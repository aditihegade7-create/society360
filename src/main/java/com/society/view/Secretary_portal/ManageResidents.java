package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ManageResidents {

    private Scene Resident;

    public Scene createScene(javafx.stage.Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb = new VBox(10);

        mainvb.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label("Manage Residents");

        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label(
                "View and manage all residents"
        );

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        TextField search = new TextField();

        search.setPromptText(
                "Search resident, flat no., phone..."
        );

        search.setPrefHeight(45);
        search.setPrefWidth(750);

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        // =====================================================
        // ADD RESIDENT BUTTON
        // =====================================================

        Button addResidentBtn = new Button(
                "+ Add New Resident"
        );

        addResidentBtn.setPrefWidth(200);
        addResidentBtn.setPrefHeight(45);

        addResidentBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // SEARCH BOX
        // =====================================================

        HBox searchBox = new HBox(15);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.getChildren().addAll(
                search,
                addResidentBtn
        );

        // =====================================================
        // RESIDENT 1
        // =====================================================

        HBox resident1 = createResidentRow(
                "Shravani",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // RESIDENT 2
        // =====================================================

        HBox resident2 = createResidentRow(
                "Sudharshana",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // RESIDENT 3
        // =====================================================

        HBox resident3 = createResidentRow(
                "Jiya",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // RESIDENT 4
        // =====================================================

        HBox resident4 = createResidentRow(
                "Manasi",
                "B-402",
                "9876543210",
                "Inactive"
        );

        // =====================================================
        // RESIDENT 5
        // =====================================================

        HBox resident5 = createResidentRow(
                "Dhanashree",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // RESIDENT LIST
        // =====================================================

        VBox vb = new VBox(
                30,
                resident1,
                resident2,
                resident3,
                resident4,
                resident5
        );

        VBox.setMargin(
                resident1,
                new Insets(20, 0, 0, 0)
        );

        // =====================================================
        // ADD MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                vb
        );

        // =====================================================
        // ROOT
        // =====================================================

        HBox root = new HBox();

        root.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        root.setStyle(
                "-fx-background-color:#434141;"
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =====================================================
        // STACKPANE
        // =====================================================

        StackPane stackPane = new StackPane();

        stackPane.getChildren().add(root);

        // =====================================================
        // ADD RESIDENT SMALL POPUP
        // =====================================================

        VBox popup = new VBox(12);

        popup.setPadding(
                new Insets(25)
        );

        popup.setAlignment(
                Pos.TOP_LEFT
        );

        popup.setPrefWidth(430);
        popup.setMaxWidth(430);
        popup.setPrefHeight(400);
        popup.setMaxHeight(400);

        popup.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;" +
                "-fx-effect:dropshadow(gaussian, rgba(0,0,0,0.30), 20, 0.2, 0, 5);"
        );

        // =====================================================
        // POPUP TITLE
        // =====================================================

        Label popupTitle = new Label(
                "Add New Resident"
        );

        popupTitle.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label nameLabel = new Label(
                "Resident Name"
        );

        nameLabel.setStyle(
                "-fx-font-weight:bold;"
        );

        TextField nameField = new TextField();

        nameField.setPromptText(
                "Enter resident name"
        );

        nameField.setPrefHeight(40);

        // =====================================================
        // FLAT
        // =====================================================

        Label flatLabel = new Label(
                "Flat Number"
        );

        flatLabel.setStyle(
                "-fx-font-weight:bold;"
        );

        TextField flatField = new TextField();

        flatField.setPromptText(
                "Enter flat number"
        );

        flatField.setPrefHeight(40);

        // =====================================================
        // MOBILE
        // =====================================================

        Label mobileLabel = new Label(
                "Mobile Number"
        );

        mobileLabel.setStyle(
                "-fx-font-weight:bold;"
        );

        TextField mobileField = new TextField();

        mobileField.setPromptText(
                "Enter mobile number"
        );

        mobileField.setPrefHeight(40);

        // =====================================================
        // EMAIL
        // =====================================================

        Label emailLabel = new Label(
                "Email"
        );

        emailLabel.setStyle(
                "-fx-font-weight:bold;"
        );

        TextField emailField = new TextField();

        emailField.setPromptText(
                "Enter email"
        );

        emailField.setPrefHeight(40);

        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        Button cancelBtn = new Button(
                "Cancel"
        );

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button saveBtn = new Button(
                "Save Resident"
        );

        saveBtn.setPrefWidth(140);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox = new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.setPadding(
                new Insets(10, 0, 0, 0)
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );

        // =====================================================
        // POPUP CONTENT
        // =====================================================

        popup.getChildren().addAll(

                popupTitle,

                nameLabel,
                nameField,

                flatLabel,
                flatField,

                mobileLabel,
                mobileField,

                emailLabel,
                emailField,

                buttonBox
        );

        // =====================================================
        // DARK BACKGROUND OVERLAY
        // =====================================================

        VBox overlay = new VBox();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.35);"
        );

        // =====================================================
        // POPUP CONTAINER
        // =====================================================

        StackPane popupContainer = new StackPane();

        popupContainer.setAlignment(
                Pos.CENTER
        );

        popupContainer.getChildren().add(
                popup
        );

        // =====================================================
        // ADD POPUP TO STACKPANE
        // =====================================================

        StackPane popupLayer = new StackPane();

        popupLayer.setPickOnBounds(true);

        popupLayer.getChildren().addAll(
                overlay,
                popupContainer
        );

        // Initially popup hidden
        popupLayer.setVisible(false);

        stackPane.getChildren().add(
                popupLayer
        );

        // =====================================================
        // ADD BUTTON CLICK
        // =====================================================

        addResidentBtn.setOnAction(e -> {

            popupLayer.setVisible(true);

        });

        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        cancelBtn.setOnAction(e -> {

            popupLayer.setVisible(false);

            nameField.clear();
            flatField.clear();
            mobileField.clear();
            emailField.clear();

        });

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        saveBtn.setOnAction(e -> {

            String name =
                    nameField.getText();

            String flat =
                    flatField.getText();

            String mobile =
                    mobileField.getText();

            String email =
                    emailField.getText();

            System.out.println(
                    "Resident Name: " + name
            );

            System.out.println(
                    "Flat Number: " + flat
            );

            System.out.println(
                    "Mobile: " + mobile
            );

            System.out.println(
                    "Email: " + email
            );

            // Later Firebase / Firestore save

            popupLayer.setVisible(false);

            nameField.clear();
            flatField.clear();
            mobileField.clear();
            emailField.clear();

        });

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                stackPane,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        Resident = scene;

        return Resident;
    }

    // =========================================================
    // RESIDENT ROW METHOD
    // =========================================================

    private HBox createResidentRow(
            String residentName,
            String flatNumber,
            String mobile,
            String statusText
    ) {

        HBox residentRow = new HBox(5);

        residentRow.setPrefWidth(1000);
        residentRow.setMaxWidth(1000);
        residentRow.setPrefHeight(70);

        residentRow.setAlignment(
                Pos.CENTER_LEFT
        );

        residentRow.setPadding(
                new Insets(20)
        );

        residentRow.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        // =====================================================
        // PROFILE
        // =====================================================

        Label profile = new Label("👤");

        profile.setPrefWidth(50);
        profile.setPrefHeight(50);

        profile.setAlignment(
                Pos.CENTER
        );

        profile.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label name = new Label(
                residentName
        );

        name.setPrefWidth(200);

        name.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =====================================================
        // FLAT
        // =====================================================

        Label flat = new Label(
                "Flat: " + flatNumber
        );

        flat.setPrefWidth(150);

        flat.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        // =====================================================
        // MOBILE
        // =====================================================

        Label mobileLabel = new Label(
                "Mobile: " + mobile
        );

        mobileLabel.setPrefWidth(220);

        mobileLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label status = new Label(
                statusText
        );

        status.setPrefWidth(100);

        status.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        // =====================================================
        // ADD CHILDREN
        // =====================================================

        residentRow.getChildren().addAll(
                profile,
                name,
                flat,
                mobileLabel,
                status
        );

        return residentRow;
    }
}