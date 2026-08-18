package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecretaryDashboard {
    private Scene SecretaryDash;

    public Scene createScene(Stage stage) {

        VBox sidebar = new VBox();
        sidebar.setPrefWidth(280);
        sidebar.setPrefHeight(750);
        sidebar.setStyle("-fx-background-color:#4e4b4b");
        sidebar.setSpacing(14);
        sidebar.setPadding(new Insets(20));

        Label logo = new Label("Society360");
        logo.setLineSpacing(10);
        logo.setAlignment(Pos.CENTER_LEFT);
        logo.setStyle("-fx-text-fill:white;-fx-font-size:24px;-fx-font-weight:bold");

        Label panel = new Label("Secretary Panel");
        panel.setStyle("-fx-text-fill:lightgray;-fx-font-size:14px;-fx-padding:5px");

        // sidebar menu buttons

        Button dashboardBtn = new Button("Dashboard");
        dashboardBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");

        Button residentsBtn = new Button("Manage Residents");
        residentsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        residentsBtn.setOnAction(e -> {
            ManageResidents residents = new ManageResidents();
            stage.setScene(residents.createScene(stage));

        });

        Button ownersBtn = new Button("Manage Owners");
        ownersBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        ownersBtn.setOnAction(e -> {
            ManageOwner owners = new ManageOwner();
            stage.setScene(owners.createScene(stage));

        });

        Button guardsBtn = new Button("Manage Guards");
        guardsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        guardsBtn.setOnAction(e -> {
            ManageGuard guards = new ManageGuard();
            stage.setScene(guards.createScene(stage));

        });

        Button noticesBtn = new Button("Manage Notices");
        noticesBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        noticesBtn.setOnAction(e -> {
            ManageNotices notices = new ManageNotices();
            stage.setScene(notices.createScene(stage));

        });

        Button complaintsBtn = new Button("Manage Complaints");
        complaintsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        complaintsBtn.setOnAction(e -> {
            ManageComplaints complaints = new ManageComplaints();
            stage.setScene(complaints.createScene(stage));

        });

        Button maintenanceBtn = new Button("Manage Maintenance");
        maintenanceBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        maintenanceBtn.setOnAction(e -> {
            ManageMaintenance maintenance = new ManageMaintenance();
            stage.setScene(maintenance.createScene(stage));

        });

        Button paymentsBtn = new Button("Manage Payments");
        paymentsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        paymentsBtn.setOnAction(e -> {
            ManagePayment payment = new ManagePayment();
            stage.setScene(payment.createScene(stage));

        });

        Button sosBtn = new Button("View SOS Alerts");
        sosBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        sosBtn.setOnAction(e -> {
            ViewSos sos = new ViewSos();
            stage.setScene(sos.createScene(stage));

        });

        Button eventsBtn = new Button("Manage Events");
        eventsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        eventsBtn.setOnAction(e -> {
            ManageEvents events = new ManageEvents();
            stage.setScene(events.createScene(stage));

        });

        Button reportsBtn = new Button("Generate Reports");
        reportsBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        reportsBtn.setOnAction(e -> {
            GenerateReports report = new GenerateReports();
            stage.setScene(report.createScene(stage));

        });

        Button profileBtn = new Button("Profile");
        profileBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        profileBtn.setOnAction(e -> {
            Profile profile = new Profile();
            stage.setScene(profile.createScene(stage));

        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setStyle(
                "-fx-background-color:#434141;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        logoutBtn.setOnAction(e -> {
            Logout logout = new Logout();
            stage.setScene(logout.createScene(stage));

        });

        sidebar.getChildren().addAll(logo,
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

        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color:#b3adad;");

        Label greeting = new Label("Good Morning, Secretary 👋");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill:#434141;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label notification = new Label("🔔");
        notification.setStyle("-fx-font-size:20px;");

        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));

        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(greeting,
                spacer,
                notification,
                vb1);

        // cards

        VBox residentsCard = new VBox();

        residentsCard.setPrefWidth(200);
        residentsCard.setPrefHeight(130);
        residentsCard.setPadding(new Insets(20));

        // residents cards
        residentsCard.setStyle("-fx-background-color: white;-fx-background-radius: 10;");

        Label residentsTitle = new Label("Residents");
        residentsTitle.setStyle("-fx-font-size: 14px;-fx-text-fill: #666666;");

        Label residentsCount = new Label("248");
        residentsCount.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: #123C36;");

        Label residentText = new Label("Total Residents");
        residentText.setStyle("-fx-font-size: 13px;-fx-text-fill: #777777;");

        residentsCard.getChildren().addAll(
                residentsTitle,
                residentsCount,
                residentText);

        // owner cards

        VBox ownersCard = new VBox();
        ownersCard.setPrefWidth(200);
        ownersCard.setPrefHeight(130);
        ownersCard.setPadding(new Insets(20));
        ownersCard.setStyle("-fx-background-color: white;-fx-background-radius: 10;");

        Label ownersTitle = new Label("Owners");
        ownersTitle.setStyle("-fx-font-size: 14px;-fx-text-fill: #666666;");

        Label ownersCount = new Label("128");
        ownersCount.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: #123C36;");

        Label ownerText = new Label("Total Owners");
        ownerText.setStyle("-fx-font-size: 13px; -fx-text-fill: #777777;");

        ownersCard.getChildren().addAll(
                ownersTitle,
                ownersCount,
                ownerText);

        // guard card

        VBox guardsCard = new VBox();
        guardsCard.setPrefWidth(200);
        guardsCard.setPrefHeight(130);
        guardsCard.setPadding(new Insets(20));
        guardsCard.setStyle("-fx-background-color: white;-fx-background-radius: 10;");

        Label guardsTitle = new Label("Guards");
        guardsTitle.setStyle("-fx-font-size: 14px;-fx-text-fill: #666666;");

        Label guardsCount = new Label("12");
        guardsCount.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: #123C36;");

        Label guardText = new Label("On Duty");
        guardText.setStyle("-fx-font-size: 13px; -fx-text-fill: #777777;");

        guardsCard.getChildren().addAll(
                guardsTitle,
                guardsCount,
                guardText);

        // complaint card

        VBox complaintsCard = new VBox();
        complaintsCard.setPrefWidth(200);
        complaintsCard.setPrefHeight(130);
        complaintsCard.setPadding(new Insets(20));
        complaintsCard.setStyle("-fx-background-color: white;-fx-background-radius: 10;");

        Label complaintsTitle = new Label("Complaints");
        complaintsTitle.setStyle("-fx-font-size: 14px;-fx-text-fill: #666666;");

        Label complaintsCount = new Label("18");
        complaintsCount.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: #123C36;");

        Label complaintText = new Label("Open");
        complaintText.setStyle("-fx-font-size: 13px; -fx-text-fill: #777777;");

        complaintsCard.getChildren().addAll(
                complaintsTitle,
                complaintsCount,
                complaintText);

        // card - maintenance

        VBox maintenanceCard = new VBox();

        maintenanceCard.setPrefWidth(200);
        maintenanceCard.setPrefHeight(130);
        maintenanceCard.setPadding(new Insets(20));

        maintenanceCard.setStyle("-fx-background-color: white;-fx-background-radius: 10;");

        Label maintenanceTitle = new Label("Maintenance");
        maintenanceTitle.setStyle("-fx-font-size: 14px;-fx-text-fill: #666666;");

        Label maintenanceAmount = new Label("₹ 1.25 L");
        maintenanceAmount.setStyle("-fx-font-size: 28px;-fx-font-weight: bold;-fx-text-fill: #123C36;");

        Label maintenanceText = new Label("Collected (May)");
        maintenanceText.setStyle("-fx-font-size: 13px; -fx-text-fill: #777777;");

        maintenanceCard.getChildren().addAll(
                maintenanceTitle,
                maintenanceAmount,
                maintenanceText);

        HBox cardsRow = new HBox(50, residentsCard, ownersCard, guardsCard, complaintsCard, maintenanceCard);
        cardsRow.setStyle("-fx-background-color: #b3adad;");
        cardsRow.setSpacing(30);
        cardsRow.setPadding(new Insets(20));

        // quick Actions

        VBox quickActions = new VBox();
        quickActions.setPrefWidth(350);
        quickActions.setMinWidth(350);
        quickActions.setPrefHeight(280);
        quickActions.setSpacing(10);
        quickActions.setPadding(new Insets(20));
        quickActions.setStyle(
                "-fx-background-color:white;-fx-border-color:#E5E7EB;-fx-border-radius:10;-fx-background-radius:10");

        Label quickTitle = new Label("Quick Actions");
        quickTitle.setStyle("-fx-font-size: 17px;-fx-font-weight: bold;-fx-text-fill: #183B56;");

        Label addResident = new Label("👥   Add Resident\n  New Registration");
        addResident.setPrefWidth(260);
        addResident.setStyle("-fx-font-size: 13px;-fx-text-fill: #183B56;-fx-padding: 8px;");

        Label addNotice = new Label("▣   Add Notice\n    Create Notice");
        addNotice.setPrefWidth(260);
        addNotice.setStyle("-fx-font-size: 14px;-fx-text-fill: #183B56;-fx-padding: 12px;");

        Label viewPayments = new Label("▣   View Payments\n    Collection Status");
        viewPayments.setPrefWidth(260);
        viewPayments.setStyle("-fx-font-size: 14px;-fx-text-fill: #183B56;-fx-padding: 12px;");

        quickActions.getChildren().addAll(
                quickTitle,
                addResident,
                addNotice,
                viewPayments);

        // Todays overview

        VBox todayOverview = new VBox();
        todayOverview.setPrefWidth(350);
        todayOverview.setPrefHeight(480);
        todayOverview.setSpacing(10);
        todayOverview.setPadding(new Insets(18));
        todayOverview.setStyle(
                "-fx-background-color: white;-fx-border-color: #E5E7EB;-fx-border-radius: 10;-fx-background-radius: 10;");

        Label todayTitle = new Label("Today's Overview");
        todayTitle.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #183B56;");

        Label newResidents = new Label("New Residents                                  02");
        newResidents.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 7px;");

        Label dailyVisitors = new Label("Daily Visitors                                     35");
        dailyVisitors.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 7px;");

        Label complaintsReceived = new Label("Complaints Received                       06");
        complaintsReceived.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 7px;");

        Label maintenanceRequests = new Label("Maintenance Requests                    04");
        maintenanceRequests.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 7px;");

        Label paymentsReceived = new Label("Payments Received                    ₹18,750");
        paymentsReceived.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 7px");

        Label viewAllreports = new Label("View All Reports");
        viewAllreports.setStyle("-fx-font-size: 13px;-fx-font-weight: bold;-fx-text-fill: #4169A1;-fx-padding: 10px;");

        todayOverview.getChildren().addAll(todayTitle,
                newResidents,
                dailyVisitors,
                complaintsReceived,
                maintenanceRequests,
                paymentsReceived,
                viewAllreports

        );

        // upcoming Events
        VBox upcomingEvents = new VBox();
        upcomingEvents.setPrefWidth(350);
        upcomingEvents.setPrefHeight(480);
        upcomingEvents.setSpacing(12);
        upcomingEvents.setPadding(new Insets(18));
        upcomingEvents.setStyle(
                "-fx-background-color: white;-fx-border-color: #E5E7EB;-fx-border-radius: 10;-fx-background-radius: 10;");

        Label eventsTitle = new Label("Upcoming Events");
        eventsTitle.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #183B56;");

        Label event1 = new Label("Society Meeting\n10 May 2026");
        event1.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 8px;");

        Label event2 = new Label("Blood Donation camp\n18 May 2025\n09:00 AM");
        event2.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 8px;");

        Label viewAllEvents = new Label("View All Events");
        viewAllEvents.setStyle("-fx-font-size: 13px;-fx-font-weight: bold;-fx-text-fill: #4169A1;-fx-padding: 10px;");

        upcomingEvents.getChildren().addAll(
                eventsTitle,
                event1,
                event2,
                viewAllEvents);

        // sos Alerts

        VBox recentSOS = new VBox();
        recentSOS.setPrefWidth(280);
        recentSOS.setMinWidth(280);
        recentSOS.setPrefHeight(180);
        recentSOS.setSpacing(8);
        recentSOS.setPadding(new Insets(18));
        recentSOS.setStyle(
                "-fx-background-color: white;-fx-border-color: #E5E7EB;-fx-border-radius: 10;-fx-background-radius: 10;");

        Label sosTitle = new Label("Recent SOS Alerts");
        sosTitle.setStyle("-fx-font-size: 17px;-fx-font-weight: bold;-fx-text-fill: #D9534F;");

        Label viewAll = new Label("View All");
        viewAll.setStyle("-fx-font-size: 13px;-fx-text-fill: #4169A1;");

        HBox sosHeader = new HBox(10);
        sosHeader.setSpacing(120);
        sosHeader.getChildren().addAll(
                sosTitle,
                viewAll);

        Label sosAlert = new Label(
                "🔴   Block B, 402 (Medical)            2 min ago");
        sosAlert.setStyle("-fx-font-size: 13px;-fx-text-fill: #555555;-fx-padding: 8px;");

        recentSOS.getChildren().addAll(
                sosHeader,
                sosAlert);

        VBox leftColumn = new VBox(20);
        leftColumn.getChildren().addAll(quickActions, recentSOS);
        HBox hb1 = new HBox(50, leftColumn, todayOverview, upcomingEvents);
        hb1.setStyle("-fx-background-color: #b3adad;");

        // main content Area
        VBox mainContent = new VBox();
        mainContent.setPrefWidth(920);
        mainContent.setPrefHeight(700);
        mainContent.setMaxWidth(Double.MAX_VALUE);
        mainContent.setStyle("-fx-background-color:#b3adad;");
        mainContent.getChildren().addAll(header,
                cardsRow,
                hb1);

        // add sidebar and main content to body
        // body Dashboard

        VBox.setVgrow(mainContent, Priority.ALWAYS);
        HBox.setHgrow(mainContent, Priority.ALWAYS);

        HBox body = new HBox(20);
        body.getChildren().addAll(sidebar, mainContent);

        // main layout
        VBox mainvb = new VBox();
        mainvb.setStyle("-fx-background-color:#b3adad;");
        mainvb.getChildren().add(body);
        VBox.setVgrow(body, Priority.ALWAYS);

        // Scene scene = new Scene(mainvb, 1500, 750);
        Scene scene = new Scene(
                mainvb,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        
        SecretaryDash = scene;

        return SecretaryDash;
    }

}
