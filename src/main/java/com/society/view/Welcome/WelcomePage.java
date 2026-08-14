package com.society.view.Welcome;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WelcomePage {
    private Scene createScene;
    public Scene createScene() {
        StackPane root = new StackPane();

        root.setStyle("-fx-background-color: #07131b");



        VBox loginBox = new VBox();
        loginBox.setPrefSize(400, 500);
        loginBox.setMaxSize(400, 500);
        loginBox.setPrefHeight(360);
        loginBox.setPrefWidth(540);
        loginBox.setPadding(new Insets(30));
        loginBox.setSpacing(15);
        loginBox.setAlignment(Pos.CENTER);
        
        loginBox.setStyle("-fx-background-color: #efe9e9; -fx-backgronud-radius: 12; -fx-border-radius: 12; -fx-border-color: #e0e0e0; -fx-border-width: 1; -fx-effect: dropShadow(gaussian, rgba(0,0,0,0,12), 12, 0, 0, 3);");


        StackPane iconBox = new StackPane();
        
        Rectangle iconBackground = new Rectangle(45,45);
        iconBackground.setArcWidth(8);
        iconBackground.setArcHeight(8);
        iconBackground.setFill(Color.WHITE);
        Label icon = new Label();
        icon.setTextFill(Color.WHITE);
        icon.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        iconBox.getChildren().addAll(iconBackground, icon);

        Label title = new Label("Society360");
        title.setFont(Font.font("Arial",FontWeight.BOLD, 24));
        title.setTextFill(Color.BLACK);

        Label subtitle = new Label("Sign in to Manage Your Community.");
        //subtitle.setFont(Font.font("Arial", 13));
        subtitle.setTextFill(Color.GRAY);

        
       Label usernameLabel = new Label("Username");
       usernameLabel.setFont(Font.font("Arial", FontWeight.BOLD,11));
       usernameLabel.setTextFill(Color.BLACK);
       TextField username = new TextField();
       username.setPromptText("Enter your Username");
       username.setPrefHeight(36);
       username.setStyle("-fx-border-color: #445566; -fx-border-radius: 6; -fx-background-radius: 6");

       Label passwordLabel = new Label("Password");
       passwordLabel.setFont(Font.font("Arial", FontWeight.BOLD, 11));
       passwordLabel.setTextFill(Color.BLACK);
       PasswordField password = new PasswordField();
       password.setPromptText("Enter your Password");
       password.setPrefHeight(36);
       password.setStyle("-fx-border-color: #445566; -fx-border-radius: 6; -fx-background-radius: 6");

       Label roleLabel = new Label("ROLE");

       roleLabel.setFont(Font.font("Arial",FontWeight.BOLD,11));
       roleLabel.setTextFill(Color.GRAY);
       ComboBox<String> role = new ComboBox<>();

       role.getItems().addAll(
        "Secretery",
        "Guard",
        "Resident",
        "Owner"
       );
       role.setPromptText("Select your Role");

       role.setMaxWidth(Double.MAX_VALUE);

       CheckBox rememberMe = new CheckBox("Remember Me");

       rememberMe.setFont(Font.font("Arial",11));

       rememberMe.setTextFill(Color.GRAY);

       Hyperlink forgotPassword = new Hyperlink("Forgot Password?");

       forgotPassword.setFont(Font.font("Arial", 11));

       HBox options = new HBox();
       options.setAlignment(Pos.CENTER_LEFT);
       Region spacer = new Region();

       HBox.setHgrow(spacer, Priority.ALWAYS);

       options.getChildren().addAll(rememberMe, spacer, forgotPassword);


       Button loginButton = new Button("LOGIN");
       loginButton.setPrefHeight(40);
       loginButton.setMaxWidth(Double.MAX_VALUE);

       loginButton.setFont(Font.font("Arial", FontWeight.BOLD, 12));

       loginButton.setTextFill(Color.WHITE);

       loginButton.setStyle("-fx-background-color: #0a3081; -fx-background-radius: 6; -fx-cursor: hand;");

       Label help = new Label("Need Help?");
       help.setFont(Font.font("Arial",11));
       help.setTextFill(Color.GRAY);

       Hyperlink support = new Hyperlink("Contact Support");
       support.setFont(Font.font("Arial",11));

       HBox supportBox = new HBox();
       supportBox.setAlignment(Pos.CENTER);
       supportBox.getChildren().addAll(help,support);

       loginBox.getChildren().addAll(
        iconBox,
        title,
        subtitle,
        usernameLabel,
        username,
        passwordLabel,
        password,
        roleLabel,
        role,
        options,
        loginButton,
        supportBox

       );
       root.getChildren().add(loginBox);

    //return new Scene(root,1200,750);
    Scene scene = new Scene(root,1200, 750);
    createScene = scene;
    return createScene;
    }
}


        
    
    
    
