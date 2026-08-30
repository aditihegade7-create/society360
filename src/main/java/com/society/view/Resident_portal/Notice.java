package com.society.view.Resident_portal;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.model.Resident_model.NoticeModel;
import com.society.view.ScreenSize;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Notice {

    private List<NoticeModel> allNotices =
            new ArrayList<>();


    // =========================================================
    // SCENE
    // =========================================================

    public Scene getResidentbtScene(Stage stage) {

        // ROOT
        BorderPane root = new BorderPane();

        // SIDEBAR
        panel panelobj = new panel(stage);

        root.setLeft(
                panelobj.getSidebar()
        );


        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(30)
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );


        // =====================================================
        // HEADING
        // =====================================================

        Label title =
                new Label("Notices");

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.WHITE);


        Label subtitle =
                new Label(
                        "Important announcements from society management"
                );

        subtitle.setFont(
                Font.font("System", 14)
        );

        subtitle.setTextFill(Color.WHITE);


        VBox heading =
                new VBox(5);

        heading.setPadding(
                new Insets(15)
        );

        heading.setMaxWidth(
                Double.MAX_VALUE
        );

        heading.setStyle(
                "-fx-background-color: #4e342e;"
        );

        heading.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // FILTER
        // =====================================================

        HBox filterBox =
                new HBox(10);

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );


        ComboBox<String> category =
                new ComboBox<>();

        category.setPromptText(
                "Category"
        );

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


        // =====================================================
        // NOTICE CONTAINER
        // =====================================================

        VBox noticeContainer =
                new VBox(15);

        noticeContainer.setPadding(
                new Insets(10)
        );

        noticeContainer.setFillWidth(
                true
        );

        /*
         * IMPORTANT
         * Give the container a visible background.
         */
        noticeContainer.setStyle(
                "-fx-background-color: #e8ddd5;"
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                noticeContainer
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setFitToHeight(false);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setMaxWidth(
                Double.MAX_VALUE
        );

        scrollPane.setMaxHeight(
                Double.MAX_VALUE
        );

        scrollPane.setStyle(
                "-fx-background-color: #e8ddd5;"
        );


        // VERY IMPORTANT

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );


        // =====================================================
        // ADD TO MAIN CONTENT
        // =====================================================

        mainContent.getChildren().addAll(
                heading,
                filterBox,
                scrollPane
        );


        // =====================================================
        // CENTER
        // =====================================================

        root.setCenter(
                mainContent
        );


        // =====================================================
        // FETCH
        // =====================================================

        fetchNotices(
                noticeContainer
        );


        // =====================================================
        // SCENE
        // =====================================================

        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );


        return scene;
    }


    // =========================================================
    // FETCH NOTICES
    // =========================================================

    private void fetchNotices(
            VBox noticeContainer) {

        Thread thread =
                new Thread(() -> {

                    try {

                        System.out.println(
                                "Fetching notices..."
                        );


                        // GET FIRESTORE

                        Firestore db =
                                FirebaseConfig.getFirestore();


                        // GET COLLECTION

                        QuerySnapshot snapshot =
                                db.collection("Notices")
                                  .get()
                                  .get();


                        System.out.println(
                                "Number of notices = "
                                + snapshot.size()
                        );


                        List<NoticeModel> fetchedNotices =
                                new ArrayList<>();


                        // =================================================
                        // READ DOCUMENTS
                        // =================================================

                        for (
                                DocumentSnapshot document :
                                snapshot.getDocuments()
                        ) {

                            String title =
                                    document.getString(
                                            "title"
                                    );

                            String date =
                                    document.getString(
                                            "date"
                                    );

                            String description =
                                    document.getString(
                                            "description"
                                    );

                            String status =
                                    document.getString(
                                            "status"
                                    );


                            System.out.println(
                                    "Title = " + title
                            );

                            System.out.println(
                                    "Date = " + date
                            );

                            System.out.println(
                                    "Description = "
                                    + description
                            );

                            System.out.println(
                                    "Status = " + status
                            );


                            NoticeModel notice =
                                    new NoticeModel(
                                            title,
                                            date,
                                            description,
                                            status
                                    );


                            fetchedNotices.add(
                                    notice
                            );
                        }


                        // =================================================
                        // JAVAFX THREAD
                        // =================================================

                        Platform.runLater(() -> {

                            System.out.println(
                                    "Updating JavaFX UI..."
                            );


                            allNotices.clear();

                            allNotices.addAll(
                                    fetchedNotices
                            );


                            noticeContainer
                                    .getChildren()
                                    .clear();


                            // =================================================
                            // ADD NOTICE BOXES
                            // =================================================

                            for (
                                    NoticeModel notice :
                                    fetchedNotices
                            ) {

                                VBox box =
                                        createNoticeBox(
                                                notice
                                        );


                                noticeContainer
                                        .getChildren()
                                        .add(
                                                box
                                        );
                            }


                            System.out.println(
                                    "Notice boxes added = "
                                    + noticeContainer
                                            .getChildren()
                                            .size()
                            );


                            // Force layout calculation

                            noticeContainer
                                    .applyCss();

                            noticeContainer
                                    .layout();


                        });


                    } catch (Exception e) {

                        e.printStackTrace();


                        Platform.runLater(() -> {

                            noticeContainer
                                    .getChildren()
                                    .clear();


                            Label error =
                                    new Label(
                                            "Error loading notices"
                                    );


                            error.setTextFill(
                                    Color.RED
                            );


                            noticeContainer
                                    .getChildren()
                                    .add(
                                            error
                                    );
                        });
                    }

                });


        thread.setDaemon(true);

        thread.start();
    }


    // =========================================================
    // CREATE NOTICE BOX
    // =========================================================

    private VBox createNoticeBox(
            NoticeModel notice) {


        VBox box =
                new VBox(12);


        box.setPadding(
                new Insets(20)
        );


        /*
         * IMPORTANT
         * Make the box wide enough to be visible.
         */

        box.setMinHeight(130);

        box.setMaxWidth(
                Double.MAX_VALUE
        );


        box.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;" +
                "-fx-border-color: #d0d0d0;" +
                "-fx-border-radius: 10;"
        );


        // =====================================================
        // TITLE + STATUS
        // =====================================================

        Label titleLabel =
                new Label(
                        notice.getTitle() == null
                                ? ""
                                : notice.getTitle()
                );


        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        18
                )
        );


        titleLabel.setTextFill(
                Color.web("#263238")
        );


        Label statusLabel =
                new Label(
                        notice.getStatus() == null
                                ? ""
                                : notice.getStatus()
                );


        statusLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );


        statusLabel.setTextFill(
                Color.WHITE
        );


        statusLabel.setPadding(
                new Insets(
                        5,
                        12,
                        5,
                        12
                )
        );


        statusLabel.setStyle(
                "-fx-background-color: #2e7d32;" +
                "-fx-background-radius: 15;"
        );


        HBox topRow =
                new HBox(10);


        topRow.setAlignment(
                Pos.CENTER_LEFT
        );


        topRow.getChildren().addAll(
                titleLabel,
                statusLabel
        );


        // =====================================================
        // DATE
        // =====================================================

        Label dateLabel =
                new Label(
                        "Date • "
                        + (
                        notice.getDate() == null
                                ? ""
                                : notice.getDate()
                        )
                );


        dateLabel.setFont(
                Font.font(
                        "System",
                        13
                )
        );


        dateLabel.setTextFill(
                Color.web("#607D8B")
        );


        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label descriptionLabel =
                new Label(
                        notice.getDescription() == null
                                ? ""
                                : notice.getDescription()
                );


        descriptionLabel.setWrapText(true);

        descriptionLabel.setMaxWidth(
                Double.MAX_VALUE
        );


        descriptionLabel.setFont(
                Font.font(
                        "System",
                        14
                )
        );


        descriptionLabel.setTextFill(
                Color.web("#455A64")
        );


        // =====================================================
        // ADD TO BOX
        // =====================================================

        box.getChildren().addAll(
                topRow,
                dateLabel,
                descriptionLabel
        );


        return box;
    }
}
