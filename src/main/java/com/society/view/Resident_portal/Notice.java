package com.society.view.Resident_portal;



import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Notice {
    public Scene getResidentbtScene(Stage stage){
        
 panel panelobj = new panel(stage);


        // ================= ROOT =================

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN AREA =================

        VBox mainContent = new VBox(20);
 mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setSpacing(20);
        mainContent.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        Notice.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        100, 100, true, true, false, true
                )
        );

        mainContent.setBackground(new Background(backgroundImage));

        // ================= HEADING =================

        Label title = new Label("Notices");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Important announcements from society management"
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

        // ================= FILTER =================

        HBox filterBox = new HBox(10);

        ComboBox<String> category =
                new ComboBox<>();

        category.setPromptText("Category");

        category.getItems().addAll(
                "All",
                "Maintenance",
                "Security",
                "Events",
                "General"
        );

        category.setPrefWidth(180);

        TextField search =
                new TextField();

        search.setPromptText(
                "Search notices..."
        );

        search.setPrefWidth(250);

        filterBox.getChildren().addAll(
                category,
                search
        );

        // ================= NOTICE CONTAINER =================

        VBox noticeContainer =
                new VBox(15);

        noticeContainer.setFillWidth(true);

        // =================================================
        // NOTICE 1
        // =================================================

        VBox notice1 = new VBox(10);

        notice1.setPadding(
                new Insets(18)
        );

        notice1.setMaxWidth(
                Double.MAX_VALUE
        );

        notice1.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        Label title1 =
                new Label(
                        "Water Supply Maintenance"
                );

        title1.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        title1.setTextFill(
                Color.web("#263238")
        );

        Label info1 =
                new Label(
                        "Maintenance  •  15 August 2026"
                );

        info1.setFont(
                Font.font("System", 13)
        );

        info1.setTextFill(
                Color.web("#607D8B")
        );

        Label text1 =
                new Label(
                        "Water supply will remain unavailable "
                        + "from 10:00 AM to 2:00 PM due to "
                        + "scheduled maintenance work. "
                        + "Residents are requested to store "
                        + "sufficient water in advance."
                );

        text1.setWrapText(true);

        text1.setFont(
                Font.font("System", 13)
        );

        text1.setTextFill(
                Color.web("#455A64")
        );

        Button button1 =
                new Button("View Details");

        button1.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttonBox1 =
                new HBox();

        buttonBox1.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox1.getChildren().add(
                button1
        );

        notice1.getChildren().addAll(
                title1,
                info1,
                text1,
                buttonBox1
        );

        // =================================================
        // NOTICE 2
        // =================================================

        VBox notice2 = new VBox(10);

        notice2.setPadding(
                new Insets(18)
        );

        notice2.setMaxWidth(
                Double.MAX_VALUE
        );

        notice2.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        Label title2 =
                new Label(
                        "Independence Day Celebration"
                );

        title2.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        title2.setTextFill(
                Color.web("#263238")
        );

        Label info2 =
                new Label(
                        "Events  •  14 August 2026"
                );

        info2.setFont(
                Font.font("System", 13)
        );

        info2.setTextFill(
                Color.web("#607D8B")
        );

        Label text2 =
                new Label(
                        "All residents are invited to join "
                        + "the Independence Day celebration "
                        + "at the society community ground. "
                        + "The program will begin at 8:00 AM "
                        + "with flag hoisting."
                );

        text2.setWrapText(true);

        text2.setFont(
                Font.font("System", 13)
        );

        text2.setTextFill(
                Color.web("#455A64")
        );

        Button button2 =
                new Button("View Details");

        button2.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttonBox2 =
                new HBox();

        buttonBox2.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox2.getChildren().add(
                button2
        );

        notice2.getChildren().addAll(
                title2,
                info2,
                text2,
                buttonBox2
        );

        // =================================================
        // NOTICE 3
        // =================================================

        VBox notice3 = new VBox(10);

        notice3.setPadding(
                new Insets(18)
        );

        notice3.setMaxWidth(
                Double.MAX_VALUE
        );

        notice3.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        Label title3 =
                new Label(
                        "Parking Area Rules"
                );

        title3.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        title3.setTextFill(
                Color.web("#263238")
        );

        Label info3 =
                new Label(
                        "General  •  12 August 2026"
                );

        info3.setFont(
                Font.font("System", 13)
        );

        info3.setTextFill(
                Color.web("#607D8B")
        );

        Label text3 =
                new Label(
                        "Residents are requested to park "
                        + "their vehicles only in their allotted "
                        + "parking spaces. Visitors should use "
                        + "the designated visitor parking area."
                );

        text3.setWrapText(true);

        text3.setFont(
                Font.font("System", 13)
        );

        text3.setTextFill(
                Color.web("#455A64")
        );

        Button button3 =
                new Button("View Details");

        button3.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttonBox3 =
                new HBox();

        buttonBox3.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox3.getChildren().add(
                button3
        );

        notice3.getChildren().addAll(
                title3,
                info3,
                text3,
                buttonBox3
        );

        // =================================================
        // NOTICE 4
        // =================================================

        VBox notice4 = new VBox(10);

        notice4.setPadding(
                new Insets(18)
        );

        notice4.setMaxWidth(
                Double.MAX_VALUE
        );

        notice4.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        Label title4 =
                new Label(
                        "Security Update"
                );

        title4.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        title4.setTextFill(
                Color.web("#263238")
        );

        Label info4 =
                new Label(
                        "Security  •  10 August 2026"
                );

        info4.setFont(
                Font.font("System", 13)
        );

        info4.setTextFill(
                Color.web("#607D8B")
        );

        Label text4 =
                new Label(
                        "All residents are requested to carry "
                        + "their society identification card "
                        + "while entering the premises. "
                        + "Visitors must complete the security "
                        + "verification process."
                );

        text4.setWrapText(true);

        text4.setFont(
                Font.font("System", 13)
        );

        text4.setTextFill(
                Color.web("#455A64")
        );

        Button button4 =
                new Button("View Details");

        button4.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttonBox4 =
                new HBox();

        buttonBox4.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox4.getChildren().add(
                button4
        );

        notice4.getChildren().addAll(
                title4,
                info4,
                text4,
                buttonBox4
        );

        // ================= ADD NOTICES =================

        noticeContainer.getChildren().addAll(
                notice1,
                notice2,
                notice3,
                notice4
        );

        // ================= SCROLL =================

        ScrollPane scrollPane =
                new ScrollPane(noticeContainer);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        // ================= FINAL =================

        mainContent.getChildren().addAll(
                heading,
                filterBox,
                scrollPane
        );

        
BorderPane mainarea = new BorderPane();
mainarea.setTop(heading);
mainarea.setCenter(mainContent);
heading.setStyle("-fx-background-color: #4e342e");


root.setCenter(mainarea);        



        return new Scene(
                root,
                 ScreenSize.getWidth(),
                ScreenSize.getHeight());
        
    }
}

        