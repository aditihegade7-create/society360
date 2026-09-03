package com.society.view.Resident_portal;

import com.society.controller.welcome.UserController;

import com.society.controller.Resident_Controller.NoticeController;

import com.society.dao.Resident_dao.ComplaintDAO;
import com.society.dao.Resident_dao.VisitorDAO;
import com.society.dao.Welcome.UserDao;

import com.society.model.Resident_model.ComplaintModel;
import com.society.model.Resident_model.VisitorModel;
import com.society.model.Resident_model.NoticeModel;

import com.society.model.Welcome.User;

import com.society.config.FirebaseConfig;
import com.society.view.ScreenSize;

import javafx.application.Platform;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Resident Dashboard
 *
 * Dashboard data:
 *
 * 1. Resident name
 * 2. Flat number
 * 3. Active complaints
 * 4. Visitors today
 * 5. Society notices
 *
 * Society notices are fetched dynamically using the
 * logged-in resident email.
 */
public class ResidentDashboard {

    private Scene residentDashboardScene;

    private String residentName;
    private String flatNo;
    private String LognEmail;

    // =========================================================
    // DASHBOARD DYNAMIC LABELS
    // =========================================================

    private Label complaintCountLabel;
    private Label visitorCountLabel;

    // =========================================================
    // GET RESIDENT DASHBOARD SCENE
    // =========================================================

