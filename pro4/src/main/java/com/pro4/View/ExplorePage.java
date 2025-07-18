package com.pro4.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExplorePage {

    Scene explorescene;
    Stage explorestage;

    public void setExplorescene(Scene explorescene) {
        this.explorescene = explorescene;
    }

    public void setExplorestage(Stage explorestage) {
        this.explorestage = explorestage;
    }

    
    public VBox createExploreScene(Runnable myThread2){

        // Button b1 = new Button("Back to Home Page");
        // b1.setFocusTraversable(false);
        // b1.setMinWidth(60);
        // b1.setMaxWidth(120);
        // b1.setStyle(
        //     "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
        //     "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        // );
        // b1.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent arg0) {
        //         myThread2.run();
        //     }
            
        // });
        Text t1 = new Text("Welcome to Explore Page");
        t1.setStyle("-fx-font-size : 20px; -fx-fill: white; -fx-font-weight : bold;");
        t1.setOnMouseClicked(event->{
            System.out.println("title Clicked");
        });

        Button b2 = new Button("Back");
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
                myThread2.run();
            }
            
        });

        VBox vb = new VBox(20,t1,b2);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: black");
        return vb;
    }
}
