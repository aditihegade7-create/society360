package com.society.controller.Resident_Controller;

import com.society.dao.Welcome.UserDao;
import com.society.model.Welcome.User;
import com.society.service.resident_service.ResidentSession;
import com.society.view.ScreenSize;

import com.society.view.Guard_portal.GuardDashboard;
import com.society.view.Owner_portal.OwnerDashboard;
import com.society.view.Resident_portal.ResidentDashboard;
import com.society.view.Secretary_portal.SecretaryDashboard;
import com.society.view.Welcome.SigninPage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LogInPage {

    // =========================================================
    // COLORS
    // =========================================================

    private static final String DARK_BROWN = "#4E342E";
    private static final String BROWN = "#4E342E";
    private static final String PRIMARY_BROWN = "#4e342e";
    private static final String LIGHT_BROWN = "#D7CCC8";
    private static final String TEXT = "#3E2723";
    private static final String WHITE = "#FFFFFF";

    // =========================================================
    // SCENE
    // =========================================================

    private Scene loginScene;

    // =========================================================
    // CREATE LOGIN SCENE
    // =========================================================

    public Scene createScene(Stage stage) {

        // =====================================================
        // MAIN ROOT
        // =====================================================

        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: "
                        + "linear-gradient(to right,#E8DDD5,#bfb1a7);"
        );

        // =====================================================
        // LEFT PANEL
        // =====================================================

        VBox leftPanel = createLeftPanel();

        StackPane.setAlignment(
                leftPanel,
                Pos.CENTER_LEFT
        );

        StackPane.setMargin(
                leftPanel,
                new Insets(
                        20,
                        20,
                        20,
                        50
                )
        );

        // =====================================================
        // LOGIN CARD
        // =====================================================

        VBox loginCard = createLoginCard(stage);

        loginCard.setPrefWidth(450);
        loginCard.setMinWidth(450);
        loginCard.setMaxWidth(450);

        loginCard.setPrefHeight(600);
        loginCard.setMaxHeight(600);

        // =====================================================
        // RIGHT SIDE
        // =====================================================

        StackPane.setAlignment(
                loginCard,
                Pos.CENTER_RIGHT
        );

        StackPane.setMargin(
                loginCard,
                new Insets(
                        20,
                        100,
                        20,
                        20
                )
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        root.getChildren().addAll(
                leftPanel,
                loginCard
        );

        // =====================================================
        // SCENE
        // =====================================================

        loginScene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        stage.setTitle(
                "Society360 - Login"
        );

        stage.setMinWidth(900);
        stage.setMinHeight(600);

        return loginScene;
    }

    // =========================================================
    // LEFT IMAGE PANEL
    // =========================================================

    private VBox createLeftPanel() {

        VBox panel = new VBox();

        panel.setPrefWidth(550);
        panel.setPrefHeight(500);

        panel.setMinWidth(550);
        panel.setMinHeight(500);

        panel.setMaxWidth(540);
        panel.setMaxHeight(500);

        panel.setAlignment(
                Pos.CENTER
        );

        panel.setPadding(
                new Insets(0)
        );

        panel.setStyle(
                "-fx-background-color:"
                        + DARK_BROWN + ";"
        );

        // =====================================================
        // LOAD IMAGE
        // =====================================================

        try {

            Image image = new Image(
                    getClass()
                            .getResourceAsStream(
                                    "/image.png"
                            )
            );

            ImageView imageView =
                    new ImageView(image);

            imageView.setFitWidth(520);
            imageView.setFitHeight(480);

            imageView.setPreserveRatio(false);
            imageView.setSmooth(true);

            StackPane imageContainer =
                    new StackPane(
                            imageView
                    );

            imageContainer.setPrefWidth(600);
            imageContainer.setPrefHeight(700);

            imageContainer.setMinWidth(600);
            imageContainer.setMinHeight(700);

            imageContainer.setMaxWidth(600);
            imageContainer.setMaxHeight(700);

            panel.getChildren().add(
                    imageContainer
            );

        } catch (Exception e) {

            // If image is not available,
            // show Society360 instead.

            Label logo =
                    new Label("Society360");

            logo.setStyle(
                    "-fx-font-size:40px;"
                            + "-fx-font-weight:bold;"
                            + "-fx-text-fill:white;"
            );

            panel.getChildren().add(
                    logo
            );
        }

        return panel;
    }

    // =========================================================
    // LOGIN CARD
    // =========================================================

    private VBox createLoginCard(Stage stage) {

        VBox card = new VBox(20);

        card.setMaxWidth(450);

        card.setPadding(
                new Insets(
                        45,
                        45,
                        40,
                        45
                )
        );

        card.setStyle(
                "-fx-background-color:#F8F3EE;"
                        + "-fx-background-radius:15;"
                        + "-fx-border-color:#c7c3bd;"
                        + "-fx-border-radius:15;"
                        + "-fx-border-width:1.5;"
                        + "-fx-effect:dropshadow("
                        + "gaussian,"
                        + "rgba(78,52,46,0.18),"
                        + "20,"
                        + "0,"
                        + "0,"
                        + "8);"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label(
                        "Welcome Back! 👋"
                );

        title.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(
                Color.web(TEXT)
        );

        // =====================================================
        // SUBTITLE
        // =====================================================

        Label subtitle =
                new Label(
                        "Login to continue to Society360"
                );

        subtitle.setFont(
                Font.font(
                        "Arial",
                        14
                )
        );

        subtitle.setTextFill(
                Color.web(BROWN)
        );

        VBox titleBox =
                new VBox(
                        6,
                        title,
                        subtitle
                );

        // =====================================================
        // EMAIL
        // =====================================================

        TextField username =
                new TextField();

        username.setPromptText(
                "Email"
        );

        username.setPrefHeight(42);

        username.setStyle(
                inputStyle()
        );

        // =====================================================
        // PASSWORD
        // =====================================================

        PasswordField password =
                new PasswordField();

        password.setPromptText(
                "Password"
        );

        password.setPrefHeight(42);

        password.setStyle(
                inputStyle()
        );

        // =====================================================
        // REMEMBER ME
        // =====================================================

        CheckBox remember =
                new CheckBox(
                        "Remember me"
                );

        remember.setTextFill(
                Color.web(TEXT)
        );

        // =====================================================
        // FORGOT PASSWORD
        // =====================================================

        Hyperlink forgot =
                new Hyperlink(
                        "Forgot Password?"
                );

        forgot.setTextFill(
                Color.web(PRIMARY_BROWN)
        );

        forgot.setOnAction(e -> {

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Forgot Password",
                    "Please contact the Society Administrator "
                            + "to reset your password."
            );
        });

        // =====================================================
        // REMEMBER ROW
        // =====================================================

        HBox rememberRow =
                new HBox();

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        rememberRow.getChildren().addAll(
                remember,
                spacer,
                forgot
        );

        rememberRow.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // LOGIN BUTTON
        // =====================================================

        Button loginButton =
                new Button(
                        "Login   →"
                );

        loginButton.setPrefHeight(52);

        loginButton.setMaxWidth(
                Double.MAX_VALUE
        );

        loginButton.setStyle(
                primaryButtonStyle()
        );

        // =====================================================
        // LOGIN ACTION
        // =====================================================

        loginButton.setOnAction(event -> {

            String email =
                    username.getText()
                            .trim();

            String passwordText =
                    password.getText();

            // =================================================
            // VALIDATION
            // =================================================

            if (email.isEmpty()
                    || passwordText.isEmpty()) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Login",
                        "Please enter your Email and Password."
                );

                return;
            }

            // =================================================
            // EMAIL VALIDATION
            // =================================================

            if (!email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
            )) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Invalid Email",
                        "Please enter a valid email address."
                );

                return;
            }

            // =================================================
            // DAO
            // =================================================

            UserDao dao =
                    new UserDao();

            // =================================================
            // STEP 1
            // FIREBASE AUTHENTICATION
            // =================================================

            boolean authenticated =
                    dao.authenticateUser(
                            email,
                            passwordText
                    );

            if (!authenticated) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Login Failed",
                        "Invalid Email or Password."
                );

                return;
            }

            // =================================================
            // STEP 2
            // FETCH USER FROM FIRESTORE
            // =================================================

            User user =
                    dao.getUserByEmail(
                            email
                    );

            if (user == null) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Login Error",
                        "Your Firebase account exists, "
                                + "but your profile was not found "
                                + "in Firestore."
                );

                return;
            }

            // =================================================
            // STEP 3
            // GET ROLE
            // =================================================

            String role =
                    user.getRole();

            if (role == null
                    || role.trim().isEmpty()) {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Login Error",
                        "User role was not found in Firestore."
                );

                return;
            }

            role =
                    role.trim();

            // =================================================
            // STEP 4
            // SAVE CURRENT LOGGED-IN EMAIL
            // =================================================
            //
            // Profile.java will use this email to fetch
            // ONLY the account that logged in.
            //
            // Password is NOT stored.
            // =================================================

            UserDao.setLoggedInEmail(
                    email
            );

            System.out.println(
                    "Logged-in Email: "
                            + email
            );

            System.out.println(
                    "Logged-in Role: "
                            + role
            );

            System.out.println(
                    "Logged-in User: "
                            + user.getName()
            );

            // =================================================
            // STEP 5
            // OPEN CORRECT DASHBOARD
            // =================================================

            if (role.equalsIgnoreCase(
                    "resident"
            )) {
                ResidentSession.setLoggedInEmail(email);
                ResidentDashboard dashboard =
                        new ResidentDashboard();


                stage.setScene(
                        dashboard
                                .getResidentDashboardScene(
                                        stage
                                )
                );

                stage.show();

            }

            else if (role.equalsIgnoreCase(
                    "owner"
            )) {

                OwnerDashboard dashboard =
                        new OwnerDashboard();

                stage.setScene(
                        dashboard.createScene(
                                stage
                        )
                );

                stage.show();

            }

            else if (role.equalsIgnoreCase(
                    "secretary"
            )) {

                SecretaryDashboard dashboard =
                        new SecretaryDashboard();

                stage.setScene(
                        dashboard.createScene(
                                stage
                        )
                );

                stage.show();

            }

            else if (
                    role.equalsIgnoreCase(
                            "security"
                    )
                    ||
                    role.equalsIgnoreCase(
                            "guard"
                    )
            ) {

                GuardDashboard dashboard =
                        new GuardDashboard();

                stage.setScene(
                        dashboard.createScene(
                                stage
                        )
                );

                stage.show();

            }

            else {

                // If role is invalid

                UserDao.clearLoggedInUser();

                showAlert(
                        Alert.AlertType.ERROR,
                        "Login Error",
                        "Unknown user role: "
                                + role
                );
            }
        });

        // =====================================================
        // SIGN UP TEXT
        // =====================================================

        Label account =
                new Label(
                        "Don't have an account?"
                );

        account.setTextFill(
                Color.web(TEXT)
        );

        Hyperlink signup =
                new Hyperlink(
                        "Sign up"
                );

        signup.setTextFill(
                Color.web(PRIMARY_BROWN)
        );

        signup.setOnAction(event -> {

            SigninPage signupPage =
                    new SigninPage();

            stage.setScene(
                    signupPage.createScene(
                            stage
                    )
            );

            stage.show();
        });

        // =====================================================
        // SIGNUP ROW
        // =====================================================

        HBox signupRow =
                new HBox(
                        4,
                        account,
                        signup
                );

        signupRow.setAlignment(
                Pos.CENTER
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        card.getChildren().addAll(
                titleBox,
                new Separator(),
                username,
                password,
                rememberRow,
                loginButton,
                signupRow
        );

        return card;
    }

    // =========================================================
    // INPUT STYLE
    // =========================================================

    private String inputStyle() {

        return "-fx-background-color:"
                + WHITE + ";"
                + "-fx-background-radius:10;"
                + "-fx-border-color:"
                + LIGHT_BROWN + ";"
                + "-fx-border-radius:10;"
                + "-fx-border-width:1;"
                + "-fx-padding:0 15;"
                + "-fx-font-size:14px;"
                + "-fx-text-fill:"
                + TEXT + ";"
                + "-fx-prompt-text-fill:#9E8E8E;";
    }

    // =========================================================
    // PRIMARY BUTTON STYLE
    // =========================================================

    private String primaryButtonStyle() {

        return "-fx-background-color:"
                + PRIMARY_BROWN + ";"
                + "-fx-background-radius:10;"
                + "-fx-text-fill:"
                + WHITE + ";"
                + "-fx-font-size:15px;"
                + "-fx-font-weight:bold;"
                + "-fx-cursor:hand;";
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message
    ) {

        Alert alert =
                new Alert(type);

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}