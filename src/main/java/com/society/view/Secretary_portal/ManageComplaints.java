package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageComplaints {

    // Scene
    private Scene manageComplaintsScene;

    public Scene createScene(Stage stage) {

       

        BorderPane root = new BorderPane();

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);
        root.setLeft(sidebar);

       BorderPane mainarea = new BorderPane();
       HBox header = new HBox();

        header.setPrefWidth(900);
        header.setPrefHeight(80);

        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setPadding(
                new Insets(20)
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );


        
        VBox headerText = new VBox(4);

        Label greeting = new Label(
                "Manage Complaints"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label description = new Label(
                "Track and resolve resident complaints"
        );

        description.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#ffffff;"
        );


        headerText.getChildren().addAll(
                greeting,
                description
        );


       
        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        
        Label day = new Label();

        Label date = new Label();

        LocalDate today = LocalDate.now();


        day.setText(
                today.format(
                        DateTimeFormatter.ofPattern("EEEE")
                )
        );


        date.setText(
                today.format(
                        DateTimeFormatter.ofPattern("dd MMMM yyyy")
                )
        );


        day.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        date.setStyle(
                "-fx-text-fill:#ffffff;"
        );


        VBox dateBox = new VBox(4);

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        dateBox.getChildren().addAll(
                day,
                date
        );


        
        header.getChildren().addAll(
                headerText,
                spacer,
                dateBox
        );


        
        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(25, 30, 25, 30)
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );
        

        
        Button openBtn = new Button(
                "Open (6)"
        );

        Button progressBtn = new Button(
                "In Progress (4)"
        );

        Button resolvedBtn = new Button(
                "Resolved (13)"
        );


        openBtn.setPrefWidth(150);
        openBtn.setPrefHeight(40);

        progressBtn.setPrefWidth(150);
        progressBtn.setPrefHeight(40);

        resolvedBtn.setPrefWidth(150);
        resolvedBtn.setPrefHeight(40);


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


        openBtn.setStyle(
                activeStyle
        );

        progressBtn.setStyle(
                normalStyle
        );

        resolvedBtn.setStyle(
                normalStyle
        );


        

        HBox tabs = new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                openBtn,
                progressBtn,
                resolvedBtn
        );


       
        VBox complaintList = new VBox(15);

        complaintList.setPadding(
                new Insets(5, 0, 5, 0)
        );


        
        VBox openComplaint1 = createComplaint(
                "Water Leakage in Bathroom",
                "B-402",
                "10 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


        VBox openComplaint2 = createComplaint(
                "Parking Issue",
                "C-203",
                "09 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


        VBox openComplaint3 = createComplaint(
                "Lift Noise Problem",
                "A-204",
                "09 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


        VBox openComplaint4 = createComplaint(
                "Cleaning Issue",
                "B-105",
                "08 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


        VBox openComplaint5 = createComplaint(
                "Water Tap Leakage",
                "C-301",
                "07 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


        VBox openComplaint6 = createComplaint(
                "Security Gate Issue",
                "A-402",
                "06 May 2025",
                "Open",
                "#FFF0D9",
                "#C47A20"
        );


       
        VBox progressComplaint1 = createComplaint(
                "Lift Not Working",
                "A-101",
                "10 May 2025",
                "In Progress",
                "#E7F0FF",
                "#3478C9"
        );


        VBox progressComplaint2 = createComplaint(
                "Water Tank Cleaning",
                "B-305",
                "08 May 2025",
                "In Progress",
                "#E7F0FF",
                "#3478C9"
        );


        VBox progressComplaint3 = createComplaint(
                "Garden Maintenance",
                "C-102",
                "07 May 2025",
                "In Progress",
                "#E7F0FF",
                "#3478C9"
        );


        VBox progressComplaint4 = createComplaint(
                "Common Area Light",
                "A-302",
                "06 May 2025",
                "In Progress",
                "#E7F0FF",
                "#3478C9"
        );


       
        VBox resolvedComplaint1 = createComplaint(
                "Garbage Not Collected",
                "B-305",
                "09 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint2 = createComplaint(
                "Water Pressure Issue",
                "C-201",
                "06 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint3 = createComplaint(
                "Parking Light Issue",
                "B-201",
                "05 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint4 = createComplaint(
                "Lift Button Issue",
                "C-302",
                "03 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint5 = createComplaint(
                "Corridor Cleaning",
                "B-104",
                "02 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint6 = createComplaint(
                "Water Pipe Issue",
                "A-202",
                "01 May 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint7 = createComplaint(
                "Parking Space Issue",
                "C-103",
                "30 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint8 = createComplaint(
                "Staircase Light",
                "B-203",
                "29 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint9 = createComplaint(
                "Society Gate Issue",
                "A-301",
                "28 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint10 = createComplaint(
                "Basement Cleaning",
                "B-301",
                "23 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint11 = createComplaint(
                "Security Camera Issue",
                "A-102",
                "22 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint12 = createComplaint(
                "Terrace Cleaning",
                "C-302",
                "21 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox resolvedComplaint13 = createComplaint(
                "Electricity Issue",
                "A-204",
                "19 Apr 2025",
                "Resolved",
                "#E5F7EC",
                "#2E9D63"
        );


        
        complaintList.getChildren().addAll(
                openComplaint1,
                openComplaint2,
                openComplaint3,
                openComplaint4,
                openComplaint5,
                openComplaint6
        );


       
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                complaintList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(480);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        
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

            openBtn.setStyle(
                    activeStyle
            );

            progressBtn.setStyle(
                    normalStyle
            );

            resolvedBtn.setStyle(
                    normalStyle
            );
        });


        
        progressBtn.setOnAction(e -> {

            complaintList.getChildren().clear();

            complaintList.getChildren().addAll(
                    progressComplaint1,
                    progressComplaint2,
                    progressComplaint3,
                    progressComplaint4
            );

            openBtn.setStyle(
                    normalStyle
            );

            progressBtn.setStyle(
                    activeStyle
            );

            resolvedBtn.setStyle(
                    normalStyle
            );
        });


        

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

            openBtn.setStyle(
                    normalStyle
            );

            progressBtn.setStyle(
                    normalStyle
            );

            resolvedBtn.setStyle(
                    activeStyle
            );
        });


        
        Button viewAllBtn = new Button(
                "View All Complaints"
        );

        viewAllBtn.setPrefWidth(1180);

        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );


        
        mainContent.getChildren().addAll(
               
                
                tabs,
                scrollPane,
                viewAllBtn
        );


        
        mainarea.setTop(header);

        mainarea.setCenter(mainContent);


        root.setCenter(mainarea);
        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageComplaintsScene = scene;

        return manageComplaintsScene;
    }


    private VBox createComplaint(
            String complaintTitle,
            String flatNo,
            String date,
            String statusText,
            String statusBackground,
            String statusColor) {


        VBox complaint = new VBox(10);

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


        

        Label title = new Label(
                complaintTitle
        );

        title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


       
        Label details = new Label(
                "Flat: " + flatNo +
                "    |    " +
                date
        );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );



        Label status = new Label(
                statusText
        );

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


        HBox bottom = new HBox();

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