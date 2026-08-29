package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;
import com.society.view.Resident_portal.Bills;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenerateReports {

    private Scene generateReportsScene;

    public Scene createScene(Stage stage) {

       
        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25, 35, 25, 35));
        mainvb.setSpacing(20);
        mainvb.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        GenerateReports.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, false, true
                )
        );

        mainvb.setBackground(new Background(backgroundImage));
       

        Label heading = new Label("GENERATE REPORTS");               
        heading.setStyle("-fx-font-size:18px;-fx-font-weight:bold;-fx-text-fill:#434141;");


        Label title =   new Label("Generate Reports");              
        title.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-text-fill:#123C36;");
        Label subtitle =   new Label("Generate and view society management reports");
        subtitle.setStyle("-fx-font-size:13px;-fx-text-fill:black");
        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // REPORT CARDS

        HBox row1 = new HBox(20);
        HBox row2 = new HBox(20);
        row1.setAlignment(Pos.CENTER_LEFT);
        row2.setAlignment(Pos.CENTER_LEFT);

        VBox residentReport =
                createReportCard(
                        "Resident Report",
                        "View total residents and resident details"
                );


        VBox paymentReport =
                createReportCard(
                        "Payment Report",
                        "View pending, paid and overdue payments"
                );

        VBox complaintReport =
                createReportCard(
                        "Complaint Report",
                        "View resident complaints and their status"
                );


        VBox visitorReport =
                createReportCard(
                        "Visitor Report",
                        "View visitor entry and exit records"
                );


        VBox eventReport =
                createReportCard(
                        "Event Report",
                        "View upcoming and completed events"
                );


        VBox maintenanceReport =
                createReportCard(
                        "Maintenance Report",
                        "View society maintenance records"
                );


        row1.getChildren().addAll(
                residentReport,
                paymentReport,
                complaintReport
        );


        row2.getChildren().addAll(
                visitorReport,
                eventReport,
                maintenanceReport
        );


        // DOWNLOAD / GENERATE BUTTON

        Button generateBtn =
                new Button("Generate Report");
        generateBtn.setPrefWidth(1180);
        generateBtn.setPrefHeight(45);
        generateBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // ADD EVERYTHING TO MAIN

        mainvb.getChildren().addAll(
                heading,
                titleBox,
                row1,
                row2,
                generateBtn
        );

        // ROOT

        HBox root =
                new HBox();

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        // generateReportsScene =
        //         new Scene(root, 1500, 750);

         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        generateReportsScene = scene;
        return generateReportsScene;
    }


    private VBox createReportCard(
            String reportName,
            String description) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(20)
        );

        card.setPrefWidth(370);
        card.setPrefHeight(135);

        card.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


        Label name =
                new Label(reportName);

        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label details =
                new Label(description);

        details.setWrapText(true);

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        Button viewBtn =
                new Button("View Report");

        viewBtn.setPrefWidth(110);
        viewBtn.setPrefHeight(30);

        viewBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:6;"
        );


        card.getChildren().addAll(
                name,
                details,
                viewBtn
        );


        return card;
    }
}