    public Scene getResidentDashboardScene(Stage stage) {

        // =====================================================
        // GET LOGGED-IN USER
        // =====================================================

        UserController userController =
                new UserController();

        String loggedInEmail =
                UserDao.getLoggedInEmail();

        this.LognEmail =
                loggedInEmail;

        User resident = null;

        if (loggedInEmail != null
                && !loggedInEmail.trim().isEmpty()) {

            resident =
                    userController.getUserByEmail(
                            loggedInEmail
                    );
        }

        // =====================================================
        // RESIDENT DETAILS
        // =====================================================

        if (resident != null) {

            residentName =
                    resident.getName();

            flatNo =
                    resident.getFlatNo();

        } else {

            residentName =
                    "Resident";

            flatNo =
                    "N/A";
        }

        // =====================================================
        // SIDEBAR
        // =====================================================

        panel panelobj =
                new panel(
                        stage,
                        loggedInEmail
                );

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root =
                new BorderPane();

        root.setLeft(
                panelobj.getSidebar()
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainContent =
                new VBox(20);

        mainContent.setPadding(
                new Insets(
                        25,
                        30,
                        25,
                        30
                )
        );

        mainContent.setStyle(
                "-fx-background-color: #e8ddd5;"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox header =
                new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox welcomeBox =
                new VBox(4);

        Label welcome =
                new Label(
                        "Good Morning, "
                                + residentName
                                + " 👋"
                );

        welcome.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        25
                )
        );

        welcome.setTextFill(
                Color.WHITE
        );

        Label flat =
                new Label(
                        "Flat "
                                + flatNo
                                + " • Tower A"
                );

        flat.setFont(
                Font.font(
                        "System",
                        13
                )
        );

        flat.setTextFill(
                Color.WHITE
        );

        welcomeBox.getChildren().addAll(
                welcome,
                flat
        );

        Region headerSpace =
                new Region();

        HBox.setHgrow(
                headerSpace,
                Priority.ALWAYS
        );

        Label date =
                new Label(
                        "16 August 2026\nSunday"
                );

        date.setTextFill(
                Color.WHITE
        );

        date.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        date.setAlignment(
                Pos.CENTER_RIGHT
        );

        header.getChildren().addAll(
                welcomeBox,
                headerSpace,
                date
        );

        // =====================================================
        // SUMMARY CARDS
        // =====================================================

        HBox summaryCards =
                new HBox(15);

        // =====================================================
        // TOTAL BILLS
        // =====================================================

        VBox totalDuetal =
                createSummaryCard(
                        "Total Bills",
                        "₹ 3,250",
                        "View Details"
                );

        // =====================================================
        // MAINTENANCE BILLS
        // =====================================================

        VBox maintenanceDue =
                createSummaryCard(
                        "Maintenance Bills",
                        "₹ 1,250",
                        "Due: 20 Aug 2026"
                );

        // =====================================================
        // ACTIVE COMPLAINTS
        // =====================================================

        VBox complaints =
                createSummaryCard(
                        "Active Complaints",
                        "0",
                        "View Status"
                );

        // =====================================================
        // VISITORS TODAY
        // =====================================================

        VBox visitors =
                createSummaryCard(
                        "Visitors Today",
                        "0",
                        "View Log"
                );

        // =====================================================
        // GET LABELS FROM CARDS
        // =====================================================

        complaintCountLabel =
                (Label) complaints
                        .getChildren()
                        .get(1);

        visitorCountLabel =
                (Label) visitors
                        .getChildren()
                        .get(1);

        // =====================================================
        // ADD SUMMARY CARDS
        // =====================================================

        summaryCards.getChildren().addAll(
                totalDuetal,
                maintenanceDue,
                complaints,
                visitors
        );

        // =====================================================
        // QUICK ACTIONS
        // =====================================================

        Label quickTitle =
                createSectionTitle(
                        "Quick Actions"
                );

        GridPane quickActions =
                new GridPane();

        quickActions.setHgap(15);
        quickActions.setVgap(15);

        // =====================================================
        // PAY MAINTENANCE
        // =====================================================

        Button payMaintenance =
                createActionButton(
                        "Pay Maintenance",
                        "Secure Online Payment"
                );

        // =====================================================
        // RAISE COMPLAINT
        // =====================================================

        Button raiseComplaint =
                createActionButton(
                        "Raise Complaint",
                        "Report an issue"
                );

        raiseComplaint.setOnAction(e -> {

            Complaint complaint =
                    new Complaint();

            stage.setScene(
                    complaint.getComplaintScene(
                            stage
                    )
            );
        });

        // =====================================================
        // BOOK AMENITY
        // =====================================================

        Button bookAmenity =
                createActionButton(
                        "Book Amenity",
                        "Hall, Court, Guest Room"
                );

        bookAmenity.setOnAction(e -> {

            AmenitiesBooking booking =
                    new AmenitiesBooking(
                            residentName,
                            flatNo,
                            loggedInEmail
                    );

            stage.setScene(
                    booking.getAminityScene(
                            stage
                    )
            );
        });

        // =====================================================
        // INVITE VISITOR
        // =====================================================

        Button inviteVisitor =
                createActionButton(
                        "Invite Visitor",
                        "Pre-approve entry"
                );

        inviteVisitor.setOnAction(e -> {

            Visitor visitor =
                    new Visitor();

            stage.setScene(
                    visitor.getVisitorScene(
                            stage
                    )
            );
        });

        // =====================================================
        // ADD QUICK ACTIONS
        // =====================================================

        quickActions.add(
                payMaintenance,
                0,
                0
        );

        quickActions.add(
                raiseComplaint,
                1,
                0
        );

        quickActions.add(
                bookAmenity,
                0,
                1
        );

        quickActions.add(
                inviteVisitor,
                1,
                1
        );

        // =====================================================
        // UPCOMING / DUE
        // =====================================================

        VBox upcomingBox =
                new VBox(12);

        upcomingBox.setPadding(
                new Insets(18)
        );

        upcomingBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label upcomingTitle =
                new Label(
                        "Upcoming / Due"
                );

        upcomingTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        upcomingTitle.setTextFill(
                Color.web("#263238")
        );

        upcomingBox.getChildren().add(
                upcomingTitle
        );

        upcomingBox.getChildren().addAll(

                createDueRow(
                        "Maintenance Due",
                        "20 Aug 2026"
                ),

                createDueRow(
                        "Water Bill",
                        "25 Aug 2026"
                ),

                createDueRow(
                        "Electricity Bill",
                        "30 Aug 2026"
                )
        );

        // =====================================================
        // MIDDLE SECTION
        // =====================================================

        HBox middleSection =
                new HBox(20);

        VBox quickBox =
                new VBox(10);

        quickBox.setPadding(
                new Insets(18)
        );

        quickBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        quickBox.getChildren().addAll(
                quickTitle,
                quickActions
        );

        HBox.setHgrow(
                quickBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                upcomingBox,
                Priority.ALWAYS
        );

        middleSection.getChildren().addAll(
                quickBox,
                upcomingBox
        );

        // =====================================================
        // BOTTOM SECTION
        // =====================================================

        HBox bottomSection =
                new HBox(20);

        // =====================================================
        // SOCIETY NOTICES
        // =====================================================

        VBox noticesBox =
                new VBox(12);

        noticesBox.setPadding(
                new Insets(18)
        );

        noticesBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label noticesTitle =
                new Label(
                        "Society Notices"
                );

        noticesTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        noticesTitle.setTextFill(
                Color.web("#263238")
        );

        // =====================================================
        // NOTICE CONTENT CONTAINER
        // =====================================================

        VBox noticeContent =
                new VBox(10);

        noticeContent.setFillWidth(
                true
        );

        // =====================================================
        // INITIAL LOADING MESSAGE
        // =====================================================

        Label loadingNotice =
                new Label(
                        "Loading notices..."
                );

        loadingNotice.setFont(
                Font.font(
                        "System",
                        13
                )
        );

        loadingNotice.setTextFill(
                Color.web("#789098")
        );

        noticeContent.getChildren().add(
                loadingNotice
        );

        noticesBox.getChildren().addAll(
                noticesTitle,
                noticeContent
        );

        // =====================================================
        // FETCH SOCIETY NOTICES
        // =====================================================

        loadSocietyNotices(
                loggedInEmail,
                noticeContent
        );

        // =====================================================
        // COMMUNITY POLL
        // =====================================================

        VBox pollBox =
                new VBox(12);

        pollBox.setPadding(
                new Insets(18)
        );

        pollBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label pollTitle =
                new Label(
                        "Community Poll"
                );

        pollTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        pollTitle.setTextFill(
                Color.web("#263238")
        );

        Label question =
                new Label(
                        "Should we organize a society picnic this month?"
                );

        question.setWrapText(
                true
        );

        question.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        Label yes =
                new Label(
                        "Yes (78%)"
                );

        yes.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        ProgressBar yesBar =
                new ProgressBar(
                        0.78
                );

        yesBar.setPrefWidth(
                250
        );

        Label no =
                new Label(
                        "No (22%)"
                );

        no.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        ProgressBar noBar =
                new ProgressBar(
                        0.22
                );

        noBar.setPrefWidth(
                250
        );

        pollBox.getChildren().addAll(
                pollTitle,
                question,
                yes,
                yesBar,
                no,
                noBar
        );

        // =====================================================
        // BOTTOM SECTION SIZING
        // =====================================================

        HBox.setHgrow(
                noticesBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                pollBox,
                Priority.ALWAYS
        );

        bottomSection.getChildren().addAll(
                noticesBox,
                pollBox
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        mainContent.getChildren().addAll(
                summaryCards,
                middleSection,
                bottomSection
        );

        // =====================================================
        // HEADER STYLE
        // =====================================================

        header.setStyle(
                "-fx-background-color: #4e342e"
        );

        // =====================================================
        // MAIN AREA
        // =====================================================

        BorderPane mainarea =
                new BorderPane();

        mainarea.setTop(
                header
        );

        mainarea.setCenter(
                mainContent
        );

        root.setCenter(
                mainarea
        );

        // =====================================================
        // CREATE SCENE
        // =====================================================

        residentDashboardScene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        // =====================================================
        // FETCH DASHBOARD DATA
        // =====================================================

        loadDashboardData(
                loggedInEmail
        );

        return residentDashboardScene;
    }


    // =========================================================
    // LOAD SOCIETY NOTICES
    // =========================================================

    private void loadSocietyNotices(
            String loggedInEmail,
            VBox noticeContent) {

        // -----------------------------------------------------
        // VALIDATE EMAIL
        // -----------------------------------------------------

        if (loggedInEmail == null
                || loggedInEmail.trim().isEmpty()) {

            Platform.runLater(() -> {

                noticeContent
                        .getChildren()
                        .clear();

                Label noEmail =
                        new Label(
                                "Unable to load notices."
                        );

                noEmail.setFont(
                        Font.font(
                                "System",
                                13
                        )
                );

                noEmail.setTextFill(
                        Color.web("#789098")
                );

                noticeContent
                        .getChildren()
                        .add(
                                noEmail
                        );
            });

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "RESIDENT NOTICE FETCH"
            );

            System.out.println(
                    "Logged-in email is missing."
            );

            System.out.println(
                    "========================================"
            );

            return;
        }

        // -----------------------------------------------------
        // CLEAN EMAIL
        // -----------------------------------------------------

        final String email =
                loggedInEmail
                        .trim()
                        .toLowerCase();

        // -----------------------------------------------------
        // BACKGROUND THREAD
        // -----------------------------------------------------

        Thread noticeThread =
                new Thread(() -> {

                    try {

                        System.out.println(
                                "========================================"
                        );

                        System.out.println(
                                "RESIDENT DASHBOARD NOTICE FETCH STARTED"
                        );

                        System.out.println(
                                "Resident Email : "
                                        + email
                        );

                        System.out.println(
                                "========================================"
                        );

                        // -------------------------------------------------
                        // NOTICE CONTROLLER
                        // -------------------------------------------------

                        NoticeController noticeController =
                                new NoticeController();

                        // -------------------------------------------------
                        // FETCH NOTICES
                        // -------------------------------------------------

                        List<NoticeModel> notices =
                                noticeController
                                        .getNoticesForResident(
                                                email
                                        );

                        if (notices == null) {
                            notices =
                                    java.util.Collections.emptyList();
                        }

                        System.out.println(
                                "Dashboard notices fetched = "
                                        + notices.size()
                        );

                        // -------------------------------------------------
                        // FINAL LIST
                        // -------------------------------------------------

                        final List<NoticeModel>
                                finalNotices =
                                        notices;

                        // -------------------------------------------------
                        // UPDATE JAVAFX UI
                        // -------------------------------------------------

                        Platform.runLater(() -> {

                            noticeContent
                                    .getChildren()
                                    .clear();

                            // ---------------------------------------------
                            // NO NOTICES
                            // ---------------------------------------------

                            if (finalNotices.isEmpty()) {

                                Label noNotices =
                                        new Label(
                                                "No society notices available."
                                        );

                                noNotices.setFont(
                                        Font.font(
                                                "System",
                                                13
                                        )
                                );

                                noNotices.setTextFill(
                                        Color.web("#789098")
                                );

                                noNotices.setWrapText(
                                        true
                                );

                                noticeContent
                                        .getChildren()
                                        .add(
                                                noNotices
                                        );

                                System.out.println(
                                        "No society notices found."
                                );

                                return;
                            }

                            // ---------------------------------------------
                            // DISPLAY NOTICES
                            // ---------------------------------------------
                            //
                            // Dashboard shows maximum 3 notices so the
                            // existing dashboard layout remains compact.
                            //
                            // The complete Notices page can show all
                            // notices.
                            // ---------------------------------------------

                            int displayCount =
                                    Math.min(
                                            finalNotices.size(),
                                            3
                                    );

                            for (int i = 0;
                                 i < displayCount;
                                 i++) {

                                NoticeModel notice =
                                        finalNotices.get(i);

                                if (notice == null) {
                                    continue;
                                }

                                VBox noticeCard =
                                        createDashboardNotice(
                                                notice
                                        );

                                noticeContent
                                        .getChildren()
                                        .add(
                                                noticeCard
                                        );
                            }

                            System.out.println(
                                    "Dashboard notice boxes added = "
                                            + noticeContent
                                                    .getChildren()
                                                    .size()
                            );
                        });

                        System.out.println(
                                "========================================"
                        );

                        System.out.println(
                                "RESIDENT DASHBOARD NOTICE FETCH COMPLETED"
                        );

                        System.out.println(
                                "Total Notices : "
                                        + finalNotices.size()
                        );

                        System.out.println(
                                "Resident Email : "
                                        + email
                        );

                        System.out.println(
                                "========================================"
                        );

                    } catch (Exception ex) {

                        System.out.println(
                                "========================================"
                        );

                        System.out.println(
                                "RESIDENT DASHBOARD NOTICE ERROR"
                        );

                        System.out.println(
                                "Resident Email : "
                                        + email
                        );

                        System.out.println(
                                "========================================"
                        );

                        ex.printStackTrace();

                        Platform.runLater(() -> {

                            noticeContent
                                    .getChildren()
                                    .clear();

                            Label errorLabel =
                                    new Label(
                                            "Unable to load society notices."
                                    );

                            errorLabel.setFont(
                                    Font.font(
                                            "System",
                                            13
                                    )
                            );

                            errorLabel.setTextFill(
                                    Color.web("#789098")
                            );

                            errorLabel.setWrapText(
                                    true
                            );

                            noticeContent
                                    .getChildren()
                                    .add(
                                            errorLabel
                                    );
                        });
                    }
                });

        // -----------------------------------------------------
        // DAEMON THREAD
        // -----------------------------------------------------

        noticeThread.setDaemon(
                true
        );

        noticeThread.start();
    }


