package com.pro4.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePage {

    Scene homescene, page3Scene;
    Stage homestage;

    public void setScene1(Scene homescene) {
        this.homescene = homescene;
    }

    public void setStage2(Stage homestage) {
        this.homestage = homestage;
    }


    public VBox createHomeScene(Runnable myThread1){

        Text t1 = new Text("Welcome to Home Page");
        t1.setStyle("-fx-font-size : 20px; -fx-fill: white; -fx-font-weight : bold;");

        Button b1 = new Button("Back");
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
                myThread1.run();
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
                homestage.setScene(page3Scene);
            }
            
        });

        VBox vb = new VBox(20,t1,b1,b2);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: black");
        return vb;
    }

    private void initializedPage3() {
        ExplorePage ep = new ExplorePage();
        ep.setExplorestage(homestage);
        page3Scene = new Scene(ep.createExploreScene(this::handleBackButton),800,500);
        ep.setExplorescene(page3Scene); 
    }

    private void handleBackButton(){
        homestage.setScene(homescene);
    }
}
