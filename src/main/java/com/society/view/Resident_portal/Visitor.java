package com.society.view.Resident_portal;


import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

public class Visitor {
    public Scene getVisitorScene(Stage stage){
        panel panelobj = new panel(stage);
 


 

    
        // ================= SIDEBAR =================
        

        // ================= MAIN CONTENT =================
        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setStyle("-fx-background-color: #e8ddd5;");

        // ================= TITLE =================
        Label title = new Label("Invite / Pre-Approve Visitor");
        title.setFont(Font.font("System", FontWeight.BOLD, 24));
        title.setTextFill(Color.web("#172B4D"));

        Label subtitle = new Label("Add visitor details to allow entry");
        subtitle.setFont(Font.font("System", 13));
        subtitle.setTextFill(Color.GRAY);

        VBox heading = new VBox(5);
        heading.getChildren().addAll(title, subtitle);

        // ================= FORM =================
        GridPane form = new GridPane();

        form.setHgap(25);
        form.setVgap(15);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        form.getColumnConstraints().addAll(col1, col2);

        // Visitor Name
        Label visitorNameLabel = new Label("Visitor Name");
        TextField visitorName = new TextField();
        visitorName.setPromptText("Enter full name");
        visitorName.setPrefHeight(38);

        VBox visitorNameBox = new VBox(6);
        visitorNameBox.getChildren().addAll(visitorNameLabel, visitorName);

        // Phone Number
        Label phoneLabel = new Label("Phone Number");
        TextField phoneNumber = new TextField();
        phoneNumber.setPromptText("Enter mobile number");
        phoneNumber.setPrefHeight(38);

        VBox phoneBox = new VBox(6);
        phoneBox.getChildren().addAll(phoneLabel, phoneNumber);

        form.add(visitorNameBox, 0, 0);
        form.add(phoneBox, 1, 0);

        // Purpose
        Label purposeLabel = new Label("Purpose of Visit");

        ComboBox<String> purpose = new ComboBox<>();
        purpose.setPromptText("Select purpose");
        purpose.getItems().addAll(
                "Personal Visit",
                "Family Visit",
                "Service Visit",
                "Delivery",
                "Other"
        );
        purpose.setMaxWidth(Double.MAX_VALUE);
        purpose.setPrefHeight(38);

        VBox purposeBox = new VBox(6);
        purposeBox.getChildren().addAll(purposeLabel, purpose);

        // Visit Date
        Label dateLabel = new Label("Visit Date");

        DatePicker visitDate = new DatePicker();
        visitDate.setPromptText("Select date");
        visitDate.setMaxWidth(Double.MAX_VALUE);
        visitDate.setPrefHeight(38);

        VBox dateBox = new VBox(6);
        dateBox.getChildren().addAll(dateLabel, visitDate);

        form.add(purposeBox, 0, 1);
        form.add(dateBox, 1, 1);

        // Visit Time
        Label timeLabel = new Label("Visit Time");

        ComboBox<String> visitTime = new ComboBox<>();
        visitTime.setPromptText("Select time");
        visitTime.getItems().addAll(
                "08:00 AM",
                "09:00 AM",
                "10:00 AM",
                "11:00 AM",
                "12:00 PM",
                "01:00 PM",
                "02:00 PM",
                "03:00 PM",
                "04:00 PM",
                "05:00 PM",
                "06:00 PM",
                "07:00 PM",
                "08:00 PM"
        );
        visitTime.setMaxWidth(Double.MAX_VALUE);
        visitTime.setPrefHeight(38);

        VBox timeBox = new VBox(6);
        timeBox.getChildren().addAll(timeLabel, visitTime);

        // Flat Visit
        Label flatLabel = new Label("Flat Visit");

        ComboBox<String> flatVisit = new ComboBox<>();
        flatVisit.setPromptText("Select flat to visit");
        flatVisit.getItems().addAll(
                "A-101",
                "A-102",
                "A-103",
                "B-101",
                "B-102",
                "B-103"
        );
        flatVisit.setMaxWidth(Double.MAX_VALUE);
        flatVisit.setPrefHeight(38);

        VBox flatBox = new VBox(6);
        flatBox.getChildren().addAll(flatLabel, flatVisit);

        form.add(timeBox, 0, 2);
        form.add(flatBox, 1, 2);

        // Gate Entry
        Label gateLabel = new Label("Gate Entry");

        ComboBox<String> gateEntry = new ComboBox<>();
        gateEntry.setPromptText("Select Gate");
        gateEntry.getItems().addAll(
                "Main Gate",
                "Gate 2",
                "Service Gate"
        );
        gateEntry.setMaxWidth(Double.MAX_VALUE);
        gateEntry.setPrefHeight(38);

        VBox gateBox = new VBox(6);
        gateBox.getChildren().addAll(gateLabel, gateEntry);

        // Vehicle Number
        Label vehicleLabel = new Label("Vehicle Number (Optional)");

        TextField vehicleNumber = new TextField();
        vehicleNumber.setPromptText("Enter vehicle number");
        vehicleNumber.setPrefHeight(38);

        VBox vehicleBox = new VBox(6);
        vehicleBox.getChildren().addAll(vehicleLabel, vehicleNumber);

        form.add(gateBox, 0, 3);
        form.add(vehicleBox, 1, 3);

        // ================= NOTE =================
        Label note = new Label(
                "Note: Visitor will receive a QR code / OTP for gate entry."
        );

        note.setPadding(new Insets(10));
        note.setMaxWidth(Double.MAX_VALUE);
        note.setStyle(
                "-fx-background-color: #EAF2FF;" +
                "-fx-text-fill: #315B9A;" +
                "-fx-font-size: 12px;" +
                "-fx-background-radius: 5;"
        );

        // ================= BUTTONS =================
        Button clearBtn = new Button("Clear");
        clearBtn.setPrefWidth(90);
        clearBtn.setPrefHeight(35);

        clearBtn.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D1D5DB;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;"
        );

