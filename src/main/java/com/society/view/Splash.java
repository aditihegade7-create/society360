
package com.society.view;

import com.society.view.Guard_portal.GuardDashboard;

import javafx.application.Application;
import javafx.stage.Stage;

public class Splash extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(GuardDashboard.createScene(stage));
        stage.show();
    }
}