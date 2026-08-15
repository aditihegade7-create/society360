package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ManualVisitorEntry { 

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
        GuardSidebar sidebar = new GuardSidebar(stage, "Manual Visitor Entry");

        root.setLeft(sidebar.getSidebar());


        VBox content = new VBox();

        content.setPadding(new Insets(30, 40, 30, 40));
        content.setSpacing(20);

        content.setStyle(
                "-fx-background-color: #789098;"
        );

        Label title = new Label("Manual Visitor Entry");

        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        Label subtitle = new Label(
                "Add visitor details manually"
        );

        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #102A43;"
        );

        VBox heading = new VBox(5);
        heading.getChildren().addAll(title, subtitle);


        GridPane form = new GridPane();

        form.setHgap(20);
        form.setVgap(18);

        // Full Name
        Label nameLabel = createLabel("Full Name");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter full name");
        styleField(nameField);

        // Phone
        Label phoneLabel = createLabel("Phone Number");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter mobile number");
        styleField(phoneField);

        // Purpose
        Label purposeLabel = createLabel("Purpose of Visit");

        ComboBox<String> purposeBox = new ComboBox<>();

        purposeBox.getItems().addAll(
                "Personal Visit",
                "Delivery",
                "Service",
                "Housekeeping",
                "Other"
        );

        purposeBox.setPromptText("Select Purpose");
        styleComboBox(purposeBox);

        // Flat
        Label flatLabel = createLabel("Visiting Unit / Flat");

        TextField flatField = new TextField();
        flatField.setPromptText("Enter flat / unit no.");
        styleField(flatField);

       

        // Remarks
        Label remarksLabel = createLabel("Remarks");

        TextArea remarksField = new TextArea();
        remarksField.setPromptText(
                "Any additional information"
        );

        remarksField.setPrefHeight(80);
        remarksField.setWrapText(true);

        remarksField.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;" +
                "-fx-border-color: #B7C7BE;" +
                "-fx-border-radius: 6;"
        );

        form.add(nameLabel, 0, 0);
        form.add(phoneLabel, 1, 0);

        form.add(nameField, 0, 1);
        form.add(phoneField, 1, 1);

        form.add(purposeLabel, 0, 2);
        form.add(flatLabel, 1, 2);

        form.add(purposeBox, 0, 3);
        form.add(flatField, 1, 3);

        form.add(remarksLabel, 0, 6);
        form.add(remarksField, 0, 7, 2, 1);


        Button clearButton = new Button("Clear");

        clearButton.setPrefWidth(120);
        clearButton.setPrefHeight(40);

        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #183A2D;" +
                "-fx-background-radius: 6;" +
                "-fx-setAlignment- CENTER_LEFT;"
        );

        Button submitButton = new Button(
                "Submit & Approve"
        );

        submitButton.setPrefWidth(170);
        submitButton.setPrefHeight(40);

        submitButton.setStyle(
                "-fx-background-color: #183A2D;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        clearButton.setOnAction(e -> {

            nameField.clear();
            phoneField.clear();
            flatField.clear();
            remarksField.clear();
            purposeBox.setValue(null);
        });

        submitButton.setOnAction(e -> {

            if (nameField.getText().trim().isEmpty()
                    || phoneField.getText().trim().isEmpty()
                    || purposeBox.getValue() == null
                    || flatField.getText().trim().isEmpty()) {

                showMessage(
                        "Missing Information",
                        "Please fill all required fields."
                );

                return;
            }

            showMessage(
                    "Visitor Approved",
                    "Visitor entry has been submitted successfully."
            );

            clearButton.fire();
        });

        HBox buttons = new HBox(15);

        buttons.setAlignment(Pos.CENTER_RIGHT);

        buttons.getChildren().addAll(
                clearButton,
                submitButton
        );


        content.getChildren().addAll(
                heading,
                form,
                buttons
        );

        root.setCenter(content);


        return new Scene(
                root,
                1500,
                750
        );
    }

    private static Label createLabel(String text) {

        Label label = new Label(text);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        return label;
    }


    private static void styleField(TextField field) {

        field.setPrefWidth(330);
        field.setPrefHeight(40);

        field.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;" +
                "-fx-border-color: #B7C7BE;" +
                "-fx-border-radius: 6;"
        );
    }


    private static void styleComboBox(
            ComboBox<String> box) {

        box.setPrefWidth(330);
        box.setPrefHeight(40);
    }

    // =========================
    // MESSAGE
    // =========================

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
    

