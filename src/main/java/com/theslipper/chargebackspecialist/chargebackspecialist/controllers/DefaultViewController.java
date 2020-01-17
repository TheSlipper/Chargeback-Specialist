package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles the incoming traffic for the websites that share a similar header-content-footer design.
 */
@Controller
public class DefaultViewController {

    private final String standardLayoutModelName = "standard_layout";
    private final String[] homeSubWebsites = {"Home", "Updates", "Help"};

    @RequestMapping(value = {"/", "/Home", "/Home/Home"})
    public String homeHome(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Home", "Home", homeSubWebsites));
        return standardLayoutModelName;
    }

    @RequestMapping(value = "/Home/Updates")
    public String homeUpdates(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Home", "Updates", homeSubWebsites));
        return standardLayoutModelName;
    }

}
