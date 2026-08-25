package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

public class EmergencySOS {

    private static boolean sosActive = false;

    private static String emergencyType = "";
    private static String emergencyLocation = "";
    private static String emergencyDetails = "";
    private static String emergencyTime = "";


    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        GuardSidebar sidebar = new GuardSidebar(stage, "Emergency SOS");

        root.setLeft(sidebar.getSidebar());

        VBox content = new VBox();
        content.setPadding(new Insets(25, 40, 25, 40));
        content.setSpacing(18);
        content.setStyle(
                "-fx-background-color: #e8ddd5;");

         HBox header = new HBox();
header.setPadding(new Insets(25, 35, 25, 35));
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("Emergency SOS");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Send an emergency alert to residents and the secretary."
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


        VBox alertCard = new VBox();
        alertCard.setPadding(new Insets(18, 25, 18, 25));
        alertCard.setSpacing(8);
        alertCard.setAlignment(Pos.CENTER);
        alertCard.setMaxWidth(Double.MAX_VALUE);
        alertCard.setStyle(
                "-fx-background-color: #F4E4E4;" +
                "-fx-background-radius: 14;");

        Label alertTitle = new Label("Emergency Alert");
        alertTitle.setStyle(
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #8F3030;");

        Label alertMessage = new Label("Fill in the emergency details and press SOS to alert residents and the secretary.");
        alertMessage.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #52606D;");
        alertMessage.setWrapText(true);

        Button sendAlertButton = new Button("SOS");
        sendAlertButton.setPrefWidth(135);
        sendAlertButton.setPrefHeight(135);
        sendAlertButton.setMinWidth(135);
        sendAlertButton.setMinHeight(135);
        sendAlertButton.setMaxWidth(135);
        sendAlertButton.setMaxHeight(135);
        sendAlertButton.setStyle(
                "-fx-background-color: #B83A3A;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 100px;" +
                "-fx-border-color: #F4B5B5;" +
                "-fx-border-width: 5px;" +
                "-fx-border-radius: 100px;");

        Label statusLabel = new Label();

        updateStatus(statusLabel);

        alertCard.getChildren().addAll(
                alertTitle,
                alertMessage,
                sendAlertButton,
                statusLabel);

        VBox detailsCard = new VBox();
        detailsCard.setPadding(new Insets(20, 25, 20, 25));
        detailsCard.setSpacing(14);
        detailsCard.setMaxWidth(Double.MAX_VALUE);
        detailsCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;");

        Label detailsTitle = new Label("Emergency Details");
        detailsTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #060606;");

        Label detailsSubtitle = new Label("These details will be included in the emergency alert.");
        detailsSubtitle.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #52606D;");

        GridPane form = new GridPane();
        form.setHgap(30);
        form.setVgap(12);
        form.setMaxWidth(Double.MAX_VALUE);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);
        column1.setHgrow(Priority.ALWAYS);
        column2.setHgrow(Priority.ALWAYS);

        form.getColumnConstraints().addAll(column1,column2);

        Label typeLabel = createLabel("Emergency Type *");

        ComboBox<String> typeBox = new ComboBox<>();

        typeBox.getItems().addAll(
                "Fire",
                "Medical Emergency",
                "Security Threat",
                "Accident",
                "Suspicious Activity",
                "Other");

        typeBox.setPromptText("Select emergency type");

        styleComboBox(typeBox);

        Label locationLabel = createLabel("Location *");

        TextField locationField = new TextField();
        locationField.setPromptText("Example: Building A");

        styleField(locationField);

        form.add(typeLabel,0, 0);
        form.add(locationLabel,1, 0);
        form.add(typeBox,0, 1);
        form.add(locationField,1, 1);

        Label informationLabel = createLabel("Additional Information");

