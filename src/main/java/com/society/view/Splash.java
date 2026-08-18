package com.society.view;

import com.society.view.Welcome.LogInPage;

import javafx.application.Application;
import javafx.stage.Stage;

public class Splash extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       LogInPage logInPage = new LogInPage();
       stage.setScene(logInPage.createScene(stage));
       stage.show();
    }



}

