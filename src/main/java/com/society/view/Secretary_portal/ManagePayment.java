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

public class ManagePayment {

    private Scene managePaymentScene;

    public Scene createScene(Stage stage) {

        
        BorderPane root = new BorderPane();
        SecretarySidebar sidebarObj = new SecretarySidebar();

        VBox sidebar = sidebarObj.createSidebar(stage);

        root.setLeft(sidebar);
        BorderPane mainarea = new BorderPane();
        HBox header = new HBox();

        header.setPrefHeight(80);
        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setPadding(new Insets(20));

        header.setAlignment(Pos.CENTER_LEFT);

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );

       
        VBox headerText = new VBox(4);

        Label greeting = new Label(
                "Manage Payments"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );

        Label description = new Label(
                "View and manage society payment records"
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
        Button pendingBtn = new Button(
                "Pending (8)"
        );

        Button paidBtn = new Button(
                "Paid (32)"
        );

        Button overdueBtn = new Button(
                "Overdue (5)"
        );

        pendingBtn.setPrefWidth(150);
        pendingBtn.setPrefHeight(40);

        paidBtn.setPrefWidth(150);
        paidBtn.setPrefHeight(40);

        overdueBtn.setPrefWidth(150);
        overdueBtn.setPrefHeight(40);
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

        pendingBtn.setStyle(activeStyle);
        paidBtn.setStyle(normalStyle);
        overdueBtn.setStyle(normalStyle);

        HBox tabs = new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                pendingBtn,
                paidBtn,
                overdueBtn
        );

        VBox paymentList = new VBox(15);

        paymentList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        VBox pending1 = createPayment(
                "Diya Wadhwa",
                "B-402",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending2 = createPayment(
                "Rahul Sharma",
                "A-101",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending3 = createPayment(
                "Neha Patil",
                "C-203",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending4 = createPayment(
                "Amit Kulkarni",
                "B-305",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending5 = createPayment(
                "Pooja Singh",
                "A-503",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        

        VBox paid1 = createPayment(
                "Aarav Mehta",
                "A-201",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid2 = createPayment(
                "Priya Sharma",
                "B-102",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid3 = createPayment(
                "Vivek Patil",
                "C-301",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid4 = createPayment(
                "Anjali Joshi",
                "A-402",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid5 = createPayment(
                "Riya Singh",
                "B-203",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid6 = createPayment(
                "Sahil More",
                "C-104",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        
        VBox overdue1 = createPayment(
                "Vikram Deshmukh",
                "A-305",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue2 = createPayment(
                "Meena Shah",
                "B-404",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue3 = createPayment(
                "Akash Patil",
                "C-202",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue4 = createPayment(
                "Nisha Kulkarni",
                "A-103",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue5 = createPayment(
                "Rohit Sharma",
                "B-302",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        

        paymentList.getChildren().addAll(
                pending1,
                pending2,
                pending3,
                pending4,
                pending5
        );

       

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                paymentList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(480);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        pendingBtn.setOnAction(e -> {

            paymentList.getChildren().clear();

            paymentList.getChildren().addAll(
                    pending1,
                    pending2,
                    pending3,
                    pending4,
                    pending5
            );

            pendingBtn.setStyle(activeStyle);
            paidBtn.setStyle(normalStyle);
            overdueBtn.setStyle(normalStyle);
        });

       
        paidBtn.setOnAction(e -> {

            paymentList.getChildren().clear();

            paymentList.getChildren().addAll(
                    paid1,
                    paid2,
                    paid3,
                    paid4,
                    paid5,
                    paid6
            );

            pendingBtn.setStyle(normalStyle);
            paidBtn.setStyle(activeStyle);
            overdueBtn.setStyle(normalStyle);
        });


        overdueBtn.setOnAction(e -> {

            paymentList.getChildren().clear();

            paymentList.getChildren().addAll(
                    overdue1,
                    overdue2,
                    overdue3,
                    overdue4,
                    overdue5
            );

            pendingBtn.setStyle(normalStyle);
            paidBtn.setStyle(normalStyle);
            overdueBtn.setStyle(activeStyle);
        });

        

        Button viewAllBtn = new Button(
                "View All Payments"
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

        managePaymentScene = scene;

        return managePaymentScene;
    }

    private VBox createPayment(
            String residentName,
            String flatNo,
            String amount,
            String month,
            String statusText,
            String statusBackground,
            String statusColor) {

        VBox payment = new VBox(10);

        payment.setPadding(
                new Insets(18)
        );

        payment.setPrefHeight(90);

        payment.setMaxWidth(1180);

        payment.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


        Label name = new Label(
                residentName
        );

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label details = new Label(
                "Flat: " + flatNo +
                "    |    " +
                "Amount: " + amount +
                "    |    " +
                month
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

        payment.getChildren().addAll(
                name,
                bottom
        );

        return payment;
    }
}