package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private Scene manageMaintenanceScene;

    // Main StackPane
    // Popup isi ke upar open hoga
    private StackPane rootStack;

    public Scene createScene(Stage stage) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        VBox mainvb = new VBox(20);

        mainvb.setPadding(new Insets(25));
        mainvb.setPrefWidth(1220);

        mainvb.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading = new Label("MANAGE MAINTENANCE");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label("Manage Maintenance");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        Label subtitle = new Label(
                "View and manage society maintenance records"
        );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#777777;"
        );

        VBox titleBox = new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // =====================================================
        // ADD MAINTENANCE BUTTON
        // =====================================================

        Button addMaintenanceBtn =
                new Button("+ Add Maintenance");

        addMaintenanceBtn.setPrefWidth(160);
        addMaintenanceBtn.setPrefHeight(40);

        addMaintenanceBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-cursor:hand;"
        );

        // IMPORTANT
        // New Stage nahi banega
        addMaintenanceBtn.setOnAction(
                e -> openAddMaintenanceDialog()
        );

        // =====================================================
        // HEADER
        // =====================================================

        HBox maintenanceHeader = new HBox();

        maintenanceHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        maintenanceHeader.getChildren().addAll(
                titleBox,
                addMaintenanceBtn
        );

        // =====================================================
        // STATUS BUTTONS
        // =====================================================

        Button pendingBtn =
                new Button("Pending (8)");

        Button paidBtn =
                new Button("Paid (32)");

        Button overdueBtn =
                new Button("Overdue (5)");

        pendingBtn.setPrefWidth(150);
        pendingBtn.setPrefHeight(40);

        paidBtn.setPrefWidth(150);
        paidBtn.setPrefHeight(40);

        overdueBtn.setPrefWidth(150);
        overdueBtn.setPrefHeight(40);

        // =====================================================
        // BUTTON STYLES
        // =====================================================

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#777777;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;";

        String activeStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#123C36;" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-width:0 0 2 0;";

        pendingBtn.setStyle(activeStyle);
        paidBtn.setStyle(normalStyle);
        overdueBtn.setStyle(normalStyle);

        // =====================================================
        // TABS
        // =====================================================

        HBox tabs = new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                pendingBtn,
                paidBtn,
                overdueBtn
        );

        // =====================================================
        // MAINTENANCE LIST
        // =====================================================

        VBox maintenanceList = new VBox(15);

        maintenanceList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        // =====================================================
        // PENDING
        // =====================================================

        VBox pending1 = createMaintenance(
                "Diya Wadhwa",
                "B-402",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending2 = createMaintenance(
                "Rahul Sharma",
                "A-101",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending3 = createMaintenance(
                "Neha Patil",
                "C-203",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending4 = createMaintenance(
                "Amit Kulkarni",
                "B-305",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending5 = createMaintenance(
                "Pooja Singh",
                "A-503",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending6 = createMaintenance(
                "Rohan Joshi",
                "C-102",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending7 = createMaintenance(
                "Sneha Patil",
                "A-204",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        VBox pending8 = createMaintenance(
                "Kunal Shah",
                "B-201",
                "₹2500",
                "May 2025",
                "Pending",
                "#FFF0D9",
                "#C47A20"
        );

        // =====================================================
        // PAID
        // =====================================================

        VBox paid1 = createMaintenance(
                "Aarav Mehta",
                "A-201",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid2 = createMaintenance(
                "Priya Sharma",
                "B-102",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid3 = createMaintenance(
                "Vivek Patil",
                "C-301",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid4 = createMaintenance(
                "Anjali Joshi",
                "A-402",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid5 = createMaintenance(
                "Riya Singh",
                "B-203",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        VBox paid6 = createMaintenance(
                "Sahil More",
                "C-104",
                "₹2500",
                "May 2025",
                "Paid",
                "#E5F7EC",
                "#2E9D63"
        );

        // =====================================================
        // OVERDUE
        // =====================================================

        VBox overdue1 = createMaintenance(
                "Vikram Deshmukh",
                "A-305",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue2 = createMaintenance(
                "Meena Shah",
                "B-404",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue3 = createMaintenance(
                "Akash Patil",
                "C-202",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue4 = createMaintenance(
                "Nisha Kulkarni",
                "A-103",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        VBox overdue5 = createMaintenance(
                "Rohit Sharma",
                "B-302",
                "₹5000",
                "April 2025",
                "Overdue",
                "#FDE8E8",
                "#D9534F"
        );

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(
                maintenanceList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(450);

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =====================================================
        // SHOW PENDING BY DEFAULT
        // =====================================================

        maintenanceList.getChildren().addAll(
                pending1,
                pending2,
                pending3,
                pending4,
                pending5,
                pending6,
                pending7,
                pending8
        );

        // =====================================================
        // PENDING BUTTON
        // =====================================================

        pendingBtn.setOnAction(e -> {

            maintenanceList.getChildren().clear();

            maintenanceList.getChildren().addAll(
                    pending1,
                    pending2,
                    pending3,
                    pending4,
                    pending5,
                    pending6,
                    pending7,
                    pending8
            );

            pendingBtn.setStyle(activeStyle);
            paidBtn.setStyle(normalStyle);
            overdueBtn.setStyle(normalStyle);
        });

        // =====================================================
        // PAID BUTTON
        // =====================================================

        paidBtn.setOnAction(e -> {

            maintenanceList.getChildren().clear();

            maintenanceList.getChildren().addAll(
                    paid1,
                    paid2,
                    paid3,
                    paid4,
                    paid5,
                    paid6
            );

            pendingBtn.setStyle(normalStyle);
            paidBtn.setStyle(activeStyle);
            overdueBtn.setStyle(normalStyle);
        });

        // =====================================================
        // OVERDUE BUTTON
        // =====================================================

        overdueBtn.setOnAction(e -> {

            maintenanceList.getChildren().clear();

            maintenanceList.getChildren().addAll(
                    overdue1,
                    overdue2,
                    overdue3,
                    overdue4,
                    overdue5
            );

            pendingBtn.setStyle(normalStyle);
            paidBtn.setStyle(normalStyle);
            overdueBtn.setStyle(activeStyle);
        });

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn =
                new Button("View All Maintenance");

        viewAllBtn.setPrefWidth(1180);
        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;" +
                "-fx-cursor:hand;"
        );

        // IMPORTANT
        // New Stage nahi banega
        viewAllBtn.setOnAction(
                e -> openViewAllMaintenanceDialog()
        );

        // =====================================================
        // MAIN CONTENT
        // =====================================================

        mainvb.getChildren().addAll(
                heading,
                maintenanceHeader,
                tabs,
                scrollPane,
                viewAllBtn
        );

        // =====================================================
        // MAIN ROOT
        // =====================================================

        HBox mainRoot = new HBox();

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

        // =====================================================
        // STACKPANE
        // =====================================================

        rootStack = new StackPane();

        rootStack.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        rootStack.getChildren().add(
                mainRoot
        );

        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                rootStack,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageMaintenanceScene = scene;

        return manageMaintenanceScene;
    }


    // =========================================================
    // ADD MAINTENANCE POPUP
    // =========================================================

    private void openAddMaintenanceDialog() {

        // DARK OVERLAY

        StackPane overlay = new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );

        // SMALL POPUP

        VBox formBox = new VBox(15);

        formBox.setPadding(
                new Insets(30)
        );

        formBox.setMaxWidth(450);
        formBox.setMaxHeight(500);

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
                Pos.CENTER_LEFT
        );

        Label popupTitle =
                new Label("Add Maintenance");

        popupTitle.setStyle(
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Region spacer = new Region();

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

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeBtn
        );

        // =====================================================
        // RESIDENT NAME
        // =====================================================

        Label nameLabel =
                new Label("Resident Name");

        TextField nameField =
                new TextField();

        nameField.setPromptText(
                "Enter resident name"
        );

        nameField.setPrefHeight(40);

        // =====================================================
        // FLAT NUMBER
        // =====================================================

        Label flatLabel =
                new Label("Flat Number");

        TextField flatField =
                new TextField();

        flatField.setPromptText(
                "Enter flat number"
        );

        flatField.setPrefHeight(40);

        // =====================================================
        // AMOUNT
        // =====================================================

        Label amountLabel =
                new Label("Amount");

        TextField amountField =
                new TextField();

        amountField.setPromptText(
                "Enter maintenance amount"
        );

        amountField.setPrefHeight(40);

        // =====================================================
        // MONTH
        // =====================================================

        Label monthLabel =
                new Label("Month");

        TextField monthField =
                new TextField();

        monthField.setPromptText(
                "Enter month"
        );

        monthField.setPrefHeight(40);

        // =====================================================
        // BUTTONS
        // =====================================================

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

        Button saveBtn =
                new Button("Save");

        saveBtn.setPrefWidth(120);
        saveBtn.setPrefHeight(40);

        saveBtn.setStyle(
                "-fx-background-color:#2E9D63;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        HBox buttonBox =
                new HBox(10);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        buttonBox.getChildren().addAll(
                cancelBtn,
                saveBtn
        );

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
                monthField,

                buttonBox
        );

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        cancelBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        saveBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        // =====================================================
        // ADD POPUP TO EXISTING SCREEN
        // =====================================================

        overlay.getChildren().add(
                formBox
        );

        StackPane.setAlignment(
                formBox,
                Pos.CENTER
        );

        rootStack.getChildren().add(
                overlay
        );
    }


    // =========================================================
    // VIEW ALL MAINTENANCE POPUP
    // =========================================================

    private void openViewAllMaintenanceDialog() {

        // DARK OVERLAY

        StackPane overlay =
                new StackPane();

        overlay.setStyle(
                "-fx-background-color:rgba(0,0,0,0.5);"
        );

        // =====================================================
        // POPUP
        // =====================================================

        VBox popup =
                new VBox(15);

        popup.setPadding(
                new Insets(25)
        );

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

        HBox headerRow =
                new HBox();

        headerRow.setAlignment(
                Pos.CENTER_LEFT
        );

        Label popupTitle =
                new Label("All Maintenance");

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

        Button closeTopBtn =
                new Button("✕");

        closeTopBtn.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#555555;" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );

        closeTopBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        headerRow.getChildren().addAll(
                popupTitle,
                spacer,
                closeTopBtn
        );

        // =====================================================
        // ALL MAINTENANCE DATA
        // =====================================================

        VBox allMaintenance =
                new VBox(12);

        allMaintenance.setPadding(
                new Insets(5)
        );

        allMaintenance.getChildren().addAll(

                createMaintenance(
                        "Diya Wadhwa",
                        "B-402",
                        "₹2500",
                        "May 2025",
                        "Pending",
                        "#FFF0D9",
                        "#C47A20"
                ),

                createMaintenance(
                        "Rahul Sharma",
                        "A-101",
                        "₹2500",
                        "May 2025",
                        "Pending",
                        "#FFF0D9",
                        "#C47A20"
                ),

                createMaintenance(
                        "Aarav Mehta",
                        "A-201",
                        "₹2500",
                        "May 2025",
                        "Paid",
                        "#E5F7EC",
                        "#2E9D63"
                ),

                createMaintenance(
                        "Priya Sharma",
                        "B-102",
                        "₹2500",
                        "May 2025",
                        "Paid",
                        "#E5F7EC",
                        "#2E9D63"
                ),

                createMaintenance(
                        "Vikram Deshmukh",
                        "A-305",
                        "₹5000",
                        "April 2025",
                        "Overdue",
                        "#FDE8E8",
                        "#D9534F"
                ),

                createMaintenance(
                        "Meena Shah",
                        "B-404",
                        "₹5000",
                        "April 2025",
                        "Overdue",
                        "#FDE8E8",
                        "#D9534F"
                )
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane popupScroll =
                new ScrollPane();

        popupScroll.setContent(
                allMaintenance
        );

        popupScroll.setFitToWidth(true);

        popupScroll.setPrefHeight(400);

        popupScroll.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =====================================================
        // CLOSE BUTTON
        // =====================================================

        Button closeBtn =
                new Button("Close");

        closeBtn.setPrefWidth(100);
        closeBtn.setPrefHeight(40);

        closeBtn.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:8;" +
                "-fx-cursor:hand;"
        );

        closeBtn.setOnAction(
                e -> removeOverlay(overlay)
        );

        HBox buttonBox =
                new HBox(closeBtn);

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        // =====================================================
        // ADD POPUP CONTENT
        // =====================================================

        popup.getChildren().addAll(
                headerRow,
                popupScroll,
                buttonBox
        );

        // =====================================================
        // ADD TO EXISTING SCENE
        // =====================================================

        overlay.getChildren().add(
                popup
        );

        StackPane.setAlignment(
                popup,
                Pos.CENTER
        );

        rootStack.getChildren().add(
                overlay
        );
    }


    // =========================================================
    // REMOVE OVERLAY
    // =========================================================

    private void removeOverlay(
            StackPane overlay) {

        rootStack.getChildren().remove(
                overlay
        );
    }


    // =========================================================
    // MAINTENANCE CARD
    // =========================================================

    private VBox createMaintenance(
            String residentName,
            String flatNo,
            String amount,
            String month,
            String statusText,
            String statusBackground,
            String statusColor) {

        VBox maintenance =
                new VBox(10);

        maintenance.setPadding(
                new Insets(18)
        );

        maintenance.setPrefHeight(90);
        maintenance.setMaxWidth(1180);

        maintenance.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:10;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label name =
                new Label(residentName);

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        // =====================================================
        // DETAILS
        // =====================================================

        Label details =
                new Label(
                        "Flat: " + flatNo +
                        "    |    " +
                        "Amount: " + amount +
                        "    |    " +
                        month
                );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:#777777;"
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label status =
                new Label(statusText);

        status.setStyle(
                "-fx-background-color:" +
                statusBackground + ";" +

                "-fx-text-fill:" +
                statusColor + ";" +

                "-fx-font-size:10px;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:5px 10px;" +
                "-fx-background-radius:12;"
        );

        // =====================================================
        // BOTTOM
        // =====================================================

        HBox bottom =
                new HBox();

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                details,
                Priority.ALWAYS
        );

        bottom.getChildren().addAll(
                details,
                status
        );

        maintenance.getChildren().addAll(
                name,
                bottom
        );

        return maintenance;
    }
}