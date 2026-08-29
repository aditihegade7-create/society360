package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageResidents {

    private Scene Resident;

    public Scene createScene(Stage stage) {

        
        BorderPane root = new BorderPane();
        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);
        root.setLeft(sidebar);

       
        BorderPane mainarea = new BorderPane();
        HBox header = new HBox();

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

        
        VBox headerText = new VBox(4);

        Label greeting = new Label(
                "Manage Residents"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );

        Label description = new Label(
                "View and manage all residents"
        );

        description.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#ffffff;"
        );

        headerText.getChildren().addAll(
                greeting,
                description
        );

       

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        
        Label day = new Label();

        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(
                today.format(
                        DateTimeFormatter.ofPattern("EEEE")
                )
        );

        date.setText(
                today.format(
                        DateTimeFormatter.ofPattern("dd MMMM yyyy")
                )
        );

        day.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        date.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        VBox dateBox = new VBox(4);

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

        
        VBox mainContent = new VBox(15);

        mainContent.setPadding(
                new Insets(25, 30, 25, 30)
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );

        
       
        TextField search = new TextField();

        search.setPromptText(
                "Search resident, flat no., phone..."
        );

        search.setPrefHeight(45);

        search.setPrefWidth(750);

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        Button addResidentBtn = new Button(
                "+ Add New Resident"
        );

        addResidentBtn.setPrefWidth(200);

        addResidentBtn.setPrefHeight(45);

        addResidentBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        HBox searchBox = new HBox(15);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.getChildren().addAll(
                search,
                addResidentBtn
        );

        HBox resident1 = new HBox(5);

        resident1.setPrefWidth(1000);
        resident1.setMaxWidth(1000);
        resident1.setPrefHeight(70);

        resident1.setAlignment(
                Pos.CENTER_LEFT
        );

        resident1.setPadding(
                new Insets(20)
        );

        resident1.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile1 = new Label("👤");

        profile1.setPrefWidth(50);
        profile1.setPrefHeight(50);

        profile1.setAlignment(
                Pos.CENTER
        );

        profile1.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name1 = new Label("Shravani");

        name1.setPrefWidth(220);

        name1.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat1 = new Label("Flat: B-402");

        flat1.setPrefWidth(150);

        flat1.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile1 = new Label(
                "Mobile: 9876543210"
        );

        mobile1.setPrefWidth(220);

        mobile1.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status1 = new Label("Active");

        status1.setPrefWidth(100);

        status1.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident1.getChildren().addAll(
                profile1,
                name1,
                flat1,
                mobile1,
                status1
        );


        HBox resident2 = new HBox(5);

        resident2.setPrefWidth(1000);
        resident2.setMaxWidth(1000);
        resident2.setPrefHeight(70);

        resident2.setAlignment(
                Pos.CENTER_LEFT
        );

        resident2.setPadding(
                new Insets(20)
        );

        resident2.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile2 = new Label("👤");

        profile2.setPrefWidth(50);
        profile2.setPrefHeight(50);

        profile2.setAlignment(
                Pos.CENTER
        );

        profile2.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name2 = new Label("Sudharshana");

        name2.setPrefWidth(200);

        name2.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat2 = new Label("Flat: B-402");

        flat2.setPrefWidth(150);

        flat2.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile2 = new Label(
                "Mobile: 9876543210"
        );

        mobile2.setPrefWidth(220);

        mobile2.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status2 = new Label("Active");

        status2.setPrefWidth(100);

        status2.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident2.getChildren().addAll(
                profile2,
                name2,
                flat2,
                mobile2,
                status2
        );

       

        HBox resident3 = new HBox(5);

        resident3.setPrefWidth(1000);
        resident3.setMaxWidth(1000);
        resident3.setPrefHeight(70);

        resident3.setAlignment(
                Pos.CENTER_LEFT
        );

        resident3.setPadding(
                new Insets(20)
        );

        resident3.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile3 = new Label("👤");

        profile3.setPrefWidth(50);
        profile3.setPrefHeight(50);

        profile3.setAlignment(
                Pos.CENTER
        );

        profile3.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name3 = new Label("Jiya");

        name3.setPrefWidth(200);

        name3.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat3 = new Label("Flat: B-402");

        flat3.setPrefWidth(150);

        flat3.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile3 = new Label(
                "Mobile: 9876543210"
        );

        mobile3.setPrefWidth(220);

        mobile3.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status3 = new Label("Active");

        status3.setPrefWidth(100);

        status3.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident3.getChildren().addAll(
                profile3,
                name3,
                flat3,
                mobile3,
                status3
        );

        

        HBox resident4 = new HBox(5);

        resident4.setPrefWidth(1000);
        resident4.setMaxWidth(1000);
        resident4.setPrefHeight(70);

        resident4.setAlignment(
                Pos.CENTER_LEFT
        );

        resident4.setPadding(
                new Insets(20)
        );

        resident4.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile4 = new Label("👤");

        profile4.setPrefWidth(50);
        profile4.setPrefHeight(50);

        profile4.setAlignment(
                Pos.CENTER
        );

        profile4.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name4 = new Label("Manasi");

        name4.setPrefWidth(200);

        name4.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat4 = new Label("Flat: B-402");

        flat4.setPrefWidth(150);

        flat4.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile4 = new Label(
                "Mobile: 9876543210"
        );

        mobile4.setPrefWidth(220);

        mobile4.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status4 = new Label("Inactive");

        status4.setPrefWidth(100);

        status4.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident4.getChildren().addAll(
                profile4,
                name4,
                flat4,
                mobile4,
                status4
        );

       

        HBox resident5 = new HBox(5);

        resident5.setPrefWidth(1000);
        resident5.setMaxWidth(1000);
        resident5.setPrefHeight(70);

        resident5.setAlignment(
                Pos.CENTER_LEFT
        );

        resident5.setPadding(
                new Insets(20)
        );

        resident5.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile5 = new Label("👤");

        profile5.setPrefWidth(50);
        profile5.setPrefHeight(50);

        profile5.setAlignment(
                Pos.CENTER
        );

        profile5.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name5 = new Label("Dhanashree");

        name5.setPrefWidth(200);

        name5.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat5 = new Label("Flat: B-402");

        flat5.setPrefWidth(150);

        flat5.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile5 = new Label(
                "Mobile: 9876543210"
        );

        mobile5.setPrefWidth(220);

        mobile5.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status5 = new Label("Active");

        status5.setPrefWidth(100);

        status5.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident5.getChildren().addAll(
                profile5,
                name5,
                flat5,
                mobile5,
                status5
        );

        
        VBox residentList = new VBox(20);

        residentList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        residentList.getChildren().addAll(
                resident1,
                resident2,
                resident3,
                resident4,
                resident5
        );

        

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                residentList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        

        Button viewAllBtn = new Button(
                "View All Residents"
        );

        viewAllBtn.setPrefWidth(1180);

        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );

        
        mainContent.getChildren().addAll(
                
                searchBox,
                scrollPane,
                viewAllBtn
        );
        mainarea.setTop(header);

        mainarea.setCenter(mainContent);

        root.setCenter(mainarea);

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        Resident = scene;

        return Resident;
    }
}