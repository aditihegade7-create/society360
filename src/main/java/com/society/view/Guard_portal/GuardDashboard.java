package com.society.view.Guard_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardDashboard {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        GuardSidebar sidebar =
                new GuardSidebar(stage, "Dashboard");

        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox();

        mainContent.setPadding(
                new Insets(28, 32, 25, 28)
        );

        mainContent.setSpacing(20);

        mainContent.setFillWidth(true);

        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

        root.setCenter(mainContent);

        Label shiftInfo =
                new Label(
                        "Main Gate    Shift A    (08:00 AM - 04:00 PM)"
                );

        shiftInfo.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #17231F;"
        );

        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color:#b3adad;");

        Label greeting = new Label("Good Morning, Owner");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill:#434141;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));

        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(greeting,
                spacer,
                vb1);


        mainContent.getChildren().add(header);


        VBox activeVisitors =
                createStatCard(
                        "Active Visitors",
                        "24",
                        "+12% from yesterday"
                );


        VBox parking =
                createStatCard(
                        "Parking Occupancy",
                        "142/160",
                        "88% Full"
                );


        VBox approvals =
                createStatCard(
                        "Pending Approvals",
                        "03",
                        "Needs attention"
                );


        VBox sos =
                createStatCard(
                        "SOS Alerts",
                        "01",
                        "High Priority"
                );


        HBox statCards =
                new HBox(20);

        statCards.setAlignment(
                Pos.CENTER_LEFT
        );

        statCards.getChildren().addAll(
                activeVisitors,
                parking,
                approvals,
                sos
        );

        mainContent.getChildren().add(statCards);


        Label quickActionsTitle =
                new Label("Quick Actions");

        quickActionsTitle.setStyle(
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030A12;"
        );


        Label quickActionsSubtitle =
                new Label(
                        "Frequently used gate operations"
                );

        quickActionsSubtitle.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #263B35;"
        );


        VBox quickHeading =
                new VBox(3);

        quickHeading.getChildren().addAll(
                quickActionsTitle,
                quickActionsSubtitle
        );

        Button scanQRButton =
                new Button(
                        "Scan QR Pass\nVisitor Check-in"
                );

        Button manualEntryButton =
                new Button(
                        "Manual Entry\nAdd Visitor"
                );

        Button parkingEntryButton =
                new Button(
                        "Parking Entry\nVehicle In"
                );

        Button emergencySOSButton =
                new Button(
                        "Emergency SOS\nRaise Alert"
                );


        Button[] quickActionButtons = {

                scanQRButton,
                manualEntryButton,
                parkingEntryButton,
                emergencySOSButton

        };


        for (Button button : quickActionButtons) {

            button.setPrefWidth(315);

            button.setPrefHeight(78);

            button.setAlignment(
                    Pos.CENTER_LEFT
            );

            button.setPadding(
                    new Insets(12, 18, 12, 18)
            );

            button.setStyle(
                    "-fx-background-color: #434141;" +
                    "-fx-text-fill: #E8F0E8;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;"
            );


            button.setOnMouseEntered(e -> {

                button.setStyle(
                        "-fx-background-color: #434141;" +
                        "-fx-text-fill: #E8F0E8;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
                );

            });


            button.setOnMouseExited(e -> {

                button.setStyle(
                        "-fx-background-color: #434141;" +
                        "-fx-text-fill: #E8F0E8;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;"
                );

            });
        }


        scanQRButton.setOnAction(e -> {

            stage.setScene(
                    QRScanner.createScene(stage)
            );

        });


        manualEntryButton.setOnAction(e -> {

            stage.setScene(
                    ManualVisitorEntry.createScene(stage)
            );

        });


        parkingEntryButton.setOnAction(e -> {

            stage.setScene(
                    Parking.createScene(stage)
            );

        });


        emergencySOSButton.setOnAction(e -> {

            stage.setScene(
                    EmergencySOS.createScene(stage)
            );

        });


        HBox firstActionRow =
                new HBox(18);

        firstActionRow.getChildren().addAll(
                scanQRButton,
                manualEntryButton
        );


        HBox secondActionRow =
                new HBox(18);

        secondActionRow.getChildren().addAll(
                parkingEntryButton,
                emergencySOSButton
        );


        VBox quickActionsSection =
                new VBox(12);

        quickActionsSection.setPrefWidth(
                650
        );

        quickActionsSection.getChildren().addAll(
                quickHeading,
                firstActionRow,
                secondActionRow
        );


        Label summaryTitle =
                new Label("Today's Summary");

        summaryTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030A12;"
        );


        Label summarySubtitle =
                new Label(
                        "Gate activity for today"
                );

        summarySubtitle.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #52605A;"
        );


        VBox summaryHeading =
                new VBox(3);

        summaryHeading.getChildren().addAll(
                summaryTitle,
                summarySubtitle
        );


        HBox totalVisitorsRow =
                createSummaryRow(
                        "Total Visitors",
                        "36"
                );


        HBox deliveryRow =
                createSummaryRow(
                        "Delivery / Service",
                        "18"
                );


        HBox personalRow =
                createSummaryRow(
                        "Personal / Guest",
                        "12"
                );


        HBox vehiclesRow =
                createSummaryRow(
                        "Vehicles Entered",
                        "28"
                );


        HBox exitsRow =
                createSummaryRow(
                        "Exits",
                        "25"
                );


        VBox summaryBox =
                new VBox(16);

        summaryBox.setPadding(
                new Insets(20)
        );

        summaryBox.setPrefWidth(
                475
        );

        summaryBox.setPrefHeight(
                265
        );

        summaryBox.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 10;"
        );


        summaryBox.getChildren().addAll(
                summaryHeading,
                totalVisitorsRow,
                deliveryRow,
                personalRow,
                vehiclesRow,
                exitsRow
        );


        HBox lowerSection =
                new HBox(28);

        lowerSection.setAlignment(
                Pos.TOP_LEFT
        );

        lowerSection.getChildren().addAll(
                quickActionsSection,
                summaryBox
        );


        mainContent.getChildren().add(
                lowerSection
        );

        VBox noticeContent =
                new VBox(4);


        Label noticeLabel =
                new Label("IMPORTANT NOTICE");

        noticeLabel.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #183A2D;"
        );


        Label noticeText =
                new Label(
                        "Fire Drill scheduled today at 3:00 PM."
                );

        noticeText.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #050605;"
        );


        Label noticeInfo =
                new Label(
                        "All guards are requested to follow the emergency procedure."
                );

        noticeInfo.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #52605A;"
        );


        noticeContent.getChildren().addAll(
                noticeLabel,
                noticeText,
                noticeInfo
        );


        Button viewNoticeButton =
                new Button("View Notice");

        viewNoticeButton.setPrefWidth(
                120
        );

        viewNoticeButton.setPrefHeight(
                38
        );

        viewNoticeButton.setStyle(
                "-fx-background-color: #434141;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 7;"
        );


        Region noticeSpacer =
                new Region();

        HBox.setHgrow(
                noticeSpacer,
                Priority.ALWAYS
        );


        HBox noticeBar =
                new HBox(15);

        noticeBar.setPrefHeight(
                75
        );

        noticeBar.setMaxWidth(
                Double.MAX_VALUE
        );

        noticeBar.setPadding(
                new Insets(10, 18, 10, 20)
        );

        noticeBar.setAlignment(
                Pos.CENTER_LEFT
        );

        noticeBar.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 10;"
        );


        noticeBar.getChildren().addAll(
                noticeContent,
                noticeSpacer,
                viewNoticeButton
        );

        mainContent.getChildren().add(noticeBar);

        Scene scene = new Scene(root,1500,750);
        stage.setTitle("Society360 - Guard Dashboard");
        stage.setScene(scene);
        stage.show();
        return scene;
    }


    private static VBox createStatCard(
            String title,
            String value,
            String subtitle) {

        VBox card =
                new VBox(5);

        card.setPrefWidth(
                285
        );

        card.setPrefHeight(
                110
        );

        card.setPadding(
                new Insets(15)
        );

        card.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 10;"
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #0b0d0c;"
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030A12;"
        );


        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setStyle(
                "-fx-font-size: 10px;" +
                "-fx-text-fill: #52605A;"
        );


        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                subtitleLabel
        );


        return card;
    }

    private static HBox createSummaryRow(
            String title,
            String value) {

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #183A2D;"
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030A12;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(2, 0, 2, 0)
        );


        row.getChildren().addAll(
                titleLabel,
                spacer,
                valueLabel
        );

        return row;
    }
}