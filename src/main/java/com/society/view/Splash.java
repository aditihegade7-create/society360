package com.society.view;
import com.society.view.Welcome.LogInPage;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;

import javafx.application.Application;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.stage.Stage;
import javafx.util.Duration;


public class Splash extends Application {

    // =========================================================
    // COLORS
    // =========================================================

    private static final String DARK_BROWN = "#4E342E";
    private static final String BROWN = "#6D4C41";
    private static final String GOLD = "#B8895A";


    // =========================================================
    // START
    // =========================================================

    @Override
    public void start(Stage stage) {

        // =====================================================
        // ROOT
        // =====================================================

        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom, "
                        + "#FFFDF9, #E8DDD5);"
        );


        // =====================================================
        // ANIMATION PANE
        // =====================================================

        StackPane animationPane = new StackPane();

        animationPane.setPrefSize(600, 600);


        // =====================================================
        // OUTER CIRCLE
        // =====================================================

        Circle outerCircle = new Circle(145);

        outerCircle.setFill(Color.TRANSPARENT);

        outerCircle.setStroke(Color.web(GOLD));

        outerCircle.setStrokeWidth(5);

        outerCircle.setOpacity(0);


        // =====================================================
        // BUILDING
        // =====================================================

        StackPane building = createBuilding();

        building.setOpacity(0);

        building.setScaleX(0.5);

        building.setScaleY(0.5);


        // =====================================================
        // DOTS
        // =====================================================

        Circle dot1 = createDot(0, -145);
        Circle dot2 = createDot(125, -70);
        Circle dot3 = createDot(120, 80);
        Circle dot4 = createDot(-120, 80);
        Circle dot5 = createDot(-125, -70);

        dot1.setOpacity(0);
        dot2.setOpacity(0);
        dot3.setOpacity(0);
        dot4.setOpacity(0);
        dot5.setOpacity(0);


        // =====================================================
        // LOGO TEXT
        // =====================================================

        Label societyText = new Label("Society");

        societyText.setFont(
                Font.font("Arial", FontWeight.BOLD, 42)
        );

        societyText.setTextFill(
                Color.web(DARK_BROWN)
        );


        Label numberText = new Label("360");

        numberText.setFont(
                Font.font("Arial", FontWeight.BOLD, 42)
        );

        numberText.setTextFill(
                Color.web(GOLD)
        );


        HBox logoText = new HBox(
                0,
                societyText,
                numberText
        );

        logoText.setAlignment(Pos.CENTER);

        logoText.setOpacity(0);


        // =====================================================
        // TAGLINE
        // =====================================================

        Label tagline = new Label(
                "Manage. Connect. Simplify."
        );

        tagline.setFont(
                Font.font("Arial", 16)
        );

        tagline.setTextFill(
                Color.web(BROWN)
        );

        tagline.setOpacity(0);


        // =====================================================
        // ADD ANIMATION ELEMENTS
        // =====================================================

        animationPane.getChildren().addAll(
                outerCircle,
                dot1,
                dot2,
                dot3,
                dot4,
                dot5,
                building
        );


        // =====================================================
        // COMPLETE LOGO
        // =====================================================

        VBox completeLogo = new VBox(
                12,
                animationPane,
                logoText,
                tagline
        );

        completeLogo.setAlignment(Pos.CENTER);


        root.getChildren().add(completeLogo);


        // =====================================================
        // SCENE
        // =====================================================

        Scene scene = new Scene(
                root,
                1100,
                700
        );


        stage.setTitle("Society360");

        stage.setScene(scene);

        stage.show();


        // =====================================================
        // START ANIMATION
        // =====================================================

