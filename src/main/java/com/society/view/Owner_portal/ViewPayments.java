package com.society.view.Owner_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewPayments {

    public static Scene createScene(Stage stage) {
    
        BorderPane root = new BorderPane();
        OwnerSidebar sidebar =new OwnerSidebar(stage);

        root.setLeft(sidebar.getSidebar());

       
        VBox mainContent = new VBox();

        mainContent.setPadding( new Insets(25, 35, 25, 35) );

        mainContent.setSpacing(15);

        mainContent.setAlignment(Pos.TOP_LEFT);

        mainContent.setStyle( "-fx-background-color: #e8ddd5;"
        );

        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox vb = new VBox();
        Label greeting = new Label("Payments");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        Label description = new Label("View all rental and maintenance payment");
        description.setStyle("-fx-font-size:12px;-fx-text-fill: #ffffff;");

        vb.getChildren().addAll(greeting,description);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        

        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));
        day.setStyle("-fx-text-fill: #ffffff;"); 
        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        date.setStyle("-fx-text-fill: #ffffff;"); 
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(vb,
                spacer,
                vb1);

        mainContent.getChildren().add(
                header
        );
        TableView<Payment> table = new TableView<>();
        table.setPrefHeight(500);
        table.setColumnResizePolicy( TableView.CONSTRAINED_RESIZE_POLICY
        );

        
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

       

        table.getItems().addAll(

                new Payment(
                        "10 May 2025",
                        "Aditi Hegde",
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
                        "Sanavi Gabale",
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

        mainContent.getChildren().add( summary
        );

        BorderPane mainarea = new BorderPane();
       mainarea.setTop(header);
       mainarea.setCenter(mainContent);
       root.setCenter(mainarea);
       
        return new Scene(
                root,
                1500,
                750
        );
    }

    
    private static VBox createSummaryBox(
            String title,
            String value
    ) {

        VBox box = new VBox();

        box.setSpacing(5);
        box.setPadding( new Insets(15)
        );
        box.setPrefWidth(200);
        box.setStyle(
                "-fx-background-color: #F4F7F8;-fx-background-radius: 8;");

        Label titleLabel =new Label(title);

        titleLabel.setStyle( "-fx-font-size: 13px;-fx-text-fill: #546E7A;"
        );

        Label valueLabel = new Label(value);

        valueLabel.setStyle(
                "-fx-font-size: 20px;-fx-font-weight: bold;fx-text-fill: #102A43;"
        );

        box.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return box;
    }

    
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