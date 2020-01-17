package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Javadoc
/**
 * Handles the incoming traffic for the home subsection of the website.
 */
@Controller
public class HomeViewController {

    private final String homeViewSectionLayoutName = "standard_layout";
    private final String[] homeSectionTitles = {"Home", "Updates", "Help"};
    private final String[] homeSectionLinks = {"/home/home", "/home/updates", "/home/help"};

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
        return homeViewSectionLayoutName;
    }

}
