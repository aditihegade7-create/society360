package com.society.view.Secretary_portal;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManageOwner {
    public Scene createScene(Stage stage) {
       SecretarySidebar sidebarObj = new SecretarySidebar();
        VBox sidebar = sidebarObj.createSidebar(stage);

        HBox root = new HBox();
        root.getChildren().addAll(sidebar);
        
        Scene scene = new Scene(root,1500,750);
        return scene;
    }
}
