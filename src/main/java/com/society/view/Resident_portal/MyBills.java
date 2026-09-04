package com.society.view.Resident_portal;

import com.society.dao.Secretary_dao.manegedao;
import com.society.dao.Welcome.UserDao;
import com.society.model.Secretary_model.Maintenance;
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

public class MyBills {

    // =========================================================
    // DAO
    // =========================================================

    private final manegedao maintenanceDAO;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public MyBills() {

        maintenanceDAO =
                new manegedao();
    }

    // =========================================================
    // GET LOGGED-IN RESIDENT EMAIL
    // =========================================================

    private String getLoggedInResidentEmail() {

        try {

            String email =
                    UserDao.getLoggedInEmail();

            if (email == null ||
                    email.trim().isEmpty()) {

                System.err.println(
                        "Logged-in resident email is empty."
                );

                return "";
            }

            email =
                    email
                            .trim()
                            .toLowerCase();

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "LOGGED-IN RESIDENT"
            );

            System.out.println(
                    "Resident Email = "
                            + email
            );

            System.out.println(
                    "=========================================="
            );

            return email;

        } catch (Exception e) {

            System.err.println(
                    "Error while getting logged-in resident email:"
            );

            e.printStackTrace();

            return "";
        }
    }

    // =========================================================
    // GET BILL SCENE
    // =========================================================

    public Scene getBillScene(Stage stage) {

        // =====================================================
        // LOGGED-IN RESIDENT
        // =====================================================

        String residentEmail =
                getLoggedInResidentEmail();

        // =====================================================
        // SIDEBAR
        // =====================================================

        panel panelobj =
                new panel(stage);

        BorderPane root =
                new BorderPane();

        root.setLeft(
                panelobj.getSidebar()
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent =
                new VBox(20);

        mainContent.setPadding(
                new Insets(
                        30,
                        40,
                        30,
                        40
                )
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label(
                        "My Bills"
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(
                Color.WHITE
        );

        Label subtitle =
                new Label(
                        "View your society bills and payment status"
                );

        subtitle.setFont(
                Font.font(
                        "System",
                        14
                )
        );

        subtitle.setTextFill(
                Color.WHITE
        );

        VBox heading =
                new VBox(5);

        heading.setPadding(
                new Insets(
                        15,
                        20,
                        15,
                        20
                )
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

        HBox summaryCards =
                new HBox(20);

        VBox totalDue =
                createSummaryCard(
                        "Total Due",
                        "₹ 0",
                        "Pending amount"
                );

        VBox maintenanceDue =
                createSummaryCard(
                        "Maintenance Due",
                        "₹ 0",
                        "Loading..."
                );

        VBox electricityDue =
                createSummaryCard(
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

        Label billTitle =
                new Label(
                        "Bill History"
                );

        billTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        billTitle.setTextFill(
                Color.WHITE
        );

        // =====================================================
        // TABLE
        // =====================================================

        TableView<Bill> table =
                new TableView<>();

        table.setPrefHeight(300);

        table.setStyle(
                "-fx-background-color: white;"
        );

        // =====================================================
        // BILL TYPE
        // =====================================================

        TableColumn<Bill, String> typeColumn =
                new TableColumn<>(
                        "Bill Type"
                );

        typeColumn.setCellValueFactory(
                data ->
                        data.getValue()
                                .typeProperty()
        );

        typeColumn.setPrefWidth(130);

        // =====================================================
        // MONTH
        // =====================================================

        TableColumn<Bill, String> monthColumn =
                new TableColumn<>(
                        "Month"
                );

        monthColumn.setCellValueFactory(
                data ->
                        data.getValue()
                                .monthProperty()
        );

        monthColumn.setPrefWidth(130);

        // =====================================================
        // AMOUNT
        // =====================================================

        TableColumn<Bill, String> amountColumn =
                new TableColumn<>(
                        "Amount"
                );

        amountColumn.setCellValueFactory(
                data ->
                        data.getValue()
                                .amountProperty()
        );

        amountColumn.setPrefWidth(130);

        // =====================================================
        // DATE
        // =====================================================

        TableColumn<Bill, String> dueDateColumn =
                new TableColumn<>(
                        "Date"
                );

        dueDateColumn.setCellValueFactory(
                data ->
                        data.getValue()
                                .dueDateProperty()
        );

        dueDateColumn.setPrefWidth(130);

        // =====================================================
        // STATUS
        // =====================================================

        TableColumn<Bill, String> statusColumn =
                new TableColumn<>(
                        "Status"
                );

        statusColumn.setCellValueFactory(
                data ->
                        data.getValue()
                                .statusProperty()
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
        // LOAD MAINTENANCE
        // =====================================================

        loadMaintenance(
                residentEmail,
                table,
                totalDue,
                maintenanceDue
        );

        // =====================================================
        // PAY BUTTON
        // =====================================================

        Button payButton =
                new Button(
                        "Pay Selected Bill"
                );

        payButton.setPrefHeight(40);

        payButton.setPrefWidth(160);

        payButton.setStyle(
                "-fx-background-color: #4e342e;"
                        + "-fx-text-fill: #f3e5e2;"
                        + "-fx-font-weight: bold;"
                        + "-fx-background-radius: 6;"
        );

        // =====================================================
        // PAY BUTTON ACTION
        // =====================================================

        payButton.setOnAction(e -> {

            Bill selectedBill =
                    table
                            .getSelectionModel()
                            .getSelectedItem();

            if (selectedBill == null) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.WARNING
                        );

                alert.setTitle(
                        "No Bill Selected"
                );

                alert.setHeaderText(
                        null
                );

                alert.setContentText(
                        "Please select a bill first."
                );

                alert.showAndWait();

                return;
            }

            // =================================================
            // ALREADY PAID
            // =================================================

            if (selectedBill
                    .getStatus()
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
                            + "\nDate: "
                            + selectedBill.getDueDate()
                            + "\nStatus: "
                            + selectedBill.getStatus()
                            + "\nSociety: "
                            + selectedBill.getSociety()
                            + "\nSecretary: "
                            + selectedBill.getSecretaryEmail()
            );

            alert.showAndWait();
        });

        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox =
                new HBox();

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
        // CENTER
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
            String residentEmail,
            TableView<Bill> table,
            VBox totalDue,
            VBox maintenanceDue) {

        try {

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "FETCHING SOCIETY MAINTENANCE"
            );

            System.out.println(
                    "Resident Email = "
                            + residentEmail
            );

            // =================================================
            // EMAIL CHECK
            // =================================================

            if (residentEmail == null ||
                    residentEmail.trim().isEmpty()) {

                table.setPlaceholder(
                        new Label(
                                "Logged-in resident not found"
                        )
                );

                updateCards(
                        totalDue,
                        maintenanceDue,
                        0,
                        0
                );

                return;
            }

            residentEmail =
                    residentEmail
                            .trim()
                            .toLowerCase();

            // =================================================
            // FETCH MAINTENANCE
            // =================================================
            //
            // IMPORTANT:
            //
            // Do NOT use:
            //
            // manegedao.getMaintenanceByEmail()
            //
            // because that is static and incorrect.
            //
            // We use the DAO object:
            //
            // maintenanceDAO.getMaintenanceByEmail()
            //
            // =================================================

            List<Maintenance> maintenanceList =
                    maintenanceDAO
                            .getMaintenanceByEmail(
                                    residentEmail
                            );

            System.out.println(
                    "Maintenance records received = "
                            + (
                                    maintenanceList == null
                                            ? 0
                                            : maintenanceList.size()
                            )
            );

            // =================================================
            // NO DATA
            // =================================================

            if (maintenanceList == null ||
                    maintenanceList.isEmpty()) {

                table.setPlaceholder(
                        new Label(
                                "No maintenance bills found for your society"
                        )
                );

                updateCards(
                        totalDue,
                        maintenanceDue,
                        0,
                        0
                );

                return;
            }

            // =================================================
            // CLEAR TABLE
            // =================================================

            table.getItems().clear();

            // =================================================
            // SUMMARY
            // =================================================

            double totalPendingAmount =
                    0.0;

            int pendingCount =
                    0;

            // =================================================
            // LOOP
            // =================================================

            for (Maintenance maintenance :
                    maintenanceList) {

                if (maintenance == null) {

                    continue;
                }

                // -------------------------------------------------
                // MAINTENANCE ID
                // -------------------------------------------------

                String maintenanceId =
                        safeValue(
                                maintenance
                                        .getMaintenanceId()
                        );

                // -------------------------------------------------
                // AMOUNT
                // -------------------------------------------------

                String amount =
                        safeValue(
                                maintenance
                                        .getAmount()
                        );

                // -------------------------------------------------
                // MONTH
                // -------------------------------------------------

                String month =
                        safeValue(
                                maintenance
                                        .getMonth()
                        );

                // -------------------------------------------------
                // DATE
                // -------------------------------------------------

                String date =
                        safeValue(
                                maintenance
                                        .getDate()
                        );

                // -------------------------------------------------
                // STATUS
                // -------------------------------------------------

                String status =
                        normalizeStatus(
                                maintenance
                                        .getStatus()
                        );

                // -------------------------------------------------
                // SOCIETY
                // -------------------------------------------------

                String society =
                        safeValue(
                                maintenance
                                        .getSociety()
                        );

                // -------------------------------------------------
                // SECRETARY EMAIL
                // -------------------------------------------------

                String secretaryEmail =
                        safeValue(
                                maintenance
                                        .getAddedBySecretaryEmail()
                        );

                // -------------------------------------------------
                // DEFAULT VALUES
                // -------------------------------------------------

                if (maintenanceId.isEmpty()) {

                    maintenanceId = "-";
                }

                if (month.isEmpty()) {

                    month = "-";
                }

                if (date.isEmpty()) {

                    date = "-";
                }

                if (status.isEmpty()) {

                    status = "Pending";
                }

                if (society.isEmpty()) {

                    society = "-";
                }

                if (secretaryEmail.isEmpty()) {

                    secretaryEmail = "-";
                }

                // =================================================
                // AMOUNT DISPLAY
                // =================================================

                String displayAmount;

                if (amount.isEmpty()) {

                    displayAmount =
                            "₹ 0";

                } else if (
                        amount.startsWith("₹")) {

                    displayAmount =
                            amount;

                } else {

                    displayAmount =
                            "₹ " + amount;
                }

                // =================================================
                // BILL
                // =================================================

                Bill bill =
                        new Bill(
                                maintenanceId,
                                "Maintenance",
                                month,
                                displayAmount,
                                date,
                                status,
                                society,
                                secretaryEmail
                        );

                // =================================================
                // ADD TO TABLE
                // =================================================

                table.getItems().add(
                        bill
                );

                // =================================================
                // NUMERIC AMOUNT
                // =================================================

                double numericAmount =
                        parseAmount(
                                amount
                        );

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

            updateCards(
                    totalDue,
                    maintenanceDue,
                    totalPendingAmount,
                    pendingCount
            );

            System.out.println(
                    "Total Pending Amount = ₹ "
                            + totalPendingAmount
            );

            System.out.println(
                    "Pending Maintenance Count = "
                            + pendingCount
            );

            System.out.println(
                    "Total Maintenance Displayed = "
                            + table.getItems().size()
            );

            System.out.println(
                    "=========================================="
            );

        } catch (Exception e) {

            System.err.println(
                    "Error while loading maintenance:"
            );

            e.printStackTrace();

            table.setPlaceholder(
                    new Label(
                            "Error while loading maintenance"
                    )
            );

            updateCards(
                    totalDue,
                    maintenanceDue,
                    0,
                    0
            );
        }
    }

    // =========================================================
    // UPDATE SUMMARY CARDS
    // =========================================================

    private void updateCards(
            VBox totalDue,
            VBox maintenanceDue,
            double pendingAmount,
            int pendingCount) {

        // =====================================================
        // MAINTENANCE
        // =====================================================

        Label maintenanceAmountLabel =
                (Label)
                        maintenanceDue
                                .getChildren()
                                .get(1);

        maintenanceAmountLabel.setText(
                formatCurrency(
                        pendingAmount
                )
        );

        Label maintenanceDescriptionLabel =
                (Label)
                        maintenanceDue
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
                (Label)
                        totalDue
                                .getChildren()
                                .get(1);

        totalAmountLabel.setText(
                formatCurrency(
                        pendingAmount
                )
        );

        Label totalDescriptionLabel =
                (Label)
                        totalDue
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
    // SAFE VALUE
    // =========================================================

    private String safeValue(
            String value) {

        if (value == null) {

            return "";
        }

        return value.trim();
    }

    // =========================================================
    // PARSE AMOUNT
    // =========================================================

    private double parseAmount(
            String amount) {

        try {

            if (amount == null ||
                    amount.trim().isEmpty()) {

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

            System.out.println(
                    "Invalid maintenance amount: "
                            + amount
            );

            return 0.0;
        }
    }

    // =========================================================
    // CHECK PENDING
    // =========================================================

    private boolean isPendingStatus(
            String status) {

        if (status == null) {

            return false;
        }

        String normalizedStatus =
                status
                        .trim()
                        .toLowerCase();

        return normalizedStatus.equals(
                        "pending"
                )
                || normalizedStatus.equals(
                        "unpaid"
                )
                || normalizedStatus.equals(
                        "overdue"
                );
    }

    // =========================================================
    // NORMALIZE STATUS
    // =========================================================

    private String normalizeStatus(
            String status) {

        if (status == null ||
                status.trim().isEmpty()) {

            return "Pending";
        }

        String value =
                status.trim();

        if (value.equalsIgnoreCase(
                "pending")) {

            return "Pending";
        }

        if (value.equalsIgnoreCase(
                "paid")) {

            return "Paid";
        }

        if (value.equalsIgnoreCase(
                "overdue")) {

            return "Overdue";
        }

        if (value.equalsIgnoreCase(
                "unpaid")) {

            return "Pending";
        }

        if (value.equalsIgnoreCase(
                "open")) {

            return "Pending";
        }

        if (value.equalsIgnoreCase(
                "in progress")) {

            return "In Progress";
        }

        return value;
    }

    // =========================================================
    // FORMAT CURRENCY
    // =========================================================

    private String formatCurrency(
            double amount) {

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
            String description) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setPrefWidth(220);

        card.setPrefHeight(105);

        card.setStyle(
                "-fx-background-color: white;"
                        + "-fx-background-radius: 8;"
                        + "-fx-border-radius: 8;"
        );

        Label headingLabel =
                new Label(
                        heading
                );

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
                new Label(
                        amount
                );

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
                new Label(
                        description
                );

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

        private final SimpleStringProperty maintenanceId;
        private final SimpleStringProperty type;
        private final SimpleStringProperty month;
        private final SimpleStringProperty amount;
        private final SimpleStringProperty dueDate;
        private final SimpleStringProperty status;
        private final SimpleStringProperty society;
        private final SimpleStringProperty secretaryEmail;

        // =====================================================
        // CONSTRUCTOR
        // =====================================================

        public Bill(
                String maintenanceId,
                String type,
                String month,
                String amount,
                String dueDate,
                String status,
                String society,
                String secretaryEmail) {

            this.maintenanceId =
                    new SimpleStringProperty(
                            maintenanceId
                    );

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

            this.society =
                    new SimpleStringProperty(
                            society
                    );

            this.secretaryEmail =
                    new SimpleStringProperty(
                            secretaryEmail
                    );
        }

        // =====================================================
        // MAINTENANCE ID
        // =====================================================

        public StringProperty maintenanceIdProperty() {

            return maintenanceId;
        }

        public String getMaintenanceId() {

            return maintenanceId.get();
        }

        // =====================================================
        // TYPE
        // =====================================================

        public StringProperty typeProperty() {

            return type;
        }

        public String getType() {

            return type.get();
        }

        // =====================================================
        // MONTH
        // =====================================================

        public StringProperty monthProperty() {

            return month;
        }

        public String getMonth() {

            return month.get();
        }

        // =====================================================
        // AMOUNT
        // =====================================================

        public StringProperty amountProperty() {

            return amount;
        }

        public String getAmount() {

            return amount.get();
        }

        // =====================================================
        // DATE
        // =====================================================

        public StringProperty dueDateProperty() {

            return dueDate;
        }

        public String getDueDate() {

            return dueDate.get();
        }

        // =====================================================
        // STATUS
        // =====================================================

        public StringProperty statusProperty() {

            return status;
        }

        public String getStatus() {

            return status.get();
        }

        // =====================================================
        // SOCIETY
        // =====================================================

        public StringProperty societyProperty() {

            return society;
        }

        public String getSociety() {

            return society.get();
        }

        // =====================================================
        // SECRETARY EMAIL
        // =====================================================

        public StringProperty secretaryEmailProperty() {

            return secretaryEmail;
        }

        public String getSecretaryEmail() {

            return secretaryEmail.get();
        }
    }
}