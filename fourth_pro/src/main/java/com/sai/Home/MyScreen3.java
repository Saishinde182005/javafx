package com.sai.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyScreen3 extends Application{
    public int num1=0;
    public int num2 = 0;
    public int sq=0;
    public double sqrroot = 0; 
    Text t1 = new Text();

    @Override
    public void start(Stage myStage) throws Exception {
        
    
        TextField user = new TextField();
        user.setPromptText("Enter Number");
        user.setPrefHeight(25);
        user.setFocusTraversable(false);
        user.setMinWidth(100);
        user.setMaxWidth(400);
        user.setStyle(
            "-fx-background-color: lightblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        Button s1Button = new Button("Square");
        s1Button.setFocusTraversable(false);
        s1Button.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        s1Button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                num1 = Integer.parseInt(user.getText());
                sq = num1*num1;
              
                String s1 = String.valueOf("Square of the given number is -->"+sq);
            
                t1.setText(s1);
            }
            
        });
        
        Label lb = new Label();

        Button s2Button = new Button("Square Root");
        s2Button.setFocusTraversable(false);
        s2Button.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        s2Button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                int num2 = Integer.parseInt(user.getText());
                sqrroot = Math.sqrt(num2);
                lb.setText("Square Root of the given number is -->"+sqrroot);
                
            }
            
        });


        VBox vb = new VBox(30,user,s1Button,s2Button,t1,lb);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setStyle("-fx-background-color: lightpink");
        Scene myScene = new Scene(vb);
        myScene.setFill(Color.LAVENDER);  //No use of this because vb(root) cover all area
        myStage.setTitle("Core2Web");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
