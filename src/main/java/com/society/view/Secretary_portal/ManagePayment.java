package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.society.controller.Secretary_Controller.PaymentController;
import com.society.model.Secretary_model.Payment;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagePayment {

    // =========================================================
    // SCENE
    // =========================================================

    private Scene managePaymentScene;

    // =========================================================
    // CONTROLLER
    // =========================================================

    private PaymentController paymentController;

    // =========================================================
    // BOOKING LIST
    // =========================================================

    private VBox bookingList;

    // =========================================================
    // AMENITY GRID
    // =========================================================

    private GridPane amenityGrid;

    // =========================================================
    // DATE FORMAT
    // =========================================================

    private final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd MMM yyyy");

    // =========================================================
    // TIME FORMAT
    // =========================================================

    private final DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("hh:mm a");

    // =========================================================
    // CREATE SCENE
    // =========================================================

    public Scene createScene(Stage stage) {

        // =====================================================
        // CONTROLLER
        // =====================================================

        paymentController =
                new PaymentController();

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb =
                new VBox(14);

        mainvb.setPadding(
                new Insets(22, 25, 20, 25)
        );

        mainvb.setMaxWidth(
                Double.MAX_VALUE
        );

        mainvb.setMaxHeight(
                Double.MAX_VALUE
        );

        mainvb.setStyle(
                "-fx-background-color:#E8DDD3;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading =
                new Label("Manage Payment");

        heading.setStyle(
                "-fx-font-size:26px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#24456D;"
        );

        Label subtitle =
                new Label(
                        "Manage society amenities bookings and payments"
                );

        subtitle.setStyle(
                "-fx-font-size:15px;" +
                "-fx-text-fill:#666666;"
        );

        VBox headingBox =
                new VBox(4);

        headingBox.getChildren().addAll(
                heading,
                subtitle
        );

        // =====================================================
        // HEADING AREA
        // =====================================================

        VBox headingArea =
                new VBox();

        headingArea.setMaxWidth(
                Double.MAX_VALUE
        );

        headingArea.getChildren().add(
                headingBox
        );

        // =====================================================
        // ADD AMENITY BUTTON
        // =====================================================

        Button addAmenityButton =
                new Button("+ Add Amenity");

        addAmenityButton.setPrefWidth(150);

        addAmenityButton.setPrefHeight(40);

        addAmenityButton.setStyle(
                "-fx-background-color:#56342B;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:14px;" +
                "-fx-background-radius:7;"
        );

        addAmenityButton.setOnAction(
                e -> openAddAmenityPopup()
        );

        // =====================================================
        // ADD AMENITY BUTTON BOX
        // BUTTON IS BELOW HEADING AND ON RIGHT
        // =====================================================

        HBox addAmenityBox =
                new HBox();

        addAmenityBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        addAmenityBox.setMaxWidth(
                Double.MAX_VALUE
        );

        addAmenityBox.getChildren().add(
                addAmenityButton
        );

        // =====================================================
        // AMENITIES TITLE
        // =====================================================

        Label amenitiesTitle =
                new Label("Amenities");

        amenitiesTitle.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        // =====================================================
        // AMENITY GRID
        // =====================================================

        amenityGrid =
                new GridPane();

        amenityGrid.setHgap(12);

        amenityGrid.setVgap(12);

        amenityGrid.setMaxWidth(
                Double.MAX_VALUE
        );

        // =====================================================
        // COLUMN WIDTH
        // =====================================================

        for (int i = 0; i < 6; i++) {

            ColumnConstraints column =
                    new ColumnConstraints();

            column.setPercentWidth(
                    16.66
            );

            amenityGrid
                    .getColumnConstraints()
                    .add(column);
        }

        // =====================================================
        // LOAD AMENITIES
        // =====================================================

        loadAmenities();

        // =====================================================
        // SEPARATOR
        // =====================================================

        Separator separator =
                new Separator();

        separator.setMaxWidth(
                Double.MAX_VALUE
        );

        // =====================================================
        // UPCOMING TITLE
        // =====================================================

        Label upcomingTitle =
                new Label(
                        "Upcoming Bookings"
                );

        upcomingTitle.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        // =====================================================
        // REFRESH BUTTON
        // =====================================================

        Button refreshButton =
                new Button("⟳ Refresh");

        refreshButton.setPrefHeight(38);

        refreshButton.setPrefWidth(110);

        refreshButton.setStyle(
                "-fx-background-color:#56342B;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;"
        );

        refreshButton.setOnAction(
                e -> {

                    loadBookings();

                    loadAmenities();
                }
        );

        // =====================================================
        // BOOKING HEADER
        // REFRESH BUTTON RIGHT SIDE
        // =====================================================

        HBox bookingHeader =
                new HBox();

        bookingHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        bookingHeader.setMaxWidth(
                Double.MAX_VALUE
        );

        HBox.setHgrow(
                upcomingTitle,
                Priority.ALWAYS
        );

        bookingHeader.getChildren().addAll(
                upcomingTitle,
                refreshButton
        );

        // =====================================================
        // BOOKING LIST
        // =====================================================

        bookingList =
                new VBox(8);

        bookingList.setPadding(
                new Insets(5)
        );

        bookingList.setFillWidth(true);

        bookingList.setMaxWidth(
                Double.MAX_VALUE
        );

        // =====================================================
        // LOAD BOOKINGS
        // =====================================================

        loadBookings();

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane bookingScroll =
                new ScrollPane();

        bookingScroll.setContent(
                bookingList
        );

        bookingScroll.setFitToWidth(true);

        bookingScroll.setFitToHeight(false);

        bookingScroll.setPrefHeight(300);

        bookingScroll.setMaxHeight(300);

        bookingScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        bookingScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        bookingScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =====================================================
        // FOOTER
        // =====================================================

        Label footer =
                new Label(
                        "All booking details are synced with society records."
                );

        footer.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        HBox footerBox =
                new HBox();

        footerBox.setAlignment(
                Pos.CENTER
        );

        footerBox.getChildren().add(
                footer
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(

                // Heading
                headingArea,

                // Add Amenity below heading - right side
                addAmenityBox,

                // Amenities
                amenitiesTitle,

                amenityGrid,

                separator,

                // Upcoming + Refresh
                bookingHeader,

                bookingScroll,

                footerBox
        );

        // =====================================================
        // ROOT
        // =====================================================

        HBox mainRoot =
                new HBox();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =====================================================
        // STACK ROOT
        // =====================================================

        StackPane root =
                new StackPane();

        root.getChildren().add(
                mainRoot
        );

        // =====================================================
        // SCENE
        // =====================================================

        managePaymentScene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        return managePaymentScene;
    }

    // =========================================================
    // LOAD AMENITIES
    // =========================================================

    private void loadAmenities() {

        if (amenityGrid == null) {
            return;
        }

        amenityGrid.getChildren().clear();

        List<Payment> amenities =
                paymentController.getAllAmenities();

        if (amenities == null
                || amenities.isEmpty()) {

            addDefaultAmenityCards();

            return;
        }

        int column = 0;

        int row = 0;

        int validCount = 0;

        for (Payment amenity : amenities) {

            if (amenity == null) {
                continue;
            }

            VBox card =
                    createAmenityCard(
                            safe(
                                    amenity.getAmenityName()
                            ),
                            safe(
                                    amenity.getPrice()
                            ),
                            safe(
                                    amenity.getDescription()
                            ),
                            safe(
                                    amenity.getAvailability()
                            )
                    );

            amenityGrid.add(
                    card,
                    column,
                    row
            );

            column++;

            validCount++;

            if (column == 6) {

                column = 0;

                row++;
            }
        }

        if (validCount == 0) {

            addDefaultAmenityCards();
        }
    }

    // =========================================================
    // DEFAULT AMENITY CARDS
    // =========================================================

    private void addDefaultAmenityCards() {

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );

        addAmenityCardToGrid(
                "",
                "",
                "",
                ""
        );
    }

    // =========================================================
    // ADD CARD TO GRID
    // =========================================================

    private void addAmenityCardToGrid(
            String name,
            String price,
            String description,
            String availability) {

        int index =
                amenityGrid.getChildren().size();

        int column =
                index % 6;

        int row =
                index / 6;

        amenityGrid.add(
                createAmenityCard(
                        name,
                        price,
                        description,
                        availability
                ),
                column,
                row
        );
    }

    // =========================================================
    // AMENITY CARD
    // =========================================================

    private VBox createAmenityCard(
            String amenityName,
            String price,
            String description,
            String availability) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(13)
        );

        card.setPrefHeight(145);

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:8;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label name =
                new Label(amenityName);

        name.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#18385E;"
        );

        // =====================================================
        // PRICE
        // =====================================================

        Label priceLabel =
                new Label(price);

        priceLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#888888;"
        );

        // =====================================================
        // AVAILABILITY
        // =====================================================

        ComboBox<String> availabilityCombo =
                new ComboBox<>();

        availabilityCombo.getItems().addAll(
                "Available",
                "Not Available"
        );

        if (availability.equalsIgnoreCase(
                "Available"
        )
        ||
        availability.equalsIgnoreCase(
                "Not Available"
        )) {

            availabilityCombo.setValue(
                    availability
            );

        } else {

            availabilityCombo.setValue(
                    "Available"
            );
        }

        availabilityCombo.setMaxWidth(
                Double.MAX_VALUE
        );

        availabilityCombo.setPrefHeight(
                32
        );

        card.getChildren().addAll(
                name,
                priceLabel,
                descriptionLabel,
                availabilityCombo
        );

        return card;
    }

    // =========================================================
    // ADD AMENITY POPUP
    // =========================================================

    private void openAddAmenityPopup() {

        StackPane popupLayer =
                createOverlay();

        // =====================================================
        // FORM
        // =====================================================

        VBox form =
                new VBox(9);

        form.setPadding(
                new Insets(20)
        );

        // SMALL COMPACT HEIGHT
        form.setPrefWidth(400);

        form.setMaxWidth(400);

        form.setPrefHeight(430);

        form.setMaxHeight(430);

        form.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;" +
                "-fx-border-color:#DDDDDD;" +
                "-fx-border-radius:15;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label("Add Amenity");

        title.setStyle(
                "-fx-font-size:21px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#24456D;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label nameLabel =
                createFormLabel(
                        "Amenity Name"
                );

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter amenity name"
        );

        nameField.setPrefHeight(36);

        // =====================================================
        // PRICE
        // =====================================================

        Label priceLabel =
                createFormLabel(
                        "Price"
                );

        TextField priceField =
                new TextField();

        priceField.setPromptText(
                "Example: ₹ 500 / Hour"
        );

        priceField.setPrefHeight(36);

        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label descriptionLabel =
                createFormLabel(
                        "Description"
                );

        TextField descriptionField =
                new TextField();

        descriptionField.setPromptText(
                "Enter description"
        );

        descriptionField.setPrefHeight(36);

        // =====================================================
        // AVAILABILITY
        // =====================================================

        Label availabilityLabel =
                createFormLabel(
                        "Availability"
                );

        ComboBox<String> availabilityCombo =
                new ComboBox<>();

        availabilityCombo.getItems().addAll(
                "Available",
                "Not Available"
        );

        availabilityCombo.setValue(
                "Available"
        );

        availabilityCombo.setMaxWidth(
                Double.MAX_VALUE
        );

        availabilityCombo.setPrefHeight(36);

        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        Button cancelButton =
                new Button("Cancel");

        cancelButton.setPrefWidth(95);

        cancelButton.setPrefHeight(36);

        cancelButton.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button saveButton =
                new Button("Save Amenity");

        saveButton.setPrefWidth(125);

        saveButton.setPrefHeight(36);

        saveButton.setStyle(
                "-fx-background-color:#56342B;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelButton,
                saveButton
        );

        // =====================================================
        // FORM CHILDREN
        // =====================================================

        form.getChildren().addAll(

                title,

                nameLabel,
                nameField,

                priceLabel,
                priceField,

                descriptionLabel,
                descriptionField,

                availabilityLabel,
                availabilityCombo,

                buttonBox
        );

        // =====================================================
        // ADD FORM TO POPUP
        // =====================================================

        popupLayer.getChildren().add(
                form
        );

        StackPane.setAlignment(
                form,
                Pos.CENTER
        );

        // =====================================================
        // ROOT
        // =====================================================

        StackPane root =
                (StackPane) managePaymentScene
                        .getRoot();

        root.getChildren().add(
                popupLayer
        );

        // =====================================================
        // CANCEL
        // =====================================================

        cancelButton.setOnAction(
                e -> removePopup(
                        popupLayer
                )
        );

        // =====================================================
        // SAVE AMENITY
        // =====================================================

        saveButton.setOnAction(e -> {

            String name =
                    nameField
                            .getText()
                            .trim();

            String price =
                    priceField
                            .getText()
                            .trim();

            String description =
                    descriptionField
                            .getText()
                            .trim();

            String availability =
                    availabilityCombo
                            .getValue();

            // =================================================
            // VALIDATION
            // =================================================

            if (name.isEmpty()
                    || price.isEmpty()
                    || description.isEmpty()
                    || availability == null) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Missing Information",
                        "Please fill all amenity details."
                );

                return;
            }

            // =================================================
            // SAVE THROUGH CONTROLLER
            // =================================================

            boolean saved =
                    paymentController.addAmenity(
                            name,
                            price,
                            description,
                            availability
                    );

            // =================================================
            // SUCCESS
            // =================================================

            if (saved) {

                showAlert(
                        Alert.AlertType.INFORMATION,
                        "Success",
                        "Amenity added successfully."
                );

                removePopup(
                        popupLayer
                );

                loadAmenities();

            } else {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Save Failed",
                        "Unable to save amenity to Firestore."
                );
            }
        });
    }

    // =========================================================
    // LOAD BOOKINGS
    // =========================================================

    private void loadBookings() {

        if (bookingList == null) {
            return;
        }

        bookingList.getChildren().clear();

        Label loading =
                new Label(
                        "Loading bookings..."
                );

        loading.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        bookingList.getChildren().add(
                loading
        );

        List<Payment> bookings =
                paymentController
                        .getAllBookings();

        bookingList.getChildren().clear();

        if (bookings == null) {

            showNoBookings(
                    "Unable to fetch bookings."
            );

            return;
        }

        if (bookings.isEmpty()) {

            showNoBookings(
                    "No bookings found in Firestore."
            );

            return;
        }

        int count = 0;

        for (Payment payment : bookings) {

            if (payment == null) {
                continue;
            }

            if (isBookingExpired(payment)) {
                continue;
            }

            HBox row =
                    createBookingRow(
                            payment
                    );

            bookingList.getChildren().add(
                    row
            );

            count++;
        }

        if (count == 0) {

            showNoBookings(
                    "No upcoming bookings available."
            );
        }
    }

    // =========================================================
    // CREATE BOOKING ROW
    // =========================================================

    private HBox createBookingRow(
            Payment payment) {

        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(12)
        );

        row.setMinHeight(72);

        row.setMaxWidth(
                Double.MAX_VALUE
        );

        row.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:8;" +
                "-fx-border-color:#DDDDDD;" +
                "-fx-border-radius:8;"
        );

        // =====================================================
        // RESIDENT
        // =====================================================

        VBox residentBox =
                createDetailBox(
                        "Resident Name",
                        safe(
                                payment.getResidentName()
                        )
                );

        // =====================================================
        // FLAT
        // =====================================================

        VBox flatBox =
                createDetailBox(
                        "Flat No",
                        safe(
                                payment.getFlatNo()
                        )
                );

        // =====================================================
        // AMENITY
        // =====================================================

        VBox amenityBox =
                createDetailBox(
                        "Amenity",
                        safe(
                                payment.getAmenityName()
                        )
                );

        // =====================================================
        // DATE
        // =====================================================

        VBox dateBox =
                createDetailBox(
                        "Date",
                        formatDate(
                                payment.getBookingDate()
                        )
                );

        // =====================================================
        // TIME
        // =====================================================

        String time =
                safe(
                        payment.getStartTime()
                )
                + " - "
                + safe(
                        payment.getEndTime()
                );

        VBox timeBox =
                createDetailBox(
                        "Time",
                        time
                );

        // =====================================================
        // STATUS
        // =====================================================

        VBox statusBox =
                new VBox(5);

        Label statusTitle =
                new Label("Status");

        statusTitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#888888;"
        );

        Label statusLabel =
                new Label();

        String status =
                safe(
                        payment.getStatus()
                );

        if (status.equalsIgnoreCase(
                "Accepted"
        )) {

            statusLabel.setText(
                    "Accepted"
            );

            statusLabel.setStyle(
                    "-fx-background-color:#DDF4E5;" +
                    "-fx-text-fill:#218838;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:6px 10px;" +
                    "-fx-background-radius:15;"
            );

        } else if (status.equalsIgnoreCase(
                "Rejected"
        )) {

            statusLabel.setText(
                    "Rejected"
            );

            statusLabel.setStyle(
                    "-fx-background-color:#F8D7DA;" +
                    "-fx-text-fill:#B02A37;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:6px 10px;" +
                    "-fx-background-radius:15;"
            );

        } else {

            statusLabel.setText(
                    "Pending"
            );

            statusLabel.setStyle(
                    "-fx-background-color:#FFF3CD;" +
                    "-fx-text-fill:#856404;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:6px 10px;" +
                    "-fx-background-radius:15;"
            );
        }

        statusBox.getChildren().addAll(
                statusTitle,
                statusLabel
        );

        // =====================================================
        // ACTION
        // =====================================================

        VBox actionBox =
                new VBox(5);

        Label actionTitle =
                new Label("Action");

        actionTitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#888888;"
        );

        HBox actionButtons =
                new HBox(8);

        // =====================================================
        // ACCEPT
        // =====================================================

        Button acceptButton =
                new Button("Accept");

        acceptButton.setPrefWidth(75);

        acceptButton.setPrefHeight(32);

        acceptButton.setStyle(
                "-fx-background-color:#198754;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:5;"
        );

        // =====================================================
        // REJECT
        // =====================================================

        Button rejectButton =
                new Button("Reject");

        rejectButton.setPrefWidth(75);

        rejectButton.setPrefHeight(32);

        rejectButton.setStyle(
                "-fx-background-color:#DC3545;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:5;"
        );

        // =====================================================
        // DISABLE AFTER DECISION
        // =====================================================

        if (status.equalsIgnoreCase(
                "Accepted"
        )
        ||
        status.equalsIgnoreCase(
                "Rejected"
        )) {

            acceptButton.setDisable(true);

            rejectButton.setDisable(true);
        }

        // =====================================================
        // ACCEPT ACTION
        // =====================================================

        acceptButton.setOnAction(
                e -> updateBookingStatus(
                        payment,
                        "Accepted"
                )
        );

        // =====================================================
        // REJECT ACTION
        // =====================================================

        rejectButton.setOnAction(
                e -> updateBookingStatus(
                        payment,
                        "Rejected"
                )
        );

        actionButtons.getChildren().addAll(
                acceptButton,
                rejectButton
        );

        actionBox.getChildren().addAll(
                actionTitle,
                actionButtons
        );

        // =====================================================
        // WIDTH
        // =====================================================

        residentBox.setPrefWidth(150);

        flatBox.setPrefWidth(80);

        amenityBox.setPrefWidth(145);

        dateBox.setPrefWidth(110);

        timeBox.setPrefWidth(145);

        statusBox.setPrefWidth(100);

        actionBox.setPrefWidth(165);

        // =====================================================
        // ADD TO ROW
        // =====================================================

        row.getChildren().addAll(

                residentBox,

                flatBox,

                amenityBox,

                dateBox,

                timeBox,

                statusBox,

                actionBox
        );

        return row;
    }

    // =========================================================
    // UPDATE BOOKING STATUS
    // =========================================================

    private void updateBookingStatus(
            Payment payment,
            String newStatus) {

        try {

            String bookingId =
                    payment.getBookingId();

            if (bookingId == null
                    || bookingId.trim().isEmpty()) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Update Failed",
                        "Booking ID not found."
                );

                return;
            }

            boolean updated =
                    paymentController
                            .updateBookingStatus(
                                    bookingId,
                                    newStatus
                            );

            if (updated) {

                showAlert(
                        Alert.AlertType.INFORMATION,
                        "Booking Updated",
                        "Booking has been "
                                + newStatus
                                + " successfully."
                );

                loadBookings();

            } else {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Update Failed",
                        "Unable to update booking status."
                );
            }

        } catch (Exception e) {

            e.printStackTrace();

            showAlert(
                    Alert.AlertType.ERROR,
                    "Error",
                    "Something went wrong while updating booking."
            );
        }
    }

    // =========================================================
    // DETAIL BOX
    // =========================================================

    private VBox createDetailBox(
            String title,
            String value) {

        VBox box =
                new VBox(4);

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#888888;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setWrapText(true);

        valueLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        box.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return box;
    }

    // =========================================================
    // CHECK EXPIRED
    // =========================================================

    private boolean isBookingExpired(
            Payment payment) {

        try {

            String bookingDate =
                    payment.getBookingDate();

            String endTime =
                    payment.getEndTime();

            if (bookingDate == null
                    || endTime == null
                    || bookingDate.isEmpty()
                    || endTime.isEmpty()) {

                return false;
            }

            LocalDate date =
                    LocalDate.parse(
                            bookingDate
                    );

            LocalTime end =
                    parseTime(
                            endTime
                    );

            LocalDateTime endDateTime =
                    LocalDateTime.of(
                            date,
                            end
                    );

            return !LocalDateTime.now()
                    .isBefore(
                            endDateTime
                    );

        } catch (Exception e) {

            return false;
        }
    }

    // =========================================================
    // FORMAT DATE
    // =========================================================

    private String formatDate(
            String date) {

        try {

            if (date == null
                    || date.isEmpty()) {

                return "";
            }

            return LocalDate
                    .parse(date)
                    .format(
                            dateFormatter
                    );

        } catch (Exception e) {

            return safe(date);
        }
    }

    // =========================================================
    // PARSE TIME
    // =========================================================

    private LocalTime parseTime(
            String time) {

        return LocalTime.parse(
                time,
                timeFormatter
        );
    }

    // =========================================================
    // FORM LABEL
    // =========================================================

    private Label createFormLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;"
        );

        return label;
    }

    // =========================================================
    // NO BOOKINGS
    // =========================================================

    private void showNoBookings(
            String message) {

        Label label =
                new Label(message);

        label.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#777777;" +
                "-fx-padding:20;"
        );

        bookingList.getChildren().add(
                label
        );
    }

    // =========================================================
    // OVERLAY
    // =========================================================

    private StackPane createOverlay() {

        StackPane overlay =
                new StackPane();

        overlay.setPickOnBounds(
                true
        );

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.35);"
        );

        return overlay;
    }

    // =========================================================
    // REMOVE POPUP
    // =========================================================

    private void removePopup(
            StackPane popupLayer) {

        StackPane root =
                (StackPane) managePaymentScene
                        .getRoot();

        root.getChildren().remove(
                popupLayer
        );
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message) {

        Alert alert =
                new Alert(type);

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

    // =========================================================
    // SAFE STRING
    // =========================================================

    private String safe(
            String value) {

        return value == null
                ? ""
                : value;
    }
}