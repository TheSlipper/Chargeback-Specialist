package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/usrmanagement/listing")
public class UsrManagementController {

    @Autowired
    private SystemUserService systemUserService;

    private final String usrManagementViewSectionLayoutName = "standard_layout";
    private final String[] usrManagementProfileSectionTitles = {"Listing"};
    private final String[] usrManagementProfileSectionLinks = {"/usrmanagement/listing"};

    @GetMapping
    public String listing(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                usrManagementProfileSectionTitles[0], usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        Page<SystemUser> page = this.systemUserService.getSystemUsersFromPage(0);
        model.addAttribute("systemUsers", page.toList());
        model.addAttribute("pageNumber", 1);
        return usrManagementViewSectionLayoutName;
    }

    @GetMapping(path = "{id}")
    public String listingByPageNo(Model model, @PathVariable("id") int pageNo) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                usrManagementProfileSectionTitles[0], usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        Page<SystemUser> page = this.systemUserService.getSystemUsersFromPage(pageNo-1);
        model.addAttribute("systemUsers", page.toList());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("isNextPageEmpty", this.systemUserService.isPageEmpty(pageNo+1));
        return usrManagementViewSectionLayoutName;
    }

}
