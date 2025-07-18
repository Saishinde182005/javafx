package com.pro6.View;
import com.pro6.Controller.SignIn;
import com.pro6.Controller.SignUp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Application{
    @Override
    public void start(Stage myStage) throws Exception {

        Text t1 = new Text("Email");
        t1.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        TextField tf1 = new TextField();
        tf1.setPromptText("Enter Email");
        tf1.setPrefHeight(25);
        tf1.setFocusTraversable(false);
        tf1.setMinWidth(100);
        tf1.setMaxWidth(400);
        tf1.setStyle(
            "-fx-background-color: lightblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;" 
        );
        
        Text t2 = new Text("Password");
        t2.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        PasswordField pf1 = new PasswordField();
        pf1.setPromptText("Enter Password");
        pf1.setPrefHeight(25);
        pf1.setFocusTraversable(false);
        pf1.setMinWidth(100);
        pf1.setMaxWidth(400);
        pf1.setStyle(
            "-fx-background-color: lightblue;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;"
        );

        Text ouput = new Text();
        ouput.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");

        Button b1 = new Button("Sign Up");
        b1.setFocusTraversable(false);
        b1.setMinWidth(60);
        b1.setMaxWidth(120);
        b1.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        b1.setOnAction(e->{
            String email = tf1.getText();
            String password = pf1.getText();

            SignUp signUp = new SignUp();
            boolean returnSecureToken = signUp.signUpWithEmailAndPassword(email, password);

            if(returnSecureToken){
                ouput.setText("SignUp Successfully");
                System.out.println("SignUp Successfull");
            }else{
                ouput.setText("SignUp Failed");
            }
            tf1.clear();
            pf1.clear();
        
        });

        Button b2 = new Button("Login");
        b2.setFocusTraversable(false);
        b2.setMinWidth(60);
        b2.setMaxWidth(120);
        b2.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        b2.setOnAction(e->{
            String email = tf1.getText();
            String password = pf1.getText();

            SignIn signIn = new SignIn();
            boolean returnSecureToken = signIn.loginWithEmailAndPassword(email, password);

            if(returnSecureToken){
                ouput.setText("Login Successfully");
                System.out.println("Login Successfull");
            }else{
                ouput.setText("Login Failed");
                System.out.println("Login Failed");
            }
            tf1.clear();
            pf1.clear();
        
        });

        VBox vb = new VBox(20,t1,tf1,t2,pf1,b1,b2,ouput);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setStyle("-fx-background-color: black");
        Scene myScene = new Scene(vb);
        myStage.setTitle("Firebase Authentication");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        myStage.show();
        myStage.show();
    }
    
}
