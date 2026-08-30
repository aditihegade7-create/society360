package com.society.view.Secretary_portal;

import java.util.List;

import com.society.controller.Secretary_Controller.NoticeController;
import com.society.model.Secretary_model.Notice;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageNotices {

    private Scene manageNoticesScene;

    // =====================================================
    // CONTROLLER
    // =====================================================

    private NoticeController noticeController;

    // =====================================================
    // MAIN STACKPANE
    // =====================================================

    private StackPane rootStack;

    // =====================================================
    // NOTICE LIST
    // =====================================================

    private VBox noticeList;

    // =====================================================
    // CREATE SCENE
    // =====================================================

    public Scene createScene(Stage stage) {

        // =====================================================
        // CONTROLLER
        // =====================================================

        noticeController = new NoticeController();

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb =
                new VBox(20);

        mainvb.setPadding(
                new Insets(25)
        );

        mainvb.setPrefWidth(1220);

        mainvb.setMaxWidth(
                Double.MAX_VALUE
        );

        mainvb.setMaxHeight(
                Double.MAX_VALUE
        );

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading =
                new Label(
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

        Label title =
                new Label(
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

        Label subtitle =
                new Label(
                        "Create, edit and manage society notices"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // ADD NOTICE BUTTON
        // =====================================================

        Button addNoticeBtn =
                new Button(
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

        VBox headingBox =
                new VBox(5);

        headingBox.getChildren().addAll(
                title,
                subtitle
        );

        HBox header =
                new HBox();

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
        // NOTICE LIST
        // =====================================================

        noticeList =
                new VBox(15);

        noticeList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // =====================================================
        // LOAD NOTICES
        // =====================================================

        loadNotices();

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn =
                new Button(
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
                noticeList,
                viewAllBtn
        );

        // =====================================================
        // ROOT
        // =====================================================

        HBox root =
                new HBox();

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

        rootStack =
                new StackPane();

        rootStack.getChildren().add(
                root
        );

        // =====================================================
        // ADD NOTICE BUTTON
        // =====================================================

        addNoticeBtn.setOnAction(
                e -> openAddNoticePopup()
        );

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        viewAllBtn.setOnAction(
                e -> openAllNoticesPopup()
        );

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene =
                new Scene(
                        rootStack,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        manageNoticesScene = scene;

        return manageNoticesScene;
    }

    // =====================================================
    // LOAD NOTICES FROM FIRESTORE
    // =====================================================

    private void loadNotices() {

        noticeList.getChildren().clear();

        List<Notice> notices =
                noticeController.getAllNotices();

        if (notices == null ||
                notices.isEmpty()) {

            Label emptyLabel =
                    new Label(
                            "No notices found."
                    );

            emptyLabel.setStyle(
                    "-fx-font-size:16px;" +
                    "-fx-text-fill:#555555;"
            );

            noticeList.getChildren().add(
                    emptyLabel
            );

            return;
        }

        // Show notices individually
        for (Notice notice : notices) {

            VBox noticeBox =
                    createNotice(
                            notice.getTitle(),
                            notice.getDescription(),
                            notice.getDate(),
                            notice.getStatus()
                    );

            noticeList.getChildren().add(
                    noticeBox
            );
        }
    }

    // =====================================================
    // CREATE INDIVIDUAL NOTICE
    // =====================================================

    private VBox createNotice(
            String noticeTitleText,
            String noticeDescription,
            String noticeDateText,
            String statusText
    ) {

        VBox notice =
                new VBox(8);

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

        // =================================================
        // NOTICE TITLE LABEL
        // =================================================

        Label noticeTitle =
                new Label(
                        "▣  " + noticeTitleText
                );

        noticeTitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =================================================
        // NOTICE DESCRIPTION LABEL
        // =================================================

        Label noticeText =
                new Label(
                        noticeDescription
                );

        noticeText.setWrapText(true);

        noticeText.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // =================================================
        // DATE LABEL
        // =================================================

        Label noticeDate =
                new Label(
                        noticeDateText
                );

        noticeDate.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );

        // =================================================
        // STATUS LABEL
        // =================================================

        Label status =
                new Label(
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

        // =================================================
        // BOTTOM BOX
        // =================================================

        HBox bottom =
                new HBox(10);

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

        // =================================================
        // ADD ALL
        // =================================================

        notice.getChildren().addAll(
                noticeTitle,
                noticeText,
                bottom
        );

        return notice;
    }

    // =====================================================
    // ADD NOTICE POPUP
    // =====================================================

    private void openAddNoticePopup() {

        // =================================================
        // DARK OVERLAY
        // =================================================

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.35);"
        );

        // =================================================
        // SMALL POPUP
        // =================================================

        VBox popup =
                new VBox(12);

        popup.setPadding(
                new Insets(25)
        );

        // Same small popup size
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

        // =================================================
        // POPUP TITLE
        // =================================================

        Label popupTitle =
                new Label(
                        "Add New Notice"
                );

        popupTitle.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =================================================
        // NOTICE TITLE
        // =================================================

        Label titleLabel =
                new Label(
                        "Notice Title"
                );

        titleLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        TextField titleField =
                new TextField();

        titleField.setPromptText(
                "Enter notice title"
        );

        titleField.setPrefHeight(40);

        // =================================================
        // DESCRIPTION
        // =================================================

        Label descriptionLabel =
                new Label(
                        "Notice Description"
                );

        descriptionLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        TextField descriptionField =
                new TextField();

        descriptionField.setPromptText(
                "Enter notice description"
        );

        descriptionField.setPrefHeight(40);

        // =================================================
        // DATE
        // =================================================

        Label dateLabel =
                new Label(
                        "Notice Date"
                );

        dateLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        TextField dateField =
                new TextField();

        dateField.setPromptText(
                "Enter date"
        );

        dateField.setPrefHeight(40);

        // =================================================
        // STATUS
        // =================================================

        Label statusLabel =
                new Label(
                        "Status"
                );

        statusLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        TextField statusField =
                new TextField();

        statusField.setPromptText(
                "Enter status"
        );

        statusField.setPrefHeight(40);

        // =================================================
        // CANCEL BUTTON
        // =================================================

        Button cancelBtn =
                new Button(
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

        Button saveBtn =
                new Button(
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

        // =================================================
        // BUTTON BOX
        // =================================================

        HBox buttonBox =
                new HBox(10);

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

        // =================================================
        // ADD CONTROLS
        // =================================================

        popup.getChildren().addAll(

                popupTitle,

                titleLabel,
                titleField,

                descriptionLabel,
                descriptionField,

                dateLabel,
                dateField,

                statusLabel,
                statusField,

                buttonBox
        );

        // =================================================
        // ADD POPUP TO OVERLAY
        // =================================================

        overlay.getChildren().add(
                popup
        );

        StackPane.setAlignment(
                popup,
                Pos.CENTER
        );

        rootStack.getChildren().add(
                overlay
        );

        // =================================================
        // CANCEL
        // =================================================

        cancelBtn.setOnAction(
                e -> rootStack.getChildren().remove(
                        overlay
                )
        );

        // =================================================
        // SAVE
        // =================================================

        saveBtn.setOnAction(e -> {

            String noticeTitle =
                    titleField.getText().trim();

            String description =
                    descriptionField.getText().trim();

            String date =
                    dateField.getText().trim();

            String status =
                    statusField.getText().trim();

            // =================================================
            // VALIDATION
            // =================================================

            if (noticeTitle.isEmpty()
                    || description.isEmpty()
                    || date.isEmpty()
                    || status.isEmpty()) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Validation Error",
                        "Please fill all fields."
                );

                return;
            }

            // =================================================
            // SAVE TO FIRESTORE
            // =================================================

            boolean success =
                    noticeController.addNotice(
                            noticeTitle,
                            description,
                            date,
                            status
                    );

            // =================================================
            // SUCCESS
            // =================================================

            if (success) {

                showAlert(
                        Alert.AlertType.INFORMATION,
                        "Success",
                        "Notice saved successfully!"
                );

                rootStack.getChildren().remove(
                        overlay
                );

                // Refresh individual notices
                loadNotices();

            } else {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Error",
                        "Failed to save notice."
                );
            }
        });

        // =================================================
        // FOCUS
        // =================================================

        titleField.requestFocus();
    }

    // =====================================================
    // VIEW ALL NOTICES POPUP
    // =====================================================

    private void openAllNoticesPopup() {

        // =================================================
        // DARK OVERLAY
        // =================================================

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.35);"
        );

        // =================================================
        // POPUP
        // =================================================

        VBox popup =
                new VBox(15);

        popup.setPadding(
                new Insets(25)
        );

        popup.setPrefWidth(600);
        popup.setPrefHeight(500);

        popup.setMaxWidth(600);
        popup.setMaxHeight(500);

        popup.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;"
        );

        // =================================================
        // TITLE
        // =================================================

        Label popupTitle =
                new Label(
                        "All Notices"
                );

        popupTitle.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =================================================
        // NOTICE LIST
        // =================================================

        VBox allNoticeList =
                new VBox(12);

        // =================================================
        // FETCH FROM FIRESTORE
        // =================================================

        List<Notice> notices =
                noticeController.getAllNotices();

        if (notices == null ||
                notices.isEmpty()) {

            Label noNotice =
                    new Label(
                            "No notices found."
                    );

            noNotice.setStyle(
                    "-fx-font-size:14px;" +
                    "-fx-text-fill:#777777;"
            );

            allNoticeList.getChildren().add(
                    noNotice
            );

        } else {

            for (Notice notice : notices) {

                VBox noticeBox =
                        createPopupNotice(
                                notice.getTitle(),
                                notice.getDescription(),
                                notice.getDate(),
                                notice.getStatus()
                        );

                allNoticeList.getChildren().add(
                        noticeBox
                );
            }
        }

        // =================================================
        // SCROLL PANE
        // =================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                allNoticeList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(370);

        scrollPane.setStyle(
                "-fx-background-color:transparent;"
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        // =================================================
        // CLOSE BUTTON
        // =================================================

        Button closeBtn =
                new Button(
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

        HBox buttonBox =
                new HBox(
                        closeBtn
                );

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        // =================================================
        // ADD EVERYTHING
        // =================================================

        popup.getChildren().addAll(
                popupTitle,
                scrollPane,
                buttonBox
        );

        // =================================================
        // ADD POPUP TO OVERLAY
        // =================================================

        overlay.getChildren().add(
                popup
        );

        StackPane.setAlignment(
                popup,
                Pos.CENTER
        );

        rootStack.getChildren().add(
                overlay
        );

        // =================================================
        // CLOSE
        // =================================================

        closeBtn.setOnAction(
                e -> rootStack.getChildren().remove(
                        overlay
                )
        );
    }

    // =====================================================
    // CREATE NOTICE FOR VIEW ALL POPUP
    // =====================================================

    private VBox createPopupNotice(
            String titleText,
            String descriptionText,
            String dateText,
            String statusText
    ) {

        VBox box =
                new VBox(7);

        box.setPadding(
                new Insets(15)
        );

        box.setStyle(
                "-fx-background-color:#F4F7F6;" +
                "-fx-background-radius:10;"
        );

        // =================================================
        // TITLE LABEL
        // =================================================

        Label title =
                new Label(
                        "▣  " + titleText
                );

        title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =================================================
        // DESCRIPTION LABEL
        // =================================================

        Label description =
                new Label(
                        descriptionText
                );

        description.setWrapText(
                true
        );

        description.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#555555;"
        );

        // =================================================
        // DATE + STATUS
        // =================================================

        Label date =
                new Label(
                        dateText
                );

        date.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        Label status =
                new Label(
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

        HBox bottom =
                new HBox(10);

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                date,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                date,
                status
        );

        box.getChildren().addAll(
                title,
                description,
                bottom
        );

        return box;
    }

    // =====================================================
    // ALERT
    // =====================================================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message) {

        Alert alert =
                new Alert(type);

        alert.setTitle(
                title
        );

        alert.setHeaderText(
                null
        );

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }
}