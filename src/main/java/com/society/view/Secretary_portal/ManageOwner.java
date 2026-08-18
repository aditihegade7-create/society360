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

        // ================= SIDEBAR =================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);


        // ================= MAIN =================

        VBox mainvb = new VBox(10);

        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // ================= TITLE =================

        Label title = new Label("Manage Owners");

        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label("View and manage all flat owners");

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );


        // ================= SEARCH =================

        TextField search = new TextField();

        search.setPromptText(
                "Search owner, flat no., phone..."
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


        // ================= ADD OWNER BUTTON =================

        Button addOwnerBtn =
                new Button("+ Add New Owner");

        addOwnerBtn.setPrefWidth(200);
        addOwnerBtn.setPrefHeight(45);

        addOwnerBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );


        HBox searchBox = new HBox(15);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.getChildren().addAll(
                search,
                addOwnerBtn
        );


        // =====================================================
        //                    STACKPANE
        // =====================================================

        StackPane contentPane =
                new StackPane();

        contentPane.getChildren().add(
                mainvb
        );


        // =====================================================
        //                  ADD OWNER FORM
        // =====================================================

        VBox addOwnerBox =
                new VBox(15);

        addOwnerBox.setPrefWidth(450);
        addOwnerBox.setMaxWidth(450);

        addOwnerBox.setPrefHeight(300);
        addOwnerBox.setMaxHeight(300);

        addOwnerBox.setPadding(
                new Insets(25)
        );

        addOwnerBox.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:12;" +
                "-fx-border-color:#DDDDDD;" +
                "-fx-border-radius:12;"
        );


        // Form Title

        Label formTitle =
                new Label("Add New Owner");

        formTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        // Owner Name

        TextField ownerName =
                new TextField();

        ownerName.setPromptText(
                "Enter owner name"
        );

        ownerName.setPrefHeight(40);


        // Flat Number

        TextField flatNumber =
                new TextField();

        flatNumber.setPromptText(
                "Enter flat number"
        );

        flatNumber.setPrefHeight(40);


        // Mobile Number

        TextField mobileNumber =
                new TextField();

        mobileNumber.setPromptText(
                "Enter mobile number"
        );

        mobileNumber.setPrefHeight(40);


        // ================= BUTTONS =================

        Button saveBtn =
                new Button("Save Owner");

        saveBtn.setPrefWidth(130);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);


        HBox formButtons =
                new HBox(10);

        formButtons.setAlignment(
                Pos.CENTER_LEFT
        );

        formButtons.getChildren().addAll(
                saveBtn,
                cancelBtn
        );


        // Add form content

        addOwnerBox.getChildren().addAll(
                formTitle,
                ownerName,
                flatNumber,
                mobileNumber,
                formButtons
        );


        // Initially hide form

        addOwnerBox.setVisible(false);


        // =====================================================
        //                 ADD BUTTON CLICK
        // =====================================================

        addOwnerBtn.setOnAction(e -> {

            addOwnerBox.setVisible(true);

            if (!contentPane.getChildren()
                    .contains(addOwnerBox)) {

                contentPane.getChildren()
                        .add(addOwnerBox);
            }

            StackPane.setAlignment(
                    addOwnerBox,
                    Pos.CENTER
            );
        });


        // =====================================================
        //                    CANCEL
        // =====================================================

        cancelBtn.setOnAction(e -> {

            addOwnerBox.setVisible(false);

            contentPane.getChildren()
                    .remove(addOwnerBox);
        });


        // =====================================================
        //                    SAVE
        // =====================================================

        saveBtn.setOnAction(e -> {

            String name =
                    ownerName.getText();

            String flat =
                    flatNumber.getText();

            String mobile =
                    mobileNumber.getText();

            if (!name.isEmpty()
                    && !flat.isEmpty()
                    && !mobile.isEmpty()) {

                System.out.println(
                        "Owner Saved: "
                                + name
                                + " | "
                                + flat
                                + " | "
                                + mobile
                );

                ownerName.clear();
                flatNumber.clear();
                mobileNumber.clear();

                addOwnerBox.setVisible(false);

                contentPane.getChildren()
                        .remove(addOwnerBox);
            }
        });


        // =====================================================
        //                    OWNER 1
        // =====================================================

        HBox resident1 =
                createOwnerRow(
                        "vijay",
                        "B-402",
                        "9876543210",
                        "Active"
                );


        // =====================================================
        //                    OWNER 2
        // =====================================================

        HBox resident2 =
                createOwnerRow(
                        "Sachin",
                        "B-403",
                        "9876543211",
                        "Active"
                );


        // =====================================================
        //                    OWNER 3
        // =====================================================

        HBox resident3 =
                createOwnerRow(
                        "Pramod",
                        "B-404",
                        "9876543212",
                        "Active"
                );


        // =====================================================
        //                    OWNER 4
        // =====================================================

        HBox resident4 =
                createOwnerRow(
                        "Ram",
                        "B-405",
                        "9876543213",
                        "Inactive"
                );


        // ================= OWNER LIST =================

        VBox vb =
                new VBox(
                        40,
                        resident1,
                        resident2,
                        resident3,
                        resident4
                );

        VBox.setMargin(
                resident1,
                new Insets(20, 0, 0, 0)
        );


        // ================= MAIN CONTENT =================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                vb
        );


        // ================= ROOT =================

        HBox root =
                new HBox();

        root.getChildren().addAll(
                sidebar,
                contentPane
        );

        HBox.setHgrow(
                contentPane,
                Priority.ALWAYS
        );


        // ================= SCENE =================

        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        Owners = scene;

        return Owners;
    }


    // =========================================================
    //                 OWNER ROW METHOD
    // =========================================================

    private HBox createOwnerRow(
            String ownerName,
            String flat,
            String mobile,
            String status) {


        HBox owner =
                new HBox(5);

        owner.setPrefWidth(1000);
        owner.setMaxWidth(1000);
        owner.setPrefHeight(70);

        owner.setAlignment(
                Pos.CENTER_LEFT
        );

        owner.setPadding(
                new Insets(20)
        );

        owner.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );


        // Profile

        Label profile =
                new Label("👤");

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


        // Name

        Label name =
                new Label(ownerName);

        name.setPrefWidth(220);

        name.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        // Flat

        Label flatLabel =
                new Label("Flat: " + flat);

        flatLabel.setPrefWidth(150);

        flatLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );


        // Mobile

        Label mobileLabel =
                new Label("Mobile: " + mobile);

        mobileLabel.setPrefWidth(220);

        mobileLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );


        // Status

        Label statusLabel =
                new Label(status);

        statusLabel.setPrefWidth(100);

        statusLabel.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );


        owner.getChildren().addAll(
                profile,
                name,
                flatLabel,
                mobileLabel,
                statusLabel
        );


        return owner;
    }
}