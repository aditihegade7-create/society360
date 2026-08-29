package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenerateReports {

    private Scene generateReportsScene;

    public Scene createScene(Stage stage) {

        
        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);
         BorderPane mainArea = new BorderPane();
        
         Label heading = new Label("GENERATE REPORTS");
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:white;"
        );

        Label subtitle = new Label(
                "Generate and view society management reports"
        );

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:white;"
        );

        VBox headerText = new VBox(4);

        headerText.setAlignment(
                Pos.CENTER_LEFT
        );

        headerText.getChildren().addAll(
                heading,
                subtitle
        );

        HBox header = new HBox();

        header.setPrefHeight(80);
        header.setMinHeight(80);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPadding(
                new Insets(25, 35, 25, 35)
        );

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );

        header.getChildren().add(
                headerText
        );

        
        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(25)
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

       
        Label title = new Label("Reports");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label pageSubtitle = new Label(
                "Select a report to view society information"
        );

        pageSubtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        VBox titleBox = new VBox(5);

        titleBox.getChildren().addAll(
                title,
                pageSubtitle
        );

       
        HBox row1 = new HBox(20);

        row1.setAlignment(
                Pos.CENTER_LEFT
        );

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

        row1.getChildren().addAll(
                residentReport,
                paymentReport,
                complaintReport
        );

        
        HBox row2 = new HBox(20);

        row2.setAlignment(
                Pos.CENTER_LEFT
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

        row2.getChildren().addAll(
                visitorReport,
                eventReport,
                maintenanceReport
        );

        
        Button generateBtn =
                new Button("Generate Report");

        generateBtn.setMaxWidth(
                Double.MAX_VALUE
        );

        generateBtn.setPrefHeight(45);

        generateBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        
        mainContent.getChildren().addAll(
                titleBox,
                row1,
                row2,
                generateBtn
        );

       

        mainArea.setTop(header);
        mainArea.setCenter(mainContent);

        
        HBox root = new HBox();

        root.getChildren().addAll(
                sidebar,
                mainArea
        );

        HBox.setHgrow(
                mainArea,
                Priority.ALWAYS
        );

        
        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        generateReportsScene = scene;

        return generateReportsScene;
    }

    

    private VBox createReportCard(
            String reportName,
            String description) {

        VBox card = new VBox(10);

        card.setPadding(
                new Insets(20)
        );

        card.setPrefWidth(370);
        card.setMinWidth(370);

        card.setPrefHeight(135);

        card.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        
        Label name = new Label(
                reportName
        );

        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

       
        Label details = new Label(
                description
        );

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
                "-fx-background-color: #4e342e;" +
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