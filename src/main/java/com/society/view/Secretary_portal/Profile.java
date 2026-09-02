package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Profile {

    // Private Scene variable
    private Scene profileScene;

    public Scene createScene(Stage stage) {

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
         mainvb.setPadding(new Insets(25, 35, 25, 35));
        mainvb.setSpacing(20);
        mainvb.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        Profile.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, false, true
                )
        );

        mainvb.setBackground(new Background(backgroundImage));

        // HEADING

        Label heading = new Label("PROFILE");               
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // TITLE

        Label title =  new Label("My Profile");
        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label subtitle =
                new Label(
                        "View and manage your secretary profile"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        // PROFILE CARD

        VBox profileCard =
                new VBox(18);

        profileCard.setPadding(
                new Insets(25)
        );

        profileCard.setPrefWidth(900);

        profileCard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        // PROFILE PHOTO PLACEHOLDER

        Label profilePhoto =   new Label("👤");             
        profilePhoto.setPrefSize(90, 90);
        profilePhoto.setAlignment(
                Pos.CENTER
        );

        profilePhoto.setStyle(
                "-fx-background-color:#E5F7EC;" +
                "-fx-background-radius:50;" +
                "-fx-font-size:35px;"
        );

        // NAME

        Label name =  new Label("Secretary");
        name.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        Label role =
                new Label("Society Secretary");

        role.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#777777;"
        );


        VBox nameBox =
                new VBox(5);

        nameBox.getChildren().addAll(
                name,
                role
        );


        HBox profileTop =
                new HBox(20);

        profileTop.setAlignment(
                Pos.CENTER_LEFT
        );

        profileTop.getChildren().addAll(
                profilePhoto,
                nameBox
        );


        // NAME FIELD

        Label nameLabel =  new Label("Full Name");
        nameLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        TextField nameField = new TextField("Secretary");
        nameField.setPrefHeight(40);

        // EMAIL FIELD

        Label emailLabel =   new Label("Email");
        emailLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        TextField emailField =
                new TextField("secretary@society360.com");

        emailField.setPrefHeight(40);

        // MOBILE FIELD

        Label mobileLabel =
                new Label("Mobile Number");

        mobileLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        TextField mobileField =  new TextField("8625043207");
        mobileField.setPrefHeight(40);

        // FLAT / SOCIETY FIELD

        Label societyLabel =
                new Label("Society");

        societyLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        TextField societyField = new TextField("Society360 Residency");
        societyField.setPrefHeight(40);

        // SAVE BUTTON

        Button saveBtn = new Button("Save Changes");
        saveBtn.setPrefWidth(150);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );

        // ADD TO PROFILE CARD

        profileCard.getChildren().addAll(
                profileTop,

                nameLabel,
                nameField,

                emailLabel,
                emailField,

                mobileLabel,
                mobileField,

                societyLabel,
                societyField,

                saveBtn
        );

        // ADD EVERYTHING TO MAIN

        mainvb.getChildren().addAll(
                heading,
                title,
                subtitle,
                profileCard
        );

        // ROOT

        HBox root =  new HBox();
        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        // SCENE
      
        // profileScene =  new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        profileScene = scene;
        return profileScene;
    }
}