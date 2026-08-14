package com.society.view.Secretary_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageResidents {

    public Scene createScene(Stage stage) {

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        VBox mainvb = new VBox();
        mainvb.setPrefWidth(1220);
        mainvb.setPrefHeight(750);
        mainvb.setPadding(new Insets(30));
        mainvb.setSpacing(10);
        mainvb.setStyle("-fx-background-color:#789098");
    
        //Title
        Label title = new Label("Manage Residents");
        title.setStyle("-fx-font-size:28px;-fx-font-weight:bold;-fx-text-fill:black");

        Label subtitle = new Label("View and manage all residents");
        subtitle.setStyle("-fx-font-size:14px;-fx-text-fill:#777777;");


        // search+add - Button
        
        TextField search = new TextField();
        search.setPromptText("Search resident, flat no., phone...");
        search.setPrefHeight(45);
        search.setPrefWidth(750);
        search.setStyle("-fx-background-color:#F8F9FA;-fx-border-color:#E1E5E8;-fx-border-radius:8;-fx-background-radius:8;-fx-font-size:14px;");


        Button addResidentBtn = new Button("+ Add New Resident");
        addResidentBtn.setPrefWidth(200);
        addResidentBtn.setPrefHeight(45);
        addResidentBtn.setStyle("-fx-background-color:#0B4F4A;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:8");

        HBox searchBox = new HBox(15);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.getChildren().addAll(search,addResidentBtn);

    
        //Resident 1

        HBox resident1 = new HBox(5);
        resident1.setPrefWidth(1100);
        resident1.setAlignment(Pos.CENTER_LEFT);
        resident1.setPrefHeight(90);
        resident1.setPadding(new Insets(20));
        resident1.setStyle("-fx-background-color:white;-fx-background-radius:10;");


        Label name1 = new Label("Aditi Hegade");
        name1.setPrefWidth(300);
        name1.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label details1 = new Label("A - 402     |   8625043207");
        details1.setPrefWidth(550);
        Label status1 = new Label("Active");
        status1.setPrefWidth(120);
        status1.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident1.getChildren().addAll(name1,details1,status1);

        //Resident 2


        HBox resident2 = new HBox(5);
         resident2.setAlignment(Pos.CENTER_LEFT);
        resident2.setPrefWidth(1100);
        resident2.setPrefHeight(90);
        resident2.setPadding(new Insets(20));
        resident2.setStyle("-fx-background-color:white;-fx-background-radius:10;");


        Label name2 = new Label("Shrutika");
        name2.setPrefWidth(300);
        name2.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label details2 = new Label("A - 101    |   9322743434");
        details2.setPrefWidth(550);
        Label status2 = new Label("Active");
        status2.setPrefWidth(120);
        status2.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident2.getChildren().addAll(name2,details2,status2);

        //Resident 3

        HBox resident3 = new HBox(5);
         resident3.setAlignment(Pos.CENTER_LEFT);
        resident3.setPrefWidth(1100);
        resident3.setPrefHeight(90);
        resident3.setPadding(new Insets(20));
        resident3.setStyle("-fx-background-color:white;-fx-background-radius:10;");


        Label name3 = new Label("Samarth Hegade");
         name3.setPrefWidth(300);
        name3.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label details3 = new Label("A - 125    |   9970022199");
        details3.setPrefWidth(550);
        Label status3 = new Label("Active");
        status3.setPrefWidth(120);
        status3.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident3.getChildren().addAll(name3,details3,status3);

         //Resident 4

        HBox resident4 = new HBox(5);
         resident4.setAlignment(Pos.CENTER_LEFT);
        resident4.setPrefWidth(1100);
        resident4.setPrefHeight(90);
        resident4.setPadding(new Insets(20));
        resident4.setStyle("-fx-background-color:white;-fx-background-radius:10;");


        Label name4 = new Label("Vaishnavi kapase");
        name4.setPrefWidth(300);
        name4.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label details4 = new Label("A - 18    |   9284905453");
        details4.setPrefWidth(550);
        Label status4 = new Label("Inactive");
        status4.setPrefWidth(120);
        status4.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident4.getChildren().addAll(name4,details4,status4);


         //Resident 5

        HBox resident5 = new HBox(5);
        resident5.setAlignment(Pos.CENTER_LEFT);
        resident5.setPrefWidth(1100);
        resident5.setPrefHeight(90);
        resident5.setPadding(new Insets(20));
        resident5.setStyle("-fx-background-color:white;-fx-background-radius:10;");


        Label name5 = new Label("xyz");
         name5.setPrefWidth(300);
        name5.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label details5 = new Label("A - 125    |   9970282199");
        details5.setPrefWidth(550);
        Label status5 = new Label("Active");
        status5.setPrefWidth(120);
        status5.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident5.getChildren().addAll(name5,details5,status5);

        VBox vb = new VBox(30,resident1,resident2,resident3,resident4,resident5);

        mainvb.getChildren().addAll(title,
                                     subtitle,
                                     searchBox,
                                     vb
        );

        HBox root = new HBox();
        root.getChildren().addAll(sidebar,mainvb);
        
        Scene scene = new Scene(root,1500,750);
        return scene;
    }
} 