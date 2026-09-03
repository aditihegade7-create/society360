package com.society.view.Resident_portal;

import com.society.dao.Secretary_dao.SecretaryParkingDAO;
import com.society.model.Secretary_model.SecretaryParking_model.AssignedParking;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.society.view.ScreenSize;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    // =========================================================
    // LOGGED-IN RESIDENT'S PARKING SLOTS
    // =========================================================

    private final List<String> myParkingSlots = new ArrayList<>();

    // Kept for compatibility with existing code
    private String myParkingSlot = "NOT ALLOCATED";

    // =========================================================
    // OLD METHOD
    // =========================================================
    // This method is kept so existing code can compile.
    //
    // IMPORTANT:
    // If this method is called, there is no resident email,
    // therefore Firestore cannot identify the resident.
    //
    // Prefer:
    // getParkingScene(stage, residentEmail)
    // =========================================================

    public Scene getParkingScene(Stage stage) {
        return getParkingScene(stage, null);
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public Scene getParkingScene(Stage stage, String residentEmail) {

        // =====================================================
        // RESET PREVIOUS PARKING DATA
        // =====================================================

        myParkingSlots.clear();
        myParkingSlot = "NOT ALLOCATED";

        // =====================================================
        // FETCH RESIDENT'S ASSIGNED PARKING
        // =====================================================

        if (residentEmail != null && !residentEmail.trim().isEmpty()) {

            residentEmail = residentEmail.trim();

            try {

                System.out.println();
                System.out.println("========================================");
                System.out.println("RESIDENT PARKING FETCH");
                System.out.println("Resident Email : " + residentEmail);
                System.out.println("========================================");

                SecretaryParkingDAO parkingDAO =
                        new SecretaryParkingDAO();

                List<AssignedParking> assignments =
                        parkingDAO.getAssignedParkingForResident(residentEmail);

                // =================================================
                // CHECK ASSIGNED PARKING
                // =================================================

                if (assignments != null && !assignments.isEmpty()) {

                    for (AssignedParking parking : assignments) {

                        if (parking == null) {
                            continue;
                        }

                        String slot = parking.getSlot();

                        if (slot != null && !slot.trim().isEmpty()) {

                            slot = slot.trim();

                            // Avoid duplicate slot entries
                            if (!myParkingSlots.contains(slot)) {
                                myParkingSlots.add(slot);
                            }

                            System.out.println(
                                    "----------------------------------------");

                            System.out.println(
                                    "Assigned Parking Slot : " + slot);

                            System.out.println(
                                    "Member : " + safe(parking.getMember()));

                            System.out.println(
                                    "Flat : " + safe(parking.getFlat()));

                            System.out.println(
                                    "Role : " + safe(parking.getRole()));

                            System.out.println(
                                    "Vehicle : " + safe(parking.getVehicle()));

                            System.out.println(
                                    "Status : " + safe(parking.getStatus()));
                        }
                    }

                    // =================================================
                    // FIRST SLOT FOR OLD COMPATIBILITY VARIABLE
                    // =================================================

                    if (!myParkingSlots.isEmpty()) {

                        myParkingSlot = myParkingSlots.get(0);

                        System.out.println(
                                "========================================");

                        System.out.println(
                                "TOTAL ASSIGNED PARKING SLOTS : "
                                        + myParkingSlots.size());

                        System.out.println(
                                "MY PARKING SLOTS : "
                                        + myParkingSlots);

                        System.out.println(
                                "========================================");
                    }

                } else {

                    System.out.println(
                            "No parking assigned to resident.");

                    System.out.println(
                            "Resident : " + residentEmail);
                }

            } catch (Exception e) {

                System.err.println(
                        "========================================");

                System.err.println(
                        "ERROR FETCHING RESIDENT PARKING");

                System.err.println(
                        "Resident Email : " + residentEmail);

                System.err.println(
                        "========================================");

                e.printStackTrace();

                myParkingSlots.clear();
                myParkingSlot = "NOT ALLOCATED";
            }

        } else {

            System.out.println(
                    "========================================");

            System.out.println(
                    "Resident email is null/empty.");

            System.out.println(
                    "Parking page requires the logged-in resident email.");

            System.out.println(
                    "========================================");
        }

        // =========================================================
        // SIDEBAR
        // =========================================================

        panel panelObj =
                new panel(stage, myParkingSlot);

        // =========================================================
        // HEADER
        // =========================================================

        Label title =
                new Label("Smart Parking");

        title.setStyle(
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;");

        Label subtitle =
                new Label(
                        "Check parking availability and monitor your assigned parking area");

        subtitle.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: white;");

        VBox header =
                new VBox(5);

        header.getChildren().addAll(
                title,
                subtitle);

        header.setStyle(
                "-fx-background-color: #b3adad;");

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox mainContent =
                new VBox(25);

        mainContent.setPadding(
                new Insets(25));

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;");

        // =========================================================
        // MY PARKING CARD
        // =========================================================

        Label myParkingTitle =
                new Label("My Parking Area");

        myParkingTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #263238;");

        // =========================================================
        // DISPLAY ALL ASSIGNED SLOTS
        // =========================================================

        String assignedParkingText;

        if (myParkingSlots.isEmpty()) {

            assignedParkingText =
                    "Assigned Parking: NOT ALLOCATED";

        } else {

            assignedParkingText =
                    "Assigned Parking: "
                            + String.join(", ", myParkingSlots);
        }

        Label mySlot =
                new Label(assignedParkingText);

        mySlot.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #37474f;");

        // =========================================================
        // PARKING STATUS
        // =========================================================

        Label myStatus;

        if (myParkingSlots.isEmpty()) {

            myStatus =
                    new Label("● NOT ALLOCATED");

            myStatus.setStyle(
                    "-fx-text-fill: #757575;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;");

        } else {

            myStatus =
                    new Label("● AVAILABLE");

            myStatus.setStyle(
                    "-fx-text-fill: green;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;");
        }

        VBox myParkingCard =
                new VBox(
                        10,
                        myParkingTitle,
                        mySlot,
                        myStatus);

        myParkingCard.setPadding(
                new Insets(20));

        myParkingCard.setMaxWidth(
                Double.MAX_VALUE);

        myParkingCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: #789098;" +
                "-fx-border-radius: 12;");

        // =========================================================
        // PARKING AVAILABILITY CARD
        // =========================================================

        Label availabilityTitle =
                new Label("Parking Availability");

        availabilityTitle.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #263238;");

        // =========================================================
        // PARKING GRID
        // =========================================================

        GridPane parkingGrid =
                new GridPane();

        parkingGrid.setHgap(20);
        parkingGrid.setVgap(20);

        parkingGrid.setAlignment(
                Pos.CENTER);

        // =========================================================
        // P-01 TO P-08
        // =========================================================

        addParkingSlot(
                parkingGrid,
                "P-01",
                0,
                0,
                false);

        addParkingSlot(
                parkingGrid,
                "P-02",
                1,
                0,
                true);

        addParkingSlot(
                parkingGrid,
                "P-03",
                2,
                0,
                false);

        addParkingSlot(
                parkingGrid,
                "P-04",
                3,
                0,
                false);

        addParkingSlot(
                parkingGrid,
                "P-05",
                0,
                1,
                true);

        addParkingSlot(
                parkingGrid,
                "P-06",
                1,
                1,
                false);

        addParkingSlot(
                parkingGrid,
                "P-07",
                2,
                1,
                true);

        addParkingSlot(
                parkingGrid,
                "P-08",
                3,
                1,
                false);

        // =========================================================
        // SIMULATION BUTTON
        // =========================================================

        Button simulateButton =
                new Button(
                        "🚗  Simulate Car Parking");

        simulateButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 10px 20px;" +
                "-fx-background-radius: 8px;");

        // =========================================================
        // SIMULATION ACTION
        // =========================================================

        simulateButton.setOnAction(event -> {

            // =====================================================
            // NO PARKING
            // =====================================================

            if (myParkingSlots.isEmpty()) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION);

                alert.setTitle(
                        "Smart Parking");

                alert.setHeaderText(
                        "No Parking Assigned");

                alert.setContentText(
                        "You currently do not have an assigned parking slot.");

                alert.show();

                return;
            }

            // =====================================================
            // CHANGE STATUS
            // =====================================================

            myStatus.setText(
                    "● OCCUPIED");

            myStatus.setStyle(
                    "-fx-text-fill: red;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;");

            // =====================================================
            // SHOW ALL ASSIGNED SLOTS IN ALERT
            // =====================================================

            String slots =
                    String.join(", ", myParkingSlots);

            Alert alert =
                    new Alert(
                            Alert.AlertType.WARNING);

            alert.setTitle(
                    "Smart Parking Alert");

            alert.setHeaderText(
                    "Parking Alert!");

            alert.setContentText(
                    "A vehicle has been detected in your parking area "
                            + slots
                            + ".\n\nPlease check your parking slot.");

            alert.show();
        });

        // =========================================================
        // WHITE PARKING AREA
        // =========================================================

        VBox parkingArea =
                new VBox(20);

        parkingArea.setPadding(
                new Insets(25));

        parkingArea.setAlignment(
                Pos.CENTER);

        parkingArea.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #789098;" +
                "-fx-border-radius: 15;");

        parkingArea.getChildren().addAll(
                availabilityTitle,
                parkingGrid,
                simulateButton);

        // =========================================================
        // ADD CONTENT
        // =========================================================

        mainContent.getChildren().addAll(
                myParkingCard,
                parkingArea);

        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(mainContent);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER);

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scrollPane.setStyle(
                "-fx-background-color: #b3adad;" +
                "-fx-control-inner-background: #b3adad;");

        // =========================================================
        // CENTER AREA
        // =========================================================

        BorderPane centerPane =
                new BorderPane();

        BorderPane mainarea =
                new BorderPane();

        mainarea.setTop(header);
        mainarea.setCenter(scrollPane);

        header.setStyle(
                "-fx-background-color: #b3adad");

        centerPane.setCenter(
                mainarea);

        // =========================================================
        // MAIN BORDERPANE
        // =========================================================

        BorderPane borderPane =
                new BorderPane();

        // =========================================================
        // SIDEBAR
        // =========================================================

        borderPane.setLeft(
                panelObj.getSidebar());

        // =========================================================
        // CENTER
        // =========================================================

        borderPane.setCenter(
                centerPane);

        // =========================================================
        // BACKGROUND
        // =========================================================

        borderPane.setStyle(
                "-fx-background-color: #b3adad;");

        // =========================================================
        // SCENE
        // =========================================================

        Scene scene =
                new Scene(
                        borderPane,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight());

        return scene;
    }

    // =========================================================
    // PARKING SLOT METHOD
    // =========================================================

    private void addParkingSlot(
            GridPane grid,
            String slotName,
            int column,
            int row,
            boolean occupied) {

        Label slot =
                new Label();

        // =====================================================
        // SIZE
        // =====================================================

        slot.setPrefSize(
                250,
                150);

        slot.setAlignment(
                Pos.CENTER);

        // =====================================================
        // CHECK WHETHER THIS IS RESIDENT'S SLOT
        // =====================================================

        boolean isMyParking =
                myParkingSlots.contains(slotName);

        // =====================================================
        // SLOT TEXT
        // =====================================================

        if (isMyParking) {

            slot.setText(
                    "⭐ " + slotName +
                    "\nMY PARKING");

        } else {

            slot.setText(
                    slotName);
        }

        // =====================================================
        // OCCUPIED
        // =====================================================

        if (occupied) {

            slot.setStyle(
                    "-fx-background-color: #e57373;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;");

        }

        // =====================================================
        // MY PARKING
        // =====================================================

        else if (isMyParking) {

            slot.setStyle(
                    "-fx-background-color: #81c784;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;" +
                    "-fx-border-color: #2e7d32;" +
                    "-fx-border-width: 3;" +
                    "-fx-border-radius: 10;");

        }

        // =====================================================
        // AVAILABLE
        // =====================================================

        else {

            slot.setStyle(
                    "-fx-background-color: #a5d6a7;" +
                    "-fx-text-fill: #1b5e20;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 10;");
        }

        // =====================================================
        // ADD SLOT
        // =====================================================

        grid.add(
                slot,
                column,
                row);
    }

    // =========================================================
    // SAFE STRING
    // =========================================================

    private String safe(String value) {

        if (value == null) {
            return "";
        }

        return value;
    }
}