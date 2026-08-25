package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

public class DailyReports {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        GuardSidebar sidebar = new GuardSidebar(stage, "Daily Reports");

        root.setLeft(sidebar.getSidebar());

        VBox content = new VBox();
        content.setPadding(new Insets(25, 40, 25, 40));
        content.setSpacing(18);
        content.setStyle("-fx-background-color: #e8ddd5;");


       HBox header = new HBox();
header.setPadding(new Insets(25, 35, 25, 35));
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("Daily Reports");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Main Gate    Shift A    (08:00 AM - 04:00 PM)"
);
description.setStyle(
        "-fx-font-size:13px;" +
        "-fx-text-fill: white;"
);

titleBox.getChildren().addAll(title, description);


// Spacer pushes date to the right
Region spacer = new Region();
HBox.setHgrow(spacer, Priority.ALWAYS);


// Date
Label day = new Label();
Label date = new Label();

LocalDate today = LocalDate.now();

day.setText(today.format(
        DateTimeFormatter.ofPattern("EEEE")
));

date.setText(today.format(
        DateTimeFormatter.ofPattern("dd MMMM yyyy")
));
day.setTextFill(Color.WHITE);
date.setTextFill(Color.WHITE);

VBox dateBox = new VBox(3);
dateBox.setAlignment(Pos.CENTER_RIGHT);
dateBox.getChildren().addAll(day, date);


