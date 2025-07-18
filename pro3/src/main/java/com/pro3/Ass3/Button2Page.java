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

public class Button2Page {
    Scene tScene;
    Stage myStage1;
    
    public void settScene(Scene tScene) {
        this.tScene = tScene;
    }
    public void setMyStage1(Stage myStage1) {
        this.myStage1 = myStage1;
    }

    public VBox createBox2(Runnable Back){
        Text tb=new Text("Welcome on Button2 !");
        tb.setFont(new Font(20));
        tb.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Back.run();
            }
            
        });
        VBox vb=new VBox(tb);
        vb.setPadding(new Insets(50,50,50,50));
        vb.setAlignment(Pos.CENTER);
        return vb;
    }

}
