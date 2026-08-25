package com.society.view.Owner_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OwnerSidebar {

    private VBox sidebar;

    public OwnerSidebar(Stage stage) {
        sidebar = new VBox();
        sidebar.setPadding( new Insets(20) );
        sidebar.setPrefWidth(280);
        sidebar.setPrefHeight(750);
        sidebar.setAlignment(Pos.TOP_LEFT);
        sidebar.setStyle("-fx-background-color: #593a32;" );

        Label logo = new Label( "Society360");
        logo.setStyle(  "-fx-font-size: 22px;-fx-font-weight: bold;-fx-text-fill: white;" );
        Label portal = new Label( "Owner Portal" );
        portal.setTextFill( Color.LIGHTBLUE );

        Button dashboard = new Button("Dashboard");
        Button addTenant = new Button("Add Tenant");
        Button removeTenant = new Button("Remove Tenant");
        Button payments = new Button("View Payments" );
        Button rentalHistory = new Button("Rental History" );
        Button ownerDocuments= new Button("Owner Document");
        Button profile = new Button("Profile");
        Button logout = new Button("Logout");

        dashboard.setPrefSize(300, 40);
        addTenant.setPrefSize(300, 40);
        removeTenant.setPrefSize(300, 40);
        payments.setPrefSize(300, 40);
        rentalHistory.setPrefSize(300, 40);
        ownerDocuments.setPrefSize(300,40);
        profile.setPrefSize(300, 40);
        logout.setPrefSize(300, 40);

        sidebar.setSpacing(10);

       

         dashboard.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white;-fx-font-size: 16px;");
         addTenant.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
         removeTenant.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
         payments.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
         rentalHistory.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
        ownerDocuments.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
         profile.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");
         logout.setStyle("-fx-background-color: #4e423e; -fx-text-fill: white; -fx-font-size: 16px;");

        
        dashboard.setOnAction(e -> {stage.setScene(OwnerDashboard.createScene(stage) );
        });

        addTenant.setOnAction(e -> { stage.setScene( AddTenant.createScene(stage));
        });

        removeTenant.setOnAction(e -> {stage.setScene(RemoveTenant.createScene(stage));
        });

        payments.setOnAction(e -> {stage.setScene(ViewPayments.createScene(stage));
        });

        rentalHistory.setOnAction(e -> {stage.setScene( RentalHistory.createScene(stage));
        });

        ownerDocuments.setOnAction(e -> {stage.setScene(OwnerDocuments.createScene(stage));
        });

        profile.setOnAction(e -> {stage.setScene( OwnerProfile.createScene(stage));
        });
        

        logout.setOnAction(e -> {System.out.println("Logout");
        });

        sidebar.getChildren().addAll(
                logo,
                portal,
                dashboard,
                addTenant,
                removeTenant,
                payments,
                rentalHistory,
                ownerDocuments,
                profile,
                logout
        );
    }

    public VBox getSidebar() {
     return sidebar;
    }
}