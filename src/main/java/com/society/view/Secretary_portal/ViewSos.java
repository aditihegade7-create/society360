package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewSos {

    // Private Scene variable
    private Scene viewSosScene;

    public Scene createScene(Stage stage) {


        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // HEADING

        Label heading =
                new Label("VIEW SOS ALERTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // TITLE

        Label title = new Label("SOS Alerts");
        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label(
                        "View and manage emergency alerts from residents"
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

        // FILTER BUTTONS


        Button activeBtn =  new Button("Active (3)");
        Button resolvedBtn = new Button("Resolved (5)");              
        Button allBtn = new Button("All Alerts");
                
        activeBtn.setPrefWidth(140);
        activeBtn.setPrefHeight(40);

        resolvedBtn.setPrefWidth(140);
        resolvedBtn.setPrefHeight(40);

        allBtn.setPrefWidth(140);
        allBtn.setPrefHeight(40);


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


        activeBtn.setStyle(activeStyle);
        resolvedBtn.setStyle(normalStyle);
        allBtn.setStyle(normalStyle);


        HBox tabs = new HBox(25);              
        tabs.setAlignment(Pos.CENTER_LEFT);
        tabs.getChildren().addAll(
                activeBtn,
                resolvedBtn,
                allBtn
        );

        // SOS LIST

        VBox sosList =  new VBox(15);              
        sosList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // ACTIVE ALERTS

        VBox sos1 = createSos(
                "Diya Wadhwa",
                "B-402",
                "Medical Emergency",
                "10:30 AM",
                "Active"
        );

        VBox sos2 = createSos(
                "Rahul Sharma",
                "A-101",
                "Security Emergency",
                "11:15 AM",
                "Active"
        );

        VBox sos3 = createSos(
                "Neha Patil",
                "C-203",
                "Medical Emergency",
                "12:05 PM",
                "Active"
        );

        // RESOLVED ALERTS

        VBox sos4 = createSos(
                "Amit Kulkarni",
                "B-305",
                "Medical Emergency",
                "09:20 AM",
                "Resolved"
        );

        VBox sos5 = createSos(
                "Pooja Singh",
                "A-503",
                "Security Emergency",
                "08:45 AM",
                "Resolved"
        );

        VBox sos6 = createSos(
                "Rohan Joshi",
                "C-102",
                "Other Emergency",
                "07:30 AM",
                "Resolved"
        );

        VBox sos7 = createSos(
                "Sneha Patil",
                "A-204",
                "Medical Emergency",
                "06:50 AM",
                "Resolved"
        );

        VBox sos8 = createSos(
                "Kunal Shah",
                "B-201",
                "Security Emergency",
                "06:15 AM",
                "Resolved"
        );

        // SHOW ACTIVE BY DEFAULT

        sosList.getChildren().addAll(
                sos1,
                sos2,
                sos3
        );

        // SCROLL PANE

        ScrollPane scrollPane =  new ScrollPane();
        scrollPane.setContent(sosList);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // ACTIVE BUTTON

        activeBtn.setOnAction(e -> {

            sosList.getChildren().clear();
            sosList.getChildren().addAll(
                    sos1,
                    sos2,
                    sos3
            );

            activeBtn.setStyle(activeStyle);
            resolvedBtn.setStyle(normalStyle);
            allBtn.setStyle(normalStyle);
        });

        
        // RESOLVED BUTTON
       
        resolvedBtn.setOnAction(e -> {

            sosList.getChildren().clear();
            sosList.getChildren().addAll(
                    sos4,
                    sos5,
                    sos6,
                    sos7,
                    sos8
            );

            activeBtn.setStyle(normalStyle);
            resolvedBtn.setStyle(activeStyle);
            allBtn.setStyle(normalStyle);
        });


        // ALL BUTTON

        allBtn.setOnAction(e -> {

            sosList.getChildren().clear();
            sosList.getChildren().addAll(
                    sos1,
                    sos2,
                    sos3,
                    sos4,
                    sos5,
                    sos6,
                    sos7,
                    sos8
            );

            activeBtn.setStyle(normalStyle);
            resolvedBtn.setStyle(normalStyle);
            allBtn.setStyle(activeStyle);
        });

        // VIEW ALL BUTTON

        Button viewAllBtn =  new Button("View All SOS Alerts");
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

        // ADD EVERYTHING TO MAIN

        mainvb.getChildren().addAll(
                heading,
                titleBox,
                tabs,
                scrollPane,
                viewAllBtn
        );


        // ROOT

        HBox root =  new HBox();
        root.getChildren().addAll(
                sidebar,
                mainvb
        );
         HBox.setHgrow(mainvb, Priority.ALWAYS);


        // SCENE

        // viewSosScene = new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());

                
        viewSosScene = scene;        
        return viewSosScene;
    }

    // SOS CARD METHOD

    private VBox createSos(
            String residentName,
            String flatNo,
            String emergencyType,
            String time,
            String statusText) {


        VBox sos =
                new VBox(10);

        sos.setPadding(
                new Insets(18)
        );

        sos.setPrefHeight(95);
        sos.setMaxWidth(1180);

        sos.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        // TOP ROW

        Label name = new Label(residentName);
        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label status =
                new Label(statusText);

        if (statusText.equals("Active")) {

            status.setStyle(
                    "-fx-background-color:#FDE8E8;" +
                    "-fx-text-fill:#D9534F;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );

        } else {

            status.setStyle(
                    "-fx-background-color:#E5F7EC;" +
                    "-fx-text-fill:#2E9D63;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );
        }


        HBox topRow =  new HBox();
               

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                name,
                Priority.ALWAYS
        );

        topRow.getChildren().addAll(
                name,
                status
        );

        // DETAILS

        Label details =
                new Label(
                        "Flat: " + flatNo +
                        "    |    " +
                        "Emergency: " + emergencyType +
                        "    |    " +
                        "Time: " + time
                );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // ADD TO CARD

        sos.getChildren().addAll(
                topRow,
                details
        );


        return sos;
    }
}