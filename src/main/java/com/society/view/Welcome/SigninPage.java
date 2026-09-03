package com.society.view.Welcome;

import com.society.controller.welcome.UserController;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SigninPage {

        private Scene signinScene;

        private final UserController controller = new UserController();

        // =====================================================
        // CREATE SCENE
        // =====================================================

        public Scene createScene(Stage stage) {

                // =================================================
                // LEFT PANEL
                // =================================================

                VBox leftPanel = createLeftPanel();

                StackPane.setAlignment(
                                leftPanel,
                                Pos.CENTER_LEFT);

                StackPane.setMargin(
                                leftPanel,
                                new Insets(20, 20, 20, 50));

                // =================================================
                // SIGNUP CARD
                // =================================================

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

                signupCard.setStyle(
                                "-fx-background-color: #F8F3EE;" +
                                                "-fx-border-color: #c7c3bd;" +
                                                "-fx-border-radius: 15;" +
                                                "-fx-border-width: 1.5;" +
                                                "-fx-background-radius:15;");

                // =================================================
                // TITLE
                // =================================================

                Label createTitle = new Label("Create Account");
        createTitle.setStyle(
                "-fx-font-size:26px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: #333333;"
        );

                createTitle.setStyle(
                                "-fx-font-size:26px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#333333;");

                Label createSubtitle = new Label(
                                "Join Society360 and simplify your life");
        createSubtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill: #535050;"
        );

                createSubtitle.setStyle(
                                "-fx-font-size:13px;" +
                                                "-fx-text-fill:#535050;");

                // =================================================
                // ROLE SELECTION
                // =================================================

                Label roleLabel = new Label("I am a");

                roleLabel.setStyle(
                                "-fx-font-size:13px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#555555;");

                RadioButton owner = new RadioButton("Owner");

                RadioButton resident = new RadioButton("Resident");

                RadioButton secretary = new RadioButton("Secretary");

                RadioButton guard = new RadioButton("Guard");

                String roleStyle = "-fx-font-size:16px;" +
                                "-fx-font-weight:bold;" +
                                "-fx-text-fill:#4e342e;";

                owner.setStyle(roleStyle);
                resident.setStyle(roleStyle);
                secretary.setStyle(roleStyle);
                guard.setStyle(roleStyle);

                ToggleGroup roleGroup = new ToggleGroup();

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
                                guard);

                // =================================================
                // BACK BUTTON
                // =================================================

                Button backToLoginBtn = new Button("← Back");

                backToLoginBtn.setPrefWidth(100);
                backToLoginBtn.setPrefHeight(40);

                backToLoginBtn.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-text-fill:#4e342e;" +
                                                "-fx-font-size:14px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-cursor:hand;");

                backToLoginBtn.setOnAction(event -> {

                        LogInPage loginPage = new LogInPage();

                        stage.setScene(
                                        loginPage.createScene(stage));

                        stage.show();
                });

                // =================================================
                // CONTINUE BUTTON
                // =================================================

                Button continueBtn = new Button("Continue");

                continueBtn.setPrefWidth(330);
                continueBtn.setPrefHeight(45);

                continueBtn.setStyle(
                                "-fx-background-color:#4e342e;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:15px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:8;");

                // =================================================
                // DETAILS BOX
                // =================================================

                VBox detailsBox = new VBox(12);

                detailsBox.setAlignment(Pos.TOP_CENTER);

                detailsBox.setVisible(false);
                detailsBox.setManaged(false);

                // =================================================
                // CONTINUE ACTION
                // =================================================

                continueBtn.setOnAction(event -> {

                        Toggle selected = roleGroup.getSelectedToggle();

                        if (selected == null) {

                                showAlert(
                                                "Role Required",
                                                "Please select your role first.");

                                return;
                        }

                        String role = ((RadioButton) selected).getText();

                        createRoleForm(
                                        role,
                                        detailsBox,
                                        stage);

                        detailsBox.setVisible(true);
                        detailsBox.setManaged(true);

                        roleLabel.setVisible(false);
                        roleLabel.setManaged(false);

                        roles.setVisible(false);
                        roles.setManaged(false);

                        continueBtn.setVisible(false);
                        continueBtn.setManaged(false);
                });

                // =================================================
                // ADD CONTENT
                // =================================================

                signupCard.getChildren().addAll(
                                backToLoginBtn,
                                createTitle,
                                createSubtitle,
                                roleLabel,
                                roles,
                                continueBtn,
                                detailsBox);

                // =================================================
                // ROOT
                // =================================================

                StackPane root = new StackPane();

                root.setStyle(
                                "-fx-background-color:" +
                                                "linear-gradient(to right,#D7CCC8,#bfb1a7);");

                StackPane.setAlignment(
                                signupCard,
                                Pos.CENTER_RIGHT);

                StackPane.setMargin(
                                signupCard,
                                new Insets(
                                                20,
                                                100,
                                                20,
                                                20));

                root.getChildren().addAll(
                                leftPanel,
                                signupCard);

                // =================================================
                // SCENE
                // =================================================

                signinScene = new Scene(
                                root,
                                ScreenSize.getWidth(),
                                ScreenSize.getHeight());

                return signinScene;
        }

        // =====================================================
        // ROLE FORM
        // =====================================================

        private void createRoleForm(
                        String role,
                        VBox detailsBox,
                        Stage stage) {

                detailsBox.getChildren().clear();

                // =================================================
                // ROLE TITLE
                // =================================================

                Label roleTitle = new Label(role + " Details");

                roleTitle.setStyle(
                                "-fx-font-size:20px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#4e342e;");

                // =================================================
                // COMMON FIELDS
                // =================================================

                TextField nameField = createTextField("Full Name");

                TextField phoneField = createTextField("Phone Number");

                DatePicker dob = new DatePicker();

                dob.setPromptText("Date of Birth");
                dob.setPrefHeight(40);
                dob.setMaxWidth(350);

                TextField emailField = createTextField("Email Address");

                ComboBox<String> gender = new ComboBox<>();

                gender.getItems().addAll(
                                "Male",
                                "Female",
                                "Other");

                gender.setPromptText("Gender");
                gender.setPrefHeight(40);
                gender.setMaxWidth(350);

                PasswordField password = new PasswordField();

                password.setPromptText("Create Password");
                password.setPrefHeight(40);
                password.setMaxWidth(350);

                PasswordField confirmPassword = new PasswordField();

                confirmPassword.setPromptText(
                                "Confirm Password");

                confirmPassword.setPrefHeight(40);
                confirmPassword.setMaxWidth(350);

                detailsBox.getChildren().addAll(
                                roleTitle,
                                nameField,
                                phoneField,
                                dob,
                                emailField,
                                gender);

                // =================================================
                // RESIDENT
                // =================================================

                if (role.equalsIgnoreCase("Resident")) {

                        TextField flatNo = createTextField("Flat Number");

                        TextField aadhar = createTextField("Aadhar Number");

                        TextField society = createTextField("Society Name");

                        Label residentTypeLabel = new Label("Resident Type");

                        residentTypeLabel.setStyle(
                                        "-fx-font-size:13px;" +
                                                        "-fx-font-weight:bold;" +
                                                        "-fx-text-fill:#3d3d3d;");

                        RadioButton ownerOption = new RadioButton("Owner");

                        RadioButton residentOption = new RadioButton("Resident");

                        ToggleGroup residentTypeGroup = new ToggleGroup();

                        ownerOption.setToggleGroup(
                                        residentTypeGroup);

                        residentOption.setToggleGroup(
                                        residentTypeGroup);

                        HBox residentTypeBox = new HBox(20);

                        residentTypeBox.setAlignment(
                                        Pos.CENTER_LEFT);

                        residentTypeBox.getChildren().addAll(
                                        ownerOption,
                                        residentOption);

                        TextField ownerName = createTextField("Owner Name");

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
                                        ownerName);
                }

                // =================================================
                // OWNER
                // =================================================

                else if (role.equalsIgnoreCase("Owner")) {

                        TextField flatNo = createTextField("Flat Number");

                        TextField aadhar = createTextField("Aadhar Number");

                        TextField address = createTextField(
                                        "Permanent Address");

                        TextField society = createTextField("Society Name");

                        detailsBox.getChildren().addAll(
                                        flatNo,
                                        password,
                                        confirmPassword,
                                        aadhar,
                                        address,
                                        society);
                }

                // =================================================
                // GUARD
                // =================================================

                else if (role.equalsIgnoreCase("Guard")) {

                        DatePicker joiningDate = new DatePicker();

                        joiningDate.setPromptText(
                                        "Joining Date");

                        joiningDate.setPrefHeight(40);
                        joiningDate.setMaxWidth(350);

                        TextField aadhar = createTextField("Aadhar Number");

                        TextField society = createTextField("Society Name");

                        detailsBox.getChildren().addAll(
                                        password,
                                        confirmPassword,
                                        joiningDate,
                                        aadhar,
                                        society);
                }

                // =================================================
                // SECRETARY
                // =================================================

                else if (role.equalsIgnoreCase("Secretary")) {

                        TextField aadhar = createTextField("Aadhar Number");

                        TextField society = createTextField("Society Name");

                        detailsBox.getChildren().addAll(
                                        password,
                                        confirmPassword,
                                        aadhar,
                                        society);
                }

                // =================================================
                // TERMS
                // =================================================

                CheckBox terms = new CheckBox(
                                "I agree to the Terms & Conditions and Privacy Policy");

                terms.setStyle(
                                "-fx-font-size:11px;" +
                                                "-fx-text-fill:#777777;");

                // =================================================
                // SIGN UP BUTTON
                // =================================================

                Button signupBtn = new Button("Sign Up");

                signupBtn.setPrefWidth(350);
                signupBtn.setPrefHeight(45);

                signupBtn.setStyle(
                                "-fx-background-color:#4e342e;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-size:15px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:8;");

                signupBtn.setOnAction(event -> {

                        // =============================================
                        // TERMS VALIDATION
                        // =============================================

                        if (!terms.isSelected()) {

                                showAlert(
                                                "Terms Required",
                                                "Please accept the Terms & Conditions.");

                                return;
                        }

                        // =============================================
                        // ROLE
                        // =============================================

                        String selectedRole = role;

                        // =============================================
                        // GET FORM DATA
                        // =============================================

                        String name = nameField.getText().trim();

                        String email = emailField.getText().trim();

                        String pass = password.getText();

                        String confirmPass = confirmPassword.getText();

                        // =============================================
                        // BASIC VALIDATION
                        // =============================================

                        if (name.isEmpty()
                                        || email.isEmpty()
                                        || pass.isEmpty()
                                        || confirmPass.isEmpty()) {

                                showAlert(
                                                "Missing Details",
                                                "Please fill all required fields.");

                                return;
                        }

                        // =============================================
                        // PASSWORD VALIDATION
                        // =============================================

                        if (!pass.equals(confirmPass)) {

                                showAlert(
                                                "Password Error",
                                                "Password and Confirm Password do not match.");

                                return;
                        }

                        if (pass.length() < 6) {

                                showAlert(
                                                "Password Error",
                                                "Password must contain at least 6 characters.");

                                return;
                        }

                        // =============================================
                        // FIREBASE SIGN UP
                        // =============================================

                        // =============================================
                        // SIGN UP + FIRESTORE SAVE
                        // =============================================

                        boolean saved = controller.addUser(
                                        name,
                                        email,
                                        pass,
                                        selectedRole);

                        if (!saved) {

                                showAlert(
                                                "Registration Failed",
                                                "Unable to create account or save user information.");

                                return;
                        }

                        // =============================================
                        // FIRESTORE FAILED
                        // =============================================

                        // =============================================
                        // SUCCESS
                        // =============================================

                        showAlert(
                                        "Sign Up Successful",
                                        "Your account has been created successfully!");

                        // =============================================
                        // CLEAR FIELDS
                        // =============================================

                        nameField.clear();
                        emailField.clear();
                        password.clear();
                        confirmPassword.clear();
                        terms.setSelected(false);

                        // =============================================
                        // GO TO LOGIN
                        // =============================================

                        LogInPage loginPage = new LogInPage();

                        stage.setScene(
                                        loginPage.createScene(stage));

                        stage.show();
                });
                // =================================================
                // LOGIN
                // =================================================

                Label accountText = new Label(
                                "Already have an account?");

                accountText.setStyle(
                                "-fx-text-fill:#666666;" +
                                                "-fx-font-size:12px;");

                Button loginBtn = new Button("Login");

                loginBtn.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-text-fill:#5f331e;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-font-size:12px;");

                loginBtn.setOnAction(event -> {

                        LogInPage loginPage = new LogInPage();

                        stage.setScene(
                                        loginPage.createScene(stage));

                        stage.show();
                });

                HBox loginBox = new HBox(5);

                loginBox.setAlignment(Pos.CENTER);

                loginBox.getChildren().addAll(
                                accountText,
                                loginBtn);

                // =================================================
                // ADD FINAL CONTROLS
                // =================================================

                detailsBox.getChildren().addAll(
                                terms,
                                signupBtn,
                                loginBox);
        }

        // =====================================================
        // TEXT FIELD
        // =====================================================

        private TextField createTextField(
                        String prompt) {

                TextField field = new TextField();

                field.setPromptText(prompt);

                field.setPrefHeight(40);
                field.setMaxWidth(350);

                return field;
        }

        // =====================================================
        // ALERT
        // =====================================================

        private void showAlert(
                        String title,
                        String message) {

                Alert alert = new Alert(
                                Alert.AlertType.INFORMATION);

                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
        }

        // =====================================================
        // LEFT PANEL
        // =====================================================

        private VBox createLeftPanel() {

                VBox leftPanel = new VBox(15);

                leftPanel.setAlignment(
                                Pos.CENTER);

                Label title = new Label("Society360");

                title.setStyle(
                                "-fx-font-size:42px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#4e342e;");

                Label subtitle = new Label(
                                "Smart Society Management System");

                subtitle.setStyle(
                                "-fx-font-size:16px;" +
                                                "-fx-text-fill:#5d4037;");

                leftPanel.getChildren().addAll(
                                title,
                                subtitle);

                return leftPanel;
        }
}