package com.pro3.LoginP1;

//import com.pro3.Home.Page2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application{
    Text user = new Text();
    Text pass = new Text();
    Scene page1Scene, page2Scene;
    Stage primaryStage;
    @Override
    public void start(Stage myStage) throws Exception {
        this.primaryStage = myStage;

        Text tx = new Text("Welcome");
        tx.setStyle("-fx-font-size: 20px");
        
        
        Text userText = new Text("User Name :");
        TextField userTextField = new TextField();
        userTextField.setPromptText("Enter UserName");
        HBox hb1 = new HBox(15,userText,userTextField);

        Text passText = new Text("Password :  ");
        PasswordField passField = new PasswordField();
        passField.setPromptText("Enter Password");
        HBox hb2 = new HBox(15,passText,passField);

        Button btn = new Button("Sign in");
        btn.setAlignment(Pos.BOTTOM_RIGHT);
        //btn.setStyle("-fx-alignment: bottom-right");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                user.setText(userTextField.getText());
                pass.setText(passField.getText());
                initializedPage2();
                primaryStage.setScene(page2Scene);
            }
            
        });

        VBox vb = new VBox(15,tx,hb1,hb2,btn,user);
        vb.setAlignment(Pos.CENTER_LEFT);
        vb.setPadding(new Insets(200));
        Scene myScene = new Scene(vb,800,500);
        myStage.setScene(myScene);
        myStage.show();
    }
    
    private void initializedPage2(){
        DisplayScreen dispscscreen = new DisplayScreen();
        dispscscreen.setStage2(primaryStage);
        dispscscreen.setUser(user.getText());
        page2Scene = new Scene(dispscscreen.createScene(),800,500);
        dispscscreen.setScene2(page2Scene); 
        //dispscscreen.getScene2();
    }

    
}
