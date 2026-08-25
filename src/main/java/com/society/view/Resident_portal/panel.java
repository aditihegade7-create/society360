package com.society.view.Resident_portal;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class panel {
    //sidebar menu buttons
    private VBox sidebar ;

    public  panel(Stage stage){
        sidebar = new VBox();


 
        sidebar.setPrefWidth(280);
        sidebar.setPrefHeight(750);
        sidebar.setStyle("-fx-background-color: #593a32");
        sidebar.setSpacing(14);
        sidebar.setPadding(new Insets(20));
    


        Label logo = new Label("Society360");
        logo.setLineSpacing(10);
        logo.setAlignment(Pos.CENTER_LEFT);
        logo.setStyle("-fx-text-fill:white;-fx-font-size:24px;-fx-font-weight:bold");

        Label panel = new Label("Secretary Panel");
        panel.setStyle("-fx-text-fill:lightgray;-fx-font-size:14px;-fx-padding:5px");


        Button dashboardBtn = new Button("Dashboard");
        dashboardBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        dashboardBtn.setOnAction(event ->{
            ResidentDashboard residentDashboard = new ResidentDashboard();
           Scene scene= residentDashboard.getResidentDashboardScene(stage);
            stage.setScene(scene);
            stage.show();
        });




        Button residentsBtn = new Button("Maintenance");
        residentsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        residentsBtn.setOnAction(event ->{
            Residentbtn residentbtn = new Residentbtn();

            stage.setScene(residentbtn.getResidentbtScene(stage));
        }

        );

        Button ownersBtn = new Button("My Bills");
        ownersBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        ownersBtn.setOnAction(event ->{
            Bills bills = new Bills();
            stage.setScene(bills.getBillScene(stage));
        });



        Button guardsBtn = new Button("Visitors");
        guardsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        guardsBtn.setOnAction(event ->{
            Visitor visitor = new Visitor();
            stage.setScene((visitor.getVisitorScene(stage)));
        });


        Button noticesBtn = new Button("Amenities Booking");
        noticesBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        noticesBtn.setOnAction(event ->{
            Aminity aminity = new Aminity();
            stage.setScene(aminity.getAminityScene(stage));
        });

         Button complaintsBtn = new Button("Community");
        complaintsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        
        complaintsBtn.setOnAction(event ->{
             Community community = new Community();
        stage.setScene(community.getCommunityScene(stage));
    });
        
        





        Button maintenanceBtn = new Button("Notices");
        maintenanceBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        maintenanceBtn.setOnAction(event ->{
            Notice notice = new Notice();
            stage.setScene(notice.getResidentbtScene(stage));


        });






        Button paymentsBtn = new Button("Complaints");
        paymentsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        paymentsBtn.setOnAction(event ->{
            Complaint complaint = new Complaint();
            stage.setScene(complaint.getComplaintScene(stage));
        });
        Button sosBtn = new Button("Emergency SOS");
        sosBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        sosBtn.setOnAction(event ->{
            Emergency emergency = new Emergency();
            stage.setScene(emergency.getEmergencyScene(stage));
        });

        Button eventsBtn = new Button("Polls& Surveys");
        eventsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        eventsBtn.setOnAction(event ->{
            Polls polls = new Polls();
            stage.setScene(polls.getPollScene(stage));
        });
        
        Button reportsBtn = new Button("Documents");
        reportsBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        reportsBtn.setOnAction(event ->{
            Document document = new Document();
            stage.setScene(document.getDocumentScene(stage));
        });
        
        Button profileBtn = new Button("Profile");
        profileBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
        profileBtn.setOnAction(event ->{
            ProfilePage profil = new ProfilePage();
            stage.setScene(profil.getProfileScene(stage));
});

    Button Parkingbtn = new Button("Parking");
    Parkingbtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");
    Parkingbtn.setOnAction(event ->{
        Parking parking = new Parking();
        stage.setScene(parking.getParkingScene(stage));
    });




        Button logoutBtn = new Button("Logout");
        logoutBtn.setStyle("-fx-background-color: #4e342e;-fx-font-weight:bold;-fx-text-fill: white;-fx-font-size: 14px;-fx-alignment: CENTER-LEFT;-fx-pref-width: 240px;-fx-pref-height: 40px;");


        sidebar.getChildren().addAll(logo,
                                    panel,
                                    dashboardBtn,
                                    residentsBtn,
                                    ownersBtn,
                                    guardsBtn,
                                    noticesBtn,
                                    complaintsBtn,
                                    maintenanceBtn,
                                    paymentsBtn,
                                    sosBtn,
                                    eventsBtn,
                                    reportsBtn,
                                    profileBtn,
                                    Parkingbtn,
                                    logoutBtn
        );}

  public VBox getSidebar(){
    return sidebar;
  }

  }
    
