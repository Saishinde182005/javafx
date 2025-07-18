package com.pro4.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application{
    Scene page1Scene, page2Scene, page3Scene;
    Stage primaryStage;

    static String user = new String("sai");
    String pass = new String("1234");

    @Override
    public void start(Stage myStage) throws Exception {

        Text ui = new Text();
        ui.setStyle("-fx-font-size : 15px; -fx-fill: white;");

        Image img = new Image("Assets\\Images\\photo.jpg");
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        
        Text t1 = new Text("Welcome to Core2Web");
        t1.setStyle("-fx-font-size : 25px; -fx-fill: white; -fx-font-weight : bold;");

        Text t2 = new Text("Username");
        t2.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        TextField tf1 = new TextField();
        tf1.setPromptText("Enter UserName");
        tf1.setPrefHeight(25);
        tf1.setFocusTraversable(false);
        tf1.setMinWidth(100);
        tf1.setMaxWidth(400);
        tf1.setStyle(
            "-fx-background-color: lightblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;" 
        );

        VBox v1 = new VBox(15,t2,tf1);
        v1.setAlignment(Pos.CENTER);
        
        Text t3 = new Text("Password");
        t3.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        PasswordField pf1 = new PasswordField();
        pf1.setPromptText("Enter Password");
        pf1.setPrefHeight(25);
        pf1.setFocusTraversable(false);
        pf1.setMinWidth(100);
        pf1.setMaxWidth(400);
        pf1.setStyle(
            "-fx-background-color: lightblue;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;"
        );

        VBox v2 = new VBox(15,t3,pf1);
        v2.setAlignment(Pos.CENTER);

        Button b1 = new Button("Login");
        b1.setFocusTraversable(false);
        b1.setMinWidth(60);
        b1.setMaxWidth(120);
        b1.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String s1 = tf1.getText();
                String s2 = pf1.getText();
                
                if(s1.equals(user) && s2.equals(pass)){
                    initializedPage2();
                    primaryStage.setScene(page2Scene);
                    System.out.println("Valid User");
                }else{
                    ui.setText("Invalid User");
                }
                tf1.clear();
                pf1.clear();
            }
            
        });

        Button b2 = new Button("Explore");
        b2.setFocusTraversable(false);
        b2.setMinWidth(60);
        b2.setMaxWidth(120);
        b2.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                initializedPage3();
                primaryStage.setScene(page3Scene);
            }
            
        });

        VBox vb = new VBox(20,imageView,t1,v1,v2,b1,b2,ui);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setStyle("-fx-background-color: black");
        Scene myScene = new Scene(vb);
        myStage.setTitle("Core2Web");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        page1Scene = myScene;
        primaryStage = myStage;
        myStage.show();
    }
    
   
    private void initializedPage2(){
        HomePage page2 = new HomePage();
        page2.setStage2(primaryStage);
        page2Scene = new Scene(page2.createHomeScene(this::handleBackButton),800,500);
        page2.setScene1(page2Scene); 
    }

    private void initializedPage3(){
        ExplorePage page3 = new ExplorePage();
        page3.setExplorestage(primaryStage);
        page3Scene = new Scene(page3.createExploreScene(this::handleBackButton),800,500);
        page3.setExplorescene(page2Scene); 
    }

    private void handleBackButton(){
        primaryStage.setScene(page1Scene);
    }
}
