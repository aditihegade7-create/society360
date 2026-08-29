package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Logout {

    // Private Scene variable
    private Scene logoutScene;

    public Scene createScene(Stage stage) {

        // SIDEBAR

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);
        mainvb.setAlignment(Pos.TOP_CENTER);
        mainvb.setStyle("-fx-background-color:#e8ddd5;");

        // HEADING

        Label heading =
                new Label("LOGOUT");
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        // LOGOUT CARD

        VBox logoutCard =
                new VBox(15);

        logoutCard.setAlignment(
                Pos.CENTER
        );
        logoutCard.setPadding(
                new Insets(35)
        );
        logoutCard.setPrefWidth(500);
        logoutCard.setPrefHeight(260);
        logoutCard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:12;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:12;"
        );

        // TITLE

        Label title =
                new Label("Logout");
        title.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // MESSAGE

        Label message =
                new Label(
                        "Are you sure you want to logout?"
                );

        message.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        // BUTTONS

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(120);
        cancelBtn.setPrefHeight(40);
        cancelBtn.setStyle(
                "-fx-background-color:white;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-radius:7;" +
                "-fx-background-radius:7;"
        );


        Button logoutBtn =
                new Button("Logout");
        logoutBtn.setPrefWidth(120);
        logoutBtn.setPrefHeight(40);
        logoutBtn.setStyle(
                "-fx-background-color:#D9534F;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        HBox buttons =
                new HBox(15);
        buttons.setAlignment(
                Pos.CENTER
        );
        buttons.getChildren().addAll(
                cancelBtn,
                logoutBtn
        );


        // CANCEL ACTION

        cancelBtn.setOnAction(e -> {
            SecretaryDashboard dashboard =
                    new SecretaryDashboard();

            stage.setScene(
                    dashboard.createScene(stage)
            );
        });


        // LOGOUT ACTION

        logoutBtn.setOnAction(e -> {

            Label loggedOut =
                    new Label("You have been logged out.");

            loggedOut.setStyle(
                    "-fx-font-size:14px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#2E9D63;"
            );

            logoutCard.getChildren().clear();

            logoutCard.getChildren().add(
                    loggedOut
            );
        });

        // ADD TO CARD

        logoutCard.getChildren().addAll(
                title,
                message,
                buttons
        );


        // ADD EVERYTHING TO MAIN

        mainvb.getChildren().addAll(
                heading,
                logoutCard
        );


        // ROOT

        HBox root = new HBox();
                
        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        // SCENE

        // logoutScene = new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        logoutScene = scene;
        return logoutScene;
    }
}