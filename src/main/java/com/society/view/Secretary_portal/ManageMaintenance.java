package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageMaintenance {

    
    private Scene manageMaintenanceScene;
    public Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
        SecretarySidebar sidebarObj = new SecretarySidebar();

        VBox sidebar = sidebarObj.createSidebar(stage);
        root.setLeft(sidebar);
        BorderPane mainarea = new BorderPane();

        HBox header = new HBox();

        header.setPrefHeight(80);
        header.setMinHeight(80);
        header.setMaxHeight(80);

        header.setPadding(
                new Insets(20)
        );

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color:#4e342e;"
        );

        VBox headerText = new VBox(4);

        Label greeting = new Label(
                "Manage Maintenance"
        );

        greeting.setStyle(
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#ffffff;"
        );


        Label description = new Label(
                "View and manage society maintenance records"
        );

        description.setStyle(
                "-fx-font-size:12px;" +
                "-fx-text-fill:#ffffff;"
        );


        headerText.getChildren().addAll(
                greeting,
                description
        );


        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label day = new Label();
        Label date = new Label();

        java.time.LocalDate today =
                java.time.LocalDate.now();


        day.setText(
                today.format(
                        java.time.format.DateTimeFormatter.ofPattern(
                                "EEEE"
                        )
                )
        );


        date.setText(
                today.format(
                        java.time.format.DateTimeFormatter.ofPattern(
                                "dd MMMM yyyy"
                        )
                )
        );


        day.setStyle(
                "-fx-text-fill:#ffffff;"
        );

        date.setStyle(
                "-fx-text-fill:#ffffff;"
        );


        VBox dateBox = new VBox(4);

        dateBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        dateBox.getChildren().addAll(
                day,
                date
        );

        header.getChildren().addAll(
                headerText,
                spacer,
                dateBox
        );

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(25, 30, 25, 30)
        );

        mainContent.setStyle(
                "-fx-background-color:#e8ddd5;"
        );
        Label sectionTitle = new Label(
                "MAINTENANCE RECORDS"
        );

        sectionTitle.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        Button pendingBtn = new Button(
                "Pending (8)"
        );

        Button paidBtn = new Button(
                "Paid (32)"
        );

        Button overdueBtn = new Button(
                "Overdue (5)"
        );


        pendingBtn.setPrefWidth(150);
        pendingBtn.setPrefHeight(40);

        paidBtn.setPrefWidth(150);
        paidBtn.setPrefHeight(40);

        overdueBtn.setPrefWidth(150);
        overdueBtn.setPrefHeight(40);
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


        pendingBtn.setStyle(
                activeStyle
        );

        paidBtn.setStyle(
                normalStyle
        );

        overdueBtn.setStyle(
                normalStyle
        );

        HBox tabs = new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );


        tabs.getChildren().addAll(
                pendingBtn,
                paidBtn,
                overdueBtn
        );

        VBox maintenanceList = new VBox(15);

        maintenanceList.setPadding(
                new Insets(5, 0, 5, 0)
        );

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


            pendingBtn.setStyle(
                    activeStyle
            );

            paidBtn.setStyle(
                    normalStyle
            );

            overdueBtn.setStyle(
                    normalStyle
            );
        });

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


            pendingBtn.setStyle(
                    normalStyle
            );

            paidBtn.setStyle(
                    activeStyle
            );

            overdueBtn.setStyle(
                    normalStyle
            );
        });

        overdueBtn.setOnAction(e -> {

            maintenanceList.getChildren().clear();

            maintenanceList.getChildren().addAll(
                    overdue1,
                    overdue2,
                    overdue3,
                    overdue4,
                    overdue5
            );


            pendingBtn.setStyle(
                    normalStyle
            );

            paidBtn.setStyle(
                    normalStyle
            );

            overdueBtn.setStyle(
                    activeStyle
            );
        });


       
        Button viewAllBtn = new Button(
                "View All Maintenance"
        );

        viewAllBtn.setPrefWidth(1180);

        viewAllBtn.setPrefHeight(40);

        viewAllBtn.setStyle(
                "-fx-background-color:#4e342e;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:#EEEEEE;" +
                "-fx-border-radius:7;"
        );

        mainContent.getChildren().addAll(
                sectionTitle,
                tabs,
                scrollPane,
                viewAllBtn
        );

        mainarea.setTop(
                header
        );

        mainarea.setCenter(
                mainContent
        );

        root.setCenter(
                mainarea
        );


        Scene scene = new Scene(
                root,
                ScreenSize.getWidth(),
                ScreenSize.getHeight()
        );

        manageMaintenanceScene = scene;

        return manageMaintenanceScene;
    }

    private VBox createMaintenance(
            String residentName,
            String flatNo,
            String amount,
            String month,
            String statusText,
            String statusBackground,
            String statusColor) {


        VBox maintenance = new VBox(10);

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

        Label name = new Label(
                residentName
        );

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#123C36;"
        );

        Label details = new Label(
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

        Label status = new Label(
                statusText
        );

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


        
        HBox bottom = new HBox();

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