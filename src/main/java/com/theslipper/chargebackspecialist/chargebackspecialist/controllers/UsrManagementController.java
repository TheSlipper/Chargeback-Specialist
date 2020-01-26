package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
@RequestMapping(value = "/usrmanagement")
public class UsrManagementController {

    @Autowired
    private SystemUserService systemUserService;

    private final String usrManagementViewSectionLayoutName = "standard_layout";
    private final String[] usrManagementProfileSectionTitles = {"Listing"};
    private final String[] usrManagementProfileSectionLinks = {"/usrmanagement/listing"};

    @GetMapping(value = "/listing")
    public String listing(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                usrManagementProfileSectionTitles[0], usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        Page<SystemUser> page = this.systemUserService.getSystemUsersFromPage(0);
        model.addAttribute("systemUsers", page.toList());
        model.addAttribute("pageNumber", 1);
        model.addAttribute("isNextPageEmpty", this.systemUserService.isPageEmpty(1));
        return usrManagementViewSectionLayoutName;
    }

    @GetMapping(path = "/listing/{id}")
    public String listingByPageNo(Model model, @PathVariable("id") int pageNo) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                usrManagementProfileSectionTitles[0], usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        Page<SystemUser> page = this.systemUserService.getSystemUsersFromPage(pageNo-1);
        model.addAttribute("systemUsers", page.toList());
        model.addAttribute("pageNumber", pageNo);
        model.addAttribute("isNextPageEmpty", this.systemUserService.isPageEmpty(pageNo));
        return usrManagementViewSectionLayoutName;
    }

    @GetMapping(path = "/editform/{id}")
    public String userEditForm(Model model, @PathVariable("id") UUID userID) {
        model.addAttribute("metadata", new WebsiteMetadata("User Management",
                "Edit User", usrManagementProfileSectionTitles, usrManagementProfileSectionLinks));
        model.addAttribute("userData", this.systemUserService.getSystemUserByID(userID).orElse(new SystemUser()));
        model.addAttribute("systemRoles", this.systemUserService.getAllSystemUserRoles());
        return usrManagementViewSectionLayoutName;
    }

    @RequestMapping(path = "/delete/{id}")
    public RedirectView userDeleteForm(RedirectAttributes attributes, @PathVariable("id") UUID userID) {
        systemUserService.rmSystemUserByID(userID);
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/usrmanagement/listing");
    }

    @PostMapping(value = "/edit")
    public RedirectView userEdit(RedirectAttributes attributes, @ModelAttribute SystemUser systemUser
                                 /*,@RequestParam("systemUserRole") UUID roleUUID*/) {
        SystemUser original = this.systemUserService.getSystemUserByID(systemUser.getSystemUserID())
                .orElse(new SystemUser());
        systemUser.setSystemUserLogin(original.getSystemUserLogin());
        systemUser.setSystemUserPassword(original.getSystemUserPassword());
//        systemUser.setSystemUserRole(original.getSystemUserRole()); // TODO: Get role from form

        this.systemUserService.editSystemUser(systemUser);
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/usrmanagement/listing");
    }
}
