package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardSidebar {

    private Stage stage;
    private VBox sidebar;

    public GuardSidebar(Stage stage, String activePage) {
        this.stage = stage;
        createSidebar(activePage);
    }

    private void createSidebar(String activePage) {

        sidebar = new VBox();
        sidebar.setPrefWidth(280);
        sidebar.setPrefHeight(750);
        sidebar.setPadding(new Insets(20));
        sidebar.setSpacing(14);
        sidebar.setAlignment(Pos.TOP_LEFT);
        sidebar.setStyle(
                "-fx-background-color: #0B4F4A;"
        );


        Label logo = new Label("Society360");
        logo.setLineSpacing(10);
        logo.setAlignment(Pos.CENTER_LEFT);
        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label guardPanel = new Label("Guard Panel");
        guardPanel.setStyle(
                "-fx-text-fill: lightgray;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 5px;"
        );

        Button dashboardButton = createButton("Dashboard");
        Button visitorButton = createButton("Visitor Log");
        Button qrButton = createButton("QR Scanner");
        Button parkingButton = createButton("Parking");
        Button manualButton = createButton("Manual Entry");
        Button sosButton = createButton("Emergency SOS");
        Button reportsButton = createButton("Daily Reports");
        Button profileButton = createButton("Profile");
        Button logoutButton = createButton("Logout");

        setActiveButton(
                activePage,
                dashboardButton,
                visitorButton,
                qrButton,
                parkingButton,
                manualButton,
                sosButton,
                reportsButton,
                profileButton,
                logoutButton
        );

        dashboardButton.setOnAction(e ->
                stage.setScene(
                        GuardDashboard.createScene(stage)
                )
        );

        visitorButton.setOnAction(e ->
                stage.setScene(
                        VisitorLog.createScene(stage)
                )
        );

        qrButton.setOnAction(e ->
                stage.setScene(
                        QRScanner.createScene(stage)
                )
        );

        parkingButton.setOnAction(e ->
                stage.setScene(
                        Parking.createScene(stage)
                )
        );

        manualButton.setOnAction(e ->
                stage.setScene(
                        ManualVisitorEntry.createScene(stage)
                )
        );

        sosButton.setOnAction(e ->
                stage.setScene(
                        EmergencySOS.createScene(stage)
                )
        );

        reportsButton.setOnAction(e ->
                stage.setScene(
                        DailyReports.createScene(stage)
                )
        );

        profileButton.setOnAction(e ->
                stage.setScene(
                        GuardProfile.createScene(stage)
                )
        );

        logoutButton.setOnAction(e -> {

            System.out.println("Logout clicked");

            // Authentication screen will be connected here later.
        });

        sidebar.getChildren().addAll(
                logo,
                guardPanel,
                dashboardButton,
                visitorButton,
                qrButton,
                parkingButton,
                manualButton,
                sosButton,
                reportsButton,
                profileButton,
                logoutButton
        );
    }

    private Button createButton(String text) {

        Button button = new Button(text);

        button.setPrefWidth(240);
        button.setPrefHeight(40);

        button.setStyle(
                "-fx-background-color: #0B4F4A;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER_LEFT;");
        return button;
    }

    private void setActiveButton(
            String activePage,
            Button dashboard,
            Button visitor,
            Button qr,
            Button parking,
            Button manual,
            Button sos,
            Button reports,
            Button profile,
            Button logout) {

        Button activeButton = null;

        switch (activePage) {

            case "Dashboard":
                activeButton = dashboard;
                break;

            case "Visitor Log":
                activeButton = visitor;
                break;

            case "QR Scanner":
                activeButton = qr;
                break;

            case "Parking":
                activeButton = parking;
                break;

            case "Manual Entry":
                activeButton = manual;
                break;

            case "Emergency SOS":
                activeButton = sos;
                break;

            case "Daily Reports":
                activeButton = reports;
                break;

            case "Profile":
                activeButton = profile;
                break;

            case "Logout":
                activeButton = logout;
                break;
        }


        if (activeButton != null) {

            activeButton.setStyle(
                    "-fx-background-color: #073936;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 14px;" +
                    "-fx-alignment: CENTER_LEFT;" +
                    "-fx-background-radius: 6;"
            );
        }
    }

    public VBox getSidebar() {
        return sidebar;
    }
}