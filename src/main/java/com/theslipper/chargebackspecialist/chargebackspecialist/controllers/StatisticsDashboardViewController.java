package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsDashboardViewController {

    private final String statisticsDashboardSectionLayoutName = "standard_layout";
    private final String[] statisticsSectionTitles = {
            "Overview",
            "User Performance Inspection"
    };
    private final String[] statisticsSectionLinks = {
            "/statistics/overview",
            "/statistics/uperformance"
    };

    @RequestMapping(value = {"/statistics/", "/statistics/overview"})
    public String statisticsDashboardOverview(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Statistics Dashboard", "Overview",
                statisticsSectionTitles, statisticsSectionLinks));
        return statisticsDashboardSectionLayoutName;
    }

    @RequestMapping(value = "/statistics/uperformance")
    public String statisticsUserPerformance(Model model) {
        model.addAttribute("metadata", new WebsiteMetadata("Statistics Dashboard", "User Performance",
                statisticsSectionTitles, statisticsSectionLinks));
        return statisticsDashboardSectionLayoutName;
    }
}
