package com.sai.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MyScreen7 extends Application{

    @Override
    public void start(Stage myStage) throws Exception {
        
        String[] colors ={"red","blue","yellow","green"};
        final int[] index = { 0 };

        VBox vb = new VBox();
        Button btn = new Button("Change");
        vb.getChildren().add(btn);
        
        vb.setStyle("-fx-background-color: "+ colors[index[0]] + ";");
        btn.setStyle("-fx-background-color: black");
        btn.setMinWidth(40);
        btn.setMaxWidth(70);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                  index[0] = (index[0] + 1) % colors.length;
                  vb.setStyle("-fx-background-color: " + colors[index[0]] + ";");
            }
                
        }); 
            
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        //vb.setStyle("-fx-background-color: yellow");
        Scene myScene = new Scene(vb,800,500);
        myScene.setFill(Color.BLUEVIOLET);
        myStage.setTitle("Screen7");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene); 
        myStage.show();
    }
    
}
