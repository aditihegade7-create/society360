package com.society.view.Welcome;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SigninPage {

    private Scene signinScene;

    private static final String DARK_BROWN = "#4e342e";

    // MAIN SCENE

    public Scene createScene(Stage stage) {

        // LEFT SIDE

        VBox leftPanel = createLeftPanel();

        StackPane.setAlignment(
                leftPanel,
                Pos.CENTER_LEFT
        );

        StackPane.setMargin(
                leftPanel,
                new Insets(20, 20, 20, 50)
        );

        // RIGHT SIDE - CREATE ACCOUNT
        
        VBox signupCard = new VBox(15);

        signupCard.setPrefWidth(400);
        signupCard.setMinWidth(400);
        signupCard.setMaxWidth(400);

        signupCard.setPrefHeight(650);
        signupCard.setMaxHeight(650);

        signupCard.setPadding(new Insets(25));

        signupCard.setAlignment(Pos.TOP_CENTER);

        signupCard.setStyle(
                "-fx-background-color: #F8F3EE;"
                +"-fx-border-color: #c7c3bd;"
                + "-fx-border-radius: 15;"
                + "-fx-border-width: 1.5;"+
                "-fx-background-radius:15;"
        );

        // TITLE

        Label createTitle =new Label("Create Account");

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

        // ROLE SELECTION
        
        Label roleLabel =new Label("I am a");

        roleLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: #555555;"
        );

        RadioButton owner =new RadioButton("Owner");

        RadioButton resident =new RadioButton("Resident");

        RadioButton secretary =new RadioButton("Secretary");

        RadioButton guard =new RadioButton("Guard");

        String roleStyle =
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: #4e342e;";

        owner.setStyle(roleStyle);
        resident.setStyle(roleStyle);
        secretary.setStyle(roleStyle);
        guard.setStyle(roleStyle);

        ToggleGroup roleGroup =new ToggleGroup();

        owner.setToggleGroup(roleGroup);
        resident.setToggleGroup(roleGroup);
        secretary.setToggleGroup(roleGroup);
        guard.setToggleGroup(roleGroup);


        VBox roles = new VBox(25);
        roles.setAlignment(Pos.CENTER_LEFT);

        roles.getChildren().addAll(
                owner,
                resident,
                secretary,
                guard
        );

        //back to login page button

        Button backToLoginBtn = new Button("← Back");

        backToLoginBtn.setPrefWidth(100);
        backToLoginBtn.setPrefHeight(40);

        backToLoginBtn.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #4e342e;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        backToLoginBtn.setOnAction(event -> {

        LogInPage loginPage = new LogInPage();

        stage.setScene(loginPage.createScene(stage));

        stage.show();
        });

        StackPane.setAlignment(backToLoginBtn,
                Pos.TOP_LEFT
        );

        StackPane.setMargin(backToLoginBtn,
                new Insets(20, 0, 0, 25)
        );

        // CONTINUE BUTTON

        Button continueBtn =new Button("Continue");

        continueBtn.setPrefWidth(330);
        continueBtn.setPrefHeight(45);

        continueBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // DETAILS BOX

        VBox detailsBox =new VBox(12);

        detailsBox.setAlignment(Pos.TOP_CENTER);

        detailsBox.setVisible(false);
        detailsBox.setManaged(false);

        // CONTINUE ACTION

        continueBtn.setOnAction(event -> {

            RadioButton selectedRole =(RadioButton) roleGroup.getSelectedToggle();

            // ROLE NOT SELECTED

            if (selectedRole == null) {

                showAlert(
                        "Role Required",
                        "Please select your role first."
                );

                return;
            }

            // SHOW DETAILS

            String role =selectedRole.getText();

            createRoleForm(
                    role,
                    detailsBox,
                    stage
            );

            detailsBox.setVisible(true);
            detailsBox.setManaged(true);

            // Hide role selection after Continue
            roleLabel.setVisible(false);
            roleLabel.setManaged(false);

            roles.setVisible(false);
            roles.setManaged(false);

            continueBtn.setVisible(false);
            continueBtn.setManaged(false);
        });


        // ADD CONTENT

        signupCard.getChildren().addAll(
                backToLoginBtn,
                createTitle,
                createSubtitle,

                roleLabel,
                roles,
                continueBtn,

                detailsBox
        );

        // MAIN ROOT

        StackPane root =new StackPane();

        root.setStyle(
                "-fx-background-color:" +
                "linear-gradient(to right, #D7CCC8, #bfb1a7);"
        );



        StackPane.setAlignment(
                signupCard,
                Pos.CENTER_RIGHT
        );

        StackPane.setMargin(
                signupCard,
                new Insets(
                        20,
                        100,
                        20,
                        20
                )
        );



        root.getChildren().addAll(
                leftPanel,
                signupCard,
                backToLoginBtn
        );

        // SCENE

        signinScene =
                new Scene(
                        root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()

                        
                );

        return signinScene;
    }

    // ROLE FORM

    private void createRoleForm(
            String role,
            VBox detailsBox,
            Stage stage) {

        detailsBox.getChildren().clear();

        // ROLE TITLE

        Label roleTitle =new Label(role + " Details");

        roleTitle.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: #4e342e;"
        );

        // COMMON FIELDS
        
        TextField nameField =createTextField("Full Name");

        TextField phoneField =createTextField("Phone Number");

        DatePicker dob =new DatePicker();

        dob.setPromptText("Date of Birth");
        dob.setPrefHeight(40);
        dob.setMaxWidth(350);

        TextField emailField =createTextField("Email Address");

        ComboBox<String> gender =new ComboBox<>();

        gender.getItems().addAll(
                "Male",
                "Female",
                "Other"
        );

        gender.setPromptText("Gender");
        gender.setPrefHeight(40);
        gender.setMaxWidth(350);


        PasswordField password =new PasswordField();

        password.setPromptText("Create Password");
        password.setPrefHeight(40);
        password.setMaxWidth(350);

        PasswordField confirmPassword =new PasswordField();

        confirmPassword.setPromptText("Confirm Password");
        confirmPassword.setPrefHeight(40);
        confirmPassword.setMaxWidth(350);


        detailsBox.getChildren().addAll(
                roleTitle,
                nameField,
                phoneField,
                dob,
                emailField,
                gender
        );


        // RESIDENT
       
        if (role.equals("Resident")) {

            TextField flatNo =createTextField("Flat Number");

            TextField aadhar =createTextField("Aadhar Number");

            TextField society =createTextField("Society Name");

            Label residentTypeLabel =new Label("Resident Type");

            residentTypeLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill: #3d3d3d;"
            );


            RadioButton ownerOption =new RadioButton("Owner");

            RadioButton residentOption =new RadioButton("Resident");

            ToggleGroup residentTypeGroup =new ToggleGroup();

            ownerOption.setToggleGroup(residentTypeGroup);

            residentOption.setToggleGroup(residentTypeGroup);

            HBox residentTypeBox =new HBox(20);

            residentTypeBox.setAlignment(Pos.CENTER_LEFT);

            residentTypeBox.getChildren().addAll(
                    ownerOption,
                    residentOption
            );


            TextField ownerName =createTextField("Owner Name");

            // Initially hidden
            ownerName.setVisible(false);
            ownerName.setManaged(false);


            residentOption.setOnAction(e -> {

                ownerName.setVisible(true);
                ownerName.setManaged(true);
            });


            ownerOption.setOnAction(e -> {

                ownerName.setVisible(false);
                ownerName.setManaged(false);
            });


            detailsBox.getChildren().addAll(
                    flatNo,
                    password,
                    confirmPassword,
                    aadhar,
                    society,
                    residentTypeLabel,
                    residentTypeBox,
                    ownerName
            );
        }

        // OWNER
        
        else if (role.equals("Owner")) {

            TextField flatNo =createTextField("Flat Number");

            TextField aadhar =createTextField("Aadhar Number");

            TextField address =createTextField("Permanent Address");

            TextField society =createTextField("Society Name");


            detailsBox.getChildren().addAll(
                    flatNo,
                    password,
                    confirmPassword,
                    aadhar,
                    address,
                    society
            );
        }

        // GUARD

        else if (role.equals("Guard")) {

            DatePicker joiningDate =new DatePicker();

            joiningDate.setPromptText("Joining Date");

            joiningDate.setPrefHeight(40);
            joiningDate.setMaxWidth(350);


            TextField aadhar =createTextField("Aadhar Number");

            TextField society =createTextField("Society Name");


            detailsBox.getChildren().addAll(
                    password,
                    confirmPassword,
                    joiningDate,
                    aadhar,
                    society
            );
        }

        // SECRETARY

        else if (role.equals("Secretary")) {

            TextField aadhar =createTextField("Aadhar Number");

            TextField society =createTextField("Society Name");

            detailsBox.getChildren().addAll(
                    password,
                    confirmPassword,
                    aadhar,
                    society
            );
        }


        // TERMS

        CheckBox terms =new CheckBox("I agree to the Terms & Conditions and Privacy Policy");

        terms.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );


        // SIGN UP BUTTON
        
        Button signupBtn =new Button("Sign Up");

        signupBtn.setPrefWidth(350);
        signupBtn.setPrefHeight(45);

        signupBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );


        signupBtn.setOnAction(event -> {

            if (!terms.isSelected()) {

                showAlert(
                        "Terms Required",
                        "Please accept the Terms & Conditions."
                );

                return;
            }

            LogInPage loginPage =new LogInPage();

            stage.setScene(loginPage.createScene(stage));

            stage.show();
        });


        // LOGIN
        
        Label accountText =new Label("Already have an account?");

        accountText.setStyle(
                "-fx-text-fill:#666666;" +
                "-fx-font-size:12px;"
        );


        Button loginBtn =
                new Button("Login");

        loginBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#5f331e;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;"
        );


        loginBtn.setOnAction(event -> {

            LogInPage loginPage =new LogInPage();

            stage.setScene(loginPage.createScene(stage));

            stage.show();
        });

        HBox loginBox =new HBox(5);

        loginBox.setAlignment(Pos.CENTER);

        loginBox.getChildren().addAll(
                accountText,
                loginBtn
        );


        detailsBox.getChildren().addAll(
                terms,
                signupBtn,
                loginBox
        );
    }

    // TEXT FIELD STYLE
    
    private TextField createTextField(String prompt) {

        TextField field =new TextField();

        field.setPromptText(prompt);

        field.setPrefHeight(40);
        field.setMaxWidth(350);

        field.setStyle(
                "-fx-background-color: #FFFDF9;" +
                "-fx-border-color: #bdbab7;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        return field;
    }

 // ALERT
   
    private void showAlert(String title,String message) {

        Alert alert =new Alert(Alert.AlertType.WARNING);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


    // LEFT IMAGE PANEL
    
    private VBox createLeftPanel() {

        VBox panel =new VBox();

        panel.setPrefWidth(550);
        panel.setPrefHeight(500);

        panel.setMinWidth(550);
        panel.setMinHeight(500);

        panel.setMaxWidth(540);
        panel.setMaxHeight(500);

        panel.setAlignment(Pos.CENTER);

        panel.setPadding(new Insets(0));

        panel.setStyle(
                "-fx-background-color:" +
                DARK_BROWN + ";"
        );


        // LOAD IMAGE

        Image image = new Image(getClass().getResourceAsStream("/image.png"));


        ImageView imageView =new ImageView(image);


        imageView.setFitWidth(520);

        imageView.setFitHeight(480);

        imageView.setPreserveRatio(false);

        imageView.setSmooth(true);

        // IMAGE CONTAINER

        StackPane imageContainer =new StackPane(imageView);

        imageContainer.setPrefWidth(600);
        imageContainer.setPrefHeight(700);

        imageContainer.setMinWidth(600);
        imageContainer.setMinHeight(700);

        imageContainer.setMaxWidth(600);
        imageContainer.setMaxHeight(700);


        panel.getChildren().add(imageContainer);

        return panel;
    }
}