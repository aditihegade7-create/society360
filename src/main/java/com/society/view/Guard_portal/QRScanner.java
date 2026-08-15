package com.society.view.Guard_portal;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QRScanner {

    public static Scene createScene(Stage stage) {

        BorderPane root = new BorderPane();
        GuardSidebar sidebar = new GuardSidebar(stage, "QR Scanner");

        root.setLeft(sidebar.getSidebar());

        VBox root1 = new VBox();

        root1.setSpacing(20);
        root1.setAlignment(Pos.CENTER);

        root1.setStyle(
                "-fx-background-color: #789098;"
        );

        Label title = new Label("QR Scanner");

        title.setStyle(
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #102A43;"
        );

        Label message = new Label(
                "QR Scanner will be available here."
        );

        Button backButton = new Button("Back to Dashboard");

        backButton.setOnAction(e -> {
            stage.setScene(
                    GuardDashboard.createScene(stage)
            );
        });

        root1.getChildren().addAll(
                title,
                message,
                backButton
        );

        return new Scene(root1, 1500, 750);
    }
}
