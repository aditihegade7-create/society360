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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageComplaints {

    // Private Scene variable
    private Scene manageComplaintsScene;

    public Scene createScene(Stage stage) {

        // SIDEBAR

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);
        mainvb.setStyle("-fx-background-color:#b3adad;");

        // HEADING

        Label heading =   new Label("MANAGE COMPLAINTS");
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        // TITLE

        Label title = new Label("Manage Complaints");
               
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


        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(
                title,
                subtitle
        );


        Button addComplaintBtn = new Button("+ Add Complaint");

                addComplaintBtn.setPrefWidth(150);
                addComplaintBtn.setPrefHeight(40);

                addComplaintBtn.setStyle(
                        "-fx-background-color:#434141;" +
                        "-fx-text-fill:white;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:7;"
                );

                addComplaintBtn.setOnAction(e -> {

        Stage popupStage = new Stage();

        VBox popup = new VBox(15);

        popup.setPadding(new Insets(25));
        popup.setAlignment(Pos.CENTER_LEFT);

        popup.setPrefWidth(450);
        popup.setPrefHeight(470);

        popup.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;"
        );

        Label popupTitle = new Label("Add New Complaint");

        popupTitle.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label complaintLabel = new Label("Complaint");

        TextField complaintField = new TextField();
        complaintField.setPromptText("Enter complaint");
        complaintField.setPrefHeight(40);

        Label flatLabel = new Label("Flat Number");

        TextField flatField = new TextField();
        flatField.setPromptText("Enter flat number");
        flatField.setPrefHeight(40);

        Label dateLabel = new Label("Date");

        TextField dateField = new TextField();
        dateField.setPromptText("Enter date");
        dateField.setPrefHeight(40);

        Label descriptionLabel = new Label("Description");

        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Enter complaint description");
        descriptionField.setPrefHeight(70);

        Button cancelBtn = new Button("Cancel");

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;"
        );

    Button saveBtn = new Button("Save Complaint");

    saveBtn.setPrefWidth(140);
    saveBtn.setPrefHeight(40);

    saveBtn.setStyle(
            "-fx-background-color:#2E9D63;" +
            "-fx-text-fill:white;" +
            "-fx-font-weight:bold;" +
            "-fx-background-radius:8;"
    );

    HBox buttonBox = new HBox(10);

    buttonBox.setAlignment(Pos.CENTER_RIGHT);

    buttonBox.getChildren().addAll(
            cancelBtn,
            saveBtn
    );

    popup.getChildren().addAll(
            popupTitle,

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

    Scene popupScene = new Scene(popup);

    popupStage.setTitle("Add Complaint");
    popupStage.setScene(popupScene);
    popupStage.setResizable(false);

    cancelBtn.setOnAction(event -> {
        popupStage.close();
    });

    saveBtn.setOnAction(event -> {
        popupStage.close();
    });

    popupStage.show();
});

                HBox complaintHeader = new HBox();

                complaintHeader.setAlignment(Pos.CENTER_LEFT);

                HBox.setHgrow(titleBox, Priority.ALWAYS);

                complaintHeader.getChildren().addAll(
                        titleBox,
                        addComplaintBtn
                );

        // STATUS BUTTONS

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

        // BUTTON STYLES

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#777777;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;";


        String activeStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-width:0 0 2 0;";


        openBtn.setStyle(activeStyle);
        progressBtn.setStyle(normalStyle);
        resolvedBtn.setStyle(normalStyle);

        // TABS

        HBox tabs = new HBox(25);
        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                openBtn,
                progressBtn,
                resolvedBtn
        );

        // COMPLAINT LIST

        VBox complaintList =
                new VBox(15);

        complaintList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // OPEN - 6 COMPLAINTS

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


        // IN PROGRESS - 4 COMPLAINTS

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


        // RESOLVED - 20 COMPLAINTS

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


        // SCROLL PANE

        ScrollPane scrollPane =  new ScrollPane();

              
        scrollPane.setContent(
                complaintList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(480);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // SHOW OPEN COMPLAINTS BY DEFAULT

        complaintList.getChildren().addAll(
                openComplaint1,
                openComplaint2,
                openComplaint3,
                openComplaint4,
                openComplaint5,
                openComplaint6
        );

        // OPEN BUTTON

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

        // IN PROGRESS BUTTON

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

        // RESOLVED BUTTON

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

        // VIEW ALL BUTTON

        Button viewAllBtn =   new Button("View All Complaints");
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

        viewAllBtn.setOnAction(e -> {

        Stage popupStage = new Stage();

        VBox popup = new VBox(15);

        popup.setPadding(new Insets(25));
        popup.setAlignment(Pos.TOP_LEFT);

        popup.setPrefWidth(600);
        popup.setPrefHeight(550);

        popup.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;"
        );

        Label popupTitle = new Label("All Complaints");

        popupTitle.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        VBox allComplaints = new VBox(12);

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
                )
        );

        ScrollPane popupScroll = new ScrollPane();

        popupScroll.setContent(allComplaints);

        popupScroll.setFitToWidth(true);

        popupScroll.setPrefHeight(420);

        popupScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        Button closeBtn = new Button("Close");

        closeBtn.setPrefWidth(100);
        closeBtn.setPrefHeight(40);

        closeBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        HBox buttonBox = new HBox(closeBtn);

        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        popup.getChildren().addAll(
                popupTitle,
                popupScroll,
                buttonBox
        );

        Scene popupScene = new Scene(popup);

        popupStage.setTitle("All Complaints");
        popupStage.setScene(popupScene);
        popupStage.setResizable(false);

        closeBtn.setOnAction(event -> {
                popupStage.close();
        });

        popupStage.show();
        });

        // MAIN CONTENT

        mainvb.getChildren().addAll(
                heading,
                complaintHeader,
                tabs,
                scrollPane,
                viewAllBtn
        );

        // ROOT

        HBox root = new HBox();
        root.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        root.getChildren().addAll(sidebar,mainvb);
        root.setStyle("-fx-background-color::#434141;");
        HBox.setHgrow(mainvb,Priority.ALWAYS);


        // SCENE

        // manageComplaintsScene = new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        manageComplaintsScene = scene;

        return manageComplaintsScene;
    }

    // COMPLAINT CARD METHOD

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

        // COMPLAINT TITLE

        Label title =
                new Label(complaintTitle);
        title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // DETAILS

        Label details =
                new Label(
                        "Flat: " + flatNo +
                        "    |    " +
                        date
                );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // STATUS

        Label status =  new Label(statusText);
        status.setStyle(
                "-fx-background-color:" +
                statusBackground + ";" +
                "-fx-text-fill:" +
                statusColor + ";" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 10px;" +
                "-fx-background-radius:12;"
        );

        // BOTTOM ROW

        HBox bottom =  new HBox();              
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