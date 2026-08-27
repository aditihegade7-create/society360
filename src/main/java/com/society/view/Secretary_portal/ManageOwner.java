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
import javafx.stage.Stage;

public class ManageOwner {

    private Scene Owners;

    public Scene createScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb = new VBox(10);

        mainvb.setPrefWidth(1220);
        mainvb.setPrefHeight(750);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label("Manage Owners");

        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label(
                "View and manage all flat owners"
        );

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // SEARCH FIELD
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
        // ADD OWNER BUTTON
        // =====================================================

        Button addOwnerBtn = new Button(
                "+ Add New Owner"
        );

        addOwnerBtn.setPrefWidth(200);
        addOwnerBtn.setPrefHeight(45);

        addOwnerBtn.setStyle(
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
                addOwnerBtn
        );

        // =====================================================
        // OWNER 1
        // =====================================================

        HBox resident1 = createOwnerRow(
                "vijay",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // OWNER 2
        // =====================================================

        HBox resident2 = createOwnerRow(
                "Sachin",
                "B-402",
                "9876543210",
                "Active"
        );

        // =====================================================
        // OWNER 3
        // =====================================================

        HBox resident3 = createOwnerRow(
                "Pramod",
                "B-402",
                "9876543210",
                "Samarth"
        );

        // =====================================================
        // OWNER 4
        // =====================================================

        HBox resident4 = createOwnerRow(
                "Ram",
                "B-402",
                "9876543210",
                "Inactive"
        );

        // =====================================================
        // OWNER LIST
        // =====================================================

        VBox vb = new VBox(
                20,
                resident1,
                resident2,
                resident3,
                resident4
        );

        vb.setPadding(
                new Insets(20, 0, 0, 0)
        );

        // =====================================================
        // ADD CONTENT TO MAIN
        // =====================================================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                vb
        );

        // =====================================================
        // ROOT HBOX
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
        // Used for popup overlay
        // =====================================================

        StackPane rootPane = new StackPane();

        rootPane.getChildren().add(
                root
        );

        // =====================================================
        // ADD OWNER BUTTON CLICK
        // =====================================================

        addOwnerBtn.setOnAction(e -> {

            // =================================================
            // POPUP
            // =================================================

            VBox popup = new VBox(12);

            popup.setPadding(
                    new Insets(25)
            );

            popup.setAlignment(
                    Pos.TOP_LEFT
            );

            popup.setPrefWidth(450);
            popup.setPrefHeight(480);

            popup.setMaxWidth(450);
            popup.setMaxHeight(480);

            popup.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:15;" +
                    "-fx-border-color:#D9D9D9;" +
                    "-fx-border-radius:15;"
            );

            // =================================================
            // POPUP TITLE
            // =================================================

            Label popupTitle = new Label(
                    "Add New Owner"
            );

            popupTitle.setStyle(
                    "-fx-font-size:24px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // =================================================
            // OWNER NAME
            // =================================================

            Label nameLabel = new Label(
                    "Owner Name"
            );

            nameLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField nameField = new TextField();

            nameField.setPromptText(
                    "Enter owner name"
            );

            nameField.setPrefHeight(40);

            // =================================================
            // FLAT NUMBER
            // =================================================

            Label flatLabel = new Label(
                    "Flat Number"
            );

            flatLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField flatField = new TextField();

            flatField.setPromptText(
                    "Enter flat number"
            );

            flatField.setPrefHeight(40);

            // =================================================
            // MOBILE NUMBER
            // =================================================

            Label mobileLabel = new Label(
                    "Mobile Number"
            );

            mobileLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField mobileField = new TextField();

            mobileField.setPromptText(
                    "Enter mobile number"
            );

            mobileField.setPrefHeight(40);

            // =================================================
            // EMAIL
            // =================================================

            Label emailLabel = new Label(
                    "Email"
            );

            emailLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField emailField = new TextField();

            emailField.setPromptText(
                    "Enter email"
            );

            emailField.setPrefHeight(40);

            // =================================================
            // CANCEL BUTTON
            // =================================================

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

            // =================================================
            // SAVE BUTTON
            // =================================================

            Button saveBtn = new Button(
                    "Save Owner"
            );

            saveBtn.setPrefWidth(130);
            saveBtn.setPrefHeight(40);

            saveBtn.setStyle(
                    "-fx-background-color:#2E9D63;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            // =================================================
            // BUTTON BOX
            // =================================================

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

            // =================================================
            // ADD CONTROLS TO POPUP
            // =================================================

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

            // =================================================
            // DARK OVERLAY
            // =================================================

            StackPane overlay = new StackPane();

            overlay.setAlignment(
                    Pos.CENTER
            );

            overlay.setStyle(
                    "-fx-background-color:rgba(0,0,0,0.35);"
            );

            overlay.getChildren().add(
                    popup
            );

            // =================================================
            // SHOW POPUP
            // =================================================

            rootPane.getChildren().add(
                    overlay
            );

            // =================================================
            // CANCEL BUTTON
            // =================================================

            cancelBtn.setOnAction(event -> {

                rootPane.getChildren().remove(
                        overlay
                );

            });

            // =================================================
            // SAVE BUTTON
            // =================================================

            saveBtn.setOnAction(event -> {

                String ownerName =
                        nameField.getText();

                String flatNumber =
                        flatField.getText();

                String mobile =
                        mobileField.getText();

                String email =
                        emailField.getText();

                System.out.println(
                        "Owner Name: " + ownerName
                );

                System.out.println(
                        "Flat Number: " + flatNumber
                );

                System.out.println(
                        "Mobile: " + mobile
                );

                System.out.println(
                        "Email: " + email
                );

                // Close popup
                rootPane.getChildren().remove(
                        overlay
                );

            });

        });

        // =====================================================
        // MAIN SCENE
        // =====================================================

        Scene scene = new Scene(
                rootPane,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        Owners = scene;

        return Owners;
    }

    // =========================================================
    // OWNER ROW METHOD
    // =========================================================

    private HBox createOwnerRow(
            String ownerName,
            String flatNumber,
            String mobile,
            String statusText
    ) {

        HBox ownerRow = new HBox(5);

        ownerRow.setPrefWidth(1000);
        ownerRow.setMaxWidth(1000);
        ownerRow.setPrefHeight(70);

        ownerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        ownerRow.setPadding(
                new Insets(20)
        );

        ownerRow.setStyle(
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
                ownerName
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
        // ADD TO ROW
        // =====================================================

        ownerRow.getChildren().addAll(
                profile,
                name,
                flat,
                mobileLabel,
                status
        );

        return ownerRow;
    }
}