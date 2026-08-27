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

public class ManageNotices {

    private Scene manageNoticesScene;

    public Scene createScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj = new SecretarySidebar();

        VBox sidebar = sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb = new VBox(20);

        mainvb.setPadding(new Insets(25));

        mainvb.setPrefWidth(1220);

        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxHeight(Double.MAX_VALUE);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading = new Label(
                "MANAGE NOTICES"
        );

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label(
                "Manage Notices"
        );

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        // =====================================================
        // SUBTITLE
        // =====================================================

        Label subtitle = new Label(
                "Create, edit and manage society notices"
        );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // ADD NOTICE BUTTON
        // =====================================================

        Button addNoticeBtn = new Button(
                "+ Add Notice"
        );

        addNoticeBtn.setPrefWidth(120);
        addNoticeBtn.setPrefHeight(38);

        addNoticeBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );

        // =====================================================
        // HEADER BOX
        // =====================================================

        VBox headingBox = new VBox(5);

        headingBox.getChildren().addAll(
                title,
                subtitle
        );

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                headingBox,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                headingBox,
                addNoticeBtn
        );

        // =====================================================
        // NOTICE 1
        // =====================================================

        VBox notice1 = createNotice(
                "▣  Water Supply Maintenance",
                "The water supply will be unavailable on " +
                "12 May 2025 from 10:00 PM to 6:00 AM.",
                "10 May 2025",
                "Published"
        );

        // =====================================================
        // NOTICE 2
        // =====================================================

        VBox notice2 = createNotice(
                "▣  Society Meeting",
                "All residents are requested to attend the " +
                "monthly meeting on 12 May 2025.",
                "08 May 2025",
                "Published"
        );

        // =====================================================
        // NOTICE 3
        // =====================================================

        VBox notice3 = createNotice(
                "▣  Parking Rule Update",
                "New parking rules are effective from " +
                "15 May 2025.",
                "05 May 2025",
                "Draft"
        );

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn = new Button(
                "View All Notices"
        );

        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                heading,
                header,
                notice1,
                notice2,
                notice3,
                viewAllBtn
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
        // Popup main screen वर दाखवण्यासाठी
        // =====================================================

        StackPane rootStack = new StackPane();

        rootStack.getChildren().add(
                root
        );

        // =====================================================
        // ADD NOTICE BUTTON CLICK
        // =====================================================

        addNoticeBtn.setOnAction(e -> {

            // -------------------------------------------------
            // DARK OVERLAY
            // -------------------------------------------------

            VBox overlay = new VBox();

            overlay.setStyle(
                    "-fx-background-color:rgba(0,0,0,0.35);"
            );

            overlay.setAlignment(
                    Pos.CENTER
            );

            // -------------------------------------------------
            // SMALL POPUP
            // -------------------------------------------------

            VBox popup = new VBox(12);

            popup.setPadding(
                    new Insets(25)
            );

            popup.setPrefWidth(450);
            popup.setPrefHeight(400);

            popup.setMaxWidth(450);
            popup.setMaxHeight(400);

            popup.setAlignment(
                    Pos.TOP_LEFT
            );

            popup.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:15;"
            );

            // -------------------------------------------------
            // POPUP TITLE
            // -------------------------------------------------

            Label popupTitle = new Label(
                    "Add New Notice"
            );

            popupTitle.setStyle(
                    "-fx-font-size:24px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // -------------------------------------------------
            // NOTICE TITLE
            // -------------------------------------------------

            Label titleLabel = new Label(
                    "Notice Title"
            );

            titleLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField titleField = new TextField();

            titleField.setPromptText(
                    "Enter notice title"
            );

            titleField.setPrefHeight(40);

            // -------------------------------------------------
            // DESCRIPTION
            // -------------------------------------------------

            Label descriptionLabel = new Label(
                    "Notice Description"
            );

            descriptionLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField descriptionField = new TextField();

            descriptionField.setPromptText(
                    "Enter notice description"
            );

            descriptionField.setPrefHeight(40);

            // -------------------------------------------------
            // DATE
            // -------------------------------------------------

            Label dateLabel = new Label(
                    "Notice Date"
            );

            dateLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;"
            );

            TextField dateField = new TextField();

            dateField.setPromptText(
                    "Enter date"
            );

            dateField.setPrefHeight(40);

            // -------------------------------------------------
            // CANCEL BUTTON
            // -------------------------------------------------

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

            // -------------------------------------------------
            // SAVE BUTTON
            // -------------------------------------------------

            Button saveBtn = new Button(
                    "Save Notice"
            );

            saveBtn.setPrefWidth(130);
            saveBtn.setPrefHeight(40);

            saveBtn.setStyle(
                    "-fx-background-color:#2E9D63;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            // -------------------------------------------------
            // BUTTON BOX
            // -------------------------------------------------

            HBox buttonBox = new HBox(10);

            buttonBox.setAlignment(
                    Pos.CENTER_RIGHT
            );

            buttonBox.setPadding(
                    new Insets(8, 0, 0, 0)
            );

            buttonBox.getChildren().addAll(
                    cancelBtn,
                    saveBtn
            );

            // -------------------------------------------------
            // ADD CONTROLS
            // -------------------------------------------------

            popup.getChildren().addAll(

                    popupTitle,

                    titleLabel,
                    titleField,

                    descriptionLabel,
                    descriptionField,

                    dateLabel,
                    dateField,

                    buttonBox
            );

            // -------------------------------------------------
            // POPUP TO OVERLAY
            // -------------------------------------------------

            overlay.getChildren().add(
                    popup
            );

            // -------------------------------------------------
            // ADD OVERLAY ABOVE MAIN SCREEN
            // -------------------------------------------------

            rootStack.getChildren().add(
                    overlay
            );

            // -------------------------------------------------
            // CANCEL
            // -------------------------------------------------

            cancelBtn.setOnAction(event -> {

                rootStack.getChildren().remove(
                        overlay
                );

            });

            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            saveBtn.setOnAction(event -> {

                String noticeTitle =
                        titleField.getText();

                String description =
                        descriptionField.getText();

                String date =
                        dateField.getText();

                System.out.println(
                        "Notice Title: " + noticeTitle
                );

                System.out.println(
                        "Description: " + description
                );

                System.out.println(
                        "Date: " + date
                );

                rootStack.getChildren().remove(
                        overlay
                );

            });

            // -------------------------------------------------
            // FOCUS
            // -------------------------------------------------

            titleField.requestFocus();

        });

        // =====================================================
        // VIEW ALL BUTTON CLICK
        // =====================================================

        viewAllBtn.setOnAction(e -> {

            // -------------------------------------------------
            // DARK OVERLAY
            // -------------------------------------------------

            VBox overlay = new VBox();

            overlay.setStyle(
                    "-fx-background-color:rgba(0,0,0,0.35);"
            );

            overlay.setAlignment(
                    Pos.CENTER
            );

            // -------------------------------------------------
            // SMALL POPUP
            // -------------------------------------------------

            VBox popup = new VBox(15);

            popup.setPadding(
                    new Insets(25)
            );

            popup.setPrefWidth(600);
            popup.setPrefHeight(500);

            popup.setMaxWidth(600);
            popup.setMaxHeight(500);

            popup.setAlignment(
                    Pos.TOP_LEFT
            );

            popup.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:15;"
            );

            // -------------------------------------------------
            // TITLE
            // -------------------------------------------------

            Label popupTitle = new Label(
                    "All Notices"
            );

            popupTitle.setStyle(
                    "-fx-font-size:24px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // -------------------------------------------------
            // NOTICE 1
            // -------------------------------------------------

            Label notice11 = new Label(
                    "▣ Water Supply Maintenance\n" +
                    "The water supply will be unavailable " +
                    "on 12 May 2025.\n" +
                    "10 May 2025"
            );

            notice11.setPrefWidth(530);

            notice11.setWrapText(true);

            notice11.setPadding(
                    new Insets(15)
            );

            notice11.setStyle(
                    "-fx-background-color:#F4F7F6;" +
                    "-fx-background-radius:10;" +
                    "-fx-font-size:13px;"
            );

            // -------------------------------------------------
            // NOTICE 2
            // -------------------------------------------------

            Label notice12 = new Label(
                    "▣ Society Meeting\n" +
                    "All residents are requested to attend " +
                    "the monthly meeting.\n" +
                    "08 May 2025"
            );

            notice12.setPrefWidth(530);

            notice12.setWrapText(true);

            notice12.setPadding(
                    new Insets(15)
            );

            notice12.setStyle(
                    "-fx-background-color:#F4F7F6;" +
                    "-fx-background-radius:10;" +
                    "-fx-font-size:13px;"
            );

            // -------------------------------------------------
            // NOTICE 3
            // -------------------------------------------------

            Label notice13 = new Label(
                    "▣ Parking Rule Update\n" +
                    "New parking rules are effective from " +
                    "15 May 2025.\n" +
                    "05 May 2025"
            );

            notice13.setPrefWidth(530);

            notice13.setWrapText(true);

            notice13.setPadding(
                    new Insets(15)
            );

            notice13.setStyle(
                    "-fx-background-color:#F4F7F6;" +
                    "-fx-background-radius:10;" +
                    "-fx-font-size:13px;"
            );

            // -------------------------------------------------
            // CLOSE BUTTON
            // -------------------------------------------------

            Button closeBtn = new Button(
                    "Close"
            );

            closeBtn.setPrefWidth(100);
            closeBtn.setPrefHeight(40);

            closeBtn.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            HBox buttonBox = new HBox(
                    closeBtn
            );

            buttonBox.setAlignment(
                    Pos.CENTER_RIGHT
            );

            // -------------------------------------------------
            // ADD EVERYTHING
            // -------------------------------------------------

            popup.getChildren().addAll(

                    popupTitle,

                    notice11,
                    notice12,
                    notice13,

                    buttonBox
            );

            // -------------------------------------------------
            // ADD POPUP TO OVERLAY
            // -------------------------------------------------

            overlay.getChildren().add(
                    popup
            );

            // -------------------------------------------------
            // ADD OVERLAY
            // -------------------------------------------------

            rootStack.getChildren().add(
                    overlay
            );

            // -------------------------------------------------
            // CLOSE
            // -------------------------------------------------

            closeBtn.setOnAction(event -> {

                rootStack.getChildren().remove(
                        overlay
                );

            });

        });

        // =====================================================
        // MAIN SCENE
        // =====================================================

        Scene scene = new Scene(
                rootStack,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageNoticesScene = scene;

        return manageNoticesScene;
    }

    // =========================================================
    // NOTICE CREATION METHOD
    // =========================================================

    private VBox createNotice(
            String noticeTitleText,
            String noticeDescription,
            String noticeDateText,
            String statusText
    ) {

        VBox notice = new VBox(8);

        notice.setPadding(
                new Insets(20)
        );

        notice.setPrefHeight(95);

        notice.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:8;"
        );

        // -----------------------------------------------------
        // NOTICE TITLE
        // -----------------------------------------------------

        Label noticeTitle = new Label(
                noticeTitleText
        );

        noticeTitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // -----------------------------------------------------
        // DESCRIPTION
        // -----------------------------------------------------

        Label noticeText = new Label(
                noticeDescription
        );

        noticeText.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // -----------------------------------------------------
        // DATE
        // -----------------------------------------------------

        Label noticeDate = new Label(
                noticeDateText
        );

        noticeDate.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );

        // -----------------------------------------------------
        // STATUS
        // -----------------------------------------------------

        Label status = new Label(
                statusText
        );

        status.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 9px;" +
                "-fx-background-radius:12;"
        );

        // -----------------------------------------------------
        // BOTTOM BOX
        // -----------------------------------------------------

        HBox bottom = new HBox(10);

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                noticeDate,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                noticeDate,
                status
        );

        // -----------------------------------------------------
        // ADD
        // -----------------------------------------------------

        notice.getChildren().addAll(
                noticeTitle,
                noticeText,
                bottom
        );

        return notice;
    }
}