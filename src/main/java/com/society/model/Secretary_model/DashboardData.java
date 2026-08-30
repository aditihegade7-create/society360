package com.society.model.Secretary_model;

/**
 * DashboardData
 *
 * This model stores all summary data required
 * by the Secretary Dashboard.
 */
public class DashboardData {

    // ============================================================
    // FIELDS
    // ============================================================

    private int totalResidents;
    private int totalOwners;
    private int totalGuards;
    private int openComplaints;
    private double maintenanceCollection;

    // ============================================================
    // DEFAULT CONSTRUCTOR
    // ============================================================

    public DashboardData() {
    }

    // ============================================================
    // PARAMETERIZED CONSTRUCTOR
    // ============================================================

    public DashboardData(
            int totalResidents,
            int totalOwners,
            int totalGuards,
            int openComplaints,
            double maintenanceCollection) {

        this.totalResidents = totalResidents;
        this.totalOwners = totalOwners;
        this.totalGuards = totalGuards;
        this.openComplaints = openComplaints;
        this.maintenanceCollection = maintenanceCollection;
    }

    // ============================================================
    // GET TOTAL RESIDENTS
    // ============================================================

    public int getTotalResidents() {

        return totalResidents;
    }

    // ============================================================
    // SET TOTAL RESIDENTS
    // ============================================================

    public void setTotalResidents(int totalResidents) {

        this.totalResidents = totalResidents;
    }

    // ============================================================
    // GET TOTAL OWNERS
    // ============================================================

    public int getTotalOwners() {

        return totalOwners;
    }

    // ============================================================
    // SET TOTAL OWNERS
    // ============================================================

    public void setTotalOwners(int totalOwners) {

        this.totalOwners = totalOwners;
    }

    // ============================================================
    // GET TOTAL GUARDS
    // ============================================================

    public int getTotalGuards() {

        return totalGuards;
    }

    // ============================================================
    // SET TOTAL GUARDS
    // ============================================================

    public void setTotalGuards(int totalGuards) {

        this.totalGuards = totalGuards;
    }

    // ============================================================
    // GET OPEN COMPLAINTS
    // ============================================================

    public int getOpenComplaints() {

        return openComplaints;
    }

    // ============================================================
    // SET OPEN COMPLAINTS
    // ============================================================

    public void setOpenComplaints(int openComplaints) {

        this.openComplaints = openComplaints;
    }

    // ============================================================
    // GET MAINTENANCE COLLECTION
    // ============================================================

    public double getMaintenanceCollection() {

        return maintenanceCollection;
    }

    // ============================================================
    // SET MAINTENANCE COLLECTION
    // ============================================================

    public void setMaintenanceCollection(
            double maintenanceCollection) {

        this.maintenanceCollection = maintenanceCollection;
    }
}