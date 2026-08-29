package com.society.view.Owner_portal;

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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OwnerProfile {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
                
        OwnerSidebar sidebar = new OwnerSidebar(stage);

        root.setLeft( sidebar.getSidebar()
        );

        VBox mainContent = new VBox();

        mainContent.setPadding(new Insets(25,35,25,35));

        mainContent.setSpacing(20);

        mainContent.setStyle( "-fx-background-color: #e8ddd5;" );


        HBox header = new HBox();
        header.setPadding(new Insets(25,35,25,35));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox vb = new VBox();
        Label greeting = new Label("Owner Profile");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        Label description = new Label("View and manage owner details");
        description.setStyle("-fx-font-size:12px;-fx-text-fill: #ffffff;");

        vb.getChildren().addAll(greeting,description);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        

        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));
        day.setStyle("-fx-text-fill: #ffffff"); 
        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        date.setStyle("-fx-text-fill: #ffffff"); 
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(vb,
                spacer,
                vb1);


        Label title = new Label("Owner Profile" );

        title.setStyle( "-fx-font-size: 24px;-fx-font-weight: bold;-fx-text-fill: #102A43;" );

        Label subtitle = new Label("View and manage your personal details");

        subtitle.setStyle("-fx-font-size: 12px;-fx-text-fill: #263238;" );

        

        VBox profileCard = new VBox();
        profileCard.setPadding(new Insets(25));
        profileCard.setSpacing(20);
        profileCard.setMaxWidth( 900);

        profileCard.setStyle("-fx-background-color: #F4F7F8;-fx-background-radius: 12;");

        
        Label profileTitle = new Label( "Personal Information");
        profileTitle.setStyle( "-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #102A43;");

        Label profileSubtitle = new Label("Your registered owner information" );
        profileSubtitle.setStyle("-fx-font-size: 12px;-fx-text-fill: #546E7A;");

        VBox profileHeading = new VBox(4, profileTitle,profileSubtitle);

       
        GridPane form = new GridPane();
        form.setHgap(30);
        form.setVgap(15);

        
        Label nameLabel = new Label( "Full Name");
        TextField nameField = new TextField( "Owner Name");

       Label phoneLabel = new Label("Phone Number" );
       TextField phoneField = new TextField("9876543210");

        Label emailLabel = new Label("Email");

        TextField emailField = new TextField("owner@email.com");

        
        Label societyLabel = new Label("Society Name" );
        TextField societyField = new TextField("Green Acres Society" );

        Label flatLabel = new Label( "Flat / Unit Number");
        TextField flatField = new TextField( "A-101");

         Label ownerIdLabel = new Label("Owner ID");
        TextField ownerIdField = new TextField( "OWN001" );

        
        nameField.setPrefWidth(350);
        phoneField.setPrefWidth(350);

        emailField.setPrefWidth(350);
        societyField.setPrefWidth(350);

        flatField.setPrefWidth(350);
        ownerIdField.setPrefWidth(350);

        nameField.setPrefHeight(40);
        phoneField.setPrefHeight(40);

        emailField.setPrefHeight(40);
        societyField.setPrefHeight(40);

        flatField.setPrefHeight(40);
        ownerIdField.setPrefHeight(40);

        

        styleLabel(nameLabel);
        styleLabel(phoneLabel);

        styleLabel(emailLabel);
        styleLabel(societyLabel);

        styleLabel(flatLabel);
        styleLabel(ownerIdLabel);

        

        String fieldStyle ="-fx-background-color: white;-fx-border-color: #CBD5D8;-fx-border-radius: 6;-fx-background-radius: 6;";

        nameField.setStyle(fieldStyle);
        phoneField.setStyle(fieldStyle);

        emailField.setStyle(fieldStyle);
        societyField.setStyle(fieldStyle);

        flatField.setStyle(fieldStyle);
        ownerIdField.setStyle(fieldStyle);

        
        nameField.setEditable(false);
        phoneField.setEditable(false);

        emailField.setEditable(false);
        societyField.setEditable(false);

        flatField.setEditable(false);
        ownerIdField.setEditable(false);

        form.add(nameLabel,0,0);
        form.add(phoneLabel,1,0 );
        form.add( nameField, 0,1 );
        form.add(phoneField,1,1);
        form.add(emailLabel,0,2);
        form.add( societyLabel, 1, 2 );
        form.add(emailField,0,3);
        form.add(societyField,1,3);
        form.add(flatLabel,0,4 );
        form.add( ownerIdLabel, 1, 4);
        form.add(flatField,0,5 );
        form.add(ownerIdField,1, 5);

        

        Button editButton =new Button("Edit Profile");
        Button saveButton =new Button("Save Changes");

        editButton.setPrefWidth(130);
        editButton.setPrefHeight(40);

        saveButton.setPrefWidth(130);
        saveButton.setPrefHeight(40);

        editButton.setStyle(
                "-fx-background-color: #ffffff;-fx-text-fill: #4e342e;-fx-font-weight: bold;-fx-background-radius: 7;"
        );

        saveButton.setStyle("-fx-background-color: #4e342e;-fx-text-fill: #ffffff;-fx-font-weight: bold;-fx-background-radius: 7;"
        );

        
        saveButton.setDisable(true);
        editButton.setOnAction(e -> {

            nameField.setEditable(true);
            phoneField.setEditable(true);

            emailField.setEditable(true);
            societyField.setEditable(true);

            flatField.setEditable(true);

            saveButton.setDisable(false);
            editButton.setDisable(true);
        });

        
        saveButton.setOnAction(e -> {

            nameField.setEditable(false);
            phoneField.setEditable(false);

            emailField.setEditable(false);
            societyField.setEditable(false);

            flatField.setEditable(false);

            saveButton.setDisable(true);
            editButton.setDisable(false);
        });

        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        buttons.getChildren().addAll(editButton,saveButton);

        profileCard.getChildren().addAll(
                profileHeading,
                form,
                buttons
        );

        
        mainContent.getChildren().addAll(
                header,
                profileCard
        );

        
        BorderPane mainarea = new BorderPane();
       mainarea.setTop(header);
       mainarea.setCenter(mainContent);
       root.setCenter(mainarea);
       
        return new Scene(
                 root,
                 ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }

    

    private static void styleLabel( Label label
    ) {

        label.setStyle(
                "-fx-font-size: 12px;-fx-font-weight: bold;-fx-text-fill: #37474F;"
        );
    }
}