package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageNotices {

    

    private Scene manageNoticesScene;
    public Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
        SecretarySidebar sidebarObj = new SecretarySidebar();

        VBox sidebar = sidebarObj.createSidebar(stage);
        root.setLeft(sidebar);
        BorderPane mainarea = new BorderPane();


        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);

        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setPadding(new Insets(20));
        header.setAlignment( Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color:#4e342e;"
        );

        VBox headerText = new VBox(4);
        Label greeting = new Label("Manage Notices"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );

        Label description = new Label(
                "Create, edit and manage society notices"
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

        Label date = new Label(
                "Society Notice Portal"
        );

        date.setStyle(
                "-fx-text-fill:#ffffff;"
        );


        VBox dateBox = new VBox();

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        dateBox.getChildren().add(
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


        
        Button publishedBtn = new Button(
                "Published (2)"
        );

        Button draftBtn = new Button(
                "Draft (1)"
        );


        publishedBtn.setPrefWidth(150);
        publishedBtn.setPrefHeight(40);

        draftBtn.setPrefWidth(150);
        draftBtn.setPrefHeight(40);

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#777777;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;";


        String activeStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-width:0 0 2 0;";


        publishedBtn.setStyle(
                activeStyle
        );

        draftBtn.setStyle(
                normalStyle
        );

        HBox tabs = new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                publishedBtn,
                draftBtn
        );

        VBox noticeList = new VBox(15);

        noticeList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        VBox publishedNotice1 = createNotice(
                "Water Supply Maintenance",
                "The water supply will be unavailable on 12 May 2025 from 10:00 PM to 6:00 AM.",
                "10 May 2025",
                "Published",
                "#E5F7EC",
                "#2E9D63"
        );


        VBox publishedNotice2 = createNotice(
                "Society Meeting",
                "All residents are requested to attend the monthly meeting on 12 May 2025.",
                "08 May 2025",
                "Published",
                "#E5F7EC",
                "#2E9D63"
        );


       

        VBox draftNotice1 = createNotice(
                "Parking Rule Update",
                "New parking rules are effective from 15 May 2025.",
                "05 May 2025",
                "Draft",
                "#FFF0D9",
                "#C47A20"
        );


       
        noticeList.getChildren().addAll(
                publishedNotice1,
                publishedNotice2
        );


        
        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                noticeList
        );

        scrollPane.setFitToWidth(
                true
        );

        scrollPane.setPrefHeight(
                450
        );

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        
        publishedBtn.setOnAction(e -> {

            noticeList.getChildren().clear();

            noticeList.getChildren().addAll(
                    publishedNotice1,
                    publishedNotice2
            );

            publishedBtn.setStyle(
                    activeStyle
            );

            draftBtn.setStyle(
                    normalStyle
            );
        });

        draftBtn.setOnAction(e -> {

            noticeList.getChildren().clear();

            noticeList.getChildren().add(
                    draftNotice1
            );

            publishedBtn.setStyle(
                    normalStyle
            );

            draftBtn.setStyle(
                    activeStyle
            );
        });



        Button viewAllBtn = new Button(
                "View All Notices"
        );

        viewAllBtn.setPrefWidth(
                1180
        );

        viewAllBtn.setPrefHeight(
                40
        );

        viewAllBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );


        

        mainContent.getChildren().addAll(
                tabs,
                scrollPane,
                viewAllBtn
        );


        
        mainarea.setTop(
                header
        );

        mainarea.setCenter(
                mainContent
        );


        root.setCenter(
                mainarea
        );


        
        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageNoticesScene = scene;

        return manageNoticesScene;
    }


    
    private VBox createNotice(
            String noticeTitle,
            String noticeText,
            String noticeDate,
            String statusText,
            String statusBackground,
            String statusColor) {


       
        VBox notice = new VBox(10);

        notice.setPadding(
                new Insets(18)
        );

        notice.setPrefHeight(
                100
        );

        notice.setMaxWidth(
                1180
        );

        notice.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );


       
        Label title = new Label(
                "▣  " + noticeTitle
        );

        title.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        
        Label text = new Label(
                noticeText
        );

        text.setWrapText(
                true
        );

        text.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        
        Label date = new Label(
                noticeDate
        );

        date.setStyle(
                "-fx-font-size:10px;" +
                "-fx-text-fill:#777777;"
        );


        

        Label status = new Label(
                statusText
        );

        status.setStyle(
                "-fx-background-color:" +
                statusBackground + ";" +
                "-fx-text-fill:" +
                statusColor + ";" +
                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 10px;" +
                "-fx-background-radius:12;"
        );


       
        HBox bottom = new HBox();

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                date,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                date,
                status
        );


        
        notice.getChildren().addAll(
                title,
                text,
                bottom
        );


        return notice;
    }
}