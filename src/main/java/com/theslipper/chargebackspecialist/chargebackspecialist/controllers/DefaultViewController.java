package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles the incoming traffic for the websites that share a similar header-content-footer design.
 */
@Controller
public class DefaultViewController {

    @RequestMapping(value = {"/", "/home"})
    public String greeting(Model model) {
//        model.addAttribute("name", name);
        model.addAttribute("sectionName", "Home");
        return "home";
    }

}
