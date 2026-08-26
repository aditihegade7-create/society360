package com.society.view.Owner_portal;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OwnerDocuments {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        OwnerSidebar sidebar = new OwnerSidebar(stage);
        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox(20);

        mainContent.setPadding(new Insets(30, 40, 30, 40));

        Image image = new Image(
        OwnerDocuments.class.getResource("/background-Dashboard1.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );

        mainContent.setBackground(new Background(backgroundImage));
        

       HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox vb = new VBox();
        Label greeting = new Label("Owner Documents");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        Label description = new Label("View Owner documents");
        description.setStyle("-fx-font-size:12px;-fx-text-fill: #ffffff;");

        vb.getChildren().addAll(greeting,description);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

         Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));
        day.setStyle("-fx-text-fill: #ffffff"); 
        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
         date.setStyle("-fx-text-fill: #ffffff");
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(vb,
                spacer,
                vb1);
       
        VBox documentCard = new VBox(18);

        documentCard.setPadding(
                new Insets(25)
        );

        documentCard.setStyle(
                "-fx-background-color: #ffffff;"+
                "-fx-background-radius: 15;" +
                "-fx-border-color: #E5E7EB;" +
                "-fx-border-radius: 15;"
        );

        

        Label cardTitle = new Label(
                "Required Documents"
        );

        cardTitle.setStyle(
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #333333;"
        );

        Label cardDescription = new Label(
                "Upload documents in PDF format"
        );

        cardDescription.setStyle(
                "-fx-font-size: 13px;" +
                "-fx-text-fill: #888888;"
        );

        VBox cardHeading = new VBox(4);

        cardHeading.getChildren().addAll(
                cardTitle,
                cardDescription
        );

        HBox aadhaar = createDocumentRow(
                stage,
                "Aadhaar Card",
                "Identity Proof"
        );

        HBox pan = createDocumentRow(
                stage,
                "PAN Card",
                "Identity Proof"
        );

        HBox ownership = createDocumentRow(
                stage,
                "Ownership Proof",
                "Property Document"
        );

        HBox address = createDocumentRow(
                stage,
                "Address Proof",
                "Address Document"
        );

        
        documentCard.getChildren().addAll(
                cardHeading,
                aadhaar,
                pan,
                ownership,
                address
        );

        
        HBox buttonBox = new HBox();

        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        Button saveButton = new Button(
                "Save Documents"
        );

        saveButton.setPrefWidth(170);
        saveButton.setPrefHeight(42);

        saveButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;" +
                "-fx-cursor: hand;"
        );

        buttonBox.getChildren().add(
                saveButton
        );

         mainContent.getChildren().addAll(
                header,
                documentCard,
                buttonBox
        );

       BorderPane mainarea = new BorderPane();
       mainarea.setTop(header);
       mainarea.setCenter(mainContent);
       root.setCenter(mainarea);
       

        return new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }


     private static HBox createDocumentRow(
            Stage stage,
            String documentName,
            String documentType) {

        HBox row = new HBox(15);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(15)
        );

        row.setStyle(
                "-fx-background-color: #F8FAFC;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E8EBEF;" +
                "-fx-border-radius: 10;"
        );

        
        Label icon = new Label("📄");

        icon.setStyle(
                "-fx-font-size: 25px;"
        );

        
        Label name = new Label(
                documentName
        );

        name.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #333333;"
        );

        Label type = new Label(
                documentType
        );

        type.setStyle(
                "-fx-font-size: 11px;" +
                "-fx-text-fill: #888888;"
        );

        VBox information = new VBox(3);

        information.setPrefWidth(220);

        information.getChildren().addAll(
                name,
                type
        );

       

        Label fileName = new Label(
                "No file selected"
        );

        fileName.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #999999;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        

        Button chooseButton = new Button( "Choose File" );

        chooseButton.setPrefWidth(110);
        chooseButton.setPrefHeight(34);

        chooseButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #4e342e;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;" +
                "-fx-text-fill: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        chooseButton.setOnAction(e -> {

            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle( "Select " + documentName );

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "PDF Files",
                            "*.pdf"
                    )
            );

            File file =fileChooser.showOpenDialog(stage);

            if (file != null) {

                fileName.setText(
                        file.getName()
                );

                fileName.setStyle(
                        "-fx-font-size: 12px;" +
                        "-fx-text-fill: #4e3425;" +
                        "-fx-font-weight: bold;"
                );
            }
        });

        row.getChildren().addAll(
                icon,
                information,
                fileName,
                spacer,
                chooseButton
        );

        return row;
    }
}