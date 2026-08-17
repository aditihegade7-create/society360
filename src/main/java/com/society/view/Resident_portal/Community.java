package com.society.view.Resident_portal;


import  javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Community {
    



    public Scene getCommunityScene(Stage stage){
        
 panel panelobj = new panel(stage);
 


        // ================= SIDEBAR =================

        // ================= ROOT =================
        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================
        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        // Background color
        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

        // ================= TITLE =================

        Label title = new Label("Community");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Stay connected with your society community"
        );

        subtitle.setFont(
                Font.font("System", 14)
        );

        subtitle.setTextFill(Color.WHITE);

        VBox heading = new VBox(5);

        heading.getChildren().addAll(
                title,
                subtitle
        );

        // ================= QUICK ACTIONS =================

        HBox actionCards = new HBox(15);

        VBox eventsCard = createActionCard(
                "Events",
                "View upcoming society events"
        );

        VBox residentsCard = createActionCard(
                "Residents",
                "Connect with society residents"
        );

        VBox activitiesCard = createActionCard(
                "Activities",
                "Explore community activities"
        );

        actionCards.getChildren().addAll(
                eventsCard,
                residentsCard,
                activitiesCard
        );

        // ================= UPCOMING EVENTS =================

        Label eventTitle = new Label(
                "Upcoming Events"
        );

        eventTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        eventTitle.setTextFill(Color.WHITE);

        VBox eventList = new VBox(12);

        eventList.getChildren().addAll(

                createEventCard(
                        "Independence Day Celebration",
                        "15 August 2026",
                        "08:00 AM",
                        "Community Ground"
                ),

                createEventCard(
                        "Society Sports Day",
                        "22 August 2026",
                        "09:00 AM",
                        "Sports Ground"
                ),

                createEventCard(
                        "Residents Meeting",
                        "28 August 2026",
                        "06:00 PM",
                        "Community Hall"
                )
        );

        // ================= COMMUNITY ANNOUNCEMENT =================

        Label announcementTitle = new Label(
                "Community Announcements"
        );

        announcementTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        19
                )
        );

        announcementTitle.setTextFill(Color.WHITE);

        VBox announcement = new VBox(8);

        announcement.setPadding(
                new Insets(15)
        );

        announcement.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        Label announcementHeading =
                new Label("Maintenance Work");

        announcementHeading.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        15
                )
        );

        Label announcementText =
                new Label(
                        "Water supply maintenance will be carried out " +
                        "on Sunday from 10:00 AM to 2:00 PM."
                );

        announcementText.setWrapText(true);

        announcementText.setTextFill(
                Color.web("#546E7A")
        );

        announcement.getChildren().addAll(
                announcementHeading,
                announcementText
        );

        // ================= ADD CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                actionCards,
                eventTitle,
                eventList,
                announcementTitle,
                announcement
        );

        root.setCenter(mainContent);

        return new Scene(
                root,
                1200,
                700
        );
    }

    // =====================================================
    // ACTION CARD
    // =====================================================

    private VBox createActionCard(
            String title,
            String description) {

        VBox card = new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setPrefWidth(220);

        card.setPrefHeight(95);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        15
                )
        );

        titleLabel.setTextFill(
                Color.web("#37474F")
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setWrapText(true);

        descriptionLabel.setTextFill(
                Color.web("#789098")
        );

        card.getChildren().addAll(
                titleLabel,
                descriptionLabel
        );

        return card;
    }

    // =====================================================
    // EVENT CARD
    // =====================================================

    private HBox createEventCard(
            String eventName,
            String date,
            String time,
            String location) {

        HBox card = new HBox(20);

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setPadding(
                new Insets(15)
        );

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        VBox eventInfo = new VBox(5);

        Label nameLabel =
                new Label(eventName);

        nameLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        15
                )
        );

        nameLabel.setTextFill(
                Color.web("#37474F")
        );

        Label locationLabel =
                new Label(location);

        locationLabel.setTextFill(
                Color.GRAY
        );

        eventInfo.getChildren().addAll(
                nameLabel,
                locationLabel
        );

        VBox dateInfo = new VBox(5);

        Label dateLabel =
                new Label(date);

        dateLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        dateLabel.setTextFill(
                Color.web("#455A64")
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setTextFill(
                Color.GRAY
        );

        dateInfo.getChildren().addAll(
                dateLabel,
                timeLabel
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button viewButton =
                new Button("View");

        viewButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        card.getChildren().addAll(
                eventInfo,
                spacer,
                dateInfo,
                viewButton
        );

        return card;
    }
}

 





