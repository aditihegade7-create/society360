package com.society.view.Resident_portal;

import com.society.dao.Resident_dao.MaintenanceDAO;
import com.society.dao.Welcome.UserDao;
import com.society.view.ScreenSize;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class MyBills {

    // =========================================================
    // DAO
    // =========================================================

    private final MaintenanceDAO maintenanceDAO;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public MyBills() {
        this.maintenanceDAO = new MaintenanceDAO();
    }

    // =========================================================
    // GET LOGGED-IN RESIDENT EMAIL
    // =========================================================

    private String getLoggedInResidentEmail() {

        String email = UserDao.getLoggedInEmail();

        if (email == null || email.trim().isEmpty()) {

            throw new IllegalStateException(
                    "No Resident is currently logged in."
            );
        }

        return email.trim().toLowerCase();
    }

    // =========================================================
    // GET BILL SCENE
    // =========================================================

    public Scene getBillScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        panel panelobj = new panel(stage);

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // TITLE
        // =====================================================

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

        VBox heading = new VBox(5);

        heading.setPadding(
                new Insets(15, 20, 15, 20)
        );

        heading.getChildren().addAll(
                title,
                subtitle
        );

        heading.setStyle(
                "-fx-background-color: #4e342e;"
        );

        // =====================================================
        // SUMMARY CARDS
        // =====================================================

        HBox summaryCards = new HBox(20);

        VBox totalDue = createSummaryCard(
                "Total Due",
                "₹ 0",
                "Pending amount"
        );

        VBox maintenanceDue = createSummaryCard(
                "Maintenance Due",
                "₹ 0",
                "Loading..."
        );

        VBox electricityDue = createSummaryCard(
                "Electricity Due",
                "₹ 0",
                "No data"
        );

        summaryCards.getChildren().addAll(
                totalDue,
                maintenanceDue,
                electricityDue
        );

        // =====================================================
        // BILL TITLE
        // =====================================================

        Label billTitle = new Label("Bill History");

        billTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        billTitle.setTextFill(Color.WHITE);

        // =====================================================
        // TABLE
        // =====================================================

        TableView<Bill> table = new TableView<>();

        table.setPrefHeight(300);

        table.setStyle(
                "-fx-background-color: white;"
        );

        // =====================================================
        // BILL TYPE
        // =====================================================

        TableColumn<Bill, String> typeColumn =
                new TableColumn<>("Bill Type");

        typeColumn.setCellValueFactory(
                data ->
                        data.getValue().typeProperty()
        );

        typeColumn.setPrefWidth(130);

        // =====================================================
        // MONTH
        // =====================================================

        TableColumn<Bill, String> monthColumn =
                new TableColumn<>("Month");

        monthColumn.setCellValueFactory(
                data ->
                        data.getValue().monthProperty()
        );

        monthColumn.setPrefWidth(130);

        // =====================================================
        // AMOUNT
        // =====================================================

        TableColumn<Bill, String> amountColumn =
                new TableColumn<>("Amount");

        amountColumn.setCellValueFactory(
                data ->
                        data.getValue().amountProperty()
        );

        amountColumn.setPrefWidth(130);

        // =====================================================
        // DUE DATE
        // =====================================================

        TableColumn<Bill, String> dueDateColumn =
                new TableColumn<>("Due Date");

        dueDateColumn.setCellValueFactory(
                data ->
                        data.getValue().dueDateProperty()
        );

        dueDateColumn.setPrefWidth(130);

        // =====================================================
        // STATUS
        // =====================================================

        TableColumn<Bill, String> statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                data ->
                        data.getValue().statusProperty()
        );

        statusColumn.setPrefWidth(130);

        // =====================================================
        // ADD COLUMNS
        // =====================================================

        table.getColumns().addAll(
                typeColumn,
                monthColumn,
                amountColumn,
                dueDateColumn,
                statusColumn
        );

        // =====================================================
        // FETCH MAINTENANCE
        // =====================================================

        loadMaintenance(
                table,
                totalDue,
                maintenanceDue
        );

        // =====================================================
        // PAY BUTTON
        // =====================================================

        Button payButton =
                new Button("Pay Selected Bill");

        payButton.setPrefHeight(40);

        payButton.setPrefWidth(160);

        payButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: #f3e5e2;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        // =====================================================
        // PAY BUTTON ACTION
        // =====================================================

        payButton.setOnAction(e -> {

            Bill selectedBill =
                    table.getSelectionModel()
                            .getSelectedItem();

            if (selectedBill == null) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.WARNING
                        );

                alert.setTitle(
                        "No Bill Selected"
                );

                alert.setHeaderText(null);

                alert.setContentText(
                        "Please select a bill first."
                );

                alert.showAndWait();

                return;
            }

            // =================================================
            // ALREADY PAID
            // =================================================

            if (selectedBill.getStatus()
                    .equalsIgnoreCase("Paid")) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );

                alert.setTitle(
                        "Payment Status"
                );

                alert.setHeaderText(
                        "Bill Already Paid"
                );

                alert.setContentText(
                        "This maintenance bill is already marked as Paid."
                );

                alert.showAndWait();

                return;
            }

            // =================================================
            // PAYMENT DETAILS
            // =================================================

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle(
                    "Payment"
            );

            alert.setHeaderText(
                    "Payment Details"
            );

            alert.setContentText(
                    "Bill: "
                            + selectedBill.getType()
                            + "\nAmount: "
                            + selectedBill.getAmount()
                            + "\nMonth: "
                            + selectedBill.getMonth()
                            + "\nDue Date: "
                            + selectedBill.getDueDate()
                            + "\nStatus: "
                            + selectedBill.getStatus()
            );

            alert.showAndWait();
        });

        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox = new HBox();

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().add(
                payButton
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        mainContent.getChildren().addAll(
                heading,
                summaryCards,
                billTitle,
                table,
                buttonBox
        );

        // =====================================================
        // CENTER AREA
        // =====================================================

        BorderPane mainarea =
                new BorderPane();

        mainarea.setCenter(
                mainContent
        );

        root.setCenter(
                mainarea
        );

        // =====================================================
        // RETURN SCENE
        // =====================================================

        return new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }

    // =========================================================
    // LOAD MAINTENANCE
    // =========================================================

    private void loadMaintenance(
            TableView<Bill> table,
            VBox totalDue,
            VBox maintenanceDue
    ) {

        double totalPendingAmount = 0.0;

        int pendingCount = 0;

        try {

            // =================================================
            // LOGGED-IN RESIDENT
            // =================================================

            String loggedInEmail =
                    getLoggedInResidentEmail();

            System.out.println(
                    "=============================================="
            );

            System.out.println(
                    "FETCHING MAINTENANCE FOR RESIDENT"
            );

            System.out.println(
                    "Resident Email : "
                            + loggedInEmail
            );

            // =================================================
            // FETCH BY RESIDENT EMAIL
            // =================================================
            //
            // DAO internally:
            //
            // Residents/{email}
            //       ↓
            //      society
            //       ↓
            // Maintenance/{secretaryEmail}/records
            //       ↓
            // filter by society
            //
            // =================================================

            List<Map<String, Object>> maintenanceList =
                    maintenanceDAO.getMaintenanceByEmail(
                            loggedInEmail
                    );

            System.out.println(
                    "Maintenance Records Found : "
                            + (
                            maintenanceList == null
                                    ? 0
                                    : maintenanceList.size()
                    )
            );

            // =================================================
            // NO DATA
            // =================================================

            if (maintenanceList == null
                    || maintenanceList.isEmpty()) {

                table.setPlaceholder(
                        new Label(
                                "No maintenance bills found"
                        )
                );

                updateMaintenanceCards(
                        totalDue,
                        maintenanceDue,
                        0.0,
                        0
                );

                System.out.println(
                        "No maintenance records found for resident."
                );

                return;
            }

            // =================================================
            // LOOP MAINTENANCE
            // =================================================

            for (Map<String, Object> data :
                    maintenanceList) {

                if (data == null) {
                    continue;
                }

                String amount =
                        getValue(
                                data,
                                "amount"
                        );

                String month =
                        getValue(
                                data,
                                "month"
                        );

                String date =
                        getValue(
                                data,
                                "date"
                        );

                String status =
                        getValue(
                                data,
                                "status"
                        );

                // =================================================
                // DEFAULT VALUES
                // =================================================

                if (month.isEmpty()) {
                    month = "-";
                }

                if (date.isEmpty()) {
                    date = "-";
                }

                if (status.isEmpty()) {
                    status = "Pending";
                }

                // =================================================
                // FORMAT AMOUNT
                // =================================================

                String displayAmount;

                if (amount.isEmpty()) {

                    displayAmount = "₹ 0";

                } else if (
                        amount.startsWith("₹")
                ) {

                    displayAmount = amount;

                } else {

                    displayAmount =
                            "₹ " + amount;
                }

                // =================================================
                // ADD TO TABLE
                // =================================================

                table.getItems().add(
                        new Bill(
                                "Maintenance",
                                month,
                                displayAmount,
                                date,
                                normalizeStatus(status)
                        )
                );

                // =================================================
                // AMOUNT
                // =================================================

                double numericAmount =
                        parseAmount(amount);

                // =================================================
                // PENDING
                // =================================================

                if (isPendingStatus(status)) {

                    totalPendingAmount +=
                            numericAmount;

                    pendingCount++;
                }
            }

            // =================================================
            // UPDATE CARDS
            // =================================================

            updateMaintenanceCards(
                    totalDue,
                    maintenanceDue,
                    totalPendingAmount,
                    pendingCount
            );

            System.out.println(
                    "Total Pending Amount : ₹"
                            + totalPendingAmount
            );

            System.out.println(
                    "Pending Bills : "
                            + pendingCount
            );

            System.out.println(
                    "=============================================="
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while loading maintenance:"
            );

            e.printStackTrace();

            table.setPlaceholder(
                    new Label(
                            "Unable to load maintenance bills"
                    )
            );

            updateMaintenanceCards(
                    totalDue,
                    maintenanceDue,
                    0.0,
                    0
            );
        }
    }

    // =========================================================
    // UPDATE SUMMARY CARDS
    // =========================================================

    private void updateMaintenanceCards(
            VBox totalDue,
            VBox maintenanceDue,
            double pendingAmount,
            int pendingCount
    ) {

        // =====================================================
        // MAINTENANCE CARD
        // =====================================================

        Label maintenanceAmountLabel =
                (Label) maintenanceDue
                        .getChildren()
                        .get(1);

        maintenanceAmountLabel.setText(
                formatCurrency(
                        pendingAmount
                )
        );

        Label maintenanceDescriptionLabel =
                (Label) maintenanceDue
                        .getChildren()
                        .get(2);

        if (pendingCount == 0) {

            maintenanceDescriptionLabel.setText(
                    "No pending maintenance"
            );

        } else if (pendingCount == 1) {

            maintenanceDescriptionLabel.setText(
                    "1 pending bill"
            );

        } else {

            maintenanceDescriptionLabel.setText(
                    pendingCount
                            + " pending bills"
            );
        }

        // =====================================================
        // TOTAL DUE
        // =====================================================

        Label totalAmountLabel =
                (Label) totalDue
                        .getChildren()
                        .get(1);

        totalAmountLabel.setText(
                formatCurrency(
                        pendingAmount
                )
        );

        Label totalDescriptionLabel =
                (Label) totalDue
                        .getChildren()
                        .get(2);

        if (pendingAmount > 0) {

            totalDescriptionLabel.setText(
                    "Pending amount"
            );

        } else {

            totalDescriptionLabel.setText(
                    "No pending amount"
            );
        }
    }

    // =========================================================
    // GET VALUE
    // =========================================================

    private String getValue(
            Map<String, Object> data,
            String field
    ) {

        if (data == null) {
            return "";
        }

        Object value =
                data.get(field);

        if (value == null) {
            return "";
        }

        return String.valueOf(
                value
        ).trim();
    }

    // =========================================================
    // PARSE AMOUNT
    // =========================================================

    private double parseAmount(
            String amount
    ) {

        try {

            if (amount == null
                    || amount.trim().isEmpty()) {

                return 0.0;
            }

            String cleanedAmount =
                    amount
                            .replace("₹", "")
                            .replace(",", "")
                            .trim();

            return Double.parseDouble(
                    cleanedAmount
            );

        } catch (Exception e) {

            System.err.println(
                    "Invalid maintenance amount: "
                            + amount
            );

            return 0.0;
        }
    }

    // =========================================================
    // CHECK PENDING STATUS
    // =========================================================

    private boolean isPendingStatus(
            String status
    ) {

        if (status == null) {
            return false;
        }

        String normalized =
                status.trim()
                        .toLowerCase();

        return normalized.equals("pending")
                || normalized.equals("unpaid")
                || normalized.equals("overdue");
    }

    // =========================================================
    // NORMALIZE STATUS
    // =========================================================

    private String normalizeStatus(
            String status
    ) {

        if (status == null
                || status.trim().isEmpty()) {

            return "Pending";
        }

        String value =
                status.trim();

        if (value.equalsIgnoreCase("pending")) {
            return "Pending";
        }

        if (value.equalsIgnoreCase("paid")) {
            return "Paid";
        }

        if (value.equalsIgnoreCase("overdue")) {
            return "Overdue";
        }

        if (value.equalsIgnoreCase("unpaid")) {
            return "Pending";
        }

        if (value.equalsIgnoreCase("open")) {
            return "Pending";
        }

        if (value.equalsIgnoreCase("in progress")) {
            return "In Progress";
        }

        return value;
    }

    // =========================================================
    // FORMAT CURRENCY
    // =========================================================

    private String formatCurrency(
            double amount
    ) {

        if (amount == 0) {
            return "₹ 0";
        }

        if (amount == Math.floor(amount)) {

            return String.format(
                    "₹ %.0f",
                    amount
            );
        }

        return String.format(
                "₹ %.2f",
                amount
        );
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private VBox createSummaryCard(
            String heading,
            String amount,
            String description
    ) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setPrefWidth(220);

        card.setPrefHeight(105);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;" +
                "-fx-border-radius: 8;"
        );

        Label headingLabel =
                new Label(heading);

        headingLabel.setTextFill(
                Color.web("#546E7A")
        );

        headingLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        Label amountLabel =
                new Label(amount);

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        22
                )
        );

        amountLabel.setTextFill(
                Color.web("#37474F")
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setTextFill(
                Color.GRAY
        );

        card.getChildren().addAll(
                headingLabel,
                amountLabel,
                descriptionLabel
        );

        return card;
    }

    // =========================================================
    // BILL CLASS
    // =========================================================

    public static class Bill {

        private final SimpleStringProperty type;

        private final SimpleStringProperty month;

        private final SimpleStringProperty amount;

        private final SimpleStringProperty dueDate;

        private final SimpleStringProperty status;

        // =====================================================
        // CONSTRUCTOR
        // =====================================================

        public Bill(
                String type,
                String month,
                String amount,
                String dueDate,
                String status
        ) {

            this.type =
                    new SimpleStringProperty(
                            type
                    );

            this.month =
                    new SimpleStringProperty(
                            month
                    );

            this.amount =
                    new SimpleStringProperty(
                            amount
                    );

            this.dueDate =
                    new SimpleStringProperty(
                            dueDate
                    );

            this.status =
                    new SimpleStringProperty(
                            status
                    );
        }

        // =====================================================
        // PROPERTIES
        // =====================================================

        public StringProperty typeProperty() {
            return type;
        }

        public StringProperty monthProperty() {
            return month;
        }

        public StringProperty amountProperty() {
            return amount;
        }

        public StringProperty dueDateProperty() {
            return dueDate;
        }

        public StringProperty statusProperty() {
            return status;
        }

        // =====================================================
        // GETTERS
        // =====================================================

        public String getType() {
            return type.get();
        }

        public String getMonth() {
            return month.get();
        }

        public String getAmount() {
            return amount.get();
        }

        public String getDueDate() {
            return dueDate.get();
        }

        public String getStatus() {
            return status.get();
        }
    }
}