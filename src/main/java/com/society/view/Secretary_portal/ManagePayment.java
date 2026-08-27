package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagePayment {

    private Scene managePaymentScene;

    public Scene createScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb = new VBox(20);

        mainvb.setPadding(new Insets(25));

        mainvb.setPrefWidth(1220);

        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxHeight(Double.MAX_VALUE);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading = new Label("MANAGE PAYMENTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label("Manage Payments");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label(
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

        // =====================================================
        // ADD PAYMENT BUTTON
        // =====================================================

        Button addPaymentBtn = new Button("+ Add Payment");

        addPaymentBtn.setPrefWidth(140);
        addPaymentBtn.setPrefHeight(40);

        addPaymentBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-background-radius:7;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header = new HBox();

        header.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                titleBox,
                addPaymentBtn
        );

        // =====================================================
        // STATUS BUTTONS
        // =====================================================

        Button pendingBtn = new Button("Pending (8)");
        Button paidBtn = new Button("Paid (32)");
        Button overdueBtn = new Button("Overdue (5)");

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

        // =====================================================
        // TABS
        // =====================================================

        HBox tabs = new HBox(25);

        tabs.setAlignment(Pos.CENTER_LEFT);

        tabs.getChildren().addAll(
                pendingBtn,
                paidBtn,
                overdueBtn
        );

        // =====================================================
        // PAYMENT LIST
        // =====================================================

        VBox paymentList = new VBox(15);

        paymentList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // =====================================================
        // PENDING PAYMENTS
        // =====================================================

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

        // =====================================================
        // PAID PAYMENTS
        // =====================================================

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

        // =====================================================
        // OVERDUE PAYMENTS
        // =====================================================

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

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(paymentList);

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =====================================================
        // DEFAULT PENDING
        // =====================================================

        paymentList.getChildren().addAll(
                pending1,
                pending2,
                pending3,
                pending4,
                pending5
        );

        // =====================================================
        // PENDING BUTTON
        // =====================================================

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

        // =====================================================
        // PAID BUTTON
        // =====================================================

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

        // =====================================================
        // OVERDUE BUTTON
        // =====================================================

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

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn = new Button(
                "View All Payments"
        );

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

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                heading,
                header,
                tabs,
                scrollPane,
                viewAllBtn
        );

        // =====================================================
        // MAIN ROOT
        // =====================================================

        HBox mainRoot = new HBox();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        mainRoot.setStyle(
                "-fx-background-color:#434141;"
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =====================================================
        // ROOT STACKPANE
        // =====================================================

        StackPane root = new StackPane();

        root.getChildren().add(
                mainRoot
        );

        // =====================================================
        // ADD PAYMENT POPUP
        // =====================================================

        addPaymentBtn.setOnAction(e -> {

            StackPane popupLayer = createOverlay();

            VBox paymentForm = new VBox(12);

            paymentForm.setPadding(
                    new Insets(25)
            );

            paymentForm.setPrefWidth(430);
            paymentForm.setMaxWidth(430);
            paymentForm.setMaxHeight(600);

            paymentForm.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:15;" +
                    "-fx-border-radius:15;" +
                    "-fx-border-color:#DDDDDD;"
            );

            // =================================================
            // TITLE
            // =================================================

            Label formTitle = new Label(
                    "Add New Payment"
            );

            formTitle.setStyle(
                    "-fx-font-size:22px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // =================================================
            // RESIDENT
            // =================================================

            Label residentLabel = new Label(
                    "Resident Name"
            );

            residentLabel.setStyle(
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#333333;"
            );

            TextField residentField = new TextField();

            residentField.setPromptText(
                    "Enter resident name"
            );

            residentField.setPrefHeight(38);

            // =================================================
            // FLAT
            // =================================================

            Label flatLabel = new Label(
                    "Flat Number"
            );

            flatLabel.setStyle(
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#333333;"
            );

            TextField flatField = new TextField();

            flatField.setPromptText(
                    "Enter flat number"
            );

            flatField.setPrefHeight(38);

            // =================================================
            // AMOUNT
            // =================================================

            Label amountLabel = new Label(
                    "Payment Amount"
            );

            amountLabel.setStyle(
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#333333;"
            );

            TextField amountField = new TextField();

            amountField.setPromptText(
                    "Enter amount"
            );

            amountField.setPrefHeight(38);

            // =================================================
            // MONTH
            // =================================================

            Label monthLabel = new Label(
                    "Payment Month"
            );

            monthLabel.setStyle(
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#333333;"
            );

            TextField monthField = new TextField();

            monthField.setPromptText(
                    "Example: May 2025"
            );

            monthField.setPrefHeight(38);

            // =================================================
            // BUTTONS
            // =================================================

            Button cancelBtn = new Button(
                    "Cancel"
            );

            cancelBtn.setPrefWidth(100);
            cancelBtn.setPrefHeight(38);

            cancelBtn.setStyle(
                    "-fx-background-color:#E5E7EB;" +
                    "-fx-text-fill:#333333;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            Button saveBtn = new Button(
                    "Save Payment"
            );

            saveBtn.setPrefWidth(125);
            saveBtn.setPrefHeight(38);

            saveBtn.setStyle(
                    "-fx-background-color:#2E9D63;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            HBox buttonBox = new HBox(10);

            buttonBox.setAlignment(
                    Pos.CENTER_RIGHT
            );

            buttonBox.setPadding(
                    new Insets(8, 0, 0, 0)
            );

            buttonBox.getChildren().addAll(
                    cancelBtn,
                    saveBtn
            );

            // =================================================
            // ADD CONTROLS
            // =================================================

            paymentForm.getChildren().addAll(

                    formTitle,

                    residentLabel,
                    residentField,

                    flatLabel,
                    flatField,

                    amountLabel,
                    amountField,

                    monthLabel,
                    monthField,

                    buttonBox
            );

            // =================================================
            // ADD FORM TO OVERLAY
            // =================================================

            popupLayer.getChildren().add(
                    paymentForm
            );

            StackPane.setAlignment(
                    paymentForm,
                    Pos.CENTER
            );

            // =================================================
            // CANCEL
            // =================================================

            cancelBtn.setOnAction(event -> {

                root.getChildren().remove(
                        popupLayer
                );

            });

            // =================================================
            // SAVE
            // =================================================

            saveBtn.setOnAction(event -> {

                String residentName =
                        residentField.getText();

                String flatNo =
                        flatField.getText();

                String amount =
                        amountField.getText();

                String month =
                        monthField.getText();

                System.out.println(
                        "================================"
                );

                System.out.println(
                        "NEW PAYMENT"
                );

                System.out.println(
                        "Resident: " + residentName
                );

                System.out.println(
                        "Flat: " + flatNo
                );

                System.out.println(
                        "Amount: " + amount
                );

                System.out.println(
                        "Month: " + month
                );

                System.out.println(
                        "================================"
                );

                // Firebase / Firestore code
                // can be added here later.

                root.getChildren().remove(
                        popupLayer
                );
            });

            // =================================================
            // SHOW POPUP
            // =================================================

            root.getChildren().add(
                    popupLayer
            );
        });

        // =====================================================
        // VIEW ALL PAYMENTS POPUP
        // =====================================================

        viewAllBtn.setOnAction(e -> {

            StackPane popupLayer = createOverlay();

            // =================================================
            // POPUP BOX
            // =================================================

            VBox allPaymentBox = new VBox(15);

            allPaymentBox.setPadding(
                    new Insets(25)
            );

            allPaymentBox.setPrefWidth(650);

            allPaymentBox.setMaxWidth(650);

            allPaymentBox.setMaxHeight(650);

            allPaymentBox.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:15;" +
                    "-fx-border-radius:15;" +
                    "-fx-border-color:#DDDDDD;"
            );

            // =================================================
            // TITLE
            // =================================================

            Label allTitle = new Label(
                    "All Payments"
            );

            allTitle.setStyle(
                    "-fx-font-size:22px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            Label allSubtitle = new Label(
                    "Complete society payment records"
            );

            allSubtitle.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-text-fill:#777777;"
            );

            // =================================================
            // PAYMENT SCROLL
            // =================================================

            VBox allList = new VBox(10);

            allList.setPadding(
                    new Insets(5)
            );

            // =================================================
            // ALL PAYMENT 1
            // =================================================

            VBox allPayment1 = createAllPayment(
                    "Diya Wadhwa",
                    "B-402",
                    "₹2500",
                    "May 2025",
                    "Pending",
                    "#FFF0D9",
                    "#C47A20"
            );

            // =================================================
            // ALL PAYMENT 2
            // =================================================

            VBox allPayment2 = createAllPayment(
                    "Rahul Sharma",
                    "A-101",
                    "₹2500",
                    "May 2025",
                    "Pending",
                    "#FFF0D9",
                    "#C47A20"
            );

            // =================================================
            // ALL PAYMENT 3
            // =================================================

            VBox allPayment3 = createAllPayment(
                    "Aarav Mehta",
                    "A-201",
                    "₹2500",
                    "May 2025",
                    "Paid",
                    "#E5F7EC",
                    "#2E9D63"
            );

            // =================================================
            // ALL PAYMENT 4
            // =================================================

            VBox allPayment4 = createAllPayment(
                    "Priya Sharma",
                    "B-102",
                    "₹2500",
                    "May 2025",
                    "Paid",
                    "#E5F7EC",
                    "#2E9D63"
            );

            // =================================================
            // ALL PAYMENT 5
            // =================================================

            VBox allPayment5 = createAllPayment(
                    "Vivek Patil",
                    "C-301",
                    "₹2500",
                    "May 2025",
                    "Paid",
                    "#E5F7EC",
                    "#2E9D63"
            );

            // =================================================
            // ALL PAYMENT 6
            // =================================================

            VBox allPayment6 = createAllPayment(
                    "Vikram Deshmukh",
                    "A-305",
                    "₹5000",
                    "April 2025",
                    "Overdue",
                    "#FDE8E8",
                    "#D9534F"
            );

            // =================================================
            // ALL PAYMENT 7
            // =================================================

            VBox allPayment7 = createAllPayment(
                    "Meena Shah",
                    "B-404",
                    "₹5000",
                    "April 2025",
                    "Overdue",
                    "#FDE8E8",
                    "#D9534F"
            );

            // =================================================
            // ALL PAYMENT 8
            // =================================================

            VBox allPayment8 = createAllPayment(
                    "Akash Patil",
                    "C-202",
                    "₹5000",
                    "April 2025",
                    "Overdue",
                    "#FDE8E8",
                    "#D9534F"
            );

            allList.getChildren().addAll(
                    allPayment1,
                    allPayment2,
                    allPayment3,
                    allPayment4,
                    allPayment5,
                    allPayment6,
                    allPayment7,
                    allPayment8
            );

            // =================================================
            // SCROLL
            // =================================================

            ScrollPane allScrollPane =
                    new ScrollPane(allList);

            allScrollPane.setFitToWidth(true);

            allScrollPane.setPrefHeight(450);

            allScrollPane.setStyle(
                    "-fx-background-color:transparent;" +
                    "-fx-border-color:transparent;"
            );

            // =================================================
            // CLOSE BUTTON
            // =================================================

            Button closeBtn = new Button(
                    "Close"
            );

            closeBtn.setPrefWidth(100);

            closeBtn.setPrefHeight(38);

            closeBtn.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:8;"
            );

            HBox closeBox = new HBox();

            closeBox.setAlignment(
                    Pos.CENTER_RIGHT
            );

            closeBox.getChildren().add(
                    closeBtn
            );

            // =================================================
            // ADD EVERYTHING
            // =================================================

            allPaymentBox.getChildren().addAll(

                    allTitle,
                    allSubtitle,
                    allScrollPane,
                    closeBox
            );

            // =================================================
            // CENTER POPUP
            // =================================================

            popupLayer.getChildren().add(
                    allPaymentBox
            );

            StackPane.setAlignment(
                    allPaymentBox,
                    Pos.CENTER
            );

            // =================================================
            // CLOSE
            // =================================================

            closeBtn.setOnAction(event -> {

                root.getChildren().remove(
                        popupLayer
                );

            });

            // =================================================
            // SHOW SAME SCENE POPUP
            // =================================================

            root.getChildren().add(
                    popupLayer
            );
        });

        // =====================================================
        // MAIN SCENE
        // =====================================================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        managePaymentScene = scene;

        return managePaymentScene;
    }

    // =========================================================
    // CREATE OVERLAY
    // =========================================================

    private StackPane createOverlay() {

        StackPane popupLayer = new StackPane();

        popupLayer.setPickOnBounds(true);

        popupLayer.setStyle(
                "-fx-background-color:rgba(0,0,0,0.35);"
        );

        return popupLayer;
    }

    // =========================================================
    // PAYMENT CARD
    // =========================================================

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

        // =====================================================
        // NAME
        // =====================================================

        Label name = new Label(
                residentName
        );

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =====================================================
        // DETAILS
        // =====================================================

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

        // =====================================================
        // STATUS
        // =====================================================

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

        // =====================================================
        // BOTTOM
        // =====================================================

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

        // =====================================================
        // CARD
        // =====================================================

        payment.getChildren().addAll(
                name,
                bottom
        );

        return payment;
    }

    // =========================================================
    // ALL PAYMENT CARD
    // =========================================================

    private VBox createAllPayment(

            String residentName,
            String flatNo,
            String amount,
            String month,
            String statusText,
            String statusBackground,
            String statusColor) {

        VBox card = new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color:#F9F9F9;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#E5E5E5;" +
                "-fx-border-radius:10;"
        );

        // =====================================================
        // TOP ROW
        // =====================================================

        HBox topRow = new HBox();

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label name = new Label(
                residentName
        );

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        HBox.setHgrow(
                name,
                Priority.ALWAYS
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

        topRow.getChildren().addAll(
                name,
                status
        );

        // =====================================================
        // DETAILS
        // =====================================================

        Label details = new Label(

                "Flat: " + flatNo +
                "     |     " +
                "Amount: " + amount +
                "     |     " +
                "Month: " + month
        );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // ADD TO CARD
        // =====================================================

        card.getChildren().addAll(
                topRow,
                details
        );

        return card;
    }
}