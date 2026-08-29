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

public class ManageOwner {

    private Scene manageOwnerScene;

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

        header.setPadding(new Insets(20));

        header.setAlignment(Pos.CENTER_LEFT);

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );

        VBox headerText = new VBox(4);

        Label greeting = new Label(
                "Manage Owners"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label description = new Label(
                "View and manage all flat owners"
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

        VBox mainContent = new VBox(10);

        mainContent.setPadding(
                new Insets(20)
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
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
                "+ Add New Owner"
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


        HBox resident1 = createOwner(
                "Vijay",
                "B-402",
                "9876543210",
                "Active"
        );

        HBox resident2 = createOwner(
                "Sachin",
                "B-102",
                "9876543211",
                "Active"
        );

        HBox resident3 = createOwner(
                "Pramod",
                "C-203",
                "9876543212",
                "Active"
        );

        HBox resident4 = createOwner(
                "Ram",
                "A-105",
                "9876543213",
                "Inactive"
        );



        HBox resident5 = createOwner(
                "Sneha Patil",
                "A-204",
                "9876543214",
                "Active"
        );


        

        HBox resident6 = createOwner(
                "Rahul Sharma",
                "C-301",
                "9876543215",
                "Active"
        );


        
        HBox resident7 = createOwner(
                "Pooja Singh",
                "B-201",
                "9876543216",
                "Inactive"
        );


        
        VBox ownerList = new VBox(15);

        ownerList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        ownerList.getChildren().addAll(
                resident1,
                resident2,
                resident3,
                resident4,
                resident5,
                resident6,
                resident7
        );


       
        

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                ownerList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        
        Button viewAllBtn = new Button(
                "View All Owners"
        );

        viewAllBtn.setPrefWidth(1180);

        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color: #4e342e;" +
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

        manageOwnerScene = scene;

        return manageOwnerScene;
    }

    private HBox createOwner(
            String ownerName,
            String flatNo,
            String mobile,
            String statusText) {


        HBox owner = new HBox(5);

        owner.setPrefWidth(1000);

        owner.setMaxWidth(1180);

        owner.setPrefHeight(70);

        owner.setAlignment(
                Pos.CENTER_LEFT
        );

        owner.setPadding(
                new Insets(20)
        );

        owner.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


        
        Label profile = new Label(
                "👤"
        );

        profile.setPrefWidth(50);

        profile.setPrefHeight(50);

        profile.setAlignment(
                Pos.CENTER
        );

        profile.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );


       
        Label name = new Label(
                ownerName
        );

        name.setPrefWidth(220);

        name.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


       
        Label flat = new Label(
                "Flat: " + flatNo
        );

        flat.setPrefWidth(150);

        flat.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );


        
        Label mobileLabel = new Label(
                "Mobile: " + mobile
        );

        mobileLabel.setPrefWidth(220);

        mobileLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );


       
        Label status = new Label(
                statusText
        );

        status.setPrefWidth(100);

        status.setAlignment(
                Pos.CENTER
        );


        if (statusText.equals("Active")) {

            status.setStyle(
                    "-fx-background-color:#E5F7EC;" +
                    "-fx-text-fill:#2E9D63;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );

        } else {

            status.setStyle(
                    "-fx-background-color:#FDE8E8;" +
                    "-fx-text-fill:#D9534F;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );
        }


        
        owner.getChildren().addAll(
                profile,
                name,
                flat,
                mobileLabel,
                status
        );


        return owner;
    }
}