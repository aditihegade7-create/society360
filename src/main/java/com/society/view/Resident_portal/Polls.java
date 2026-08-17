
package com.society.view.Resident_portal;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



    
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;


public class Polls {

    public Scene getPollScene(Stage stage) {
          panel panelobj = new panel(stage);
          

        // =========================================================
        // MAIN ROOT
        // =========================================================

        BorderPane root = new BorderPane();
        

        root.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.web("#b3adad"),
                                CornerRadii.EMPTY,
                                Insets.EMPTY
                        )
                )
        );

root.setLeft(panelobj.getSidebar());
        // =========================================================
        // PAGE TITLE
        // =========================================================

        Label title = new Label("Polls & Surveys");

        title.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        28
                )
        );

        title.setTextFill(Color.BLACK);

        Label subtitle = new Label(
                "Share your opinion and help improve our society"
        );

        subtitle.setFont(
                Font.font(
                        "Arial",
                        14
                )
        );

        subtitle.setTextFill(Color.BLACK);


        VBox header = new VBox(5);

        header.setPadding(
                new Insets(25, 30, 15, 30)
        );

        header.getChildren().addAll(
                title,
                subtitle
        );


        // =========================================================
        // POLLS CONTAINER
        // =========================================================

        VBox pollsContainer = new VBox(20);

        pollsContainer.setPadding(
                new Insets(10, 30, 30, 30)
        );


        // =========================================================
        // POLL 1
        // =========================================================

        VBox poll1 = createPoll(
                "Which facility should be improved first?",
                "Swimming Pool",
                "Gym",
                "Children's Play Area",
                "Community Hall"
        );


        // =========================================================
        // POLL 2
        // =========================================================

        VBox poll2 = createPoll(
                "What should be the preferred timing for the gym?",
                "6:00 AM - 9:00 AM",
                "9:00 AM - 12:00 PM",
                "4:00 PM - 7:00 PM",
                "7:00 PM - 10:00 PM"
        );


        // =========================================================
        // SURVEY
        // =========================================================

        VBox survey = createSurvey(
                "How satisfied are you with the society's overall services?"
        );


        pollsContainer.getChildren().addAll(
                poll1,
                poll2,
                survey
        );


          VBox mainContant = new VBox();
        mainContant.setPadding(new Insets(20));
        mainContant.getChildren().addAll(header,pollsContainer);

ScrollPane scrollPane = new ScrollPane(mainContant);
scrollPane.setFitToWidth(true);
scrollPane.setFitToHeight(false);

scrollPane.setVbarPolicy(
        ScrollPane.ScrollBarPolicy.AS_NEEDED
);
 scrollPane.setHbarPolicy(
        ScrollPane.ScrollBarPolicy.NEVER
 );
 scrollPane.setStyle("-fx-background-color: #b3adad");
 






        // =========================================================
        // PUT CONTENT INTO ROOT
        // =========================================================

