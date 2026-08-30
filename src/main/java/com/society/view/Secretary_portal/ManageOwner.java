package com.society.view.Secretary_portal;

import java.util.List;

import com.society.controller.Secretary_Controller.OwnerController;
import com.society.model.Secretary_model.Owner;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageOwner {

    // =====================================================
    // SCENE
    // =====================================================

    private Scene Owners;

    // =====================================================
    // ROOT
    // =====================================================

    private StackPane rootPane;

    // =====================================================
    // CONTROLLER
    // =====================================================

    private OwnerController ownerController;

    // =====================================================
    // OWNER LIST
    // =====================================================

    private VBox ownerList;

    // =====================================================
    // SEARCH
    // =====================================================

    private TextField search;

    // =====================================================
    // CREATE SCENE
    // =====================================================

    public Scene createScene(Stage stage) {

        // =====================================================
        // CONTROLLER
        // =====================================================

        ownerController =
                new OwnerController();

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb =
                new VBox(10);

        mainvb.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainvb.setPadding(
                new Insets(20)
        );

        mainvb.setSpacing(10);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label("Manage Owners");

        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        // =====================================================
        // SUBTITLE
        // =====================================================

        Label subtitle =
                new Label(
                        "View and manage all flat owners"
                );

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        search =
                new TextField();

        search.setPromptText(
                "Search owner, flat no., phone..."
        );

        search.setPrefHeight(45);

        search.setPrefWidth(600);

        search.setMaxWidth(
                Double.MAX_VALUE
        );

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        HBox.setHgrow(
                search,
                Priority.ALWAYS
        );

        // =====================================================
        // ADD OWNER BUTTON
        // =====================================================

        Button addOwnerBtn =
                new Button("+ Add New Owner");

        addOwnerBtn.setPrefWidth(180);

        addOwnerBtn.setPrefHeight(45);

        addOwnerBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        // =====================================================
        // REFRESH BUTTON
        // ONLY REFRESH SYMBOL
        // =====================================================

        Button refreshBtn =
                new Button("⟳");

        refreshBtn.setPrefWidth(45);

        refreshBtn.setPrefHeight(45);

        refreshBtn.setMinWidth(45);

        refreshBtn.setMinHeight(45);

        refreshBtn.setMaxWidth(45);

        refreshBtn.setMaxHeight(45);

        refreshBtn.setStyle(
                "-fx-background-color:#56342B;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;" +
                "-fx-padding:0;"
        );

        Tooltip refreshTooltip =
                new Tooltip("Refresh");

        refreshBtn.setTooltip(
                refreshTooltip
        );

        // =====================================================
        // SEARCH BOX
        // =====================================================

        HBox searchBox =
                new HBox(12);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.setMaxWidth(
                Double.MAX_VALUE
        );

        searchBox.getChildren().addAll(
                search,
                addOwnerBtn,
                refreshBtn
        );

        // =====================================================
        // OWNER LIST
        // =====================================================

        ownerList =
                new VBox(15);

        ownerList.setPadding(
                new Insets(15, 0, 20, 0)
        );

        ownerList.setFillWidth(true);

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                ownerList
        );

        scrollPane.setFitToWidth(true);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );

        // =====================================================
        // MAIN ROOT
        // =====================================================

        HBox root =
                new HBox();

        root.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        root.setStyle(
                "-fx-background-color:#434141;"
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =====================================================
        // ROOT STACKPANE
        // =====================================================

        rootPane =
                new StackPane();

        rootPane.getChildren().add(
                root
        );

        // =====================================================
        // ADD OWNER BUTTON
        // =====================================================

        addOwnerBtn.setOnAction(
                e -> openAddOwnerDialog()
        );

        // =====================================================
        // REFRESH BUTTON
        // =====================================================

        refreshBtn.setOnAction(e -> {

            // Clear search
            search.clear();

            // Reload latest data from Firestore
            loadOwners();

            System.out.println(
                    "Owner data refreshed from Firestore."
            );
        });

        // =====================================================
        // SEARCH
        // =====================================================

        search.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    filterOwners(newValue);
                }
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                scrollPane
        );

        // =====================================================
        // LOAD DATA
        // =====================================================

        loadOwners();

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene =
                new Scene(
                        rootPane,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        Owners = scene;

        return Owners;
    }

    // =====================================================
    // LOAD OWNERS
    // =====================================================

    private void loadOwners() {

        ownerList.getChildren().clear();

        List<Owner> owners =
                ownerController.getAllOwners();

        if (owners == null ||
                owners.isEmpty()) {

            Label emptyLabel =
                    new Label(
                            "No owners found."
                    );

            emptyLabel.setStyle(
                    "-fx-font-size:16px;" +
                    "-fx-text-fill:#555555;"
            );

            ownerList.getChildren().add(
                    emptyLabel
            );

            return;
        }

        for (Owner owner : owners) {

            if (owner == null) {
                continue;
            }

            HBox ownerRow =
                    createOwnerRow(owner);

            ownerList.getChildren().add(
                    ownerRow
            );
        }
    }

    // =====================================================
    // FILTER OWNERS
    // =====================================================

    private void filterOwners(
            String searchText) {

        ownerList.getChildren().clear();

        String text =
                searchText == null
                        ? ""
                        : searchText
                                .toLowerCase()
                                .trim();

        List<Owner> owners =
                ownerController.getAllOwners();

        boolean found = false;

        if (owners != null) {

            for (Owner owner : owners) {

                if (owner == null) {
                    continue;
                }

                String name =
                        safe(owner.getName())
                                .toLowerCase();

                String flat =
                        safe(owner.getFlat())
                                .toLowerCase();

                String mobile =
                        safe(owner.getMobile())
                                .toLowerCase();

                String email =
                        safe(owner.getEmail())
                                .toLowerCase();

                String status =
                        safe(owner.getStatus())
                                .toLowerCase();

                if (name.contains(text)
                        || flat.contains(text)
                        || mobile.contains(text)
                        || email.contains(text)
                        || status.contains(text)) {

                    ownerList.getChildren().add(
                            createOwnerRow(owner)
                    );

                    found = true;
                }
            }
        }

        if (!found) {

            Label emptyLabel =
                    new Label(
                            "No matching owners found."
                    );

            emptyLabel.setStyle(
                    "-fx-font-size:16px;" +
                    "-fx-text-fill:#555555;"
            );

            ownerList.getChildren().add(
                    emptyLabel
            );
        }
    }

    // =====================================================
    // CREATE OWNER ROW
    // =====================================================

    private HBox createOwnerRow(
            Owner owner) {

        HBox ownerRow =
                new HBox(10);

        ownerRow.setPrefHeight(80);

        ownerRow.setMaxWidth(
                Double.MAX_VALUE
        );

        ownerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        ownerRow.setPadding(
                new Insets(15)
        );

        ownerRow.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        // =====================================================
        // PROFILE
        // =====================================================

        Label profile =
                new Label("👤");

        profile.setPrefWidth(45);

        profile.setPrefHeight(45);

        profile.setAlignment(
                Pos.CENTER
        );

        profile.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:21px;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label name =
                new Label(
                        safe(owner.getName())
                );

        name.setPrefWidth(200);

        name.setStyle(
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =====================================================
        // FLAT
        // =====================================================

        Label flat =
                new Label(
                        "Flat: " +
                        safe(owner.getFlat())
                );

        flat.setPrefWidth(150);

        flat.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        // =====================================================
        // MOBILE
        // =====================================================

        Label mobile =
                new Label(
                        "Mobile: " +
                        safe(owner.getMobile())
                );

        mobile.setPrefWidth(200);

        mobile.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#555555;"
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label status =
                new Label(
                        safe(owner.getStatus())
                );

        status.setPrefWidth(100);

        status.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        // =====================================================
        // ADD TO ROW
        // =====================================================

        ownerRow.getChildren().addAll(
                profile,
                name,
                flat,
                mobile,
                status
        );

        return ownerRow;
    }

    // =====================================================
    // ADD OWNER POPUP
    // =====================================================

    private void openAddOwnerDialog() {

        // =====================================================
        // OVERLAY
        // =====================================================

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );

        // =====================================================
        // FORM BOX
        // =====================================================

        VBox formBox =
                new VBox(8);

        formBox.setPadding(
                new Insets(20)
        );

        formBox.setPrefWidth(450);

        formBox.setMaxWidth(450);

        formBox.setMaxHeight(540);

        formBox.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:15;" +
                "-fx-effect:dropshadow(" +
                "gaussian, rgba(0,0,0,0.30)," +
                "20,0.2,0,5);"
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label popupTitle =
                new Label(
                        "Add New Owner"
                );

        popupTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button closeBtn =
                new Button("✕");

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );

        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeBtn
        );

        // =====================================================
        // NAME
        // =====================================================

        Label nameLabel =
                createFormLabel(
                        "Owner Name"
                );

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter owner name"
        );

        nameField.setPrefHeight(35);

        // =====================================================
        // FLAT
        // =====================================================

        Label flatLabel =
                createFormLabel(
                        "Flat Number"
                );

        TextField flatField =
                new TextField();

        flatField.setPromptText(
                "Enter flat number"
        );

        flatField.setPrefHeight(35);

        // =====================================================
        // MOBILE
        // =====================================================

        Label mobileLabel =
                createFormLabel(
                        "Mobile Number"
                );

        TextField mobileField =
                new TextField();

        mobileField.setPromptText(
                "Enter mobile number"
        );

        mobileField.setPrefHeight(35);

        // =====================================================
        // EMAIL
        // =====================================================

        Label emailLabel =
                createFormLabel(
                        "Email"
                );

        TextField emailField =
                new TextField();

        emailField.setPromptText(
                "Enter email"
        );

        emailField.setPrefHeight(35);

        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel =
                createFormLabel(
                        "Status"
                );

        TextField statusField =
                new TextField();

        statusField.setPromptText(
                "Enter status (Active / Inactive)"
        );

        statusField.setPrefHeight(35);

        // =====================================================
        // CANCEL BUTTON
        // =====================================================

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);

        cancelBtn.setPrefHeight(38);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        // =====================================================
        // SAVE BUTTON
        // =====================================================

        Button saveBtn =
                new Button("Save Owner");

        saveBtn.setPrefWidth(130);

        saveBtn.setPrefHeight(38);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        // =====================================================
        // BUTTON BOX
        // =====================================================

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.setPadding(
                new Insets(5, 0, 0, 0)
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );

        // =====================================================
        // FORM CONTENT
        // =====================================================

        formBox.getChildren().addAll(

                headerRow,

                nameLabel,
                nameField,

                flatLabel,
                flatField,

                mobileLabel,
                mobileField,

                emailLabel,
                emailField,

                statusLabel,
                statusField,

                buttonBox
        );

        // =====================================================
        // ADD FORM TO OVERLAY
        // =====================================================

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );

        rootPane.getChildren().add(
                overlay
        );

        // =====================================================
        // CLOSE
        // =====================================================

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        // =====================================================
        // CANCEL
        // =====================================================

        cancelBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        // =====================================================
        // SAVE
        // =====================================================

        saveBtn.setOnAction(e -> {

            String name =
                    nameField.getText()
                            .trim();

            String flat =
                    flatField.getText()
                            .trim();

            String mobile =
                    mobileField.getText()
                            .trim();

            String email =
                    emailField.getText()
                            .trim();

            String status =
                    statusField.getText()
                            .trim();

            // =================================================
            // VALIDATION
            // =================================================

            if (name.isEmpty()
                    || flat.isEmpty()
                    || mobile.isEmpty()
                    || email.isEmpty()
                    || status.isEmpty()) {

                showAlert(
                        Alert.AlertType.WARNING,
                        "Validation Error",
                        "Please fill all fields."
                );

                return;
            }

            // =================================================
            // ADD OWNER
            // =================================================

            boolean success =
                    ownerController.addOwner(
                            name,
                            flat,
                            mobile,
                            email,
                            status
                    );

            // =================================================
            // SUCCESS
            // =================================================

            if (success) {

                showAlert(
                        Alert.AlertType.INFORMATION,
                        "Success",
                        "Owner saved successfully!"
                );

                removeOverlay(
                        overlay
                );

                // Clear fields
                nameField.clear();
                flatField.clear();
                mobileField.clear();
                emailField.clear();
                statusField.clear();

                // =================================================
                // REFRESH FIRESTORE DATA
                // =================================================

                loadOwners();

            } else {

                showAlert(
                        Alert.AlertType.ERROR,
                        "Error",
                        "Failed to save owner."
                );
            }
        });
    }

    // =====================================================
    // FORM LABEL
    // =====================================================

    private Label createFormLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#333333;" +
                "-fx-font-size:13px;"
        );

        return label;
    }

    // =====================================================
    // REMOVE OVERLAY
    // =====================================================

    private void removeOverlay(
            StackPane overlay) {

        if (rootPane != null) {

            rootPane.getChildren()
                    .remove(overlay);
        }
    }

    // =====================================================
    // ALERT
    // =====================================================

    private void showAlert(
            Alert.AlertType type,
            String title,
            String message) {

        Alert alert =
                new Alert(type);

        alert.setTitle(title);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

    // =====================================================
    // SAFE STRING
    // =====================================================

    private String safe(
            String value) {

        return value == null
                ? ""
                : value;
    }
}