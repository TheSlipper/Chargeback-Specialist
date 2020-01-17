package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

// TODO: Javadoc
public class WebsiteMetadata {
    private String sectionName;
    private String subsectionName;
    private String[] sidebarTitles;
    private String[] sidebarLinks;

    public WebsiteMetadata(String sectionName, String subsectionName, String[] sidebarTitles, String[] sidebarLinks) {
        this.sectionName = sectionName;
        this.subsectionName = subsectionName;
        this.sidebarTitles = sidebarTitles;
        this.sidebarLinks = sidebarLinks;
    }

    public String[] getSidebarLinks() {
        return sidebarLinks;
    }

    public void setSidebarLinks(String[] sidebarLinks) {
        this.sidebarLinks = sidebarLinks;
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

    public String[] getSidebarTitles() {
        return sidebarTitles;
    }

    public void setSidebarTitles(String[] sidebarTitles) {
        this.sidebarTitles = sidebarTitles;
    }
}
