package com.society.view;


import com.society.view.Resident_portal.ResidentDashboard;

import javafx.application.Application;
import javafx.stage.Stage;

public class Splash extends Application{
 
    @Override
    public void start(Stage stage) throws Exception {
        
 ResidentDashboard residentDashboard = new ResidentDashboard();
    stage.setScene(residentDashboard.getResidentDashboardScene(stage));
    
    stage.show();
    }
}





