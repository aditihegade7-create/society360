package com.society.view.Resident_portal;

import javafx.scene.Scene;
import javafx.stage.Stage;




import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Aminity {
    public Scene getAminityScene(Stage stage){
        
 panel panelobj = new panel(stage);
 


    
     
        // ================= MAIN ROOT =================
        BorderPane root = new BorderPane();

        // Existing sidebar
        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================
        VBox mainContent = new VBox(18);
        mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setStyle("-fx-background-color: #b3adad;");

        // ================= TITLE =================
        Label title = new Label("Book Amenity");
        title.setFont(Font.font("System", FontWeight.BOLD, 24));
        title.setTextFill(Color.web("#172B4D"));

        Label subtitle = new Label("Reserve society amenities");
        subtitle.setFont(Font.font("System", 13));
        subtitle.setTextFill(Color.GRAY);

        VBox heading = new VBox(5);
        heading.getChildren().addAll(title, subtitle);

        // ================= AMENITY CARDS =================

        GridPane cards = new GridPane();

        cards.setHgap(15);
        cards.setVgap(15);

        // Community Hall
        VBox communityHall = createAmenityCard(
                "Community Hall",
                "₹ 1,000 / Slot",
                "Capacity: 100 People",
                "Available"
        );

        // Club House
        VBox clubHouse = createAmenityCard(
                "Club House",
                "₹ 800 / Slot",
                "Capacity: 50 People",
                "Available"
        );

        // Guest Room
        VBox guestRoom = createAmenityCard(
                "Guest Room",
                "₹ 500 / Night",
                "2 Beds • AC",
                "Available"
        );

        // Tennis Court
        VBox tennisCourt = createAmenityCard(
                "Tennis Court",
                "₹ 200 / Hour",
                "Outdoor Court",
                "Available"
        );

        // Basketball Court
        VBox basketballCourt = createAmenityCard(
                "Basketball Court",
                "₹ 150 / Hour",
                "Outdoor Court",
                "Available"
        );

        // Party Lawn
        VBox partyLawn = createAmenityCard(
                "Party Lawn",
                "₹ 2,000 / Slot",
                "Capacity: 200 People",
                "Available"
        );

        cards.add(communityHall, 0, 0);
        cards.add(clubHouse, 1, 0);
        cards.add(guestRoom, 2, 0);

        cards.add(tennisCourt, 0, 1);
        cards.add(basketballCourt, 1, 1);
        cards.add(partyLawn, 2, 1);

        // ================= UPCOMING BOOKING =================

        Label upcomingTitle = new Label("Upcoming Booking");
        upcomingTitle.setFont(
                Font.font("System", FontWeight.BOLD, 16)
        );

        HBox booking = new HBox(25);

        booking.setAlignment(Pos.CENTER_LEFT);
        booking.setPadding(new Insets(15));

        booking.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E5E7EB;" +
                "-fx-border-radius: 6;" +
                "-fx-background-radius: 6;"
        );

        Label amenity = new Label("Community Hall");
        amenity.setFont(
                Font.font("System", FontWeight.BOLD, 13)
        );

        Label date = new Label("17 May 2025");

        Label time = new Label("06:00 PM - 10:00 PM");

        Label status = new Label("Confirmed");

        status.setStyle(
                "-fx-background-color: #DFF6E5;" +
                "-fx-text-fill: #16803C;" +
                "-fx-padding: 5 12 5 12;" +
                "-fx-background-radius: 12;"
        );

        HBox.setHgrow(amenity, Priority.ALWAYS);

        booking.getChildren().addAll(
                amenity,
                date,
                time,
                status
        );

        // ================= ADD TO MAIN CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                cards,
                new Separator(),
                upcomingTitle,
                booking
        );

        root.setCenter(mainContent);

        return new Scene(root, 1200, 700);
    }

    // =====================================================
    // AMENITY CARD METHOD
    // =====================================================

    private VBox createAmenityCard(
            String name,
            String price,
            String details,
            String availability){

        VBox card = new VBox(8);

        card.setPadding(new Insets(15));

        card.setPrefWidth(250);
        card.setPrefHeight(135);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E5E7EB;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;"
        );

        Label nameLabel = new Label(name);

        nameLabel.setFont(
                Font.font("System", FontWeight.BOLD, 14)
        );

        

        nameLabel.setTextFill(Color.web("#172B4D"));

        Label priceLabel = new Label(price);

        priceLabel.setFont(
                Font.font("System", FontWeight.BOLD, 13)
        );

        Label detailsLabel = new Label(details);

        detailsLabel.setTextFill(Color.GRAY);

        Label availableLabel = new Label(availability);

        availableLabel.setStyle(
                "-fx-text-fill: #16803C;" +
                "-fx-font-weight: bold;"
        );

        Button bookButton = new Button("Book");

        bookButton.setPrefWidth(70);

        bookButton.setStyle(
                "-fx-background-color: #0B4F8A;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        bookButton.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Amenity Booking");
            alert.setHeaderText("Book " + name);
            alert.setContentText(
                    "Booking option selected for " + name
            );

            alert.showAndWait();
        });

        HBox bottom = new HBox(10);

        bottom.setAlignment(Pos.CENTER_LEFT);

        Region spacer = new Region();

        HBox.setHgrow(spacer, Priority.ALWAYS);

        bottom.getChildren().addAll(
                availableLabel,
                spacer,
                bookButton
        );

        card.getChildren().addAll(
                nameLabel,
                priceLabel,
                detailsLabel,
                bottom
        );

        return card;
    }
}



//VBox vb = new VBox();
   
    