        TextArea informationField = new TextArea();
        informationField.setPromptText("Example: Smoke detected near the second floor...");
        informationField.setPrefHeight(75);
        informationField.setMaxWidth(Double.MAX_VALUE);
        informationField.setWrapText(true);
        informationField.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #080808;" +
                "-fx-prompt-text-fill: #52606D;");

        form.add(informationLabel,0, 2);
        form.add(informationField,0, 3,2, 1);

        Button clearButton =
                new Button("Clear");

        clearButton.setPrefWidth(100);
        clearButton.setPrefHeight(40);

        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #080808;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        Button resolveButton =
                new Button("Resolve Alert");

        resolveButton.setPrefWidth(140);
        resolveButton.setPrefHeight(40);

        resolveButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );


        HBox bottomButtons =
                new HBox(
                        12,
                        clearButton,
                        resolveButton
                );

        bottomButtons.setAlignment(
                Pos.CENTER_RIGHT
        );


        detailsCard.getChildren().addAll(
                detailsTitle,
                detailsSubtitle,
                form,
                bottomButtons
        );

        sendAlertButton.setOnAction(e -> {

            if (sosActive) {

                showMessage(
                        "Alert Already Active",
                        "An emergency alert is already active."
                );

                return;
            }

            if (
                    typeBox.getValue() == null
                    ||
                    locationField.getText()
                            .trim()
                            .isEmpty()
            ) {

                showMessage(
                        "Missing Information",
                        "Please select the emergency type and enter the location."
                );

                return;
            }

            emergencyType =
                    typeBox.getValue();

            emergencyLocation =
                    locationField.getText()
                            .trim();

            emergencyDetails =
                    informationField.getText()
                            .trim();

            emergencyTime =
                    LocalDateTime.now()
                            .format(
                                    DateTimeFormatter.ofPattern(
                                            "dd MMM yyyy, hh:mm a"
                                    )
                            );

            Alert confirmation =
                    new Alert(
                            Alert.AlertType.CONFIRMATION
                    );

            confirmation.setTitle(
                    "Confirm Emergency Alert"
            );

            confirmation.setHeaderText(
                    "Send Emergency Alert?"
            );

            confirmation.setContentText(
                    "Emergency: "
                            + emergencyType
                            + "\nLocation: "
                            + emergencyLocation
                            + "\n\nThis alert will be sent to residents and the secretary."
            );


            confirmation.showAndWait()
                    .ifPresent(response -> {

                        if (
                                response ==
                                ButtonType.OK
                        ) {


                            sosActive = true;


                            updateStatus(
                                    statusLabel
                            );


                            sendEmergencyAlert(
                                    emergencyType,
                                    emergencyLocation,
                                    emergencyDetails,
                                    emergencyTime
                            );


                            showMessage(
                                    "Emergency Alert Sent",
                                    "The emergency alert has been raised successfully.");
                        }
                    });
        });


        resolveButton.setOnAction(e -> {

            if (!sosActive) {

                showMessage(
                        "No Active Alert",
                        "There is no active emergency alert to resolve."
                );

                return;
            }


            sosActive = false;


            updateStatus(
                    statusLabel
            );


            showMessage(
                    "Alert Resolved",
                    "The emergency alert has been marked as resolved."
            );
        });


        clearButton.setOnAction(e -> {

            typeBox.setValue(null);

            locationField.clear();

            informationField.clear();
        });

        content.getChildren().addAll(header,alertCard,detailsCard);

        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(content);
        root.setCenter(mainarea);

        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
    }


    private static void sendEmergencyAlert(
            String type,
            String location,
            String details,
            String time) {

        System.out.println(
                "========== EMERGENCY ALERT =========="
        );

        System.out.println(
                "Type: " + type
        );

        System.out.println(
                "Location: " + location
        );

        System.out.println(
                "Details: " + details
        );

        System.out.println(
                "Time: " + time
        );

        System.out.println(
                "Status: ACTIVE"
        );

        System.out.println(
                "======================================"
        );
    }


    private static void updateStatus(
            Label statusLabel) {

        if (sosActive) {

            statusLabel.setText(
                    " ALERT ACTIVE "
            );

            statusLabel.setStyle(
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-text-fill: #9E3F3F;"
            );

        } else {

            statusLabel.setText(
                    " No active emergency "
            );

            statusLabel.setStyle(
                    "-fx-font-size: 12px;" +
                    "-fx-text-fill: #315B45;"
            );
        }
    }


    private static Label createLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #050505;"
        );

        return label;
    }


    private static void styleField(
            TextField field) {

        field.setMaxWidth(
                Double.MAX_VALUE
        );

        field.setPrefHeight(40);

        field.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #040505;" +
                "-fx-prompt-text-fill: #52606D;"
        );
    }


    private static void styleComboBox(
            ComboBox<String> box) {

        box.setMaxWidth(
                Double.MAX_VALUE
        );

        box.setPrefHeight(40);

        box.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #070707;"
        );
    }

    private static void showMessage(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                title
        );

        alert.setHeaderText(
                null
        );

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }


   public static boolean isSOSActive() {
    return sosActive;
}
}