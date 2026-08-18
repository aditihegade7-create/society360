package com.society.view.Welcome;

//import com.society.view.Authentication.LoginPage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SigninPage {
    private Scene signinScene;

    public Scene createScene(Stage stage) {

        // =====================================================
        // LEFT SIDE
        // =====================================================

        VBox leftSide = new VBox(15);

        leftSide.setPrefWidth(600);
        leftSide.setAlignment(Pos.TOP_CENTER);
        leftSide.setPadding(new Insets(80, 40, 40, 40));

        leftSide.setStyle(
                "-fx-background-color: #E8DDD5;"
        );


        // Logo
        Label logoIcon = new Label("🏢");

        logoIcon.setStyle(
                "-fx-font-size:40px;"
        );


        Label logo =
                new Label("Society360");

        logo.setStyle(
                "-fx-font-size:30px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:white;"
        );


        Label tagline =
                new Label("Manage. Connect. Simplify.");

        tagline.setStyle(
                "-fx-font-size:15px;" +
                "-fx-text-fill:white;"
        );


        // =====================================================
        // RIGHT SIDE - CREATE ACCOUNT
        // =====================================================

        VBox signupCard = new VBox(15);

        signupCard.setPrefWidth(420);
        signupCard.setMaxWidth(420);
        signupCard.setPadding(new Insets(28));

        signupCard.setAlignment(Pos.TOP_CENTER);

        signupCard.setStyle(
                "-fx-background-color: #F8F3EE;" +
                "-fx-background-radius:15;"
        );


        Label createTitle =
                new Label("Create Account");

        createTitle.setStyle(
                "-fx-font-size:26px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: #333333;"
        );


        Label createSubtitle =
                new Label("Join Society360 and simplify your life");

        createSubtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill: #535050;"
        );


        // =====================================================
        // FULL NAME
        // =====================================================

        TextField nameField =
                new TextField();

        nameField.setPromptText("Full Name");
        nameField.setPrefHeight(40);

        nameField.setStyle(
                "-fx-background-color:#FFFDF9;" +
                "-fx-border-color:#E5E0DA;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // =====================================================
        // EMAIL
        // =====================================================

        TextField emailField =
                new TextField();

        emailField.setPromptText("Email Address");
        emailField.setPrefHeight(40);

        emailField.setStyle(
                "-fx-background-color:#FFFDF9;" +
                "-fx-border-color:#E5E0DA;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // =====================================================
        // PHONE
        // =====================================================

        TextField phoneField =
                new TextField();

        phoneField.setPromptText("Phone Number");
        phoneField.setPrefHeight(40);

        phoneField.setStyle(
                "-fx-background-color:#FFFDF9;" +
                "-fx-border-color:#E5E0DA;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // =====================================================
        // PASSWORD
        // =====================================================

        PasswordField passwordField =
                new PasswordField();

        passwordField.setPromptText("Create Password");
        passwordField.setPrefHeight(40);

        passwordField.setStyle(
                "-fx-background-color:#FFFDF9;" +
                "-fx-border-color:#E5E0DA;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // =====================================================
        // CONFIRM PASSWORD
        // =====================================================

        PasswordField confirmPasswordField =
                new PasswordField();

        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setPrefHeight(40);

        confirmPasswordField.setStyle(
                "-fx-background-color:#FFFDF9;" +
                "-fx-border-color:#E5E0DA;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // =====================================================
        // ROLE
        // =====================================================

        Label roleLabel =
                new Label("I am a");

        roleLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );


        RadioButton owner =
                new RadioButton("Owner");

        RadioButton resident =
                new RadioButton("Resident");

        RadioButton secretary =
                new RadioButton("Secretary");

        RadioButton guard =
                new RadioButton("Guard");


        ToggleGroup roleGroup =
                new ToggleGroup();

        owner.setToggleGroup(roleGroup);
        resident.setToggleGroup(roleGroup);
        secretary.setToggleGroup(roleGroup);
        guard.setToggleGroup(roleGroup);


        HBox roles =
                new HBox(25);

        roles.setAlignment(Pos.CENTER_LEFT);

        roles.getChildren().addAll(
                owner,
                resident,
                secretary,
                guard
        );


        // =====================================================
        // TERMS
        // =====================================================

        CheckBox terms =
                new CheckBox(
                        "I agree to the Terms & Conditions and Privacy Policy"
                );

        terms.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        // =====================================================
        // SIGN UP BUTTON
        // =====================================================

        
        
        Button signupBtn =
                new Button("Sign Up");

        signupBtn.setPrefWidth(430);
        signupBtn.setPrefHeight(48);

        signupBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

         signupBtn.setOnAction(event -> {
                LogInPage loginPage = new LogInPage();
                stage.setScene(loginPage.createScene(stage));
                stage.show();
        });
        


        // =====================================================
        // ALREADY HAVE ACCOUNT
        // =====================================================

        Label accountText =
                new Label("Already have an account?");

        accountText.setStyle(
                "-fx-text-fill: #666666;" +
                "-fx-font-size:12px;"
        );


        Button loginBtn =
                new Button("Login");

        loginBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill: #B85C32;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;"
        );
        loginBtn.setOnAction(event -> {
                
                LogInPage loginPage = new LogInPage();
                stage.setScene(loginPage.createScene(stage));
                stage.show();
        });

        


        HBox loginBox =
                new HBox(5);

        loginBox.setAlignment(Pos.CENTER);

        loginBox.getChildren().addAll(
                accountText,
                loginBtn
        );


        // =====================================================
        // LOGIN BUTTON ACTION
        // =====================================================

        loginBtn.setOnAction(e -> {

            LogInPage loginPage =new LogInPage();

            stage.setScene(loginPage.createScene(stage));
        });


        // =====================================================
        // ADD TO SIGNUP CARD
        // =====================================================

        signupCard.getChildren().addAll(
                createTitle,
                createSubtitle,
                nameField,
                emailField,
                phoneField,
                passwordField,
                confirmPasswordField,
                roleLabel,
                roles,
                terms,
                signupBtn,
                loginBox
        );


        // =====================================================
        // MAIN ROOT
        // =====================================================

        StackPane root = new StackPane();

        root.setStyle("-fx-background-color: linear-gradient(to right, #D7CCC8, #D7CCC8);");
        signupCard.setPrefWidth(400);
        signupCard.setMinWidth(400);
        signupCard.setMaxWidth(400);
        signupCard.setPrefHeight(650);
        signupCard.setMaxHeight(650);
        signupCard.setPadding(new Insets(25));

        //right side position

        StackPane.setAlignment(signupCard,Pos.CENTER_RIGHT);

        //right margin
        StackPane.setMargin(signupCard, new Insets(20, 60, 20, 20));

        root.getChildren().add(signupCard);


        // =====================================================
        // SCENE
        // =====================================================

        signinScene =
                new Scene(root, 1200, 750);

        return signinScene;
    }
}