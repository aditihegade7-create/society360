package com.society.view.Guard_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuardProfile {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
        GuardSidebar sidebar = new GuardSidebar(stage, "Profile");

        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox();

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        mainContent.setSpacing(20);

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

         HBox header = new HBox();
header.setPadding(new Insets(25, 35, 25, 35));
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("My Profile");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Guard account and duty information."
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

VBox dateBox = new VBox(3);
dateBox.setAlignment(Pos.CENTER_RIGHT);
dateBox.getChildren().addAll(day, date);


// Add everything to header
header.getChildren().addAll(
        titleBox,
        spacer,
        dateBox
);


        HBox profileHeader = new HBox();

        profileHeader.setPadding(
                new Insets(20, 25, 20, 25)
        );

        profileHeader.setSpacing(20);

        profileHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        profileHeader.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;"
        );

        // Avatar
        Label avatar = new Label("R");
        avatar.setAlignment(Pos.CENTER);
        avatar.setPrefWidth(75);
        avatar.setPrefHeight(75);

        avatar.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 50;"
        );

        // Guard information
        Label name = new Label("Rajesh Kumar");

        name.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #030303;"
        );

        Label guardId = new Label(
                "Guard ID: G001"
        );

        guardId.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #52606D;"
        );

        Label status = new Label("Active");
        status.setStyle(
                "-fx-text-fill: #183A2D;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        VBox profileInfo = new VBox(
                5,
                name,
                guardId,
                status
        );

        profileHeader.getChildren().addAll(
                avatar,
                profileInfo
        );

        Label personalTitle = new Label(
                "Personal Information"
        );

        personalTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #060606;"
        );

        TextField nameField =
                createField("Rajesh Kumar");

        TextField phoneField =
                createField("9876543210");

        TextField emailField =
                createField("rajesh@society360.com");

        TextField idField =
                createField("G001");

        VBox personalCard = createInfoCard();

        personalCard.getChildren().addAll(
                createInfoRow(
                        "Full Name",
                        nameField
                ),
                createInfoRow(
                        "Phone Number",
                        phoneField
                ),
                createInfoRow(
                        "Email",
                        emailField
                ),
                createInfoRow(
                        "Guard ID",
                        idField
                )
        );

        Label dutyTitle = new Label(
                "Duty Information"
        );

        dutyTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #050505;"
        );

        TextField gateField =
                createField("Main Gate");

        TextField shiftField =
                createField("Shift A  (08:00 AM - 04:00 PM)");

        TextField joiningField =
                createField("15 January 2025");

        TextField statusField =
                createField("Active");

        VBox dutyCard = createInfoCard();

        dutyCard.getChildren().addAll(
                createInfoRow(
                        "Assigned Gate",
                        gateField
                ),
                createInfoRow(
                        "Current Shift",
                        shiftField
                ),
                createInfoRow(
                        "Joining Date",
                        joiningField
                ),
                createInfoRow(
                        "Account Status",
                        statusField
                )
        );

        VBox personalSection = new VBox(
                10,
                personalTitle,
                personalCard
        );

        VBox dutySection = new VBox(
                10,
                dutyTitle,
                dutyCard
        );

        HBox informationSection = new HBox();
        informationSection.setSpacing(25);


        informationSection.getChildren().addAll(
                personalSection,
                dutySection
        );

        Button editButton =
                new Button("Edit Profile");

        editButton.setPrefWidth(130);
        editButton.setPrefHeight(40);

        editButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"+
                "-fx-setAlignment- CENTER_LEFT;"
        );

        Button saveButton =
                new Button("Save Changes");

        saveButton.setPrefWidth(140);
        saveButton.setPrefHeight(40);

        saveButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        saveButton.setVisible(false);

        TextField[] fields = {
                nameField,
                phoneField,
                emailField,
                idField,
                gateField,
                shiftField,
                joiningField,
                statusField
        };

        setFieldsEditable(false, fields);

        editButton.setOnAction(e -> {

            setFieldsEditable(true, fields);

            editButton.setVisible(false);
            saveButton.setVisible(true);
        });

        saveButton.setOnAction(e -> {

            setFieldsEditable(false, fields);

            editButton.setVisible(true);
            saveButton.setVisible(false);

            showMessage(
                    "Profile Updated",
                    "Your profile details have been saved."
            );
        });

        HBox buttons = new HBox();

        buttons.setSpacing(15);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        buttons.getChildren().addAll(
                editButton,
                saveButton
        );

        mainContent.getChildren().addAll(
                header,
                profileHeader,
                informationSection,
                buttons
        );
        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(mainContent);
        root.setCenter(mainarea);
        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
    }

    private static VBox createInfoCard() {

        VBox card = new VBox();

        card.setPrefWidth(550);
        card.setSpacing(15);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 10;"
        );

        return card;
    }

    private static HBox createInfoRow(
            String labelText,
            TextField field) {

        Label label = new Label(labelText);

        label.setPrefWidth(120);

        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #070707;"
        );

        HBox row = new HBox();

        row.setSpacing(15);
        row.setAlignment(Pos.CENTER_LEFT);

        row.getChildren().addAll(
                label,
                field
        );

        return row;
    }

    private static TextField createField(
            String text) {

        TextField field = new TextField(text);

        field.setPrefWidth(330);
        field.setPrefHeight(38);

        field.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;" +
                "-fx-border-color: #B7C7BE;" +
                "-fx-border-radius: 6;" +
                "-fx-text-fill: #060606;"
        );

        return field;
    }

    private static void setFieldsEditable(
            boolean editable,
            TextField[] fields) {

        for (TextField field : fields) {
            field.setEditable(editable);
        }
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