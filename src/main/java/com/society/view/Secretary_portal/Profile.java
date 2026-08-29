package com.society.view.Secretary_portal;

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

public class Profile {

   
    private Scene profileScene;

    public Scene createScene(Stage stage) {

        
        BorderPane root = new BorderPane();

        
        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        root.setLeft(sidebar);

       
        BorderPane mainarea =
                new BorderPane();

        
        HBox header =
                new HBox();

        header.setPrefHeight(80);
        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setPadding(
                new Insets(20)
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );

       
        VBox headerText =
                new VBox(4);

        Label greeting =
                new Label("My Profile");

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );

        Label description =
                new Label(
                        "View and manage your secretary profile"
                );

        description.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#ffffff;"
        );

        headerText.getChildren().addAll(
                greeting,
                description
        );

        
        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

       

        Label day =
                new Label();

        Label date =
                new Label();

        LocalDate today =
                LocalDate.now();

        day.setText(
                today.format(
                        DateTimeFormatter.ofPattern(
                                "EEEE"
                        )
                )
        );

        date.setText(
                today.format(
                        DateTimeFormatter.ofPattern(
                                "dd MMMM yyyy"
                        )
                )
        );

        day.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        date.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        VBox dateBox =
                new VBox(4);

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        dateBox.getChildren().addAll(
                day,
                date
        );

        
        header.getChildren().addAll(
                headerText,
                spacer,
                dateBox
        );

        

        VBox mainContent =
                new VBox(15);

        mainContent.setPadding(
                new Insets(
                        25,
                        30,
                        25,
                        30
                )
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );

       
        Label title =
                new Label("My Profile");

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

        

        VBox profileCard =
                new VBox(18);

        profileCard.setPadding(
                new Insets(25)
        );

        profileCard.setPrefWidth(900);

        profileCard.setMaxWidth(1180);

        profileCard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        

        Label profilePhoto =
                new Label("👤");

        profilePhoto.setPrefSize(
                90,
                90
        );

        profilePhoto.setAlignment(
                Pos.CENTER
        );

        profilePhoto.setStyle(
                "-fx-background-color:#E5F7EC;" +
                "-fx-background-radius:50;" +
                "-fx-font-size:35px;"
        );

        
        Label name =
                new Label("Secretary");

        name.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label role =
                new Label(
                        "Society Secretary"
                );

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

        Label nameLabel =
                new Label("Full Name");

        nameLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        TextField nameField =
                new TextField("Secretary");

        nameField.setPrefHeight(40);

       
        Label emailLabel =
                new Label("Email");

        emailLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        TextField emailField =
                new TextField(
                        "secretary@society360.com"
                );

        emailField.setPrefHeight(40);

      

        Label mobileLabel =
                new Label("Mobile Number");

        mobileLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        TextField mobileField =
                new TextField("8625043207");

        mobileField.setPrefHeight(40);

        
        Label societyLabel =
                new Label("Society");

        societyLabel.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        TextField societyField =
                new TextField(
                        "Society360 Residency"
                );

        societyField.setPrefHeight(40);

       
        Button saveBtn =
                new Button("Save Changes");

        saveBtn.setPrefWidth(150);

        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );

        
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

        
        mainContent.getChildren().addAll(
                title,
                subtitle,
                profileCard
        );

        
        mainarea.setTop(header);

        mainarea.setCenter(mainContent);

        
        root.setCenter(mainarea);

        
        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        profileScene = scene;

        return profileScene;
    }
}