package com.pro3.PageNavigation3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeNav_Page3 {
    Scene p3scene;
    Stage p3stage;

    public void setP3scene(Scene explorescene) {
        this.p3scene = explorescene;
    }

    public void setP3stage(Stage explorestage) {
        this.p3stage = explorestage;
    }

    
    public VBox createExploreScene(Runnable myThread2){
        Text t1 = new Text("Third Page");
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


