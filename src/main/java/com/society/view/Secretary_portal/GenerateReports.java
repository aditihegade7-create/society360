package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GenerateReports {

    private Scene generateReportsScene;

    // Main StackPane
    private StackPane rootStack;

    public Scene createScene(Stage stage) {

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // HEADING

        Label heading =
                new Label("GENERATE REPORTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // TITLE

        Label title =
                new Label("Generate Reports");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label subtitle =
                new Label(
                        "Generate and view society management reports"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:black;"
        );

        VBox titleBox =
                new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // REPORT ROWS

        HBox row1 =
                new HBox(20);

        HBox row2 =
                new HBox(20);

        row1.setAlignment(
                Pos.CENTER_LEFT
        );

        row2.setAlignment(
                Pos.CENTER_LEFT
        );

        // REPORT CARDS

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

        // GENERATE REPORT BUTTON

        Button generateBtn =
                new Button("Generate Report");

        generateBtn.setPrefWidth(1180);
        generateBtn.setPrefHeight(45);

        generateBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        // CLICK GENERATE REPORT

        generateBtn.setOnAction(
                e -> openGenerateReportDialog()
        );

        // MAIN CONTENT

        mainvb.getChildren().addAll(
                heading,
                titleBox,
                row1,
                row2,
                generateBtn
        );

        // SIDEBAR + MAIN CONTENT

        HBox mainRoot =
                new HBox();

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        // ROOT STACKPANE

        rootStack =
                new StackPane();

        rootStack.getChildren().add(
                mainRoot
        );

        // SCENE

        Scene scene =
                new Scene(
                        rootStack,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        generateReportsScene =
                scene;

        return generateReportsScene;
    }


    // =====================================================
    // REPORT CARD
    // =====================================================

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
                "-fx-background-radius:6;" +
                "-fx-cursor:hand;"
        );

        // VIEW REPORT CLICK

        viewBtn.setOnAction(
                e -> openReportDialog(reportName)
        );

        card.getChildren().addAll(
                name,
                details,
                viewBtn
        );

        return card;
    }


    // =====================================================
    // VIEW REPORT POPUP
    // =====================================================

    private void openReportDialog(
            String reportName) {

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

        formBox.setMaxWidth(500);
        formBox.setMaxHeight(350);

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

        // HEADER

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label title =
                new Label(reportName);

        title.setFont(
                Font.font(
                        "Georgia",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setStyle(
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

        closeBtn.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-cursor:hand;"
        );

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        headerRow.getChildren().addAll(
                title,
                spacer,
                closeBtn
        );

        // SUBTITLE

        Label subtitle =
                new Label(
                        "Society management report"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        // REPORT CONTENT

        VBox reportContent =
                new VBox(12);

        reportContent.setPadding(
                new Insets(20)
        );

        reportContent.setStyle("""
            -fx-background-color:#f5f5f5;
            -fx-background-radius:10;
        """);

        if (reportName.equals("Resident Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Residents : 120"),
                    new Label("Total Owners : 85"),
                    new Label("Total Tenants : 35")
            );

        } else if (reportName.equals("Payment Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Payments : 150"),
                    new Label("Paid Payments : 120"),
                    new Label("Pending Payments : 20"),
                    new Label("Overdue Payments : 10")
            );

        } else if (reportName.equals("Complaint Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Complaints : 25"),
                    new Label("Resolved Complaints : 18"),
                    new Label("Pending Complaints : 7")
            );

        } else if (reportName.equals("Visitor Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Visitors : 75"),
                    new Label("Today's Visitors : 12"),
                    new Label("Exited Visitors : 63")
            );

        } else if (reportName.equals("Event Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Events : 10"),
                    new Label("Upcoming Events : 3"),
                    new Label("Completed Events : 7")
            );

        } else if (reportName.equals("Maintenance Report")) {

            reportContent.getChildren().addAll(
                    new Label("Total Maintenance : 50"),
                    new Label("Completed : 42"),
                    new Label("Pending : 8")
            );
        }

        formBox.getChildren().addAll(
                headerRow,
                subtitle,
                reportContent
        );

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );

        // ADD POPUP ON EXISTING SCENE

        rootStack.getChildren().add(
                overlay
        );
    }


    // =====================================================
    // GENERATE REPORT POPUP
    // =====================================================

    private void openGenerateReportDialog() {

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

        formBox.setMaxWidth(500);
        formBox.setMaxHeight(430);

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

        // HEADER

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label title =
                new Label("Generate Report");

        title.setFont(
                Font.font(
                        "Georgia",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setStyle(
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

        closeBtn.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-cursor:hand;"
        );

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        headerRow.getChildren().addAll(
                title,
                spacer,
                closeBtn
        );

        // SUBTITLE

        Label subtitle =
                new Label(
                        "Select the report you want to generate"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        // OPTIONS

        VBox optionsBox =
                new VBox(10);

        optionsBox.setPadding(
                new Insets(10)
        );

        Button residentBtn =
                createPopupButton(
                        "Resident Report"
                );

        Button paymentBtn =
                createPopupButton(
                        "Payment Report"
                );

        Button complaintBtn =
                createPopupButton(
                        "Complaint Report"
                );

        Button visitorBtn =
                createPopupButton(
                        "Visitor Report"
                );

        Button eventBtn =
                createPopupButton(
                        "Event Report"
                );

        Button maintenanceBtn =
                createPopupButton(
                        "Maintenance Report"
                );

        // BUTTON ACTIONS

        residentBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Resident Report");
        });

        paymentBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Payment Report");
        });

        complaintBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Complaint Report");
        });

        visitorBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Visitor Report");
        });

        eventBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Event Report");
        });

        maintenanceBtn.setOnAction(e -> {
            removeOverlay(overlay);
            openReportDialog("Maintenance Report");
        });

        optionsBox.getChildren().addAll(
                residentBtn,
                paymentBtn,
                complaintBtn,
                visitorBtn,
                eventBtn,
                maintenanceBtn
        );

        formBox.getChildren().addAll(
                headerRow,
                subtitle,
                optionsBox
        );

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );

        // ADD TO SAME SCENE

        rootStack.getChildren().add(
                overlay
        );
    }


    // =====================================================
    // POPUP BUTTON STYLE
    // =====================================================

    private Button createPopupButton(
            String text) {

        Button button =
                new Button(text);

        button.setPrefWidth(400);
        button.setPrefHeight(35);

        button.setStyle(
                "-fx-background-color:#f5f5f5;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        return button;
    }


    // =====================================================
    // REMOVE POPUP
    // =====================================================

    private void removeOverlay(
            StackPane overlay) {

        rootStack.getChildren().remove(
                overlay
        );
    }
}