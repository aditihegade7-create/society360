package com.society.view;
import com.society.view.Authentication.LoginPage;
import com.society.view.Owner_portal.OwnerDashboard;
import com.society.view.Resident_portal.ResidentDashboard;
import com.society.view.Secretary_portal.SecretaryDashboard;
import com.society.view.Welcome.LogInPage;

import javafx.application.Application;

import javafx.stage.Stage;
public class Splash extends Application {

    public static Stage stage;
    SecretaryDashboard secretaryDashboard = new SecretaryDashboard();
        LogInPage loginpage=new LogInPage();


    @Override
    public void start(Stage stage) throws Exception {
       stage.setTitle( "Society360 - Owner Portal" );
       stage.setScene(secretaryDashboard.createScene(stage));
       stage.show();
    }
}
