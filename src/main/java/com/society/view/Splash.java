package com.society.view;


import com.society.view.Owner_portal.OwnerDashboard;

import javafx.application.Application;

import javafx.stage.Stage;
public class Splash extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
            stage.setTitle("Society360 - Owner Portal");
            OwnerDashboard dashboard = new OwnerDashboard();
            stage.setScene(dashboard.createScene(stage));
       stage.show();
    }

}