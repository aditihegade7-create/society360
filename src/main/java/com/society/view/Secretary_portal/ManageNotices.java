package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageNotices {

    private Scene manageNoticesScene;
    public Scene createScene(Stage stage) {
        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);
        

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);
        mainvb.setStyle("-fx-background-color:#b3adad");


        Label heading = new Label("MANAGE NOTICES");
        heading.setStyle("-fx-font-size:18px;-fx-font-weight:bold;-fx-text-fill:#434141;");


        Label title = new Label("Manage Notices");
        title.setStyle("-fx-font-size:20px;-fx-font-weight:bold;-fx-text-fill:black");

        Label subtitle = new Label("Create, edit and manage society notices");
        subtitle.setStyle("-fx-font-size:13px;-fx-text-fill:#777777;");

        Button addNoticeBtn = new Button("+ Add Notice");
        addNoticeBtn.setPrefWidth(120);
        addNoticeBtn.setPrefHeight(38);
        addNoticeBtn.setStyle("-fx-background-color:#434141;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:7;");


        VBox headingBox = new VBox(5);
        headingBox.getChildren().addAll(
                title,
                subtitle
        );

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(headingBox,Priority.ALWAYS);
        header.getChildren().addAll(
                headingBox,
                addNoticeBtn
        );


        VBox notice1 = new VBox(8);
        notice1.setPadding(new Insets(20));
        notice1.setPrefHeight(95);
        notice1.setStyle("-fx-background-color:white;-fx-background-radius:8;-fx-border-color:#EEEEEE;-fx-border-radius:8;");


        Label notice1Title = new Label("▣  Water Supply Maintenance");
        notice1Title.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#123C36;");
        Label notice1Text = new Label(
                "The water supply will be unavailable on " +
                "12 May 2025 from 10:00 PM to 6:00 AM."
        );
        notice1Text.setStyle("-fx-font-size:11px;-fx-text-fill:#777777;");


        Label notice1Date = new Label("10 May 2025");
        notice1Date.setStyle("-fx-font-size:10px;-fx-text-fill:#777777;");


        Label published1 = new Label("Published");
        published1.setStyle("-fx-background-color:#434141;-fx-text-fill:white;-fx-font-size:10px;-fx-font-weight:bold;-fx-padding:5px 9px;-fx-background-radius:12;");


        HBox notice1Bottom = new HBox(10);
        notice1Bottom.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(notice1Date,Priority.ALWAYS);
        notice1Bottom.getChildren().addAll(
                notice1Date,
                published1
        );

        notice1.getChildren().addAll(
                notice1Title,
                notice1Text,
                notice1Bottom
        );
        VBox notice2 = new VBox(8);
        notice2.setPadding(new Insets(20));
        notice2.setPrefHeight(95);
        notice2.setStyle("-fx-background-color:white;-fx-background-radius:8;-fx-border-color:#EEEEEE;-fx-border-radius:8;");


        Label notice2Title = new Label("▣  Society Meeting");
        notice2Title.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#123C36;");
        Label notice2Text = new Label(
                "All residents are requested to attend the " +
                "monthly meeting on 12 May 2025."
        );
        notice2Text.setStyle("-fx-font-size:11px;-fx-text-fill:#777777;");
        Label notice2Date = new Label("08 May 2025");             
        notice2Date.setStyle("-fx-font-size:10px;-fx-text-fill:#777777;");


        Label published2 = new Label("Published");             
        published2.setStyle(
                "-fx-background-color:#434141;-fx-text-fill:white;-fx-font-size:10px;-fx-font-weight:bold;-fx-padding:5px 9px;-fx-background-radius:12;");


        HBox notice2Bottom = new HBox(10);
        notice2Bottom.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(notice2Date,Priority.ALWAYS);
        notice2Bottom.getChildren().addAll(
                notice2Date,
                published2
        );

        notice2.getChildren().addAll(
                notice2Title,
                notice2Text,
                notice2Bottom
        );


        VBox notice3 = new VBox(8);
        notice3.setPadding(new Insets(20));
        notice3.setPrefHeight(95);
        notice3.setStyle("-fx-background-color:white;-fx-background-radius:8;-fx-border-color:#EEEEEE;-fx-border-radius:8;");


        Label notice3Title = new Label("▣  Parking Rule Update");
        notice3Title.setStyle("-fx-font-size:14px;-fx-font-weight:bold;-fx-text-fill:#123C36;");
        Label notice3Text = new Label(
                "New parking rules are effective from " +
                "15 May 2025."
        );

        notice3Text.setStyle("-fx-font-size:11px;-fx-text-fill:#777777;");
        Label notice3Date =  new Label("05 May 2025");
        notice3Date.setStyle("-fx-font-size:10px;-fx-text-fill:#777777;");


        Label draft =  new Label("Draft");
        draft.setStyle("-fx-background-color:#434141;-fx-text-fill:white;-fx-font-size:10px;-fx-font-weight:bold;-fx-padding:5px 9px;-fx-background-radius:12;");


        HBox notice3Bottom = new HBox(10);
        notice3Bottom.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(notice3Date,Priority.ALWAYS);
        notice3Bottom.getChildren().addAll(
                notice3Date,
                draft
        );

        notice3.getChildren().addAll(
                notice3Title,
                notice3Text,
                notice3Bottom
        );

        Button viewAllBtn =  new Button("View All Notices");
        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);
        viewAllBtn.setStyle("-fx-background-color:#434141;;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:7;-fx-border-color:#EEEEEE;-fx-border-radius:7;");

        mainvb.getChildren().addAll(
                heading,
                header,
                notice1,
                notice2,
                notice3,
                viewAllBtn
        );

        HBox root = new HBox(10);
        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox rootBox = new HBox();
        rootBox.getChildren().addAll(sidebar,mainvb);
        
        // Scene scene = new Scene(rootBox,1500,750);
         Scene scene = new Scene(
                rootBox,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        manageNoticesScene = scene;
        return manageNoticesScene;
    }
    
}
