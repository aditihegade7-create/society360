package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.society.controller.Secretary_Controller.DashboardController;
import com.society.model.Secretary_model.DashboardData;
import com.society.model.Welcome.User;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SecretaryDashboard {

    // ============================================================
    // SCENE
    // ============================================================

    private Scene secretaryDash;

    // ============================================================
    // CONTROLLER
    // ============================================================

    private DashboardController dashboardController;

    // ============================================================
    // DASHBOARD LABELS
    // ============================================================

    private Label residentsCount;
    private Label ownersCount;
    private Label guardsCount;
    private Label complaintsCount;
    private Label maintenanceAmount;

    // ============================================================
    // LOGGED-IN USER
    // ============================================================

    private User loggedInUser;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public SecretaryDashboard(User loggedInUser) {

        this.loggedInUser = loggedInUser;

        this.dashboardController =
                new DashboardController();

        System.out.println(
                "================================================");

        System.out.println(
                "SecretaryDashboard opened");

        System.out.println(
                "Secretary Dashboard User Email: "
                        + getUserEmail());

        System.out.println(
                "================================================");
    }

    // ============================================================
    // GET USER EMAIL
    // ============================================================

    private String getUserEmail() {

        if (loggedInUser == null) {
            return "NULL";
        }

        if (loggedInUser.getEmail() == null) {
            return "NULL";
        }

        return loggedInUser.getEmail();
    }

    // ============================================================
    // CREATE SCENE
    // ============================================================

    public Scene createScene(Stage stage) {

        // ========================================================
        // CHECK LOGGED-IN USER
        // ========================================================

        if (loggedInUser == null) {

            System.out.println(
                    "WARNING: SecretaryDashboard has NULL User.");

        } else {

            System.out.println(
                    "Dashboard logged-in email: "
                            + loggedInUser.getEmail());
        }

        // ========================================================
        // SIDEBAR
        // ========================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar(loggedInUser);

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // ========================================================
        // HEADER
        // ========================================================

        HBox header =
                new HBox();

        header.setPrefHeight(80);

        header.setPadding(
                new Insets(20));

        header.setAlignment(
                Pos.CENTER_LEFT);

        header.setStyle(
                "-fx-background-color:#b3adad;");

        // ========================================================
        // GREETING
        // ========================================================

        Label greeting =
                new Label(
                        getGreeting()
                                + ", Secretary 👋");

        greeting.setStyle(
                "-fx-font-size:24px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#434141;");

        // ========================================================
        // SPACER
        // ========================================================

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        // ========================================================
        // NOTIFICATION
        // ========================================================

        Label notification =
                new Label("🔔");

        notification.setStyle(
                "-fx-font-size:20px;");

        // ========================================================
        // DATE
        // ========================================================

        LocalDate today =
                LocalDate.now();

        Label day =
                new Label(
                        today.format(
                                DateTimeFormatter.ofPattern(
                                        "EEEE")));

        day.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-font-weight:bold;");

        Label date =
                new Label(
                        today.format(
                                DateTimeFormatter.ofPattern(
                                        "dd MMMM yyyy")));

        date.setStyle(
                "-fx-font-size:12px;"
                        + "-fx-text-fill:#555555;");

        VBox dateBox =
                new VBox(
                        2,
                        day,
                        date);

        dateBox.setAlignment(
                Pos.CENTER_RIGHT);

        header.getChildren().addAll(
                greeting,
                spacer,
                notification,
                dateBox);

        // ========================================================
        // RESIDENTS CARD
        // ========================================================

        VBox residentsCard =
                createDashboardCard(
                        "Residents",
                        "Total Residents");

        residentsCount =
                (Label) residentsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // OWNERS CARD
        // ========================================================

        VBox ownersCard =
                createDashboardCard(
                        "Owners",
                        "Total Owners");

        ownersCount =
                (Label) ownersCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // GUARDS CARD
        // ========================================================

        VBox guardsCard =
                createDashboardCard(
                        "Guards",
                        "Total Guards");

        guardsCount =
                (Label) guardsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // COMPLAINTS CARD
        // ========================================================

        VBox complaintsCard =
                createDashboardCard(
                        "Complaints",
                        "Open Complaints");

        complaintsCount =
                (Label) complaintsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // MAINTENANCE CARD
        // ========================================================

        VBox maintenanceCard =
                createDashboardCard(
                        "Maintenance",
                        "Total Maitenance");

        maintenanceAmount =
                (Label) maintenanceCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // CARDS ROW
        // ========================================================

        HBox cardsRow =
                new HBox();

        cardsRow.setSpacing(20);

        cardsRow.setPadding(
                new Insets(20));

        cardsRow.setStyle(
                "-fx-background-color:#b3adad;");

        cardsRow.getChildren().addAll(
                residentsCard,
                ownersCard,
                guardsCard,
                complaintsCard,
                maintenanceCard);

        // ========================================================
        // QUICK ACTIONS
        // ========================================================

        VBox quickActions =
                createQuickActions(stage);

        // ========================================================
        // TODAY OVERVIEW
        // ========================================================

        VBox todayOverview =
                createTodayOverview();

        // ========================================================
        // UPCOMING EVENTS
        // ========================================================

        VBox upcomingEvents =
                createUpcomingEvents(stage);

        // ========================================================
        // RECENT SOS
        // ========================================================

        VBox recentSOS =
                createRecentSOS(stage);

        // ========================================================
        // LEFT COLUMN
        // ========================================================

        VBox leftColumn =
                new VBox();

        leftColumn.setSpacing(20);

        leftColumn.getChildren().addAll(
                quickActions,
                recentSOS);

        // ========================================================
        // LOWER CONTENT
        // ========================================================

        HBox lowerContent =
                new HBox();

        lowerContent.setSpacing(20);

        lowerContent.setPadding(
                new Insets(
                        0,
                        20,
                        20,
                        20));

        lowerContent.setStyle(
                "-fx-background-color:#b3adad;");

        lowerContent.getChildren().addAll(
                leftColumn,
                todayOverview,
                upcomingEvents);

        // ========================================================
        // MAIN CONTENT
        // ========================================================

        VBox mainContent =
                new VBox();

        mainContent.setStyle(
                "-fx-background-color:#b3adad;");

        mainContent.setMaxWidth(
                Double.MAX_VALUE);

        mainContent.getChildren().addAll(
                header,
                cardsRow,
                lowerContent);

        HBox.setHgrow(
                mainContent,
                Priority.ALWAYS);

        // ========================================================
        // BODY
        // ========================================================

        HBox body =
                new HBox();

        body.setSpacing(0);

        body.getChildren().addAll(
                sidebar,
                mainContent);

        // ========================================================
        // SCROLL PANE
        // ========================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(body);

        scrollPane.setFitToHeight(true);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED);

        scrollPane.setStyle(
                "-fx-background:#b3adad;"
                        + "-fx-background-color:#b3adad;");

        // ========================================================
        // ROOT
        // ========================================================

        VBox root =
                new VBox();

        root.setStyle(
                "-fx-background-color:#b3adad;");

        root.getChildren().add(
                scrollPane);

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS);

        // ========================================================
        // SCENE
        // ========================================================

        secretaryDash =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight());

        // ========================================================
        // LOAD DASHBOARD DATA
        // ========================================================

        loadDashboardData();

        return secretaryDash;
    }

    // ============================================================
    // QUICK ACTIONS
    // ============================================================

    private VBox createQuickActions(
            Stage stage) {

        VBox box =
                new VBox();

        box.setPrefWidth(330);

        box.setMinWidth(300);

        box.setPrefHeight(280);

        box.setSpacing(10);

        box.setPadding(
                new Insets(20));

        box.setStyle(
                "-fx-background-color:white;"
                        + "-fx-border-color:#E5E7EB;"
                        + "-fx-border-radius:10;"
                        + "-fx-background-radius:10;");

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label(
                        "Quick Actions");

        title.setStyle(
                "-fx-font-size:17px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#183B56;");

        // ========================================================
        // BUTTONS
        // ========================================================

        Button addResident =
                new Button(
                        "👥   Add Resident");

        Button addNotice =
                new Button(
                        "▣   Add Notice");

        Button viewPayments =
                new Button(
                        "▣   View Payments");

        addResident.setMaxWidth(
                Double.MAX_VALUE);

        addNotice.setMaxWidth(
                Double.MAX_VALUE);

        viewPayments.setMaxWidth(
                Double.MAX_VALUE);

        String buttonStyle =
                "-fx-background-color:#f4f6f7;"
                        + "-fx-text-fill:#183B56;"
                        + "-fx-font-size:13px;"
                        + "-fx-alignment:CENTER-LEFT;"
                        + "-fx-padding:12px;";

        addResident.setStyle(buttonStyle);
        addNotice.setStyle(buttonStyle);
        viewPayments.setStyle(buttonStyle);

        // ========================================================
        // ADD RESIDENT
        // ========================================================

        addResident.setOnAction(e -> {

            ManageEvents residents =
                    new ManageEvents();

            stage.setScene(
                    residents.createScene(stage));
        });

        // ========================================================
        // ADD NOTICE
        // ========================================================

        addNotice.setOnAction(e -> {

            System.out.println(
                    "Quick Action Notice Email: "
                            + getUserEmail());

            if (loggedInUser == null) {

                System.out.println(
                        "ERROR: Cannot open ManageNotices."
                                + " loggedInUser is NULL.");

                return;
            }

            ManageNotices notices =
                    new ManageNotices(loggedInUser);

            stage.setScene(
                    notices.createScene(stage));
        });

        // ========================================================
        // PAYMENTS
        // ========================================================

        viewPayments.setOnAction(e -> {

            ManagePayment payment =
                    new ManagePayment();

            stage.setScene(
                    payment.createScene(stage));
        });

        box.getChildren().addAll(
                title,
                addResident,
                addNotice,
                viewPayments);

        return box;
    }

    // ============================================================
    // DASHBOARD CARD
    // ============================================================

    private VBox createDashboardCard(
            String title,
            String bottomText) {

        VBox card =
                new VBox();

        card.setPrefWidth(200);

        card.setMinWidth(170);

        card.setPrefHeight(130);

        card.setPadding(
                new Insets(20));

        card.setSpacing(8);

        card.setStyle(
                "-fx-background-color:white;"
                        + "-fx-background-radius:10;");

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size:14px;"
                        + "-fx-text-fill:#666666;");

        Label countLabel =
                new Label("0");

        countLabel.setStyle(
                "-fx-font-size:28px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#123C36;");

        Label bottomLabel =
                new Label(bottomText);

        bottomLabel.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-text-fill:#777777;");

        card.getChildren().addAll(
                titleLabel,
                countLabel,
                bottomLabel);

        return card;
    }

    // ============================================================
    // TODAY OVERVIEW
    // ============================================================

    private VBox createTodayOverview() {

        VBox box =
                new VBox();

        box.setPrefWidth(330);

        box.setMinWidth(300);

        box.setPrefHeight(480);

        box.setSpacing(12);

        box.setPadding(
                new Insets(18));

        box.setStyle(
                "-fx-background-color:white;"
                        + "-fx-border-color:#E5E7EB;"
                        + "-fx-border-radius:10;"
                        + "-fx-background-radius:10;");

        Label title =
                new Label(
                        "Today's Overview");

        title.setStyle(
                "-fx-font-size:18px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#183B56;");

        Label info1 =
                new Label(
                        "Residents Data");

        Label info2 =
                new Label(
                        "Owners Data");

        Label info3 =
                new Label(
                        "Guards Data");

        Label info4 =
                new Label(
                        "Complaints Data");

        Label info5 =
                new Label(
                        "Maintenance Data");

        styleOverviewLabel(info1);
        styleOverviewLabel(info2);
        styleOverviewLabel(info3);
        styleOverviewLabel(info4);
        styleOverviewLabel(info5);

        Label note =
                new Label(
                        "Dashboard data is fetched from Firestore.");

        note.setWrapText(true);

        note.setStyle(
                "-fx-font-size:12px;"
                        + "-fx-text-fill:#777777;"
                        + "-fx-padding:10px;");

        box.getChildren().addAll(
                title,
                info1,
                info2,
                info3,
                info4,
                info5,
                note);

        return box;
    }

    // ============================================================
    // UPCOMING EVENTS
    // ============================================================

    private VBox createUpcomingEvents(
            Stage stage) {

        VBox box =
                new VBox();

        box.setPrefWidth(330);

        box.setMinWidth(300);

        box.setPrefHeight(480);

        box.setSpacing(12);

        box.setPadding(
                new Insets(18));

        box.setStyle(
                "-fx-background-color:white;"
                        + "-fx-border-color:#E5E7EB;"
                        + "-fx-border-radius:10;"
                        + "-fx-background-radius:10;");

        Label title =
                new Label(
                        "Upcoming Events");

        title.setStyle(
                "-fx-font-size:18px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#183B56;");

        Label eventInfo =
                new Label(
                        "No event data loaded yet.");

        eventInfo.setWrapText(true);

        eventInfo.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-text-fill:#555555;"
                        + "-fx-padding:8px;");

        Button viewEvents =
                new Button(
                        "View All Events");

        viewEvents.setStyle(
                "-fx-background-color:transparent;"
                        + "-fx-text-fill:#4169A1;"
                        + "-fx-font-size:13px;"
                        + "-fx-font-weight:bold;");

        viewEvents.setOnAction(e -> {

            ManageEvents events =
                    new ManageEvents();

            stage.setScene(
                    events.createScene(stage));
        });

        box.getChildren().addAll(
                title,
                eventInfo,
                viewEvents);

        return box;
    }

    // ============================================================
    // RECENT SOS
    // ============================================================

    private VBox createRecentSOS(
            Stage stage) {

        VBox box =
                new VBox();

        box.setPrefWidth(330);

        box.setMinWidth(300);

        box.setPrefHeight(180);

        box.setSpacing(10);

        box.setPadding(
                new Insets(18));

        box.setStyle(
                "-fx-background-color:white;"
                        + "-fx-border-color:#E5E7EB;"
                        + "-fx-border-radius:10;"
                        + "-fx-background-radius:10;");

        HBox titleRow =
                new HBox();

        titleRow.setAlignment(
                Pos.CENTER_LEFT);

        Label title =
                new Label(
                        "Recent SOS Alerts");

        title.setStyle(
                "-fx-font-size:17px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#D9534F;");

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        Button viewAll =
                new Button(
                        "View All");

        viewAll.setStyle(
                "-fx-background-color:transparent;"
                        + "-fx-text-fill:#4169A1;"
                        + "-fx-font-size:13px;");

        viewAll.setOnAction(e -> {

            ViewSos sos =
                    new ViewSos();

            stage.setScene(
                    sos.createScene(stage));
        });

        titleRow.getChildren().addAll(
                title,
                spacer,
                viewAll);

        Label message =
                new Label(
                        "No recent SOS alerts.");

        message.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-text-fill:#777777;"
                        + "-fx-padding:8px;");

        box.getChildren().addAll(
                titleRow,
                message);

        return box;
    }

    // ============================================================
    // LOAD DASHBOARD DATA
    // ============================================================

    private void loadDashboardData() {

        try {

            System.out.println(
                    "Fetching Dashboard data from Firestore...");

            DashboardData data =
                    dashboardController
                            .getDashboardData();

            if (data == null) {

                System.out.println(
                        "DashboardData is NULL.");

                setDefaultValues();

                return;
            }

            // ====================================================
            // RESIDENTS
            // ====================================================

            if (residentsCount != null) {

                residentsCount.setText(
                        String.valueOf(
                                data.getTotalResidents()));
            }

            // ====================================================
            // OWNERS
            // ====================================================

            if (ownersCount != null) {

                ownersCount.setText(
                        String.valueOf(
                                data.getTotalOwners()));
            }

            // ====================================================
            // GUARDS
            // ====================================================

            if (guardsCount != null) {

                guardsCount.setText(
                        String.valueOf(
                                data.getTotalGuards()));
            }

            // ====================================================
            // COMPLAINTS
            // ====================================================

            if (complaintsCount != null) {

                complaintsCount.setText(
                        String.valueOf(
                                data.getOpenComplaints()));
            }

            // ====================================================
            // MAINTENANCE
            // ====================================================

            if (maintenanceAmount != null) {

                maintenanceAmount.setText(
                        "₹ "
                                + formatAmount(
                                        data.getMaintenanceCollection()));
            }

            // ====================================================
            // DEBUG
            // ====================================================

            System.out.println(
                    "----------------------------------------");

            System.out.println(
                    "Dashboard data fetched successfully.");

            System.out.println(
                    "Residents: "
                            + data.getTotalResidents());

            System.out.println(
                    "Owners: "
                            + data.getTotalOwners());

            System.out.println(
                    "Guards: "
                            + data.getTotalGuards());

            System.out.println(
                    "Open Complaints: "
                            + data.getOpenComplaints());

            System.out.println(
                    "Maintenance: ₹"
                            + data.getMaintenanceCollection());

            System.out.println(
                    "Dashboard User Email: "
                            + getUserEmail());

            System.out.println(
                    "----------------------------------------");

        } catch (Exception e) {

            System.out.println(
                    "Dashboard data fetch error: "
                            + e.getMessage());

            e.printStackTrace();

            setDefaultValues();
        }
    }

    // ============================================================
    // DEFAULT VALUES
    // ============================================================

    private void setDefaultValues() {

        if (residentsCount != null) {

            residentsCount.setText("0");
        }

        if (ownersCount != null) {

            ownersCount.setText("0");
        }

        if (guardsCount != null) {

            guardsCount.setText("0");
        }

        if (complaintsCount != null) {

            complaintsCount.setText("0");
        }

        if (maintenanceAmount != null) {

            maintenanceAmount.setText("₹ 0");
        }
    }

    // ============================================================
    // FORMAT AMOUNT
    // ============================================================

    private String formatAmount(
            double amount) {

        if (amount == (long) amount) {

            return String.format(
                    "%d",
                    (long) amount);
        }

        return String.format(
                "%.2f",
                amount);
    }

    // ============================================================
    // OVERVIEW LABEL
    // ============================================================

    private void styleOverviewLabel(
            Label label) {

        label.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-text-fill:#555555;"
                        + "-fx-padding:7px;");
    }

    // ============================================================
    // GREETING
    // ============================================================

    private String getGreeting() {

        int hour =
                LocalTime
                        .now()
                        .getHour();

        if (hour >= 5 && hour < 12) {

            return "Good Morning";

        } else if (hour >= 12 && hour < 17) {

            return "Good Afternoon";

        } else if (hour >= 17 && hour < 21) {

            return "Good Evening";

        } else {

            return "Good Night";
        }
    }
}