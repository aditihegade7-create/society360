package com.society.view.Resident_portal;

import javafx.scene.Scene;
import javafx.stage.Stage;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ProfilePage {

    public Scene getProfileScene(Stage stage) {

        // ================= SIDEBAR =================

        panel panelobj = new panel(stage);

        // ================= ROOT =================

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

        Label title = new Label("My Profile");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "View and manage your personal information"
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

        // ================= PROFILE CARD =================

        VBox profileCard = new VBox(20);

        profileCard.setPadding(
                new Insets(25)
        );

        profileCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 12;"
        );

        // ================= PROFILE HEADER =================

        HBox profileHeader = new HBox(20);

        profileHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        // Profile icon / initials

        Label profileIcon =
                new Label("VK");

        profileIcon.setAlignment(
                Pos.CENTER
        );

        profileIcon.setPrefSize(
                80,
                80
        );

        profileIcon.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        24
                )
        );

        profileIcon.setTextFill(Color.WHITE);

        profileIcon.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-background-radius: 40;"
        );

        VBox profileName = new VBox(5);

        Label name =
                new Label("Vaishnavi Kapse");

        name.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        21
                )
        );

        name.setTextFill(
                Color.web("#263238")
        );

        Label role =
                new Label("Resident");

        role.setFont(
                Font.font("System", 14)
        );

        role.setTextFill(
                Color.web("#789098")
        );

        profileName.getChildren().addAll(
                name,
                role
        );

        profileHeader.getChildren().addAll(
                profileIcon,
                profileName
        );

        // ================= SEPARATOR =================

        Separator separator =
                new Separator();

        // ================= INFORMATION =================

        GridPane details =
                new GridPane();

        details.setHgap(30);
        details.setVgap(18);

        // Row 1

        Label fullNameLabel =
                createLabel("Full Name");

        Label fullNameValue =
                createValue("Vaishnavi Kapse");

        details.add(
                fullNameLabel,
                0,
                0
        );

        details.add(
                fullNameValue,
                1,
                0
        );

        // Row 2

        Label emailLabel =
                createLabel("Email");

        Label emailValue =
                createValue("vaishnavi@example.com");

        details.add(
                emailLabel,
                0,
                1
        );

        details.add(
                emailValue,
                1,
                1
        );

        // Row 3

        Label phoneLabel =
                createLabel("Phone Number");

        Label phoneValue =
                createValue("+91 98765 43210");

        details.add(
                phoneLabel,
                0,
                2
        );

        details.add(
                phoneValue,
                1,
                2
        );

        // Row 4

        Label flatLabel =
                createLabel("Flat Number");

        Label flatValue =
                createValue("A-204");

        details.add(
                flatLabel,
                0,
                3
        );

        details.add(
                flatValue,
                1,
                3
        );

        // Row 5

        Label wingLabel =
                createLabel("Wing");

        Label wingValue =
                createValue("A Wing");

        details.add(
                wingLabel,
                0,
                4
        );

        details.add(
                wingValue,
                1,
                4
        );

        // Row 6

        Label memberLabel =
                createLabel("Membership");

        Label memberValue =
                createValue("Active");

        details.add(
                memberLabel,
                0,
                5
        );

        details.add(
                memberValue,
                1,
                5
        );

        // ================= BUTTONS =================

        HBox buttonBox =
                new HBox(12);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button editButton =
                new Button("Edit Profile");

        editButton.setPrefHeight(38);

        editButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        editButton.setOnAction(e -> {

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Edit Profile");

            alert.setHeaderText(
                    "Edit Profile"
            );

            alert.setContentText(
                    "Profile editing option selected."
            );

            alert.showAndWait();
        });

        Button passwordButton =
                new Button("Change Password");

        passwordButton.setPrefHeight(38);

        passwordButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #789098;" +
                "-fx-border-color: #789098;" +
                "-fx-border-radius: 6;" +
                "-fx-font-weight: bold;"
        );

        passwordButton.setOnAction(e -> {

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Change Password");

            alert.setHeaderText(
                    "Change Password"
            );

            alert.setContentText(
                    "Password change option selected."
            );

            alert.showAndWait();
        });

        buttonBox.getChildren().addAll(
                passwordButton,
                editButton
        );

        // ================= ADD PROFILE CONTENT =================

        profileCard.getChildren().addAll(
                profileHeader,
                separator,
                details,
                buttonBox
        );

        // ================= MAIN CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                profileCard
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
    // CREATE LABEL
    // =====================================================

    private Label createLabel(String text) {

        Label label =
                new Label(text);

        label.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        label.setTextFill(
                Color.web("#607D8B")
        );

        return label;
    }

    // =====================================================
    // CREATE VALUE
    // =====================================================

    private Label createValue(String text) {

        Label label =
                new Label(text);

        label.setFont(
                Font.font(
                        "System",
                        FontWeight.NORMAL,
                        14
                )
        );

        label.setTextFill(
                Color.web("#263238")
        );

        return label;
    }


   }