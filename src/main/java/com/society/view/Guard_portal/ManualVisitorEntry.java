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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

public class ManualVisitorEntry {

    public static Scene createScene(Stage stage) {
        BorderPane root = new BorderPane();

        GuardSidebar sidebar =
                new GuardSidebar(stage, "Manual Entry");

        root.setLeft(sidebar.getSidebar());

        VBox content = new VBox();

        content.setPadding(
                new Insets(25, 40, 25, 40)
        );

        content.setSpacing(18);

        content.setFillWidth(true);

        content.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        HBox header = new HBox();
header.setPadding(new Insets(25, 35, 25, 35));
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("Manual Visitor Entry");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Enter visitor details to approve their entry."
);
description.setStyle(
        "-fx-font-size:13px;" +
        "-fx-text-fill: white;"
);

titleBox.getChildren().addAll(title, description);


// Spacer pushes date to the right
Region spacer = new Region();
HBox.setHgrow(spacer, Priority.ALWAYS);


// Date
Label day = new Label();
Label date = new Label();

LocalDate today = LocalDate.now();

day.setText(today.format(
        DateTimeFormatter.ofPattern("EEEE")
));

date.setText(today.format(
        DateTimeFormatter.ofPattern("dd MMMM yyyy")
));
day.setTextFill(Color.WHITE);
date.setTextFill(Color.WHITE);

VBox dateBox = new VBox(3);
dateBox.setAlignment(Pos.CENTER_RIGHT);
dateBox.getChildren().addAll(day, date);


// Add everything to header
header.getChildren().addAll(
        titleBox,
        spacer,
        dateBox
);

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

        Label formTitle =
                new Label("Visitor Information");

        formTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #090909;"
        );


        Label requiredNote =
                new Label("* Required fields");

        requiredNote.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #c90909;"
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

        GridPane form =
                new GridPane();

        form.setHgap(35);
        form.setVgap(14);

        form.setMaxWidth(
                Double.MAX_VALUE
        );

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

        Label nameLabel =
                createLabel("Full Name *");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter visitor's full name"
        );

        styleField(nameField);

        Label phoneLabel =
                createLabel("Phone Number *");

        TextField phoneField =
                new TextField();

        phoneField.setPromptText(
                "Enter mobile number"
        );

        styleField(phoneField);

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

        Label flatLabel =
                createLabel("Visiting Unit / Flat *");

        TextField flatField =
                new TextField();

        flatField.setPromptText(
                "Example: A-102"
        );

        styleField(flatField);

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
                "-fx-text-fill: #090909;" +
                "-fx-prompt-text-fill: #52606D;"
        );

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

        Button clearButton =
                new Button("Clear");

        clearButton.setPrefWidth(110);
        clearButton.setPrefHeight(40);

        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #070707;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );


        Button submitButton =
                new Button("Submit & Approve");

        submitButton.setPrefWidth(165);
        submitButton.setPrefHeight(40);

        submitButton.setStyle(
                "-fx-background-color: #4e342e;" +
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

        clearButton.setOnAction(e -> {
            nameField.clear();
            phoneField.clear();
            flatField.clear();
            remarksField.clear();
            purposeBox.setValue(null);
        });

        submitButton.setOnAction(e -> {

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

            VisitorLog.visitors.add(
                    visitor
            );

            showMessage(
                    "Visitor Approved",
                    nameField.getText()
                            .trim()
                            + " has been added successfully."
            );

            clearButton.fire();

            stage.setScene(VisitorLog.createScene(stage));
        });

        formCard.getChildren().addAll(
                formHeading,
                form,
                buttons
        );

        content.getChildren().addAll(header,formCard);
        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(content);
        root.setCenter(mainarea);
        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
    }

    private static Label createLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #080808;"
        );

        return label;
    }

    private static void styleField(TextField field) {
        field.setMaxWidth(Double.MAX_VALUE);
        field.setPrefHeight(40);
        field.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #060606;" +
                "-fx-prompt-text-fill: #52606D;"
        );
    }

    private static void styleComboBox(ComboBox<String> box) {
        box.setMaxWidth(Double.MAX_VALUE);
        box.setPrefHeight(60);
        box.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #080808;"
        );
    }

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