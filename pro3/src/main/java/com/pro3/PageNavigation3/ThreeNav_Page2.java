package com.pro3.PageNavigation3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeNav_Page2 {
    Scene p2scene, page3Scene;
    Stage p2stage;

    public void setScene1(Scene homescene) {
        this.p2scene = homescene;
    }

    public void setStage2(Stage homestage) {
        this.p2stage = homestage;
    }


    public VBox createHomeScene(Runnable myThread1){

        Text t1 = new Text("Second Page");
        t1.setStyle("-fx-font-size : 20px; -fx-fill: white; -fx-font-weight : bold;");

        Button b1 = new Button("Next Page");
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
                initializedPage3();
                p2stage.setScene(page3Scene);
            }
            
        });

        Button b2 = new Button("Back Page");
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
                myThread1.run();
            }
            
        });

        VBox vb = new VBox(20,t1,b1,b2);
        vb.setAlignment(Pos.CENTER);
        vb.setStyle("-fx-background-color: black");
        return vb;
    }

    private void initializedPage3() {
        ThreeNav_Page3 ep = new ThreeNav_Page3();
        ep.setP3stage(p2stage);
        page3Scene = new Scene(ep.createExploreScene(this::handleBackButton),800,500);
        ep.setP3scene(page3Scene); 
    }

    private void handleBackButton(){
        p2stage.setScene(p2scene);
    }
}

