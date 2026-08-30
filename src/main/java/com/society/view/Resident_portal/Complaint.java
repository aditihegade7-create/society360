package com.society.view.Resident_portal;

import javafx.scene.layout.Region;

import com.google.cloud.firestore.Firestore;
import com.society.config.FirebaseConfig;
import com.society.controller.Resident_Controller.ComplaintController;
import com.society.dao.Resident_dao.ComplaintDAO;
import com.society.model.Resident_model.ComplaintModel;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Complaint {

    private final ComplaintController complaintController;

    // Change this later to logged-in resident flat
    private final String currentFlatNumber = "A-201";

    // Selected image file
    private java.io.File selectedFile;

    public Complaint() {

        Firestore firestore =
                FirebaseConfig.getFirestore();

        ComplaintDAO complaintDAO =
                new ComplaintDAO(firestore);

        complaintController =
                new ComplaintController(
                        complaintDAO
                );
    }

    public Scene getComplaintScene(Stage stage) {

        // ================= SIDEBAR =================
        panel panelobj = new panel(stage);

        // ================= ROOT =================
        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================
        HBox mainArea = new HBox(25);

        mainArea.setPadding(
                new Insets(25, 35, 25, 35)
        );

        mainArea.setStyle(
                "-fx-background-color: #e8ddd5"
        );

        // =================================================
        // LEFT SIDE - RAISE COMPLAINT FORM
        // =================================================

        VBox formBox = new VBox(15);

        formBox.setPrefWidth(500);

        Label title =
                new Label("Raise a Complaint");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        24
                )
        );

        title.setTextFill(
                Color.web("#172B4D")
        );

        Label subtitle =
                new Label(
                        "Report an issue to the society management"
                );

        subtitle.setTextFill(Color.GRAY);

        subtitle.setFont(
                Font.font("System", 13)
        );

        // ================= CATEGORY =================

        Label categoryLabel =
                new Label("Complaint Category");

        ComboBox<String> category =
                new ComboBox<>();

        category.setPromptText(
                "Select Category"
        );

        category.getItems().addAll(
                "Maintenance",
                "Water Supply",
                "Electricity",
                "Security",
                "Cleanliness",
                "Lift",
                "Parking",
                "Other"
        );

        category.setMaxWidth(
                Double.MAX_VALUE
        );

        category.setPrefHeight(38);

        // ================= TITLE =================

        Label complaintTitleLabel =
                new Label("Complaint Title");

        TextField complaintTitle =
                new TextField();

        complaintTitle.setPromptText(
                "Brief title of your complaint"
        );

        complaintTitle.setPrefHeight(38);

        // ================= DESCRIPTION =================

        Label descriptionLabel =
                new Label("Description");

        TextArea description =
                new TextArea();

        description.setPromptText(
                "Describe your issue in detail"
        );

        description.setPrefHeight(120);

        description.setWrapText(true);

        // ================= IMAGE =================

        Label imageLabel =
                new Label(
                        "Upload Image (Optional)"
                );

        Button chooseFile =
                new Button("Choose File");

        Label fileName =
                new Label("No file chosen");

        fileName.setTextFill(
                Color.GRAY
        );

        HBox fileBox =
                new HBox(10);

        fileBox.setAlignment(
                Pos.CENTER_LEFT
        );

        fileBox.getChildren().addAll(
                chooseFile,
                fileName
        );

        // ================= FILE CHOOSER =================

        chooseFile.setOnAction(e -> {

            javafx.stage.FileChooser fileChooser =
                    new javafx.stage.FileChooser();

            fileChooser.setTitle(
                    "Select Complaint Image"
            );

            selectedFile =
                    fileChooser.showOpenDialog(stage);

            if (selectedFile != null) {

                fileName.setText(
                        selectedFile.getName()
                );
            }
        });

        // ================= DATE =================

        Label dateLabel =
                new Label("Preferred Date");

        DatePicker preferredDate =
                new DatePicker();

        preferredDate.setPromptText(
                "Select date"
        );

        preferredDate.setMaxWidth(
                Double.MAX_VALUE
        );

        preferredDate.setPrefHeight(38);

        // ================= BUTTONS =================

        Button clearButton =
                new Button("Clear");

        clearButton.setPrefWidth(90);

        clearButton.setPrefHeight(35);

        clearButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D1D5DB;" +
                "-fx-border-radius: 5;" +
                "-fx-background-radius: 5;"
        );

        Button submitButton =
                new Button("Submit Complaint");

        submitButton.setPrefWidth(145);

        submitButton.setPrefHeight(35);

        submitButton.setStyle(
                "-fx-background-color: #0B4F8A;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 5;"
        );

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                clearButton,
                submitButton
        );

        // ================= CLEAR =================

        clearButton.setOnAction(e -> {

            category.setValue(null);

            complaintTitle.clear();

            description.clear();

            preferredDate.setValue(null);

            selectedFile = null;

            fileName.setText(
                    "No file chosen"
            );
        });

        // ================= SUBMIT =================

        submitButton.setOnAction(e -> {

            if (category.getValue() == null
                    || complaintTitle.getText().trim().isEmpty()
                    || description.getText().trim().isEmpty()
                    || preferredDate.getValue() == null) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.WARNING
                        );

                alert.setTitle(
                        "Missing Information"
                );

                alert.setHeaderText(null);

                alert.setContentText(
                        "Please fill all required fields."
                );

                alert.showAndWait();

            } else {

                try {

                    String date =
                            preferredDate
                                    .getValue()
                                    .toString();

                    String imageName = "";

                    if (selectedFile != null) {

                        imageName =
                                selectedFile.getName();
                    }

                    ComplaintModel complaint =
                            complaintController.submitComplaint(

                                    currentFlatNumber,

                                    category.getValue(),

                                    complaintTitle
                                            .getText()
                                            .trim(),

                                    description
                                            .getText()
                                            .trim(),

                                    imageName,

                                    date
                            );

                    Alert alert =
                            new Alert(
                                    Alert.AlertType.INFORMATION
                            );

                    alert.setTitle(
                            "Complaint Submitted"
                    );

                    alert.setHeaderText(null);

                    alert.setContentText(
                            "Your complaint has been submitted successfully."
                    );

                    alert.showAndWait();

                    // Clear form after successful submission
                    category.setValue(null);

                    complaintTitle.clear();

                    description.clear();

                    preferredDate.setValue(null);

                    selectedFile = null;

                    fileName.setText(
                            "No file chosen"
                    );

                } catch (Exception ex) {

                    ex.printStackTrace();

                    Alert alert =
                            new Alert(
                                    Alert.AlertType.ERROR
                            );

                    alert.setTitle(
                            "Error"
                    );

                    alert.setHeaderText(null);

                    alert.setContentText(
                            "Failed to save complaint:\n"
                                    + ex.getMessage()
                    );

                    alert.showAndWait();
                }
            }
        });

        formBox.getChildren().addAll(

                title,

                subtitle,

                categoryLabel,

                category,

                complaintTitleLabel,

                complaintTitle,

                descriptionLabel,

                description,

                imageLabel,

                fileBox,

                dateLabel,

                preferredDate,

                buttonBox
        );

        // =================================================
        // RIGHT SIDE - MY COMPLAINTS
        // =================================================

        VBox complaintsBox =
                new VBox(15);

        complaintsBox.setPrefWidth(400);

        Label myComplaints =
                new Label("My Complaints");

        myComplaints.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        18
                )
        );

        Label viewAll =
                new Label(
                        "View all your raised complaints"
                );

        viewAll.setTextFill(
                Color.GRAY
        );

        // Complaint 1
        VBox complaint1 =
                createComplaint(
                        "Lift not working",
                        "A-201",
                        "10 May 2025",
                        "In Progress",
                        "#FFF0D6",
                        "#D97706"
                );

        // Complaint 2
        VBox complaint2 =
                createComplaint(
                        "Water leakage in lobby",
                        "A-198",
                        "08 May 2025",
                        "Resolved",
                        "#DFF6E5",
                        "#16803C"
                );

        // Complaint 3
        VBox complaint3 =
                createComplaint(
                        "Garbage not cleared",
                        "A-192",
                        "02 May 2025",
                        "Closed",
                        "#EEF0F3",
                        "#6B7280"
                );

        complaintsBox.getChildren().addAll(

                myComplaints,

                viewAll,

                complaint1,

                complaint2,

                complaint3
        );

        // ================= ADD BOTH SIDES =================

        mainArea.getChildren().addAll(
                formBox,
                complaintsBox
        );

        Label newlLabel =
                new Label("Complaints ");

        newlLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        24
                )
        );

        newlLabel.setTextFill(
                Color.web("#172B4D")
        );

        BorderPane mainarea2 =
                new BorderPane();

        mainarea2.setTop(
                newlLabel
        );

        mainarea2.setCenter(
                mainArea
        );

        newlLabel.setStyle(
                "-fx-background-color: #765252"
        );

        root.setCenter(
                mainarea2
        );

        return new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );
    }

    // =====================================================
    // COMPLAINT CARD
    // =====================================================

    private VBox createComplaint(
            String title,
            String flat,
            String date,
            String status,
            String background,
            String textColor) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(15)
        );

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E5E7EB;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        Label details =
                new Label(
                        flat + "        " + date
                );

        details.setTextFill(
                Color.GRAY
        );

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-background-color: "
                        + background + ";" +
                "-fx-text-fill: "
                        + textColor + ";" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-background-radius: 12;"
        );

        HBox bottom =
                new HBox();

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                details,
                spacer,
                statusLabel
        );

        card.getChildren().addAll(
                titleLabel,
                bottom
        );

        return card;
    }
}
