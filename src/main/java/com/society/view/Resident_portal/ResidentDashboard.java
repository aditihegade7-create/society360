package com.society.view.Resident_portal;



import javafx.scene.layout.Region;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class ResidentDashboard {
private Scene residentDashboardScene;

 public Scene getResidentDashboardScene( Stage stage) {
  



        // ================= SIDEBAR =================

        panel panelobj = new panel(stage);

        // ================= ROOT =================

        BorderPane root = new BorderPane();

        // Your existing sidebar
        root.setLeft(panelobj.getSidebar());

        // ================= MAIN CONTENT =================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(25, 30, 25, 30)
        );

        mainContent.setStyle(
                "-fx-background-color: #b3adad;"
        );

        // ================= HEADER =================

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox welcomeBox = new VBox(4);

        Label welcome = new Label(
                "Good Morning, Vaishnavi 👋"
        );

        welcome.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        25
                )
        );

        welcome.setTextFill(Color.WHITE);

        Label flat = new Label(
                "Flat A-101 • Tower A"
        );

        flat.setFont(
                Font.font("System", 13)
        );

        flat.setTextFill(Color.WHITE);

        welcomeBox.getChildren().addAll(
                welcome,
                flat
        );

        Region headerSpace = new Region();

        HBox.setHgrow(
                headerSpace,
                Priority.ALWAYS
        );

        Label date = new Label(
                "16 August 2026\nSunday"
        );

        date.setTextFill(Color.WHITE);

        date.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        date.setAlignment(
                Pos.CENTER_RIGHT
        );

        header.getChildren().addAll(
                welcomeBox,
                headerSpace,
                date
        );

        // ================= SUMMARY CARDS =================

        HBox summaryCards = new HBox(15);

        VBox totalDue = createSummaryCard(
                "Total Due",
                "₹ 3,250",
                "View Details"
        );

        VBox maintenanceDue = createSummaryCard(
                "Maintenance Due",
                "₹ 1,250",
                "Due: 20 Aug 2026"
        );

        VBox complaints = createSummaryCard(
                "Active Complaints",
                "2",
                "View Status"
        );

        VBox visitors = createSummaryCard(
                "Visitors Today",
                "1",
                "View Log"
        );

        summaryCards.getChildren().addAll(
                totalDue,
                maintenanceDue,
                complaints,
                visitors
        );

        // ================= QUICK ACTIONS =================

        Label quickTitle =
                createSectionTitle("Quick Actions");

        GridPane quickActions =
                new GridPane();

        quickActions.setHgap(15);
        quickActions.setVgap(15);

        Button payMaintenance =
                createActionButton(
                        "Pay Maintenance",
                        "Secure Online Payment"
                );

        payMaintenance.setOnAction(e -> {
            Residentbtn residentbtn = new Residentbtn();
            stage.setScene(residentbtn.getResidentbtScene(stage)
            );
        });

        Button raiseComplaint =
                createActionButton(
                        "Raise Complaint",
                        "Report an issue"
                );

        raiseComplaint.setOnAction(e -> {

            Complaint complaint =
                    new Complaint();

            stage.setScene(
                    complaint.getComplaintScene(stage)
            );
        });

        Button bookAmenity =
                createActionButton(
                        "Book Amenity",
                        "Hall, Court, Guest Room"
                );

        bookAmenity.setOnAction(e -> {

            Aminity booking =
                    new Aminity();

            stage.setScene( booking.getAminityScene(stage));
        });

        Button inviteVisitor =
                createActionButton(
                        "Invite Visitor",
                        "Pre-approve entry"
                );

        inviteVisitor.setOnAction(e -> {

            Visitor visitor =
                    new Visitor();

            stage.setScene(
                    visitor.getVisitorScene(stage)
            );
        });

        quickActions.add(
                payMaintenance,
                0,
                0
        );

        quickActions.add(
                raiseComplaint,
                1,
                0
        );

        quickActions.add(
                bookAmenity,
                0,
                1
        );

        quickActions.add(
                inviteVisitor,
                1,
                1
        );

        // ================= UPCOMING / DUE =================

        VBox upcomingBox =
                new VBox(12);

        upcomingBox.setPadding(
                new Insets(18)
        );

        upcomingBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label upcomingTitle =
                new Label("Upcoming / Due");

        upcomingTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        upcomingTitle.setTextFill(
                Color.web("#263238")
        );

        upcomingBox.getChildren().add(
                upcomingTitle
        );

        upcomingBox.getChildren().addAll(

                createDueRow(
                        "Maintenance Due",
                        "20 Aug 2026"
                ),

                createDueRow(
                        "Water Bill",
                        "25 Aug 2026"
                ),

                createDueRow(
                        "Electricity Bill",
                        "30 Aug 2026"
                )
        );

        // ================= MIDDLE SECTION =================

        HBox middleSection =
                new HBox(20);

        VBox quickBox =
                new VBox(10);

        quickBox.setPadding(
                new Insets(18)
        );

        quickBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        quickBox.getChildren().addAll(
                quickTitle,
                quickActions
        );

        HBox.setHgrow(
                quickBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                upcomingBox,
                Priority.ALWAYS
        );

        middleSection.getChildren().addAll(
                quickBox,
                upcomingBox
        );

        // ================= BOTTOM SECTION =================

        HBox bottomSection =
                new HBox(20);

        // Society Notices

        VBox noticesBox =
                new VBox(12);

        noticesBox.setPadding(
                new Insets(18)
        );

        noticesBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label noticesTitle =
                new Label("Society Notices");

        noticesTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        noticesTitle.setTextFill(
                Color.web("#263238")
        );

        Label notice1 =
                new Label(
                        "• Water supply will be shut down\n" +
                        "  on 20 August from 10:00 AM to 6:00 PM."
                );

        notice1.setFont(
                Font.font("System", 13)
        );

        notice1.setWrapText(true);

        Label notice2 =
                new Label(
                        "• Society meeting will be held\n" +
                        "  on Sunday at 5:00 PM."
                );

        notice2.setFont(
                Font.font("System", 13)
        );

        notice2.setWrapText(true);

        noticesBox.getChildren().addAll(
                noticesTitle,
                notice1,
                notice2
        );

        // Community Poll

        VBox pollBox =
                new VBox(12);

        pollBox.setPadding(
                new Insets(18)
        );

        pollBox.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label pollTitle =
                new Label("Community Poll");

        pollTitle.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        pollTitle.setTextFill(
                Color.web("#263238")
        );

        Label question =
                new Label(
                        "Should we organize a society picnic this month?"
                );

        question.setWrapText(true);

        question.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        Label yes =
                new Label("Yes (78%)");

        yes.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        ProgressBar yesBar =
                new ProgressBar(0.78);

        yesBar.setPrefWidth(250);

        Label no =
                new Label("No (22%)");

        no.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        ProgressBar noBar =
                new ProgressBar(0.22);

        noBar.setPrefWidth(250);

        pollBox.getChildren().addAll(
                pollTitle,
                question,
                yes,
                yesBar,
                no,
                noBar
        );

        HBox.setHgrow(
                noticesBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                pollBox,
                Priority.ALWAYS
        );

        bottomSection.getChildren().addAll(
                noticesBox,
                pollBox
        );

        // ================= ADD EVERYTHING =================

        mainContent.getChildren().addAll(
                header,
                summaryCards,
                middleSection,
                bottomSection
        );

        // ================= ROOT =================

        root.setCenter(mainContent);

        return new Scene(
                root,
                1200,
                700
        );
    }

    // =====================================================
    // SUMMARY CARD
    // =====================================================

    private VBox createSummaryCard(
            String title,
            String amount,
            String bottomText) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(16)
        );

        card.setPrefWidth(190);
        card.setPrefHeight(110);

        card.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 10;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        titleLabel.setTextFill(
                Color.web("#607D8B")
        );

        Label amountLabel =
                new Label(amount);

        amountLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        22
                )
        );

        amountLabel.setTextFill(
                Color.web("#263238")
        );

        Label bottomLabel =
                new Label(bottomText);

        bottomLabel.setFont(
                Font.font("System", 12)
        );

        bottomLabel.setTextFill(
                Color.web("#789098")
        );

        card.getChildren().addAll(
                titleLabel,
                amountLabel,
                bottomLabel
        );

        return card;
    }

    // =====================================================
    // SECTION TITLE
    // =====================================================

    private Label createSectionTitle(
            String text) {

        Label label =
                new Label(text);

        label.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        17
                )
        );

        label.setTextFill(
                Color.web("#263238")
        );

        return label;
    }

    // =====================================================
    // QUICK ACTION BUTTON
    // =====================================================

    private Button createActionButton(
            String title,
            String subtitle) {

        Button button =
                new Button();

        button.setPrefSize(
                230,
                65
        );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        13
                )
        );

        Label subtitleLabel =
                new Label(subtitle);

        subtitleLabel.setFont(
                Font.font("System", 11)
        );

        subtitleLabel.setTextFill(
                Color.GRAY
        );

        VBox content =
                new VBox(4);

        content.getChildren().addAll(
                titleLabel,
                subtitleLabel
        );

        button.setGraphic(content);

        button.setStyle(
                "-fx-background-color: #F5F7F8;" +
                "-fx-border-color: #D5DDE0;" +
                "-fx-border-radius: 7;" +
                "-fx-background-radius: 7;"
        );

        return button;
    }

    // =====================================================
    // DUE ROW
    // =====================================================

    private HBox createDueRow(
            String title,
            String date) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        Label dateLabel =
                new Label(date);

        dateLabel.setFont(
                Font.font(
                        "System",
                        FontWeight.BOLD,
                        12
                )
        );

        dateLabel.setTextFill(
                Color.web("#607D8B")
        );

        Region spacer =
                new Region();
        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                titleLabel,
                spacer,
                dateLabel
        );

        return row;
    }
}



  
   