        animateSplash(
                stage,
                outerCircle,
                building,
                dot1,
                dot2,
                dot3,
                dot4,
                dot5,
                logoText,
                tagline
        );
    }


    // =========================================================
    // CREATE BUILDING
    // =========================================================

    private StackPane createBuilding() {

        StackPane building = new StackPane();


        // =====================================================
        // MAIN BUILDING
        // =====================================================

        Rectangle mainBuilding = new Rectangle(
                120,
                190
        );

        mainBuilding.setArcWidth(8);

        mainBuilding.setArcHeight(8);

        mainBuilding.setFill(
                Color.web(DARK_BROWN)
        );


        // =====================================================
        // LEFT BUILDING
        // =====================================================

        Rectangle leftBuilding = new Rectangle(
                70,
                125
        );

        leftBuilding.setFill(
                Color.web(BROWN)
        );

        leftBuilding.setTranslateX(-75);

        leftBuilding.setTranslateY(32);


        // =====================================================
        // RIGHT BUILDING
        // =====================================================

        Rectangle rightBuilding = new Rectangle(
                70,
                125
        );

        rightBuilding.setFill(
                Color.web(BROWN)
        );

        rightBuilding.setTranslateX(75);

        rightBuilding.setTranslateY(32);


        // =====================================================
        // WINDOWS
        // =====================================================

        javafx.scene.layout.GridPane windows =
                new javafx.scene.layout.GridPane();

        windows.setHgap(18);

        windows.setVgap(13);

        windows.setAlignment(Pos.CENTER);


        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 2; col++) {

                Rectangle window = new Rectangle(
                        15,
                        18
                );

                window.setFill(
                        Color.web("#F6D69A")
                );

                windows.add(
                        window,
                        col,
                        row
                );
            }
        }


        // =====================================================
        // DOOR
        // =====================================================

        Rectangle door = new Rectangle(
                28,
                45
        );

        door.setFill(
                Color.web("#2D1C17")
        );

        door.setTranslateY(72);


        // =====================================================
        // ADD BUILDING ELEMENTS
        // =====================================================

        building.getChildren().addAll(
                leftBuilding,
                rightBuilding,
                mainBuilding,
                windows,
                door
        );


        return building;
    }


    // =========================================================
    // CREATE DOT
    // =========================================================

    private Circle createDot(
            double x,
            double y
    ) {

        Circle dot = new Circle(6);

        dot.setFill(
                Color.web(GOLD)
        );

        dot.setTranslateX(x);

        dot.setTranslateY(y);

        return dot;
    }


    // =========================================================
    // ANIMATION
    // =========================================================

    private void animateSplash(
            Stage stage,
            Circle circle,
            StackPane building,
            Circle dot1,
            Circle dot2,
            Circle dot3,
            Circle dot4,
            Circle dot5,
            HBox logoText,
            Label tagline
    ) {

        // =====================================================
        // CIRCLE FADE
        // =====================================================

        FadeTransition circleFade =
                new FadeTransition(
                        Duration.seconds(0.5),
                        circle
                );

        circleFade.setFromValue(0);

        circleFade.setToValue(1);


        // =====================================================
        // BUILDING FADE
        // =====================================================

        FadeTransition buildingFade =
                new FadeTransition(
                        Duration.seconds(0.4),
                        building
                );

        buildingFade.setFromValue(0);

        buildingFade.setToValue(1);


        // =====================================================
        // BUILDING SCALE
        // =====================================================

        ScaleTransition buildingScale =
                new ScaleTransition(
                        Duration.seconds(0.5),
                        building
                );

        buildingScale.setFromX(0.5);

        buildingScale.setFromY(0.5);

        buildingScale.setToX(1);

        buildingScale.setToY(1);


        ParallelTransition buildingAnimation =
                new ParallelTransition(
                        buildingFade,
                        buildingScale
                );


        // =====================================================
        // CIRCLE ROTATION
        // =====================================================

        RotateTransition rotate =
                new RotateTransition(
                        Duration.seconds(0.9),
                        circle
                );

        rotate.setByAngle(360);


        // =====================================================
        // DOT ANIMATIONS
        // =====================================================

        FadeTransition dotFade1 =
                createDotFade(dot1);

        FadeTransition dotFade2 =
                createDotFade(dot2);

        FadeTransition dotFade3 =
                createDotFade(dot3);

        FadeTransition dotFade4 =
                createDotFade(dot4);

        FadeTransition dotFade5 =
                createDotFade(dot5);


        ParallelTransition dots =
                new ParallelTransition(
                        dotFade1,
                        dotFade2,
                        dotFade3,
                        dotFade4,
                        dotFade5
                );


        // =====================================================
        // TEXT
        // =====================================================

        FadeTransition textFade =
                new FadeTransition(
                        Duration.seconds(0.5),
                        logoText
                );

        textFade.setFromValue(0);

        textFade.setToValue(1);


        // =====================================================
        // TAGLINE
        // =====================================================

        FadeTransition taglineFade =
                new FadeTransition(
                        Duration.seconds(0.4),
                        tagline
                );

        taglineFade.setFromValue(0);

        taglineFade.setToValue(1);


        // =====================================================
        // COMPLETE ANIMATION
        // =====================================================

        SequentialTransition animation =
                new SequentialTransition(
                        circleFade,
                        buildingAnimation,
                        rotate,
                        dots,
                        textFade,
                        taglineFade
                );


        // =====================================================
        // OPEN LOGIN PAGE
        // =====================================================

        animation.setOnFinished(event -> {

            PauseTransition pause =
                    new PauseTransition(
                            Duration.seconds(0.5)
                    );

            pause.setOnFinished(e -> {

                LogInPage loginPage =
                        new LogInPage();

                stage.setScene(
                        loginPage.createScene(stage)
                );

                stage.show();
            });

            pause.play();
        });


        animation.play();
    }


    // =========================================================
    // DOT FADE HELPER
    // =========================================================

    private FadeTransition createDotFade(Circle dot) {

        FadeTransition fade =
                new FadeTransition(
                        Duration.seconds(0.3),
                        dot
                );

        fade.setFromValue(0);

        fade.setToValue(1);

        return fade;
    }


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        launch(args);
    }
}