    // =========================================================
    // CREATE DASHBOARD NOTICE
    // =========================================================

    private VBox createDashboardNotice(
            NoticeModel notice) {

        VBox card =
                new VBox(4);

        card.setPadding(
                new Insets(
                        7,
                        0,
                        7,
                        0
                )
        );

        // =====================================================
        // TITLE
        // =====================================================

        String titleText =
                safeNoticeValue(
                        notice.getTitle()
                );

        if (titleText.isEmpty()) {
            titleText =
                    "Society Notice";
        }

        Label title =
                new Label(
                        "• " + titleText
                );

        title.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        title.setTextFill(
                Color.web("#263238")
        );

        title.setWrapText(
                true
        );

        // =====================================================
        // DATE
        // =====================================================

        String noticeDate =
                safeNoticeValue(
                        notice.getDate()
                );

        Label date =
                new Label(
                        noticeDate
                );

        date.setFont(
                Font.font(
                        "System",
                        11
                )
        );

        date.setTextFill(
                Color.web("#789098")
        );

        // =====================================================
        // DESCRIPTION
        // =====================================================

        String descriptionText =
                safeNoticeValue(
                        notice.getDescription()
                );

        Label description =
                new Label(
                        descriptionText
                );

        description.setFont(
                Font.font(
                        "System",
                        12
                )
        );

        description.setTextFill(
                Color.web("#607D8B")
        );

        description.setWrapText(
                true
        );

        // =====================================================
        // STATUS
        // =====================================================

        String statusText =
                safeNoticeValue(
                        notice.getStatus()
                );

        if (!statusText.isEmpty()) {

            Label status =
                    new Label(
                            "Status: "
                                    + statusText
                    );

            status.setFont(
                    Font.font(
                            "System",
                            FontWeight.BOLD,
                            11
                    )
            );

            status.setTextFill(
                    Color.web("#789098")
            );

            card.getChildren().addAll(
                    title,
                    date,
                    description,
                    status
            );

        } else {

            card.getChildren().addAll(
                    title,
                    date,
                    description
            );
        }

        return card;
    }


