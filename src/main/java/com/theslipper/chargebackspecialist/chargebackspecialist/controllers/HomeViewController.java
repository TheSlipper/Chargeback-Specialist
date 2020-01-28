package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.HelpEntryService;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles the incoming traffic for the home subsection of the website.
 */
@Controller
public class HomeViewController {

    private final String homeViewSectionLayoutName = "standard_layout";
    private final String[] homeSectionTitles = {"Home", "Updates", "Help"};
    private final String[] homeSectionLinks = {"/home/home", "/home/updates", "/home/help"};
    private final HelpEntryService helpEntryService;

    @Autowired
    public HomeViewController(HelpEntryService helpEntryService) {
        this.helpEntryService = helpEntryService;
    }

    @RequestMapping(value = {"/", "/home", "/home/home", "/home/Home"})
    public String homeHome(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Home", "Home",
                homeSectionTitles, homeSectionLinks));
        return homeViewSectionLayoutName;
    }

    @RequestMapping(value = {"/home/updates", "/home/Updates"})
    public String homeUpdates(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Home", "Updates",
                homeSectionTitles, homeSectionLinks));
        return homeViewSectionLayoutName;
    }

    @RequestMapping(value = {"/home/help", "/home/Help"})
    public String homeHelp(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Home", "Help",
                homeSectionTitles, homeSectionLinks));
        model.addAttribute("helpEntries", helpEntryService.getAllHelpEntries());
        return homeViewSectionLayoutName;
    }

}
