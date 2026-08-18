package com.society.view.Welcome;

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

    // ================= COLORS =================

    private static final String DARK_BROWN = "#4E342E";
    private static final String BROWN = "#4E342E";
    private static final String PRIMARY_BROWN = "#4e342e";
    private static final String LIGHT_BROWN = "#D7CCC8";
    private static final String TEXT = "#3E2723";
    private static final String WHITE = "#FFFFFF";


    // =========================================================
    // SHOW LOGIN PAGE
    // =========================================================

    public Scene createScene(Stage stage) {

        // =====================================================
        // MAIN ROOT
        // =====================================================

        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to right, #E8DDD5, #E8DDD5);"
        );


        // =====================================================
        // LEFT IMAGE PANEL
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

        VBox loginCard =
                createLoginCard(stage);


        loginCard.setPrefWidth(400);
        loginCard.setMinWidth(400);
        loginCard.setMaxWidth(400);

        loginCard.setPrefHeight(500);
        loginCard.setMaxHeight(500);


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
                        70,
                        20,
                        20
                )
        );


        // =====================================================
        // ADD LEFT IMAGE + LOGIN CARD
        // =====================================================

        root.getChildren().addAll(
                leftPanel,
                loginCard
        );


        // =====================================================
        // SCENE
        // =====================================================

        Scene loginScene =
                new Scene(
                        root,
                        1100,
                        700
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

        panel.setPrefWidth(450);
        panel.setPrefHeight(400);

        panel.setMinWidth(450);
        panel.setMinHeight(400);

        panel.setMaxWidth(440);
        panel.setMaxHeight(400);

        panel.setAlignment(
                Pos.CENTER
        );

        panel.setPadding(
                new Insets(0)
        );

        // YOUR ORIGINAL COLOR
        panel.setStyle(
                "-fx-background-color: " + DARK_BROWN + ";"
        );


        // =====================================================
        // LOAD IMAGE
        // =====================================================

        Image image = new Image(
                getClass()
                        .getResourceAsStream("/image.png")
        );


        ImageView imageView =
                new ImageView(image);


        // =====================================================
        // IMAGE SIZE
        // =====================================================

        imageView.setFitWidth(420);

        imageView.setFitHeight(380);

        imageView.setPreserveRatio(false);

        imageView.setSmooth(true);


        // =====================================================
        // IMAGE CONTAINER
        // =====================================================

        StackPane imageContainer =
                new StackPane(
                        imageView
                );

        imageContainer.setPrefWidth(500);
        imageContainer.setPrefHeight(600);

        imageContainer.setMinWidth(500);
        imageContainer.setMinHeight(600);

        imageContainer.setMaxWidth(500);
        imageContainer.setMaxHeight(600);


        // =====================================================
        // ADD IMAGE
        // =====================================================

        panel.getChildren().add(
                imageContainer
        );


        return panel;
    }


    // =========================================================
    // LOGIN CARD
    // =========================================================

    private VBox createLoginCard(Stage stage) {

        VBox card =
                new VBox(16);

        card.setMaxWidth(450);

        card.setPadding(
                new Insets(
                        45,
                        45,
                        40,
                        45
                )
        );


        // YOUR ORIGINAL COLOR / STYLE
        card.setStyle(
                "-fx-background-color: #FFFDF9;"
                + "-fx-background-radius: 15;"
                + "-fx-border-color: #c7c3bd;"
                + "-fx-border-radius: 15;"
                + "-fx-border-width: 1.5;"
                + "-fx-effect: dropshadow("
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


        Label subtitle =
                new Label(
                        " Login to continue to Society360"
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


        loginButton.setOnAction(event -> {

            if (
                    username.getText().isEmpty()
                    || password.getText().isEmpty()
            ) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Login",
                        "Please enter your Email and Password."
                );

                return;
            }


            // =================================================
            // LOGIN SUCCESS
            // =================================================

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Login",
                    "Login successful!"
            );
        });


        // =====================================================
        // NEW ACCOUNT
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
                    signupPage.createScene(stage)
            );
        });


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
        // ADD TO CARD
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

        return
                "-fx-background-color: " + WHITE + ";"
                + "-fx-background-radius: 10;"
                + "-fx-border-color: " + LIGHT_BROWN + ";"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 1;"
                + "-fx-padding: 0 15;"
                + "-fx-font-size: 14px;"
                + "-fx-text-fill: " + TEXT + ";"
                + "-fx-prompt-text-fill: #9E8E8E;";
    }


    // =========================================================
    // BUTTON STYLE
    // =========================================================

    private String primaryButtonStyle() {

        return
                "-fx-background-color: " + PRIMARY_BROWN + ";"
                + "-fx-background-radius: 10;"
                + "-fx-text-fill: " + WHITE + ";"
                + "-fx-font-size: 15px;"
                + "-fx-font-weight: bold;"
                + "-fx-cursor: hand;";
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