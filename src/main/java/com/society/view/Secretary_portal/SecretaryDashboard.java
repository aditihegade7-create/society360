package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.society.controller.Secretary_Controller.DashboardController;
import com.society.model.Secretary_model.DashboardData;
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

    private Scene SecretaryDash;

    // ============================================================
    // CONTROLLER
    // ============================================================

    private DashboardController dashboardController;

    // ============================================================
    // DYNAMIC DASHBOARD LABELS
    // ============================================================

    private Label residentsCount;
    private Label ownersCount;
    private Label guardsCount;
    private Label complaintsCount;
    private Label maintenanceAmount;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================

    public SecretaryDashboard() {

        dashboardController =
                new DashboardController();
    }

    // ============================================================
    // CREATE SCENE
    // ============================================================

    public Scene createScene(Stage stage) {

        // ========================================================
        // SIDEBAR
        // ========================================================

        VBox sidebar =
                new VBox();

        sidebar.setPrefWidth(280);
        sidebar.setMinWidth(280);
        sidebar.setPrefHeight(
                ScreenSize.getHeight()
        );

        sidebar.setSpacing(10);
        sidebar.setPadding(
                new Insets(20)
        );

        sidebar.setStyle(
                "-fx-background-color:#4e4b4b;"
        );

        // ========================================================
        // LOGO
        // ========================================================

        Label logo =
                new Label("Society360");

        logo.setAlignment(
                Pos.CENTER_LEFT
        );

        logo.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;"
        );

        // ========================================================
        // PANEL
        // ========================================================

        Label panel =
                new Label("Secretary Panel");

        panel.setStyle(
                "-fx-text-fill:lightgray;" +
                "-fx-font-size:14px;" +
                "-fx-padding:5px;"
        );

        // ========================================================
        // DASHBOARD
        // ========================================================

        Button dashboardBtn =
                createMenuButton("Dashboard");

        dashboardBtn.setOnAction(e -> {

            SecretaryDashboard dashboard =
                    new SecretaryDashboard();

            stage.setScene(
                    dashboard.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE RESIDENTS
        // ========================================================

        Button residentsBtn =
                createMenuButton("Manage Residents");

        residentsBtn.setOnAction(e -> {

            ManageResidents residents =
                    new ManageResidents();

            stage.setScene(
                    residents.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE OWNERS
        // ========================================================

        Button ownersBtn =
                createMenuButton("Manage Owners");

        ownersBtn.setOnAction(e -> {

            ManageOwner owners =
                    new ManageOwner();

            stage.setScene(
                    owners.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE GUARDS
        // ========================================================

        Button guardsBtn =
                createMenuButton("Manage Guards");

        guardsBtn.setOnAction(e -> {

            ManageGuard guards =
                    new ManageGuard();

            stage.setScene(
                    guards.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE NOTICES
        // ========================================================

        Button noticesBtn =
                createMenuButton("Manage Notices");

        noticesBtn.setOnAction(e -> {

            ManageNotices notices =
                    new ManageNotices();

            stage.setScene(
                    notices.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE COMPLAINTS
        // ========================================================

        Button complaintsBtn =
                createMenuButton("Manage Complaints");

        complaintsBtn.setOnAction(e -> {

            ManageComplaints complaints =
                    new ManageComplaints();

            stage.setScene(
                    complaints.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE MAINTENANCE
        // ========================================================

        Button maintenanceBtn =
                createMenuButton("Manage Maintenance");

        maintenanceBtn.setOnAction(e -> {

            ManageMaintenance maintenance =
                    new ManageMaintenance();

            stage.setScene(
                    maintenance.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE PAYMENTS
        // ========================================================

        Button paymentsBtn =
                createMenuButton("Manage Payments");

        paymentsBtn.setOnAction(e -> {

            ManagePayment payment =
                    new ManagePayment();

            stage.setScene(
                    payment.createScene(stage)
            );
        });

        // ========================================================
        // SOS
        // ========================================================

        Button sosBtn =
                createMenuButton("View SOS Alerts");

        sosBtn.setOnAction(e -> {

            ViewSos sos =
                    new ViewSos();

            stage.setScene(
                    sos.createScene(stage)
            );
        });

        // ========================================================
        // MANAGE EVENTS
        // ========================================================

        Button eventsBtn =
                createMenuButton("Manage Events");

        eventsBtn.setOnAction(e -> {

            ManageEvents events =
                    new ManageEvents();

            stage.setScene(
                    events.createScene(stage)
            );
        });

        // ========================================================
        // REPORTS
        // ========================================================

        Button reportsBtn =
                createMenuButton("Generate Reports");

        reportsBtn.setOnAction(e -> {

            GenerateReports report =
                    new GenerateReports();

            stage.setScene(
                    report.createScene(stage)
            );
        });

        // ========================================================
        // PROFILE
        // ========================================================

        Button profileBtn =
                createMenuButton("Profile");

        profileBtn.setOnAction(e -> {

            Profile profile =
                    new Profile();

            stage.setScene(
                    profile.createScene(stage)
            );
        });

        // ========================================================
        // LOGOUT
        // ========================================================

        Button logoutBtn =
                createMenuButton("Logout");

        logoutBtn.setOnAction(e -> {

            Logout logout =
                    new Logout();

            stage.setScene(
                    logout.createScene(stage)
            );
        });

        // ========================================================
        // ADD ALL BUTTONS TO SIDEBAR
        // ========================================================

        sidebar.getChildren().addAll(

                logo,
                panel,

                dashboardBtn,
                residentsBtn,
                ownersBtn,
                guardsBtn,
                noticesBtn,
                complaintsBtn,
                maintenanceBtn,
                paymentsBtn,
                sosBtn,
                eventsBtn,
                reportsBtn,
                profileBtn,
                logoutBtn
        );

        // ========================================================
        // HEADER
        // ========================================================

        HBox header =
                new HBox();

        header.setPrefHeight(80);

        header.setPadding(
                new Insets(20)
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // ========================================================
        // GREETING
        // ========================================================

        Label greeting =
                new Label(
                        getGreeting()
                                + ", Secretary 👋"
                );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // ========================================================
        // HEADER SPACER
        // ========================================================

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // ========================================================
        // NOTIFICATION
        // ========================================================

        Label notification =
                new Label("🔔");

        notification.setStyle(
                "-fx-font-size:20px;"
        );

        // ========================================================
        // CURRENT DATE
        // ========================================================

        LocalDate today =
                LocalDate.now();

        Label day =
                new Label(
                        today.format(
                                DateTimeFormatter.ofPattern(
                                        "EEEE"
                                )
                        )
                );

        day.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        Label date =
                new Label(
                        today.format(
                                DateTimeFormatter.ofPattern(
                                        "dd MMMM yyyy"
                                )
                        )
                );

        date.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#555555;"
        );

        VBox dateBox =
                new VBox(
                        2,
                        day,
                        date
                );

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        // ========================================================
        // ADD HEADER COMPONENTS
        // ========================================================

        header.getChildren().addAll(
                greeting,
                spacer,
                notification,
                dateBox
        );

        // ========================================================
        // RESIDENTS CARD
        // ========================================================

        VBox residentsCard =
                createDashboardCard(
                        "Residents",
                        "Total Residents"
                );

        residentsCount =
                (Label)
                residentsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // OWNERS CARD
        // ========================================================

        VBox ownersCard =
                createDashboardCard(
                        "Owners",
                        "Total Owners"
                );

        ownersCount =
                (Label)
                ownersCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // GUARDS CARD
        // ========================================================

        VBox guardsCard =
                createDashboardCard(
                        "Guards",
                        "Total Guards"
                );

        guardsCount =
                (Label)
                guardsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // COMPLAINTS CARD
        // ========================================================

        VBox complaintsCard =
                createDashboardCard(
                        "Complaints",
                        "Open Complaints"
                );

        complaintsCount =
                (Label)
                complaintsCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // MAINTENANCE CARD
        // ========================================================

        VBox maintenanceCard =
                createDashboardCard(
                        "Maintenance",
                        "Total Collected"
                );

        maintenanceAmount =
                (Label)
                maintenanceCard
                        .getChildren()
                        .get(1);

        // ========================================================
        // CARDS ROW
        // ========================================================

        HBox cardsRow =
                new HBox();

        cardsRow.setSpacing(20);

        cardsRow.setPadding(
                new Insets(20)
        );

        cardsRow.setStyle(
                "-fx-background-color:#b3adad;"
        );

        cardsRow.getChildren().addAll(

                residentsCard,
                ownersCard,
                guardsCard,
                complaintsCard,
                maintenanceCard
        );

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
                recentSOS
        );

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
                        20
                )
        );

        lowerContent.setStyle(
                "-fx-background-color:#b3adad;"
        );

        lowerContent.getChildren().addAll(

                leftColumn,
                todayOverview,
                upcomingEvents
        );

        // ========================================================
        // MAIN CONTENT
        // ========================================================

        VBox mainContent =
                new VBox();

        mainContent.setStyle(
                "-fx-background-color:#b3adad;"
        );

        mainContent.setMaxWidth(
                Double.MAX_VALUE
        );

        mainContent.getChildren().addAll(

                header,
                cardsRow,
                lowerContent
        );

        HBox.setHgrow(
                mainContent,
                Priority.ALWAYS
        );

        // ========================================================
        // BODY
        // ========================================================

        HBox body =
                new HBox();

        body.setSpacing(0);

        body.getChildren().addAll(

                sidebar,
                mainContent
        );

        // ========================================================
        // SCROLL PANE
        // ========================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                body
        );

        scrollPane.setFitToHeight(true);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background:#b3adad;" +
                "-fx-background-color:#b3adad;"
        );

        // ========================================================
        // ROOT
        // ========================================================

        VBox root =
                new VBox();

        root.setStyle(
                "-fx-background-color:#b3adad;"
        );

        root.getChildren().add(
                scrollPane
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        // ========================================================
        // SCENE
        // ========================================================

        Scene scene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        SecretaryDash =
                scene;

        // ========================================================
        // LOAD FIRESTORE DATA
        // ========================================================

        loadDashboardData();

        return SecretaryDash;
    }

    // ============================================================
    // MENU BUTTON
    // ============================================================

    private Button createMenuButton(
            String text) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setPrefHeight(40);

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:14px;" +
                "-fx-alignment:CENTER-LEFT;" +
                "-fx-padding:0 15 0 15;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color:#5a5757;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-size:14px;" +
                    "-fx-alignment:CENTER-LEFT;" +
                    "-fx-padding:0 15 0 15;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-size:14px;" +
                    "-fx-alignment:CENTER-LEFT;" +
                    "-fx-padding:0 15 0 15;"
            );
        });

        return button;
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
                new Insets(20)
        );

        card.setSpacing(8);

        card.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        // ========================================================
        // CARD TITLE
        // ========================================================

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#666666;"
        );

        // ========================================================
        // CARD COUNT
        // ========================================================

        Label countLabel =
                new Label("0");

        countLabel.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // ========================================================
        // CARD BOTTOM TEXT
        // ========================================================

        Label bottomLabel =
                new Label(bottomText);

        bottomLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        card.getChildren().addAll(

                titleLabel,
                countLabel,
                bottomLabel
        );

        return card;
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
                new Insets(20)
        );

        box.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:#E5E7EB;" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;"
        );

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label("Quick Actions");

        title.setStyle(
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#183B56;"
        );

        // ========================================================
        // ADD RESIDENT
        // ========================================================

        Button addResident =
                new Button(
                        "👥   Add Resident"
                );

        // ========================================================
        // ADD NOTICE
        // ========================================================

        Button addNotice =
                new Button(
                        "▣   Add Notice"
                );

        // ========================================================
        // VIEW PAYMENTS
        // ========================================================

        Button viewPayments =
                new Button(
                        "▣   View Payments"
                );

        addResident.setMaxWidth(
                Double.MAX_VALUE
        );

        addNotice.setMaxWidth(
                Double.MAX_VALUE
        );

        viewPayments.setMaxWidth(
                Double.MAX_VALUE
        );

        // ========================================================
        // BUTTON STYLE
        // ========================================================

        String buttonStyle =
                "-fx-background-color:#f4f6f7;" +
                "-fx-text-fill:#183B56;" +
                "-fx-font-size:13px;" +
                "-fx-alignment:CENTER-LEFT;" +
                "-fx-padding:12px;";

        addResident.setStyle(buttonStyle);

        addNotice.setStyle(buttonStyle);

        viewPayments.setStyle(buttonStyle);

        // ========================================================
        // ADD RESIDENT ACTION
        // ========================================================

        addResident.setOnAction(e -> {

            ManageResidents residents =
                    new ManageResidents();

            stage.setScene(
                    residents.createScene(stage)
            );
        });

        // ========================================================
        // ADD NOTICE ACTION
        // ========================================================

        addNotice.setOnAction(e -> {

            ManageNotices notices =
                    new ManageNotices();

            stage.setScene(
                    notices.createScene(stage)
            );
        });

        // ========================================================
        // VIEW PAYMENTS ACTION
        // ========================================================

        viewPayments.setOnAction(e -> {

            ManagePayment payment =
                    new ManagePayment();

            stage.setScene(
                    payment.createScene(stage)
            );
        });

        // ========================================================
        // ADD BUTTONS
        // ========================================================

        box.getChildren().addAll(

                title,
                addResident,
                addNotice,
                viewPayments
        );

        return box;
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
                new Insets(18)
        );

        box.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:#E5E7EB;" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;"
        );

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label("Today's Overview");

        title.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#183B56;"
        );

        // ========================================================
        // INFORMATION
        // ========================================================

        Label info1 =
                new Label("Residents Data");

        Label info2 =
                new Label("Owners Data");

        Label info3 =
                new Label("Guards Data");

        Label info4 =
                new Label("Complaints Data");

        Label info5 =
                new Label("Maintenance Data");

        styleOverviewLabel(info1);
        styleOverviewLabel(info2);
        styleOverviewLabel(info3);
        styleOverviewLabel(info4);
        styleOverviewLabel(info5);

        // ========================================================
        // NOTE
        // ========================================================

        Label note =
                new Label(
                        "Dashboard data is fetched from Firestore."
                );

        note.setWrapText(true);

        note.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#777777;" +
                "-fx-padding:10px;"
        );

        // ========================================================
        // ADD CONTENT
        // ========================================================

        box.getChildren().addAll(

                title,
                info1,
                info2,
                info3,
                info4,
                info5,
                note
        );

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
                new Insets(18)
        );

        box.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:#E5E7EB;" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;"
        );

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label("Upcoming Events");

        title.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#183B56;"
        );

        // ========================================================
        // EVENT INFORMATION
        // ========================================================

        Label eventInfo =
                new Label(
                        "No event data loaded yet."
                );

        eventInfo.setWrapText(true);

        eventInfo.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#555555;" +
                "-fx-padding:8px;"
        );

        // ========================================================
        // VIEW EVENTS BUTTON
        // ========================================================

        Button viewEvents =
                new Button(
                        "View All Events"
                );

        viewEvents.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#4169A1;" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );

        viewEvents.setOnAction(e -> {

            ManageEvents events =
                    new ManageEvents();

            stage.setScene(
                    events.createScene(stage)
            );
        });

        // ========================================================
        // ADD CONTENT
        // ========================================================

        box.getChildren().addAll(

                title,
                eventInfo,
                viewEvents
        );

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
                new Insets(18)
        );

        box.setStyle(
                "-fx-background-color:white;" +
                "-fx-border-color:#E5E7EB;" +
                "-fx-border-radius:10;" +
                "-fx-background-radius:10;"
        );

        // ========================================================
        // TITLE ROW
        // ========================================================

        HBox titleRow =
                new HBox();

        titleRow.setAlignment(
                Pos.CENTER_LEFT
        );

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label(
                        "Recent SOS Alerts"
                );

        title.setStyle(
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#D9534F;"
        );

        // ========================================================
        // SPACER
        // ========================================================

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // ========================================================
        // VIEW ALL
        // ========================================================

        Button viewAll =
                new Button(
                        "View All"
                );

        viewAll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#4169A1;" +
                "-fx-font-size:13px;"
        );

        viewAll.setOnAction(e -> {

            ViewSos sos =
                    new ViewSos();

            stage.setScene(
                    sos.createScene(stage)
            );
        });

        titleRow.getChildren().addAll(

                title,
                spacer,
                viewAll
        );

        // ========================================================
        // MESSAGE
        // ========================================================

        Label message =
                new Label(
                        "No recent SOS alerts."
                );

        message.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;" +
                "-fx-padding:8px;"
        );

        // ========================================================
        // ADD CONTENT
        // ========================================================

        box.getChildren().addAll(

                titleRow,
                message
        );

        return box;
    }

    // ============================================================
    // LOAD DASHBOARD DATA
    // ============================================================

    private void loadDashboardData() {

        try {

            System.out.println(
                    "Fetching Dashboard data from Firestore..."
            );

            DashboardData data =
                    dashboardController
                            .getDashboardData();

            // ====================================================
            // NULL CHECK
            // ====================================================

            if (data == null) {

                System.out.println(
                        "DashboardData is null."
                );

                setDefaultValues();

                return;
            }

            // ====================================================
            // RESIDENTS
            // ====================================================

            residentsCount.setText(
                    String.valueOf(
                            data.getTotalResidents()
                    )
            );

            // ====================================================
            // OWNERS
            // ====================================================

            ownersCount.setText(
                    String.valueOf(
                            data.getTotalOwners()
                    )
            );

            // ====================================================
            // GUARDS
            // ====================================================

            guardsCount.setText(
                    String.valueOf(
                            data.getTotalGuards()
                    )
            );

            // ====================================================
            // COMPLAINTS
            // ====================================================

            complaintsCount.setText(
                    String.valueOf(
                            data.getOpenComplaints()
                    )
            );

            // ====================================================
            // MAINTENANCE
            // ====================================================

            maintenanceAmount.setText(
                    "₹ "
                            + formatAmount(
                                    data.getMaintenanceCollection()
                            )
            );

            // ====================================================
            // CONSOLE
            // ====================================================

            System.out.println(
                    "Dashboard data fetched successfully."
            );

            System.out.println(
                    "Residents: "
                            + data.getTotalResidents()
            );

            System.out.println(
                    "Owners: "
                            + data.getTotalOwners()
            );

            System.out.println(
                    "Guards: "
                            + data.getTotalGuards()
            );

            System.out.println(
                    "Open Complaints: "
                            + data.getOpenComplaints()
            );

            System.out.println(
                    "Maintenance: ₹"
                            + data.getMaintenanceCollection()
            );

        } catch (Exception e) {

            System.out.println(
                    "Dashboard data fetch error: "
                            + e.getMessage()
            );

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
                    (long) amount
            );
        }

        return String.format(
                "%.2f",
                amount
        );
    }

    // ============================================================
    // OVERVIEW LABEL STYLE
    // ============================================================

    private void styleOverviewLabel(
            Label label) {

        label.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#555555;" +
                "-fx-padding:7px;"
        );
    }

    // ============================================================
    // GREETING
    // ============================================================

    private String getGreeting() {

        int hour =
                java.time.LocalTime
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