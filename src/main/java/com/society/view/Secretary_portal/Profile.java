package com.society.view.Secretary_portal;

import com.society.controller.Secretary_Controller.ProfileController;
import com.society.model.Secretary_model.ProfileModel;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Profile {

    private Scene profileScene;

    private ProfileController profileController;

    private ProfileModel currentProfile;

    // ============================================================
    // DYNAMIC LABELS
    // ============================================================

    private Label profileName;
    private Label profileRole;
    private Label profileSociety;

    private Label fullNameValue;
    private Label emailValue;
    private Label phoneValue;
    private Label roleValue;

    private Label statusValue;
    private Label typeValue;
    private Label societyValue;
    private Label memberSinceValue;

    // ============================================================
    // CREATE SCENE
    // ============================================================

    public Scene createScene(Stage stage) {

        profileController =
                new ProfileController();

        // ========================================================
        // SIDEBAR
        // ========================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // ========================================================
        // MAIN
        // ========================================================

        VBox mainvb =
                new VBox(14);

        mainvb.setPadding(
                new Insets(
                        22,
                        25,
                        20,
                        25));

        mainvb.setPrefWidth(1220);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;");

        // ========================================================
        // HEADING
        // ========================================================

        Label heading =
                new Label("PROFILE");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;");

        // ========================================================
        // TITLE
        // ========================================================

        Label title =
                new Label("My Profile");

        title.setStyle(
                "-fx-font-size:21px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;");

        Label subtitle =
                new Label(
                        "Manage your personal and account information");

        subtitle.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#555555;");

        VBox titleBox =
                new VBox(
                        3,
                        title,
                        subtitle);

        // ========================================================
        // LEFT CARD
        // ========================================================

        VBox profileCard =
                new VBox(15);

        profileCard.setPrefWidth(330);
        profileCard.setMinWidth(330);
        profileCard.setPrefHeight(555);

        profileCard.setPadding(
                new Insets(27));

        profileCard.setAlignment(
                Pos.TOP_CENTER);

        profileCard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#E5E5E5;" +
                "-fx-border-radius:10;");

        // ========================================================
        // PHOTO
        // ========================================================

        StackPane photoContainer =
                new StackPane();

        photoContainer.setPrefSize(
                130,
                130);

        photoContainer.setMaxSize(
                130,
                130);

        Circle photoBackground =
                new Circle(
                        65,
                        Color.web("#E5F7EC"));

        Label initial =
                new Label("S");

        initial.setStyle(
                "-fx-font-size:44px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;");

        photoContainer.getChildren()
                .addAll(
                        photoBackground,
                        initial);

        // ========================================================
        // PROFILE NAME
        // ========================================================

        profileName =
                new Label("Loading...");

        profileName.setStyle(
                "-fx-font-size:23px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;");

        // ========================================================
        // ROLE
        // ========================================================

        profileRole =
                new Label("Loading...");

        profileRole.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;");

        // ========================================================
        // SOCIETY
        // ========================================================

        profileSociety =
                new Label("Loading...");

        profileSociety.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;");

        VBox profileDetails =
                new VBox(5);

        profileDetails.setAlignment(
                Pos.CENTER);

        profileDetails.getChildren()
                .addAll(
                        profileName,
                        profileRole,
                        profileSociety);

        Separator profileSeparator =
                new Separator();

        // ========================================================
        // EDIT
        // ========================================================

        Button editBtn =
                new Button("Edit Profile");

        editBtn.setPrefWidth(225);
        editBtn.setPrefHeight(40);

        editBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;");

        editBtn.setOnAction(
                e -> showEditProfileDialog());

        // ========================================================
        // LOGOUT
        // ========================================================

        Button logoutBtn =
                new Button("Logout");

        logoutBtn.setPrefWidth(225);
        logoutBtn.setPrefHeight(40);

        logoutBtn.setStyle(
                "-fx-background-color:#D9534F;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;");

        logoutBtn.setOnAction(e -> {

            com.society.dao.Welcome.UserDao
                    .clearLoggedInUser();

            Logout logout =
                    new Logout();

            stage.setScene(
                    logout.createScene(stage));
        });

        VBox profileButtons =
                new VBox(10);

        profileButtons.setAlignment(
                Pos.CENTER);

        profileButtons.getChildren()
                .addAll(
                        editBtn,
                        logoutBtn);

        profileCard.getChildren()
                .addAll(
                        photoContainer,
                        profileDetails,
                        profileSeparator,
                        profileButtons);

        // ========================================================
        // RIGHT INFORMATION CARD
        // ========================================================

        VBox informationCard =
                new VBox(16);

        informationCard.setPrefWidth(775);
        informationCard.setMinWidth(775);
        informationCard.setPrefHeight(555);

        informationCard.setPadding(
                new Insets(25));

        informationCard.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#E5E5E5;" +
                "-fx-border-radius:10;");

        // ========================================================
        // PERSONAL INFORMATION
        // ========================================================

        Label personalTitle =
                createSectionTitle(
                        "Personal Information");

        Separator personalSeparator =
                new Separator();

        fullNameValue =
                new Label("Not Available");

        emailValue =
                new Label("Not Available");

        phoneValue =
                new Label("Not Available");

        roleValue =
                new Label("Not Available");

        VBox personalSection =
                new VBox(9);

        personalSection.getChildren()
                .addAll(
                        personalTitle,
                        personalSeparator,
                        createInfoRow(
                                "Full Name",
                                fullNameValue),
                        createInfoRow(
                                "Email",
                                emailValue),
                        createInfoRow(
                                "Phone",
                                phoneValue),
                        createInfoRow(
                                "Role",
                                roleValue));

        // ========================================================
        // ACCOUNT INFORMATION
        // ========================================================

        Label accountTitle =
                createSectionTitle(
                        "Account Information");

        Separator accountSeparator =
                new Separator();

        statusValue =
                new Label("Active");

        typeValue =
                new Label("Account");

        societyValue =
                new Label("Not Available");

        memberSinceValue =
                new Label("Not Available");

        VBox accountSection =
                new VBox(9);

        accountSection.getChildren()
                .addAll(
                        accountTitle,
                        accountSeparator,
                        createInfoRow(
                                "Account Status",
                                statusValue),
                        createInfoRow(
                                "Account Type",
                                typeValue),
                        createInfoRow(
                                "Society",
                                societyValue),
                        createInfoRow(
                                "Member Since",
                                memberSinceValue));

        // ========================================================
        // SECURITY
        // ========================================================

        Label securityTitle =
                createSectionTitle(
                        "Security");

        Separator securitySeparator =
                new Separator();

        Label passwordLabel =
                new Label("Password");

        passwordLabel.setStyle(
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#777777;");

        Label passwordStatus =
                new Label(
                        "Your password is securely protected");

        passwordStatus.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#555555;");

        VBox passwordInfo =
                new VBox(
                        4,
                        passwordLabel,
                        passwordStatus);

        Button changePasswordBtn =
                new Button("Change Password");

        changePasswordBtn.setPrefWidth(165);
        changePasswordBtn.setPrefHeight(38);

        changePasswordBtn.setStyle(
                "-fx-background-color:white;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;" +
                "-fx-border-color:#123C36;" +
                "-fx-border-radius:7;" +
                "-fx-background-radius:7;");

        HBox securityContent =
                new HBox();

        securityContent.setAlignment(
                Pos.CENTER_LEFT);

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS);

        securityContent.getChildren()
                .addAll(
                        passwordInfo,
                        spacer,
                        changePasswordBtn);

        VBox securitySection =
                new VBox(9);

        securitySection.getChildren()
                .addAll(
                        securityTitle,
                        securitySeparator,
                        securityContent);

        informationCard.getChildren()
                .addAll(
                        personalSection,
                        accountSection,
                        securitySection);

        // ========================================================
        // PROFILE CONTENT
        // ========================================================

        HBox profileContent =
                new HBox(22);

        profileContent.setAlignment(
                Pos.TOP_LEFT);

        profileContent.getChildren()
                .addAll(
                        profileCard,
                        informationCard);

        mainvb.getChildren()
                .addAll(
                        heading,
                        titleBox,
                        profileContent);

        // ========================================================
        // ROOT
        // ========================================================

        HBox root =
                new HBox();

        root.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE);

        root.getChildren()
                .addAll(
                        sidebar,
                        mainvb);

        root.setStyle(
                "-fx-background-color:#434141;");

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS);

        // ========================================================
        // SCENE
        // ========================================================

        profileScene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight());

        // ========================================================
        // LOAD LOGGED-IN USER
        // ========================================================

        loadProfile();

        return profileScene;
    }

    // ============================================================
    // LOAD PROFILE
    // ============================================================

    private void loadProfile() {

        try {

            currentProfile =
                    profileController.getProfile();

            if (currentProfile == null) {

                showAlert(
                        "Profile",
                        "No logged-in account found.");

                return;
            }

            // ====================================================
            // LEFT CARD
            // ====================================================

            String name =
                    safe(currentProfile.getName());

            String role =
                    safe(currentProfile.getRole());

            String society =
                    safe(currentProfile.getSociety());

            profileName.setText(
                    name.isEmpty()
                            ? "Not Available"
                            : name);

            profileRole.setText(
                    role.isEmpty()
                            ? "Not Available"
                            : role);

            profileSociety.setText(
                    society.isEmpty()
                            ? "Not Available"
                            : society);

            // ====================================================
            // PERSONAL
            // ====================================================

            fullNameValue.setText(
                    display(
                            currentProfile.getName()));

            emailValue.setText(
                    display(
                            currentProfile.getEmail()));

            phoneValue.setText(
                    display(
                            currentProfile.getMobile()));

            roleValue.setText(
                    display(
                            currentProfile.getRole()));

            // ====================================================
            // ACCOUNT
            // ====================================================

            statusValue.setText(
                    display(
                            currentProfile.getStatus()));

            typeValue.setText(
                    display(
                            currentProfile.getAccountType()));

            societyValue.setText(
                    display(
                            currentProfile.getSociety()));

            memberSinceValue.setText(
                    display(
                            currentProfile.getMemberSince()));

            System.out.println(
                    "Profile displayed successfully.");

        } catch (Exception e) {

            System.out.println(
                    "Profile loading error:");

            e.printStackTrace();

            showAlert(
                    "Error",
                    "Unable to load profile.");
        }
    }

    // ============================================================
    // EDIT PROFILE
    // ============================================================

    private void showEditProfileDialog() {

        if (currentProfile == null) {

            showAlert(
                    "Profile",
                    "Profile data is not available.");

            return;
        }

        TextField nameField =
                new TextField(
                        safe(currentProfile.getName()));

        TextField emailField =
                new TextField(
                        safe(currentProfile.getEmail()));

        TextField mobileField =
                new TextField(
                        safe(currentProfile.getMobile()));

        TextField societyField =
                new TextField(
                        safe(currentProfile.getSociety()));

        nameField.setPromptText(
                "Enter full name");

        emailField.setPromptText(
                "Email");

        mobileField.setPromptText(
                "Enter mobile number");

        societyField.setPromptText(
                "Enter society name");

        nameField.setPrefWidth(280);
        emailField.setPrefWidth(280);
        mobileField.setPrefWidth(280);
        societyField.setPrefWidth(280);

        // ========================================================
        // EMAIL READ ONLY
        // ========================================================

        emailField.setEditable(false);

        emailField.setStyle(
                "-fx-background-color:#eeeeee;" +
                "-fx-text-fill:#666666;");

        // ========================================================
        // GRID
        // ========================================================

        GridPane grid =
                new GridPane();

        grid.setHgap(12);
        grid.setVgap(12);

        grid.setPadding(
                new Insets(20));

        grid.add(
                new Label("Full Name:"),
                0,
                0);

        grid.add(
                nameField,
                1,
                0);

        grid.add(
                new Label("Email:"),
                0,
                1);

        grid.add(
                emailField,
                1,
                1);

        grid.add(
                new Label("Mobile:"),
                0,
                2);

        grid.add(
                mobileField,
                1,
                2);

        grid.add(
                new Label("Society:"),
                0,
                3);

        grid.add(
                societyField,
                1,
                3);

        // ========================================================
        // BUTTONS
        // ========================================================

        Button saveButton =
                new Button("Save Changes");

        Button cancelButton =
                new Button("Cancel");

        saveButton.setPrefWidth(130);
        saveButton.setPrefHeight(38);

        cancelButton.setPrefWidth(100);
        cancelButton.setPrefHeight(38);

        saveButton.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;");

        cancelButton.setStyle(
                "-fx-background-color:#D9534F;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;");

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT);

        buttonBox.getChildren()
                .addAll(
                        saveButton,
                        cancelButton);

        VBox popup =
                new VBox(15);

        popup.setPadding(
                new Insets(20));

        popup.setPrefWidth(470);
        popup.setMaxWidth(470);

        popup.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;");

        Label popupTitle =
                new Label("Edit Profile");

        popupTitle.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;");

        popup.getChildren()
                .addAll(
                        popupTitle,
                        grid,
                        buttonBox);

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.45);");

        overlay.getChildren()
                .add(popup);

        StackPane rootStack =
                new StackPane();

        rootStack.getChildren()
                .addAll(
                        profileScene.getRoot(),
                        overlay);

        Scene dialogScene =
                new Scene(
                        rootStack,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight());

        Stage dialogStage =
                new Stage();

        dialogStage.setTitle(
                "Edit Profile");

        dialogStage.setScene(
                dialogScene);

        dialogStage.initOwner(
                profileScene.getWindow());

        // ========================================================
        // CANCEL
        // ========================================================

        cancelButton.setOnAction(
                e -> dialogStage.close());

        // ========================================================
        // SAVE
        // ========================================================

        saveButton.setOnAction(e -> {

            String name =
                    nameField.getText().trim();

            String mobile =
                    mobileField.getText().trim();

            String society =
                    societyField.getText().trim();

            if (name.isEmpty()
                    || mobile.isEmpty()
                    || society.isEmpty()) {

                showAlert(
                        "Validation Error",
                        "Please fill all profile details.");

                return;
            }

            if (!mobile.matches("\\d{10}")) {

                showAlert(
                        "Validation Error",
                        "Mobile number must contain exactly 10 digits.");

                return;
            }

            boolean success =
                    profileController.saveProfile(
                            name,
                            emailField.getText().trim(),
                            mobile,
                            society);

            if (success) {

                // ================================================
                // UPDATE LOCAL MODEL
                // ================================================

                currentProfile.setName(name);
                currentProfile.setMobile(mobile);
                currentProfile.setSociety(society);

                // ================================================
                // UPDATE UI
                // ================================================

                profileName.setText(name);
                profileSociety.setText(society);

                fullNameValue.setText(name);
                phoneValue.setText(mobile);
                societyValue.setText(society);

                dialogStage.close();

                showAlert(
                        "Success",
                        "Profile updated successfully in Firestore.");

            } else {

                showAlert(
                        "Error",
                        "Failed to update profile.");
            }
        });

        dialogStage.show();
    }

    // ============================================================
    // SECTION TITLE
    // ============================================================

    private Label createSectionTitle(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;");

        return label;
    }

    // ============================================================
    // INFORMATION ROW
    // ============================================================

    private HBox createInfoRow(
            String labelText,
            Label value) {

        Label label =
                new Label(labelText);

        label.setPrefWidth(150);

        label.setStyle(
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#777777;");

        value.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#434141;");

        HBox row =
                new HBox(15);

        row.setAlignment(
                Pos.CENTER_LEFT);

        row.setPadding(
                new Insets(
                        4,
                        0,
                        4,
                        0));

        row.getChildren()
                .addAll(
                        label,
                        value);

        return row;
    }

    // ============================================================
    // SAFE
    // ============================================================

    private String safe(
            String value) {

        if (value == null) {

            return "";
        }

        return value.trim();
    }

    // ============================================================
    // DISPLAY
    // ============================================================

    private String display(
            String value) {

        if (value == null
                || value.trim().isEmpty()) {

            return "Not Available";
        }

        return value;
    }

    // ============================================================
    // ALERT
    // ============================================================

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
}