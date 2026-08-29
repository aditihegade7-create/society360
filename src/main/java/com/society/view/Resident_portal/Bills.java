package com.society.view.Resident_portal;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.control.TableColumn;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Bills {
    public Scene getBillScene(Stage stage){
        
 panel panelobj = new panel(stage);


 BorderPane root =new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================
        VBox mainContent = new VBox(20);

        // YOUR REQUIRED BACKGROUND COLOR
        mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setSpacing(20);
        mainContent.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        Bills.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, false, true
                )
        );

        mainContent.setBackground(new Background(backgroundImage));



        // ================= TITLE =================

        Label title = new Label("My Bills");

        title.setFont(
                Font.font("System", FontWeight.BOLD, 28)
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

        heading.getChildren().addAll(
                title,
                subtitle
        );

        // ================= SUMMARY CARDS =================

        HBox summaryCards = new HBox(20);

        VBox totalDue = createSummaryCard(
                "Total Due",
                "₹ 4,500",
                "Pending amount"
        );

        VBox maintenanceDue = createSummaryCard(
                "Maintenance Due",
                "₹ 3,500",
                "August 2026"
        );

        VBox electricityDue = createSummaryCard(
                "Electricity Due",
                "₹ 1,000",
                "August 2026"
        );

        summaryCards.getChildren().addAll(
                totalDue,
                maintenanceDue,
                electricityDue
        );

        // ================= BILL TITLE =================

        Label billTitle = new Label("Bill History");

        billTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        billTitle.setTextFill(Color.WHITE);

        // ================= TABLE =================

        TableView<Bill> table = new TableView<>();

        table.setPrefHeight(300);

        table.setStyle(
                "-fx-background-color: white;"
        );

        TableColumn<Bill, String> typeColumn =
                new TableColumn<>("Bill Type");

        typeColumn.setCellValueFactory(
                data -> data.getValue().typeProperty()
        );

        TableColumn<Bill, String> monthColumn =
                new TableColumn<>("Month");

        monthColumn.setCellValueFactory(
                data -> data.getValue().monthProperty()
        );

        TableColumn<Bill, String> amountColumn =
                new TableColumn<>("Amount");

        amountColumn.setCellValueFactory(
                data -> data.getValue().amountProperty()
        );

        TableColumn<Bill, String> dueDateColumn =
                new TableColumn<>("Due Date");

        dueDateColumn.setCellValueFactory(
                data -> data.getValue().dueDateProperty()
        );

        TableColumn<Bill, String> statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                data -> data.getValue().statusProperty()
        );

        table.getColumns().addAll(
                typeColumn,
                monthColumn,
                amountColumn,
                dueDateColumn,
                statusColumn
        );

        // ================= SAMPLE BILL DATA =================

        table.getItems().addAll(

                new Bill(
                        "Maintenance",
                        "August 2026",
                        "₹ 3,500",
                        "25 Aug 2026",
                        "Pending"
                ),

                new Bill(
                        "Electricity",
                        "August 2026",
                        "₹ 1,000",
                        "20 Aug 2026",
                        "Pending"
                ),

                new Bill(
                        "Maintenance",
                        "July 2026",
                        "₹ 3,500",
                        "25 Jul 2026",
                        "Paid"
                ),

                new Bill(
                        "Water",
                        "July 2026",
                        "₹ 500",
                        "20 Jul 2026",
                        "Paid"
                )
        );

        // ================= PAY BUTTON =================

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

        payButton.setOnAction(e -> {

            Bill selectedBill =
                    table.getSelectionModel()
                         .getSelectedItem();

            if (selectedBill == null) {

                Alert alert =
                        new Alert(Alert.AlertType.WARNING);

                alert.setTitle("No Bill Selected");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Please select a bill first."
                );

                alert.showAndWait();

            } else {

                Alert alert =
                        new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Payment");
                alert.setHeaderText("Payment Details");

                alert.setContentText(
                        "Bill: "
                        + selectedBill.getType()
                        + "\nAmount: "
                        + selectedBill.getAmount()
                );

                alert.showAndWait();
            }
        });

        HBox buttonBox = new HBox();

        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        buttonBox.getChildren().add(payButton);

        // ================= ADD CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                summaryCards,
                billTitle,
                table,
                buttonBox
        );

        
BorderPane mainarea = new BorderPane();
mainarea.setTop(heading);
mainarea.setCenter(mainContent);
heading.setStyle("-fx-background-color: #4e342e");


root.setCenter(mainarea);        



        return new Scene(
                root,
                 ScreenSize.getWidth(),
                ScreenSize.getHeight());

    }

    // =====================================================
    // SUMMARY CARD
    // =====================================================

    private VBox createSummaryCard(
            String heading,
            String amount,
            String description) {

        VBox card = new VBox(8);

        card.setPadding(new Insets(15));

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
                Font.font("System", FontWeight.BOLD, 13)
        );

        Label amountLabel =
                new Label(amount);

        amountLabel.setFont(
                Font.font("System", FontWeight.BOLD, 22)
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

    // =====================================================
    // BILL CLASS
    // =====================================================

    public static class Bill {

        private final javafx.beans.property.SimpleStringProperty type;
        private final javafx.beans.property.SimpleStringProperty month;
        private final javafx.beans.property.SimpleStringProperty amount;
        private final javafx.beans.property.SimpleStringProperty dueDate;
        private final javafx.beans.property.SimpleStringProperty status;

        public Bill(
                String type,
                String month,
                String amount,
                String dueDate,
                String status) {

            this.type =
                    new javafx.beans.property.SimpleStringProperty(type);

            this.month =
                    new javafx.beans.property.SimpleStringProperty(month);

            this.amount =
                    new javafx.beans.property.SimpleStringProperty(amount);

            this.dueDate =
                    new javafx.beans.property.SimpleStringProperty(dueDate);

            this.status =
                    new javafx.beans.property.SimpleStringProperty(status);
        }

        public javafx.beans.property.StringProperty typeProperty() {
            return type;
        }

        public javafx.beans.property.StringProperty monthProperty() {
            return month;
        }

        public javafx.beans.property.StringProperty amountProperty() {
            return amount;
        }

        public javafx.beans.property.StringProperty dueDateProperty() {
            return dueDate;
        }

        public javafx.beans.property.StringProperty statusProperty() {
            return status;
        }

        public String getType() {
            return type.get();
        }

        public String getAmount() {
            return amount.get();
        }

        public String getStatus() {
            return status.get();
        }
    }
}
//VBox vb = new VBox();
 


