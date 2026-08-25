package com.society.view.Resident_portal;

import javafx.scene.control.*;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Emergency {
public Scene getEmergencyScene(Stage stage){
        
 panel panelobj = new panel(stage);

 
        

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // ================= HEADING =================

        Label title = new Label("Emergency SOS");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Quickly request emergency assistance"
        );

        subtitle.setFont(
                Font.font("System", 14)
        );

        subtitle.setTextFill(Color.WHITE);

        VBox heading = new VBox(5);

        heading.getChildren().addAll(
                title,
                subtitle
        );

        // ================= SOS CARD =================

        VBox sosCard = new VBox(15);

        sosCard.setAlignment(
                Pos.CENTER
        );

        sosCard.setPadding(
                new Insets(25)
        );

        sosCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12;"
        );

        Label sosTitle =
                new Label("Need Emergency Help?");

        sosTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        20
                )
        );

        sosTitle.setTextFill(
                Color.web("#263238")
        );

        Label sosDescription =
                new Label(
                        "Press the SOS button to alert " +
                        "society security immediately."
                );

        sosDescription.setWrapText(true);

        sosDescription.setTextAlignment(
                javafx.scene.text.TextAlignment.CENTER
        );

        sosDescription.setTextFill(
                Color.web("#546E7A")
        );

        // ================= SOS BUTTON =================

        Button sosButton =
                new Button("SOS");

        sosButton.setPrefSize(
                130,
                130
        );

        sosButton.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        30
                )
        );

        sosButton.setStyle(
                "-fx-background-color: #D32F2F;" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 65;"
        );

        sosButton.setOnAction(e -> {

            Alert confirmation =
                    new Alert(
                            Alert.AlertType.CONFIRMATION
                    );

            confirmation.setTitle(
                    "Emergency SOS"
            );

            confirmation.setHeaderText(
                    "Send Emergency SOS?"
            );

            confirmation.setContentText(
                    "This will alert society security " +
                    "that you need immediate assistance."
            );

            confirmation.showAndWait()
                    .ifPresent(response -> {

                        if (response ==
                                ButtonType.OK) {

                            Alert sent =
                                    new Alert(
                                            Alert.AlertType.INFORMATION
                                    );

                            sent.setTitle(
                                    "SOS Sent"
                            );

                            sent.setHeaderText(
                                    "Emergency Alert Sent"
                            );

                            sent.setContentText(
                                    "Society security has been " +
                                    "notified. Please stay safe " +
                                    "and wait for assistance."
                            );

                            sent.showAndWait();
                        }
                    });
        });

        sosCard.getChildren().addAll(
                sosTitle,
                sosDescription,
                sosButton
        );

        // ================= EMERGENCY SERVICES =================

        Label servicesTitle =
                new Label("Emergency Services");

        servicesTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        servicesTitle.setTextFill(
                Color.WHITE
        );

        HBox serviceCards =
                new HBox(15);

        VBox securityCard =
                createServiceCard(
                        "Society Security",
                        "Immediate assistance",
                        "Contact"
                );

        VBox policeCard =
                createServiceCard(
                        "Police",
                        "Emergency assistance",
                        "Call 112"
                );

        VBox ambulanceCard =
                createServiceCard(
                        "Ambulance",
                        "Medical emergency",
                        "Call 108"
                );

        VBox fireCard =
                createServiceCard(
                        "Fire Department",
                        "Fire emergency",
                        "Call 101"
                );

        serviceCards.getChildren().addAll(
                securityCard,
                policeCard,
                ambulanceCard,
                fireCard
        );

        // ================= ADD CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                sosCard,
                servicesTitle,
                serviceCards
        );

       
BorderPane mainarea = new BorderPane();
mainarea.setTop(heading);
mainarea.setCenter(mainContent);


root.setCenter(mainarea);        


        return new Scene(
                root,
                 ScreenSize.getWidth(),
                ScreenSize.getHeight());

    }

    // =====================================================
    // SERVICE CARD
    // =====================================================

    private VBox createServiceCard(
            String title,
            String description,
            String buttonText) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setPrefWidth(200);

        card.setPrefHeight(120);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        15
                )
        );

        titleLabel.setTextFill(
                Color.web("#263238")
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setWrapText(true);

        descriptionLabel.setTextFill(
                Color.web("#607D8B")
        );

        Button actionButton =
                new Button(buttonText);

        actionButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        card.getChildren().addAll(
                titleLabel,
                descriptionLabel,
                actionButton
        );

        return card;
    }
}


