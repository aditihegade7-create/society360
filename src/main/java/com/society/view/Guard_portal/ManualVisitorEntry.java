package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ManualVisitorEntry {

    public static Scene createScene(Stage stage) {

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root = new BorderPane();


        // =====================================================
        // SIDEBAR
        // =====================================================

        GuardSidebar sidebar =
                new GuardSidebar(stage, "Manual Entry");

        root.setLeft(sidebar.getSidebar());


        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox content = new VBox();

        content.setPadding(
                new Insets(25, 40, 25, 40)
        );

        content.setSpacing(18);

        content.setFillWidth(true);
       

        content.setStyle(
                "-fx-background-color: #789098;"
        );


        // =====================================================
        // PAGE HEADING
        // =====================================================

        Label title =
                new Label("Manual Visitor Entry");

        title.setStyle(
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );


        Label subtitle =
                new Label(
                        "Enter visitor details to approve their entry."
                );

        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #263238;"
        );


        VBox heading =
                new VBox(
                        4,
                        title,
                        subtitle
                );


        // =====================================================
        // FORM CARD
        // =====================================================

        VBox formCard =
                new VBox();

        formCard.setPadding(
                new Insets(22, 28, 22, 28)
        );

        formCard.setSpacing(18);

        formCard.setMaxWidth(
                Double.MAX_VALUE
        );

        formCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;"
        );


        // =====================================================
        // FORM HEADING
        // =====================================================

        Label formTitle =
                new Label("Visitor Information");

        formTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #183A2D;"
        );


        Label requiredNote =
                new Label("* Required fields");

        requiredNote.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #52606D;"
        );


        HBox formHeading =
                new HBox(
                        formTitle,
                        requiredNote
                );

        formHeading.setAlignment(
                Pos.CENTER_LEFT
        );

        formHeading.setSpacing(20);


        // =====================================================
        // FORM GRID
        // =====================================================

        GridPane form =
                new GridPane();

        form.setHgap(35);
        form.setVgap(14);

        form.setMaxWidth(
                Double.MAX_VALUE
        );


        // =====================================================
        // TWO EQUAL COLUMNS
        // =====================================================

        ColumnConstraints column1 =
                new ColumnConstraints();

        ColumnConstraints column2 =
                new ColumnConstraints();

        column1.setPercentWidth(50);
        column2.setPercentWidth(50);

        column1.setHgrow(
                Priority.ALWAYS
        );

        column2.setHgrow(
                Priority.ALWAYS
        );

        form.getColumnConstraints().addAll(
                column1,
                column2
        );


        // =====================================================
        // FULL NAME
        // =====================================================

        Label nameLabel =
                createLabel("Full Name *");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter visitor's full name"
        );

        styleField(nameField);


        // =====================================================
        // PHONE NUMBER
        // =====================================================

        Label phoneLabel =
                createLabel("Phone Number *");

        TextField phoneField =
                new TextField();

        phoneField.setPromptText(
                "Enter mobile number"
        );

        styleField(phoneField);


        // =====================================================
        // PURPOSE
        // =====================================================

        Label purposeLabel =
                createLabel("Purpose of Visit *");

        ComboBox<String> purposeBox =
                new ComboBox<>();

        purposeBox.getItems().addAll(
                "Personal Visit",
                "Delivery",
                "Service",
                "Housekeeping",
                "Other"
        );

        purposeBox.setPromptText(
                "Select purpose"
        );

        styleComboBox(purposeBox);


        // =====================================================
        // FLAT
        // =====================================================

        Label flatLabel =
                createLabel("Visiting Unit / Flat *");

        TextField flatField =
                new TextField();

        flatField.setPromptText(
                "Example: A-102"
        );

        styleField(flatField);


        // =====================================================
        // REMARKS
        // =====================================================

        Label remarksLabel =
                createLabel("Remarks");

        TextArea remarksField =
                new TextArea();

        remarksField.setPromptText(
                "Add any additional information..."
        );

        remarksField.setPrefHeight(70);

        remarksField.setMaxWidth(
                Double.MAX_VALUE
        );

        remarksField.setWrapText(true);

        remarksField.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #102A43;" +
                "-fx-prompt-text-fill: #52606D;"
        );


        // =====================================================
        // ADD FORM ELEMENTS
        // =====================================================

        form.add(
                nameLabel,
                0, 0
        );

        form.add(
                phoneLabel,
                1, 0
        );

        form.add(
                nameField,
                0, 1
        );

        form.add(
                phoneField,
                1, 1
        );


        form.add(
                purposeLabel,
                0, 2
        );

        form.add(
                flatLabel,
                1, 2
        );

        form.add(
                purposeBox,
                0, 3
        );

        form.add(
                flatField,
                1, 3
        );


        form.add(
                remarksLabel,
                0, 4
        );

        form.add(
                remarksField,
                0, 5,
                2, 1
        );


        // =====================================================
        // BUTTONS
        // =====================================================

        Button clearButton =
                new Button("Clear");

        clearButton.setPrefWidth(110);
        clearButton.setPrefHeight(40);

        clearButton.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-text-fill: #183A2D;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );


        Button submitButton =
                new Button("Submit & Approve");

        submitButton.setPrefWidth(165);
        submitButton.setPrefHeight(40);

        submitButton.setStyle(
                "-fx-background-color: #183A2D;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );


        HBox buttons =
                new HBox(
                        12,
                        clearButton,
                        submitButton
                );

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );


        // =====================================================
        // CLEAR ACTION
        // =====================================================

        clearButton.setOnAction(e -> {

            nameField.clear();

            phoneField.clear();

            flatField.clear();

            remarksField.clear();

            purposeBox.setValue(null);
        });


        // =====================================================
        // SUBMIT & APPROVE ACTION
        // =====================================================

        submitButton.setOnAction(e -> {

            // Check required fields

            if (
                    nameField.getText()
                            .trim()
                            .isEmpty()

                    ||

                    phoneField.getText()
                            .trim()
                            .isEmpty()

                    ||

                    purposeBox.getValue() == null

                    ||

                    flatField.getText()
                            .trim()
                            .isEmpty()
            ) {

                showMessage(
                        "Missing Information",
                        "Please fill all required fields."
                );

                return;
            }


            // =================================================
            // CREATE VISITOR
            // =================================================

            VisitorLog.Visitor visitor =
                    new VisitorLog.Visitor(

                            nameField.getText()
                                    .trim(),

                            phoneField.getText()
                                    .trim(),

                            flatField.getText()
                                    .trim(),

                            purposeBox.getValue(),

                            remarksField.getText()
                                    .trim(),

                            LocalTime.now()
                                    .format(
                                            DateTimeFormatter
                                                    .ofPattern(
                                                            "hh:mm a"
                                                    )
                                    ),

                            "Inside"
                    );


            // =================================================
            // ADD VISITOR TO VISITOR LOG
            // =================================================

            VisitorLog.visitors.add(
                    visitor
            );


            // =================================================
            // SUCCESS MESSAGE
            // =================================================

            showMessage(
                    "Visitor Approved",
                    nameField.getText()
                            .trim()
                            + " has been added successfully."
            );


            // Clear the form

            clearButton.fire();


            // Open Visitor Log

            stage.setScene(
                    VisitorLog.createScene(stage)
            );
        });


        // =====================================================
        // ADD FORM TO CARD
        // =====================================================

        formCard.getChildren().addAll(
                formHeading,
                form,
                buttons
        );


        // =====================================================
        // ADD CONTENT
        // =====================================================

        content.getChildren().addAll(
                heading,
                formCard
        );


        root.setCenter(content);


        // =====================================================
        // SCENE SIZE
        // =====================================================

        return new Scene(
                root,
                1500,
                750
        );
    }


    // =====================================================
    // CREATE LABEL
    // =====================================================

    private static Label createLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #183A2D;"
        );

        return label;
    }


    // =====================================================
    // STYLE TEXT FIELD
    // =====================================================

    private static void styleField(
            TextField field) {

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setPrefHeight(40);

        field.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #102A43;" +
                "-fx-prompt-text-fill: #52606D;"
        );
    }


    // =====================================================
    // STYLE COMBO BOX
    // =====================================================

    private static void styleComboBox(
            ComboBox<String> box) {

        box.setMaxWidth(
                Double.MAX_VALUE
        );

        box.setPrefHeight(60);

        box.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #102A43;"
        );
    }


    // =====================================================
    // MESSAGE
    // =====================================================

    private static void showMessage(
            String title,
            String message) {

        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}