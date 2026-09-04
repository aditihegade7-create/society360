
package com.society.view.Guard_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.society.view.ScreenSize;

public class Parking {

    static class ParkingSpot {

        String spotNumber;
        boolean occupied;
        String vehicleNumber;
        String ownerName;
        String vehicleType;

        ParkingSpot(String spotNumber) {

            this.spotNumber = spotNumber;
            this.occupied = false;
            this.vehicleNumber = "";
            this.ownerName = "";
            this.vehicleType = "";
        }
    }


    static ArrayList<ParkingSpot> parkingSpots =
            new ArrayList<>();

    private static void initializeParkingSpots() {

        if (!parkingSpots.isEmpty()) {
            return;
        }

        // Zone A
        parkingSpots.add(new ParkingSpot("A-01"));
        parkingSpots.add(new ParkingSpot("A-02"));
        parkingSpots.add(new ParkingSpot("A-03"));
        parkingSpots.add(new ParkingSpot("A-04"));

        // Zone B
        parkingSpots.add(new ParkingSpot("B-01"));
        parkingSpots.add(new ParkingSpot("B-02"));
        parkingSpots.add(new ParkingSpot("B-03"));
        parkingSpots.add(new ParkingSpot("B-04"));

        // Zone C
        parkingSpots.add(new ParkingSpot("C-01"));
        parkingSpots.add(new ParkingSpot("C-02"));
        parkingSpots.add(new ParkingSpot("C-03"));
        parkingSpots.add(new ParkingSpot("C-04"));
    }

    public static Scene createScene(Stage stage) {
        initializeParkingSpots();

        BorderPane root = new BorderPane();

        GuardSidebar sidebar = new GuardSidebar(stage, "Parking");

        root.setLeft(sidebar.getSidebar());


        VBox content = new VBox();

        content.setPadding(
                new Insets(25, 40, 25, 40)
        );

        content.setSpacing(18);

        content.setStyle(
                "-fx-background-color: #e8ddd5 ;"
        );

HBox header = new HBox();
header.setPadding(new Insets(25, 35, 25, 35));
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("Parking / Vehicle Entry");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Check parking availability and allot a space to vehicles."
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

        HBox summary =
                createSummary();

        VBox parkingCard =
                new VBox();

        parkingCard.setPadding(
                new Insets(20)
        );

        parkingCard.setSpacing(15);

        parkingCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;"
        );


        Label parkingTitle =
                new Label("Parking Availability");

        parkingTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #0c0c0c;"
        );


        Label instruction =
                new Label(
                        "Green = Available     Red = Occupied"
                );

        instruction.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #080808;"
        );

        GridPane parkingGrid =new GridPane();
        parkingGrid.setHgap(12);
        parkingGrid.setVgap(12);
        parkingGrid.setAlignment(Pos.CENTER_LEFT);

        for (int i = 0; i < parkingSpots.size(); i++) {

            ParkingSpot spot =
                    parkingSpots.get(i);

            Button spotButton =
                    createSpotButton(spot);

            int column = i % 6;
            int row = i / 6;

            parkingGrid.add(
                    spotButton,
                    column,
                    row
            );
        }

        parkingCard.getChildren().addAll(
                parkingTitle,
                instruction,
                parkingGrid
        );

        VBox entryCard =
                new VBox();

        entryCard.setPadding(
                new Insets(20)
        );
        entryCard.setSpacing(15);
        entryCard.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 12;"
        );

        Label entryTitle =
                new Label("Vehicle Entry");

        entryTitle.setStyle(
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #0a0a0a;"
        );

        Label vehicleLabel =
                createLabel("Vehicle Number *");

        TextField vehicleField =
                new TextField();

        vehicleField.setPromptText(
                "Example: MH12AB1234"
        );

        styleField(vehicleField);

        Label ownerLabel =
                createLabel("Owner / Resident Name *");

        TextField ownerField =
                new TextField();

        ownerField.setPromptText(
                "Enter name"
        );

        styleField(ownerField);

        Label typeLabel =
                createLabel("Vehicle Type *");

        ComboBox<String> vehicleTypeBox =
                new ComboBox<>();

        vehicleTypeBox.getItems().addAll(
                "Car",
                "Bike",
                "Scooter",
                "Other"
        );

        vehicleTypeBox.setPromptText(
                "Select vehicle type"
        );

        styleComboBox(vehicleTypeBox);

        Label selectedLabel =
                createLabel("Assigned Parking Spot");

        Label selectedSpot =
                new Label("Not assigned");

        selectedSpot.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #080808;"
        );

        GridPane entryGrid =
                new GridPane();

        entryGrid.setHgap(25);
        entryGrid.setVgap(12);

        ColumnConstraintsHelper.addTwoColumns(
                entryGrid
        );


        entryGrid.add(
                vehicleLabel,
                0, 0
        );

        entryGrid.add(
                ownerLabel,
                1, 0
        );

        entryGrid.add(
                vehicleField,
                0, 1
        );

        entryGrid.add(
                ownerField,
                1, 1
        );

        entryGrid.add(
                typeLabel,
                0, 2
        );

        entryGrid.add(
                selectedLabel,
                1, 2
        );

        entryGrid.add(
                vehicleTypeBox,
                0, 3
        );

        entryGrid.add(
                selectedSpot,
                1, 3
        );

        Button findSpotButton =
                new Button("Find Available Spot");

        findSpotButton.setPrefWidth(180);
        findSpotButton.setPrefHeight(40);

        findSpotButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        Button parkButton =
                new Button("Park Vehicle");

        parkButton.setPrefWidth(150);
        parkButton.setPrefHeight(40);

        parkButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        Button clearButton =
                new Button("Clear");

        clearButton.setPrefWidth(100);
        clearButton.setPrefHeight(40);

        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #0e0f0f;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        HBox entryButtons = new HBox(12,findSpotButton,parkButton,clearButton);
        entryButtons.setAlignment(Pos.CENTER_RIGHT);
        entryCard.getChildren().addAll(
                entryTitle,
                entryGrid,
                entryButtons);

        content.getChildren().addAll(
                header,
                summary,
                parkingCard,
                entryCard
        );

        root.setCenter(content);

        findSpotButton.setOnAction(e -> {

            ParkingSpot availableSpot =
                    findAvailableSpot();

            if (availableSpot == null) {

                showMessage(
                        "Parking Full",
                        "There are no available parking spots."
                );
                selectedSpot.setText("No spot available");
                return;
            }
            selectedSpot.setText(availableSpot.spotNumber);
        });

        parkButton.setOnAction(e -> {

            if (
                    vehicleField.getText()
                            .trim()
                            .isEmpty()
                    ||
                    ownerField.getText()
                            .trim()
                            .isEmpty()
                    ||
                    vehicleTypeBox.getValue() == null
            ) {

                showMessage(
                        "Missing Information",
                        "Please enter vehicle number, owner name and vehicle type."
                );
                return;
            }

            ParkingSpot spot =
                    findSpotByNumber(
                            selectedSpot.getText()
                    );


            if (spot == null) {

                showMessage(
                        "Parking Spot Required",
                        "Please find an available parking spot first."
                );
                return;
            }

            if (spot.occupied) {

                showMessage(
                        "Spot Occupied",
                        "This parking spot is already occupied."
                );
                return;
            }

            spot.occupied = true;

            spot.vehicleNumber =
                    vehicleField.getText()
                            .trim();

            spot.ownerName =
                    ownerField.getText()
                            .trim();

            spot.vehicleType =
                    vehicleTypeBox.getValue();


            showMessage(
                    "Parking Allotted",
                    "Vehicle allotted to parking spot "
                            + spot.spotNumber
            );

            stage.setScene(createScene(stage));
        });

        clearButton.setOnAction(e -> {
            vehicleField.clear();
            ownerField.clear();
            vehicleTypeBox.setValue(null);
            selectedSpot.setText(
                    "Not assigned"
            );
        });
        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(content);
        root.setCenter(mainarea);
        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
}

    private static Button createSpotButton(
            ParkingSpot spot) {

        Button button =
                new Button();

        button.setPrefWidth(105);
        button.setPrefHeight(55);

        updateSpotButton(
                button,
                spot
        );


        button.setOnAction(e -> {

            if (spot.occupied) {

                showMessage(
                        "Occupied Spot",
                        "Vehicle: "
                                + spot.vehicleNumber
                                + "\nOwner: "
                                + spot.ownerName
                );

            } else {

                showMessage(
                        "Available Spot",
                        "Parking spot "
                                + spot.spotNumber
                                + " is available."
                );
            }
        });
        return button;
    }

    private static void updateSpotButton(
            Button button,
            ParkingSpot spot) {

        if (spot.occupied) {

            button.setText(
                    spot.spotNumber
                            + "\nOccupied"
            );

            button.setStyle(
                    "-fx-background-color: #C96B6B;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 7;"
            );

        } else {

            button.setText(
                    spot.spotNumber
                            + "\nAvailable"
            );

            button.setStyle(
                    "-fx-background-color: #A9D6B5;" +
                    "-fx-text-fill: #183A2D;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 7;"
            );
        }
    }

    private static ParkingSpot findAvailableSpot() {

        for (ParkingSpot spot :
                parkingSpots) {

            if (!spot.occupied) {

                return spot;
            }
        }
        return null;
    }

    private static ParkingSpot findSpotByNumber(
            String spotNumber) {

        for (ParkingSpot spot :
                parkingSpots) {

            if (
                    spot.spotNumber.equals(
                            spotNumber
                    )
            ) {

                return spot;
            }
        }

        return null;
    }

    private static HBox createSummary() {

        int total = parkingSpots.size();
        int occupied = 0;

        for (ParkingSpot spot :
                parkingSpots) {

            if (spot.occupied) {
                occupied++;
            }
        }

        int available = total - occupied;

        Label totalLabel = new Label("Total Spots\n" + total);
        Label availableLabel = new Label("Available\n" + available);
        Label occupiedLabel = new Label("Occupied\n" + occupied);

        styleSummaryLabel(
                totalLabel
        );

        styleSummaryLabel(
                availableLabel
        );

        styleSummaryLabel(
                occupiedLabel
        );

        HBox summary = new HBox(15,totalLabel,availableLabel,occupiedLabel);
        summary.setAlignment(Pos.CENTER_LEFT);
        return summary;
    }

    private static void styleSummaryLabel(
            Label label) {

        label.setPrefWidth(180);
        label.setPrefHeight(55);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setPadding(new Insets(10));
        label.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-text-fill: #080808;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 7;"
        );
    }

    private static Label createLabel(String text) {

        Label label = new Label(text);
        label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #090a0a;"
        );
        return label;
    }

    private static void styleField(TextField field) {
        field.setMaxWidth(Double.MAX_VALUE);
        field.setPrefHeight(40);
        field.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #050505;" +
                "-fx-prompt-text-fill: #52606D;"
        );
    }

    private static void styleComboBox(ComboBox<String> box) {
        box.setMaxWidth(Double.MAX_VALUE);
        box.setPrefHeight(40);
        box.setStyle(
                "-fx-background-color: #F4F7F4;" +
                "-fx-background-radius: 6;" +
                "-fx-text-fill: #090909;"
        );
    }

    private static void showMessage(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    static class ColumnConstraintsHelper {

        static void addTwoColumns(GridPane grid) {

            javafx.scene.layout.ColumnConstraints
                    column1 =new javafx.scene.layout.ColumnConstraints();

            javafx.scene.layout.ColumnConstraints
                    column2 = new javafx.scene.layout.ColumnConstraints();

            column1.setPercentWidth(50);
            column2.setPercentWidth(50);
            column1.setHgrow(Priority.ALWAYS);
            column2.setHgrow(Priority.ALWAYS);

            grid.getColumnConstraints().addAll(column1,column2);
        }
    }
}