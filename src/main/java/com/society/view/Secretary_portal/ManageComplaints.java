package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public class ManageComplaints {

    // Scene
    private Scene manageComplaintsScene;

    // Main StackPane
    // Popup isi ke upar open hoga
    private StackPane rootStack;


    // =========================================================
    // CREATE SCENE
    // =========================================================

    public Scene createScene(Stage stage) {

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

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // =====================================================
        // HEADING
        // =====================================================

        Label heading =
                new Label("MANAGE COMPLAINTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label("Manage Complaints");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label(
                        "Track and resolve resident complaints"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );


        VBox titleBox =
                new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // ADD COMPLAINT BUTTON
        // =====================================================

        Button addComplaintBtn =
                new Button("+ Add Complaint");

        addComplaintBtn.setPrefWidth(150);
        addComplaintBtn.setPrefHeight(40);

        addComplaintBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;"
        );


        // SAME SCENE POPUP

        addComplaintBtn.setOnAction(
                e -> openAddComplaintDialog()
        );


        // =====================================================
        // COMPLAINT HEADER
        // =====================================================

        HBox complaintHeader =
                new HBox();

        complaintHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        complaintHeader.getChildren().addAll(
                titleBox,
                addComplaintBtn
        );


        // =====================================================
        // STATUS BUTTONS
        // =====================================================

        Button openBtn =
                new Button("Open (6)");

        Button progressBtn =
                new Button("In Progress (4)");

        Button resolvedBtn =
                new Button("Resolved (13)");


        openBtn.setPrefWidth(150);
        openBtn.setPrefHeight(40);

        progressBtn.setPrefWidth(150);
        progressBtn.setPrefHeight(40);

        resolvedBtn.setPrefWidth(150);
        resolvedBtn.setPrefHeight(40);


        // =====================================================
        // BUTTON STYLES
        // =====================================================

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#777777;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-cursor:hand;";


        String activeStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-width:0 0 2 0;" +
                "-fx-cursor:hand;";


        openBtn.setStyle(activeStyle);
        progressBtn.setStyle(normalStyle);
        resolvedBtn.setStyle(normalStyle);


        // =====================================================
        // TABS
        // =====================================================

        HBox tabs =
                new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                openBtn,
                progressBtn,
                resolvedBtn
        );


        // =====================================================
        // COMPLAINT LIST
        // =====================================================

        VBox complaintList =
                new VBox(15);

        complaintList.setPadding(
                new Insets(5, 0, 5, 0)
        );


        // =====================================================
        // OPEN COMPLAINTS
        // =====================================================

        VBox openComplaint1 =
                createComplaint(
                        "Water Leakage in Bathroom",
                        "B-402",
                        "10 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        VBox openComplaint2 =
                createComplaint(
                        "Parking Issue",
                        "C-203",
                        "09 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        VBox openComplaint3 =
                createComplaint(
                        "Lift Noise Problem",
                        "A-204",
                        "09 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        VBox openComplaint4 =
                createComplaint(
                        "Cleaning Issue",
                        "B-105",
                        "08 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        VBox openComplaint5 =
                createComplaint(
                        "Water Tap Leakage",
                        "C-301",
                        "07 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        VBox openComplaint6 =
                createComplaint(
                        "Security Gate Issue",
                        "A-402",
                        "06 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                );


        // =====================================================
        // IN PROGRESS COMPLAINTS
        // =====================================================

        VBox progressComplaint1 =
                createComplaint(
                        "Lift Not Working",
                        "A-101",
                        "10 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                );


        VBox progressComplaint2 =
                createComplaint(
                        "Water Tank Cleaning",
                        "B-305",
                        "08 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                );


        VBox progressComplaint3 =
                createComplaint(
                        "Garden Maintenance",
                        "C-102",
                        "07 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                );


        VBox progressComplaint4 =
                createComplaint(
                        "Common Area Light",
                        "A-302",
                        "06 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                );


        // =====================================================
        // RESOLVED COMPLAINTS
        // =====================================================

        VBox resolvedComplaint1 =
                createComplaint(
                        "Garbage Not Collected",
                        "B-305",
                        "09 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint2 =
                createComplaint(
                        "Water Pressure Issue",
                        "C-201",
                        "06 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint3 =
                createComplaint(
                        "Parking Light Issue",
                        "B-201",
                        "05 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint4 =
                createComplaint(
                        "Lift Button Issue",
                        "C-302",
                        "03 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint5 =
                createComplaint(
                        "Corridor Cleaning",
                        "B-104",
                        "02 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint6 =
                createComplaint(
                        "Water Pipe Issue",
                        "A-202",
                        "01 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint7 =
                createComplaint(
                        "Parking Space Issue",
                        "C-103",
                        "30 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint8 =
                createComplaint(
                        "Staircase Light",
                        "B-203",
                        "29 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint9 =
                createComplaint(
                        "Society Gate Issue",
                        "A-301",
                        "28 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint10 =
                createComplaint(
                        "Basement Cleaning",
                        "B-301",
                        "23 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint11 =
                createComplaint(
                        "Security Camera Issue",
                        "A-102",
                        "22 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint12 =
                createComplaint(
                        "Terrace Cleaning",
                        "C-302",
                        "21 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        VBox resolvedComplaint13 =
                createComplaint(
                        "Electricity Issue",
                        "A-204",
                        "19 Apr 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                );


        // =====================================================
        // DEFAULT OPEN COMPLAINTS
        // =====================================================

        complaintList.getChildren().addAll(
                openComplaint1,
                openComplaint2,
                openComplaint3,
                openComplaint4,
                openComplaint5,
                openComplaint6
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                complaintList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(480);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        // =====================================================
        // OPEN BUTTON
        // =====================================================

        openBtn.setOnAction(e -> {

            complaintList.getChildren().clear();

            complaintList.getChildren().addAll(
                    openComplaint1,
                    openComplaint2,
                    openComplaint3,
                    openComplaint4,
                    openComplaint5,
                    openComplaint6
            );

            openBtn.setStyle(activeStyle);
            progressBtn.setStyle(normalStyle);
            resolvedBtn.setStyle(normalStyle);
        });


        // =====================================================
        // IN PROGRESS BUTTON
        // =====================================================

        progressBtn.setOnAction(e -> {

            complaintList.getChildren().clear();

            complaintList.getChildren().addAll(
                    progressComplaint1,
                    progressComplaint2,
                    progressComplaint3,
                    progressComplaint4
            );

            openBtn.setStyle(normalStyle);
            progressBtn.setStyle(activeStyle);
            resolvedBtn.setStyle(normalStyle);
        });


        // =====================================================
        // RESOLVED BUTTON
        // =====================================================

        resolvedBtn.setOnAction(e -> {

            complaintList.getChildren().clear();

            complaintList.getChildren().addAll(
                    resolvedComplaint1,
                    resolvedComplaint2,
                    resolvedComplaint3,
                    resolvedComplaint4,
                    resolvedComplaint5,
                    resolvedComplaint6,
                    resolvedComplaint7,
                    resolvedComplaint8,
                    resolvedComplaint9,
                    resolvedComplaint10,
                    resolvedComplaint11,
                    resolvedComplaint12,
                    resolvedComplaint13
            );

            openBtn.setStyle(normalStyle);
            progressBtn.setStyle(normalStyle);
            resolvedBtn.setStyle(activeStyle);
        });


        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn =
                new Button("View All Complaints");

        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;" +
                "-fx-cursor:hand;"
        );


        // SAME SCENE POPUP

        viewAllBtn.setOnAction(
                e -> openAllComplaintsDialog()
        );


        // =====================================================
        // ADD MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                heading,
                complaintHeader,
                tabs,
                scrollPane,
                viewAllBtn
        );


        // =====================================================
        // MAIN ROOT
        // =====================================================

        HBox mainRoot =
                new HBox();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );


        // =====================================================
        // ROOT STACKPANE
        // =====================================================

        rootStack =
                new StackPane();

        rootStack.getChildren().add(
                mainRoot
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

        manageComplaintsScene =
                scene;

        return manageComplaintsScene;
    }


    // =========================================================
    // ADD COMPLAINT POPUP
    // =========================================================

    private void openAddComplaintDialog() {

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );


        VBox formBox =
                new VBox(15);

        formBox.setPadding(
                new Insets(30)
        );

        formBox.setMaxWidth(450);
        formBox.setMaxHeight(500);

        formBox.setStyle("""
            -fx-background-color:#ffffff;
            -fx-background-radius:20;
            -fx-effect:dropshadow(
                three-pass-box,
                rgba(0,0,0,0.3),
                20,
                0,
                0,
                5
            );
        """);


        // =====================================================
        // HEADER
        // =====================================================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label popupTitle =
                new Label("Add New Complaint");

        popupTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button closeBtn =
                new Button("✕");

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );


        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeBtn
        );


        // =====================================================
        // COMPLAINT FIELD
        // =====================================================

        Label complaintLabel =
                new Label("Complaint");

        TextField complaintField =
                new TextField();

        complaintField.setPromptText(
                "Enter complaint"
        );

        complaintField.setPrefHeight(40);


        // =====================================================
        // FLAT FIELD
        // =====================================================

        Label flatLabel =
                new Label("Flat Number");

        TextField flatField =
                new TextField();

        flatField.setPromptText(
                "Enter flat number"
        );

        flatField.setPrefHeight(40);


        // =====================================================
        // DATE FIELD
        // =====================================================

        Label dateLabel =
                new Label("Date");

        TextField dateField =
                new TextField();

        dateField.setPromptText(
                "Enter date"
        );

        dateField.setPrefHeight(40);


        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label descriptionLabel =
                new Label("Description");

        TextField descriptionField =
                new TextField();

        descriptionField.setPromptText(
                "Enter complaint description"
        );

        descriptionField.setPrefHeight(60);


        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button saveBtn =
                new Button("Save Complaint");

        saveBtn.setPrefWidth(140);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );


        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        cancelBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        saveBtn.setOnAction(e -> {

            // Firebase save code can be added here later

            removeOverlay(overlay);
        });


        // =====================================================
        // ADD FORM CONTENT
        // =====================================================

        formBox.getChildren().addAll(

                headerRow,

                complaintLabel,
                complaintField,

                flatLabel,
                flatField,

                dateLabel,
                dateField,

                descriptionLabel,
                descriptionField,

                buttonBox
        );


        overlay.getChildren().add(
                formBox
        );


        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );


        // IMPORTANT
        // Popup same scene ke andar add hoga

        rootStack.getChildren().add(
                overlay
        );
    }


    // =========================================================
    // VIEW ALL COMPLAINTS POPUP
    // =========================================================

    private void openAllComplaintsDialog() {

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );


        VBox formBox =
                new VBox(15);

        formBox.setPadding(
                new Insets(25)
        );

        formBox.setMaxWidth(650);
        formBox.setMaxHeight(600);

        formBox.setStyle("""
            -fx-background-color:#ffffff;
            -fx-background-radius:20;
            -fx-effect:dropshadow(
                three-pass-box,
                rgba(0,0,0,0.3),
                20,
                0,
                0,
                5
            );
        """);


        // =====================================================
        // HEADER
        // =====================================================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label popupTitle =
                new Label("All Complaints");

        popupTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button closeBtn =
                new Button("✕");

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );


        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeBtn
        );


        // =====================================================
        // ALL COMPLAINTS
        // =====================================================

        VBox allComplaints =
                new VBox(12);

        allComplaints.getChildren().addAll(

                createComplaint(
                        "Water Leakage in Bathroom",
                        "B-402",
                        "10 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                ),

                createComplaint(
                        "Parking Issue",
                        "C-203",
                        "09 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                ),

                createComplaint(
                        "Lift Noise Problem",
                        "A-204",
                        "09 May 2025",
                        "Open",
                        "#FFF0D9",
                        "#C47A20"
                ),

                createComplaint(
                        "Lift Not Working",
                        "A-101",
                        "10 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                ),

                createComplaint(
                        "Water Tank Cleaning",
                        "B-305",
                        "08 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                ),

                createComplaint(
                        "Garden Maintenance",
                        "C-102",
                        "07 May 2025",
                        "In Progress",
                        "#E7F0FF",
                        "#3478C9"
                ),

                createComplaint(
                        "Garbage Not Collected",
                        "B-305",
                        "09 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                ),

                createComplaint(
                        "Water Pressure Issue",
                        "C-201",
                        "06 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                ),

                createComplaint(
                        "Parking Light Issue",
                        "B-201",
                        "05 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                ),

                createComplaint(
                        "Lift Button Issue",
                        "C-302",
                        "03 May 2025",
                        "Resolved",
                        "#E5F7EC",
                        "#2E9D63"
                )
        );


        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane popupScroll =
                new ScrollPane();

        popupScroll.setContent(
                allComplaints
        );

        popupScroll.setFitToWidth(true);

        popupScroll.setPrefHeight(430);

        popupScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        // =====================================================
        // CLOSE BUTTON
        // =====================================================

        Button closeButton =
                new Button("Close");

        closeButton.setPrefWidth(100);
        closeButton.setPrefHeight(40);

        closeButton.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        closeButton.setOnAction(
                e -> removeOverlay(overlay)
        );


        HBox buttonBox =
                new HBox(closeButton);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        // =====================================================
        // ADD CONTENT
        // =====================================================

        formBox.getChildren().addAll(
                headerRow,
                popupScroll,
                buttonBox
        );


        overlay.getChildren().add(
                formBox
        );


        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );


        // SAME SCENE

        rootStack.getChildren().add(
                overlay
        );
    }


    // =========================================================
    // REMOVE POPUP
    // =========================================================

    private void removeOverlay(
            StackPane overlay) {

        rootStack.getChildren().remove(
                overlay
        );
    }


    // =========================================================
    // COMPLAINT CARD
    // =========================================================

    private VBox createComplaint(
            String complaintTitle,
            String flatNo,
            String date,
            String statusText,
            String statusBackground,
            String statusColor) {


        VBox complaint =
                new VBox(10);

        complaint.setPadding(
                new Insets(18)
        );

        complaint.setPrefHeight(85);

        complaint.setMaxWidth(1180);

        complaint.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


        // =====================================================
        // COMPLAINT TITLE
        // =====================================================

        Label title =
                new Label(complaintTitle);

        title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        // =====================================================
        // DETAILS
        // =====================================================

        Label details =
                new Label(
                        "Flat: " +
                        flatNo +
                        "    |    " +
                        date
                );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        // =====================================================
        // STATUS
        // =====================================================

        Label status =
                new Label(statusText);

        status.setStyle(
                "-fx-background-color:" +
                statusBackground +
                ";" +
                "-fx-text-fill:" +
                statusColor +
                ";" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 10px;" +
                "-fx-background-radius:12;"
        );


        // =====================================================
        // BOTTOM ROW
        // =====================================================

        HBox bottom =
                new HBox();

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                details,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                details,
                status
        );


        complaint.getChildren().addAll(
                title,
                bottom
        );


        return complaint;
    }
}