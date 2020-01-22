package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChargebackProcessingViewController {

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
                    chargebackProcessingSectionTitles[0], chargebackProcessingSectionTitles, chargebackProcessingSectionLinks));
        return chargebackProcessingSectionLayoutName;
    }

    @RequestMapping(value = "/chargebacks/queue")
    public String chargebacksQueue(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Chargeback Processing",
                chargebackProcessingSectionTitles[1], chargebackProcessingSectionTitles, chargebackProcessingSectionLinks));
        return chargebackProcessingSectionLayoutName;
    }
}