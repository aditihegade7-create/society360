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

public class ManagePayment {

    // Private Scene variable
    private Scene managePaymentScene;

    public Scene createScene(Stage stage) {

        // SIDEBAR

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setStyle(
                "-fx-background-color:#4e342e;"
        );

        // HEADING

        Label heading =  new Label("MANAGE PAYMENTS");
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // TITLE

        Label title =  new Label("Manage Payments");
               

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label(
                        "View and manage society payment records"
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


        // STATUS BUTTONS

        Button pendingBtn =
                new Button("Pending (8)");

        Button paidBtn =
                new Button("Paid (32)");

        Button overdueBtn =
                new Button("Overdue (5)");


        pendingBtn.setPrefWidth(150);
        pendingBtn.setPrefHeight(40);

        paidBtn.setPrefWidth(150);
        paidBtn.setPrefHeight(40);

        overdueBtn.setPrefWidth(150);
        overdueBtn.setPrefHeight(40);

        // BUTTON STYLES

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


        // TABS

        HBox tabs =  new HBox(25);
               
        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                pendingBtn,
                paidBtn,
                overdueBtn
        );

        // PAYMENT LIST

        VBox paymentList =  new VBox(15);
               

        paymentList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // PENDING PAYMENTS

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

        // PAID PAYMENTS

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

        // OVERDUE PAYMENTS

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


        // SCROLL PANE

        ScrollPane scrollPane =  new ScrollPane();
               
        scrollPane.setContent(
                paymentList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // SHOW PENDING BY DEFAULT

        paymentList.getChildren().addAll(
                pending1,
                pending2,
                pending3,
                pending4,
                pending5
        );

        // PENDING BUTTON

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


        // PAID BUTTON

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


        // OVERDUE BUTTON

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

        // VIEW ALL BUTTON


        Button viewAllBtn = new Button("View All Payments");
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

        // managePaymentScene =   new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        managePaymentScene = scene;
        return managePaymentScene;
    }

    // PAYMENT CARD METHOD

    private VBox createPayment(
            String residentName,
            String flatNo,
            String amount,
            String month,
            String statusText,
            String statusBackground,
            String statusColor) {


        VBox payment =  new VBox(10);
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

        // RESIDENT NAME

        Label name =  new Label(residentName);
        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // DETAILS

        Label details =
                new Label(
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

        // STATUS

        Label status =  new Label(residentName);
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

        // BOTTOM ROW

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