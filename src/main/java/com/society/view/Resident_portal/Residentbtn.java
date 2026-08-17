package com.society.view.Resident_portal;



import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Residentbtn {
    public Scene getResidentbtScene(Stage stage){



 

        // ================= SIDEBAR =================

        panel panelobj = new panel(stage);

        // ================= ROOT =================

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

        // ================= HEADING =================

        Label title = new Label("Maintenance");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "View your maintenance charges and payment details"
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

        HBox summaryBox = new HBox(15);

        VBox totalCard = createSummaryCard(
                "Monthly Maintenance",
                "₹ 2,500",
                "Current monthly charge"
        );

        VBox paidCard = createSummaryCard(
                "Paid Amount",
                "₹ 2,500",
                "For current month"
        );

        VBox dueCard = createSummaryCard(
                "Amount Due",
                "₹ 0",
                "No pending payment"
        );

        summaryBox.getChildren().addAll(
                totalCard,
                paidCard,
                dueCard
        );

        // ================= CURRENT MAINTENANCE =================

        Label currentTitle =
                new Label("Current Maintenance");

        currentTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        currentTitle.setTextFill(Color.WHITE);

        VBox currentCard =
                new VBox(12);

        currentCard.setPadding(
                new Insets(20)
        );

        currentCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        // ================= CURRENT DETAILS =================

        HBox monthRow =
                createDetailRow(
                        "Billing Month",
                        "August 2026"
                );

        HBox amountRow =
                createDetailRow(
                        "Maintenance Amount",
                        "₹ 2,500"
                );

        HBox dueDateRow =
                createDetailRow(
                        "Due Date",
                        "10 August 2026"
                );

        HBox statusRow =
                createDetailRow(
                        "Payment Status",
                        "Paid"
                );

        // ================= PAY BUTTON =================

        Button payButton =
                new Button("Pay Maintenance");

        payButton.setPrefHeight(38);

        payButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        payButton.setOnAction(e -> {

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Maintenance Payment");

            alert.setHeaderText(
                    "Maintenance Payment"
            );

            alert.setContentText(
                    "Payment option selected."
            );

            alert.showAndWait();
        });

        HBox payBox =
                new HBox();

        payBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        payBox.getChildren().add(
                payButton
        );

        currentCard.getChildren().addAll(
                monthRow,
                amountRow,
                dueDateRow,
                statusRow,
                //new Separator(),
                payBox
        );

        // ================= PAYMENT HISTORY =================

        Label historyTitle =
                new Label("Payment History");

        historyTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        historyTitle.setTextFill(Color.WHITE);

        VBox historyCard =
                new VBox(0);

        historyCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        historyCard.getChildren().addAll(
                createHistoryRow(
                        "July 2026",
                        "₹ 2,500",
                        "10 July 2026",
                        "Paid"
                ),
                createHistoryRow(
                        "June 2026",
                        "₹ 2,500",
                        "08 June 2026",
                        "Paid"
                ),
                createHistoryRow(
                        "May 2026",
                        "₹ 2,500",
                        "09 May 2026",
                        "Paid"
                ),
                createHistoryRow(
                        "April 2026",
                        "₹ 2,500",
                        "10 April 2026",
                        "Paid"
                )
        );

        // ================= SCROLL =================

        VBox content =
                new VBox(18);

        content.getChildren().addAll(
                heading,
                summaryBox,
                currentTitle,
                currentCard,
                historyTitle,
                historyCard
        );

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        mainContent.getChildren().add(
                scrollPane
        );

        root.setCenter(mainContent);

        return new Scene(
                root,
                1200,
                700
        );
    }

    // =====================================================
    // SUMMARY CARD
    // =====================================================

    private VBox createSummaryCard(
            String title,
            String amount,
            String description) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefWidth(230);

        card.setPrefHeight(110);

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
                        13
                )
        );

        titleLabel.setTextFill(
                Color.web("#607D8B")
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
                Color.web("#263238")
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setFont(
                Font.font("System", 12)
        );

        descriptionLabel.setTextFill(
                Color.GRAY
        );

        card.getChildren().addAll(
                titleLabel,
                amountLabel,
                descriptionLabel
        );

        return card;
    }

    // =====================================================
    // DETAIL ROW
    // =====================================================

    private HBox createDetailRow(
            String labelText,
            String valueText) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label label =
                new Label(labelText);

        label.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        label.setTextFill(
                Color.web("#607D8B")
        );

        Label value =
                new Label(valueText);

        value.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        value.setTextFill(
                Color.web("#263238")
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                label,
                spacer,
                value
        );

        return row;
    }

    // =====================================================
    // PAYMENT HISTORY ROW
    // =====================================================

    private HBox createHistoryRow(
            String month,
            String amount,
            String date,
            String status) {

        HBox row =
                new HBox(20);

        row.setPadding(
                new Insets(15, 20, 15, 20)
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label monthLabel =
                new Label(month);

        monthLabel.setPrefWidth(150);

        monthLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        monthLabel.setTextFill(
                Color.web("#263238")
        );

        Label amountLabel =
                new Label(amount);

        amountLabel.setPrefWidth(120);

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        amountLabel.setTextFill(
                Color.web("#263238")
        );

        Label dateLabel =
                new Label(date);

        dateLabel.setPrefWidth(150);

        dateLabel.setTextFill(
                Color.GRAY
        );

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 5 12 5 12;" +
                "-fx-background-radius: 15;" +
                "-fx-font-weight: bold;"
        );

        row.getChildren().addAll(
                monthLabel,
                amountLabel,
                dateLabel,
                statusLabel
        );

        return row;
    }
}








