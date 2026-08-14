package com.society.view;

import com.society.view.Secretary_portal.SecretaryDashboard;

import javafx.application.Application;
import javafx.stage.Stage;

public class Splash extends Application{
    public static String stage;
    @Override
    public void start(Stage stage) {
        SecretaryDashboard dashboard = new SecretaryDashboard();
        stage.setScene(dashboard.creatScene());
        stage.setTitle("Society360 - Secretary Dashboard");
        
        stage.show();

}
}