    // =========================================================
    // SAFE NOTICE VALUE
    // =========================================================

    private String safeNoticeValue(
            String value) {

        if (value == null) {
            return "";
        }

        return value.trim();
    }


    // =========================================================
    // LOAD DASHBOARD DATA
    // =========================================================

    private void loadDashboardData(
            String loggedInEmail) {

        if (loggedInEmail == null
                || loggedInEmail.trim().isEmpty()) {

            System.out.println(
                    "Dashboard: Logged-in email is missing."
            );

            return;
        }

        Thread dashboardThread =
                new Thread(() -> {

                    try {

                        String email =
                                loggedInEmail
                                        .trim()
                                        .toLowerCase();

                        // =====================================
                        // FIRESTORE
                        // =====================================

                        ComplaintDAO complaintDAO =
                                new ComplaintDAO(
                                        FirebaseConfig
                                                .getFirestore()
                                );

                        VisitorDAO visitorDAO =
                                new VisitorDAO(
                                        FirebaseConfig
                                                .getFirestore()
                                );

                        // =====================================
                        // FETCH COMPLAINTS
                        // =====================================

                        List<ComplaintModel> complaints =
                                complaintDAO
                                        .getComplaintsByEmail(
                                                email
                                        );

                        int activeComplaintCount =
                                countActiveComplaints(
                                        complaints
                                );

                        // =====================================
                        // FETCH TODAY'S VISITORS
                        // =====================================

                        int todayVisitorCount =
                                getTodayVisitorCount(
                                        visitorDAO,
                                        email
                                );

                        // =====================================
                        // UPDATE UI
                        // =====================================

                        Platform.runLater(() -> {

                            if (complaintCountLabel != null) {

                                complaintCountLabel.setText(
                                        String.valueOf(
                                                activeComplaintCount
                                        )
                                );
                            }

                            if (visitorCountLabel != null) {

                                visitorCountLabel.setText(
                                        String.valueOf(
                                                todayVisitorCount
                                        )
                                );
                            }
                        });

                        // =====================================
                        // CONSOLE LOG
                        // =====================================

                        System.out.println(
                                "================================="
                        );

                        System.out.println(
                                "RESIDENT DASHBOARD DATA"
                        );

                        System.out.println(
                                "Resident Email: "
                                        + email
                        );

                        System.out.println(
                                "Active Complaints: "
                                        + activeComplaintCount
                        );

                        System.out.println(
                                "Visitors Today: "
                                        + todayVisitorCount
                        );

                        System.out.println(
                                "================================="
                        );

                    } catch (Exception ex) {

                        ex.printStackTrace();

                        Platform.runLater(() -> {

                            if (complaintCountLabel != null) {

                                complaintCountLabel.setText(
                                        "0"
                                );
                            }

                            if (visitorCountLabel != null) {

                                visitorCountLabel.setText(
                                        "0"
                                );
                            }
                        });
                    }
                });

        // Do not block JavaFX UI

        dashboardThread.setDaemon(
                true
        );

        dashboardThread.start();
    }


