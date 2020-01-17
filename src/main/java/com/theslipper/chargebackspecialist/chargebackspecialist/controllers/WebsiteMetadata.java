package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

public class WebsiteMetadata {
    private String sectionName;
    private String subsectionName;
    private String[] sidebarStrings;

    public WebsiteMetadata(String sectionName, String subsectionName, String[] sidebarStrings) {
        this.sectionName = sectionName;
        this.subsectionName = subsectionName;
        this.sidebarStrings = sidebarStrings;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSubsectionName() {
        return subsectionName;
    }

    public void setSubsectionName(String subsectionName) {
        this.subsectionName = subsectionName;
    }

    public String[] getSidebarStrings() {
        return sidebarStrings;
    }

    public void setSidebarStrings(String[] sidebarStrings) {
        this.sidebarStrings = sidebarStrings;
    }
}
