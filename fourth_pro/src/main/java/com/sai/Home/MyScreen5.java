package com.sai.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyScreen5 extends Application {

    @Override
    public void start(Stage myStage) throws Exception {
        Text t1 = new Text();
        // Text t2 = new Text();
        
        String user = new String("Core2Web");
        String pass = new String("1234");
        
        TextField tf = new TextField();
        tf.setPromptText("Enter UserNamr");
        tf.setFocusTraversable(false);

        PasswordField passwordFieldf = new PasswordField();
        passwordFieldf.setPromptText("Enter Password");
        passwordFieldf.setFocusTraversable(false);

        Button btn = new Button("Login");
        btn.setStyle("-fx-background-color: blue");
        btn.setFocusTraversable(false);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                 String s1 = tf.getText();
                 String s2 = passwordFieldf.getText();
                
                if(s1.equals(user) && pass.equals(s2)){
                    t1.setText("You are welcome !!!!");
                }else{
                    t1.setText("Invalid User");
                }
                tf.clear();
                passwordFieldf.clear();
            }
            
        });

        VBox vb = new VBox(15,tf,passwordFieldf,btn,t1);
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

