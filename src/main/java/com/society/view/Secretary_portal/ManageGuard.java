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

public class ManageGuard {

    private Scene manageGuardScene;
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
                "Manage Guards"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label description = new Label(
                "View and manage security guards"
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


        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(25, 30, 25, 30)
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );


        Label sectionTitle = new Label(
                "SECURITY GUARDS"
        );

        sectionTitle.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        Button addGuardBtn = new Button(
                "+ Add Guard"
        );

        addGuardBtn.setPrefWidth(130);

        addGuardBtn.setPrefHeight(40);

        addGuardBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );



        Region guardSpacer = new Region();

        HBox.setHgrow(
                guardSpacer,
                Priority.ALWAYS
        );


        HBox guardHeader = new HBox();

        guardHeader.setAlignment(
                Pos.CENTER_LEFT
        );


        guardHeader.getChildren().addAll(
                sectionTitle,
                guardSpacer,
                addGuardBtn
        );


        TextField searchField = new TextField();

        searchField.setPromptText(
                "Search guard name, mobile number..."
        );

        searchField.setPrefHeight(40);

        searchField.setPrefWidth(1180);

        searchField.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:13px;"
        );

        VBox guardList = new VBox(15);

        guardList.setPadding(
                new Insets(5, 0, 5, 0)
        );
        VBox guard1 = createGuard(
                "Rajesh Kumar",
                "9876543210",
                "Morning Shift",
                "Active"
        );

        VBox guard2 = createGuard(
                "Sunil Yadav",
                "9876543211",
                "Night Shift",
                "Active"
        );


        VBox guard3 = createGuard(
                "Mahesh Jagtap",
                "9876543212",
                "Morning Shift",
                "Active"
        );


        VBox guard4 = createGuard(
                "Ramesh More",
                "9876543213",
                "Evening Shift",
                "Inactive"
        );


        VBox guard5 = createGuard(
                "Vijay Patil",
                "9876543214",
                "Night Shift",
                "Active"
        );

        VBox guard6 = createGuard(
                "Suresh Shinde",
                "9876543215",
                "Evening Shift",
                "Active"
        );

        guardList.getChildren().addAll(
                guard1,
                guard2,
                guard3,
                guard4,
                guard5,
                guard6
        );

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                guardList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        Button viewAllBtn = new Button(
                "View All Guards"
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

        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    String searchText =
                            newValue.toLowerCase().trim();

                    guardList.getChildren().clear();

                    if (searchText.isEmpty()) {

                        guardList.getChildren().addAll(
                                guard1,
                                guard2,
                                guard3,
                                guard4,
                                guard5,
                                guard6
                        );

                    } else {

                        if (containsGuard(
                                "Rajesh Kumar",
                                "9876543210",
                                searchText)) {

                            guardList.getChildren().add(guard1);
                        }


                        if (containsGuard(
                                "Sunil Yadav",
                                "9876543211",
                                searchText)) {

                            guardList.getChildren().add(guard2);
                        }


                        if (containsGuard(
                                "Mahesh Jagtap",
                                "9876543212",
                                searchText)) {

                            guardList.getChildren().add(guard3);
                        }


                        if (containsGuard(
                                "Ramesh More",
                                "9876543213",
                                searchText)) {

                            guardList.getChildren().add(guard4);
                        }


                        if (containsGuard(
                                "Vijay Patil",
                                "9876543214",
                                searchText)) {

                            guardList.getChildren().add(guard5);
                        }


                        if (containsGuard(
                                "Suresh Shinde",
                                "9876543215",
                                searchText)) {

                            guardList.getChildren().add(guard6);
                        }
                    }
                }
        );


        
        mainContent.getChildren().addAll(
                guardHeader,
                searchField,
                scrollPane,
                viewAllBtn
        );


        
        mainarea.setTop(header);

        mainarea.setCenter(mainContent);


        root.setCenter(
                mainarea
        );


        
        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );


        manageGuardScene = scene;

        return manageGuardScene;
    }


    
    private VBox createGuard(
            String guardName,
            String mobile,
            String shift,
            String statusText) {


        VBox guard = new VBox(10);


        guard.setPadding(
                new Insets(18)
        );


        guard.setPrefHeight(90);


        guard.setMaxWidth(1180);


        guard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


       
        Label name = new Label(
                guardName
        );


        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        
        Label details = new Label(
                "Mobile: " + mobile +
                "    |    " +
                "Shift: " + shift
        );


        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        
        Label status = new Label(
                statusText
        );


        if (statusText.equals("Active")) {

            status.setStyle(
                    "-fx-background-color:#E5F7EC;" +
                    "-fx-text-fill:#2E9D63;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );

        } else {

            status.setStyle(
                    "-fx-background-color:#EAF0F6;" +
                    "-fx-text-fill:#55708A;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );
        }


        
        HBox bottom = new HBox();


        bottom.setAlignment(
                Pos.CENTER_LEFT
        );


        HBox.setHgrow(
                details,
                Priority.ALWAYS
        );


        bottom.getChildren().addAll(
                details,
                status
        );


        guard.getChildren().addAll(
                name,
                bottom
        );


        return guard;
    }


   
    private boolean containsGuard(
            String name,
            String mobile,
            String searchText) {


        return name.toLowerCase().contains(searchText)
                || mobile.contains(searchText);
    }
}