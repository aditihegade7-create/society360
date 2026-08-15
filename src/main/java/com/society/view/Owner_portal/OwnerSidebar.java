package com.society.view.Owner_portal;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OwnerSidebar {

    private VBox sidebar;

    public OwnerSidebar(Stage stage) {

        sidebar = new VBox(10);

        sidebar.setPadding(
                new Insets(20)
        );

        sidebar.setPrefWidth(220);

        sidebar.setStyle(
                "-fx-background-color: #102A43;"
        );

        // =========================
        // LOGO
        // =========================

        Label logo = new Label(
                "Society360"
        );

        logo.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;"
        );

        Label portal = new Label(
                "Owner Portal"
        );

        portal.setTextFill(
                Color.LIGHTBLUE
        );

        // =========================
        // BUTTONS
        // =========================

        Button dashboard = new Button(
                "Dashboard"
        );

        Button addTenant = new Button(
                "Add Tenant"
        );

        Button removeTenant = new Button(
                "Remove Tenant"
        );

        Button payments = new Button(
                "View Payments"
        );

        Button rentalHistory = new Button(
                "Rental History"
        );

        Button profile = new Button(
                "Profile"
        );

        Button logout = new Button(
                "Logout"
        );

        // =========================
        // BUTTON WIDTH
        // =========================

        dashboard.setMaxWidth(
                Double.MAX_VALUE
        );

        addTenant.setMaxWidth(
                Double.MAX_VALUE
        );

        removeTenant.setMaxWidth(
                Double.MAX_VALUE
        );

        payments.setMaxWidth(
                Double.MAX_VALUE
        );

        rentalHistory.setMaxWidth(
                Double.MAX_VALUE
        );

        profile.setMaxWidth(
                Double.MAX_VALUE
        );

        logout.setMaxWidth(
                Double.MAX_VALUE
        );

        // =========================
        // SET ON ACTION
        // =========================

        dashboard.setOnAction(e -> {

            stage.setScene(
                    OwnerDashboard.createScene(stage)
            );
        });

        addTenant.setOnAction(e -> {

            stage.setScene(
                    AddTenant.createScene(stage)
            );
        });

        removeTenant.setOnAction(e -> {

            stage.setScene(
                    RemoveTenant.createScene(stage)
            );
        });

        payments.setOnAction(e -> {

            stage.setScene(
                    ViewPayments.createScene(stage)
            );
        });

        rentalHistory.setOnAction(e -> {

            stage.setScene(
                    RentalHistory.createScene(stage)
            );
        });

        profile.setOnAction(e -> {

            stage.setScene(
                    OwnerProfile.createScene(stage)
            );
        });

        logout.setOnAction(e -> {

            System.out.println("Logout");
        });

        // =========================
        // ADD TO SIDEBAR
        // =========================

        sidebar.getChildren().addAll(
                logo,
                portal,
                dashboard,
                addTenant,
                removeTenant,
                payments,
                rentalHistory,
                profile,
                logout
        );
    }

    public VBox getSidebar() {

        return sidebar;
    }
}