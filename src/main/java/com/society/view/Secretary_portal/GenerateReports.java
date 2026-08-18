package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenerateReports {

    private Scene generateReportsScene;

    public Scene createScene(Stage stage) {

        // ================= SIDEBAR =================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);


        // ================= MAIN CONTENT =================

        VBox mainvb = new VBox(20);

        mainvb.setPadding(new Insets(25));
        mainvb.setMaxWidth(Double.MAX_VALUE);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // ================= HEADING =================

        Label heading = new Label("GENERATE REPORTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        // ================= TITLE =================

        Label title = new Label("Generate Reports");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label subtitle =
                new Label("Generate and view society management reports");

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:black;"
        );


        VBox titleBox = new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );


        // ================= STACKPANE =================

        StackPane contentPane = new StackPane();

        contentPane.getChildren().add(mainvb);


        // ================= REPORT CARDS =================

        HBox row1 = new HBox(20);
        HBox row2 = new HBox(20);

        row1.setAlignment(Pos.CENTER_LEFT);
        row2.setAlignment(Pos.CENTER_LEFT);


        // Resident Report

        VBox residentReport =
                createReportCard(
                        "Resident Report",
                        "View total residents and resident details",
                        contentPane
                );


        // Payment Report

        VBox paymentReport =
                createReportCard(
                        "Payment Report",
                        "View pending, paid and overdue payments",
                        contentPane
                );


        // Complaint Report

        VBox complaintReport =
                createReportCard(
                        "Complaint Report",
                        "View resident complaints and their status",
                        contentPane
                );


        // Visitor Report

        VBox visitorReport =
                createReportCard(
                        "Visitor Report",
                        "View visitor entry and exit records",
                        contentPane
                );


        // Event Report

        VBox eventReport =
                createReportCard(
                        "Event Report",
                        "View upcoming and completed events",
                        contentPane
                );


        // Maintenance Report

        VBox maintenanceReport =
                createReportCard(
                        "Maintenance Report",
                        "View society maintenance records",
                        contentPane
                );


        // ================= ADD CARDS TO ROWS =================

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


        // ================= GENERATE BUTTON =================

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


        // ================= MAIN CONTENT =================

        mainvb.getChildren().addAll(
                heading,
                titleBox,
                row1,
                row2,
                generateBtn
        );


        // ================= ROOT =================

        HBox root = new HBox();

        root.getChildren().addAll(
                sidebar,
                contentPane
        );

        HBox.setHgrow(
                contentPane,
                Priority.ALWAYS
        );


        // ================= SCENE =================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        generateReportsScene = scene;
        return generateReportsScene;
    }

      //  REPORT CARD METHOD
    

    private VBox createReportCard(
            String reportName,
            String description,
            StackPane contentPane) {


        // ================= CARD =================

        VBox card = new VBox(10);

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


        // ================= REPORT NAME =================

        Label name =
                new Label(reportName);

        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        // ================= DESCRIPTION =================

        Label details =
                new Label(description);

        details.setWrapText(true);

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        // ================= VIEW BUTTON =================

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


        // =====================================================
        //                  BUTTON CLICK
        // =====================================================

        viewBtn.setOnAction(e -> {


            // ================= POPUP =================

            VBox reportPopup =
                    new VBox(15);

            reportPopup.setPrefWidth(400);
            reportPopup.setMaxWidth(400);

            reportPopup.setPrefHeight(250);
            reportPopup.setMaxHeight(250);

            reportPopup.setPadding(
                    new Insets(25)
            );

            reportPopup.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:12;" +
                    "-fx-border-color:#DDDDDD;" +
                    "-fx-border-radius:12;"
            );


            // ================= POPUP TITLE =================

            Label popupTitle =
                    new Label(reportName);

            popupTitle.setStyle(
                    "-fx-font-size:20px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );


            // ================= POPUP DESCRIPTION =================

            Label popupText =
                    new Label(description);

            popupText.setWrapText(true);

            popupText.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-text-fill:#666666;"
            );


            // ================= REPORT INFORMATION =================

            Label reportInfo =
                    new Label(
                            "Report details will be displayed here."
                    );

            reportInfo.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-text-fill:#555555;"
            );


            // ================= CLOSE BUTTON =================

            Button closeBtn =
                    new Button("Close");

            closeBtn.setPrefWidth(90);
            closeBtn.setPrefHeight(35);

            closeBtn.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:7;"
            );


            // ================= CLOSE ACTION =================

            closeBtn.setOnAction(
                    event -> contentPane
                            .getChildren()
                            .remove(reportPopup)
            );


            // ================= ADD POPUP CONTENT =================

            reportPopup.getChildren().addAll(
                    popupTitle,
                    popupText,
                    reportInfo,
                    closeBtn
            );


            // ================= SHOW POPUP =================

            contentPane.getChildren().add(
                    reportPopup
            );


            StackPane.setAlignment(
                    reportPopup,
                    Pos.CENTER
            );
        });


        // ================= ADD CARD CONTENT =================

        card.getChildren().addAll(
                name,
                details,
                viewBtn
        );


        return card;
    }
}