    // =========================================================
    // COUNT ACTIVE COMPLAINTS
    // =========================================================

    private int countActiveComplaints(
            List<ComplaintModel> complaints) {

        if (complaints == null
                || complaints.isEmpty()) {

            return 0;
        }

        int count = 0;

        for (ComplaintModel complaint :
                complaints) {

            if (complaint == null) {
                continue;
            }

            String status =
                    complaint.getStatus();

            // ---------------------------------------------
            // If status is missing, consider complaint active
            // ---------------------------------------------

            if (status == null
                    || status.trim().isEmpty()) {

                count++;

                continue;
            }

            String cleanStatus =
                    status.trim()
                            .toLowerCase();

            // ---------------------------------------------
            // Completed / closed statuses are NOT active
            // ---------------------------------------------

            if (cleanStatus.equals("resolved")
                    || cleanStatus.equals("closed")
                    || cleanStatus.equals("completed")
                    || cleanStatus.equals("complete")
                    || cleanStatus.equals("cancelled")
                    || cleanStatus.equals("canceled")) {

                continue;
            }

            // ---------------------------------------------
            // Everything else is considered active
            // ---------------------------------------------

            count++;
        }

        return count;
    }


    // =========================================================
    // GET TODAY'S VISITOR COUNT
    // =========================================================

