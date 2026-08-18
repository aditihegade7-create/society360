package com.society.view.Owner_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveTenant {

    public static Scene createScene(Stage stage) {

         BorderPane root = new BorderPane();
         OwnerSidebar sidebar = new OwnerSidebar(stage);
         root.setLeft( sidebar.getSidebar() );

         VBox mainContent = new VBox();
         mainContent.setPadding(new Insets(30, 40, 30, 40));
         mainContent.setSpacing(20);
         mainContent.setAlignment(
                Pos.TOP_LEFT
        );

        mainContent.setStyle( "-fx-background-color: #b3adad;" );

        
        Label title = new Label("Remove Tenant" );
        title.setStyle( "-fx-font-size: 27px;-fx-font-weight: bold;-fx-text-fill: #102A43;"
        );

        Label subtitle = new Label("Remove an existing tenant from your property"
        );
        subtitle.setStyle(
                "-fx-font-size: 13px;-fx-text-fill: #263238;");

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        VBox tenantCard = new VBox();
        tenantCard.setPadding( new Insets(25)
        );
        tenantCard.setSpacing(20);
        tenantCard.setMaxWidth( 1000 );

        tenantCard.setStyle( "-fx-background-color: #F4F7F8;-fx-background-radius: 12;" );

       
        Label cardTitle = new Label( "Tenant Details"  );
       cardTitle.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #102A43;" );

        Label cardSubtitle = new Label("Enter the details of the tenant you want to remove");
        cardSubtitle.setStyle( "-fx-font-size: 12px;-fx-text-fill: #546E7A;" );

        VBox cardHeading = new VBox(  4, cardTitle,cardSubtitle );
        GridPane form = new GridPane();
        form.setHgap(30);
        form.setVgap(15);


        Label nameLabel = new Label( "Tenant Name" );
        TextField nameField = new TextField();
        nameField.setPromptText("Enter tenant name" );

       
        Label flatLabel = new Label( "Flat / Unit Number" );
         TextField flatField = new TextField();
        flatField.setPromptText("Enter flat number");

        Label dateLabel = new Label( "Move-out Date" );
        TextField dateField = new TextField();
        dateField.setPromptText("Enter move-out date");

        
        Label reasonLabel = new Label("Reason");
        TextField reasonField = new TextField();
        reasonField.setPromptText( "Enter reason");

       
        nameField.setPrefWidth(380);
        flatField.setPrefWidth(380);

        dateField.setPrefWidth(380);
        reasonField.setPrefWidth(380);

        nameField.setPrefHeight(40);
        flatField.setPrefHeight(40);

        dateField.setPrefHeight(40);
        reasonField.setPrefHeight(40);

        styleLabel(nameLabel);
        styleLabel(flatLabel);
        styleLabel(dateLabel);
        styleLabel(reasonLabel);

        
        String fieldStyle ="-fx-background-color: white;-fx-border-color: #CBD5D8;-fx-border-radius: 6;-fx-background-radius: 6;";

        nameField.setStyle(fieldStyle);
        flatField.setStyle(fieldStyle);

        dateField.setStyle(fieldStyle);
        reasonField.setStyle(fieldStyle);

        
        form.add( nameLabel, 0, 0);
        form.add(flatLabel,1,0 );
        form.add(nameField,0,1 );
        form.add( flatField,1,1 );
        form.add( dateLabel, 0, 2 );
        form.add(reasonLabel, 1, 2 );
        form.add(dateField,0,3 );
        form.add( reasonField, 1, 3);

        
        Button clearButton = new Button("Clear");
        Button removeButton =new Button("Remove Tenant");

        clearButton.setPrefWidth(110);
        clearButton.setPrefHeight(40);

        removeButton.setPrefWidth(140);
        removeButton.setPrefHeight(40);

        clearButton.setStyle("-fx-background-color: #b3adad;-fx-text-fill: #434141;-fx-font-weight: bold;-fx-background-radius: 7;");
        removeButton.setStyle("-fx-background-color: #434141;-fx-text-fill: #b3adad;-fx-font-weight: bold;-fx-background-radius: 7;");

        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.setAlignment( Pos.CENTER_RIGHT );

        buttons.getChildren().addAll(
                clearButton,
                removeButton
        );


        tenantCard.getChildren().addAll(
                cardHeading,
                form,
                buttons
        );

        Label information = new Label(  "Please verify the tenant name and flat number before removing the tenant.");
        information.setPadding( new Insets(14));
        information.setMaxWidth( 1000);
        information.setStyle( "-fx-background-color: #E8F1F2;-fx-background-radius: 8;-fx-text-fill: #263238;");

        mainContent.getChildren().addAll(
                heading,
                tenantCard,
                information
        );
        root.setCenter( mainContent );
        return new Scene(
                root,
                1500,
                750
        );
    }

         private static void styleLabel( Label label
    ) { label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #37474F;"
        );
    }
}