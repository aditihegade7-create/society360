package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ManageEvents {

    private Scene manageEventsScene;

    // IMPORTANT:
    // StackPane will keep popup inside same scene
    private StackPane rootStack;

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

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // =========================
        // HEADING
        // =========================

        Label heading =
                new Label("MANAGE EVENTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        // =========================
        // TITLE
        // =========================

        Label title =
                new Label("Manage Events");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label(
                        "Create and manage society events"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );


        VBox titleBox =
                new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );


        // =========================
        // ADD EVENT BUTTON
        // =========================

        Button addEventBtn =
                new Button("+ Add Event");

        addEventBtn.setPrefWidth(130);
        addEventBtn.setPrefHeight(40);

        addEventBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;"
        );


        // CLICK ADD EVENT
        addEventBtn.setOnAction(
                e -> openAddEventDialog()
        );


        // =========================
        // HEADER
        // =========================

        HBox header =
                new HBox();

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

        VBox event1 =
                createEvent(
                        "Society Annual Meeting",
                        "18 May 2025",
                        "10:00 AM",
                        "Community Hall",
                        "Upcoming"
                );


        // EVENT 2

        VBox event2 =
                createEvent(
                        "Children's Drawing Competition",
                        "25 May 2025",
                        "04:00 PM",
                        "Garden Area",
                        "Upcoming"
                );


        // EVENT 3

        VBox event3 =
                createEvent(
                        "Yoga Session",
                        "28 May 2025",
                        "07:00 AM",
                        "Community Hall",
                        "Upcoming"
                );


        // EVENT 4

        VBox event4 =
                createEvent(
                        "Society Cleanliness Drive",
                        "05 May 2025",
                        "08:00 AM",
                        "Society Entrance",
                        "Completed"
                );


        // EVENT 5

        VBox event5 =
                createEvent(
                        "Cultural Evening",
                        "02 May 2025",
                        "06:00 PM",
                        "Community Hall",
                        "Completed"
                );


        // EVENT 6

        VBox event6 =
                createEvent(
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

        ScrollPane scrollPane =
                new ScrollPane();

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
        // VIEW ALL EVENTS
        // =========================

        Button viewAllBtn =
                new Button("View All Events");

        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;" +
                "-fx-cursor:hand;"
        );


        // CLICK VIEW ALL
        viewAllBtn.setOnAction(
                e -> openViewAllEventsDialog()
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
        // MAIN HBOX
        // =========================

        HBox mainRoot =
                new HBox();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );


        // =========================
        // STACKPANE ROOT
        // =========================

        rootStack =
                new StackPane();

        rootStack.getChildren().add(
                mainRoot
        );


        // =========================
        // SCENE
        // =========================

        Scene scene =
                new Scene(
                        rootStack,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        manageEventsScene = scene;

        return manageEventsScene;
    }


    // =====================================================
    // ADD EVENT POPUP
    // =====================================================

    private void openAddEventDialog() {

        // DARK OVERLAY

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );


        // POPUP BOX

        VBox formBox =
                new VBox(12);

        formBox.setPadding(
                new Insets(25)
        );

        formBox.setMaxWidth(500);
        formBox.setMaxHeight(500);

        formBox.setStyle("""
            -fx-background-color:#ffffff;
            -fx-background-radius:20;
            -fx-effect:dropshadow(
                three-pass-box,
                rgba(0,0,0,0.3),
                20,
                0,
                0,
                5
            );
        """);


        // =========================
        // HEADER
        // =========================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label title =
                new Label("Add New Event");

        title.setFont(
                Font.font(
                        "Georgia",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setStyle(
                "-fx-text-fill:#123C36;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button closeBtn =
                new Button("✕");

        closeBtn.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-cursor:hand;"
        );

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        headerRow.getChildren().addAll(
                title,
                spacer,
                closeBtn
        );


        // =========================
        // EVENT NAME
        // =========================

        Label nameLabel =
                new Label("Event Name");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter event name"
        );

        nameField.setPrefHeight(40);


        // =========================
        // DATE
        // =========================

        Label dateLabel =
                new Label("Date");

        TextField dateField =
                new TextField();

        dateField.setPromptText(
                "Enter event date"
        );

        dateField.setPrefHeight(40);


        // =========================
        // TIME
        // =========================

        Label timeLabel =
                new Label("Time");

        TextField timeField =
                new TextField();

        timeField.setPromptText(
                "Enter event time"
        );

        timeField.setPrefHeight(40);


        // =========================
        // VENUE
        // =========================

        Label venueLabel =
                new Label("Venue");

        TextField venueField =
                new TextField();

        venueField.setPromptText(
                "Enter event venue"
        );

        venueField.setPrefHeight(40);


        // =========================
        // BUTTONS
        // =========================

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);
        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;"
        );


        Button saveBtn =
                new Button("Save Event");

        saveBtn.setPrefWidth(120);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );


        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );


        cancelBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        saveBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        // =========================
        // ADD TO FORM
        // =========================

        formBox.getChildren().addAll(
                headerRow,

                nameLabel,
                nameField,

                dateLabel,
                dateField,

                timeLabel,
                timeField,

                venueLabel,
                venueField,

                buttonBox
        );


        // =========================
        // ADD POPUP TO OVERLAY
        // =========================

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );


        // IMPORTANT:
        // Same scene, no Stage

        rootStack.getChildren().add(
                overlay
        );
    }


    // =====================================================
    // VIEW ALL EVENTS POPUP
    // =====================================================

    private void openViewAllEventsDialog() {

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );


        VBox formBox =
                new VBox(15);

        formBox.setPadding(
                new Insets(25)
        );

        formBox.setMaxWidth(650);
        formBox.setMaxHeight(600);

        formBox.setStyle("""
            -fx-background-color:#ffffff;
            -fx-background-radius:20;
            -fx-effect:dropshadow(
                three-pass-box,
                rgba(0,0,0,0.3),
                20,
                0,
                0,
                5
            );
        """);


        // =========================
        // HEADER
        // =========================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label title =
                new Label("All Events");

        title.setFont(
                Font.font(
                        "Georgia",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setStyle(
                "-fx-text-fill:#123C36;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Button closeBtn =
                new Button("✕");

        closeBtn.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-cursor:hand;"
        );


        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        headerRow.getChildren().addAll(
                title,
                spacer,
                closeBtn
        );


        // =========================
        // ALL EVENTS
        // =========================

        VBox allEvents =
                new VBox(12);

        allEvents.getChildren().addAll(

                createEvent(
                        "Society Annual Meeting",
                        "18 May 2025",
                        "10:00 AM",
                        "Community Hall",
                        "Upcoming"
                ),

                createEvent(
                        "Children's Drawing Competition",
                        "25 May 2025",
                        "04:00 PM",
                        "Garden Area",
                        "Upcoming"
                ),

                createEvent(
                        "Yoga Session",
                        "28 May 2025",
                        "07:00 AM",
                        "Community Hall",
                        "Upcoming"
                ),

                createEvent(
                        "Society Cleanliness Drive",
                        "05 May 2025",
                        "08:00 AM",
                        "Society Entrance",
                        "Completed"
                ),

                createEvent(
                        "Cultural Evening",
                        "02 May 2025",
                        "06:00 PM",
                        "Community Hall",
                        "Completed"
                ),

                createEvent(
                        "Tree Plantation Drive",
                        "28 April 2025",
                        "08:00 AM",
                        "Society Garden",
                        "Completed"
                )
        );


        // =========================
        // SCROLL
        // =========================

        ScrollPane popupScroll =
                new ScrollPane();

        popupScroll.setContent(
                allEvents
        );

        popupScroll.setFitToWidth(true);

        popupScroll.setPrefHeight(430);

        popupScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        // =========================
        // CLOSE BUTTON
        // =========================

        Button closeBottomBtn =
                new Button("Close");

        closeBottomBtn.setPrefWidth(100);
        closeBottomBtn.setPrefHeight(40);

        closeBottomBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );


        closeBottomBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        HBox buttonBox =
                new HBox(
                        closeBottomBtn
                );

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        // =========================
        // FORM CONTENT
        // =========================

        formBox.getChildren().addAll(
                headerRow,
                popupScroll,
                buttonBox
        );


        // =========================
        // ADD TO OVERLAY
        // =========================

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );


        // SAME SCENE
        rootStack.getChildren().add(
                overlay
        );
    }


    // =====================================================
    // REMOVE POPUP
    // =====================================================

    private void removeOverlay(
            StackPane overlay) {

        rootStack.getChildren().remove(
                overlay
        );
    }


    // =====================================================
    // EVENT CARD
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


        event.getChildren().addAll(
                name,
                bottom
        );


        return event;
    }
}