package com.society.view.Resident_portal;

import javafx.scene.Scene;
import javafx.stage.Stage;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Document {

    public Scene getDocumentScene(Stage stage) {





    

        panel panelobj = new panel(stage);

        // ================= ROOT =================

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30, 40, 30, 40)
        );

        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

        // ================= HEADING =================

        Label title = new Label("Documents");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);

        Label subtitle = new Label(
                "Access and manage your society documents"
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

        // ================= SEARCH =================

        HBox searchBox = new HBox(12);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search documents..."
        );

        searchField.setPrefWidth(280);
        searchField.setPrefHeight(35);

        ComboBox<String> category =
                new ComboBox<>();

        category.setPromptText(
                "Document Type"
        );

        category.getItems().addAll(
                "All",
                "Personal",
                "Society",
                "Financial",
                "Other"
        );

        category.setPrefWidth(170);
        category.setPrefHeight(35);

        searchBox.getChildren().addAll(
                searchField,
                category
        );

        // ================= DOCUMENT LIST =================

        VBox documentList =
                new VBox(15);

        // Document 1
        VBox document1 = createDocument(
                "Society Membership Certificate",
                "Society",
                "Issued: 10 August 2026",
                "Available",
                "View"
        );

        // Document 2
        VBox document2 = createDocument(
                "Maintenance Payment Receipt",
                "Financial",
                "Issued: 05 August 2026",
                "Available",
                "View"
        );

        // Document 3
        VBox document3 = createDocument(
                "Resident ID Card",
                "Personal",
                "Issued: 01 August 2026",
                "Available",
                "View"
        );

        // Document 4
        VBox document4 = createDocument(
                "Parking Allotment Letter",
                "Society",
                "Issued: 25 July 2026",
                "Available",
                "View"
        );

        documentList.getChildren().addAll(
                document1,
                document2,
                document3,
                document4
        );

        // ================= SCROLL =================

        ScrollPane scrollPane =
                new ScrollPane(documentList);

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        // ================= ADD CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                searchBox,
                scrollPane
        );

        root.setCenter(mainContent);

        return new Scene(
                root,
                 ScreenSize.getWidth(),
                ScreenSize.getHeight());
        
    }

    // =====================================================
    // DOCUMENT CARD
    // =====================================================

    private VBox createDocument(
            String documentName,
            String documentType,
            String date,
            String status,
            String buttonText) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(18)
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        // Separate white box
        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #E0E0E0;" +
                "-fx-border-radius: 10;"
        );

        // ================= TOP ROW =================

        HBox topRow =
                new HBox();

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label documentLabel =
                new Label(documentName);

        documentLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        documentLabel.setTextFill(
                Color.web("#263238")
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 5 12 5 12;" +
                "-fx-background-radius: 15;" +
                "-fx-font-weight: bold;"
        );

        topRow.getChildren().addAll(
                documentLabel,
                spacer,
                statusLabel
        );

        // ================= DETAILS =================

        HBox details =
                new HBox(15);

        Label typeLabel =
                new Label(documentType);

        typeLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        typeLabel.setTextFill(
                Color.web("#546E7A")
        );

        Label dateLabel =
                new Label(date);

        dateLabel.setFont(
                Font.font("System", 13)
        );

        dateLabel.setTextFill(
                Color.GRAY
        );

        details.getChildren().addAll(
                typeLabel,
                dateLabel
        );

        // ================= BUTTONS =================

        Button viewButton =
                new Button("View");

        viewButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        viewButton.setOnAction(e -> {

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Document");

            alert.setHeaderText(
                    documentName
            );

            alert.setContentText(
                    "Document Type: "
                    + documentType
                    + "\n"
                    + date
                    + "\nStatus: "
                    + status
            );

            alert.showAndWait();
        });

        Button downloadButton =
                new Button("Download");

        downloadButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #789098;" +
                "-fx-border-color: #789098;" +
                "-fx-border-radius: 5;" +
                "-fx-font-weight: bold;"
        );

        downloadButton.setOnAction(e -> {

            Alert alert =
                    new Alert(
                            Alert.AlertType.INFORMATION
                    );

            alert.setTitle("Download");

            alert.setHeaderText(
                    documentName
            );

            alert.setContentText(
                    "Download option selected."
            );

            alert.showAndWait();
        });

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                viewButton,
                downloadButton
        );

        // ================= ADD EVERYTHING =================

        card.getChildren().addAll(
                topRow,
                details,
                buttonBox
        );

        return card;
    }
}