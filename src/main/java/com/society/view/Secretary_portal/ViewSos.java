package com.society.view.Secretary_portal;

import com.society.view.ScreenSize;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewSos {

    // =========================================================
    // SCENE
    // =========================================================

    private Scene viewSosScene;

    // =========================================================
    // COLORS
    // =========================================================

    private static final String BACKGROUND = "#b3adad";
    private static final String DARK = "#434141";
    private static final String TEXT_DARK = "#333333";
    private static final String GREEN = "#123C36";
    private static final String BORDER = "#EEEEEE";
    private static final String WHITE = "#FFFFFF";
    private static final String GREY = "#777777";

    // =========================================================
    // CREATE SCENE
    // =========================================================

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

        mainvb.setPadding(
                new Insets(25)
        );

        mainvb.setPrefWidth(1220);

        mainvb.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        mainvb.setStyle(
                "-fx-background-color:" + BACKGROUND + ";"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label heading =
                new Label("VIEW SOS ALERTS");

        heading.setStyle(
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:" + DARK + ";"
        );

        // =====================================================
        // TITLE
        // =====================================================

        Label title =
                new Label("SOS Alerts");

        title.setStyle(
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:black;"
        );

        // =====================================================
        // SUBTITLE
        // =====================================================

        Label subtitle =
                new Label(
                        "View and manage emergency alerts from residents"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:" + GREY + ";"
        );

        // =====================================================
        // TITLE BOX
        // =====================================================

        VBox titleBox =
                new VBox(5);

        titleBox.getChildren().addAll(
                title,
                subtitle
        );

        // =====================================================
        // FILTER BUTTONS
        // =====================================================

        Button activeBtn =
                new Button("Active (3)");

        Button resolvedBtn =
                new Button("Resolved (5)");

        Button allBtn =
                new Button("All Alerts");

        activeBtn.setPrefWidth(140);
        activeBtn.setPrefHeight(40);

        resolvedBtn.setPrefWidth(140);
        resolvedBtn.setPrefHeight(40);

        allBtn.setPrefWidth(140);
        allBtn.setPrefHeight(40);

        // =====================================================
        // BUTTON STYLES
        // =====================================================

        String normalStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:" + GREY + ";" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-cursor:hand;";

        String activeStyle =
                "-fx-background-color:transparent;" +
                "-fx-text-fill:" + GREEN + ";" +
                "-fx-font-weight:bold;" +
                "-fx-font-size:12px;" +
                "-fx-border-color:#0B4F4A;" +
                "-fx-border-width:0 0 2 0;" +
                "-fx-cursor:hand;";

        activeBtn.setStyle(activeStyle);
        resolvedBtn.setStyle(normalStyle);
        allBtn.setStyle(normalStyle);

        // =====================================================
        // TABS
        // =====================================================

        HBox tabs =
                new HBox(25);

        tabs.setAlignment(
                Pos.CENTER_LEFT
        );

        tabs.getChildren().addAll(
                activeBtn,
                resolvedBtn,
                allBtn
        );

        // =====================================================
        // SOS LIST
        // =====================================================

        VBox sosList =
                new VBox(15);

        sosList.setPadding(
                new Insets(5, 0, 5, 0)
        );

        sosList.setFillWidth(true);

        // =====================================================
        // ACTIVE ALERTS
        // =====================================================

        VBox sos1 =
                createSos(
                        "Diya Wadhwa",
                        "B-402",
                        "Medical Emergency",
                        "10:30 AM",
                        "Active"
                );

        VBox sos2 =
                createSos(
                        "Rahul Sharma",
                        "A-101",
                        "Security Emergency",
                        "11:15 AM",
                        "Active"
                );

        VBox sos3 =
                createSos(
                        "Neha Patil",
                        "C-203",
                        "Medical Emergency",
                        "12:05 PM",
                        "Active"
                );

        // =====================================================
        // RESOLVED ALERTS
        // =====================================================

        VBox sos4 =
                createSos(
                        "Amit Kulkarni",
                        "B-305",
                        "Medical Emergency",
                        "09:20 AM",
                        "Resolved"
                );

        VBox sos5 =
                createSos(
                        "Pooja Singh",
                        "A-503",
                        "Security Emergency",
                        "08:45 AM",
                        "Resolved"
                );

        VBox sos6 =
                createSos(
                        "Rohan Joshi",
                        "C-102",
                        "Other Emergency",
                        "07:30 AM",
                        "Resolved"
                );

        VBox sos7 =
                createSos(
                        "Sneha Patil",
                        "A-204",
                        "Medical Emergency",
                        "06:50 AM",
                        "Resolved"
                );

        VBox sos8 =
                createSos(
                        "Kunal Shah",
                        "B-201",
                        "Security Emergency",
                        "06:15 AM",
                        "Resolved"
                );

        // =====================================================
        // ACTIVE BY DEFAULT
        // =====================================================

        sosList.getChildren().addAll(
                sos1,
                sos2,
                sos3
        );

        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                sosList
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setPrefHeight(450);

        scrollPane.setMaxHeight(
                Double.MAX_VALUE
        );

        scrollPane.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-border-color:transparent;"
        );

        // =====================================================
        // ACTIVE BUTTON ACTION
        // =====================================================

        activeBtn.setOnAction(e -> {

            sosList.getChildren().clear();

            sosList.getChildren().addAll(
                    sos1,
                    sos2,
                    sos3
            );

            activeBtn.setStyle(
                    activeStyle
            );

            resolvedBtn.setStyle(
                    normalStyle
            );

            allBtn.setStyle(
                    normalStyle
            );
        });

        // =====================================================
        // RESOLVED BUTTON ACTION
        // =====================================================

        resolvedBtn.setOnAction(e -> {

            sosList.getChildren().clear();

            sosList.getChildren().addAll(
                    sos4,
                    sos5,
                    sos6,
                    sos7,
                    sos8
            );

            activeBtn.setStyle(
                    normalStyle
            );

            resolvedBtn.setStyle(
                    activeStyle
            );

            allBtn.setStyle(
                    normalStyle
            );
        });

        // =====================================================
        // ALL BUTTON ACTION
        // =====================================================

        allBtn.setOnAction(e -> {

            sosList.getChildren().clear();

            sosList.getChildren().addAll(
                    sos1,
                    sos2,
                    sos3,
                    sos4,
                    sos5,
                    sos6,
                    sos7,
                    sos8
            );

            activeBtn.setStyle(
                    normalStyle
            );

            resolvedBtn.setStyle(
                    normalStyle
            );

            allBtn.setStyle(
                    activeStyle
            );
        });

        // =====================================================
        // VIEW ALL BUTTON
        // =====================================================

        Button viewAllBtn =
                new Button(
                        "View All SOS Alerts"
                );

        viewAllBtn.setPrefWidth(
                1180
        );

        viewAllBtn.setPrefHeight(
                40
        );

        viewAllBtn.setMaxWidth(
                Double.MAX_VALUE
        );

        viewAllBtn.setStyle(
                "-fx-background-color:" + DARK + ";" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:7;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:7;" +
                "-fx-cursor:hand;"
        );

        // =====================================================
        // VIEW ALL BUTTON ACTION
        // =====================================================

        viewAllBtn.setOnAction(e -> {

            sosList.getChildren().clear();

            sosList.getChildren().addAll(
                    sos1,
                    sos2,
                    sos3,
                    sos4,
                    sos5,
                    sos6,
                    sos7,
                    sos8
            );

            activeBtn.setStyle(
                    normalStyle
            );

            resolvedBtn.setStyle(
                    normalStyle
            );

            allBtn.setStyle(
                    activeStyle
            );
        });

        // =====================================================
        // ADD CONTENT TO MAIN
        // =====================================================

        mainvb.getChildren().addAll(
                heading,
                titleBox,
                tabs,
                scrollPane,
                viewAllBtn
        );

        // =====================================================
        // ROOT
        // =====================================================

        HBox root =
                new HBox();

        root.setMaxSize(
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );

        root.setStyle(
                "-fx-background-color:" + DARK + ";"
        );

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

        viewSosScene =
                new Scene(
                        root,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        stage.setTitle(
                "Society360 - View SOS Alerts"
        );

        stage.setScene(
                viewSosScene
        );

        stage.show();

        return viewSosScene;
    }

    // =========================================================
    // CREATE SOS CARD
    // =========================================================

    private VBox createSos(
            String residentName,
            String flatNo,
            String emergencyType,
            String time,
            String statusText
    ) {

        VBox sos =
                new VBox(10);

        sos.setPadding(
                new Insets(18)
        );

        sos.setPrefHeight(95);

        sos.setMaxWidth(
                Double.MAX_VALUE
        );

        sos.setStyle(
                "-fx-background-color:white;" +
                "-fx-background-radius:10;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:10;"
        );

        // =====================================================
        // RESIDENT NAME
        // =====================================================

        Label name =
                new Label(
                        residentName
                );

        name.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:" + GREEN + ";"
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label status =
                new Label(
                        statusText
                );

        if (statusText.equalsIgnoreCase("Active")) {

            status.setStyle(
                    "-fx-background-color:#FDE8E8;" +
                    "-fx-text-fill:#D9534F;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );

        } else {

            status.setStyle(
                    "-fx-background-color:#E5F7EC;" +
                    "-fx-text-fill:#2E9D63;" +
                    "-fx-font-size:10px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-padding:5px 10px;" +
                    "-fx-background-radius:12;"
            );
        }

        // =====================================================
        // TOP ROW
        // =====================================================

        HBox topRow =
                new HBox();

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );

        RegionSpacer spacer =
                new RegionSpacer();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        topRow.getChildren().addAll(
                name,
                spacer,
                status
        );

        // =====================================================
        // DETAILS
        // =====================================================

        Label details =
                new Label(
                        "Flat: " + flatNo +
                        "    |    " +
                        "Emergency: " + emergencyType +
                        "    |    " +
                        "Time: " + time
                );

        details.setStyle(
                "-fx-font-size:11px;" +
                "-fx-text-fill:" + GREY + ";"
        );

        // =====================================================
        // ADD TO CARD
        // =====================================================

        sos.getChildren().addAll(
                topRow,
                details
        );

        return sos;
    }

    // =========================================================
    // SMALL REGION CLASS
    // =========================================================
    // Used only as a spacer in the top row.
    // =========================================================

    private static class RegionSpacer
            extends javafx.scene.layout.Region {
    }
}