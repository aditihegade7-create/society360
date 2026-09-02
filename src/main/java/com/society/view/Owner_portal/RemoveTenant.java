package com.society.view.Owner_portal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

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

       Image image = new Image(
        RemoveTenant.class.getResource("/background-Dashboard5.jpeg").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, false, true)
        );

        mainContent.setBackground(new Background(backgroundImage));
        
        
        HBox header = new HBox();
        header.setPrefWidth(900);
        header.setPrefHeight(80);
        header.setPadding(new Insets(20));
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-background-color: #4e342e;");

        VBox vb = new VBox();
        Label greeting = new Label("Remove Tenant");
        greeting.setStyle("-fx-font-size:24px;-fx-font-weight:bold;-fx-text-fill: #ffffff;");

        Label description = new Label("Remove an existing tenant from your property");
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


        VBox tenantCard = new VBox();
        tenantCard.setPadding( new Insets(25)
        );
        tenantCard.setSpacing(20);
        tenantCard.setMaxWidth( 1000 );

        tenantCard.setStyle( "-fx-background-color: #a47970;-fx-background-radius: 12;" );

       
        Label cardTitle = new Label( "Tenant Details"  );
       cardTitle.setStyle("-fx-font-size: 18px;-fx-font-weight: bold;-fx-text-fill: #102A43;" );

        Label cardSubtitle = new Label("Enter the details of the tenant you want to remove");
        cardSubtitle.setStyle( "-fx-font-size: 12px;-fx-text-fill: #102A43;" );

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

        Label moveOutLabel = new Label("Move-Out Date");
        DatePicker moveOutDate =new DatePicker();
        moveOutDate.setPromptText("Select date" );
        moveOutDate.setPrefWidth(320);
        moveOutDate.setPrefHeight(38);


        
        Label reasonLabel = new Label("Reason");
        TextField reasonField = new TextField();
        reasonField.setPromptText( "Enter reason");

       
        nameField.setPrefWidth(380);
        flatField.setPrefWidth(380);

        moveOutDate.setPrefWidth(380);
        reasonField.setPrefWidth(380);

        nameField.setPrefHeight(40);
        flatField.setPrefHeight(40);

        moveOutDate.setPrefHeight(40);
        reasonField.setPrefHeight(40);

        styleLabel(nameLabel);
        styleLabel(flatLabel);
        styleLabel(moveOutLabel);
        styleLabel(reasonLabel);

        
        String fieldStyle ="-fx-background-color: white;-fx-border-color: #CBD5D8;-fx-border-radius: 6;-fx-background-radius: 6;";

        nameField.setStyle(fieldStyle);
        flatField.setStyle(fieldStyle);

        moveOutDate.setStyle(fieldStyle);
        reasonField.setStyle(fieldStyle);

        
        form.add( nameLabel, 0, 0);
        form.add(flatLabel,1,0 );
        form.add(nameField,0,1 );
        form.add( flatField,1,1 );
        form.add( moveOutLabel, 0, 2 );
        form.add(reasonLabel, 1, 2 );
        form.add(moveOutDate,0,3 );
        form.add( reasonField, 1, 3);

        
        Button clearButton = new Button("Clear");
        Button removeButton =new Button("Remove Tenant");

        clearButton.setPrefWidth(110);
        clearButton.setPrefHeight(40);

        removeButton.setPrefWidth(140);
        removeButton.setPrefHeight(40);

        clearButton.setStyle("-fx-background-color: #ffffff;-fx-text-fill: #4e342e;-fx-font-weight: bold;-fx-background-radius: 7;");
        removeButton.setStyle("-fx-background-color: #4e342e;-fx-text-fill: #ffffff;-fx-font-weight: bold;-fx-background-radius: 7;");

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

        Label information = new Label("*Please verify the tenant name and flat number before removing the tenant.");
        information.setPadding( new Insets(14));
        information.setMaxWidth( 1000);
        information.setStyle( "-fx-background-color: #E8F1F2;-fx-background-radius: 8;-fx-text-fill: #263238;");

        mainContent.getChildren().addAll(
                header,
                tenantCard,
                information
        );

        // ===== REMOVE TENANT ANIMATION =====

        animateHeader(header);

        animateTenantCard(tenantCard);

        animateInformation(information);

        animateButton(clearButton);

        animateButton(removeButton);


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

         private static void styleLabel( Label label
    ) { label.setStyle(
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #37474F;"
        );
    }

    // ================= HEADER ANIMATION =================

private static void animateHeader(HBox header) {

    header.setOpacity(0);

    FadeTransition fade = new FadeTransition(
            Duration.millis(600),
            header
    );

    fade.setFromValue(0);
    fade.setToValue(1);

    fade.play();
}


// ================= TENANT CARD ANIMATION =================

private static void animateTenantCard(VBox card) {

    card.setOpacity(0);

    FadeTransition fade = new FadeTransition(
            Duration.millis(700),
            card
    );

    fade.setFromValue(0);
    fade.setToValue(1);
    fade.setDelay(Duration.millis(200));

    fade.play();
}


// ================= INFORMATION ANIMATION =================

private static void animateInformation(Label information) {

    information.setOpacity(0);

    FadeTransition fade = new FadeTransition(
            Duration.millis(600),
            information
    );

    fade.setFromValue(0);
    fade.setToValue(1);
    fade.setDelay(Duration.millis(500));

    fade.play();
}


// ================= BUTTON HOVER ANIMATION =================

private static void animateButton(Button button) {

    button.setOnMouseEntered(e -> {

        if (!button.isDisabled()) {

            ScaleTransition scale = new ScaleTransition(
                    Duration.millis(120),
                    button
            );

            scale.setToX(1.05);
            scale.setToY(1.05);

            scale.play();
        }
    });

    button.setOnMouseExited(e -> {

        ScaleTransition scale = new ScaleTransition(
                Duration.millis(120),
                button
        );

        scale.setToX(1.0);
        scale.setToY(1.0);

        scale.play();
    });
}
}