package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ManageGuard {

    private Scene guard;

    // Main StackPane
    private StackPane rootStack;

    public Scene createScene(Stage stage) {

        // ==========================================
        // SIDEBAR
        // ==========================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);


        // ==========================================
        // MAIN CONTENT
        // ==========================================

        VBox mainvb =
                new VBox(10);

        mainvb.setPrefWidth(1220);

        mainvb.setPrefHeight(750);

        mainvb.setPadding(
                new Insets(20)
        );

        mainvb.setSpacing(10);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );


        // ==========================================
        // TITLE
        // ==========================================

        Label title =
                new Label("Manage Guards");

        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );


        Label subtitle =
                new Label(
                        "View and manage Security guards"
                );

        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );


        // ==========================================
        // SEARCH
        // ==========================================

        TextField search =
                new TextField();

        search.setPromptText(
                "Search resident, flat no., phone..."
        );

        search.setPrefHeight(45);

        search.setPrefWidth(750);

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );


        // ==========================================
        // ADD GUARD BUTTON
        // ==========================================

        Button addGuardBtn =
                new Button("+ Add New Guard");

        addGuardBtn.setPrefWidth(200);

        addGuardBtn.setPrefHeight(45);

        addGuardBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        // IMPORTANT:
        // No new Stage here.
        // Popup will open inside same Scene.

        addGuardBtn.setOnAction(
                e -> openAddGuardDialog()
        );


        // ==========================================
        // SEARCH BOX
        // ==========================================

        HBox searchBox =
                new HBox(15);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.getChildren().addAll(
                search,
                addGuardBtn
        );


        // ==========================================
        // GUARD 1
        // ==========================================

        HBox resident1 =
                createGuard(
                        "Rajesh Kumar",
                        "B-402",
                        "9876543210",
                        "Active"
                );


        // ==========================================
        // GUARD 2
        // ==========================================

        HBox resident2 =
                createGuard(
                        "Sunil Yadav",
                        "B-402",
                        "9876543210",
                        "Active"
                );


        // ==========================================
        // GUARD 3
        // ==========================================

        HBox resident3 =
                createGuard(
                        "Mahesh Jagtap",
                        "B-402",
                        "9876543210",
                        "Active"
                );


        // ==========================================
        // GUARD 4
        // ==========================================

        HBox resident4 =
                createGuard(
                        "Ramesh More",
                        "B-402",
                        "9876543210",
                        "Inactive"
                );


        // ==========================================
        // GUARD LIST
        // ==========================================

        VBox vb =
                new VBox(
                        40,
                        resident1,
                        resident2,
                        resident3,
                        resident4
                );

        VBox.setMargin(
                resident1,
                new Insets(20, 0, 0, 0)
        );


        // ==========================================
        // MAIN CONTENT ADD
        // ==========================================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                vb
        );


        // ==========================================
        // MAIN ROOT
        // ==========================================

        HBox mainRoot =
                new HBox();

        mainRoot.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainRoot.getChildren().addAll(
                sidebar,
                mainvb
        );

        mainRoot.setStyle(
                "-fx-background-color:#434141;"
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );


        // ==========================================
        // STACKPANE
        // ==========================================

        rootStack =
                new StackPane();

        rootStack.getChildren().add(
                mainRoot
        );


        // ==========================================
        // SCENE
        // ==========================================

        Scene scene =
                new Scene(
                        rootStack,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        guard = scene;

        return guard;
    }


    // =====================================================
    // GUARD CARD METHOD
    // =====================================================

    private HBox createGuard(
            String guardName,
            String flatNo,
            String mobileNo,
            String statusText) {

        HBox resident =
                new HBox(5);

        resident.setAlignment(
                Pos.CENTER_LEFT
        );

        resident.setPrefWidth(1000);

        resident.setMaxWidth(1000);

        resident.setPrefHeight(70);

        resident.setPadding(
                new Insets(20)
        );

        resident.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );


        // PROFILE

        Label profile =
                new Label("👤");

        profile.setPrefWidth(50);

        profile.setPrefHeight(50);

        profile.setAlignment(
                Pos.CENTER
        );

        profile.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );


        // NAME

        Label name =
                new Label(guardName);

        name.setPrefWidth(220);

        name.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );


        // FLAT

        Label flat =
                new Label(
                        "Flat: " + flatNo
                );

        flat.setPrefWidth(150);

        flat.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );


        // MOBILE

        Label mobile =
                new Label(
                        "Mobile: " + mobileNo
                );

        mobile.setPrefWidth(220);

        mobile.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );


        // STATUS

        Label status =
                new Label(statusText);

        status.setPrefWidth(100);

        status.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );


        resident.getChildren().addAll(
                profile,
                name,
                flat,
                mobile,
                status
        );

        return resident;
    }


    // =====================================================
    // ADD GUARD POPUP
    // =====================================================

    private void openAddGuardDialog() {

        // ==========================================
        // DARK OVERLAY
        // ==========================================

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );


        // ==========================================
        // SMALL POPUP
        // ==========================================

        VBox formBox =
                new VBox(15);

        formBox.setPadding(
                new Insets(30)
        );

        formBox.setMaxWidth(500);

        formBox.setMaxHeight(450);

        formBox.setStyle("""
            -fx-background-color:#ffffff;
            -fx-background-radius:20;
            -fx-effect:dropshadow(
                three-pass-box,
                rgba(0,0,0,0.3),
                20,
                0,
                0,
                5
            );
        """);


        // ==========================================
        // HEADER
        // ==========================================

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label popupTitle =
                new Label("Add New Guard");

        popupTitle.setFont(
                Font.font(
                        "Georgia",
                        FontWeight.BOLD,
                        22
                )
        );

        popupTitle.setStyle(
                "-fx-text-fill:#123C36;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        // ==========================================
        // CLOSE BUTTON
        // ==========================================

        Button closeBtn =
                new Button("✕");

        closeBtn.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        closeBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-cursor:hand;"
        );


        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeBtn
        );


        // ==========================================
        // GUARD NAME
        // ==========================================

        Label nameLabel =
                new Label("Guard Name");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter guard name"
        );

        nameField.setPrefHeight(40);


        // ==========================================
        // MOBILE
        // ==========================================

        Label mobileLabel =
                new Label("Mobile Number");

        TextField mobileField =
                new TextField();

        mobileField.setPromptText(
                "Enter mobile number"
        );

        mobileField.setPrefHeight(40);


        // ==========================================
        // SHIFT
        // ==========================================

        Label shiftLabel =
                new Label("Shift");

        TextField shiftField =
                new TextField();

        shiftField.setPromptText(
                "Enter shift"
        );

        shiftField.setPrefHeight(40);


        // ==========================================
        // EMAIL
        // ==========================================

        Label emailLabel =
                new Label("Email");

        TextField emailField =
                new TextField();

        emailField.setPromptText(
                "Enter email"
        );

        emailField.setPrefHeight(40);


        // ==========================================
        // CANCEL BUTTON
        // ==========================================

        Button cancelBtn =
                new Button("Cancel");

        cancelBtn.setPrefWidth(100);

        cancelBtn.setPrefHeight(40);

        cancelBtn.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-text-fill:#333333;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        // ==========================================
        // SAVE BUTTON
        // ==========================================

        Button saveBtn =
                new Button("Save Guard");

        saveBtn.setPrefWidth(130);

        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );


        // ==========================================
        // BUTTON BOX
        // ==========================================

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );


        // ==========================================
        // CANCEL ACTION
        // ==========================================

        cancelBtn.setOnAction(
                e -> removeOverlay(overlay)
        );


        // ==========================================
        // SAVE ACTION
        // ==========================================

        saveBtn.setOnAction(e -> {

            // Future me yaha Firebase save code
            // add kar sakti ho.

            removeOverlay(overlay);
        });


        // ==========================================
        // ADD FORM CONTENT
        // ==========================================

        formBox.getChildren().addAll(

                headerRow,

                nameLabel,
                nameField,

                mobileLabel,
                mobileField,

                shiftLabel,
                shiftField,

                emailLabel,
                emailField,

                buttonBox
        );


        // ==========================================
        // ADD POPUP TO OVERLAY
        // ==========================================

        overlay.getChildren().add(
                formBox
        );


        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );


        // ==========================================
        // ADD OVERLAY TO SAME SCENE
        // ==========================================

        rootStack.getChildren().add(
                overlay
        );
    }


    // =====================================================
    // REMOVE POPUP
    // =====================================================

    private void removeOverlay(
            StackPane overlay) {

        rootStack.getChildren().remove(
                overlay
        );
    }
}