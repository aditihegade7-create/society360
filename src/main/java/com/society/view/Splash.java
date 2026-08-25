package com.society.view;
import com.society.view.Owner_portal.OwnerDashboard;
import com.society.view.Resident_portal.ResidentDashboard;

import javafx.application.Application;

import javafx.stage.Stage;
public class Splash extends Application {

    public static Stage stage;
    ResidentDashboard residentDashboard=new ResidentDashboard();
     

    @Override
    public void start(Stage stage) throws Exception {
       stage.setTitle( "Society360 - Owner Portal" );
       stage.setScene(residentDashboard.getResidentDashboardScene(stage));
       stage.show();
    }
}
