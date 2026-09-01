package com.society.view.Welcome;

import com.society.controller.welcome.UserController;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SigninPage {

    private Scene signinScene;

    private final UserController controller =
            new UserController();

    // =========================================================
    // RESIDENT FIELDS
    // =========================================================

    private TextField residentFlatNo;
    private TextField residentAadhar;
    private TextField residentSociety;
    private TextField residentOwnerName;

    // =========================================================
    // OWNER FIELDS
    // =========================================================

    private TextField ownerFlatNo;
    private TextField ownerAadhar;
    private TextField ownerAddress;
    private TextField ownerSociety;

    // =========================================================
    // GUARD FIELDS
    // =========================================================

    private DatePicker joiningDate;
    private TextField guardAadhar;
    private TextField guardSociety;

    // =========================================================
    // SECRETARY FIELDS
    // =========================================================

    private TextField secretaryAadhar;
    private TextField secretarySociety;

    // =========================================================
    // CREATE SCENE
    // =========================================================

    public Scene createScene(Stage stage) {

        VBox leftPanel = createLeftPanel();

        StackPane.setAlignment(
                leftPanel,
                Pos.CENTER_LEFT);

        StackPane.setMargin(
                leftPanel,
                new Insets(
                        20,
                        20,
                        20,
                        50));

        // =====================================================
        // SIGNUP CARD
        // =====================================================

        VBox signupCard =
                new VBox(15);

        signupCard.setPrefWidth(400);
        signupCard.setMinWidth(400);
        signupCard.setMaxWidth(400);

        signupCard.setPrefHeight(650);
        signupCard.setMaxHeight(650);

        signupCard.setPadding(
                new Insets(25));

        signupCard.setAlignment(
                Pos.TOP_CENTER);

        signupCard.setStyle(
                "-fx-background-color:#F8F3EE;"
                        + "-fx-border-color:#c7c3bd;"
                        + "-fx-border-radius:15;"
                        + "-fx-border-width:1.5;"
                        + "-fx-background-radius:15;"
                        + "-fx-effect:dropshadow("
                        + "gaussian,"
                        + "rgba(78,52,46,0.18),"
                        + "20,0,0,8);");

        // =====================================================
        // TITLE
        // =====================================================

        Label createTitle =
                new Label(
                        "Create Account");

        createTitle.setStyle(
                "-fx-font-size:26px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#333333;");

        Label createSubtitle =
                new Label(
                        "Join Society360 and simplify your life");

        createSubtitle.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-text-fill:#535050;");

        // =====================================================
        // ROLE LABEL
        // =====================================================

        Label roleLabel =
                new Label("I am a");

        roleLabel.setStyle(
                "-fx-font-size:13px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#555555;");

        // =====================================================
        // ROLE RADIO BUTTONS
        // =====================================================

        RadioButton owner =
                new RadioButton("Owner");

        RadioButton resident =
                new RadioButton("Resident");

        RadioButton secretary =
                new RadioButton("Secretary");

        RadioButton guard =
                new RadioButton("Guard");

        String roleStyle =
                "-fx-font-size:16px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#4e342e;";

        owner.setStyle(roleStyle);
        resident.setStyle(roleStyle);
        secretary.setStyle(roleStyle);
        guard.setStyle(roleStyle);

        ToggleGroup roleGroup =
                new ToggleGroup();

        owner.setToggleGroup(roleGroup);
        resident.setToggleGroup(roleGroup);
        secretary.setToggleGroup(roleGroup);
        guard.setToggleGroup(roleGroup);

        VBox roles =
                new VBox(20);

        roles.setAlignment(
                Pos.CENTER_LEFT);

        roles.getChildren().addAll(
                owner,
                resident,
                secretary,
                guard);

        // =====================================================
        // BACK BUTTON
        // =====================================================

        Button backToLoginBtn =
                new Button("← Back");

        backToLoginBtn.setPrefWidth(100);
        backToLoginBtn.setPrefHeight(40);

        backToLoginBtn.setStyle(
                "-fx-background-color:transparent;"
                        + "-fx-text-fill:#4e342e;"
                        + "-fx-font-size:14px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-cursor:hand;");

        backToLoginBtn.setOnAction(event -> {

            LogInPage loginPage =
                    new LogInPage();

            stage.setScene(
                    loginPage.createScene(stage));

            stage.show();
        });

        // =====================================================
        // CONTINUE BUTTON
        // =====================================================

        Button continueBtn =
                new Button("Continue");

        continueBtn.setPrefWidth(330);
        continueBtn.setPrefHeight(45);

        continueBtn.setStyle(
                "-fx-background-color:#4e342e;"
                        + "-fx-text-fill:white;"
                        + "-fx-font-size:15px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-background-radius:8;");

        // =====================================================
        // DETAILS BOX
        // =====================================================

        VBox detailsBox =
                new VBox(10);

        detailsBox.setAlignment(
                Pos.TOP_CENTER);

        detailsBox.setVisible(false);
        detailsBox.setManaged(false);

        // =====================================================
        // CONTINUE ACTION
        // =====================================================

        continueBtn.setOnAction(event -> {

            Toggle selected =
                    roleGroup.getSelectedToggle();

            if (selected == null) {

                showAlert(
                        "Role Required",
                        "Please select your role first.");

                return;
            }

            String role =
                    ((RadioButton) selected).getText();

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

            signupCard.setPrefHeight(
                    ScreenSize.getHeight() - 40);

            signupCard.setMaxHeight(
                    ScreenSize.getHeight() - 40);
        });

        // =====================================================
        // ADD CONTENT
        // =====================================================

        signupCard.getChildren().addAll(
                backToLoginBtn,
                createTitle,
                createSubtitle,
                roleLabel,
                roles,
                continueBtn,
                detailsBox);

        // =====================================================
        // ROOT
        // =====================================================

        StackPane root =
                new StackPane();

        root.setStyle(
                "-fx-background-color:"
                        + "linear-gradient("
                        + "to right,"
                        + "#D7CCC8,"
                        + "#bfb1a7);");

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

        signinScene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight());

        stage.setTitle(
                "Society360 - Create Account");

        return signinScene;
    }

    // =========================================================
    // CREATE ROLE FORM
    // =========================================================

    private void createRoleForm(
            String role,
            VBox detailsBox,
            Stage stage) {

        detailsBox.getChildren().clear();

        // Reset fields
        residentFlatNo = null;
        residentAadhar = null;
        residentSociety = null;
        residentOwnerName = null;

        ownerFlatNo = null;
        ownerAadhar = null;
        ownerAddress = null;
        ownerSociety = null;

        joiningDate = null;
        guardAadhar = null;
        guardSociety = null;

        secretaryAadhar = null;
        secretarySociety = null;

        // =====================================================
        // TITLE
        // =====================================================

        Label roleTitle =
                new Label(
                        role + " Details");

        roleTitle.setStyle(
                "-fx-font-size:20px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#4e342e;");

        // =====================================================
        // COMMON FIELDS
        // =====================================================

        TextField nameField =
                createTextField("Full Name");

        TextField phoneField =
                createTextField("Phone Number");

        DatePicker dob =
                new DatePicker();

        dob.setPromptText(
                "Date of Birth");

        dob.setPrefHeight(40);
        dob.setMaxWidth(350);

        TextField emailField =
                createTextField(
                        "Email Address");

        ComboBox<String> gender =
                new ComboBox<>();

        gender.getItems().addAll(
                "Male",
                "Female",
                "Other");

        gender.setPromptText(
                "Gender");

        gender.setPrefHeight(40);
        gender.setMaxWidth(350);

        PasswordField password =
                new PasswordField();

        password.setPromptText(
                "Create Password");

        password.setPrefHeight(40);
        password.setMaxWidth(350);

        PasswordField confirmPassword =
                new PasswordField();

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

        // =====================================================
        // RESIDENT
        // =====================================================

        if (role.equalsIgnoreCase("Resident")) {

            residentFlatNo =
                    createTextField(
                            "Flat Number");

            residentAadhar =
                    createTextField(
                            "Aadhar Number");

            residentSociety =
                    createTextField(
                            "Society Name");

            residentOwnerName =
                    createTextField(
                            "Owner Name");

            Label residentTypeLabel =
                    new Label(
                            "Resident Type");

            residentTypeLabel.setStyle(
                    "-fx-font-size:13px;"
                            + "-fx-font-weight:bold;"
                            + "-fx-text-fill:#3d3d3d;");

            RadioButton ownerOption =
                    new RadioButton("Owner");

            RadioButton residentOption =
                    new RadioButton("Resident");

            ToggleGroup residentTypeGroup =
                    new ToggleGroup();

            ownerOption.setToggleGroup(
                    residentTypeGroup);

            residentOption.setToggleGroup(
                    residentTypeGroup);

            HBox residentTypeBox =
                    new HBox(20);

            residentTypeBox.setAlignment(
                    Pos.CENTER_LEFT);

            residentTypeBox.getChildren().addAll(
                    ownerOption,
                    residentOption);

            residentOwnerName.setVisible(false);
            residentOwnerName.setManaged(false);

            residentOption.setOnAction(e -> {

                residentOwnerName.setVisible(true);
                residentOwnerName.setManaged(true);
            });

            ownerOption.setOnAction(e -> {

                residentOwnerName.setVisible(false);
                residentOwnerName.setManaged(false);
                residentOwnerName.clear();
            });

            detailsBox.getChildren().addAll(
                    residentFlatNo,
                    password,
                    confirmPassword,
                    residentAadhar,
                    residentSociety,
                    residentTypeLabel,
                    residentTypeBox,
                    residentOwnerName);
        }

        // =====================================================
        // OWNER
        // =====================================================

        else if (role.equalsIgnoreCase("Owner")) {

            ownerFlatNo =
                    createTextField(
                            "Flat Number");

            ownerAadhar =
                    createTextField(
                            "Aadhar Number");

            ownerAddress =
                    createTextField(
                            "Permanent Address");

            ownerSociety =
                    createTextField(
                            "Society Name");

            detailsBox.getChildren().addAll(
                    ownerFlatNo,
                    password,
                    confirmPassword,
                    ownerAadhar,
                    ownerAddress,
                    ownerSociety);
        }

        // =====================================================
        // GUARD
        // =====================================================

        else if (role.equalsIgnoreCase("Guard")) {

            joiningDate =
                    new DatePicker();

            joiningDate.setPromptText(
                    "Joining Date");

            joiningDate.setPrefHeight(40);
            joiningDate.setMaxWidth(350);

            guardAadhar =
                    createTextField(
                            "Aadhar Number");

            guardSociety =
                    createTextField(
                            "Society Name");

            detailsBox.getChildren().addAll(
                    password,
                    confirmPassword,
                    joiningDate,
                    guardAadhar,
                    guardSociety);
        }

        // =====================================================
        // SECRETARY
        // =====================================================

        else if (role.equalsIgnoreCase("Secretary")) {

            secretaryAadhar =
                    createTextField(
                            "Aadhar Number");

            secretarySociety =
                    createTextField(
                            "Society Name");

            detailsBox.getChildren().addAll(
                    password,
                    confirmPassword,
                    secretaryAadhar,
                    secretarySociety);
        }

        // =====================================================
        // TERMS
        // =====================================================

        CheckBox terms =
                new CheckBox(
                        "I agree to the Terms & Conditions and Privacy Policy");

        terms.setStyle(
                "-fx-font-size:11px;"
                        + "-fx-text-fill:#777777;");

        // =====================================================
        // SIGNUP BUTTON
        // =====================================================

        Button signupBtn =
                new Button("Sign Up");

        signupBtn.setPrefWidth(350);
        signupBtn.setPrefHeight(45);

        signupBtn.setStyle(
                "-fx-background-color:#4e342e;"
                        + "-fx-text-fill:white;"
                        + "-fx-font-size:15px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-background-radius:8;");

        // =====================================================
        // SIGNUP ACTION
        // =====================================================

        signupBtn.setOnAction(event -> {

            // =================================================
            // TERMS
            // =================================================

            if (!terms.isSelected()) {

                showAlert(
                        "Terms Required",
                        "Please accept the Terms & Conditions.");

                return;
            }

            // =================================================
            // COMMON DATA
            // =================================================

            String name =
                    nameField.getText().trim();

            String phone =
                    phoneField.getText().trim();

            String email =
                    emailField.getText()
                            .trim()
                            .toLowerCase();

            String pass =
                    password.getText();

            String confirmPass =
                    confirmPassword.getText();

            String dobValue = "";

            if (dob.getValue() != null) {

                dobValue =
                        dob.getValue().toString();
            }

            String genderValue = "";

            if (gender.getValue() != null) {

                genderValue =
                        gender.getValue();
            }

            // =================================================
            // COMMON VALIDATION
            // =================================================

            if (name.isEmpty()
                    || phone.isEmpty()
                    || email.isEmpty()
                    || pass.isEmpty()
                    || confirmPass.isEmpty()) {

                showAlert(
                        "Missing Details",
                        "Please fill all required fields.");

                return;
            }

            // =================================================
            // EMAIL VALIDATION
            // =================================================

            if (!email.matches(
                    "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                showAlert(
                        "Invalid Email",
                        "Please enter a valid email address.");

                return;
            }

            // =================================================
            // PHONE VALIDATION
            // =================================================

            if (!phone.matches("\\d{10}")) {

                showAlert(
                        "Invalid Phone",
                        "Phone number must contain exactly 10 digits.");

                return;
            }

            // =================================================
            // PASSWORD
            // =================================================

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

            // =================================================
            // VARIABLES
            // =================================================

            String flatNo = "";
            String aadhar = "";
            String society = "";
            String ownerName = "";
            String address = "";
            String joiningDateValue = "";

            // =================================================
            // RESIDENT DATA
            // =================================================

            if (role.equalsIgnoreCase("Resident")) {

                flatNo =
                        residentFlatNo
                                .getText()
                                .trim();

                aadhar =
                        residentAadhar
                                .getText()
                                .trim();

                society =
                        residentSociety
                                .getText()
                                .trim();

                ownerName =
                        residentOwnerName
                                .getText()
                                .trim();

                if (flatNo.isEmpty()
                        || aadhar.isEmpty()
                        || society.isEmpty()) {

                    showAlert(
                            "Missing Details",
                            "Please fill Flat Number, Aadhar Number and Society Name.");

                    return;
                }

                if (!aadhar.matches("\\d{12}")) {

                    showAlert(
                            "Invalid Aadhar",
                            "Aadhar number must contain exactly 12 digits.");

                    return;
                }
            }

            // =================================================
            // OWNER DATA
            // =================================================

            else if (role.equalsIgnoreCase("Owner")) {

                flatNo =
                        ownerFlatNo
                                .getText()
                                .trim();

                aadhar =
                        ownerAadhar
                                .getText()
                                .trim();

                address =
                        ownerAddress
                                .getText()
                                .trim();

                society =
                        ownerSociety
                                .getText()
                                .trim();

                if (flatNo.isEmpty()
                        || aadhar.isEmpty()
                        || address.isEmpty()
                        || society.isEmpty()) {

                    showAlert(
                            "Missing Details",
                            "Please fill all Owner details.");

                    return;
                }

                if (!aadhar.matches("\\d{12}")) {

                    showAlert(
                            "Invalid Aadhar",
                            "Aadhar number must contain exactly 12 digits.");

                    return;
                }
            }

            // =================================================
            // GUARD DATA
            // =================================================

            else if (role.equalsIgnoreCase("Guard")) {

                aadhar =
                        guardAadhar
                                .getText()
                                .trim();

                society =
                        guardSociety
                                .getText()
                                .trim();

                if (joiningDate.getValue() != null) {

                    joiningDateValue =
                            joiningDate
                                    .getValue()
                                    .toString();
                }

                if (aadhar.isEmpty()
                        || society.isEmpty()
                        || joiningDateValue.isEmpty()) {

                    showAlert(
                            "Missing Details",
                            "Please fill all Guard details.");

                    return;
                }

                if (!aadhar.matches("\\d{12}")) {

                    showAlert(
                            "Invalid Aadhar",
                            "Aadhar number must contain exactly 12 digits.");

                    return;
                }
            }

            // =================================================
            // SECRETARY DATA
            // =================================================

            else if (role.equalsIgnoreCase("Secretary")) {

                aadhar =
                        secretaryAadhar
                                .getText()
                                .trim();

                society =
                        secretarySociety
                                .getText()
                                .trim();

                if (aadhar.isEmpty()
                        || society.isEmpty()) {

                    showAlert(
                            "Missing Details",
                            "Please fill all Secretary details.");

                    return;
                }

                if (!aadhar.matches("\\d{12}")) {

                    showAlert(
                            "Invalid Aadhar",
                            "Aadhar number must contain exactly 12 digits.");

                    return;
                }
            }

            // =================================================
            // SAVE USER
            // =================================================

            boolean saved =
                    controller.addUser(
                            name,
                            email,
                            pass,
                            role,
                            phone,
                            dobValue,
                            genderValue,
                            flatNo,
                            aadhar,
                            society,
                            ownerName,
                            address,
                            joiningDateValue);

            // =================================================
            // FAILED
            // =================================================

            if (!saved) {

                showAlert(
                        "Registration Failed",
                        "Unable to create account or save user information.");

                return;
            }

            // =================================================
            // SUCCESS
            // =================================================

            showAlert(
                    "Sign Up Successful",
                    "Your account has been created successfully!");

            // =================================================
            // GO TO LOGIN
            // =================================================

            LogInPage loginPage =
                    new LogInPage();

            stage.setScene(
                    loginPage.createScene(stage));

            stage.show();
        });

        // =====================================================
        // LOGIN TEXT
        // =====================================================

        Label accountText =
                new Label(
                        "Already have an account?");

        accountText.setStyle(
                "-fx-text-fill:#666666;"
                        + "-fx-font-size:12px;");

        Button loginBtn =
                new Button("Login");

        loginBtn.setStyle(
                "-fx-background-color:transparent;"
                        + "-fx-text-fill:#5f331e;"
                        + "-fx-font-weight:bold;"
                        + "-fx-font-size:12px;");

        loginBtn.setOnAction(event -> {

            LogInPage loginPage =
                    new LogInPage();

            stage.setScene(
                    loginPage.createScene(stage));

            stage.show();
        });

        HBox loginBox =
                new HBox(5);

        loginBox.setAlignment(
                Pos.CENTER);

        loginBox.getChildren().addAll(
                accountText,
                loginBtn);

        detailsBox.getChildren().addAll(
                terms,
                signupBtn,
                loginBox);
    }

    // =========================================================
    // CREATE TEXT FIELD
    // =========================================================

    private TextField createTextField(
            String prompt) {

        TextField field =
                new TextField();

        field.setPromptText(prompt);

        field.setPrefHeight(40);
        field.setMaxWidth(350);

        field.setStyle(
                "-fx-background-color:white;"
                        + "-fx-background-radius:8;"
                        + "-fx-border-color:#D7CCC8;"
                        + "-fx-border-radius:8;"
                        + "-fx-padding:0 12;"
                        + "-fx-font-size:13px;");

        return field;
    }

    // =========================================================
    // ALERT
    // =========================================================

    private void showAlert(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

    // =========================================================
    // LEFT PANEL
    // =========================================================

    private VBox createLeftPanel() {

        VBox leftPanel =
                new VBox(15);

        leftPanel.setAlignment(
                Pos.CENTER);

        Label title =
                new Label(
                        "Society360");

        title.setStyle(
                "-fx-font-size:42px;"
                        + "-fx-font-weight:bold;"
                        + "-fx-text-fill:#4e342e;");

        Label subtitle =
                new Label(
                        "Smart Society Management System");

        subtitle.setStyle(
                "-fx-font-size:16px;"
                        + "-fx-text-fill:#5d4037;");

        leftPanel.getChildren().addAll(
                title,
                subtitle);

        return leftPanel;
    }
}