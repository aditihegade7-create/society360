package com.society.view.Owner_portal;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OwnerDashboard {

    public static Scene createScene(Stage stage) {

        // =========================
        // ROOT
        // =========================

        BorderPane root = new BorderPane();

        OwnerSidebar sidebar = new OwnerSidebar(stage);

        root.setLeft(
                sidebar.getSidebar()
        );

        // =========================
        // MAIN CONTENT
        // =========================

        VBox mainContent = new VBox();

        mainContent.setPadding(
                new Insets(25, 35, 25, 35)
        );

        mainContent.setSpacing(20);

        mainContent.setAlignment(
                Pos.TOP_LEFT
        );

        mainContent.setStyle(
                "-fx-background-color: #789098;"
        );

        // =========================
        // HEADER
        // =========================

        Label title = new Label(
                "Good Morning, Owner"
        );

        title.setStyle(
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        Label subtitle = new Label(
                "Welcome to your Society360 Owner Portal"
        );

        subtitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #263238;"
        );

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        mainContent.getChildren().add(
                heading
        );

        // =========================
        // OWNER CONTENT
        // =========================

        HBox cards = new HBox();

        cards.setSpacing(15);

        VBox totalTenants = createCard(
                "Total Tenants",
                "02"
        );

        VBox rentReceived = createCard(
                "Rent Received",
                "₹18,450"
        );

        VBox pendingAmount = createCard(
                "Pending Amount",
                "₹1,250"
        );

        VBox upcomingDue = createCard(
                "Upcoming Due",
                "02"
        );

        cards.getChildren().addAll(
                totalTenants,
                rentReceived,
                pendingAmount,
                upcomingDue
        );

        mainContent.getChildren().add(
                cards
        );

        // =========================
        // INCOME AND ACTIVITY
        // =========================

        HBox information = new HBox();

        information.setSpacing(20);

        VBox income = createInformationBox(
                "Income Overview",
                "Total Rent       ₹17,200",
                "Maintenance        ₹800",
                "Other Charges      ₹450"
        );

        VBox activity = createInformationBox(
                "Recent Activity",
                "Payment Received      ₹9,000",
                "Maintenance Paid      ₹1,250",
                "Rent Due             ₹12,500"
        );

        information.getChildren().addAll(
                income,
                activity
        );

        mainContent.getChildren().add(
                information
        );

        // =========================
        // NOTICE
        // =========================

        Label notice = new Label(
                "Notice: Water tank cleaning on 15 May 2025 from 9:00 AM to 1:00 PM."
        );

        notice.setPadding(
                new Insets(15)
        );

        notice.setMaxWidth(
                Double.MAX_VALUE
        );

        notice.setStyle(
                "-fx-background-color: #E8F1F2;" +
                "-fx-background-radius: 8;" +
                "-fx-text-fill: #263238;"
        );

        mainContent.getChildren().add(
                notice
        );

        // =========================
        // CENTER
        // =========================

        root.setCenter(
                mainContent
        );

        // =========================
        // SCENE
        // =========================

        return new Scene(
                root,
                1500,
                750
        );
    }

    // =========================
    // CARD
    // =========================

    private static VBox createCard(
            String title,
            String value
    ) {

        VBox card = new VBox();

        card.setSpacing(8);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefWidth(250);

        card.setStyle(
                "-fx-background-color: #F4F7F8;" +
                "-fx-background-radius: 10;"
        );

        Label cardTitle = new Label(
                title
        );

        cardTitle.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #546E7A;"
        );

        Label cardValue = new Label(
                value
        );

        cardValue.setStyle(
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        card.getChildren().addAll(
                cardTitle,
                cardValue
        );

        return card;
    }

    // =========================
    // INFORMATION BOX
    // =========================

    private static VBox createInformationBox(
            String title,
            String line1,
            String line2,
            String line3
    ) {

        VBox box = new VBox();

        box.setSpacing(10);

        box.setPadding(
                new Insets(20)
        );

        box.setPrefWidth(500);

        box.setStyle(
                "-fx-background-color: #F4F7F8;" +
                "-fx-background-radius: 10;"
        );

        Label heading = new Label(
                title
        );

        heading.setStyle(
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        Label first = new Label(line1);
        Label second = new Label(line2);
        Label third = new Label(line3);

        first.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #37474F;"
        );

        second.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #37474F;"
        );

        third.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #37474F;"
        );

        box.getChildren().addAll(
                heading,
                first,
                second,
                third
        );

        return box;
    }
}