root.setCenter(scrollPane);        


        // =========================================================
        // SCENE
        // =========================================================

        return new Scene(
                root,
                1200,
                700
        );
    }


    // =============================================================
    // CREATE POLL METHOD
    // =============================================================

    private VBox createPoll(
            String question,
            String option1,
            String option2,
            String option3,
            String option4
    ) {

        // Main poll card
        VBox pollBox = new VBox(12);

        pollBox.setPadding(
                new Insets(20)
        );

        pollBox.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(10),
                                Insets.EMPTY
                        )
                )
        );


        // =========================================================
        // QUESTION
        // =========================================================

        Label questionLabel = new Label(question);

        questionLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        17
                )
        );

        questionLabel.setTextFill(
                Color.web("#070d10")
        );


        // =========================================================
        // RADIO BUTTONS
        // =========================================================

        RadioButton optionButton1 =
                new RadioButton(option1);

        RadioButton optionButton2 =
                new RadioButton(option2);

        RadioButton optionButton3 =
                new RadioButton(option3);

        RadioButton optionButton4 =
                new RadioButton(option4);


        // =========================================================
        // TOGGLE GROUP
        // =========================================================

        ToggleGroup group = new ToggleGroup();

        optionButton1.setToggleGroup(group);
        optionButton2.setToggleGroup(group);
        optionButton3.setToggleGroup(group);
        optionButton4.setToggleGroup(group);


        // =========================================================
        // MAKE TEXT VISIBLE
        // =========================================================

        optionButton1.setTextFill(Color.BLACK);
        optionButton2.setTextFill(Color.BLACK);
        optionButton3.setTextFill(Color.BLACK);
        optionButton4.setTextFill(Color.BLACK);


        optionButton1.setFont(
                Font.font("Arial", 14)
        );

        optionButton2.setFont(
                Font.font("Arial", 14)
        );

        optionButton3.setFont(
                Font.font("Arial", 14)
        );

        optionButton4.setFont(
                Font.font("Arial", 14)
        );


        // =========================================================
        // SUBMIT BUTTON
        // =========================================================

        Button submitButton =
                new Button("Submit Vote");

        submitButton.setPrefWidth(130);
        submitButton.setPrefHeight(35);

        submitButton.setStyle(
                "-fx-background-color: #0B4F8A;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );


        // =========================================================
        // RESULT LABEL
        // =========================================================

        Label resultLabel =
                new Label("");

        resultLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        resultLabel.setTextFill(
                Color.web("#2E7D32")
        );


        // =========================================================
        // SUBMIT ACTION
        // =========================================================

        submitButton.setOnAction(event -> {

            if (group.getSelectedToggle() == null) {

                resultLabel.setText(
                        "Please select an option."
                );

            } else {

                RadioButton selected =
                        (RadioButton) group.getSelectedToggle();

                resultLabel.setText(
                        "Your vote: " + selected.getText()
                );
            }
        });


        // =========================================================
        // ADD EVERYTHING
        // =========================================================

        pollBox.getChildren().addAll(
                questionLabel,
                optionButton1,
                optionButton2,
                optionButton3,
                optionButton4,
                submitButton,
                resultLabel
        );


        return pollBox;
    }


    // =============================================================
    // CREATE SURVEY METHOD
    // =============================================================

    private VBox createSurvey(String question) {

        VBox surveyBox = new VBox(12);

        surveyBox.setPadding(
                new Insets(20)
        );

        surveyBox.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(10),
                                Insets.EMPTY
                        )
                )
        );


        // =========================================================
        // SURVEY TITLE
        // =========================================================

        Label surveyTitle =
                new Label("Community Survey");

        surveyTitle.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        19
                )
        );

        surveyTitle.setTextFill(
                Color.web("#0B4F8A")
        );


        // =========================================================
        // QUESTION
        // =========================================================

        Label questionLabel =
                new Label(question);

        questionLabel.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        16
                )
        );

        questionLabel.setTextFill(
                Color.BLACK
        );


        // =========================================================
        // SURVEY OPTIONS
        // =========================================================

        RadioButton verySatisfied =
                new RadioButton("Very Satisfied");

        RadioButton satisfied =
                new RadioButton("Satisfied");

        RadioButton neutral =
                new RadioButton("Neutral");

        RadioButton dissatisfied =
                new RadioButton("Dissatisfied");

        RadioButton veryDissatisfied =
                new RadioButton("Very Dissatisfied");


        // =========================================================
        // TOGGLE GROUP
        // =========================================================

        ToggleGroup surveyGroup =
                new ToggleGroup();

        verySatisfied.setToggleGroup(surveyGroup);
        satisfied.setToggleGroup(surveyGroup);
        neutral.setToggleGroup(surveyGroup);
        dissatisfied.setToggleGroup(surveyGroup);
        veryDissatisfied.setToggleGroup(surveyGroup);


        // =========================================================
        // MAKE TEXT VISIBLE
        // =========================================================

        verySatisfied.setTextFill(Color.BLACK);
        satisfied.setTextFill(Color.BLACK);
        neutral.setTextFill(Color.BLACK);
        dissatisfied.setTextFill(Color.BLACK);
        veryDissatisfied.setTextFill(Color.BLACK);


        verySatisfied.setFont(Font.font("Arial", 14));
        satisfied.setFont(Font.font("Arial", 14));
        neutral.setFont(Font.font("Arial", 14));
        dissatisfied.setFont(Font.font("Arial", 14));
        veryDissatisfied.setFont(Font.font("Arial", 14));


        // =========================================================
        // SUBMIT SURVEY
        // =========================================================

        Button submitSurvey =
                new Button("Submit Survey");

        submitSurvey.setPrefWidth(140);
        submitSurvey.setPrefHeight(35);

        submitSurvey.setStyle(
                "-fx-background-color: #0B4F8A;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );


        Label surveyResult =
                new Label("");

        surveyResult.setFont(
                Font.font(
                        "Arial",
                        FontWeight.BOLD,
                        13
                )
        );

        surveyResult.setTextFill(
                Color.web("#2E7D32")
        );


        submitSurvey.setOnAction(event -> {

            if (surveyGroup.getSelectedToggle() == null) {

                surveyResult.setText(
                        "Please select an option."
                );

            } else {

                RadioButton selected =
                        (RadioButton) surveyGroup.getSelectedToggle();

                surveyResult.setText(
                        "Response submitted: "
                                + selected.getText()
                );
            }
        });





       
        // =========================================================
        // ADD EVERYTHING
        // =========================================================

        surveyBox.getChildren().addAll(
                surveyTitle,
                questionLabel,
                verySatisfied,
                satisfied,
                neutral,
                dissatisfied,
                veryDissatisfied,
                submitSurvey,
                surveyResult
        );

ScrollPane scrollPane = new ScrollPane();
scrollPane.setFitToWidth(true);
scrollPane.setFitToHeight(false);

scrollPane.setVbarPolicy(
        ScrollPane.ScrollBarPolicy.AS_NEEDED
);
 scrollPane.setHbarPolicy(
        ScrollPane.ScrollBarPolicy.NEVER
 );
 scrollPane.setStyle("-fx-background-color: #b3adad");
 

    


        return surveyBox;
    }
}