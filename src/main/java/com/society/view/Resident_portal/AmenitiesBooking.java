package com.society.view.Resident_portal;

import com.society.controller.Resident_Controller.AmenitiesController;
import com.society.model.Resident_model.Amenities;
import com.society.service.resident_service.RazorpayService;
import com.society.view.ScreenSize;

import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

public class AmenitiesBooking {

    private VBox cardsContainer;

    private final AmenitiesController amenitiesController;
    private final RazorpayService razorpay;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public AmenitiesBooking() {

        amenitiesController = new AmenitiesController();

        razorpay = new RazorpayService();
    }

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getAminityScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        panel panelobj = new panel(stage);

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root = new BorderPane();

        root.setLeft(panelobj.getSidebar());

        // =====================================================
        // MAIN AREA
        // =====================================================

        BorderPane mainArea = new BorderPane();

        // =====================================================
        // HEADER
        // =====================================================

        VBox heading = new VBox(3);

        heading.setPadding(
                new Insets(5, 0, 8, 0)
        );

        heading.setStyle(
                "-fx-background-color: #4e342e;"
        );

        Label title = new Label(
                "Book Amenity"
        );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(
                Color.web("#0d2b52")
        );

        Label subtitle = new Label(
                "Reserve society amenities"
        );

        subtitle.setFont(
                Font.font(
                        "System",
                        14
                )
        );

        subtitle.setTextFill(
                Color.web("#9e9e9e")
        );

        heading.getChildren().addAll(
                title,
                subtitle
        );

        mainArea.setTop(heading);

        // =====================================================
        // CONTENT
        // =====================================================

        VBox content = new VBox(20);

        content.setPadding(
                new Insets(
                        27,
                        38,
                        30,
                        38
                )
        );

        content.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // CARDS CONTAINER
        // =====================================================

        cardsContainer = new VBox(15);

        loadAmenities();

        // =====================================================
        // UPCOMING BOOKING
        // =====================================================

        VBox upcomingSection = createUpcomingBooking();

        content.getChildren().addAll(
                cardsContainer,
                upcomingSection
        );

        VBox.setVgrow(
                cardsContainer,
                Priority.ALWAYS
        );

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setStyle(
                "-fx-background: #e8ddd5;" +
                "-fx-background-color: #e8ddd5;"
        );

        mainArea.setCenter(scrollPane);

        // =====================================================
        // SET MAIN AREA
        // =====================================================

