package com.society.view.Owner_portal;

import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        BorderPane mainArea = new BorderPane();

        
        HBox header = new HBox();
        header.setPadding( new Insets(25,35,25,35) );
         header.setAlignment( Pos.CENTER_LEFT );
         header.setStyle("-fx-background-color:#4e342e;"
        );

       
        VBox titleBox = new VBox(3);
        Label greeting = new Label("Owner Documents");
        greeting.setStyle(  "-fx-font-size:24px;" +"-fx-font-weight:bold;" +"-fx-text-fill:white;");

        Label description = new Label("View and manage your important documents");
        description.setStyle("-fx-font-size:12px;" +"-fx-text-fill:#eeeeee;");
        titleBox.getChildren().addAll( greeting, description);

       
        Region headerSpacer = new Region();
        HBox.setHgrow( headerSpacer, Priority.ALWAYS
        );
        VBox dateBox = new VBox(3);
        dateBox.setAlignment(Pos.CENTER_RIGHT );
        LocalDate today = LocalDate.now();
        Label day = new Label(today.format(DateTimeFormatter.ofPattern("EEEE"))
        );
         day.setStyle("-fx-font-size:13px;" +"-fx-font-weight:bold;" +"-fx-text-fill:white;"
        );
        Label date = new Label( today.format( DateTimeFormatter.ofPattern("dd MMMM yyyy"))
        );

        date.setStyle("-fx-font-size:12px;" + "-fx-text-fill:#eeeeee;"
        );

        dateBox.getChildren().addAll(day,date );
        header.getChildren().addAll(
                titleBox,
                headerSpacer,
                dateBox
        );

        mainArea.setTop(header);
        VBox content = new VBox(20);

        content.setPadding( new Insets(30, 40, 30, 40));
        content.setStyle("-fx-background-color:#e8ddd5;" );
       
        VBox documentCard = new VBox(18);
        documentCard.setPadding(new Insets(25));
        documentCard.setStyle("-fx-background-color:white;" +"-fx-background-radius:15;" +"-fx-border-color:#E5E7EB;" +"-fx-border-radius:15;");

        Label cardTitle = new Label( "Required Documents");
        cardTitle.setStyle("-fx-font-size:19px;" +"-fx-font-weight:bold;" +"-fx-text-fill:#333333;");

        Label cardDescription = new Label("Upload your documents in PDF format");
        cardDescription.setStyle("-fx-font-size:13px;" +"-fx-text-fill:#888888;" );

        VBox cardHeading = new VBox(4);
        cardHeading.getChildren().addAll(cardTitle,cardDescription);

        
        HBox aadhaar = createDocumentRow( stage,
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

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        Button saveButton = new Button("Save Documents");

        saveButton.setPrefWidth(170);
        saveButton.setPrefHeight(42);

        saveButton.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        buttonBox.getChildren().add(saveButton);

        
        content.getChildren().addAll(
                documentCard,
                buttonBox
        );

        mainArea.setCenter(content);
        root.setCenter(mainArea);

        
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

        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding( new Insets(15));
        row.setStyle(
                "-fx-background-color:#F8FAFC;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#E8EBEF;" +
                "-fx-border-radius:10;"
        );

        
        Label icon = new Label("📄");
        icon.setStyle("-fx-font-size:25px;");

        
        Label name = new Label(documentName);
        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        Label type = new Label( documentType);
        type.setStyle( "-fx-font-size:11px;" + "-fx-text-fill:#888888;" );

        VBox information = new VBox(3);
         information.setPrefWidth(200);

        information.getChildren().addAll(
                name,
                type
        );

        
        Label fileName = new Label( "No file selected" );

        fileName.setStyle("-fx-font-size:12px;" +"-fx-text-fill:#999999;");

       
        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        
        final File[] selectedFile = new File[1];

        
        Button previewButton = new Button("Preview" );
        previewButton.setPrefWidth(90);
        previewButton.setPrefHeight(34);

        previewButton.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;"
        );

        
        previewButton.setOnAction(e -> {

            if (selectedFile[0] != null) {

                try {

                    if (Desktop.isDesktopSupported()) {

                        Desktop.getDesktop().open(
                                selectedFile[0]
                        );

                    } else {

                        fileName.setText(
                                "Preview not supported"
                        );

                    }

                } catch (Exception ex) {

                    fileName.setText(
                            "Unable to open file"
                    );

                    ex.printStackTrace();
                }

            } else {

                fileName.setText(
                        "Please select a file first"
                );

                fileName.setStyle(
                        "-fx-font-size:12px;" +
                        "-fx-text-fill:red;"
                );
            }
        });

        
        Button chooseButton = new Button("Choose File");

        chooseButton.setPrefWidth(110);
        chooseButton.setPrefHeight(34);
        chooseButton.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:#4e342e;" +
                "-fx-border-radius:7;" +
                "-fx-background-radius:7;" +
                "-fx-text-fill:#4e342e;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );

        
        chooseButton.setOnAction(e -> { FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle( "Select " + documentName);

            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "PDF Files",
                            "*.pdf"
                    )
            );

            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {

                selectedFile[0] = file;

                fileName.setText(
                        file.getName()
                );

                fileName.setStyle(
                        "-fx-font-size:12px;" +
                        "-fx-text-fill:#4e342e;" +
                        "-fx-font-weight:bold;"
                );
            }
        });

         row.getChildren().addAll(
                icon,
                information,
                fileName,
                spacer,
                previewButton,
                chooseButton
        );

        return row;
    }
}