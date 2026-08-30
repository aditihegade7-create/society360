
package com.society.view.Secretary_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.society.controller.Secretary_Controller.MaintenanceController;
import com.society.controller.welcome.UserController;
import com.society.model.Secretary_model.Maintenance;
import com.society.model.Welcome.User;
import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageMaintenance {

        // =========================================================
        // SCENE
        // =========================================================
        User user = new User();
        private Scene manageMaintenanceScene;

        // =========================================================
        // ROOT STACKPANE
        // =========================================================

        private StackPane rootStack;

        // =========================================================
        // CONTROLLER
        // =========================================================

        private MaintenanceController maintenanceController;

        // =========================================================
        // MAINTENANCE LIST
        // =========================================================

        private VBox maintenanceList;

        // =========================================================
        // CREATE SCENE
        // =========================================================

        public Scene createScene(Stage stage) {

                // =====================================================
                // CONTROLLER
                // =====================================================

                maintenanceController = new MaintenanceController();

                // =====================================================
                // SIDEBAR
                // =====================================================

                SecretarySidebar sidebarObj = new SecretarySidebar();

                VBox sidebar = sidebarObj.createSidebar(stage);

                // =====================================================
                // MAIN CONTENT
                // =====================================================

                VBox mainvb = new VBox(20);

                mainvb.setPadding(
                                new Insets(25));

                mainvb.setPrefWidth(1220);

                mainvb.setMaxWidth(
                                Double.MAX_VALUE);

                mainvb.setMaxHeight(
                                Double.MAX_VALUE);

                mainvb.setStyle(
                                "-fx-background-color:#b3adad;");

                // =====================================================
                // HEADING
                // =====================================================

                Label heading = new Label("MANAGE MAINTENANCE");

                heading.setStyle(
                                "-fx-font-size:18px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#434141;");

                // =====================================================
                // TITLE
                // =====================================================

                Label title = new Label("Manage Maintenance");

                title.setStyle(
                                "-fx-font-size:20px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:black;");

                // =====================================================
                // SUBTITLE
                // =====================================================

                Label subtitle = new Label(
                                "View and manage society maintenance records");

                subtitle.setStyle(
                                "-fx-font-size:13px;" +
                                                "-fx-text-fill:#777777;");

                VBox titleBox = new VBox(5);

                titleBox.getChildren().addAll(
                                title,
                                subtitle);

                // =====================================================
                // ADD MAINTENANCE BUTTON
                // =====================================================

                Button addMaintenanceBtn = new Button("+ Add Maintenance");

                addMaintenanceBtn.setPrefWidth(160);
                addMaintenanceBtn.setPrefHeight(40);

                addMaintenanceBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:7;" +
                                                "-fx-cursor:hand;");

                addMaintenanceBtn.setOnAction(
                                e -> openAddMaintenanceDialog());

                // =====================================================
                // HEADER
                // =====================================================

                HBox maintenanceHeader = new HBox();

                maintenanceHeader.setAlignment(
                                Pos.CENTER_LEFT);

                HBox.setHgrow(
                                titleBox,
                                Priority.ALWAYS);

                maintenanceHeader.getChildren().addAll(
                                titleBox,
                                addMaintenanceBtn);

                // =====================================================
                // STATUS BUTTONS
                // =====================================================

                Button pendingBtn = new Button("Pending");

                Button paidBtn = new Button("Paid");

                Button overdueBtn = new Button("Overdue");

                pendingBtn.setPrefWidth(150);
                pendingBtn.setPrefHeight(40);

                paidBtn.setPrefWidth(150);
                paidBtn.setPrefHeight(40);

                overdueBtn.setPrefWidth(150);
                overdueBtn.setPrefHeight(40);

                // =====================================================
                // STYLES
                // =====================================================

                String normalStyle = "-fx-background-color:transparent;" +
                                "-fx-text-fill:#777777;" +
                                "-fx-font-weight:bold;" +
                                "-fx-font-size:12px;" +
                                "-fx-cursor:hand;";

                String activeStyle = "-fx-background-color:transparent;" +
                                "-fx-text-fill:#123C36;" +
                                "-fx-font-weight:bold;" +
                                "-fx-font-size:12px;" +
                                "-fx-border-color:#0B4F4A;" +
                                "-fx-border-width:0 0 2 0;" +
                                "-fx-cursor:hand;";

                pendingBtn.setStyle(activeStyle);
                paidBtn.setStyle(normalStyle);
                overdueBtn.setStyle(normalStyle);

                // =====================================================
                // TABS
                // =====================================================

                HBox tabs = new HBox(25);

                tabs.setAlignment(
                                Pos.CENTER_LEFT);

                tabs.getChildren().addAll(
                                pendingBtn,
                                paidBtn,
                                overdueBtn);

                // =====================================================
                // MAINTENANCE LIST
                // =====================================================

                maintenanceList = new VBox(15);

                maintenanceList.setPadding(
                                new Insets(5, 0, 5, 0));

                // =====================================================
                // SCROLL PANE
                // =====================================================

                ScrollPane scrollPane = new ScrollPane();

                scrollPane.setContent(
                                maintenanceList);

                scrollPane.setFitToWidth(true);

                scrollPane.setPrefHeight(450);

                scrollPane.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-border-color:transparent;");

                // =====================================================
                // DEFAULT = PENDING
                // =====================================================

                loadMaintenanceByStatus(
                                "Pending");

                // =====================================================
                // PENDING BUTTON
                // =====================================================

                pendingBtn.setOnAction(
                                e -> {

                                        loadMaintenanceByStatus(
                                                        "Pending");

                                        pendingBtn.setStyle(
                                                        activeStyle);

                                        paidBtn.setStyle(
                                                        normalStyle);

                                        overdueBtn.setStyle(
                                                        normalStyle);
                                });

                // =====================================================
                // PAID BUTTON
                // =====================================================

                paidBtn.setOnAction(
                                e -> {

                                        loadMaintenanceByStatus(
                                                        "Paid");

                                        pendingBtn.setStyle(
                                                        normalStyle);

                                        paidBtn.setStyle(
                                                        activeStyle);

                                        overdueBtn.setStyle(
                                                        normalStyle);
                                });

                // =====================================================
                // OVERDUE BUTTON
                // =====================================================

                overdueBtn.setOnAction(
                                e -> {

                                        loadMaintenanceByStatus(
                                                        "Overdue");

                                        pendingBtn.setStyle(
                                                        normalStyle);

                                        paidBtn.setStyle(
                                                        normalStyle);

                                        overdueBtn.setStyle(
                                                        activeStyle);
                                });

                // =====================================================
                // VIEW ALL
                // =====================================================

                Button viewAllBtn = new Button(
                                "View All Maintenance");

                viewAllBtn.setPrefWidth(1180);
                viewAllBtn.setPrefHeight(40);

                viewAllBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:7;" +
                                                "-fx-border-color:#EEEEEE;" +
                                                "-fx-border-radius:7;" +
                                                "-fx-cursor:hand;");

                viewAllBtn.setOnAction(
                                e -> openViewAllMaintenanceDialog());

                // =====================================================
                // MAIN CONTENT
                // =====================================================

                mainvb.getChildren().addAll(
                                heading,
                                maintenanceHeader,
                                tabs,
                                scrollPane,
                                viewAllBtn);

                // =====================================================
                // MAIN ROOT
                // =====================================================

                HBox mainRoot = new HBox();

                mainRoot.setMaxSize(
                                Double.MAX_VALUE,
                                Double.MAX_VALUE);

                mainRoot.getChildren().addAll(
                                sidebar,
                                mainvb);

                mainRoot.setStyle(
                                "-fx-background-color:#434141;");

                HBox.setHgrow(
                                mainvb,
                                Priority.ALWAYS);

                // =====================================================
                // STACKPANE
                // =====================================================

                rootStack = new StackPane();

                rootStack.setMaxSize(
                                Double.MAX_VALUE,
                                Double.MAX_VALUE);

                rootStack.getChildren().add(
                                mainRoot);

                // =====================================================
                // SCENE
                // =====================================================

                Scene scene = new Scene(
                                rootStack,
                                ScreenSize.getWidth(),
                                ScreenSize.getHeight());

                manageMaintenanceScene = scene;

                return manageMaintenanceScene;
        }

        // =========================================================
        // LOAD MAINTENANCE FROM FIRESTORE
        // =========================================================

        private void loadMaintenanceByStatus(
                        String requiredStatus) {

                maintenanceList.getChildren().clear();

                List<Maintenance> data = maintenanceController
                                .getAllMaintenance();

                boolean found = false;

                if (data != null) {

                        for (Maintenance maintenance : data) {

                                String status = maintenance.getStatus();

                                if (status != null &&
                                                status.equalsIgnoreCase(
                                                                requiredStatus)) {

                                        VBox card = createMaintenance(
                                                        maintenance.getResidentName(),
                                                        maintenance.getFlatNo(),
                                                        maintenance.getAmount(),
                                                        maintenance.getMonth(),
                                                        maintenance.getDate(),
                                                        maintenance.getStatus());

                                        maintenanceList
                                                        .getChildren()
                                                        .add(card);

                                        found = true;
                                }
                        }
                }

                if (!found) {

                        Label emptyLabel = new Label(
                                        "No "
                                                        + requiredStatus
                                                        + " maintenance records found.");

                        emptyLabel.setStyle(
                                        "-fx-font-size:16px;" +
                                                        "-fx-text-fill:#555555;");

                        maintenanceList
                                        .getChildren()
                                        .add(emptyLabel);
                }
        }

        // =========================================================
        // ADD MAINTENANCE POPUP
        // =========================================================

        private void openAddMaintenanceDialog() {

                StackPane overlay = new StackPane();

                overlay.setStyle(
                                "-fx-background-color:rgba(0,0,0,0.5);");

                // =====================================================
                // FORM BOX
                // =====================================================

                VBox formBox = new VBox(12);

                formBox.setPadding(
                                new Insets(25));

                formBox.setMaxWidth(500);

                formBox.setMaxHeight(650);

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

                // =====================================================
                // HEADER
                // =====================================================

                HBox headerRow = new HBox();

                headerRow.setAlignment(
                                Pos.CENTER_LEFT);

                Label popupTitle = new Label(
                                "Add Maintenance");

                popupTitle.setStyle(
                                "-fx-font-size:22px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#123C36;");

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Button closeBtn = new Button("✕");

                closeBtn.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-text-fill:#555555;" +
                                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-cursor:hand;");

                closeBtn.setOnAction(
                                e -> removeOverlay(overlay));

                headerRow.getChildren().addAll(
                                popupTitle,
                                spacer,
                                closeBtn);

                // =====================================================
                // RESIDENT NAME
                // =====================================================

                Label nameLabel = new Label(
                                "Resident Name");

                TextField nameField = new TextField();

                nameField.setPromptText(
                                "Enter resident name");

                nameField.setPrefHeight(40);

                // =====================================================
                // FLAT NUMBER
                // =====================================================

                Label flatLabel = new Label(
                                "Flat Number");

                TextField flatField = new TextField();

                flatField.setPromptText(
                                "Enter flat number");

                flatField.setPrefHeight(40);

                // =====================================================
                // AMOUNT
                // =====================================================

                Label amountLabel = new Label(
                                "Amount");

                TextField amountField = new TextField();

                amountField.setPromptText(
                                "Enter maintenance amount");

                amountField.setPrefHeight(40);

                // =====================================================
                // MONTH
                // =====================================================

                Label monthLabel = new Label(
                                "Month");

                TextField monthField = new TextField();

                monthField.setPromptText(
                                "Select month from calendar");

                monthField.setPrefHeight(40);

                monthField.setEditable(false);

                // =====================================================
                // CALENDAR
                // =====================================================

                DatePicker monthPicker = new DatePicker();

                monthPicker.setPrefHeight(40);

                monthPicker.setPrefWidth(150);

                monthPicker.setPromptText(
                                "Calendar");

                // =====================================================
                // DATE FORMAT
                // =====================================================

                DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern(
                                "MMMM yyyy");

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy");

                // =====================================================
                // CALENDAR ACTION
                // =====================================================

                monthPicker.setOnAction(
                                e -> {

                                        LocalDate selectedDate = monthPicker.getValue();

                                        if (selectedDate != null) {

                                                // Month field
                                                monthField.setText(
                                                                selectedDate.format(
                                                                                monthFormatter));
                                        }
                                });

                // =====================================================
                // MONTH BOX
                // =====================================================

                HBox monthBox = new HBox(8);

                HBox.setHgrow(
                                monthField,
                                Priority.ALWAYS);

                monthBox.getChildren().addAll(
                                monthField,
                                monthPicker);

                // =====================================================
                // STATUS
                // =====================================================

                Label statusLabel = new Label(
                                "Status");

                ComboBox<String> statusComboBox = new ComboBox<>();

                statusComboBox.getItems().addAll(
                                "Pending",
                                "Paid",
                                "Overdue");

                statusComboBox.setValue(
                                "Pending");

                statusComboBox.setPrefHeight(40);

                statusComboBox.setMaxWidth(
                                Double.MAX_VALUE);

                // =====================================================
                // BUTTONS
                // =====================================================

                Button cancelBtn = new Button(
                                "Cancel");

                cancelBtn.setPrefWidth(100);

                cancelBtn.setPrefHeight(40);

                cancelBtn.setStyle(
                                "-fx-background-color:#E5E7EB;" +
                                                "-fx-text-fill:#333333;" +
                                                "-fx-background-radius:8;" +
                                                "-fx-cursor:hand;");

                Button saveBtn = new Button(
                                "Save");

                saveBtn.setPrefWidth(120);

                saveBtn.setPrefHeight(40);

                saveBtn.setStyle(
                                "-fx-background-color:#2E9D63;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:8;" +
                                                "-fx-cursor:hand;");

                HBox buttonBox = new HBox(10);

                buttonBox.setAlignment(
                                Pos.CENTER_RIGHT);

                buttonBox.getChildren().addAll(
                                cancelBtn,
                                saveBtn);

                // =====================================================
                // FORM
                // =====================================================

                formBox.getChildren().addAll(

                                headerRow,

                                nameLabel,
                                nameField,

                                flatLabel,
                                flatField,

                                amountLabel,
                                amountField,

                                monthLabel,
                                monthBox,

                                statusLabel,
                                statusComboBox,

                                buttonBox);

                // =====================================================
                // CANCEL
                // =====================================================

                cancelBtn.setOnAction(
                                e -> removeOverlay(overlay));

                // =====================================================
                // SAVE
                // =====================================================

                saveBtn.setOnAction(
                                e -> {

                                        // =========================================
                                        // GET VALUES
                                        // =========================================

                                        String residentName = nameField.getText()
                                                        .trim();

                                        String flatNo = flatField.getText()
                                                        .trim();

                                        String amount = amountField.getText()
                                                        .trim();

                                        String month = monthField.getText()
                                                        .trim();

                                        String status = statusComboBox.getValue();

                                        LocalDate selectedDate = monthPicker.getValue();

                                        // =========================================
                                        // DATE
                                        // =========================================

                                        String date = "";

                                        if (selectedDate != null) {

                                                date = selectedDate.format(
                                                                dateFormatter);
                                        }

                                        // =========================================
                                        // VALIDATION
                                        // =========================================

                                        if (residentName.isEmpty()) {

                                                showMessage(
                                                                "Please enter resident name.");

                                                return;
                                        }

                                        if (flatNo.isEmpty()) {

                                                showMessage(
                                                                "Please enter flat number.");

                                                return;
                                        }

                                        if (amount.isEmpty()) {

                                                showMessage(
                                                                "Please enter maintenance amount.");

                                                return;
                                        }

                                        if (selectedDate == null) {

                                                showMessage(
                                                                "Please select a date from calendar.");

                                                return;
                                        }

                                        if (month.isEmpty()) {

                                                showMessage(
                                                                "Please select month.");

                                                return;
                                        }

                                        if (status == null ||
                                                        status.isEmpty()) {

                                                showMessage(
                                                                "Please select status.");

                                                return;
                                        }

                                        // =========================================
                                        // SAVE TO FIRESTORE
                                        // =========================================

                                        UserController userController = new UserController();

                                        // Find resident using Flat Number
                                        User resident = userController.getResidentByFlatNo(
                                                        flatNo);

                                        if (resident == null) {

                                                showMessage(
                                                                "No resident found for Flat No: "
                                                                                + flatNo);

                                                return;
                                        }

                                        // Get signup email of that resident
                                        String residentEmail = resident.getEmail();

                                        if (residentEmail == null ||
                                                        residentEmail.trim().isEmpty()) {

                                                showMessage(
                                                                "Email not found for this resident.");

                                                return;
                                        }

                                        System.out.println(
                                                        "Resident Name = "
                                                                        + resident.getName());

                                        System.out.println(
                                                        "Resident Flat No = "
                                                                        + flatNo);

                                        System.out.println(
                                                        "Resident Signup Email = "
                                                                        + residentEmail);
                                        

                                        if (!"Resident".equalsIgnoreCase(
                                                        resident.getRole())) {

                                                System.out.println(
                                                                "This email does not belong to a Resident.");

                                                return;
                                        }

                                        boolean success = maintenanceController.addMaintenance(
                                                        resident.getEmail(),
                                                        residentName,
                                                        flatNo,
                                                        amount,
                                                        month,
                                                        date,
                                                        status);

                                        // =========================================
                                        // SUCCESS
                                        // =========================================

                                        if (success) {

                                                System.out.println(
                                                                "Maintenance added successfully!");

                                                removeOverlay(
                                                                overlay);

                                                // Refresh selected status
                                                loadMaintenanceByStatus(
                                                                status);

                                        } else {

                                                showMessage(
                                                                "Failed to save maintenance.");
                                        }
                                });

                // =====================================================
                // ADD OVERLAY
                // =====================================================

                overlay.getChildren().add(
                                formBox);

                StackPane.setAlignment(
                                formBox,
                                Pos.CENTER);

                rootStack.getChildren().add(
                                overlay);
        }

        // =========================================================
        // VIEW ALL MAINTENANCE
        // =========================================================

        private void openViewAllMaintenanceDialog() {

                StackPane overlay = new StackPane();

                overlay.setStyle(
                                "-fx-background-color:rgba(0,0,0,0.5);");

                VBox popup = new VBox(15);

                popup.setPadding(
                                new Insets(25));

                popup.setMaxWidth(650);

                popup.setMaxHeight(550);

                popup.setStyle("""
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

                // =====================================================
                // HEADER
                // =====================================================

                HBox headerRow = new HBox();

                headerRow.setAlignment(
                                Pos.CENTER_LEFT);

                Label popupTitle = new Label(
                                "All Maintenance");

                popupTitle.setStyle(
                                "-fx-font-size:22px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#123C36;");

                Region spacer = new Region();

                HBox.setHgrow(
                                spacer,
                                Priority.ALWAYS);

                Button closeTopBtn = new Button("✕");

                closeTopBtn.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-text-fill:#555555;" +
                                                "-fx-font-size:16px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-cursor:hand;");

                closeTopBtn.setOnAction(
                                e -> removeOverlay(overlay));

                headerRow.getChildren().addAll(
                                popupTitle,
                                spacer,
                                closeTopBtn);

                // =====================================================
                // DATA
                // =====================================================

                VBox allMaintenance = new VBox(12);

                allMaintenance.setPadding(
                                new Insets(5));

                List<Maintenance> data = maintenanceController
                                .getAllMaintenance();

                if (data != null &&
                                !data.isEmpty()) {

                        for (Maintenance maintenance : data) {

                                VBox card = createMaintenance(
                                                maintenance.getResidentName(),
                                                maintenance.getFlatNo(),
                                                maintenance.getAmount(),
                                                maintenance.getMonth(),
                                                maintenance.getDate(),
                                                maintenance.getStatus());

                                allMaintenance
                                                .getChildren()
                                                .add(card);
                        }

                } else {

                        Label noData = new Label(
                                        "No maintenance records found.");

                        noData.setStyle(
                                        "-fx-font-size:15px;" +
                                                        "-fx-text-fill:#555555;");

                        allMaintenance
                                        .getChildren()
                                        .add(noData);
                }

                // =====================================================
                // SCROLL
                // =====================================================

                ScrollPane popupScroll = new ScrollPane();

                popupScroll.setContent(
                                allMaintenance);

                popupScroll.setFitToWidth(true);

                popupScroll.setPrefHeight(400);

                popupScroll.setStyle(
                                "-fx-background-color:transparent;" +
                                                "-fx-border-color:transparent;");

                // =====================================================
                // CLOSE
                // =====================================================

                Button closeBtn = new Button("Close");

                closeBtn.setPrefWidth(100);

                closeBtn.setPrefHeight(40);

                closeBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-background-radius:8;" +
                                                "-fx-cursor:hand;");

                closeBtn.setOnAction(
                                e -> removeOverlay(overlay));

                HBox buttonBox = new HBox(closeBtn);

                buttonBox.setAlignment(
                                Pos.CENTER_RIGHT);

                // =====================================================
                // POPUP CONTENT
                // =====================================================

                popup.getChildren().addAll(
                                headerRow,
                                popupScroll,
                                buttonBox);

                overlay.getChildren().add(
                                popup);

                StackPane.setAlignment(
                                popup,
                                Pos.CENTER);

                rootStack.getChildren().add(
                                overlay);
        }

        // =========================================================
        // REMOVE OVERLAY
        // =========================================================

        private void removeOverlay(
                        StackPane overlay) {

                rootStack.getChildren().remove(
                                overlay);
        }

        // =========================================================
        // MAINTENANCE CARD
        // =========================================================

        private VBox createMaintenance(
                        String residentName,
                        String flatNo,
                        String amount,
                        String month,
                        String date,
                        String statusText) {

                VBox maintenance = new VBox(10);

                maintenance.setPadding(
                                new Insets(18));

                maintenance.setPrefHeight(100);

                maintenance.setMaxWidth(1180);

                maintenance.setStyle(
                                "-fx-background-color:white;" +
                                                "-fx-background-radius:10;" +
                                                "-fx-border-color:#EEEEEE;" +
                                                "-fx-border-radius:10;");

                // =====================================================
                // NAME
                // =====================================================

                Label name = new Label(
                                residentName);

                name.setStyle(
                                "-fx-font-size:14px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-text-fill:#123C36;");

                // =====================================================
                // DETAILS
                // =====================================================

                Label details = new Label(
                                "Flat: "
                                                + flatNo
                                                + "    |    Amount: "
                                                + amount
                                                + "    |    "
                                                + month
                                                + "    |    Date: "
                                                + date);

                details.setStyle(
                                "-fx-font-size:11px;" +
                                                "-fx-text-fill:#777777;");

                // =====================================================
                // STATUS COLORS
                // =====================================================

                String statusBackground = "#FFF0D9";

                String statusColor = "#C47A20";

                if (statusText != null &&
                                statusText.equalsIgnoreCase(
                                                "Paid")) {

                        statusBackground = "#E5F7EC";

                        statusColor = "#2E9D63";

                } else if (statusText != null &&
                                statusText.equalsIgnoreCase(
                                                "Overdue")) {

                        statusBackground = "#FDE8E8";

                        statusColor = "#D9534F";
                }

                // =====================================================
                // STATUS
                // =====================================================

                Label status = new Label(
                                statusText == null
                                                ? ""
                                                : statusText);

                status.setStyle(
                                "-fx-background-color:"
                                                + statusBackground
                                                + ";" +
                                                "-fx-text-fill:"
                                                + statusColor
                                                + ";" +
                                                "-fx-font-size:10px;" +
                                                "-fx-font-weight:bold;" +
                                                "-fx-padding:5px 10px;" +
                                                "-fx-background-radius:12;");

                // =====================================================
                // BOTTOM
                // =====================================================

                HBox bottom = new HBox();

                bottom.setAlignment(
                                Pos.CENTER_LEFT);

                HBox.setHgrow(
                                details,
                                Priority.ALWAYS);

                bottom.getChildren().addAll(
                                details,
                                status);

                // =====================================================
                // ADD
                // =====================================================

                maintenance.getChildren().addAll(
                                name,
                                bottom);

                return maintenance;
        }

        // =========================================================
        // MESSAGE
        // =========================================================

        private void showMessage(
                        String message) {

                StackPane messageOverlay = new StackPane();

                messageOverlay.setStyle(
                                "-fx-background-color:rgba(0,0,0,0.35);");

                VBox box = new VBox(15);

                box.setPadding(
                                new Insets(25));

                box.setAlignment(
                                Pos.CENTER);

                box.setMaxWidth(350);

                box.setStyle(
                                "-fx-background-color:white;" +
                                                "-fx-background-radius:15;");

                Label messageLabel = new Label(
                                message);

                messageLabel.setWrapText(true);

                messageLabel.setStyle(
                                "-fx-font-size:14px;" +
                                                "-fx-text-fill:#333333;");

                Button okBtn = new Button("OK");

                okBtn.setPrefWidth(80);

                okBtn.setPrefHeight(35);

                okBtn.setStyle(
                                "-fx-background-color:#434141;" +
                                                "-fx-text-fill:white;" +
                                                "-fx-background-radius:7;" +
                                                "-fx-cursor:hand;");

                okBtn.setOnAction(
                                e -> rootStack
                                                .getChildren()
                                                .remove(
                                                                messageOverlay));

                box.getChildren().addAll(
                                messageLabel,
                                okBtn);

                messageOverlay.getChildren().add(
                                box);

                StackPane.setAlignment(
                                box,
                                Pos.CENTER);

                rootStack.getChildren().add(
                                messageOverlay);
        }
}
