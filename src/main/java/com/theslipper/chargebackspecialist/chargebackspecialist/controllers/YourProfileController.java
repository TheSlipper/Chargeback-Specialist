package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.repositories.VendorTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles the incoming traffic for the your profile section of the website.
 */
@Controller
public class YourProfileController {

    @Autowired
    private VendorTypeRepository vendorTypeRepository;
    private final String yourProfileViewSectionLayoutName = "standard_layout";
    private final String[] yourProfileSectionTitles = {"My Profile"};
    private final String[] yourProfileSectionLinks = {"/profile/myprofile"};

    @RequestMapping(value = "/profile/myprofile")
    public String myProfile(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Your Profile",
                yourProfileSectionTitles[0], yourProfileSectionTitles, yourProfileSectionLinks));
        return yourProfileViewSectionLayoutName;
    }
}
