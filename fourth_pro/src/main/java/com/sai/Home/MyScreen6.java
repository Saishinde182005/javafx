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

public class MyScreen6 extends Application{

    @Override
    public void start(Stage myStage) throws Exception {

        Text t1 = new Text();

        TextField tf = new TextField();
        tf.setPromptText("Enter the Number");
        tf.setMinWidth(100);
        tf.setMaxWidth(400);

        Button btn = new Button("Check");
        btn.setStyle("-fx-background-color: lightblue");
        btn.setMinWidth(40);
        btn.setMaxWidth(70);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                String original = tf.getText();
                StringBuilder sb = new StringBuilder(original);
                String reverse = sb.reverse().toString();
                if(original.equalsIgnoreCase(reverse)){
                    t1.setText("Palindrom");
                }else{
                    t1.setText("Not Palindrom");
                }
                tf.clear();
                
            }
            
        });
        
        VBox vb = new VBox(10,tf,btn,t1);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(20));
        vb.setStyle("-fx-background-color: yellow");
        Scene myScene = new Scene(vb,800,500);
        myStage.setTitle("Screen6");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene); 
        myStage.show();
    }
    
}
