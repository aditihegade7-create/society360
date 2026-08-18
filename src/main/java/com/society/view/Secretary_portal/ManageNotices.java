package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageNotices {

    private Scene manageNoticesScene;

    public Scene createScene(Stage stage) {

        // ================= SIDEBAR =================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);


        // ================= MAIN CONTENT =================

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxHeight(Double.MAX_VALUE);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // ================= TOP HEADER =================

        Label welcomeLabel = new Label("Welcome back");
        welcomeLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        Label secretaryLabel = new Label("Secretary Dashboard");
        secretaryLabel.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        VBox welcomeBox = new VBox(2);
        welcomeBox.getChildren().addAll(
                welcomeLabel,
                secretaryLabel
        );


        Label notification = new Label("🔔");
        notification.setStyle(
                "-fx-font-size:20px;"
        );

        Label dateLabel = new Label("18 August 2026");
        dateLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        Label profile = new Label("S");
        profile.setPrefWidth(38);
        profile.setPrefHeight(38);
        profile.setAlignment(Pos.CENTER);

        profile.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:50%;"
        );


        HBox topHeader = new HBox(20);
        topHeader.setAlignment(Pos.CENTER_LEFT);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topHeader.getChildren().addAll(
                welcomeBox,
                spacer,
                notification,
                dateLabel,
                profile
        );


        // ================= PAGE HEADING =================

        Label heading = new Label("MANAGE NOTICES");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        Label title = new Label("Manage Notices");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle = new Label(
                "Create, edit and manage society notices"
        );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );


        // ================= ADD NOTICE BUTTON =================

        Button addNoticeBtn = new Button("+ Add Notice");

        addNoticeBtn.setPrefWidth(130);
        addNoticeBtn.setPrefHeight(40);

        addNoticeBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        VBox headingBox = new VBox(5);

        headingBox.getChildren().addAll(
                title,
                subtitle
        );


        HBox header = new HBox();

        header.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(
                headingBox,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                headingBox,
                addNoticeBtn
        );


        // ================= NOTICE 1 =================

        VBox notice1 = new VBox(8);

        notice1.setPadding(
                new Insets(20)
        );

        notice1.setPrefHeight(95);

        notice1.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:8;"
        );


        Label notice1Title =
                new Label("▣  Water Supply Maintenance");

        notice1Title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label notice1Text =
                new Label(
                        "The water supply will be unavailable on " +
                        "12 May 2025 from 10:00 PM to 6:00 AM."
                );

        notice1Text.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        Label notice1Date =
                new Label("10 May 2025");

        notice1Date.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );


        Label published1 =
                new Label("Published");

        published1.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 9px;" +
                "-fx-background-radius:12;"
        );


        HBox notice1Bottom =
                new HBox(10);

        notice1Bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                notice1Date,
                Priority.ALWAYS
        );

        notice1Bottom.getChildren().addAll(
                notice1Date,
                published1
        );


        notice1.getChildren().addAll(
                notice1Title,
                notice1Text,
                notice1Bottom
        );


        // ================= NOTICE 2 =================

        VBox notice2 = new VBox(8);

        notice2.setPadding(
                new Insets(20)
        );

        notice2.setPrefHeight(95);

        notice2.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:8;"
        );


        Label notice2Title =
                new Label("▣  Society Meeting");

        notice2Title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label notice2Text =
                new Label(
                        "All residents are requested to attend the " +
                        "monthly meeting on 12 May 2025."
                );

        notice2Text.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        Label notice2Date =
                new Label("08 May 2025");

        notice2Date.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );


        Label published2 =
                new Label("Published");

        published2.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 9px;" +
                "-fx-background-radius:12;"
        );


        HBox notice2Bottom =
                new HBox(10);

        notice2Bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                notice2Date,
                Priority.ALWAYS
        );

        notice2Bottom.getChildren().addAll(
                notice2Date,
                published2
        );


        notice2.getChildren().addAll(
                notice2Title,
                notice2Text,
                notice2Bottom
        );


        // ================= NOTICE 3 =================

        VBox notice3 = new VBox(8);

        notice3.setPadding(
                new Insets(20)
        );

        notice3.setPrefHeight(95);

        notice3.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:8;"
        );


        Label notice3Title =
                new Label("▣  Parking Rule Update");

        notice3Title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label notice3Text =
                new Label(
                        "New parking rules are effective from " +
                        "15 May 2025."
                );

        notice3Text.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        Label notice3Date =
                new Label("05 May 2025");

        notice3Date.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );


        Label draft =
                new Label("Draft");

        draft.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 9px;" +
                "-fx-background-radius:12;"
        );


        HBox notice3Bottom =
                new HBox(10);

        notice3Bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                notice3Date,
                Priority.ALWAYS
        );

        notice3Bottom.getChildren().addAll(
                notice3Date,
                draft
        );


        notice3.getChildren().addAll(
                notice3Title,
                notice3Text,
                notice3Bottom
        );


        // ================= VIEW ALL BUTTON =================

        Button viewAllBtn =
                new Button("View All Notices");

        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        // ================= MAIN CONTENT =================

        mainvb.getChildren().addAll(
                topHeader,
                heading,
                header,
                notice1,
                notice2,
                notice3,
                viewAllBtn
        );


        // ================= ROOT =================

        HBox contentRoot =
                new HBox();

        contentRoot.setMaxWidth(
                Double.MAX_VALUE
        );

        contentRoot.setMaxHeight(
                Double.MAX_VALUE
        );

        contentRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );


        // ================= STACKPANE =================

        /*
         * StackPane is used so that the small Add Notice
         * window can appear ON TOP of the existing page.
         */

        StackPane root =
                new StackPane();

        root.getChildren().add(
                contentRoot
        );


        // =================================================
        // ADD NOTICE POPUP
        // =================================================

        StackPane overlay =
                new StackPane();

        overlay.setVisible(false);

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.45);"
        );


        // ================= POPUP BOX =================

        VBox noticeBox =
                new VBox(15);

        noticeBox.setPrefWidth(430);
        noticeBox.setMaxWidth(430);
        noticeBox.setPrefHeight(350);
        noticeBox.setMaxHeight(350);

        noticeBox.setPadding(
                new Insets(25)
        );

        noticeBox.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:14;"
        );


        // ================= POPUP HEADER =================

        Label popupTitle =
                new Label("Add New Notice");

        popupTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Button closeBtn =
                new Button("×");

        closeBtn.setPrefWidth(35);
        closeBtn.setPrefHeight(35);

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-font-size:22px;" +
                "-fx-text-fill:#777777;"
        );


        Region popupSpacer =
                new Region();

        HBox.setHgrow(
                popupSpacer,
                Priority.ALWAYS
        );


        HBox popupHeader =
                new HBox();

        popupHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        popupHeader.getChildren().addAll(
                popupTitle,
                popupSpacer,
                closeBtn
        );


        // ================= NOTICE TITLE =================

        Label noticeTitleLabel =
                new Label("Notice Title");

        noticeTitleLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        TextField noticeTitleField =
                new TextField();

        noticeTitleField.setPromptText(
                "Enter notice title"
        );

        noticeTitleField.setPrefHeight(42);

        noticeTitleField.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#DDDDDD;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:13px;"
        );


        // ================= DESCRIPTION =================

        Label descriptionLabel =
                new Label("Description");

        descriptionLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        TextArea descriptionField =
                new TextArea();

        descriptionField.setPromptText(
                "Enter notice description"
        );

        descriptionField.setPrefHeight(90);

        descriptionField.setWrapText(true);

        descriptionField.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#DDDDDD;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:13px;"
        );


        // ================= POPUP BUTTONS =================

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:white;" +
                "-fx-text-fill:#434141;" +
                "-fx-font-weight:bold;" +
                "-fx-border-color:#CCCCCC;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;"
        );


        Button saveBtn =
                new Button("Save Notice");

        saveBtn.setPrefWidth(120);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );


        HBox popupButtons =
                new HBox(10);

        popupButtons.setAlignment(
                Pos.CENTER_RIGHT
        );

        popupButtons.getChildren().addAll(
                cancelBtn,
                saveBtn
        );


        // ================= ADD TO POPUP =================

        noticeBox.getChildren().addAll(
                popupHeader,
                noticeTitleLabel,
                noticeTitleField,
                descriptionLabel,
                descriptionField,
                popupButtons
        );


        overlay.getChildren().add(
                noticeBox
        );

        StackPane.setAlignment(
                noticeBox,
                Pos.CENTER
        );


        root.getChildren().add(
                overlay
        );


        // =================================================
        // ADD NOTICE BUTTON CLICK
        // =================================================

        addNoticeBtn.setOnAction(e -> {

            overlay.setVisible(true);

        });


        // =================================================
        // CLOSE BUTTON CLICK
        // =================================================

        closeBtn.setOnAction(e -> {

            overlay.setVisible(false);

            noticeTitleField.clear();
            descriptionField.clear();

        });


        // =================================================
        // CANCEL BUTTON CLICK
        // =================================================

        cancelBtn.setOnAction(e -> {

            overlay.setVisible(false);

            noticeTitleField.clear();
            descriptionField.clear();

        });


        // =================================================
        // SAVE BUTTON CLICK
        // =================================================

        saveBtn.setOnAction(e -> {

            String noticeTitleText =
                    noticeTitleField.getText();

            String descriptionText =
                    descriptionField.getText();


            if (!noticeTitleText.isEmpty()
                    && !descriptionText.isEmpty()) {

                System.out.println(
                        "Notice Saved: "
                        + noticeTitleText
                );

                overlay.setVisible(false);

                noticeTitleField.clear();
                descriptionField.clear();

            }

        });


        // ================= SCENE =================

        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        manageNoticesScene = scene;

        return manageNoticesScene;
    }
}