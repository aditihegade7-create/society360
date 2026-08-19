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
import javafx.stage.Stage;

public class ManageGuard {

    private Scene guard;

    public Scene createScene(Stage stage) {

        // ================= SIDEBAR =================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // ================= MAIN =================

        VBox mainvb = new VBox(10);
        mainvb.setMaxWidth(Double.MAX_VALUE);
        mainvb.setPadding(new Insets(20));
        mainvb.setSpacing(10);
        mainvb.setStyle("-fx-background-color:#b3adad;");

        // ================= HEADER =================

        mainvb.setStyle("-fx-background-color: #e8ddd5;");
    
        //Title
        Label title = new Label("Manage Guards");
        title.setStyle(
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label("View and manage Security guards");
        subtitle.setStyle(
                "-fx-font-size:14px;" +
                "-fx-text-fill:#777777;"
        );

        VBox headingBox = new VBox(5);
        headingBox.getChildren().addAll(
                title,
                subtitle
        );

        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        header.getChildren().add(headingBox);

        // ================= SEARCH =================

        TextField search = new TextField();
        search.setPromptText("Search guard, phone...");
        search.setPrefHeight(45);
        search.setPrefWidth(750);
        search.setStyle("-fx-background-color:#F8F9FA;-fx-border-color: #E1E5E8;-fx-border-radius:8;-fx-background-radius:8;-fx-font-size:14px;");

        search.setStyle(
                "-fx-background-color:#F8F9FA;" +
                "-fx-border-color:#E1E5E8;" +
                "-fx-border-radius:8;" +
                "-fx-background-radius:8;" +
                "-fx-font-size:14px;"
        );

        // ================= ADD GUARD BUTTON =================

        Button addGuardBtn = new Button("+ Add New Guard");
        addGuardBtn.setPrefWidth(200);
        addGuardBtn.setPrefHeight(45);

        addGuardBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;"
        );

        HBox searchBox = new HBox(15);
        searchBox.setAlignment(Pos.CENTER_LEFT);
        searchBox.getChildren().addAll(
                search,
                addGuardBtn
        );

        // =====================================================
        // ADD NEW GUARD BUTTON CLICK
        // =====================================================

        addGuardBtn.setOnAction(e -> {

            VBox formBox = new VBox(15);

            formBox.setPadding(new Insets(25));
            formBox.setPrefWidth(450);

            formBox.setStyle(
                    "-fx-background-color:white;" +
                    "-fx-background-radius:12;"
            );

            // -------- FORM TITLE --------

            Label formTitle = new Label("Add New Guard");

            formTitle.setStyle(
                    "-fx-font-size:22px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-text-fill:#123C36;"
            );

            // -------- GUARD NAME --------

            TextField guardName = new TextField();
            guardName.setPromptText("Enter guard name");
            guardName.setPrefHeight(40);

            // -------- MOBILE NUMBER --------

            TextField mobileNumber = new TextField();
            mobileNumber.setPromptText("Enter mobile number");
            mobileNumber.setPrefHeight(40);

            // -------- SHIFT --------

            TextField shift = new TextField();
            shift.setPromptText("Enter shift");
            shift.setPrefHeight(40);

            // -------- SAVE BUTTON --------

            Button saveBtn = new Button("Save Guard");

            saveBtn.setPrefWidth(150);
            saveBtn.setPrefHeight(40);

            saveBtn.setStyle(
                    "-fx-background-color:#434141;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:7;"
            );

            // -------- CANCEL BUTTON --------

            Button cancelBtn = new Button("Cancel");

            cancelBtn.setPrefWidth(100);
            cancelBtn.setPrefHeight(40);

            // -------- FORM BUTTONS --------

            HBox formButtons = new HBox(10);

            formButtons.setAlignment(Pos.CENTER_LEFT);

            formButtons.getChildren().addAll(
                    saveBtn,
                    cancelBtn
            );

            // -------- ADD EVERYTHING TO FORM --------

            formBox.getChildren().addAll(
                    formTitle,
                    guardName,
                    mobileNumber,
                    shift,
                    formButtons
            );

            // -------- SMALL SCENE --------

            Scene formScene = new Scene(
                    formBox,
                    500,
                    350
            );

            Stage formStage = new Stage();

            formStage.setTitle("Add New Guard");
            formStage.setScene(formScene);

            formStage.show();

            // -------- CANCEL --------

            cancelBtn.setOnAction(event -> {
                formStage.close();
            });

            // -------- SAVE --------

            saveBtn.setOnAction(event -> {

                System.out.println("Guard Saved");

                formStage.close();
            });
        });

        // =====================================================
        // GUARD 1
        // =====================================================

        HBox guard1 = new HBox(5);

        guard1.setPrefWidth(1000);
        guard1.setMaxWidth(1000);
        guard1.setAlignment(Pos.CENTER_LEFT);
        guard1.setPrefHeight(70);
        guard1.setPadding(new Insets(20));

        guard1.setStyle(
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

        Label name1 = new Label("Rajesh Kumar");
        name1.setPrefWidth(220);

        name1.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label shift1 = new Label("Shift: Morning");
        shift1.setPrefWidth(180);

        shift1.setStyle(
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

        guard1.getChildren().addAll(
                profile1,
                name1,
                shift1,
                mobile1,
                status1
        );

        // =====================================================
        // GUARD 2
        // =====================================================

        HBox guard2 = new HBox(5);

        guard2.setAlignment(Pos.CENTER_LEFT);
        guard2.setPrefWidth(1000);
        guard2.setMaxWidth(1000);
        guard2.setPrefHeight(70);
        guard2.setPadding(new Insets(20));

        guard2.setStyle(
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

        Label name2 = new Label("Sunil Yadav");
        name2.setPrefWidth(200);

        name2.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label shift2 = new Label("Shift: Evening");
        shift2.setPrefWidth(180);

        shift2.setStyle(
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

        guard2.getChildren().addAll(
                profile2,
                name2,
                shift2,
                mobile2,
                status2
        );

        // =====================================================
        // GUARD 3
        // =====================================================

        HBox guard3 = new HBox(5);

        guard3.setAlignment(Pos.CENTER_LEFT);
        guard3.setMaxWidth(1000);
        guard3.setPrefWidth(1000);
        guard3.setPrefHeight(70);
        guard3.setPadding(new Insets(20));

        guard3.setStyle(
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

        Label name3 = new Label("Mahesh Jagtap");
        name3.setPrefWidth(200);

        name3.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label shift3 = new Label("Shift: Night");
        shift3.setPrefWidth(180);

        shift3.setStyle(
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

        guard3.getChildren().addAll(
                profile3,
                name3,
                shift3,
                mobile3,
                status3
        );

        // =====================================================
        // GUARD 4
        // =====================================================

        HBox guard4 = new HBox(5);

        guard4.setAlignment(Pos.CENTER_LEFT);
        guard4.setPrefWidth(1000);
        guard4.setMaxWidth(1000);
        guard4.setPrefHeight(70);
        guard4.setPadding(new Insets(20));

        guard4.setStyle(
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

        Label name4 = new Label("Ramesh More");
        name4.setPrefWidth(200);

        name4.setStyle(
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label shift4 = new Label("Shift: Night");
        shift4.setPrefWidth(180);

        shift4.setStyle(
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
                "-fx-text-fill:#2E9D63;" +
                "-fx-font-weight:bold;"
        );

        guard4.getChildren().addAll(
                profile4,
                name4,
                shift4,
                mobile4,
                status4
        );

        // =====================================================
        // GUARDS VBOX
        // =====================================================

        VBox vb = new VBox(
                40,
                guard1,
                guard2,
                guard3,
                guard4
        );

        VBox.setMargin(
                guard1,
                new Insets(20, 0, 0, 0)
        );

        // =====================================================
        // ADD TO MAIN
        // =====================================================

        mainvb.getChildren().addAll(
                header,
                searchBox,
                vb
        );

        // =====================================================
        // ROOT
        // =====================================================

        HBox root = new HBox();

        root.getChildren().addAll(
                sidebar,
                mainvb
        );

        HBox.setHgrow(
                mainvb,
                Priority.ALWAYS
        );

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        guard = scene;

        return guard;
    }
}