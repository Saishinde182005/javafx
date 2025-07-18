package com.pro3.PageNavigation3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ThreeNav_Page1 extends Application{
    Scene page1Scene, page2Scene;
    Stage primaryStage;

    @Override
    public void start(Stage myStage) throws Exception {

        Text t1 = new Text("First Page");
        t1.setStyle("-fx-font-size : 25px; -fx-fill: white; -fx-font-weight : bold;");

        Button b1 = new Button("Next");
        b1.setFocusTraversable(false);
        b1.setMinWidth(60);
        b1.setMaxWidth(120);
        b1.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                initializedPage2();
                primaryStage.setScene(page2Scene);
            }
            
        });

        VBox vb = new VBox(20,t1,b1);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setStyle("-fx-background-color: black");
        Scene myScene = new Scene(vb);
        myStage.setTitle("Core2Web");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        page1Scene = myScene;
        primaryStage = myStage;
        myStage.show();
    }
    
   
    private void initializedPage2(){
        ThreeNav_Page2 page2 = new ThreeNav_Page2();
        page2.setStage2(primaryStage);
        page2Scene = new Scene(page2.createHomeScene(this::handleBackButton),800,500);
        page2.setScene1(page2Scene); 
    }

    private void handleBackButton(){
        primaryStage.setScene(page1Scene);
    }
    
}
