package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
public class ChargebackProcessingViewController {

    private final ChargebackService chargebackService;

    @Autowired
    public ChargebackProcessingViewController(ChargebackService chargebackService) {
        this.chargebackService = chargebackService;
    }

    private final String chargebackProcessingSectionLayoutName = "standard_layout";
    private final String[] chargebackProcessingSectionTitles = {
            "Listing",
            "Processing Queue"
    };
    private final String[] chargebackProcessingSectionLinks = {
            "/chargebacks/listing",
            "/chargebacks/queue"
    };

    @GetMapping(value = {"/chargebacks/", "/chargebacks/listing"})
    public String chargebacksListing(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                    chargebackProcessingSectionTitles[0], chargebackProcessingSectionTitles,
                    chargebackProcessingSectionLinks));
        model.addAttribute("chargebacks", this.chargebackService.getChargebacksFromPage(0).toList());
        model.addAttribute("pageNumber", 1);
        model.addAttribute("isNextPageEmpty", this.chargebackService.isPageEmpty(1));
        EnumSet<Chargeback.ChargebackCode> set = EnumSet.allOf(Chargeback.ChargebackCode.class);
        model.addAttribute("chargebackCodes", set);
        return chargebackProcessingSectionLayoutName;
    }

    @GetMapping(path = "/chargebacks/listing/{id}")
    public String chargebackListingByPageNo(Model model, @PathVariable("id") int pageNo) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                chargebackProcessingSectionTitles[0], chargebackProcessingSectionTitles,
                chargebackProcessingSectionLinks));
        model.addAttribute("chargebacks", this.chargebackService.getChargebacksFromPage(pageNo-1).toList());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("isNextPageEmpty", this.chargebackService.isPageEmpty(pageNo));

        EnumSet<Chargeback.ChargebackCode> set = EnumSet.allOf(Chargeback.ChargebackCode.class);
        model.addAttribute("chargebackCodes", set);
        return chargebackProcessingSectionLayoutName;
    }

    @PostMapping(value = "/chargebacks/listing/{p}")
    public String chargebackListingFiltered(Model model,
                                            @PathVariable("p") int pageNo,
                                            @RequestParam(name = "process-id", required = false) UUID processID,
                                            @RequestParam(name = "entry-id", required = false) UUID entryID,
                                            @RequestParam(name = "chargeback-code", required = false) String code,
                                            @RequestParam(name = "date-of-opening", required = false)
                                                @DateTimeFormat(pattern = "mm-dd-yyyy") Date dateOfOpening,
                                            @RequestParam(name = "date-of-processing", required = false)
                                                @DateTimeFormat(pattern = "mm-dd-yyyy") Date dateOfProcessing) {
        if (processID != null) {
            model.addAttribute("chargebacks", this.chargebackService.getAllChargebacksByProcessID(processID, pageNo));
        } else if (entryID != null) {
            ArrayList<Chargeback> chargebacks = new ArrayList<>();
            chargebacks.add(this.chargebackService.getChargebackByID(entryID).orElse(new Chargeback()));
            model.addAttribute("chargebacks", chargebacks);
        } else if (code != null) {
            model.addAttribute("chargebacks", this.chargebackService.
                    getAllChargebacksByChargebackCode(Chargeback.ChargebackCode.valueOf(code), pageNo - 1));
        }
        else if (dateOfOpening != null)
            model.addAttribute("chargebacks", this.chargebackService.
                    getAllChargebacksByOpeningDate(dateOfOpening, pageNo-1));
        else if (dateOfProcessing != null)
            model.addAttribute("chargebacks", this.chargebackService.
                    getAllChargebacksByProcessingDate(dateOfProcessing, pageNo-1));

        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                chargebackProcessingSectionTitles[0], chargebackProcessingSectionTitles,
                chargebackProcessingSectionLinks));
        model.addAttribute("pageNumber", 1);
        model.addAttribute("isNextPageEmpty", this.chargebackService.isPageEmpty(1));
        EnumSet<Chargeback.ChargebackCode> set = EnumSet.allOf(Chargeback.ChargebackCode.class);
        model.addAttribute("chargebackCodes", set);
        return chargebackProcessingSectionLayoutName;
    }

    @GetMapping(value = "/chargebacks/queue")
    public String chargebacksQueue(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                chargebackProcessingSectionTitles[1], chargebackProcessingSectionTitles,
                chargebackProcessingSectionLinks));

        // TODO: Implement a session mechanism and delete this later
        SystemUserRole systemUserRole = new SystemUserRole();
        systemUserRole.setPermissions(new SystemUserRole.SystemPermission[]{
                    SystemUserRole.SystemPermission.PROCESS_MASTERCARD_CHARGEBACK,
                    SystemUserRole.SystemPermission.PROCESS_VISA_CHARGEBACK
        });
        SystemUser systemUser = new SystemUser();
        systemUser.setSystemUserRole(systemUserRole);

        Optional<Chargeback> chargebackOptional = this.chargebackService.getChargebackEntryForQueue(systemUser);
        if (chargebackOptional.isPresent()) {
            Chargeback chargeback = chargebackOptional.get();
            chargeback.setChargebackOpenedDate(new Date()); // TODO: Edit method in service
            this.chargebackService.addChargeback(chargeback);
            model.addAttribute("chargebackData", chargeback);
        } else {
            model.addAttribute("chargebackData", new Chargeback());
        }

        return chargebackProcessingSectionLayoutName;
    }

    @PostMapping(value = "/chargebacks/process")
    public RedirectView chargebacksPostQueue(RedirectAttributes attributes, @ModelAttribute Chargeback chargeback) {
        this.chargebackService.rmChargebackByID(chargeback.getChargebackEntryID());
        chargeback.setChargebackProcessedDate(new Date());
        this.chargebackService.addChargeback(chargeback);

        return new RedirectView("/chargebacks/queue");
    }
}
