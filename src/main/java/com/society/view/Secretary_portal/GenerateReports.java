package com.society.view.Secretary_portal;

import java.util.List;

import com.society.controller.Secretary_Controller.ReportController;
import com.society.model.Secretary_model.Report;
import com.society.view.ScreenSize;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GenerateReports {

    private ReportController reportController;

    private TableView<Report> reportTable;

    private ObservableList<Report> reportList;

    public GenerateReports() {

        reportController =
                new ReportController();
    }

    // ============================================================
    // CREATE SCENE
    // ============================================================

    public Scene createScene(Stage stage) {

        // ========================================================
        // SIDEBAR
        // ========================================================

        SecretarySidebar sidebarObj =
                new SecretarySidebar();

        VBox sidebar =
                sidebarObj.createSidebar(stage);

        // ========================================================
        // MAIN LAYOUT
        // ========================================================

        BorderPane mainLayout =
                new BorderPane();

        mainLayout.setStyle(
                "-fx-background-color:#b3adad;"
        );

        // ========================================================
        // HEADER
        // ========================================================

        HBox header =
                new HBox();

        header.setPadding(
                new Insets(20)
        );

        header.setSpacing(15);

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setStyle(
                "-fx-background-color:#b3adad;"
        );

        Label title =
                new Label(
                        "Generate Reports"
                );

        title.setStyle(
                "-fx-font-size:26px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#434141;"
        );

        Label subtitle =
                new Label(
                        "View reports and data collected from all society portals"
                );

        subtitle.setStyle(
                "-fx-font-size:13px;" +
                "-fx-text-fill:#555555;"
        );

        VBox titleBox =
                new VBox(
                        5,
                        title,
                        subtitle
                );

        header.getChildren().add(
                titleBox
        );

        mainLayout.setTop(header);

        // ========================================================
        // FILTER SECTION
        // ========================================================

        HBox filterBox =
                new HBox();

        filterBox.setSpacing(15);

        filterBox.setPadding(
                new Insets(15, 20, 15, 20)
        );

        filterBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Label filterLabel =
                new Label(
                        "Filter by Source:"
                );

        filterLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;"
        );

        ComboBox<String> sourceFilter =
                new ComboBox<>();

        sourceFilter.getItems().addAll(
                "All",
                "Guards",
                "Residents",
                "Owners",
                "Complaints",
                "Maintenance",
                "Payments",
                "Events",
                "Notices",
                "SOS"
        );

        sourceFilter.setValue("All");

        sourceFilter.setPrefWidth(180);

        // ========================================================
        // REFRESH BUTTON
        // ========================================================

        Button refreshButton =
                new Button(
                        "↻ Refresh Reports"
                );

        refreshButton.setStyle(
                "-fx-background-color:#434141;" +
                "-fx-text-fill:white;" +
                "-fx-font-weight:bold;" +
                "-fx-padding:10px 18px;"
        );

        // ========================================================
        // TOTAL LABEL
        // ========================================================

        Label totalLabel =
                new Label(
                        "Total Reports: 0"
                );

        totalLabel.setStyle(
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-text-fill:#183B56;"
        );

        filterBox.getChildren().addAll(
                filterLabel,
                sourceFilter,
                refreshButton,
                totalLabel
        );

        // ========================================================
        // TABLE
        // ========================================================

        reportTable =
                new TableView<>();

        reportTable.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );

        reportTable.setPlaceholder(
                new Label(
                        "No reports found."
                )
        );

        // ========================================================
        // SOURCE COLUMN
        // ========================================================

        TableColumn<Report, String> sourceColumn =
                new TableColumn<>(
                        "Source"
                );

        sourceColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "source"
                )
        );

        sourceColumn.setPrefWidth(130);

        // ========================================================
        // TYPE COLUMN
        // ========================================================

        TableColumn<Report, String> typeColumn =
                new TableColumn<>(
                        "Report Type"
                );

        typeColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "type"
                )
        );

        typeColumn.setPrefWidth(130);

        // ========================================================
        // TITLE COLUMN
        // ========================================================

        TableColumn<Report, String> titleColumn =
                new TableColumn<>(
                        "Title / Name"
                );

        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "title"
                )
        );

        titleColumn.setPrefWidth(180);

        // ========================================================
        // DETAILS COLUMN
        // ========================================================

        TableColumn<Report, String> detailsColumn =
                new TableColumn<>(
                        "Details"
                );

        detailsColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "details"
                )
        );

        detailsColumn.setPrefWidth(300);

        // ========================================================
        // DATE COLUMN
        // ========================================================

        TableColumn<Report, String> dateColumn =
                new TableColumn<>(
                        "Date"
                );

        dateColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "date"
                )
        );

        dateColumn.setPrefWidth(150);

        // ========================================================
        // STATUS COLUMN
        // ========================================================

        TableColumn<Report, String> statusColumn =
                new TableColumn<>(
                        "Status"
                );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>(
                        "status"
                )
        );

        statusColumn.setPrefWidth(120);

        reportTable.getColumns().addAll(
                sourceColumn,
                typeColumn,
                titleColumn,
                detailsColumn,
                dateColumn,
                statusColumn
        );

        // ========================================================
        // TABLE CONTAINER
        // ========================================================

        VBox tableBox =
                new VBox();

        tableBox.setPadding(
                new Insets(0, 20, 20, 20)
        );

        tableBox.setStyle(
                "-fx-background-color:#b3adad;"
        );

        VBox.setVgrow(
                reportTable,
                Priority.ALWAYS
        );

        tableBox.getChildren().add(
                reportTable
        );

        // ========================================================
        // FILTER ACTION
        // ========================================================

        sourceFilter.setOnAction(e -> {

            String selected =
                    sourceFilter.getValue();

            filterReports(
                    selected,
                    totalLabel
            );
        });

        // ========================================================
        // REFRESH ACTION
        // ========================================================

        refreshButton.setOnAction(e -> {

            loadReports(
                    totalLabel,
                    sourceFilter
            );
        });

        // ========================================================
        // LOAD INITIAL DATA
        // ========================================================

        loadReports(
                totalLabel,
                sourceFilter
        );

        // ========================================================
        // CONTENT
        // ========================================================

        VBox content =
                new VBox();

        content.setStyle(
                "-fx-background-color:#b3adad;"
        );

        content.getChildren().addAll(
                filterBox,
                tableBox
        );

        VBox.setVgrow(
                tableBox,
                Priority.ALWAYS
        );

        mainLayout.setCenter(
                content
        );

        // ========================================================
        // BODY
        // ========================================================

        HBox body =
                new HBox();

        body.setStyle(
                "-fx-background-color:#b3adad;"
        );

        body.getChildren().addAll(
                sidebar,
                mainLayout
        );

        HBox.setHgrow(
                mainLayout,
                Priority.ALWAYS
        );

        // ========================================================
        // SCROLL
        // ========================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                body
        );

        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background:#b3adad;" +
                "-fx-background-color:#b3adad;"
        );

        // ========================================================
        // SCENE
        // ========================================================

        Scene scene =
                new Scene(
                        scrollPane,
                        ScreenSize.getWidth(),
                        ScreenSize.getHeight()
                );

        return scene;
    }

    // ============================================================
    // LOAD REPORTS
    // ============================================================

    private void loadReports(
            Label totalLabel,
            ComboBox<String> sourceFilter) {

        try {

            System.out.println(
                    "================================="
            );

            System.out.println(
                    "Fetching Reports..."
            );

            List<Report> reports =
                    reportController.getAllReports();

            reportList =
                    FXCollections.observableArrayList(
                            reports
                    );

            reportTable.setItems(
                    reportList
            );

            totalLabel.setText(
                    "Total Reports: " +
                    reportList.size()
            );

            sourceFilter.setValue("All");

            System.out.println(
                    "Reports loaded: " +
                    reportList.size()
            );

            System.out.println(
                    "================================="
            );

        } catch (Exception e) {

            System.out.println(
                    "Error loading reports: " +
                    e.getMessage()
            );

            e.printStackTrace();

            reportTable.setItems(
                    FXCollections.observableArrayList()
            );

            totalLabel.setText(
                    "Total Reports: 0"
            );
        }
    }

    // ============================================================
    // FILTER REPORTS
    // ============================================================

    private void filterReports(
            String selected,
            Label totalLabel) {

        if (reportList == null) {
            return;
        }

        if (selected == null ||
                selected.equals("All")) {

            reportTable.setItems(
                    reportList
            );

            totalLabel.setText(
                    "Total Reports: " +
                    reportList.size()
            );

            return;
        }

        ObservableList<Report> filtered =
                FXCollections.observableArrayList();

        for (Report report :
                reportList) {

            if (report.getSource()
                    .equalsIgnoreCase(selected)) {

                filtered.add(report);
            }
        }

        reportTable.setItems(
                filtered
        );

        totalLabel.setText(
                "Total Reports: " +
                filtered.size()
        );
    }
}