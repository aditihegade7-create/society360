package com.society.view;

// import com.society.view.Guard_portal.GuardDashboard;
import com.society.view.Secretary_portal.SecretaryDashboard;

import javafx.application.Application;
import javafx.stage.Stage;

public class Splash extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {

        SecretaryDashboard dashboard = new SecretaryDashboard();
        stage.setScene(dashboard.createScene(stage));
        stage.show();

        // stage.setScene(GuardDashboard.createScene(stage));
        // stage.show();
    }
}
