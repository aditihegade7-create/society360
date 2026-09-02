package com.society.view.Resident_portal;

import javafx.scene.Scene;
import javafx.stage.Stage;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.FileChooser;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Document {

    public Scene getDocumentScene(Stage stage) {

        panel panelobj = new panel(stage);

        // ================= ROOT =================

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());


        // ================= MAIN CONTENT =================

        VBox mainContent = new VBox(20);
 mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setSpacing(20);
        mainContent.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        Document.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

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


        // ================= ADD DOCUMENT BUTTON =================

        Button addDocumentButton =
                new Button("+ Add Document");

        addDocumentButton.setPrefHeight(35);

        addDocumentButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );


        searchBox.getChildren().addAll(
                searchField,
                category,
                addDocumentButton
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
                "View",
                null
        );


        // Document 2

        VBox document2 = createDocument(
                "Maintenance Payment Receipt",
                "Financial",
                "Issued: 05 August 2026",
                "Available",
                "View",
                null
        );


        // Document 3

        VBox document3 = createDocument(
                "Resident ID Card",
                "Personal",
                "Issued: 01 August 2026",
                "Available",
                "View",
                null
        );


        // Document 4

        VBox document4 = createDocument(
                "Parking Allotment Letter",
                "Society",
                "Issued: 25 July 2026",
                "Available",
                "View",
                null
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


        // ================= ADD DOCUMENT ACTION =================

        addDocumentButton.setOnAction(e -> {

            FileChooser fileChooser =
                    new FileChooser();

            fileChooser.setTitle(
                    "Select Document"
            );


            // Allow common document formats

            FileChooser.ExtensionFilter extensionFilter =
                    new FileChooser.ExtensionFilter(
                            "Documents and Images",
                            "*.pdf",
                            "*.doc",
                            "*.docx",
                            "*.txt",
                            "*.jpg",
                            "*.jpeg",
                            "*.png"
                    );

            fileChooser.getExtensionFilters().add(
                    extensionFilter
            );


            // Open file chooser

            File selectedFile =
                    fileChooser.showOpenDialog(stage);


            if (selectedFile != null) {

                // ================= DOCUMENT TYPE =================

                ChoiceDialog<String> typeDialog =
                        new ChoiceDialog<>(
                                "Personal",
                                "Personal",
                                "Society",
                                "Financial",
                                "Other"
                        );

                typeDialog.setTitle(
                        "Document Type"
                );

                typeDialog.setHeaderText(
                        "Select Document Type"
                );

                typeDialog.setContentText(
                        "Document Type:"
                );


                typeDialog.showAndWait().ifPresent(
                        selectedType -> {

                            String fileName =
                                    selectedFile.getName();


                            String currentDate =
                                    LocalDate.now().format(
                                            DateTimeFormatter.ofPattern(
                                                    "dd MMMM yyyy"
                                            )
                                    );


                            // ================= CREATE NEW CARD =================

                            VBox newDocument =
                                    createDocument(
                                            fileName,
                                            selectedType,
                                            "Uploaded: " + currentDate,
                                            "Available",
                                            "View",
                                            selectedFile
                                    );


                            // Add uploaded document at top

                            documentList
                                    .getChildren()
                                    .add(
                                            0,
                                            newDocument
                                    );


                            // Success message

                            Alert alert =
                                    new Alert(
                                            Alert.AlertType.INFORMATION
                                    );

                            alert.setTitle(
                                    "Document Uploaded"
                            );

                            alert.setHeaderText(
                                    "Upload Successful"
                            );

                            alert.setContentText(
                                    fileName +
                                    "\n\nYour document has been added to the document list."
                            );

                            alert.showAndWait();

                        }
                );
            }
        });


        // ================= SEARCH FUNCTION =================

        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    String searchText =
                            newValue.toLowerCase();

                    for (javafx.scene.Node node :
                            documentList.getChildren()) {

                        VBox card =
                                (VBox) node;

                        String cardText =
                                card.getUserData() != null
                                ? card.getUserData().toString().toLowerCase()
                                : "";

                        card.setVisible(
                                cardText.contains(searchText)
                        );

                        card.setManaged(
                                cardText.contains(searchText)
                        );
                    }
                }
        );


        // ================= CATEGORY FILTER =================

        category.setOnAction(e -> {

            String selectedCategory =
                    category.getValue();


            if (selectedCategory == null ||
                    selectedCategory.equals("All")) {

                for (javafx.scene.Node node :
                        documentList.getChildren()) {

                    node.setVisible(true);
                    node.setManaged(true);
                }

                return;
            }


            for (javafx.scene.Node node :
                    documentList.getChildren()) {

                VBox card =
                        (VBox) node;

                String cardText =
                        card.getUserData() != null
                        ? card.getUserData().toString()
                        : "";

                boolean match =
                        cardText.contains(
                                selectedCategory
                        );

                card.setVisible(match);
                card.setManaged(match);
            }
        });


        // ================= ADD CONTENT =================

        mainContent.getChildren().addAll(
                heading,
                searchBox,
                scrollPane
        );


        BorderPane mainarea =
                new BorderPane();

        mainarea.setTop(heading);

        mainarea.setCenter(mainContent);


        root.setCenter(mainarea);


        return new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }


    // =====================================================
    // DOCUMENT CARD
    // =====================================================

    private VBox createDocument(
            String documentName,
            String documentType,
            String date,
            String status,
            String buttonText,
            File uploadedFile) {


        VBox card =
                new VBox(10);


        // Store information for search/filter

        card.setUserData(
                documentName +
                " " +
                documentType
        );


        card.setPadding(
                new Insets(18)
        );


        card.setMaxWidth(
                Double.MAX_VALUE
        );


        // ================= WHITE CARD =================

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


        // ================= VIEW BUTTON =================

        Button viewButton =
                new Button("View");


        viewButton.setStyle(
                "-fx-background-color: #789098;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );


        viewButton.setOnAction(e -> {

            // If this is an uploaded document

            if (uploadedFile != null) {

                try {

                    if (Desktop.isDesktopSupported()) {

                        Desktop.getDesktop().open(
                                uploadedFile
                        );

                    } else {

                        showAlert(
                                "View Document",
                                "Your system does not support opening files automatically."
                        );
                    }

                } catch (IOException ex) {

                    showAlert(
                            "Error",
                            "Unable to open the document."
                    );
                }

            } else {

                // Existing sample documents

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );

                alert.setTitle(
                        "Document"
                );

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
            }
        });


        // ================= DOWNLOAD BUTTON =================

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

            if (uploadedFile != null) {

                FileChooser saveChooser =
                        new FileChooser();

                saveChooser.setTitle(
                        "Save Document"
                );


                saveChooser.setInitialFileName(
                        uploadedFile.getName()
                );


                File saveFile =
                        saveChooser.showSaveDialog(
                                null
                        );


                if (saveFile != null) {

                    try {

                        Files.copy(
                                uploadedFile.toPath(),
                                saveFile.toPath(),
                                StandardCopyOption.REPLACE_EXISTING
                        );


                        showAlert(
                                "Download",
                                "Document downloaded successfully."
                        );


                    } catch (IOException ex) {

                        showAlert(
                                "Error",
                                "Unable to download the document."
                        );
                    }
                }

            } else {

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );

                alert.setTitle(
                        "Download"
                );

                alert.setHeaderText(
                        documentName
                );

                alert.setContentText(
                        "This is a sample document.\n"
                        + "No actual file is attached."
                );

                alert.showAndWait();
            }
        });


        // ================= BUTTON BOX =================

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


    // =====================================================
    // ALERT METHOD
    // =====================================================

    private void showAlert(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}