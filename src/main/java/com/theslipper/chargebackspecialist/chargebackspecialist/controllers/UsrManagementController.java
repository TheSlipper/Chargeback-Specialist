package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrManagementController {

    private final String usrManagementViewSectionLayoutName = "standard_layout";
    private final String[] usrManagementProfileSectionTitles = {"Listing"};
    private final String[] usrManagementProfileSectionLinks = {"/usrmanagement/listing"};

    @RequestMapping(value = "/usrmanagement/listing")
    public String listing(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                usrManagementProfileSectionTitles[0], usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        return usrManagementViewSectionLayoutName;
    }

}
