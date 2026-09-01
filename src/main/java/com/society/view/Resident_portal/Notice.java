package com.society.view.Resident_portal;

import java.util.ArrayList;
import java.util.List;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.dao.Welcome.UserDao;
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

public class Notice {

    // =========================================================
    // FIRESTORE COLLECTION
    // =========================================================

    private static final String NOTICE_COLLECTION =
            "Notices";

    private static final String RESIDENT_COLLECTION =
            "Residents";

    // =========================================================
    // ALL NOTICES
    // =========================================================

    private List<NoticeModel> allNotices =
            new ArrayList<>();

    // =========================================================
    // CURRENT RESIDENT SOCIETY
    // =========================================================

    private String currentSociety = "";

    // =========================================================
    // SCENE
    // =========================================================

    public Scene getResidentbtScene(Stage stage) {

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root = new BorderPane();

        // =====================================================
        // SIDEBAR
        // =====================================================

        panel panelobj =
                new panel(stage);

        root.setLeft(
                panelobj.getSidebar()
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent =
                new VBox(20);

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

        title.setTextFill(
                Color.WHITE
        );

        Label subtitle =
                new Label(
                        "Important announcements from society management"
                );

        subtitle.setFont(
                Font.font(
                        "System",
                        14
                )
        );

        subtitle.setTextFill(
                Color.WHITE
        );

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

        category.setPrefWidth(
                180
        );

        TextField search =
                new TextField();

        search.setPromptText(
                "Search notices..."
        );

        search.setPrefWidth(
                250
        );

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

        scrollPane.setFitToWidth(
                true
        );

        scrollPane.setFitToHeight(
                false
        );

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
        // FETCH SOCIETY + NOTICES
        // =====================================================

        fetchNotices(
                noticeContainer
        );

        // =====================================================
        // SEARCH
        // =====================================================

        search.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    filterNotices(
                            noticeContainer,
                            category.getValue(),
                            newValue
                    );
                }
        );

        // =====================================================
        // CATEGORY
        // =====================================================

