package com.sai.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyScreen2 extends Application {

    @Override
    public void start(Stage myStage) throws Exception {
        Text t1 = new Text();
        TextField tf = new TextField();
        tf.setPromptText("Enter Text");

        Button btn = new Button("Print Text");
        btn.setStyle("-fx-background-color: blue");
        btn.setFocusTraversable(false);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                t1.setText(tf.getText());
            }
            
        });

        VBox vb = new VBox(15,tf,btn,t1);
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