    private int getTodayVisitorCount(
            VisitorDAO visitorDAO,
            String email)
            throws Exception {

        LocalDate today =
                LocalDate.now();

        /*
         * Your VisitorDAO searches using:
         *
         * whereEqualTo("visitDate", date)
         *
         * Because your existing project may store visitDate
         * in different common string formats, we try the
         * common formats below.
         *
         * Duplicate visitor IDs are removed using a Set.
         */

        Set<String> visitorIds =
                new HashSet<>();

        // =====================================================
        // FORMAT 1
        // 02-09-2026
        // =====================================================

        String format1 =
                today.format(
                        DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy"
                        )
                );

        addVisitorsForDate(
                visitorDAO,
                email,
                format1,
                visitorIds
        );

        // =====================================================
        // FORMAT 2
        // 02/09/2026
        // =====================================================

        String format2 =
                today.format(
                        DateTimeFormatter.ofPattern(
                                "dd/MM/yyyy"
                        )
                );

        addVisitorsForDate(
                visitorDAO,
                email,
                format2,
                visitorIds
        );

        // =====================================================
        // FORMAT 3
        // 2 September 2026
        // =====================================================

        String format3 =
                today.format(
                        DateTimeFormatter.ofPattern(
                                "d MMMM yyyy"
                        )
                );

