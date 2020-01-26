package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.Chargeback;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.ChargebackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping(value = "/chargebacks/queue")
    public String chargebacksQueue(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                chargebackProcessingSectionTitles[1], chargebackProcessingSectionTitles, chargebackProcessingSectionLinks));
        return chargebackProcessingSectionLayoutName;
    }
}
