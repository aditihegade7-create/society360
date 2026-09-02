package com.society.view.Guard_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.view.ScreenSize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisitorLog {

    public static ObservableList<Visitor> visitors =
        FXCollections.observableArrayList(

                    new Visitor(
                            "Amit Sharma",
                            "9876543210",
                            "A-101",
                            "Personal Visit",
                            "",
                            "09:15 AM",
                            "Inside"),

                    new Visitor(
                            "Rohan Patil",
                            "9823456789",
                            "B-204",
                            "Delivery",
                            "",
                            "10:05 AM",
                            "Inside"),

                    new Visitor(
                            "Sneha Joshi",
                            "9765432109",
                            "C-302",
                            "Service",
                            "",
                            "11:20 AM",
                            "Checked Out"),

                    new Visitor(
                            "Karan Mehta",
                            "9898989898",
                            "A-405",
                            "Personal Visit",
                            "",
                            "12:10 PM",
                            "Inside")
            );

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();

        GuardSidebar sidebar =
                new GuardSidebar(stage, "Visitor Log");

        root.setLeft(sidebar.getSidebar());

        VBox mainContent = new VBox();
        mainContent.setPadding(new Insets(25, 35, 25, 35));
        mainContent.setSpacing(20);
        mainContent.setAlignment(Pos.TOP_LEFT);

        Image image = new Image(
        DailyReports.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

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


         HBox header = new HBox();
header.setPrefWidth(900);
header.setPrefHeight(80);
header.setPadding(new Insets(25, 35, 25, 35));
header.setAlignment(Pos.CENTER_LEFT);
header.setStyle("-fx-background-color: #4e342e;");

// Title + description
VBox titleBox = new VBox(3);

Label title = new Label("Visitor Log");
title.setStyle(
        "-fx-font-size:24px;" +
        "-fx-font-weight:bold;" +
        "-fx-text-fill: white;"
);

Label description = new Label(
        "Monitor visitor entries and exits at the society gate."
);
description.setStyle(
        "-fx-font-size:13px;" +
        "-fx-text-fill: white;"
);

titleBox.getChildren().addAll(title, description);


// Spacer pushes date to the right
Region spacer = new Region();
HBox.setHgrow(spacer, Priority.ALWAYS);


// Date
Label day = new Label();
Label date = new Label();

LocalDate today = LocalDate.now();

day.setText(today.format(
        DateTimeFormatter.ofPattern("EEEE")
));

date.setText(today.format(
        DateTimeFormatter.ofPattern("dd MMMM yyyy")
));
day.setTextFill(Color.WHITE);
date.setTextFill(Color.WHITE);

VBox dateBox = new VBox(3);
dateBox.setAlignment(Pos.CENTER_RIGHT);
dateBox.getChildren().addAll(day, date);


// Add everything to header
header.getChildren().addAll(
        titleBox,
        spacer,
        dateBox
);

        GridPane summaryGrid = new GridPane();
        summaryGrid.setHgap(20);

        Label totalValue = new Label();
        Label insideValue = new Label();
        Label checkedOutValue = new Label();
        Label deliveryValue = new Label();

        VBox totalCard =
                createSummaryCard(
                        "Total Visitors",
                        totalValue);

        VBox insideCard =
                createSummaryCard(
                        "Currently Inside",
                        insideValue);

        VBox checkedOutCard =
                createSummaryCard(
                        "Checked Out",
                        checkedOutValue);

        VBox deliveryCard =
                createSummaryCard(
                        "Deliveries",
                        deliveryValue);

        summaryGrid.add(totalCard, 0, 0);
        summaryGrid.add(insideCard, 1, 0);
        summaryGrid.add(checkedOutCard, 2, 0);
        summaryGrid.add(deliveryCard, 3, 0);

        Label searchTitle = new Label("Search Visitors");
        searchTitle.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #070707;");

        TextField searchField = new TextField();
        searchField.setPromptText("Name, phone number or flat number...");
        searchField.setPrefWidth(430);
        searchField.setPrefHeight(38);
        searchField.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 6;");

        Button searchButton = new Button("Search");
        searchButton.setPrefWidth(100);
        searchButton.setPrefHeight(38);
        searchButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");

        Button refreshButton = new Button("Refresh");
        refreshButton.setPrefWidth(100);
        refreshButton.setPrefHeight(38);
        refreshButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: #050505;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");

        HBox searchBox =
                new HBox(
                        10,
                        searchField,
                        searchButton,
                        refreshButton);
        searchBox.setAlignment(Pos.CENTER_LEFT);

        VBox searchSection = new VBox(
                        8,
                        searchTitle,
                        searchBox);

        TableView<Visitor> visitorTable = new TableView<>();
        visitorTable.setPrefHeight(330);
        visitorTable.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 8;");

        TableColumn<Visitor, String> nameColumn = new TableColumn<>("Visitor Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(190);

        TableColumn<Visitor, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        phoneColumn.setPrefWidth(140);

        TableColumn<Visitor, String> flatColumn = new TableColumn<>("Flat");
        flatColumn.setCellValueFactory(new PropertyValueFactory<>("flat"));
        flatColumn.setPrefWidth(100);

        TableColumn<Visitor, String> purposeColumn = new TableColumn<>("Purpose");
        purposeColumn.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        purposeColumn.setPrefWidth(170);

        TableColumn<Visitor, String> entryColumn = new TableColumn<>("Entry Time");
        entryColumn.setCellValueFactory(new PropertyValueFactory<>("entryTime"));
        entryColumn.setPrefWidth(120);

        TableColumn<Visitor, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.setPrefWidth(130);

        visitorTable.getColumns().addAll(
                nameColumn,
                phoneColumn,
                flatColumn,
                purposeColumn,
                entryColumn,
                statusColumn
        );

        // Use the shared list
        visitorTable.setItems(visitors);

        updateSummary(
                visitors,
                totalValue,
                insideValue,
                checkedOutValue,
                deliveryValue);

        Button addVisitorButton = new Button("Add Visitor");
        addVisitorButton.setPrefWidth(140);
        addVisitorButton.setPrefHeight(40);
        addVisitorButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");

        addVisitorButton.setOnAction(e -> {
            stage.setScene(ManualVisitorEntry.createScene(stage));
        });

        Button checkOutButton = new Button("Check Out");
        checkOutButton.setPrefWidth(130);
        checkOutButton.setPrefHeight(40);
        checkOutButton.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-text-fill: #060606;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 6;");
        checkOutButton.setOnAction(e -> {

            Visitor selectedVisitor =
                    visitorTable
                            .getSelectionModel()
                            .getSelectedItem();


            if (selectedVisitor == null) {

                showMessage(
                        "No Visitor Selected",
                        "Please select a visitor first."
                );
                return;
            }

            if (selectedVisitor
                    .getStatus()
                    .equals("Checked Out")) {

                showMessage(
                        "Already Checked Out",
                        "This visitor has already checked out."
                );
                return;
            }

            selectedVisitor.setStatus(
                    "Checked Out"
            );

            visitorTable.refresh();

            updateSummary(
                    visitors,
                    totalValue,
                    insideValue,
                    checkedOutValue,
                    deliveryValue
            );

            showMessage(
                    "Visitor Checked Out",
                    selectedVisitor.getName()
                            + " has been checked out."
            );

        });


        HBox actionButtons =
                new HBox(
                        12,
                        addVisitorButton,
                        checkOutButton
                );

        actionButtons.setAlignment(
                Pos.CENTER_RIGHT
        );

        searchButton.setOnAction(e -> {

            String search =
                    searchField
                            .getText()
                            .trim()
                            .toLowerCase();


            if (search.isEmpty()) {
                visitorTable.setItems(visitors);
                return;
            }

            ObservableList<Visitor> filtered =
                    FXCollections.observableArrayList();


            for (Visitor visitor : visitors) {

                if (
                        visitor.getName()
                                .toLowerCase()
                                .contains(search)

                        ||

                        visitor.getPhone()
                                .contains(search)

                        ||

                        visitor.getFlat()
                                .toLowerCase()
                                .contains(search)
                ) {

                    filtered.add(visitor);
                }
            }


            visitorTable.setItems(filtered);

        });

        refreshButton.setOnAction(e -> {

            searchField.clear();

            visitorTable.setItems(
                    visitors
            );


            updateSummary(
                    visitors,
                    totalValue,
                    insideValue,
                    checkedOutValue,
                    deliveryValue
            );

        });

        mainContent.getChildren().addAll(
                header,
                summaryGrid,
                searchSection,
                visitorTable,
                actionButtons
        );
        BorderPane mainarea = new BorderPane();
        mainarea.setTop(header);
        mainarea.setCenter(mainContent);
        root.setCenter(mainarea);
        return new Scene(root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight());
    }

    private static VBox createSummaryCard(String title,Label value) {

        Label titleLabel = new Label(title);
        titleLabel.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-text-fill: #080808;"
        );

        value.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #080808;"
        );

        VBox card = new VBox(8,titleLabel,value);
        card.setPrefWidth(250);
        card.setPrefHeight(80);
        card.setPadding(new Insets(15));
        card.setStyle(
                "-fx-background-color: #E8F0E8;" +
                "-fx-background-radius: 10;");
        return card;
    }

    private static void updateSummary(
            ObservableList<Visitor> visitors,
            Label total,
            Label inside,
            Label checkedOut,
            Label deliveries) {


        int totalCount =
                visitors.size();

        int insideCount = 0;
        int checkedOutCount = 0;
        int deliveryCount = 0;


        for (Visitor visitor : visitors) {

            if (visitor.getStatus()
                    .equals("Inside")) {

                insideCount++;
            }


            if (visitor.getStatus()
                    .equals("Checked Out")) {

                checkedOutCount++;
            }


            if (visitor.getPurpose()
                    .equals("Delivery")) {

                deliveryCount++;
            }
        }


        total.setText(
                String.valueOf(totalCount)
        );

        inside.setText(
                String.valueOf(insideCount)
        );

        checkedOut.setText(
                String.valueOf(checkedOutCount)
        );

        deliveries.setText(
                String.valueOf(deliveryCount)
        );
    }

    public static class Visitor {

        String name;
        String phone;
        String flat;
        String purpose;
        private String remarks;
        String entryTime;
        String status;


        public Visitor(
                String name,
                String phone,
                String flat,
                String purpose,
                String remarks,
                String entryTime,
                String status) {

            this.name = name;
            this.phone = phone;
            this.flat = flat;
            this.purpose = purpose;
            this.remarks = remarks;
            this.entryTime = entryTime;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getFlat() {
            return flat;
        }

        public String getPurpose() {
            return purpose;
        }

        public String getRemarks() {
            return remarks;
        }

        public String getEntryTime() {
            return entryTime;
        }

        public String getStatus() {
            return status;
        }


        public void setStatus(String status) {
            this.status = status;
        }
    }

    private static void showMessage(
            String title,
            String message) {

        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(
                        javafx.scene.control.Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}