// Add everything to header
header.getChildren().addAll(
        titleBox,
        spacer,
        dateBox
);

        VBox summaryCard = new VBox();
        summaryCard.setPadding(new Insets(20));
        summaryCard.setSpacing(15);
        summaryCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;");

        Label summaryTitle = new Label("Today's Summary");
        summaryTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #0b0c0c;");

        GridPane summaryGrid = new GridPane();
        summaryGrid.setHgap(15);
        summaryGrid.setVgap(10);

        int totalVisitors = VisitorLog.visitors.size();
        int insideVisitors = 0;
        int checkedOutVisitors = 0;
        int deliveries = 0;

        for (VisitorLog.Visitor visitor : VisitorLog.visitors) {
            if (visitor.getStatus().equals("Inside")) {
                insideVisitors++;
            }

            if (visitor.getStatus().equals("Checked Out")) {
                checkedOutVisitors++;
            }

            if (visitor.getPurpose().equals("Delivery")) {
                deliveries++;
            }
        }


        int totalParking = Parking.parkingSpots.size();
        int occupiedParking = 0;

        for (Parking.ParkingSpot spot : Parking.parkingSpots) {
            if (spot.occupied) {
                occupiedParking++;
            }
        }

        int availableParking = totalParking - occupiedParking;

        VBox totalCard = createSummaryCard("Total Visitors",String.valueOf(totalVisitors));

        VBox insideCard = createSummaryCard("Currently Inside", String.valueOf(insideVisitors));

        VBox checkedOutCard = createSummaryCard("Checked Out", String.valueOf(checkedOutVisitors));

        VBox deliveryCard = createSummaryCard("Deliveries", String.valueOf(deliveries));

        VBox parkingCard = createSummaryCard("Occupied Parking", occupiedParking + " / " + totalParking);

        VBox availableParkingCard = createSummaryCard("Available Parking", String.valueOf(availableParking));

        summaryGrid.add(totalCard,0, 0);
        summaryGrid.add(insideCard,1, 0);
        summaryGrid.add(checkedOutCard,2, 0);
        summaryGrid.add(deliveryCard,3, 0);
        summaryGrid.add(parkingCard,4, 0);
        summaryGrid.add(availableParkingCard,5, 0);
        summaryCard.getChildren().addAll(summaryTitle,summaryGrid);

        VBox reportCard = new VBox();
        reportCard.setPadding(new Insets(20));
        reportCard.setSpacing(12);
        reportCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;");

        Label reportTitle = new Label("Daily Activity Report");
        reportTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #040505;");

        TextArea reportArea = new TextArea();
        reportArea.setEditable(false);
        reportArea.setWrapText(true);
        reportArea.setPrefHeight(220);
        reportArea.setMaxWidth(Double.MAX_VALUE);
        reportArea.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #090909;");

        generateReport(reportArea);
        reportCard.getChildren().addAll(reportTitle,reportArea);

        Button refreshButton = new Button("Refresh Report");
        refreshButton.setPrefWidth(145);
        refreshButton.setPrefHeight(40);
        refreshButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");

        Button clearButton = new Button("Clear");
        clearButton.setPrefWidth(100);
        clearButton.setPrefHeight(40);
        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #0b0b0b;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");

        HBox buttons = new HBox(12,clearButton,refreshButton);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        refreshButton.setOnAction(e -> {
            generateReport(reportArea);

            showMessage(
                    "Report Updated",
                    "Daily report has been refreshed.");
        });

        clearButton.setOnAction(e -> {
            reportArea.clear();
        });

        content.getChildren().addAll(
                header,
                summaryCard,
                reportCard,
                buttons);

        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(content);
        root.setCenter(mainarea);
        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
    }

    private static void generateReport(TextArea reportArea) {

        StringBuilder report = new StringBuilder();
        report.append("DAILY SECURITY REPORT\n");
        report.append("Date: ");
        report.append(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        report.append("\n\n");
        report.append("VISITOR ACTIVITY\n");
        report.append("Total Visitors: ");
        report.append(VisitorLog.visitors.size());
        report.append("\n");

        int insideCount = 0;
        int checkedOutCount = 0;
        int deliveryCount = 0;

        for (VisitorLog.Visitor visitor : VisitorLog.visitors) {
            if (visitor.getStatus().equals("Inside")) {
                insideCount++;
            }

            if (visitor.getStatus().equals("Checked Out")) {
                checkedOutCount++;
            }

            if (visitor.getPurpose().equals("Delivery")) {
                deliveryCount++;
            }
        }


        report.append("Currently Inside: ");
        report.append(insideCount);
        report.append("\n");
        report.append("Checked Out: ");
        report.append(checkedOutCount);
        report.append("\n");
        report.append("Deliveries: ");
        report.append(deliveryCount);
        report.append("\n\n");
        report.append("VISITOR ENTRIES\n");


        if (VisitorLog.visitors.isEmpty()) {
            report.append("No visitor entries available.\n");
            report.append("\n");
        } else {
            for (VisitorLog.Visitor visitor : VisitorLog.visitors) {
                report.append("Name: ");
                report.append(visitor.getName());
                report.append("\n");
                report.append("Phone: ");
                report.append(visitor.getPhone());
                report.append("\n");
                report.append("Flat: ");
                report.append(visitor.getFlat());
                report.append("\n");
                report.append("Purpose: ");
                report.append(visitor.getPurpose());
                report.append("\n");
                report.append("Entry Time: ");
                report.append(visitor.getEntryTime());
                report.append("\n");
                report.append("Status: ");
                report.append(visitor.getStatus());
                report.append("\n");
                report.append("\n");
                report.append("\n");
            }
        }

        report.append("\nPARKING ACTIVITY\n");

        int totalParking = Parking.parkingSpots.size();
        int occupiedParking = 0;

        for (Parking.ParkingSpot spot : Parking.parkingSpots) {
            if (spot.occupied) {
                occupiedParking++;
            }
        }

        report.append("Total Parking Spots: ");
        report.append(totalParking);
        report.append("\n");
        report.append("Occupied Spots: ");
        report.append(occupiedParking);
        report.append("\n");
        report.append("Available Spots: ");
        report.append(totalParking - occupiedParking);
        report.append("\n");
        report.append("\n");
        report.append("\nEMERGENCY STATUS\n");


        if (EmergencySOS.isSOSActive()) {
            report.append("ACTIVE EMERGENCY ALERT\n");
            report.append("Immediate attention required.\n");

        } else {
            report.append("No active emergency alerts.\n");
            report.append("\n");
        }

        reportArea.setText(report.toString());
    }

    private static VBox createSummaryCard(String title, String value) {

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #050506;");

        Label valueLabel = new Label(value);
        valueLabel.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #060707;");

        VBox card = new VBox(6,titleLabel,valueLabel);
        card.setPrefWidth(175);
        card.setPrefHeight(65);
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 8;");

        return card;
    }

    private static void showMessage(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}