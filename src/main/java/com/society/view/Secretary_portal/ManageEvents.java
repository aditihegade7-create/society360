package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageEvents {

   
    private Scene manageEventsScene;


    
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
                "Manage Events"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label description = new Label(
                "Create and manage society events"
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
                "SOCIETY EVENTS"
        );

        sectionTitle.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );


        
        Button addEventBtn = new Button(
                "+ Add Event"
        );

        addEventBtn.setPrefWidth(130);

        addEventBtn.setPrefHeight(40);

        addEventBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        

        Region eventSpacer = new Region();

        HBox.setHgrow(
                eventSpacer,
                Priority.ALWAYS
        );


        HBox eventHeader = new HBox();

        eventHeader.setAlignment(
                Pos.CENTER_LEFT
        );


        eventHeader.getChildren().addAll(
                sectionTitle,
                eventSpacer,
                addEventBtn
        );


        VBox eventList = new VBox(15);

        eventList.setPadding(
                new Insets(5, 0, 5, 0)
        );


        VBox event1 = createEvent(
                "Society Annual Meeting",
                "18 May 2025",
                "10:00 AM",
                "Community Hall",
                "Upcoming"
        );


        
        VBox event2 = createEvent(
                "Children's Drawing Competition",
                "25 May 2025",
                "04:00 PM",
                "Garden Area",
                "Upcoming"
        );


       
        VBox event3 = createEvent(
                "Yoga Session",
                "28 May 2025",
                "07:00 AM",
                "Community Hall",
                "Upcoming"
        );


        VBox event4 = createEvent(
                "Society Cleanliness Drive",
                "05 May 2025",
                "08:00 AM",
                "Society Entrance",
                "Completed"
        );


       

        VBox event5 = createEvent(
                "Cultural Evening",
                "02 May 2025",
                "06:00 PM",
                "Community Hall",
                "Completed"
        );


        
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

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                eventList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setPrefHeight(500);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );


        Button viewAllBtn = new Button(
                "View All Events"
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


       
        addEventBtn.setOnAction(e -> {

            Scene createEventScene = createEventScene(stage);

            stage.setScene(
                    createEventScene
            );

        });

        mainContent.getChildren().addAll(
                eventHeader,
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

        manageEventsScene = scene;

        return manageEventsScene;
    }


    private Scene createEventScene(Stage stage) {

       
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


        Label title = new Label(
                "Create Event"
        );

        title.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label subtitle = new Label(
                "Create a new society event"
        );

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#ffffff;"
        );


        headerText.getChildren().addAll(
                title,
                subtitle
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
                new Insets(30, 40, 30, 40)
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );


        VBox eventCard = new VBox(20);

        eventCard.setPadding(
                new Insets(25)
        );

        eventCard.setMaxWidth(1000);

        eventCard.setStyle(
                "-fx-background-color:#F4F7F8;" +
                "-fx-background-radius:12;"
        );


        Label cardTitle = new Label(
                "Event Details"
        );

        cardTitle.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#102A43;"
        );


        Label cardSubtitle = new Label(
                "Enter the details of the new society event"
        );

        cardSubtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#546E7A;"
        );


        VBox cardHeading = new VBox(
                4,
                cardTitle,
                cardSubtitle
        );


        GridPane form = new GridPane();

        form.setHgap(30);

        form.setVgap(15);


        Label eventNameLabel = new Label(
                "Event Name"
        );

        TextField eventNameField = new TextField();

        eventNameField.setPromptText(
                "Enter event name"
        );

        Label dateLabel = new Label(
                "Event Date"
        );

        DatePicker eventDatePicker = new DatePicker();

        eventDatePicker.setPromptText(
                "Select event date"
        );

        Label timeLabel = new Label(
                "Event Time"
        );

        TextField timeField = new TextField();

        timeField.setPromptText(
                "Enter event time"
        );

        Label venueLabel = new Label(
                "Venue"
        );

        TextField venueField = new TextField();

        venueField.setPromptText(
                "Enter venue"
        );

        styleLabel(eventNameLabel);

        styleLabel(dateLabel);

        styleLabel(timeLabel);

        styleLabel(venueLabel);

        String fieldStyle =
                "-fx-background-color:white;" +
                "-fx-border-color:#CBD5D8;" +
                "-fx-border-radius:6;" +
                "-fx-background-radius:6;";


        eventNameField.setStyle(
                fieldStyle
        );

        eventDatePicker.setStyle(
                fieldStyle
        );

        timeField.setStyle(
                fieldStyle
        );

        venueField.setStyle(
                fieldStyle
        );


        eventNameField.setPrefWidth(380);

        eventDatePicker.setPrefWidth(380);

        timeField.setPrefWidth(380);

        venueField.setPrefWidth(380);


        eventNameField.setPrefHeight(40);

        eventDatePicker.setPrefHeight(40);

        timeField.setPrefHeight(40);

        venueField.setPrefHeight(40);

        form.add(
                eventNameLabel,
                0,
                0
        );

        form.add(
                dateLabel,
                1,
                0
        );


        form.add(
                eventNameField,
                0,
                1
        );

        form.add(
                eventDatePicker,
                1,
                1
        );


        form.add(
                timeLabel,
                0,
                2
        );

        form.add(
                venueLabel,
                1,
                2
        );


        form.add(
                timeField,
                0,
                3
        );

        form.add(
                venueField,
                1,
                3
        );

        Button cancelButton = new Button(
                "Cancel"
        );

        Button createButton = new Button(
                "Create Event"
        );


        cancelButton.setPrefWidth(110);

        cancelButton.setPrefHeight(40);


        createButton.setPrefWidth(140);

        createButton.setPrefHeight(40);


        cancelButton.setStyle(
                "-fx-background-color:#ffffff;" +
                "-fx-text-fill:#4e342e;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        createButton.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:#ffffff;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );


        HBox buttons = new HBox(12);

        buttons.setAlignment(
                Pos.CENTER_RIGHT
        );


        buttons.getChildren().addAll(
                cancelButton,
                createButton
        );


        
        eventCard.getChildren().addAll(
                cardHeading,
                form,
                buttons
        );


        cancelButton.setOnAction(e -> {

            stage.setScene(
                    manageComplaintsOrEventsScene(stage)
            );

        });


        
        createButton.setOnAction(e -> {

            String eventName = eventNameField.getText();

            String eventTime = timeField.getText();

            String venue = venueField.getText();


            if (eventName.isEmpty()
                    || eventDatePicker.getValue() == null
                    || eventTime.isEmpty()
                    || venue.isEmpty()) {

                return;
            }


            
            stage.setScene(
                    manageEventsScene
            );

        });


        
        mainContent.getChildren().add(
                eventCard
        );


        
        mainarea.setTop(header);

        mainarea.setCenter(mainContent);


        
        root.setCenter(
                mainarea
        );


        
        return new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }


    
    private Scene manageComplaintsOrEventsScene(Stage stage) {

        return createScene(stage);
    }


    
    private VBox createEvent(
            String eventName,
            String date,
            String time,
            String venue,
            String statusText) {


        VBox event = new VBox(10);


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


       
        Label name = new Label(
                eventName
        );


        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        
        Label details = new Label(
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


       
        Label status = new Label(
                statusText
        );


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

        event.getChildren().addAll(
                name,
                bottom
        );


        return event;
    }

    private static void styleLabel(
            Label label) {

        label.setStyle(
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#37474F;"
        );
    }
}