        root.setCenter(mainArea);

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        return scene;
    }

    // =========================================================
    // LOAD AMENITIES FROM FIRESTORE
    // =========================================================

    private void loadAmenities() {

        cardsContainer.getChildren().clear();

        List<Amenities> amenities =
                amenitiesController.getAmenities();

        if (amenities == null ||
                amenities.isEmpty()) {

            Label empty = new Label(
                    "No amenities available."
            );

            empty.setFont(
                    Font.font(
                            "System",
                            FontWeight.BOLD,
                            16
                    )
            );

            cardsContainer.getChildren().add(
                    empty
            );

            return;
        }

        // =====================================================
        // GRID
        // =====================================================

        GridPane grid = new GridPane();

        grid.setHgap(16);

        grid.setVgap(16);

        grid.setPadding(
                new Insets(0)
        );

        // Three equal columns

        for (int i = 0; i < 3; i++) {

            ColumnConstraints column =
                    new ColumnConstraints();

            column.setPercentWidth(33.33);

            column.setHgrow(
                    Priority.ALWAYS
            );

            grid.getColumnConstraints()
                    .add(column);
        }

        // =====================================================
        // ADD CARDS
        // =====================================================

        int row = 0;
        int column = 0;

        for (Amenities amenity : amenities) {

            VBox card =
                    createAmenityCard(
                            amenity
                    );

            grid.add(
                    card,
                    column,
                    row
            );

            GridPane.setHgrow(
                    card,
                    Priority.ALWAYS
            );

            column++;

            if (column == 3) {

                column = 0;

                row++;
            }
        }

        cardsContainer.getChildren()
                .add(grid);
    }

    // =========================================================
    // AMENITY CARD
    // =========================================================

    private VBox createAmenityCard(
            Amenities amenity) {

        VBox card = new VBox(9);

        card.setPadding(
                new Insets(16)
        );

        card.setMinHeight(148);

        card.setPrefHeight(148);

        card.setMaxHeight(170);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label name = new Label(
                amenity.getAmenityName()
        );

        name.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        16
                )
        );

        name.setTextFill(
                Color.web("#0d2b52")
        );

        // =====================================================
        // PRICE
        // =====================================================

        Label price = new Label(
                formatPrice(
                        amenity.getPrice()
                )
        );

        price.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        price.setTextFill(
                Color.web("#263238")
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label description = new Label(
                amenity.getDescription()
        );

        description.setWrapText(true);

        description.setTextFill(
                Color.web("#789098")
        );

        description.setFont(
                Font.font(
                        "System",
                        13
                )
        );

        // =====================================================
        // BOTTOM ROW
        // =====================================================

        HBox bottomRow = new HBox(10);

        bottomRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label availability = new Label(
                amenity.getAvailability()
        );

        availability.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        availability.setTextFill(
                Color.web("#00843D")
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button bookButton =
                new Button("Book");

        bookButton.setPrefWidth(76);

        bookButton.setPrefHeight(30);

        bookButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;"
        );

        bookButton.setOnAction(
                e -> showBookingDialog(
                        amenity
                )
        );

        bottomRow.getChildren().addAll(
                availability,
                spacer,
                bookButton
        );

        card.getChildren().addAll(
                name,
                price,
                description,
                bottomRow
        );

        return card;
    }

    // =========================================================
    // FORMAT PRICE
    // =========================================================

    private String formatPrice(
            String price) {

        if (price == null ||
                price.trim().isEmpty()) {

            return "₹ 0";
        }

        String number =
                price.replaceAll(
                        "[^0-9.]",
                        ""
                );

        if (number.isEmpty()) {

            return price;
        }

        return "₹ " + number;
    }

    // =========================================================
    // BOOKING DIALOG
    // =========================================================

    private void showBookingDialog(
            Amenities amenity) {

        VBox box = new VBox(15);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPadding(
                new Insets(25)
        );

        box.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label(
                "Book " +
                amenity.getAmenityName()
        );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setTextFill(
                Color.web("#4e342e")
        );

        // =====================================================
        // DATE
        // =====================================================

        Label dateLabel =
                new Label("Select Date");

        dateLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        DatePicker datePicker =
                new DatePicker();

        datePicker.setValue(
                LocalDate.now()
        );

        datePicker.setPrefWidth(250);

        // =====================================================
        // TIME SLOT
        // =====================================================

        Label timeLabel =
                new Label("Select Time Slot");

        timeLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        ComboBox<String> timeSlot =
                new ComboBox<>();

        timeSlot.getItems().addAll(

                "08:00 AM - 10:00 AM",

                "10:00 AM - 12:00 PM",

                "12:00 PM - 02:00 PM",

                "02:00 PM - 04:00 PM",

                "04:00 PM - 06:00 PM",

                "06:00 PM - 08:00 PM"
        );

        timeSlot.setPromptText(
                "Select time slot"
        );

        timeSlot.setPrefWidth(250);

        // =====================================================
        // PAYMENT BUTTON
        // =====================================================

        Button paymentButton =
                new Button(
                        "Continue to Payment"
                );

        paymentButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20;" +
                "-fx-background-radius: 6;"
        );

        // =====================================================
        // POPUP
        // =====================================================

        Stage popup = new Stage();

        popup.setTitle(
                "Book Amenity"
        );

        Scene scene = new Scene(
                box,
                400,
                420
        );

        popup.setScene(scene);

        // =====================================================
        // PAYMENT BUTTON ACTION
        // =====================================================

        paymentButton.setOnAction(
                e -> {

                    if (datePicker.getValue()
                            == null) {

                        showError(
                                "Please select date."
                        );

                        return;
                    }

                    if (timeSlot.getValue()
                            == null) {

                        showError(
                                "Please select time slot."
                        );

                        return;
                    }

                    String selectedSlot =
                            timeSlot.getValue();

                    String[] times =
                            selectedSlot.split(
                                    " - "
                            );

                    String startTime =
                            times[0];

                    String endTime =
                            times[1];

                    popup.close();

                    startPayment(
                            amenity,
                            datePicker
                                    .getValue()
                                    .toString(),
                            startTime,
                            endTime
                    );
                }
        );

        box.getChildren().addAll(

                title,

                dateLabel,

                datePicker,

                timeLabel,

                timeSlot,

                paymentButton
        );

        popup.show();
    }

    // =========================================================
    // START PAYMENT
    // =========================================================

    private void startPayment(

            Amenities amenity,

            String bookingDate,

            String startTime,

            String endTime) {

        double amount;

        try {

            String price =
                    amenity.getPrice();

            String number =
                    price.replaceAll(
                            "[^0-9.]",
                            ""
                    );

            amount =
                    Double.parseDouble(
                            number
                    );

        } catch (Exception e) {

            showError(
                    "Invalid amenity price: " +
                    amenity.getPrice()
            );

            return;
        }

        // =====================================================
        // PROCESSING WINDOW
        // =====================================================

        Stage processingStage =
                createProcessingStage();

        processingStage.show();

        // =====================================================
        // RAZORPAY TASK
        // =====================================================

        final double finalAmount =
                amount;

        Task<String> paymentTask =
                new Task<>() {

                    @Override
                    protected String call()
                            throws Exception {

                        return razorpay
                                .createPaymentLink(
                                        finalAmount,
                                        amenity
                                                .getAmenityName()
                                                + " Booking"
                                );
                    }
                };

        // =====================================================
        // SUCCESS
        // =====================================================

        paymentTask.setOnSucceeded(
                e -> {

                    processingStage.close();

                    String paymentUrl =
                            paymentTask.getValue();

                    try {

                        razorpay.openPaymentPage(
                                paymentUrl
                        );

                        showPaymentWaiting(
                                amenity,
                                bookingDate,
                                startTime,
                                endTime,
                                finalAmount
                        );

                    } catch (Exception ex) {

                        ex.printStackTrace();

                        showError(
                                "Unable to open Razorpay payment page."
                        );
                    }
                }
        );

        // =====================================================
        // FAILED
        // =====================================================

        paymentTask.setOnFailed(
                e -> {

                    processingStage.close();

                    Throwable error =
                            paymentTask
                                    .getException();

                    if (error != null) {

                        error.printStackTrace();
                    }

                    showError(
                            "Unable to create Razorpay payment.\n\n"
                            +
                            "Please check your Razorpay Key ID "
                            +
                            "and Key Secret."
                    );
                }
        );

        Thread thread =
                new Thread(
                        paymentTask
                );

        thread.setDaemon(true);

        thread.start();
    }

    // =========================================================
    // PAYMENT PROCESSING WINDOW
    // =========================================================

    private Stage createProcessingStage() {

        VBox box = new VBox(18);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPadding(
                new Insets(30)
        );

        box.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        Label title =
                new Label(
                        "Creating Payment..."
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        22
                )
        );

        title.setTextFill(
                Color.web("#4e342e")
        );

        ProgressIndicator progress =
                new ProgressIndicator();

        Label message =
                new Label(
                        "Please wait while we connect to Razorpay."
                );

        message.setWrapText(true);

        box.getChildren().addAll(
                title,
                progress,
                message
        );

        Stage stage = new Stage();

        stage.setTitle(
                "Payment"
        );

        stage.setScene(
                new Scene(
                        box,
                        400,
                        250
                )
        );

        stage.setResizable(false);

        return stage;
    }

    // =========================================================
    // PAYMENT WAITING
    // =========================================================

    private void showPaymentWaiting(

            Amenities amenity,

            String bookingDate,

            String startTime,

            String endTime,

            double amount) {

        VBox box = new VBox(18);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPadding(
                new Insets(30)
        );

        box.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        Label title =
                new Label(
                        "Payment Processing"
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        24
                )
        );

        title.setTextFill(
                Color.web("#4e342e")
        );

        ProgressIndicator progress =
                new ProgressIndicator();

        Label message =
                new Label(
                        "Razorpay payment page has been opened.\n\n"
                        +
                        "Complete your UPI payment there.\n"
                        +
                        "After successful payment, come back here."
                );

        message.setWrapText(true);

        message.setAlignment(
                Pos.CENTER
        );

        Label amountLabel =
                new Label(
                        "Amount: ₹ " +
                        amount
                );

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        16
                )
        );

        // =====================================================
        // COMPLETED BUTTON
        // =====================================================

        Button completedButton =
                new Button(
                        "I Have Completed Payment"
                );

        completedButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 25;" +
                "-fx-background-radius: 6;"
        );

        // =====================================================
        // CANCEL
        // =====================================================

        Button cancelButton =
                new Button(
                        "Cancel"
                );

        cancelButton.setStyle(
                "-fx-background-color: #eeeeee;" +
                "-fx-text-fill: #333333;" +
                "-fx-padding: 10 25;"
        );

        HBox buttons =
                new HBox(
                        10,
                        completedButton,
                        cancelButton
                );

        buttons.setAlignment(
                Pos.CENTER
        );

        box.getChildren().addAll(

                title,

                progress,

                message,

                amountLabel,

                buttons
        );

        Stage stage = new Stage();

        stage.setTitle(
                "Razorpay Payment"
        );

        stage.setScene(
                new Scene(
                        box,
                        550,
                        420
                )
        );

        stage.setResizable(false);

        // =====================================================
        // COMPLETED
        // =====================================================

        completedButton.setOnAction(
                e -> {

                    stage.close();

                    verifyPaymentAndSave(
                            amenity,
                            bookingDate,
                            startTime,
                            endTime,
                            amount
                    );
                }
        );

        // =====================================================
        // CANCEL
        // =====================================================

        cancelButton.setOnAction(
                e -> {

                    stage.close();

                    showPaymentFailed();
                }
        );

        stage.show();
    }

    // =========================================================
    // VERIFY PAYMENT
    // =========================================================

    private void verifyPaymentAndSave(

            Amenities amenity,

            String bookingDate,

            String startTime,

            String endTime,

            double amount) {

        Alert alert =
                new Alert(
                        Alert.AlertType.CONFIRMATION
                );

        alert.setTitle(
                "Payment Verification"
        );

        alert.setHeaderText(
                "Was your payment successful?"
        );

        alert.setContentText(
                "Confirm only if Razorpay shows that your UPI payment was successful."
        );

        alert.showAndWait()
                .ifPresent(result -> {

                    if (result ==
                            javafx.scene.control.ButtonType.OK) {

                        saveBooking(
                                amenity,
                                bookingDate,
                                startTime,
                                endTime,
                                amount
                        );

                    } else {

                        showPaymentFailed();
                    }
                });
    }

    // =========================================================
    // SAVE BOOKING
    // =========================================================

    private void saveBooking(

            Amenities amenity,

            String bookingDate,

            String startTime,

            String endTime,

            double amount) {

        try {

            String bookingId =
                    amenitiesController.saveBooking(

                            amenity,

                            bookingDate,

                            startTime,

                            endTime,

                            "CONFIRMED",

                            "SUCCESS",

                            String.valueOf(
                                    amount
                            )
                    );

            if (bookingId != null) {

                showPaymentSuccess(
                        bookingId
                );

                loadAmenities();

            } else {

                showError(
                        "Payment completed but booking could not be saved."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            showError(
                    "Error while saving booking."
            );
        }
    }

    // =========================================================
    // UPCOMING BOOKING
    // =========================================================

    private VBox createUpcomingBooking() {

        VBox section =
                new VBox(15);

        Label title =
                new Label(
                        "Upcoming Booking"
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        18
                )
        );

        title.setTextFill(
                Color.web("#263238")
        );

        HBox booking =
                new HBox(20);

        booking.setAlignment(
                Pos.CENTER_LEFT
        );

        booking.setPadding(
                new Insets(18)
        );

        booking.setMinHeight(62);

        booking.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 8;"
        );

        Label amenity =
                new Label(
                        "Community Hall"
                );

        amenity.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        14
                )
        );

        Label date =
                new Label(
                        "17 May 2025"
                );

        Label time =
                new Label(
                        "06:00 PM - 10:00 PM"
                );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label status =
                new Label(
                        "Confirmed"
                );

        status.setPadding(
                new Insets(
                        8,
                        12,
                        8,
                        12
                )
        );

        status.setStyle(
                "-fx-background-color: #d8f3df;" +
                "-fx-text-fill: #16823b;" +
                "-fx-background-radius: 15;"
        );

        booking.getChildren().addAll(
                amenity,
                date,
                time,
                spacer,
                status
        );

        section.getChildren().addAll(
                title,
                booking
        );

        return section;
    }

    // =========================================================
    // SUCCESS
    // =========================================================

    private void showPaymentSuccess(
            String bookingId) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "Booking Successful"
        );

        alert.setHeaderText(
                "✓ Payment Successful"
        );

        alert.setContentText(
                "Your amenity has been booked successfully.\n\n"
                +
                "Booking ID: " +
                bookingId
        );

        alert.showAndWait();
    }

    // =========================================================
    // PAYMENT FAILED
    // =========================================================

    private void showPaymentFailed() {

        Alert alert =
                new Alert(
                        Alert.AlertType.WARNING
                );

        alert.setTitle(
                "Payment"
        );

        alert.setHeaderText(
                "Payment Not Completed"
        );

        alert.setContentText(
                "Your amenity has not been booked."
        );

        alert.showAndWait();
    }

    // =========================================================
    // ERROR
    // =========================================================

    private void showError(
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.ERROR
                );

        alert.setTitle(
                "Error"
        );

        alert.setHeaderText(null);

        alert.setContentText(
                message
        );

        alert.showAndWait();
    }
}