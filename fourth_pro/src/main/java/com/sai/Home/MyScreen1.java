package com.sai.Home;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyScreen1 extends Application {

    @Override
    public void start(Stage myStage) throws Exception {
        TextField tf = new TextField();
        Button btn = new Button("Print Text");
        btn.setStyle("-fx-background-color: blue");
        VBox vb = new VBox(15,tf,btn);
        vb.setPadding(new Insets(10));
        vb.setStyle("-fx-background-color: yellow");
        vb.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(vb);
        myStage.setTitle("Screen1");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
