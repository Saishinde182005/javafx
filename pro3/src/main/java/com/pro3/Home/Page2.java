package com.pro3.Home;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Page2 {
    Scene p2Scene;
    Stage p2Stage;
    public Scene getP2Scene() {
        return p2Scene;
    }
    public void setP2Scene(Scene p2Scene) {
        this.p2Scene = p2Scene;
    }
    public Stage getP2Stage() {
        return p2Stage;
    }
    public void setP2Stage(Stage p2Stage) {
        this.p2Stage = p2Stage;
    }
    
    public VBox createScene(Runnable back){
        Text tx = new Text("Second Page");
        Button prevbtn = new Button("Previous Page ");
        prevbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                back.run();
            }
            
        });

        VBox vb = new VBox(50,tx,prevbtn);
        vb.setStyle("-fx-alignment: center");
        return vb;
    }
    
}
