
package com.society.view.Owner_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RentalHistory {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
       
        OwnerSidebar sidebar =new OwnerSidebar(stage);

        root.setLeft(sidebar.getSidebar());

       
        VBox mainContent = new VBox();

        mainContent.setPadding( new Insets(25, 35, 25, 35) );

        mainContent.setSpacing(15);

        mainContent.setAlignment(
                Pos.TOP_LEFT
        );

        mainContent.setStyle( "-fx-background-color: #b3adad;" );

        Label title = new Label( "Rental History" );

        title.setStyle(
                "-fx-font-size: 27px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        Label subtitle = new Label( "View rental history of tenants");

        subtitle.setStyle("-fx-font-size: 13px;-fx-text-fill: #263238;" );

        VBox heading = new VBox( 5,title,subtitle );

        mainContent.getChildren().add(
                heading
        );

        TableView<Rental> table =new TableView<>();

        table.setPrefHeight(550);

        table.setColumnResizePolicy(
                TableView.CONSTRAINED_RESIZE_POLICY
        );


        TableColumn<Rental, String> tenantColumn =
                new TableColumn<>("Tenant Name");

        tenantColumn.setCellValueFactory(
                new PropertyValueFactory<>("tenant")
        );

        TableColumn<Rental, String> flatColumn =
                new TableColumn<>("Flat / Unit");

        flatColumn.setCellValueFactory(
                new PropertyValueFactory<>("flat")
        );

        TableColumn<Rental, String> moveInColumn =
                new TableColumn<>("Move-in Date");

        moveInColumn.setCellValueFactory(
                new PropertyValueFactory<>("moveIn")
        );

        TableColumn<Rental, String> moveOutColumn =
                new TableColumn<>("Move-out Date");

        moveOutColumn.setCellValueFactory(
                new PropertyValueFactory<>("moveOut")
        );

        TableColumn<Rental, String> rentColumn =
                new TableColumn<>("Rent (Monthly)");

        rentColumn.setCellValueFactory(
                new PropertyValueFactory<>("rent")
        );

        TableColumn<Rental, String> statusColumn =
                new TableColumn<>("Status");

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        table.getColumns().addAll(
                tenantColumn,
                flatColumn,
                moveInColumn,
                moveOutColumn,
                rentColumn,
                statusColumn
        );

       
        table.getItems().addAll(

                new Rental(
                        "Rahul Sharma",
                        "A-101",
                        "01 Jan 2025",
                        "-",
                        "₹9,000",
                        "Active"
                ),

                new Rental(
                        "Priya Mehta",
                        "B-201",
                        "01 Jan 2025",
                        "-",
                        "₹10,000",
                        "Active"
                ),

                new Rental(
                        "Amit Verma",
                        "B-201",
                        "15 Feb 2024",
                        "31 Dec 2024",
                        "₹10,000",
                        "Inactive"
                ),

                new Rental(
                        "Sneha Patil",
                        "G-03",
                        "01 Aug 2023",
                        "31 Jan 2024",
                        "₹8,500",
                        "Inactive"
                )
        );

        
        table.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D5DDE0;"
        );

       
        mainContent.getChildren().add(
                table
        );

        
        root.setCenter(
                mainContent
        );

        return new Scene( root, 1500, 750
        );
    }



    public static class Rental {

        private String tenant;
        private String flat;
        private String moveIn;
        private String moveOut;
        private String rent;
        private String status;

        public Rental(
                String tenant,
                String flat,
                String moveIn,
                String moveOut,
                String rent,
                String status
        ) {

            this.tenant = tenant;
            this.flat = flat;
            this.moveIn = moveIn;
            this.moveOut = moveOut;
            this.rent = rent;
            this.status = status;
        }

        public String getTenant() {
            return tenant;
        }

        public String getFlat() {
            return flat;
        }

        public String getMoveIn() {
            return moveIn;
        }

        public String getMoveOut() {
            return moveOut;
        }

        public String getRent() {
            return rent;
        }

        public String getStatus() {
            return status;
        }
    }
}