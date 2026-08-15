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

        public static Scene createScene(Stage stage){

        BorderPane root = new BorderPane();
        GuardSidebar sidebar = new GuardSidebar(stage, "Dashboard");

        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox();
        mainContent.setPadding(new Insets(25));
        mainContent.setSpacing(20);
        mainContent.setFillWidth(true);
        mainContent.setStyle("-fx-background-color: #789098;");

        Label greeting = new Label("Good Morning, Guard Rajesh");
        greeting.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030a12;");

        // Shift information
        Label shiftInfo = new Label("Main Gate  Shift A (08:00 AM - 04:00 PM)");
        shiftInfo.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #020407;");

        // Greeting section
        VBox greetingBox = new VBox();
        greetingBox.setSpacing(5);
        greetingBox.getChildren().addAll(
                greeting,
                shiftInfo);
        
        // Put main content in the center
        root.setCenter(mainContent);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy\nEEEE");
        Label date = new Label(today.format(formatter));
        date.setStyle("-fx-font-size: 13px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #e2e5e8;");
        date.setAlignment(Pos.CENTER);

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        header.setSpacing(20);
        header.setMaxWidth(Double.MAX_VALUE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        header.getChildren().addAll(
                greetingBox,
                spacer,
                date);


        // Add header to main content
        mainContent.getChildren().add(header);


        VBox activeVisitors = createStatCard(
        "Active Visitors",
        "24",
        "+12% from yesterday");

        VBox parking = createStatCard(
        "Parking Occupancy",
        "142/160",
        "88% Full");

        VBox approvals = createStatCard(
        "Pending Approvals",
        "03",
        "Needs attention");

        VBox sos = createStatCard(
        "SOS Alerts",
        "01",
        "High Priority");

        HBox statCards = new HBox();
        statCards.setSpacing(20);
        statCards.getChildren().addAll(activeVisitors, parking, approvals, sos);

    
        mainContent.getChildren().add(statCards);

        Label quickActionsTitle = new Label("Quick Actions");
        quickActionsTitle.setStyle(
        "-fx-font-size: 18px;" +
        "-fx-text-fill: #030A12;");


// First row of actions
        Button scanQRButton = new Button(
        "Scan QR Pass\nVisitor Check-in");

        Button manualEntryButton = new Button(
        "Manual Entry\nAdd Visitor");


// Second row of actions
        Button parkingEntryButton = new Button(
        "Parking Entry\nVehicle In");

        Button emergencySOSButton = new Button(
        "Emergency SOS\nRaise Alert");

        // Common size for Quick Action buttons
        Button[] quickActionButtons = {
        scanQRButton,
        manualEntryButton,
        parkingEntryButton,
        emergencySOSButton
};

        for (Button button : quickActionButtons) {

            button.setPrefWidth(320);
            button.setPrefHeight(75);
            button.setAlignment(Pos.CENTER_LEFT);

            button.setStyle(
            "-fx-background-color: #E8F0E8;" +
            
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #183A2D;");
}   

        // First row
        HBox firstActionRow = new HBox();
        firstActionRow.setSpacing(20);
        firstActionRow.getChildren().addAll(scanQRButton,manualEntryButton);


// Second row
        HBox secondActionRow = new HBox();
        secondActionRow.setSpacing(20);
        secondActionRow.getChildren().addAll(parkingEntryButton,emergencySOSButton);

        VBox quickActionsSection = new VBox();
        quickActionsSection.setSpacing(12);
        quickActionsSection.setPrefWidth(700);
        quickActionsSection.getChildren().addAll(quickActionsTitle,firstActionRow,secondActionRow);


        Label summaryTitle = new Label("Today's Summary");
        summaryTitle.setStyle(
        "-fx-font-size: 18px;" +
        "-fx-font-weight: bold;" +
        "-fx-text-fill: #030A12;");

        HBox totalVisitorsRow = createSummaryRow(
        "Total Visitors",
        "36");

        HBox deliveryRow = createSummaryRow(
        "Delivery / Service",
        "18");

        HBox personalRow = createSummaryRow(
        "Personal / Guest",
        "12");

        HBox vehiclesRow = createSummaryRow(
        "Vehicles Entered",
        "28");

        HBox exitsRow = createSummaryRow(
        "Exits",
        "25");

        VBox summaryBox = new VBox();
        summaryBox.setSpacing(14);
        summaryBox.setPadding(new Insets(15));
        summaryBox.setPrefWidth(450);
        summaryBox.setPrefHeight(230);
        summaryBox.setStyle(
        "-fx-background-color: #E8F0E8;"      
        );

        summaryBox.getChildren().addAll(
        summaryTitle,
        totalVisitorsRow,
        deliveryRow,
        personalRow,
        vehiclesRow,
        exitsRow);

        HBox lowerSection = new HBox();
        lowerSection.setSpacing(30);
        lowerSection.setAlignment(Pos.TOP_LEFT);
        lowerSection.getChildren().addAll(quickActionsSection,summaryBox);

        mainContent.getChildren().add(lowerSection);

// NOTICE BAR
        Label noticeText = new Label(
        "Notice: Fire Drill scheduled today at 3:00 PM.");
        noticeText.setStyle(
        "-fx-font-size: 13px;" +
        "-fx-font-weight: bold;" +
        "-fx-text-fill: #080f0c;");

        Button viewNoticeButton = new Button("View Notice");
        viewNoticeButton.setStyle(
        "-fx-background-color: transparent;" +
        "-fx-text-fill: #183A2D;" +
        "-fx-font-size: 12px;" +
        "-fx-font-weight: bold;");

        HBox noticeBar = new HBox();
        noticeBar.setPrefHeight(50);
        noticeBar.setPrefWidth(1200);
        noticeBar.setMaxWidth(Double.MAX_VALUE);
        noticeBar.setPadding(new Insets(10, 20, 10, 20));
        noticeBar.setAlignment(Pos.CENTER_LEFT);
        noticeBar.setSpacing(20);
        noticeBar.setStyle(
        "-fx-background-color: #E8F0E8;");
        noticeBar.getChildren().addAll(noticeText, viewNoticeButton);

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

    VBox card = new VBox();
    card.setPrefWidth(285);
    card.setPrefHeight(105);
    card.setPadding(new Insets(15));
    card.setSpacing(5);
    card.setStyle("-fx-background-color: #E8F0E8;");

    Label titleLabel = new Label(title);
    titleLabel.setStyle("-fx-font-size: 14px;" + "-fx-font-weight: bold;"+ "-fx-text-fill: #08140f;");

    Label valueLabel = new Label(value);
    valueLabel.setStyle("-fx-font-size: 25px;" + "-fx-font-weight: bold;" + "-fx-text-fill: #030A12;");
    Label subtitleLabel = new Label(subtitle);
    subtitleLabel.setStyle("-fx-font-size: 10px;" + "-fx-text-fill: #03070a;");

    card.getChildren().addAll(
            titleLabel,
            valueLabel,
            subtitleLabel);

    return card;

    }

    private static HBox createSummaryRow(
        String title,
        String value) {

    Label titleLabel = new Label(title);

    titleLabel.setStyle(
            "-fx-font-size: 12px;" +
            "-fx-text-fill: #183A2D;"
    );


    Label valueLabel = new Label(value);

    valueLabel.setStyle(
            "-fx-font-size: 13px;" +
            "-fx-font-weight: bold;" +
            "-fx-text-fill: #030A12;"
    );


    HBox row = new HBox();

    row.setAlignment(Pos.CENTER_LEFT);
    row.setSpacing(20);

    row.getChildren().addAll(
            titleLabel,
            valueLabel
    );

    return row;
}
}