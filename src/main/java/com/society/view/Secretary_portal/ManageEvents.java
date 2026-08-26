package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageEvents {

    // Private Scene variable
    private Scene manageEventsScene;

    public Scene createScene(Stage stage) {

        // SIDEBAR

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // MAIN CONTENT

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);
        mainvb.setStyle("-fx-background-color: #b3adad;");

        // HEADING

        Label heading = new Label("MANAGE EVENTS");
        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // TITLE

        Label title =  new Label("Manage Events");
        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =  new Label(
                        "Create and manage society events"
                );

                
        subtitle.setStyle("-fx-font-size:13px;-fx-text-fill:#777777;");
        VBox titleBox = new VBox(5);
        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // ADD EVENT BUTTON

        Button addEventBtn =  new Button("+ Add Event");            
        addEventBtn.setPrefWidth(130);
        addEventBtn.setPrefHeight(40);
        addEventBtn.setStyle(
                "-fx-background-color: :#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        // HEADER

        HBox header =  new HBox();
        header.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                titleBox,
                addEventBtn
        );

        // EVENT LIST

        VBox eventList = new VBox(15);
        eventList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // EVENT 1

        VBox event1 = createEvent(
                "Society Annual Meeting",
                "18 May 2025",
                "10:00 AM",
                "Community Hall",
                "Upcoming"
        );

        // EVENT 2

        VBox event2 = createEvent(
                "Children's Drawing Competition",
                "25 May 2025",
                "04:00 PM",
                "Garden Area",
                "Upcoming"
        );

        // EVENT 3

        VBox event3 = createEvent(
                "Yoga Session",
                "28 May 2025",
                "07:00 AM",
                "Community Hall",
                "Upcoming"
        );

        // EVENT 4

        VBox event4 = createEvent(
                "Society Cleanliness Drive",
                "05 May 2025",
                "08:00 AM",
                "Society Entrance",
                "Completed"
        );

        // EVENT 5

        VBox event5 = createEvent(
                "Cultural Evening",
                "02 May 2025",
                "06:00 PM",
                "Community Hall",
                "Completed"
        );

        // EVENT 6

        VBox event6 = createEvent(
                "Tree Plantation Drive",
                "28 April 2025",
                "08:00 AM",
                "Society Garden",
                "Completed"
        );

        // SHOW EVENTS

        eventList.getChildren().addAll(
                event1,
                event2,
                event3,
                event4,
                event5,
                event6
        );

        // SCROLL PANE

        ScrollPane scrollPane =  new ScrollPane();
        scrollPane.setContent(
                eventList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(500);
        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // VIEW ALL EVENTS BUTTON

        Button viewAllBtn =  new Button("View All Events");           
        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);
        viewAllBtn.setStyle(
                "-fx-background-color::#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );

        // ADD EVERYTHING TO MAIN
        mainvb.getChildren().addAll(
                heading,
                header,
                scrollPane,
                viewAllBtn
        );

        // ROOT

        HBox root =  new HBox();
         root.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        root.getChildren().addAll(sidebar,mainvb);
        root.setStyle("-fx-background-color::#434141;");
        HBox.setHgrow(mainvb,Priority.ALWAYS);


        // SCENE

        //manageEventsScene =  new Scene(root, 1500, 750);
         Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
        manageEventsScene = scene;
        return manageEventsScene;
    }

    // EVENT CARD METHOD

    private VBox createEvent(
            String eventName,
            String date,
            String time,
            String venue,
            String statusText) {


        VBox event =   new VBox(10);
              

        event.setPadding(
                new Insets(18)
        );

        event.setPrefHeight(105);
        event.setMaxWidth(1180);
        event.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        // EVENT NAME

        Label name =
                new Label(eventName);
        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // DETAILS

        Label details =
                new Label(
                        "Date: " + date +
                        "    |    " +
                        "Time: " + time +
                        "    |    " +
                        "Venue: " + venue
                );
        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // STATUS

        Label status = new Label(statusText);
                
        if (statusText.equals("Upcoming")) {
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

        // BOTTOM ROW
        

        HBox bottom =  new HBox();
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


        // ADD TO EVENT CARD

        event.getChildren().addAll(
                name,
                bottom
        );

        return event;
    }
}