        addVisitorsForDate(
                visitorDAO,
                email,
                format3,
                visitorIds
        );

        // =====================================================
        // FORMAT 4
        // 02 September 2026
        // =====================================================

        String format4 =
                today.format(
                        DateTimeFormatter.ofPattern(
                                "dd MMMM yyyy"
                        )
                );

        addVisitorsForDate(
                visitorDAO,
                email,
                format4,
                visitorIds
        );

        return visitorIds.size();
    }


    // =========================================================
    // ADD VISITORS FOR A PARTICULAR DATE
    // =========================================================

    private void addVisitorsForDate(
            VisitorDAO visitorDAO,
            String email,
            String date,
            Set<String> visitorIds)
            throws Exception {

        List<VisitorModel> visitors =
                visitorDAO.getVisitorsByDate(
                        email,
                        date
                );

        if (visitors == null
                || visitors.isEmpty()) {

            return;
        }

        for (VisitorModel visitor :
                visitors) {

            if (visitor == null) {
                continue;
            }

            String id =
                    visitor.getId();

            if (id != null
                    && !id.trim().isEmpty()) {

                visitorIds.add(
                        id.trim()
                );

            } else {

                /*
                 * Normally ID is always restored by VisitorDAO.
                 * This fallback prevents duplicate counting from
                 * becoming an issue when an ID is missing.
                 */

                String fallback =
                        visitor.getVisitorName()
                                + "|"
                                + visitor.getVisitDate();

                visitorIds.add(
                        fallback
                );
            }
        }
    }


    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private VBox createSummaryCard(
            String title,
            String amount,
            String bottomText) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(16)
        );

        card.setPrefWidth(
                190
        );

        card.setPrefHeight(
                110
        );

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label titleLabel =
                new Label(
                        title
                );

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        titleLabel.setTextFill(
                Color.web("#607D8B")
        );

        Label amountLabel =
                new Label(
                        amount
                );

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        22
                )
        );

        amountLabel.setTextFill(
                Color.web("#263238")
        );

        Label bottomLabel =
                new Label(
                        bottomText
                );

        bottomLabel.setFont(
                Font.font(
                        "System",
                        12
                )
        );

        bottomLabel.setTextFill(
                Color.web("#789098")
        );

        card.getChildren().addAll(
                titleLabel,
                amountLabel,
                bottomLabel
        );

        return card;
    }


    // =========================================================
    // SECTION TITLE
    // =========================================================

    private Label createSectionTitle(
            String text) {

        Label label =
                new Label(
                        text
                );

        label.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        label.setTextFill(
                Color.web("#263238")
        );

        return label;
    }


    // =========================================================
    // QUICK ACTION BUTTON
    // =========================================================

    private Button createActionButton(
            String title,
            String subtitle) {

        Button button =
                new Button();

        button.setPrefSize(
                230,
                65
        );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        Label titleLabel =
                new Label(
                        title
                );

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        Label subtitleLabel =
                new Label(
                        subtitle
                );

        subtitleLabel.setFont(
                Font.font(
                        "System",
                        11
                )
        );

        subtitleLabel.setTextFill(
                Color.GRAY
        );

        VBox content =
                new VBox(4);

        content.getChildren().addAll(
                titleLabel,
                subtitleLabel
        );

        button.setGraphic(
                content
        );

        button.setStyle(
                "-fx-background-color: #F5F7F8;" +
                "-fx-border-color: #D5DDE0;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;"
        );

        return button;
    }


    // =========================================================
    // DUE ROW
    // =========================================================

    private HBox createDueRow(
            String title,
            String date) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label titleLabel =
                new Label(
                        title
                );

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        Label dateLabel =
                new Label(
                        date
                );

        dateLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        dateLabel.setTextFill(
                Color.web("#607D8B")
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                titleLabel,
                spacer,
                dateLabel
        );

        return row;
    }
}