package com.pro3.Home;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Page1 extends Application{
    Scene page1Scene, page2Scene;
    Stage primaryStage;

    @Override
    public void start(Stage myStage) throws Exception {
        Text tx = new Text("First Page ");
        Button nextbtn = new Button("Next Page");
        nextbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                initializedPage2();
                primaryStage.setScene(page2Scene);
            }
            
        });

        VBox vb = new VBox(50,tx,nextbtn);
        vb.setAlignment(Pos.CENTER);
        Scene sc = new Scene(vb,800,500);
        myStage.setScene(sc);
        page1Scene = sc;
        primaryStage = myStage;
        myStage.show();
    }

    private void initializedPage2(){
        Page2 page2 = new Page2();
        page2.setP2Stage(primaryStage);
        page2Scene = new Scene(page2.createScene(this::handleBackButton),800,500);
        page2.setP2Scene(page2Scene); 
    }

    private void handleBackButton(){
        primaryStage.setScene(page1Scene);
    }
    
}
