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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageResidents {

    private Scene Resident;

    public Scene createScene(Stage stage) {

        // ================= SIDEBAR =================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // ================= MAIN VBOX =================

        VBox mainvb = new VBox(10);
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setMaxHeight(Double.MAX_VALUE);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);
        mainvb.setStyle("-fx-background-color: #e8ddd5;");

        // ================= TITLE =================

        Label title = new Label("Manage Residents");
        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill: white;"
        );

        Label subtitle = new Label("View and manage all residents");
        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill: white;"
        );

        // ================= SEARCH =================

        TextField search = new TextField();
        search.setPromptText("Search resident, flat no., phone...");
        search.setPrefHeight(45);
        search.setPrefWidth(750);

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        // ================= ADD RESIDENT BUTTON =================

        Button addResidentBtn = new Button("+ Add New Resident");

        addResidentBtn.setPrefWidth(200);
        addResidentBtn.setPrefHeight(45);

        addResidentBtn.setStyle(
                "-fx-background-color: #4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        // =====================================================
        // ADD RESIDENT BUTTON CLICK
        // =====================================================

        addResidentBtn.setOnAction(e -> {

            // Small popup Stage
            Stage addResidentStage = new Stage();

            addResidentStage.setTitle("Add New Resident");

            // Popup should stay above main window
            addResidentStage.initOwner(stage);
            addResidentStage.initModality(Modality.WINDOW_MODAL);

            // ================= POPUP BOX =================

            VBox addResidentBox = new VBox(15);

            addResidentBox.setPrefWidth(450);
            addResidentBox.setMaxWidth(450);
            addResidentBox.setPadding(new Insets(25));

            addResidentBox.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:12;"
            );

            // ================= FORM TITLE =================

            Label formTitle = new Label("Add New Resident");

            formTitle.setStyle(
                    "-fx-font-size:22px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // ================= RESIDENT NAME =================

            Label nameLabel = new Label("Resident Name");

            nameLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#555555;"
            );

            TextField residentName = new TextField();

            residentName.setPromptText("Enter resident name");
            residentName.setPrefHeight(40);

            residentName.setStyle(
                    "-fx-background-color:#F8F9FA;" +
                    "-fx-border-color:#E1E5E8;" +
                    "-fx-border-radius:7;" +
                    "-fx-background-radius:7;"
            );

            // ================= FLAT NUMBER =================

            Label flatLabel = new Label("Flat Number");

            flatLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#555555;"
            );

            TextField flatNumber = new TextField();

            flatNumber.setPromptText("Enter flat number");
            flatNumber.setPrefHeight(40);

            flatNumber.setStyle(
                    "-fx-background-color:#F8F9FA;" +
                    "-fx-border-color:#E1E5E8;" +
                    "-fx-border-radius:7;" +
                    "-fx-background-radius:7;"
            );

            // ================= MOBILE NUMBER =================

            Label mobileLabel = new Label("Mobile Number");

            mobileLabel.setStyle(
                    "-fx-font-size:13px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#555555;"
            );

            TextField mobileNumber = new TextField();

            mobileNumber.setPromptText("Enter mobile number");
            mobileNumber.setPrefHeight(40);

            mobileNumber.setStyle(
                    "-fx-background-color:#F8F9FA;" +
                    "-fx-border-color:#E1E5E8;" +
                    "-fx-border-radius:7;" +
                    "-fx-background-radius:7;"
            );

            // ================= SAVE BUTTON =================

            Button saveBtn = new Button("Save Resident");

            saveBtn.setPrefWidth(150);
            saveBtn.setPrefHeight(40);

            saveBtn.setStyle(
                    "-fx-background-color:#4e342e;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:7;"
            );

            // ================= CANCEL BUTTON =================

            Button cancelBtn = new Button("Cancel");

            cancelBtn.setPrefWidth(100);
            cancelBtn.setPrefHeight(40);

            cancelBtn.setStyle(
                    "-fx-background-color:#4e342e;" +
                    "-fx-text-fill:#333333;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:7;"
            );

            // ================= BUTTONS =================

            HBox formButtons = new HBox(10);

            formButtons.setAlignment(Pos.CENTER_RIGHT);

            formButtons.getChildren().addAll(
                    cancelBtn,
                    saveBtn
            );

            // ================= ADD ALL TO POPUP =================

            addResidentBox.getChildren().addAll(
                    formTitle,

                    nameLabel,
                    residentName,

                    flatLabel,
                    flatNumber,

                    mobileLabel,
                    mobileNumber,

                    formButtons
            );

            // ================= CANCEL ACTION =================

            cancelBtn.setOnAction(event -> {
                addResidentStage.close();
            });

            // ================= SAVE ACTION =================

            saveBtn.setOnAction(event -> {

                String name = residentName.getText();
                String flat = flatNumber.getText();
                String mobile = mobileNumber.getText();

                if (name.isEmpty() ||
                        flat.isEmpty() ||
                        mobile.isEmpty()) {
                Label errorLabel = new Label(
                            "Please fill all details."
                    );

                    errorLabel.setStyle(
                            "-fx-text-fill:#D32F2F;" +
                            "-fx-font-size:13px;" +
                            "-fx-font-weight:bold;"
                    );

                    if (!addResidentBox.getChildren()
                            .contains(errorLabel)) {

                        addResidentBox.getChildren()
                                .add(1, errorLabel);
                    }

                    return;
                }

                // For now popup will close after save
                addResidentStage.close();
            });

            // ================= POPUP SCENE =================

            Scene addResidentScene = new Scene(
                    addResidentBox,
                    500,
                    430
            );

            addResidentStage.setScene(addResidentScene);

            // Small fixed window
            addResidentStage.setResizable(false);

            // Open popup
            addResidentStage.show();

        });

        // ================= SEARCH BOX =================

        HBox searchBox = new HBox(15);

        searchBox.setAlignment(Pos.CENTER_LEFT);

        searchBox.getChildren().addAll(
                search,
                addResidentBtn
        );

        // ================= RESIDENT 1 =================

        HBox resident1 = new HBox(5);

        resident1.setPrefWidth(1000);
        resident1.setMaxWidth(1000);
        resident1.setAlignment(Pos.CENTER_LEFT);
        resident1.setPrefHeight(70);
        resident1.setPadding(new Insets(20));

        resident1.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile1 = new Label("👤");

        profile1.setPrefWidth(50);
        profile1.setPrefHeight(50);
        profile1.setAlignment(Pos.CENTER);

        profile1.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name1 = new Label("Shravani");

        name1.setPrefWidth(220);

        name1.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat1 = new Label("Flat: B-402");

        flat1.setPrefWidth(150);

        flat1.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile1 = new Label("Mobile: 9876543210");

        mobile1.setPrefWidth(220);

        mobile1.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status1 = new Label("Active");

        status1.setPrefWidth(100);

        status1.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident1.getChildren().addAll(
                profile1,
                name1,
                flat1,
                mobile1,
                status1
        );

        // ================= RESIDENT 2 =================

        HBox resident2 = new HBox(5);

        resident2.setAlignment(Pos.CENTER_LEFT);
        resident2.setPrefWidth(1000);
        resident2.setMaxWidth(1000);
        resident2.setPrefHeight(70);
        resident2.setPadding(new Insets(20));

        resident2.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile2 = new Label("👤");

        profile2.setPrefWidth(50);
        profile2.setPrefHeight(50);
        profile2.setAlignment(Pos.CENTER);

        profile2.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name2 = new Label("Sudharshana");

        name2.setPrefWidth(200);

        name2.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat2 = new Label("Flat: B-402");

        flat2.setPrefWidth(150);

        flat2.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile2 = new Label("Mobile: 9876543210");

        mobile2.setPrefWidth(220);

        mobile2.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status2 = new Label("Active");

        status2.setPrefWidth(100);

        status2.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident2.getChildren().addAll(
                profile2,
                name2,
                flat2,
                mobile2,
                status2
        );

        // ================= RESIDENT 3 =================

        HBox resident3 = new HBox(5);

        resident3.setAlignment(Pos.CENTER_LEFT);
        resident3.setMaxWidth(1000);
        resident3.setPrefWidth(1000);
        resident3.setPrefHeight(70);
        resident3.setPadding(new Insets(20));

        resident3.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile3 = new Label("👤");

        profile3.setPrefWidth(50);
        profile3.setPrefHeight(50);
        profile3.setAlignment(Pos.CENTER);

        profile3.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name3 = new Label("Jiya");

        name3.setPrefWidth(200);

        name3.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat3 = new Label("Flat: B-402");

        flat3.setPrefWidth(150);

        flat3.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile3 = new Label("Mobile: 9876543210");

        mobile3.setPrefWidth(220);

        mobile3.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status3 = new Label("Active");

        status3.setPrefWidth(100);

        status3.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident3.getChildren().addAll(
                profile3,
                name3,
                flat3,
                mobile3,
                status3
        );

        // ================= RESIDENT 4 =================

        HBox resident4 = new HBox(5);

        resident4.setAlignment(Pos.CENTER_LEFT);
        resident4.setPrefWidth(1000);
        resident4.setMaxWidth(1000);
        resident4.setPrefHeight(70);
        resident4.setPadding(new Insets(20));

        resident4.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile4 = new Label("👤");

        profile4.setPrefWidth(50);
        profile4.setPrefHeight(50);
        profile4.setAlignment(Pos.CENTER);

        profile4.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name4 = new Label("Manasi");

        name4.setPrefWidth(200);

        name4.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat4 = new Label("Flat: B-402");

        flat4.setPrefWidth(150);

        flat4.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile4 = new Label("Mobile: 9876543210");

        mobile4.setPrefWidth(220);

        mobile4.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status4 = new Label("Inactive");

        status4.setPrefWidth(100);

        status4.setStyle(
                "-fx-text-fill:#D32F2F;" +
                "-fx-font-weight:bold;"
        );

        resident4.getChildren().addAll(
                profile4,
                name4,
                flat4,
                mobile4,
                status4
        );

        // ================= RESIDENT 5 =================

        HBox resident5 = new HBox(5);

        resident5.setAlignment(Pos.CENTER_LEFT);
        resident5.setMaxWidth(1000);
        resident5.setPrefWidth(1000);
        resident5.setPrefHeight(70);
        resident5.setPadding(new Insets(20));

        resident5.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;"
        );

        Label profile5 = new Label("👤");

        profile5.setPrefWidth(50);
        profile5.setPrefHeight(50);
        profile5.setAlignment(Pos.CENTER);

        profile5.setStyle(
                "-fx-background-color:#E5E7EB;" +
                "-fx-background-radius:50%;" +
                "-fx-font-size:22px;"
        );

        Label name5 = new Label("Dhanashree");

        name5.setPrefWidth(200);

        name5.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label flat5 = new Label("Flat: B-402");

        flat5.setPrefWidth(150);

        flat5.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#555555;"
        );

        Label mobile5 = new Label("Mobile: 9876543210");

        mobile5.setPrefWidth(220);

        mobile5.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#555555;"
        );

        Label status5 = new Label("Active");

        status5.setPrefWidth(100);

        status5.setStyle(
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        resident5.getChildren().addAll(
                profile5,
                name5,
                flat5,
                mobile5,
                status5
        );

        // ================= RESIDENT LIST =================

        VBox vb = new VBox(
                30,
                resident1,
                resident2,
                resident3,
                resident4,
                resident5
        );

        VBox.setMargin(
                resident1,
                new Insets(20, 0, 0, 0)
        );

        // ================= MAIN CONTENT =================

        mainvb.getChildren().addAll(
                title,
                subtitle,
                searchBox,
                vb
        );

        // ================= ROOT =================

        HBox root = new HBox();

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // ================= SCENE =================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        Resident = scene;

        return Resident;
    }
}
                    