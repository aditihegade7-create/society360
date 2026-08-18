package com.society.view.Owner_portal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddTenant {

    public static Scene createScene(Stage stage) {
    BorderPane root = new BorderPane();
    OwnerSidebar sidebar =new OwnerSidebar(stage);
    root.setLeft(sidebar.getSidebar());

    VBox mainContent = new VBox();
    mainContent.setPadding( new Insets(25, 35, 25, 35));
    mainContent.setSpacing(18);
    mainContent.setAlignment(Pos.TOP_LEFT);
    mainContent.setStyle("-fx-background-color: #e8ddd5;" );

    HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox vb = new VBox();
        Label greeting = new Label("Add Tenant");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        Label description = new Label("Add and manage tenant details for your property");
        description.setStyle("-fx-font-size:12px;-fx-text-fill: #ffffff;");

        vb.getChildren().addAll(greeting,description);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        

        Label day = new Label();
        Label date = new Label();

        LocalDate today = LocalDate.now();

        day.setText(today.format(
                DateTimeFormatter.ofPattern("EEEE")));
        day.setStyle("-fx-text-fill: #ffffff");        

        date.setText(today.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy")));
         date.setStyle("-fx-text-fill: #ffffff"); 
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(day, date);

        header.getChildren().addAll(vb,
                spacer,
                vb1);

        VBox formCard = new VBox();

        formCard.setPadding( new Insets(20, 25, 20, 25));
        formCard.setSpacing(15);
        formCard.setMaxWidth( 1050);
        formCard.setStyle( "-fx-background-color: #efeff3;-fx-background-radius: 12;" );

        
        Label formTitle = new Label("Tenant Information" );
        formTitle.setStyle( "-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #102A43;" );

        Label formSubtitle = new Label("Please provide the required tenant details");
        formSubtitle.setStyle("-fx-font-size: 12px;-fx-text-fill: #546E7A;");

        VBox formHeading = new VBox( 3, formTitle, formSubtitle);
        GridPane form = new GridPane();
        form.setHgap(25);
        form.setVgap(10);

        
        Label nameLabel = createLabel("Full Name");
        TextField nameField = createField("Enter full name");
        Label phoneLabel = createLabel("Phone Number");
        TextField phoneField = createField("Enter phone number");


        Label emailLabel = createLabel("Email");
        TextField emailField = createField("Enter email address");


        Label flatLabel = createLabel("Flat / Unit Number");
        TextField flatField =createField("Enter flat number");


        Label moveInLabel = createLabel("Move-in Date");
        DatePicker moveInDate =new DatePicker();
        moveInDate.setPromptText("Select date" );
        moveInDate.setPrefWidth(320);
        moveInDate.setPrefHeight(38);


        Label rentLabel = createLabel("Monthly Rent");
        TextField rentField = createField("Enter monthly rent");

        Label depositLabel = createLabel("Security Deposit");
        TextField depositField =createField("Enter security deposit");


        Label idLabel = createLabel("ID Proof Number");
        TextField idField =createField("Enter ID proof number");


        Label emergencyLabel = createLabel("Emergency Contact");
        TextField emergencyField = createField("Enter emergency contact");

        form.add( nameLabel, 0, 0 );
        form.add( phoneLabel,1,0 );
        form.add( nameField,0,1);
        form.add( phoneField, 1, 1 );
        form.add( emailLabel,0,2);
        form.add(flatLabel, 1, 2 );
        form.add( emailField, 0, 3 );
        form.add( flatField, 1,3);
        form.add( moveInLabel, 0, 4);
        form.add( rentLabel, 1, 4 );
        form.add( moveInDate, 0, 5 );
        form.add( rentField, 1, 5 );
        form.add( depositLabel, 0, 6 );
        form.add( idLabel, 1, 6 );
        form.add( depositField, 0, 7 );
        form.add( idField, 1, 7 );
        form.add( emergencyLabel, 0, 8 );
        form.add( emergencyField, 0, 9 );

        
        Label remarksLabel = createLabel("Remarks");
        TextArea remarksArea = new TextArea();
        remarksArea.setPromptText("Enter any additional information" );
        remarksArea.setPrefHeight(55);
        remarksArea.setWrapText(true);
        remarksArea.setStyle( "-fx-background-color: white;-fx-border-color: #CBD5D8;-fx-border-radius: 6;-fx-background-radius: 6;" );

        form.add( remarksLabel, 1, 8);
        form.add( remarksArea, 1, 9 );

        Button clearButton = new Button("Clear");
        Button saveButton = new Button("Save Tenant");
        clearButton.setPrefWidth(100);
        clearButton.setPrefHeight(38);
        saveButton.setPrefWidth(125);
        saveButton.setPrefHeight(38);
        clearButton.setStyle("-fx-background-color: #ffffff;-fx-text-fill: #4e342e;-fx-font-weight: bold;-fx-background-radius: 7;" );
        saveButton.setStyle("-fx-background-color: #4e342e;-fx-text-fill: #ffffff;-fx-font-weight: bold;-fx-background-radius: 7;" );

        HBox buttons = new HBox();
        buttons.setSpacing(12);
        buttons.setAlignment(Pos.CENTER_RIGHT );

        buttons.getChildren().addAll(
                clearButton,
                saveButton
        );

       
         formCard.getChildren().addAll(
                formHeading,
                form,
                buttons
        );

       
        mainContent.getChildren().addAll(
                header,
                formCard
        );

       
       BorderPane mainarea = new BorderPane();
       mainarea.setTop(header);
       mainarea.setCenter(mainContent);
       root.setCenter(mainarea);
       
        return new Scene(
                root,
                1500,
                750
        );
    }

   
    private static Label createLabel( String text
    ) {
        Label label = new Label(text);
        label.setStyle( "-fx-font-size: 12px;-fx-font-weight: bold;-fx-text-fill: #37474F;" );
        return label;
    }

      private static TextField createField( String prompt
    ) {
        TextField field =new TextField();
        field.setPromptText( prompt  );
        field.setPrefWidth(320);
        field.setPrefHeight(38);
        field.setStyle("-fx-background-color: white;-fx-border-color: #CBD5D8;-fx-border-radius: 6;-fx-background-radius: 6;" );

        return field;
    }
}