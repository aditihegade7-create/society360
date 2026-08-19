package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageEvents {

    // Private Scene variable
    private Scene manageEventsScene;

    public Scene createScene(Stage stage) {

        // =========================
        // SIDEBAR
        // =========================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // =========================
        // MAIN CONTENT
        // =========================

        VBox mainvb = new VBox(20);
        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);
        mainvb.setStyle("-fx-background-color: #e8ddd5;");

        mainvb.setPadding(new Insets(25));
        mainvb.setMaxWidth(Double.MAX_VALUE);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =========================
        // HEADING
        // =========================

        Label heading = new Label("MANAGE EVENTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // =========================
        // TITLE
        // =========================

        Label title = new Label("Manage Events");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label(
                "Create and manage society events"
        );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        VBox titleBox = new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // =========================
        // ADD EVENT BUTTON
        // =========================

        Button addEventBtn = new Button("+ Add Event");

        addEventBtn.setPrefWidth(130);
        addEventBtn.setPrefHeight(40);

        addEventBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );

        // =========================
        // ADD EVENT BUTTON CLICK
        // =========================

        addEventBtn.setOnAction(e -> {

            // Small popup Stage
            Stage eventStage = new Stage();

            eventStage.initModality(Modality.APPLICATION_MODAL);
            eventStage.initOwner(stage);

            // =========================
            // POPUP TITLE
            // =========================

            Label popupTitle = new Label("Add New Event");

            popupTitle.setStyle(
                    "-fx-font-size:22px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // =========================
            // EVENT NAME
            // =========================

            Label eventNameLabel =
                    new Label("Event Name:");

            eventNameLabel.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#434141;"
            );

            TextField eventNameField =
                    new TextField();

            eventNameField.setPromptText(
                    "Enter event name"
            );

            eventNameField.setPrefHeight(38);

            eventNameField.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-border-color:#dddddd;" +
                    "-fx-border-radius:6;" +
                    "-fx-background-radius:6;"
            );

            // =========================
            // DATE
            // =========================

            Label dateLabel =
                    new Label("Date:");

            dateLabel.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#434141;"
            );

            DatePicker datePicker =
                    new DatePicker();

            datePicker.setPromptText(
                    "Select event date"
            );

            datePicker.setPrefHeight(38);

            datePicker.setMaxWidth(
                    Double.MAX_VALUE
            );

            // =========================
            // TIME
            // =========================

            Label timeLabel =
                    new Label("Time:");

            timeLabel.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#434141;"
            );

            TextField timeField =
                    new TextField();

            timeField.setPromptText(
                    "e.g. 10:00 AM"
            );

            timeField.setPrefHeight(38);

            timeField.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-border-color:#dddddd;" +
                    "-fx-border-radius:6;" +
                    "-fx-background-radius:6;"
            );

            // =========================
            // VENUE
            // =========================

            Label venueLabel =
                    new Label("Venue:");

            venueLabel.setStyle(
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#434141;"
            );

            ComboBox<String> venueBox =
                    new ComboBox<>();

            venueBox.getItems().addAll(
                    "Community Hall",
                    "Garden Area",
                    "Society Entrance",
                    "Society Garden",
                    "Other"
            );

            venueBox.setPromptText(
                    "Select venue"
            );

            venueBox.setPrefHeight(38);

            venueBox.setMaxWidth(
                    Double.MAX_VALUE
            );

            // =========================
            // SAVE BUTTON
            // =========================

            Button saveBtn =
                    new Button("Save Event");

            saveBtn.setPrefWidth(110);
            saveBtn.setPrefHeight(38);

            saveBtn.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:7;"
            );

            // =========================
            // CANCEL BUTTON
            // =========================

            Button cancelBtn =
                    new Button("Cancel");

            cancelBtn.setPrefWidth(90);
            cancelBtn.setPrefHeight(38);

            cancelBtn.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-text-fill:#434141;" +
                    "-fx-font-weight:bold;" +
                    "-fx-border-color:#dddddd;" +
                    "-fx-border-radius:7;" +
                    "-fx-background-radius:7;"
            );

            // =========================
            // CANCEL CLICK
            // =========================

            cancelBtn.setOnAction(event -> {

                eventStage.close();

            });

            // =========================
            // SAVE CLICK
            // =========================

            saveBtn.setOnAction(event -> {

                System.out.println(
                        "Event Saved: " +
                        eventNameField.getText()
                );

                eventStage.close();

            });

            // =========================
            // BUTTON BOX
            // =========================

            HBox buttons =
                    new HBox(10);

            buttons.setAlignment(
                    Pos.CENTER_RIGHT
            );

            buttons.getChildren().addAll(
                    cancelBtn,
                    saveBtn
            );

            // =========================
            // POPUP BOX
            // =========================

            VBox popupBox =
                    new VBox(8);

            popupBox.setPadding(
                    new Insets(25)
            );

            popupBox.setPrefWidth(420);
            popupBox.setPrefHeight(430);

            popupBox.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:12;" +
                    "-fx-border-color:#EEEEEE;" +
                    "-fx-border-radius:12;"
            );

            popupBox.getChildren().addAll(

                    popupTitle,

                    new Label(""),

                    eventNameLabel,
                    eventNameField,

                    dateLabel,
                    datePicker,

                    timeLabel,
                    timeField,

                    venueLabel,
                    venueBox,

                    new Label(""),

                    buttons
            );

            // =========================
            // POPUP SCENE
            // =========================

            Scene popupScene =
                    new Scene(
                            popupBox,
                            420,
                            430
                    );

            eventStage.setScene(
                    popupScene
            );

            eventStage.setTitle(
                    "Add New Event"
            );

            // Small window
            eventStage.setWidth(420);
            eventStage.setHeight(430);

            eventStage.setResizable(false);

            eventStage.showAndWait();
        });

        // =========================
        // HEADER
        // =========================

        HBox header = new HBox();

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

        // =========================
        // EVENT LIST
        // =========================

        VBox eventList =
                new VBox(15);

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

        eventList.getChildren().addAll(
                event1,
                event2,
                event3,
                event4,
                event5,
                event6
        );

        // =========================
        // SCROLL PANE
        // =========================

        javafx.scene.control.ScrollPane scrollPane =
                new javafx.scene.control.ScrollPane();

        scrollPane.setContent(
                eventList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(500);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =========================
        // VIEW ALL BUTTON
        // =========================

        Button viewAllBtn =
                new Button("View All Events");

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

        // =========================
        // MAIN CONTENT
        // =========================

        mainvb.getChildren().addAll(
                heading,
                header,
                scrollPane,
                viewAllBtn
        );

        // =========================
        // ROOT
        // =========================

        HBox root = new HBox();

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =========================
        // SCENE
        // =========================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageEventsScene = scene;

        return manageEventsScene;
    }

    // =====================================================
    // EVENT CARD METHOD
    // =====================================================

    private VBox createEvent(
            String eventName,
            String date,
            String time,
            String venue,
            String statusText) {

        VBox event =
                new VBox(10);

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

        Label status =
                new Label(statusText);

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

        HBox bottom =
                new HBox();

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

        // ADD TO CARD

        event.getChildren().addAll(
                name,
                bottom
        );

        return event;
    }
}