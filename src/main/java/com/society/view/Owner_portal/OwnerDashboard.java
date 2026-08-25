package com.society.view.Owner_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class OwnerDashboard {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();


        OwnerSidebar sidebar = new OwnerSidebar(stage);
        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox();
        mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setSpacing(20);
        mainContent.setAlignment(Pos.TOP_LEFT);
        mainContent.setStyle("-fx-background-color: #e8ddd5;");

        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox v1 = new VBox();
        Label greeting = new Label("Good Morning, Owner 👋");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        
        Label l1 = new Label("This is your dashboard");
        l1.setStyle("-fx-font-size:12px;-fx-text-fill: #ffffff;");


        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        
        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));
        day.setStyle("-fx-text-fill: #ffffff"); 
        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        date.setStyle("-fx-text-fill: #ffffff"); 
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        v1.getChildren().addAll(greeting,l1);

        header.getChildren().addAll(v1,
                spacer,
                
                vb1);

        mainContent.getChildren().add(header);

        HBox cards = new HBox();
        cards.setSpacing(15);

        VBox totalTenants =createCard("Total Tenants", "02");
        VBox rentReceived =createCard("Rent Received", "₹18,450");
        VBox pendingAmount=createCard("Pending Amount", "₹1,250");
        VBox upcomingDue = createCard("Upcoming Due", "02");

        cards.getChildren().addAll(
                totalTenants,
                rentReceived,
                pendingAmount,
                upcomingDue
        );

        mainContent.getChildren().add(cards);

        HBox information = new HBox();
        information.setSpacing(20);

        VBox incomeOverview = createIncomeOverview();

        VBox activity = createInformationBox(
                        "Recent Activity",
                        "Payment Received    20 May       ₹9,000",
                        "Maintenance Paid    26 June      ₹1,250",
                        "Rent Due             15 August    ₹12,500"
                );

        information.getChildren().addAll(
                incomeOverview,
                activity
        );

        mainContent.getChildren().add(information);

        VBox noticeBox = new VBox();
        noticeBox.setSpacing(8);
        noticeBox.setPadding(new Insets(12));
        noticeBox.setPrefWidth(1100);
        noticeBox.setPrefHeight(100);

        noticeBox.setStyle( "-fx-background-color: #f8f8fc;-fx-background-radius: 10;-fx-border-radius: 10;-fx-border-color: #D0DDE0;"
        );

        Label noticeHeading = new Label("Notice");

        noticeHeading.setStyle( "-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        Label noticeText = new Label(
                "Water tank cleaning on 15 May 2025 " +
                "from 9:00 AM to 1:00 PM."
        );

        noticeText.setStyle(
                "-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill: #131314;"
        );

        noticeBox.getChildren().addAll(
                noticeHeading,
                noticeText
        );

        mainContent.getChildren().add(noticeBox);
        BorderPane mainarea = new BorderPane();
       mainarea.setTop(header);
       mainarea.setCenter(mainContent);
       root.setCenter(mainarea);
       
        return new Scene(root, 
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }

         private static VBox createCard(
            String title,
            String value
    ) {

        VBox card = new VBox();

        card.setSpacing(8);
        card.setPadding(new Insets(18));

        card.setPrefWidth(250);
        card.setPrefHeight(100);

        card.setStyle(
                "-fx-background-color: #f6f6fd;-fx-background-radius: 10;-fx-border-radius: 10;-fx-border-color: #E0E0E0;"
        );

        Label cardTitle = new Label(title);
        cardTitle.setStyle(
                "-fx-font-size: 13px;-fx-text-fill: #546E7A;" );

        Label cardValue = new Label(value);
        cardValue.setStyle("-fx-font-size: 23px;-fx-font-weight: bold;-fx-text-fill: #102A43;" );
        card.getChildren().addAll(
                cardTitle,
                cardValue
        );

        return card;
    }
        private static VBox createInformationBox(
            String title,
            String line1,
            String line2,
            String line3
    ) {

        VBox box = new VBox();

        box.setSpacing(15);
        box.setPadding(new Insets(18));

        box.setPrefWidth(600);
        box.setPrefHeight(250);

        box.setStyle(
                "-fx-background-color: white;-fx-background-radius: 15;-fx-border-radius: 15;-fx-border-color: #E0E0E0;-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 10, 0, 0, 3);"
        );

        Label heading = new Label(title);

        heading.setStyle(
                "-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        Label first = new Label("●  " + line1);
        Label second = new Label("●  " + line2);
        Label third = new Label("●  " + line3);

        first.setStyle( "-fx-font-size: 14px;-fx-font-weight: bold;-fx-text-fill: #37474F;" );
        second.setStyle( "-fx-font-size: 14px;-fx-font-weight: bold;-fx-text-fill: #37474F;" );
        third.setStyle("-fx-font-size: 14px;-fx-font-weight: bold;-fx-text-fill: #37474F;" );

        box.getChildren().addAll(
                heading,
                first,
                second,
                third
        );

        return box;
    }
        private static VBox createIncomeOverview() {
         VBox box = new VBox();

        box.setSpacing(10);
        box.setPadding(new Insets(18));

        box.setPrefWidth(500);
        box.setPrefHeight(250);

        box.setStyle("-fx-background-color: white;-fx-background-radius: 15;-fx-border-radius: 15;-fx-border-color: #E0E0E0;" );

       Label heading = new Label("Income Overview");
       heading.setStyle( "-fx-font-size: 20px;-fx-font-weight: bold;-fx-text-fill: #102A43;");


        PieChart.Data rent =new PieChart.Data("Rent", 17200);
        PieChart.Data maintenance =new PieChart.Data("Maintenance", 800);
        PieChart.Data other =new PieChart.Data("Other Charges", 450);
        PieChart pieChart = new PieChart();

        pieChart.getData().addAll(
                rent,
                maintenance,
                other
        );

        pieChart.setLabelsVisible(false);
        pieChart.setLegendVisible(false);
        pieChart.setAnimated(false);
        pieChart.setPrefSize(160, 160);

       Circle centerCircle = new Circle(43);
       centerCircle.setStyle( "-fx-fill: white;" );
       Label totalAmount = new Label("₹18,450");
       totalAmount.setStyle( "-fx-font-size: 15px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        Label totalText =new Label("Total Income");
        totalText.setStyle( "-fx-font-size: 10px;-fx-text-fill: #546E7A;" );
        VBox centerText = new VBox( 1, totalAmount, totalText);
       centerText.setAlignment( Pos.CENTER  );

        StackPane chart = new StackPane(pieChart,centerCircle,centerText);
        chart.setPrefSize(170, 170);

        VBox details = new VBox();
        details.setSpacing(12);
        details.setAlignment( Pos.CENTER_LEFT );

        HBox rentRow = createIncomeRow(
                "Rent",
                "₹17,200",
                "#d56c0f"
        );

        HBox maintenanceRow = createIncomeRow(
                "Maintenance",
                "₹800",
                "#dcbe24"
        );

        HBox otherRow = createIncomeRow(
                "Other Charges",
                "₹450",
                "#90f012"
        );


        details.getChildren().addAll(
                rentRow,
                maintenanceRow,
                otherRow
        );

        HBox content = new HBox();
        content.setSpacing(15);
        content.setAlignment(
        Pos.CENTER_LEFT
        );

        content.getChildren().addAll(
                chart,
                details
        );


        box.getChildren().addAll(
                heading,
                content
        );

        return box;
    }
            private static HBox createIncomeRow(
            String name,
            String amount,
            String color) 
            {

        Circle dot = new Circle(6);
        dot.setStyle( "-fx-fill: " + color + ";"
        );

        Label nameLabel = new Label(name);
 nameLabel.setStyle( "-fx-font-size: 13px;-fx-font-weight: bold;-fx-text-fill: #37474F;"
        );

        Label amountLabel = new Label(amount);
        amountLabel.setStyle( "-fx-font-size: 13px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        HBox row = new HBox();
        row.setSpacing(8);
        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.getChildren().addAll(
                dot,
                nameLabel,
                amountLabel
        );

        return row;
    }
}