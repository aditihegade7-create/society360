package com.society.view.Owner_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPayments {

    public static Scene createScene(Stage stage) {

        // =========================
        // ROOT
        // =========================

        BorderPane root = new BorderPane();

        // =========================
        // SIDEBAR
        // =========================

        OwnerSidebar sidebar =
                new OwnerSidebar(stage);

        root.setLeft(
                sidebar.getSidebar()
        );

        // =========================
        // MAIN CONTENT
        // =========================

        VBox mainContent = new VBox();

        mainContent.setPadding(
                new Insets(25, 35, 25, 35)
        );

        mainContent.setSpacing(15);

        mainContent.setAlignment(
                Pos.TOP_LEFT
        );

        mainContent.setStyle(
                "-fx-background-color: #789098;"
        );

        // =========================
        // HEADER
        // =========================

        Label title = new Label(
                "Payments"
        );

        title.setStyle(
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        Label subtitle = new Label(
                "View all rent and maintenance payments"
        );

        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #263238;"
        );

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        mainContent.getChildren().add(
                heading
        );

        // =========================
        // TABLE
        // =========================

        TableView<Payment> table =
                new TableView<>();

        table.setPrefHeight(500);

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        // =========================
        // COLUMNS
        // =========================

        TableColumn<Payment, String> dateColumn =
                new TableColumn<>("Date");

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        TableColumn<Payment, String> tenantColumn =
                new TableColumn<>("Tenant");

        tenantColumn.setCellValueFactory(
                new PropertyValueFactory<>("tenant")
        );

        TableColumn<Payment, String> flatColumn =
                new TableColumn<>("Flat / Unit");

        flatColumn.setCellValueFactory(
                new PropertyValueFactory<>("flat")
        );

        TableColumn<Payment, String> paymentColumn =
                new TableColumn<>("For");

        paymentColumn.setCellValueFactory(
                new PropertyValueFactory<>("paymentFor")
        );

        TableColumn<Payment, String> amountColumn =
                new TableColumn<>("Amount");

        amountColumn.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );

        TableColumn<Payment, String> statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        table.getColumns().addAll(
                dateColumn,
                tenantColumn,
                flatColumn,
                paymentColumn,
                amountColumn,
                statusColumn
        );

        // =========================
        // SAMPLE DATA
        // =========================

        table.getItems().addAll(

                new Payment(
                        "10 May 2025",
                        "Rahul Sharma",
                        "A-101",
                        "May 2025 Rent",
                        "₹9,000",
                        "Received"
                ),

                new Payment(
                        "09 May 2025",
                        "Rahul Sharma",
                        "A-101",
                        "Maintenance",
                        "₹800",
                        "Received"
                ),

                new Payment(
                        "06 May 2025",
                        "Priya Mehta",
                        "B-201",
                        "May 2025 Rent",
                        "₹10,000",
                        "Received"
                ),

                new Payment(
                        "15 May 2025",
                        "Priya Mehta",
                        "B-201",
                        "May 2025 Rent",
                        "₹12,500",
                        "Pending"
                )
        );

        table.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D5DDE0;"
        );

        mainContent.getChildren().add(
                table
        );

        // =========================
        // SUMMARY
        // =========================

        HBox summary = new HBox();

        summary.setSpacing(15);

        VBox received = createSummaryBox(
                "Total Received",
                "₹18,450"
        );

        VBox pending = createSummaryBox(
                "Pending",
                "₹13,300"
        );

        VBox overdue = createSummaryBox(
                "Overdue",
                "₹0"
        );

        VBox total = createSummaryBox(
                "Total",
                "₹31,750"
        );

        summary.getChildren().addAll(
                received,
                pending,
                overdue,
                total
        );

        mainContent.getChildren().add(
                summary
        );

        // =========================
        // CENTER
        // =========================

        root.setCenter(
                mainContent
        );

        // =========================
        // SCENE
        // =========================

        return new Scene(
                root,
                1500,
                750
        );
    }

    // =========================
    // SUMMARY BOX
    // =========================

    private static VBox createSummaryBox(
            String title,
            String value
    ) {

        VBox box = new VBox();

        box.setSpacing(5);

        box.setPadding(
                new Insets(15)
        );

        box.setPrefWidth(200);

        box.setStyle(
                "-fx-background-color: #F4F7F8;" +
                "-fx-background-radius: 8;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #546E7A;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        box.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return box;
    }

    // =========================
    // PAYMENT CLASS
    // =========================

    public static class Payment {

        private String date;
        private String tenant;
        private String flat;
        private String paymentFor;
        private String amount;
        private String status;

        public Payment(
                String date,
                String tenant,
                String flat,
                String paymentFor,
                String amount,
                String status
        ) {

            this.date = date;
            this.tenant = tenant;
            this.flat = flat;
            this.paymentFor = paymentFor;
            this.amount = amount;
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public String getTenant() {
            return tenant;
        }

        public String getFlat() {
            return flat;
        }

        public String getPaymentFor() {
            return paymentFor;
        }

        public String getAmount() {
            return amount;
        }

        public String getStatus() {
            return status;
        }
    }
}