        category.valueProperty().addListener(
                (observable, oldValue, newValue) -> {

                    filterNotices(
                            noticeContainer,
                            newValue,
                            search.getText()
                    );
                }
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
    // GET CURRENT RESIDENT SOCIETY
    // =========================================================
    /*
     * Logged-in resident email
     *          ↓
     * Residents/{email}
     *          ↓
     * society
     */

    private String getCurrentResidentSociety() {

        try {

            // =================================================
            // GET LOGGED-IN EMAIL
            // =================================================

            String email =
                    UserDao.getLoggedInEmail();

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "ERROR: Logged-in resident email not found."
                );

                return null;
            }

            email =
                    email.trim()
                            .toLowerCase();

            System.out.println(
                    "================================="
            );

            System.out.println(
                    "GETTING RESIDENT SOCIETY"
            );

            System.out.println(
                    "Resident Email: " + email
            );

            System.out.println(
                    "================================="
            );

            // =================================================
            // FIRESTORE
            // =================================================

            Firestore db =
                    FirebaseConfig.getFirestore();

            // =================================================
            // GET RESIDENT DOCUMENT
            // =================================================

            DocumentSnapshot residentDocument =
                    db.collection(
                            RESIDENT_COLLECTION
                    )
                    .document(email)
                    .get()
                    .get();

            // =================================================
            // CHECK DOCUMENT
            // =================================================

            if (!residentDocument.exists()) {

                System.out.println(
                        "ERROR: Resident document not found."
                );

                System.out.println(
                        "Path: Residents/" + email
                );

                return null;
            }

            // =================================================
            // GET SOCIETY
            // =================================================

            String society =
                    residentDocument.getString(
                            "society"
                    );

            if (society == null ||
                    society.trim().isEmpty()) {

                System.out.println(
                        "ERROR: Resident society is empty."
                );

                return null;
            }

            society =
                    society.trim();

            System.out.println(
                    "Resident Society: " + society
            );

            System.out.println(
                    "================================="
            );

            return society;

        } catch (Exception e) {

            System.out.println(
                    "ERROR WHILE GETTING RESIDENT SOCIETY"
            );

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // FETCH NOTICES FROM FIRESTORE
    // =========================================================

    private void fetchNotices(
            VBox noticeContainer) {

        Thread thread =
                new Thread(() -> {

                    try {

                        System.out.println(
                                "================================="
                        );

                        System.out.println(
                                "FETCHING RESIDENT NOTICES..."
                        );

                        System.out.println(
                                "================================="
                        );

                        // =================================================
                        // GET RESIDENT SOCIETY
                        // =================================================

                        String society =
                                getCurrentResidentSociety();

                        if (society == null ||
                                society.trim().isEmpty()) {

                            Platform.runLater(() -> {

                                noticeContainer
                                        .getChildren()
                                        .clear();

                                Label error =
                                        new Label(
                                                "Society information not found."
                                        );

                                error.setFont(
                                        Font.font(
                                                "System",
                                                15
                                        )
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

                            return;
                        }

                        currentSociety =
                                society;

                        // =================================================
                        // FIRESTORE
                        // =================================================

                        Firestore db =
                                FirebaseConfig.getFirestore();

                        // =================================================
                        // IMPORTANT
                        //
                        // ONLY CURRENT SOCIETY NOTICES
                        //
                        // Notices
                        //    where society == currentSociety
                        // =================================================

                        QuerySnapshot snapshot =
                                db.collection(
                                        NOTICE_COLLECTION
                                )
                                .whereEqualTo(
                                        "society",
                                        society
                                )
                                .get()
                                .get();

                        System.out.println(
                                "================================="
                        );

                        System.out.println(
                                "NOTICE SOCIETY FILTER"
                        );

                        System.out.println(
                                "Resident Society = "
                                        + society
                        );

                        System.out.println(
                                "Total Notices Found = "
                                        + snapshot.size()
                        );

                        System.out.println(
                                "================================="
                        );

                        // =================================================
                        // LIST
                        // =================================================

                        List<NoticeModel> fetchedNotices =
                                new ArrayList<>();

                        // =================================================
                        // READ NOTICES
                        // =================================================

                        for (
                                DocumentSnapshot document :
                                snapshot.getDocuments()
                        ) {

                            System.out.println(
                                    "---------------------------------"
                            );

                            // =================================================
                            // DOCUMENT ID
                            // =================================================

                            String noticeId =
                                    document.getId();

                            // =================================================
                            // TITLE
                            // =================================================

                            String title =
                                    document.getString(
                                            "title"
                                    );

                            // =================================================
                            // DATE
                            // =================================================

                            String date =
                                    document.getString(
                                            "date"
                                    );

                            // =================================================
                            // DESCRIPTION
                            // =================================================

                            String description =
                                    document.getString(
                                            "description"
                                    );

                            // =================================================
                            // STATUS
                            // =================================================

                            String status =
                                    document.getString(
                                            "status"
                                    );

                            // =================================================
                            // NOTICE ID FIELD
                            // =================================================

                            String firestoreNoticeId =
                                    document.getString(
                                            "noticeId"
                                    );

                            if (
                                    firestoreNoticeId != null
                                    &&
                                    !firestoreNoticeId
                                            .trim()
                                            .isEmpty()
                            ) {

                                noticeId =
                                        firestoreNoticeId;
                            }

                            // =================================================
                            // SENDER EMAIL
                            // =================================================

                            String senderEmail =
                                    document.getString(
                                            "senderEmail"
                                    );

                            if (senderEmail == null) {

                                senderEmail = "";
                            }

                            // =================================================
                            // SOCIETY
                            // =================================================

                            String noticeSociety =
                                    document.getString(
                                            "society"
                                    );

                            // =================================================
                            // DEBUG
                            // =================================================

                            System.out.println(
                                    "Notice ID = "
                                            + noticeId
                            );

                            System.out.println(
                                    "Title = "
                                            + title
                            );

                            System.out.println(
                                    "Date = "
                                            + date
                            );

                            System.out.println(
                                    "Description = "
                                            + description
                            );

                            System.out.println(
                                    "Status = "
                                            + status
                            );

                            System.out.println(
                                    "Sender Email = "
                                            + senderEmail
                            );

                            System.out.println(
                                    "Notice Society = "
                                            + noticeSociety
                            );

                            // =================================================
                            // EXTRA SAFETY CHECK
                            // =================================================
                            /*
                             * Firestore query already filters by society.
                             *
                             * This additional check ensures that
                             * wrong/missing data never appears.
                             */

                            if (
                                    noticeSociety == null
                                    ||
                                    !noticeSociety
                                            .trim()
                                            .equalsIgnoreCase(
                                                    society
                                            )
                            ) {

                                System.out.println(
                                        "SKIPPING NOTICE - SOCIETY MISMATCH"
                                );

                                continue;
                            }

                            // =================================================
                            // CREATE MODEL
                            // =================================================

                            NoticeModel notice =
                                    new NoticeModel(
                                            title,
                                            date,
                                            description,
                                            status,
                                            noticeId,
                                            senderEmail
                                    );

                            fetchedNotices.add(
                                    notice
                            );
                        }

                        // =================================================
                        // UPDATE JAVAFX UI
                        // =================================================

                        Platform.runLater(() -> {

                            System.out.println(
                                    "Updating JavaFX UI..."
                            );

                            // =================================================
                            // SAVE NOTICES
                            // =================================================

                            allNotices.clear();

                            allNotices.addAll(
                                    fetchedNotices
                            );

                            // =================================================
                            // CLEAR OLD UI
                            // =================================================

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

                            // =================================================
                            // NO NOTICES
                            // =================================================

                            if (
                                    fetchedNotices.isEmpty()
                            ) {

                                Label emptyLabel =
                                        new Label(
                                                "No notices available for your society."
                                        );

                                emptyLabel.setFont(
                                        Font.font(
                                                "System",
                                                15
                                        )
                                );

                                emptyLabel.setTextFill(
                                        Color.web(
                                                "#607D8B"
                                        )
                                );

                                noticeContainer
                                        .getChildren()
                                        .add(
                                                emptyLabel
                                        );
                            }

                            // =================================================
                            // FORCE LAYOUT
                            // =================================================

                            noticeContainer.applyCss();

                            noticeContainer.layout();

                            System.out.println(
                                    "NOTICE BOXES ADDED = "
                                            + noticeContainer
                                            .getChildren()
                                            .size()
                            );
                        });

                    } catch (Exception e) {

                        System.out.println(
                                "================================="
                        );

                        System.out.println(
                                "ERROR WHILE FETCHING NOTICES"
                        );

                        System.out.println(
                                "================================="
                        );

                        e.printStackTrace();

                        Platform.runLater(() -> {

                            noticeContainer
                                    .getChildren()
                                    .clear();

                            Label error =
                                    new Label(
                                            "Error loading notices"
                                    );

                            error.setFont(
                                    Font.font(
                                            "System",
                                            15
                                    )
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
    // FILTER NOTICES
    // =========================================================

    private void filterNotices(
            VBox noticeContainer,
            String selectedCategory,
            String searchText) {

        noticeContainer
                .getChildren()
                .clear();

        String searchValue =
                searchText == null
                        ? ""
                        : searchText
                                .trim()
                                .toLowerCase();

        String categoryValue =
                selectedCategory == null
                        ||
                        selectedCategory.equals(
                                "All"
                        )
                        ? ""
                        : selectedCategory
                                .trim()
                                .toLowerCase();

        int count = 0;

        // =====================================================
        // FILTER
        // =====================================================

        for (
                NoticeModel notice :
                allNotices
        ) {

            String title =
                    notice.getTitle() == null
                            ? ""
                            : notice.getTitle()
                                    .toLowerCase();

            String description =
                    notice.getDescription() == null
                            ? ""
                            : notice.getDescription()
                                    .toLowerCase();

            // =================================================
            // SEARCH
            // =================================================

            boolean matchesSearch =
                    searchValue.isEmpty()
                            ||
                            title.contains(
                                    searchValue
                            )
                            ||
                            description.contains(
                                    searchValue
                            );

            // =================================================
            // CATEGORY
            // =================================================
            /*
             * Your NoticeModel currently does not have
             * a category field.
             *
             * So category is matched against title
             * and description.
             */

            boolean matchesCategory =
                    categoryValue.isEmpty()
                            ||
                            title.contains(
                                    categoryValue
                            )
                            ||
                            description.contains(
                                    categoryValue
                            );

            // =================================================
            // ADD MATCHING NOTICE
            // =================================================

            if (
                    matchesSearch
                    &&
                    matchesCategory
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

                count++;
            }
        }

        // =====================================================
        // NO RESULT
        // =====================================================

        if (count == 0) {

            Label noResult =
                    new Label(
                            "No notices found."
                    );

            noResult.setFont(
                    Font.font(
                            "System",
                            15
                    )
            );

            noResult.setTextFill(
                    Color.web(
                            "#607D8B"
                    )
            );

            noticeContainer
                    .getChildren()
                    .add(
                            noResult
                    );
        }
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

        box.setMinHeight(
                130
        );

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
        // TITLE
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
                Color.web(
                        "#263238"
                )
        );

        // =====================================================
        // STATUS
        // =====================================================

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

        // =====================================================
        // TOP ROW
        // =====================================================

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
                                +
                                (
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
                Color.web(
                        "#607D8B"
                )
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

        descriptionLabel.setWrapText(
                true
        );

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
                Color.web(
                        "#455A64"
                )
        );

        // =====================================================
        // SOCIETY LABEL
        // =====================================================

        Label societyLabel =
                new Label(
                        "Society • "
                                + currentSociety
                );

        societyLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        societyLabel.setTextFill(
                Color.web(
                        "#795548"
                )
        );

        // =====================================================
        // ADD TO BOX
        // =====================================================

        box.getChildren().addAll(
                topRow,
                dateLabel,
                descriptionLabel,
                societyLabel
        );

        return box;
    }
}