package com.pro3.Ass3;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Button1Page {
    Scene bScene;
    Stage bStage;

    public void setbScene(Scene bScene) {
        this.bScene = bScene;
    }
    public void setbStage(Stage bStage) {
        this.bStage = bStage;
    }

    public VBox createBox1(Runnable Back){
        Text tx =new Text("Welcome On Button1 !");
        tx.setFont(new Font(20));
        tx.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Back.run();
            }
            
        });

        VBox vb=new VBox(tx);
        vb.setPadding(new Insets(50,50,50,50));
        vb.setAlignment(Pos.CENTER);
        return vb;
    }

    
}