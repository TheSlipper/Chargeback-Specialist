package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.Optional;

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

    @RequestMapping(value = {"/chargebacks/", "/chargebacks/listing"})
    public String chargebacksListing(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                    chargebackProcessingSectionTitles[0], chargebackProcessingSectionTitles,
                    chargebackProcessingSectionLinks));
        model.addAttribute("chargebacks", this.chargebackService.getChargebacksFromPage(0).toList());
        model.addAttribute("pageNumber", 1);
        model.addAttribute("isNextPageEmpty", this.chargebackService.isPageEmpty(1));
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
        // TODO: If not everything is present get it with the service in here
        // TODO: Edit method
        chargeback.setChargebackProcessedDate(new Date());
        this.chargebackService.addChargeback(chargeback);

        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/chargebacks/queue");
    }
}
