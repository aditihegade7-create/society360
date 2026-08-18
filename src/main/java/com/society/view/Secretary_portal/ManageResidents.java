package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

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

    private Scene Resident;

    public Scene createScene(Stage stage) {

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        VBox mainvb = new VBox(10);
        mainvb.setPrefWidth(1220);
        mainvb.setPrefHeight(750);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);
        mainvb.setStyle("-fx-background-color:#b3adad;");

        // Title
        Label title = new Label("Manage Residents");
        title.setStyle("-fx-font-size:28px;-fx-font-weight:bold;-fx-text-fill:black");

        Label subtitle = new Label("View and manage all residents");
        subtitle.setStyle("-fx-font-size:14px;-fx-text-fill:#777777;");

        // search+add - Button

        TextField search = new TextField();
        search.setPromptText("Search resident, flat no., phone...");
        search.setPrefHeight(45);
        search.setPrefWidth(750);
        search.setStyle(
                "-fx-background-color:#F8F9FA;-fx-border-color:#E1E5E8;-fx-border-radius:8;-fx-background-radius:8;-fx-font-size:14px;");

        Button addResidentBtn = new Button("+ Add New Resident");
        addResidentBtn.setPrefWidth(200);
        addResidentBtn.setPrefHeight(45);
        addResidentBtn.setStyle(
                "-fx-background-color:#434141;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:8");

        HBox searchBox = new HBox(15);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.getChildren().addAll(search, addResidentBtn);

        // Resident 1

        HBox resident1 = new HBox(5);
        resident1.setPrefWidth(1000);
        resident1.setMaxWidth(1000);
        resident1.setAlignment(Pos.CENTER_LEFT);
        resident1.setPrefHeight(70);
        resident1.setPadding(new Insets(20));
        resident1.setStyle("-fx-background-color:white;-fx-background-radius:10;");

        Label profile1 = new Label("👤");
        profile1.setPrefWidth(50);
        profile1.setPrefHeight(50);
        profile1.setAlignment(Pos.CENTER);
        profile1.setStyle("-fx-background-color:#E5E7EB;-fx-background-radius:50%;-fx-font-size:22px");

        Label name1 = new Label("Shravani");
        name1.setPrefWidth(220);
        name1.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label flat1 = new Label("Flat: B-402");
        flat1.setPrefWidth(150);
        flat1.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#555555;");
        Label mobile1 = new Label("Mobile: 9876543210");
        mobile1.setPrefWidth(220);
        mobile1.setStyle("-fx-font-size:14px;-fx-text-fill:#555555;");
        Label status1 = new Label("Active");
        status1.setPrefWidth(100);
        status1.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident1.getChildren().addAll(profile1, name1, flat1, mobile1, status1);

        // Resident 2

        HBox resident2 = new HBox(5);
        resident2.setAlignment(Pos.CENTER_LEFT);
        resident2.setPrefWidth(1000);
        resident2.setMaxWidth(1000);
        resident2.setPrefHeight(70);
        resident2.setPadding(new Insets(20));
        resident2.setStyle("-fx-background-color:white;-fx-background-radius:10;");

        Label profile2 = new Label("👤");
        profile2.setPrefWidth(50);
        profile2.setPrefHeight(50);
        profile2.setAlignment(Pos.CENTER);
        profile2.setStyle("-fx-background-color:#E5E7EB;-fx-background-radius:50%;-fx-font-size:22px");
        Label name2 = new Label("Sudharshana");
        name2.setPrefWidth(200);
        name2.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label flat2 = new Label("Flat: B-402");
        flat2.setPrefWidth(150);
        flat2.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#555555;");
        Label mobile2 = new Label("Mobile: 9876543210");
        mobile2.setPrefWidth(220);
        mobile2.setStyle("-fx-font-size:14px;-fx-text-fill:#555555;");
        Label status2 = new Label("Active");
        status2.setPrefWidth(100);
        status2.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident2.getChildren().addAll(profile2, name2, flat2, mobile2, status2);

        // Resident 3

        HBox resident3 = new HBox(5);
        resident3.setAlignment(Pos.CENTER_LEFT);
        resident3.setMaxWidth(1000);
        resident3.setPrefWidth(1000);
        resident3.setPrefHeight(70);
        resident3.setPadding(new Insets(20));
        resident3.setStyle("-fx-background-color:white;-fx-background-radius:10;");

        Label profile3 = new Label("👤");
        profile3.setPrefWidth(50);
        profile3.setPrefHeight(50);
        profile3.setAlignment(Pos.CENTER);
        profile3.setStyle("-fx-background-color:#E5E7EB;-fx-background-radius:50%;-fx-font-size:22px");
        Label name3 = new Label("Jiya");
        name3.setPrefWidth(200);
        name3.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label flat3 = new Label("Flat: B-402");
        flat3.setPrefWidth(150);
        flat3.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#555555;");
        Label mobile3 = new Label("Mobile: 9876543210");
        mobile3.setPrefWidth(220);
        mobile3.setStyle("-fx-font-size:14px;-fx-text-fill:#555555;");
        Label status3 = new Label("Active");
        status3.setPrefWidth(100);
        status3.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident3.getChildren().addAll(profile3, name3, flat3, mobile3, status3);

        // Resident 4

        HBox resident4 = new HBox(5);
        resident4.setAlignment(Pos.CENTER_LEFT);
        resident4.setPrefWidth(1000);
        resident4.setMaxWidth(1000);
        resident4.setPrefHeight(70);
        resident4.setPadding(new Insets(20));
        resident4.setStyle("-fx-background-color:white;-fx-background-radius:10;");

        Label profile4 = new Label("👤");
        profile4.setPrefWidth(50);
        profile4.setPrefHeight(50);
        profile4.setAlignment(Pos.CENTER);
        profile4.setStyle("-fx-background-color:#E5E7EB;-fx-background-radius:50%;-fx-font-size:22px");
        Label name4 = new Label("Manasi");
        name4.setPrefWidth(200);
        name4.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label flat4 = new Label("Flat: B-402");
        flat4.setPrefWidth(150);
        flat4.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#555555;");
        Label mobile4 = new Label("Mobile: 9876543210");
        mobile4.setPrefWidth(220);
        mobile4.setStyle("-fx-font-size:14px;-fx-text-fill:#555555;");
        Label status4 = new Label("Inactive");
        status4.setPrefWidth(100);
        status4.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident4.getChildren().addAll(profile4, name4, flat4, mobile4, status4);

        // Resident 5

        HBox resident5 = new HBox(5);
        resident5.setAlignment(Pos.CENTER_LEFT);
        resident5.setMaxWidth(1000);
        resident5.setPrefWidth(1000);
        resident5.setPrefHeight(70);
        resident5.setPadding(new Insets(20));
        resident5.setStyle("-fx-background-color:white;-fx-background-radius:10;");

        Label profile5 = new Label("👤");
        profile5.setPrefWidth(50);
        profile5.setPrefHeight(50);
        profile5.setAlignment(Pos.CENTER);
        profile5.setStyle("-fx-background-color:#E5E7EB;-fx-background-radius:50%;-fx-font-size:22px");
        Label name5 = new Label("Dhanashree");
        name5.setPrefWidth(200);
        name5.setStyle("-fx-font-size:16px;-fx-font-weight:bold;-fx-text-fill:#123C36");
        Label flat5 = new Label("Flat: B-402");
        flat5.setPrefWidth(150);
        flat5.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#555555;");
        Label mobile5 = new Label("Mobile: 9876543210");
        mobile5.setPrefWidth(220);
        mobile5.setStyle("-fx-font-size:14px;-fx-text-fill:#555555;");
        Label status5 = new Label("Active");
        status5.setPrefWidth(100);
        status5.setStyle("-fx-text-fill:#2E9D63;-fx-font-weight:bold;");

        resident5.getChildren().addAll(profile5, name5, flat5, mobile5, status5);

        VBox vb = new VBox(30, resident1, resident2, resident3, resident4, resident5);
        VBox.setMargin(resident1, new Insets(20, 0, 0, 0));

        mainvb.getChildren().addAll(title,
                subtitle,
                searchBox,
                vb);

        HBox root = new HBox();
        root.getChildren().addAll(sidebar, mainvb);

        // Scene scene = new Scene(root,1500,750);
        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        Resident = scene;
        return Resident;
    }
}