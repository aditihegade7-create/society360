package com.society.view.Resident_portal;

import com.society.controller.Resident_Controller.MaintenanceController;
import com.society.model.Resident_model.Maintenance;
import com.society.service.resident_service.*;
import com.society.view.ScreenSize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;

public class MyBills {

    private final MaintenanceController maintenanceController;

    private String flatNo;

    private Label totalBillsLabel;
    private Label totalDueLabel;
    private Label maintenanceDueLabel;
    private Label electricityDueLabel;

    private TableView<Maintenance> billTable;

    public MyBills() {

        maintenanceController =
                new MaintenanceController();
    }

    public Scene getMyBillsScene(Stage stage) {

        panel panelobj = new panel(stage);

        BorderPane root = new BorderPane();

        root.setLeft(
                panelobj.getSidebar()
        );

        BorderPane mainArea = new BorderPane();

        // =====================================================
        // HEADER
        // =====================================================

        VBox heading = new VBox(5);

        heading.setPadding(
                new Insets(20, 18, 18, 18)
        );

        heading.setStyle(
                "-fx-background-color: #4e342e;"
        );

        Label title = new Label("My Bills");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "View your society bills and payment status"
        );

        subtitle.setFont(
                Font.font("System", 14)
        );

        subtitle.setTextFill(Color.WHITE);

        heading.getChildren().addAll(
                title,
                subtitle
        );

        mainArea.setTop(heading);

        // =====================================================
        // CONTENT
        // =====================================================

        VBox content = new VBox(20);

        content.setPadding(
                new Insets(22, 32, 25, 32)
        );

        content.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // SUMMARY
        // =====================================================

        HBox summaryCards =
                createSummaryCards();

        // =====================================================
        // HISTORY TITLE
        // =====================================================

        Label historyTitle =
                new Label("Bill History");

        historyTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        20
                )
        );

        historyTitle.setTextFill(Color.WHITE);

        // =====================================================
        // TABLE
        // =====================================================

        billTable = createBillTable();

        // =====================================================
        // REFRESH
        // =====================================================

        Button refreshButton =
                new Button("Refresh Bills");

        refreshButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 6;"
        );

        refreshButton.setOnAction(
                e -> loadMaintenance()
        );

        HBox refreshBox =
                new HBox(refreshButton);

        refreshBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        // =====================================================
        // TABLE BOX
        // =====================================================

        VBox tableBox =
                new VBox(10);

        tableBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        tableBox.getChildren().add(
                billTable
        );

        VBox.setVgrow(
                billTable,
                Priority.ALWAYS
        );

        VBox.setVgrow(
                tableBox,
                Priority.ALWAYS
        );

        content.getChildren().addAll(
                summaryCards,
                historyTitle,
                refreshBox,
                tableBox
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setFitToHeight(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setStyle(
                "-fx-background: #e8ddd5;" +
                "-fx-background-color: #e8ddd5;"
        );

        mainArea.setCenter(scrollPane);

        root.setCenter(mainArea);

        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        // =====================================================
        // LOAD FIRESTORE DATA
        // =====================================================

        loadMaintenance();

        return scene;
    }

    // =========================================================
    // SUMMARY CARDS
    // =========================================================

    private HBox createSummaryCards() {

        totalBillsLabel =
                new Label("₹ 0");

        totalDueLabel =
                new Label("₹ 0");

        maintenanceDueLabel =
                new Label("₹ 0");

        electricityDueLabel =
                new Label("₹ 0");

        VBox totalBills =
                createCard(
                        "Total Bills",
                        totalBillsLabel,
                        "Current"
                );

        VBox totalDue =
                createCard(
                        "Total Due",
                        totalDueLabel,
                        "Pending"
                );

        VBox maintenanceDue =
                createCard(
                        "Maintenance Due",
                        maintenanceDueLabel,
                        "Pending"
                );

        VBox electricityDue =
                createCard(
                        "Electricity Due",
                        electricityDueLabel,
                        "Current"
                );

        HBox cards =
                new HBox(20);

        cards.getChildren().addAll(
                totalBills,
                totalDue,
                maintenanceDue,
                electricityDue
        );

        HBox.setHgrow(
                totalBills,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                totalDue,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                maintenanceDue,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                electricityDue,
                Priority.ALWAYS
        );

        return cards;
    }

    private VBox createCard(
            String title,
            Label amountLabel,
            String subtitle) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(20)
        );

        card.setPrefHeight(135);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        15
                )
        );

        titleLabel.setTextFill(
                Color.web("#607d8b")
        );

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        24
                )
        );

        amountLabel.setTextFill(
                Color.web("#263238")
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setTextFill(
                Color.web("#78909c")
        );

        card.getChildren().addAll(
                titleLabel,
                amountLabel,
                subtitleLabel
        );

        return card;
    }

    // =========================================================
    // TABLE
    // =========================================================

    private TableView<Maintenance> createBillTable() {

        TableView<Maintenance> table =
                new TableView<>();

        table.setPlaceholder(
                new Label(
                        "No maintenance bills found."
                )
        );

        TableColumn<Maintenance, String>
                billTypeColumn =
                new TableColumn<>("Bill Type");

        billTypeColumn.setCellValueFactory(
                data ->
                        new javafx.beans.property.SimpleStringProperty(
                                "Maintenance"
                        )
        );

        TableColumn<Maintenance, String>
                monthColumn =
                new TableColumn<>("Month");

        monthColumn.setCellValueFactory(
                new PropertyValueFactory<>("month")
        );

        TableColumn<Maintenance, String>
                amountColumn =
                new TableColumn<>("Amount");

        amountColumn.setCellValueFactory(
                new PropertyValueFactory<>("amount")
        );

        TableColumn<Maintenance, String>
                dateColumn =
                new TableColumn<>("Due Date");

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        TableColumn<Maintenance, String>
                statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        // =====================================================
        // PAYMENT BUTTON
        // =====================================================

        TableColumn<Maintenance, Void>
                paymentColumn =
                new TableColumn<>("Payment");

        paymentColumn.setCellFactory(
                column -> new TableCell<Maintenance, Void>() {

                    private final Button payButton =
                            new Button("Pay Now");

                    {
                        payButton.setStyle(
                                "-fx-background-color: #4e342e;" +
                                "-fx-text-fill: white;" +
                                "-fx-font-weight: bold;" +
                                "-fx-background-radius: 5;"
                        );

                        payButton.setOnAction(
                                event -> {

                                    Maintenance bill =
                                            getTableView()
                                                    .getItems()
                                                    .get(getIndex());

                                    payBill(bill);
                                }
                        );
                    }

                    @Override
                    protected void updateItem(
                            Void item,
                            boolean empty) {

                        super.updateItem(item, empty);

                        if (empty) {

                            setGraphic(null);

                        } else {

                            Maintenance bill =
                                    getTableView()
                                            .getItems()
                                            .get(getIndex());

                            if (bill != null &&
                                    "Pending".equalsIgnoreCase(
                                            bill.getStatus())) {

                                setGraphic(payButton);

                            } else {

                                setGraphic(null);
                            }
                        }
                    }
                }
        );

        billTypeColumn.setPrefWidth(150);
        monthColumn.setPrefWidth(170);
        amountColumn.setPrefWidth(150);
        dateColumn.setPrefWidth(150);
        statusColumn.setPrefWidth(150);
        paymentColumn.setPrefWidth(150);

        table.getColumns().addAll(
                billTypeColumn,
                monthColumn,
                amountColumn,
                dateColumn,
                statusColumn,
                paymentColumn
        );

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        return table;
    }

    // =========================================================
    // LOAD MAINTENANCE
    // =========================================================

    private void loadMaintenance() {

        System.out.println(
                "Refreshing Maintenance Bills..."
        );

        billTable.getItems().clear();

        String email =
                UserSession.getEmail();

        if (email == null || email.trim().isEmpty()) {

            System.out.println(
                    "ERROR: Logged-in email not found!"
            );

            return;
        }

        // =====================================================
        // GET FLAT FROM FIRESTORE
        // =====================================================

        flatNo =
                maintenanceController
                        .getFlatNoByEmail(email);

        if (flatNo == null ||
                flatNo.trim().isEmpty()) {

            System.out.println(
                    "ERROR: Logged-in flat number not found!"
            );

            return;
        }

        // =====================================================
        // GET ALL MAINTENANCE
        // =====================================================

        List<Maintenance> list =
                maintenanceController
                        .getMaintenanceByFlatNo(flatNo);

        if (list == null || list.isEmpty()) {

            totalBillsLabel.setText("₹ 0");
            totalDueLabel.setText("₹ 0");
            maintenanceDueLabel.setText("₹ 0");
            electricityDueLabel.setText("₹ 0");

            return;
        }

        // =====================================================
        // SHOW ALL BILLS
        // =====================================================

        billTable.getItems().addAll(list);

        // =====================================================
        // CALCULATE TOTALS
        // =====================================================

        double total = 0;

        double pending = 0;

        for (Maintenance bill : list) {

            double amount = parseAmount(
                    bill.getAmount()
            );

            total += amount;

            if ("Pending".equalsIgnoreCase(
                    bill.getStatus())) {

                pending += amount;
            }
        }

        totalBillsLabel.setText(
                "₹ " + total
        );

        totalDueLabel.setText(
                "₹ " + pending
        );

        maintenanceDueLabel.setText(
                "₹ " + pending
        );

        electricityDueLabel.setText(
                "₹ 0"
        );
    }

    // =========================================================
    // PARSE AMOUNT
    // =========================================================

    private double parseAmount(String amount) {

        if (amount == null) {
            return 0;
        }

        try {

            String number =
                    amount.replaceAll(
                            "[^0-9.]",
                            ""
                    );

            if (number.isEmpty()) {
                return 0;
            }

            return Double.parseDouble(number);

        } catch (Exception e) {

            return 0;
        }
    }

    // =========================================================
    // PAY BILL
    // =========================================================

    private void payBill(Maintenance bill) {

        Alert confirmation =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        confirmation.setTitle(
                "Payment"
        );

        confirmation.setHeaderText(
                "Pay Maintenance Bill"
        );

        confirmation.setContentText(
                "Month: " + bill.getMonth()
                        + "\nAmount: ₹"
                        + bill.getAmount()
        );

        confirmation.showAndWait()
                .ifPresent(response -> {

                    if (response ==
                            ButtonType.OK) {

                        boolean success =
                                maintenanceController
                                        .markAsPaid(
                                                bill.getDocumentId()
                                        );

                        if (success) {

                            Alert alert =
                                    new Alert(
                                            Alert.AlertType.INFORMATION
                                    );

                            alert.setTitle(
                                    "Payment Successful"
                            );

                            alert.setHeaderText(
                                    "Payment Completed"
                            );

                            alert.setContentText(
                                    "Your maintenance bill has been marked as Paid."
                            );

                            alert.showAndWait();

                            // Reload Firestore
                            loadMaintenance();
                        }
                    }
                });
    }
}