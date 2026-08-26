package com.society.view.Secretary_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecretarySidebar {

        public VBox createSidebar(Stage stage) {

                // SIDEBAR
        
                VBox sidebar = new VBox();

                sidebar.setPrefWidth(280);
                sidebar.setPrefHeight(750);
                sidebar.setStyle("-fx-background-color: #4e4b4b");
                sidebar.setSpacing(14);
                sidebar.setPadding(new Insets(20));

                // LOGO

                Label logo = new Label("Society360");

                logo.setLineSpacing(10);
                logo.setAlignment(Pos.CENTER_LEFT);

                logo.setStyle(
                                "-fx-text-fill:white;" +
                                                "-fx-font-size:24px;" +
                                                "-fx-font-weight:bold;");

                // =====================================================
                // PANEL NAME
                // =====================================================

                Label panel = new Label("Secretary Panel");

                panel.setStyle(
                                "-fx-text-fill:lightgray;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-padding:5px;");

                // =====================================================
                // DASHBOARD
                // =====================================================

                Button dashboardBtn = new Button("Dashboard");

                dashboardBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                dashboardBtn.setOnAction(e -> {

                        SecretaryDashboard dashboard = new SecretaryDashboard();

                        stage.setScene(
                                        dashboard.createScene(stage));
                });

                // =====================================================
                // MANAGE RESIDENTS
                // =====================================================

                Button residentsBtn = new Button("Manage Residents");

                residentsBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                residentsBtn.setOnAction(e -> {

                        ManageResidents residents = new ManageResidents();

                        stage.setScene(
                                        residents.createScene(stage));
                });

                // =====================================================
                // MANAGE OWNERS
                // =====================================================

                Button ownersBtn = new Button("Manage Owners");

                ownersBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                ownersBtn.setOnAction(e -> {

                        ManageOwner owners = new ManageOwner();

                        stage.setScene(
                                        owners.createScene(stage));
                });

                // =====================================================
                // MANAGE GUARDS
                // =====================================================

                Button guardsBtn = new Button("Manage Guards");

                guardsBtn.setStyle(
                                "-fx-background-color: #434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                guardsBtn.setOnAction(e -> {

                        ManageGuard guards = new ManageGuard();

                        stage.setScene(
                                        guards.createScene(stage));
                });

                // =====================================================
                // MANAGE NOTICES
                // =====================================================

                Button noticesBtn = new Button("Manage Notices");

                noticesBtn.setStyle(
                                "-fx-background-color: #434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                noticesBtn.setOnAction(e -> {

                        ManageNotices notices = new ManageNotices();

                        stage.setScene(
                                        notices.createScene(stage));
                });

                // =====================================================
                // MANAGE COMPLAINTS
                // =====================================================

                Button complaintsBtn = new Button("Manage Complaints");

                complaintsBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                complaintsBtn.setOnAction(e -> {

                        ManageComplaints complaints = new ManageComplaints();

                        stage.setScene(
                                        complaints.createScene(stage));
                });

                // =====================================================
                // MANAGE MAINTENANCE
                // =====================================================

                Button maintenanceBtn = new Button("Manage Maintenance");

                maintenanceBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                maintenanceBtn.setOnAction(e -> {

                        ManageMaintenance maintenance = new ManageMaintenance();

                        stage.setScene(
                                        maintenance.createScene(stage));
                });

                // =====================================================
                // MANAGE PAYMENTS
                // =====================================================

                Button paymentsBtn = new Button("Manage Payments");

                paymentsBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                paymentsBtn.setOnAction(e -> {

                        ManagePayment payment = new ManagePayment();

                        stage.setScene(
                                        payment.createScene(stage));
                });

                // =====================================================
                // SOS ALERTS
                // =====================================================

                Button sosBtn = new Button("View SOS Alerts");

                sosBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                sosBtn.setOnAction(e -> {

                        ViewSos sos = new ViewSos();

                        stage.setScene(
                                        sos.createScene(stage));
                });

                // =====================================================
                // MANAGE EVENTS
                // =====================================================

                Button eventsBtn = new Button("Manage Events");

                eventsBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                eventsBtn.setOnAction(e -> {

                        ManageEvents events = new ManageEvents();

                        stage.setScene(
                                        events.createScene(stage));
                });

                // =====================================================
                // GENERATE REPORTS
                // =====================================================

                Button reportsBtn = new Button("Generate Reports");

                reportsBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                reportsBtn.setOnAction(e -> {

                        GenerateReports report = new GenerateReports();

                        stage.setScene(
                                        report.createScene(stage));
                });

                // =====================================================
                // PROFILE
                // =====================================================

                Button profileBtn = new Button("Profile");

                profileBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                profileBtn.setOnAction(e -> {

                        Profile profile = new Profile();

                        stage.setScene(
                                        profile.createScene(stage));
                });

                // =====================================================
                // LOGOUT
                // =====================================================

                Button logoutBtn = new Button("Logout");

                logoutBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-alignment:CENTER-LEFT;" +
                                                "-fx-pref-width:240px;" +
                                                "-fx-pref-height:40px;");

                logoutBtn.setOnAction(e -> {

                        Logout logout = new Logout();

                        stage.setScene(
                                        logout.createScene(stage));
                });

                // =====================================================
                // ADD ALL COMPONENTS TO SIDEBAR
                // =====================================================

                sidebar.getChildren().addAll(

                                logo,
                                panel,

                                dashboardBtn,
                                residentsBtn,
                                ownersBtn,
                                guardsBtn,
                                noticesBtn,
                                complaintsBtn,
                                maintenanceBtn,
                                paymentsBtn,
                                sosBtn,
                                eventsBtn,
                                reportsBtn,
                                profileBtn,
                                logoutBtn);

                return sidebar;
        }
}