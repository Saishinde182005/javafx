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

public class Button3Page {
    Scene Scene;
    Stage myStage1;

    public void setScene(Scene scene) {
        Scene = scene;
    }
    public void setMyStage1(Stage myStage1) {
        this.myStage1 = myStage1;
    }

     public VBox createBox3Box(Runnable Back){
        Text tx =new Text("Welcome On Button3 !");
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
