package com.society.view.Resident_portal;

import com.society.dao.Resident_dao.MaintenanceDAO;
import com.society.view.ScreenSize;

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

import java.util.Map;


public class Mybills {

    // =========================================================
    // LOGGED-IN USER EMAIL
    // =========================================================

    /*
     * TEMPORARY:
     * This is the email from your Firestore screenshot.
     *
     * Later, replace this with the email of the
     * currently logged-in resident.
     */
    private String loggedInEmail = "vaishnavi@gmail.com";


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


        // Initially empty
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
        // BILL TYPE COLUMN
        // =====================================================

        TableColumn<Bill, String> typeColumn =
                new TableColumn<>("Bill Type");

        typeColumn.setCellValueFactory(
                data ->
                        data.getValue().typeProperty()
        );


        // =====================================================
        // MONTH COLUMN
        // =====================================================

        TableColumn<Bill, String> monthColumn =
                new TableColumn<>("Month");

        monthColumn.setCellValueFactory(
                data ->
                        data.getValue().monthProperty()
        );


        // =====================================================
        // AMOUNT COLUMN
        // =====================================================

        TableColumn<Bill, String> amountColumn =
                new TableColumn<>("Amount");

        amountColumn.setCellValueFactory(
                data ->
                        data.getValue().amountProperty()
        );


        // =====================================================
        // DUE DATE COLUMN
        // =====================================================

        TableColumn<Bill, String> dueDateColumn =
                new TableColumn<>("Due Date");

        dueDateColumn.setCellValueFactory(
                data ->
                        data.getValue().dueDateProperty()
        );


        // =====================================================
        // STATUS COLUMN
        // =====================================================

