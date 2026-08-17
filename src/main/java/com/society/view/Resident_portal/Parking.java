package com.society.view.Resident_portal;

import javafx.scene.Scene;
import javafx.stage.Stage;


    

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Parking {

    // Your assigned parking slot
    private final String myParkingSlot = "P-03";

    public Scene getParkingScene(Stage stage) {

        // ================= HEADER =================

        Label title = new Label("Smart Parking");
        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;"
        );

        Label subtitle = new Label(
                "Check parking availability and monitor your assigned parking area"
        );

        subtitle.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: white;"
        );

        VBox header = new VBox(5, title, subtitle);

        header.setPadding(new Insets(20));

        header.setStyle(
                "-fx-background-color: #b3adad;"
        );


        // ================= SIDEBAR =================

        panel panelObj = new panel(stage);
     
        

        // ================= MAIN CONTENT =================


        
        VBox mainContent = new VBox(20);

        mainContent.setPadding(new Insets(25));

       

        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

VBox vBox = new VBox();
vBox.getChildren().addAll(header,mainContent);

        // ================= MY PARKING CARD =================

        Label myParkingTitle = new Label("My Parking Area");

        myParkingTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #263238;"
        );


        Label mySlot = new Label(
                "Assigned Parking: " + myParkingSlot
        );

        mySlot.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        Label myStatus = new Label("● AVAILABLE");

        myStatus.setStyle(
                "-fx-text-fill: green;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );


        VBox myParkingCard = new VBox(
                10,
                myParkingTitle,
                mySlot,
                myStatus
        );

        myParkingCard.setPadding(new Insets(20));

        myParkingCard.setMaxWidth(700);

        myParkingCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: #789098;" +
                "-fx-border-radius: 12;"
        );


        // ================= AVAILABILITY TITLE =================

        Label availabilityTitle =
                new Label("Parking Availability");

        availabilityTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #263238;"
        );


        // ================= PARKING GRID =================

        GridPane parkingGrid = new GridPane();

        parkingGrid.setHgap(15);

        parkingGrid.setVgap(15);

        parkingGrid.setAlignment(Pos.CENTER);


        // Create parking slots
        addParkingSlot(parkingGrid, "P-01", 0, 0, false);
        addParkingSlot(parkingGrid, "P-02", 1, 0, true);
        addParkingSlot(parkingGrid, "P-03", 2, 0, false); // MY SLOT
        addParkingSlot(parkingGrid, "P-04", 3, 0, false);

        addParkingSlot(parkingGrid, "P-05", 0, 1, true);
        addParkingSlot(parkingGrid, "P-06", 1, 1, false);
        addParkingSlot(parkingGrid, "P-07", 2, 1, true);
        addParkingSlot(parkingGrid, "P-08", 3, 1, false);


        // ================= SIMULATION =================

        Button simulateButton =
                new Button("🚗 Simulate Car Parking");

        simulateButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 10px 20px;"
        );


        simulateButton.setOnAction(event -> {

            // Someone parks in your slot
            myStatus.setText("● OCCUPIED");

            myStatus.setStyle(
                    "-fx-text-fill: red;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;"
            );


            // Notification
            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Smart Parking Alert");

            alert.setHeaderText("Parking Alert!");

            alert.setContentText(
                    "A vehicle has been detected in your parking area "
                    + myParkingSlot
                    + ".\n\nPlease check your parking slot."
            );

            alert.show();
        });


        // ================= MAIN CONTENT =================

        mainContent.getChildren().addAll(
                myParkingCard,
                availabilityTitle,
                parkingGrid,
                simulateButton
        );


        // ================= SCROLL =================

        ScrollPane scrollPane =
                new ScrollPane(mainContent);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );


        // ================= MAIN BORDERPANE =================

        BorderPane borderPane =
                new BorderPane();

        borderPane.setLeft(panelObj.getSidebar());

       

        borderPane.setCenter(scrollPane);


        return new Scene(borderPane, 1200, 700);
    }


    // ==================================================
    // PARKING SLOT METHOD
    // ==================================================

    private void addParkingSlot(
            GridPane grid,
            String slotName,
            int column,
            int row,
            boolean occupied) {

        Label slot = new Label();

        slot.setPrefSize(130, 80);

        slot.setAlignment(Pos.CENTER);

        if (slotName.equals(myParkingSlot)) {

            slot.setText(
                    "⭐ " + slotName + "\nMY PARKING"
            );

        } else {

            slot.setText(slotName);
        }


        // OCCUPIED
        if (occupied) {

            slot.setStyle(
                    "-fx-background-color: #e57373;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;"
            );

        }

        // MY PARKING
        else if (slotName.equals(myParkingSlot)) {

            slot.setStyle(
                    "-fx-background-color: #81c784;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-color: #2e7d32;" +
                    "-fx-border-width: 3;" +
                    "-fx-border-radius: 10;"
            );

        }

        // AVAILABLE
        else {

            slot.setStyle(
                    "-fx-background-color: #a5d6a7;" +
                    "-fx-text-fill: #1b5e20;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;"
            );
        }


        grid.add(slot, column, row);
    }
}








        // ================= SIDEBAR =================
       