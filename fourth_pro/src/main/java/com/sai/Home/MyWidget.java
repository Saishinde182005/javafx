package com.sai.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyWidget extends Application{

    @Override
    public void start(Stage myStage) throws Exception {
        Text user = new Text();
        Text password = new Text();

        Text t1 = new Text("UserName");
        TextField userName = new TextField();
        userName.setPromptText("Enter UserName");
        userName.setFocusTraversable(false);

        Text t2 = new Text("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter Password");
        passwordField.setFocusTraversable(false);

        Button sButton = new Button("Submit");
        sButton.setFocusTraversable(false);
        sButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                user.setText(userName.getText());
                password.setText(passwordField.getText());
            }
            
        });

        GridPane gp = new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        for(int i=0; i<10; i++){
            for(int j=0; j<50; j++){
                gp.add(new Text("Core2Web"),i,j);
            }
        }

        VBox vb = new VBox(15,t1,userName,t2,passwordField,sButton,user,password,gp);
        ScrollPane sp = new ScrollPane(vb);
        
        vb.setPadding(new Insets(15));
        vb.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(sp);
        myScene.setFill(Color.LAVENDER);
        myStage.setTitle("Core2Web");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