        Button sendInviteBtn = new Button("Send Invite");
        sendInviteBtn.setPrefWidth(120);
        sendInviteBtn.setPrefHeight(35);

        sendInviteBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        buttons.getChildren().addAll(clearBtn, sendInviteBtn);

        // Clear button
        clearBtn.setOnAction(e -> {
            visitorName.clear();
            phoneNumber.clear();
            vehicleNumber.clear();

            purpose.setValue(null);
            visitDate.setValue(null);
            visitTime.setValue(null);
            flatVisit.setValue(null);
            gateEntry.setValue(null);
        });

        // Send Invite button
        sendInviteBtn.setOnAction(e -> {

            if (visitorName.getText().isEmpty()
                    || phoneNumber.getText().isEmpty()
                    || purpose.getValue() == null
                    || visitDate.getValue() == null
                    || visitTime.getValue() == null
                    || flatVisit.getValue() == null
                    || gateEntry.getValue() == null) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all required visitor details.");
                alert.showAndWait();

            } else {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invitation Sent");
                alert.setHeaderText(null);
                alert.setContentText(
                        "Visitor invitation sent successfully!"
                );
                alert.showAndWait();
            }
        });

        // ================= TODAY'S INVITED VISITORS =================

        Label todayTitle = new Label("Today's Invited Visitors");
        todayTitle.setFont(Font.font("System", FontWeight.BOLD, 16));

        HBox visitor1 = createVisitorRow(
                "Rahul Sharma",
                "Service Visit",
                "A-101",
                "10:00 AM",
                "Approved"
        );

        HBox visitor2 = createVisitorRow(
                "Delivery Partner",
                "Delivery",
                "A-101",
                "11:30 AM",
                "Approved"
        );

        VBox visitorList = new VBox(8);
        visitorList.getChildren().addAll(visitor1, visitor2);

        // ================= ADD EVERYTHING =================

        mainContent.getChildren().addAll(
                heading,
                form,
                note,
                buttons,
               
                todayTitle,
                visitorList
        );

        
 BorderPane mainarea = new BorderPane();
 mainarea.setTop(heading);
mainarea.setCenter(mainContent);
heading.setStyle("-fx-background-color: #4e342e");
        root.setCenter(mainarea);

        return new Scene(root, 
         ScreenSize.getWidth(),
        ScreenSize.getHeight());

    }

    // ================= VISITOR ROW =================

    private HBox createVisitorRow(
            String name,
            String purpose,
            String flat,
            String time,
            String status) {

        Label nameLabel = new Label(name);
        nameLabel.setFont(Font.font("System", FontWeight.BOLD, 13));

        Label purposeLabel = new Label(purpose);
        Label flatLabel = new Label(flat);
        Label timeLabel = new Label(time);

        Label statusLabel = new Label(status);

        statusLabel.setStyle(
                "-fx-background-color: #DFF6E5;" +
                "-fx-text-fill: #16803C;" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-background-radius: 12;"
        );

        HBox row = new HBox(20);
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(12));






        
        row.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E5E7EB;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;"
        );

        HBox.setHgrow(nameLabel, Priority.ALWAYS);

        row.getChildren().addAll(
                nameLabel,
                purposeLabel,
                flatLabel,
                timeLabel,
                statusLabel
        );

        return row;
    


    }
}