        TableColumn<Bill, String> statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                data ->
                        data.getValue().statusProperty()
        );


        // =====================================================
        // ADD COLUMNS TO TABLE
        // =====================================================

        table.getColumns().addAll(
                typeColumn,
                monthColumn,
                amountColumn,
                dueDateColumn,
                statusColumn
        );


        // =====================================================
        // FETCH MAINTENANCE FROM FIRESTORE
        // =====================================================

        MaintenanceDAO maintenanceDAO =
                new MaintenanceDAO();


        Map<String, Object> maintenanceData =
                maintenanceDAO.getMaintenanceByEmail(
                        loggedInEmail
                );


        // =====================================================
        // CHECK FIRESTORE DATA
        // =====================================================

        if (maintenanceData != null) {

            // -------------------------------------------------
            // GET DATA FROM FIRESTORE
            // -------------------------------------------------

            String amount = getValue(
                    maintenanceData,
                    "amount"
            );

            String date = getValue(
                    maintenanceData,
                    "date"
            );

            String month = getValue(
                    maintenanceData,
                    "month"
            );

            String status = getValue(
                    maintenanceData,
                    "status"
            );


            // -------------------------------------------------
            // ADD ₹ SYMBOL
            // -------------------------------------------------

            String displayAmount;

            if (amount.startsWith("₹")) {

                displayAmount = amount;

            } else {

                displayAmount = "₹ " + amount;
            }


            // -------------------------------------------------
            // ADD MAINTENANCE TO TABLE
            // -------------------------------------------------

            table.getItems().add(
                    new Bill(
                            "Maintenance",
                            month,
                            displayAmount,
                            date,
                            status
                    )
            );


            // -------------------------------------------------
            // UPDATE MAINTENANCE CARD
            // -------------------------------------------------

            Label maintenanceAmountLabel =
                    (Label) maintenanceDue
                            .getChildren()
                            .get(1);

            maintenanceAmountLabel.setText(
                    displayAmount
            );


            Label maintenanceDescriptionLabel =
                    (Label) maintenanceDue
                            .getChildren()
                            .get(2);

            maintenanceDescriptionLabel.setText(
                    month
            );


            // -------------------------------------------------
            // UPDATE TOTAL DUE
            // -------------------------------------------------

            Label totalAmountLabel =
                    (Label) totalDue
                            .getChildren()
                            .get(1);

            if (status.equalsIgnoreCase("Pending")) {

                totalAmountLabel.setText(
                        displayAmount
                );

            } else {

                totalAmountLabel.setText(
                        "₹ 0"
                );
            }


            // -------------------------------------------------
            // UPDATE TOTAL DESCRIPTION
            // -------------------------------------------------

            Label totalDescriptionLabel =
                    (Label) totalDue
                            .getChildren()
                            .get(2);

            totalDescriptionLabel.setText(
                    status
            );


        } else {

            // =================================================
            // NO DATA FOUND
            // =================================================

            table.setPlaceholder(
                    new Label(
                            "No maintenance bills found"
                    )
            );


            Label maintenanceAmountLabel =
                    (Label) maintenanceDue
                            .getChildren()
                            .get(1);

            maintenanceAmountLabel.setText(
                    "₹ 0"
            );


            Label maintenanceDescriptionLabel =
                    (Label) maintenanceDue
                            .getChildren()
                            .get(2);

            maintenanceDescriptionLabel.setText(
                    "No maintenance record"
            );


            Label totalAmountLabel =
                    (Label) totalDue
                            .getChildren()
                            .get(1);

            totalAmountLabel.setText(
                    "₹ 0"
            );


            Label totalDescriptionLabel =
                    (Label) totalDue
                            .getChildren()
                            .get(2);

            totalDescriptionLabel.setText(
                    "No pending amount"
            );
        }


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


            } else {

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
                                + "\nStatus: "
                                + selectedBill.getStatus()
                );

                alert.showAndWait();
            }
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
    // SAFE GET VALUE FROM FIRESTORE
    // =========================================================

    private String getValue(
            Map<String, Object> data,
            String field
    ) {

        Object value = data.get(field);

        if (value == null) {
            return "";
        }

        return String.valueOf(value);
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

        private final javafx.beans.property.SimpleStringProperty type;

        private final javafx.beans.property.SimpleStringProperty month;

        private final javafx.beans.property.SimpleStringProperty amount;

        private final javafx.beans.property.SimpleStringProperty dueDate;

        private final javafx.beans.property.SimpleStringProperty status;


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
                    new javafx.beans.property.SimpleStringProperty(
                            type
                    );

            this.month =
                    new javafx.beans.property.SimpleStringProperty(
                            month
                    );

            this.amount =
                    new javafx.beans.property.SimpleStringProperty(
                            amount
                    );

            this.dueDate =
                    new javafx.beans.property.SimpleStringProperty(
                            dueDate
                    );

            this.status =
                    new javafx.beans.property.SimpleStringProperty(
                            status
                    );
        }


        // =====================================================
        // TYPE PROPERTY
        // =====================================================

        public javafx.beans.property.StringProperty typeProperty() {

            return type;
        }


        // =====================================================
        // MONTH PROPERTY
        // =====================================================

        public javafx.beans.property.StringProperty monthProperty() {

            return month;
        }


        // =====================================================
        // AMOUNT PROPERTY
        // =====================================================

        public javafx.beans.property.StringProperty amountProperty() {

            return amount;
        }


        // =====================================================
        // DUE DATE PROPERTY
        // =====================================================

        public javafx.beans.property.StringProperty dueDateProperty() {

            return dueDate;
        }


        // =====================================================
        // STATUS PROPERTY
        // =====================================================

        public javafx.beans.property.StringProperty statusProperty() {

            return status;
        }


        // =====================================================
        // GET TYPE
        // =====================================================

        public String getType() {

            return type.get();
        }


        // =====================================================
        // GET MONTH
        // =====================================================

        public String getMonth() {

            return month.get();
        }


        // =====================================================
        // GET AMOUNT
        // =====================================================

        public String getAmount() {

            return amount.get();
        }


        // =====================================================
        // GET STATUS
        // =====================================================

        public String getStatus() {

            return status.get();
        }
    }
}