package com.society.view.Resident_portal;

import com.society.dao.Welcome.UserDao;
import com.society.model.Welcome.User;
import com.society.view.Welcome.LogInPage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class panel {

    // =========================================================
    // SIDEBAR
    // =========================================================

    private VBox sidebar;

    // =========================================================
    // LOGGED-IN RESIDENT EMAIL
    // =========================================================

    private static String loggedInEmail = "";

    // =========================================================
    // SET LOGGED-IN EMAIL
    // =========================================================

    public static void setLoggedInEmail(String email) {

        loggedInEmail =
                email == null
                        ? ""
                        : email.trim().toLowerCase();
    }

    // =========================================================
    // GET LOGGED-IN EMAIL
    // =========================================================

    public static String getLoggedInEmail() {

        return loggedInEmail;
    }

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public panel(Stage stage, String residentEmail) {

        // =====================================================
        // STORE LOGGED-IN RESIDENT EMAIL
        // =====================================================

        setLoggedInEmail(residentEmail);

        // =====================================================
        // SIDEBAR
        // =====================================================

        sidebar = new VBox();

        sidebar.setPrefWidth(280);
        sidebar.setPrefHeight(750);

        sidebar.setStyle(
                "-fx-background-color: #593a32"
        );

        sidebar.setSpacing(14);

        sidebar.setPadding(
                new Insets(20)
        );

        // =====================================================
        // LOGO
        // =====================================================

        Label logo =
                new Label("Society360");

        logo.setLineSpacing(10);

        logo.setAlignment(
                Pos.CENTER_LEFT
        );

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // PANEL LABEL
        // =====================================================

        Label panel =
                new Label("Secretary Panel");

        panel.setStyle(
                "-fx-text-fill: lightgray;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 5px;"
        );

        // =====================================================
        // DASHBOARD
        // =====================================================

        Button dashboardBtn =
                new Button("Dashboard");

        dashboardBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        dashboardBtn.setOnAction(event -> {

            ResidentDashboard residentDashboard =
                    new ResidentDashboard();

            Scene scene =
                    residentDashboard.getResidentDashboardScene(stage);

            stage.setScene(scene);
            stage.show();
        });

        // =====================================================
        // MY BILLS
        // =====================================================

        Button ownersBtn =
                new Button("My Bills");

        ownersBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        ownersBtn.setOnAction(event -> {

            String loginEmail =
                    UserDao.getLoggedInEmail();

            if (loginEmail == null ||
                    loginEmail.trim().isEmpty()) {

                System.out.println(
                        "No logged-in resident found."
                );

                return;
            }

            loginEmail =
                    loginEmail.trim();

            Mybills bills =
                    new Mybills(loginEmail);

            stage.setScene(
                    bills.getBillScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // VISITORS
        // =====================================================

        Button guardsBtn =
                new Button("Visitors");

        guardsBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        guardsBtn.setOnAction(event -> {

            Visitor visitor =
                    new Visitor();

            stage.setScene(
                    visitor.getVisitorScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // AMENITIES BOOKING
        // =====================================================

        Button noticesBtn =
                new Button("Amenities Booking");

        noticesBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        noticesBtn.setOnAction(event -> {

            String loginEmail =
                    UserDao.getLoggedInEmail();

            if (loginEmail == null ||
                    loginEmail.trim().isEmpty()) {

                System.out.println(
                        "No logged-in resident found."
                );

                return;
            }

            loginEmail =
                    loginEmail.trim();

            UserDao dao =
                    new UserDao();

            User resident =
                    dao.getUserByEmail(loginEmail);

            if (resident == null) {

                System.out.println(
                        "Resident profile not found for: "
                                + loginEmail
                );

                return;
            }

            String residentName =
                    resident.getName();

            String flatNo =
                    resident.getFlatNo();

            if (residentName == null) {
                residentName = "";
            }

            if (flatNo == null) {
                flatNo = "";
            }

            AmenitiesBooking amenitiesBooking =
                    new AmenitiesBooking(
                            residentName,
                            flatNo,
                            loginEmail
                    );

            stage.setScene(
                    amenitiesBooking.getAminityScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // NOTICE
        // =====================================================

        Button complaintsBtn =
                new Button("Notice");

        complaintsBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        complaintsBtn.setOnAction(event -> {

            Notice community =
                    new Notice();

            stage.setScene(
                    community.getResidentbtScene(
                            stage,
                            residentEmail
                    )
            );

            stage.show();
        });

        // =====================================================
        // COMPLAINTS
        // =====================================================

        Button paymentsBtn =
                new Button("Complaints");

        paymentsBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        paymentsBtn.setOnAction(event -> {

            Complaint complaint =
                    new Complaint();

            stage.setScene(
                    complaint.getComplaintScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // COMMUNITY
        // =====================================================

        Button cumunityButton =
                new Button("community");

        cumunityButton.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        cumunityButton.setOnAction(event -> {

            Community community =
                    new Community(residentEmail);

            stage.setScene(
                    community.getCommunityScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // EMERGENCY SOS
        // =====================================================

        Button sosBtn =
                new Button("Emergency SOS");

        sosBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        sosBtn.setOnAction(event -> {

            Emergency emergency =
                    new Emergency();

            stage.setScene(
                    emergency.getEmergencyScene(
                            stage,
                            residentEmail
                    )
            );

            stage.show();
        });

        // =====================================================
        // POLLS & SURVEYS
        // =====================================================

        Button eventsBtn =
                new Button("Polls& Surveys");

        eventsBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        eventsBtn.setOnAction(event -> {

            String email =
                    getLoggedInEmail();

            if (email == null ||
                    email.trim().isEmpty()) {

                System.out.println(
                        "Polls & Surveys: logged-in resident email is missing."
                );

                return;
            }

            PollsSurveys pollsSurveys =
                    new PollsSurveys(
                            stage,
                            email
                    );

            stage.setScene(
                    pollsSurveys.createScene()
            );
        });

        // =====================================================
        // DOCUMENTS
        // =====================================================

        Button reportsBtn =
                new Button("Documents");

        reportsBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        reportsBtn.setOnAction(event -> {

            Document document =
                    new Document();

            stage.setScene(
                    document.getDocumentScene(
                            stage,
                            residentEmail
                    )
            );

            stage.show();
        });

        // =====================================================
        // PROFILE
        // =====================================================

        Button profileBtn =
                new Button("Profile");

        profileBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        profileBtn.setOnAction(event -> {

            ProfilePage profile =
                    new ProfilePage();

            stage.setScene(
                    profile.getProfileScene(
                            stage,
                            residentEmail
                    )
            );

            stage.show();
        });

        // =====================================================
        // PARKING
        // =====================================================

        Button Parkingbtn =
                new Button("Parking");

        Parkingbtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        Parkingbtn.setOnAction(event -> {

            // =================================================
            // USE THE SAME LOGGED-IN RESIDENT EMAIL
            // =================================================

            String loginEmail =
                    getLoggedInEmail();

            if (loginEmail == null ||
                    loginEmail.trim().isEmpty()) {

                System.out.println(
                        "Parking: logged-in resident email is missing."
                );

                return;
            }

            loginEmail =
                    loginEmail.trim();

            System.out.println(
                    "========================================");

            System.out.println(
                    "OPENING RESIDENT PARKING");

            System.out.println(
                    "Resident Email : " + loginEmail);

            System.out.println(
                    "========================================");

            // =================================================
            // OPEN PARKING WITH RESIDENT EMAIL
            // =================================================

            Parking parking =
                    new Parking();

            stage.setScene(
                    parking.getParkingScene(
                            stage,
                            loginEmail
                    )
            );

            stage.show();
        });

        // =====================================================
        // LOGOUT
        // =====================================================

        Button logoutBtn =
                new Button("Logout");

        logoutBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-alignment: CENTER-LEFT;" +
                "-fx-pref-width: 240px;" +
                "-fx-pref-height: 40px;"
        );

        logoutBtn.setOnAction(event -> {

            // Clear resident email from sidebar session
            setLoggedInEmail("");

            LogInPage loginPage =
                    new LogInPage();

            stage.setScene(
                    loginPage.createScene(stage)
            );

            stage.show();
        });

        // =====================================================
        // ADD ALL SIDEBAR COMPONENTS
        // =====================================================

        sidebar.getChildren().addAll(
                logo,
                panel,
                dashboardBtn,
                ownersBtn,
                guardsBtn,
                noticesBtn,
                complaintsBtn,
                paymentsBtn,
                sosBtn,
                cumunityButton,
                eventsBtn,
                reportsBtn,
                profileBtn,
                Parkingbtn,
                logoutBtn
        );
    }

    // =========================================================
    // GET SIDEBAR
    // =========================================================

    public VBox getSidebar() {

        return sidebar;
    }
}