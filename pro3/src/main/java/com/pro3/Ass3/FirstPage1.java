package com.pro3.Ass3;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstPage1 extends Application {
    Scene fScene,sScene,tScene,hScene,fScene2;
    Stage primaryStage;

    @Override
    public void start(Stage arg0) throws Exception {

      Button b1=new Button("Button1");
      b1.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
          initializeB1Scene();
          primaryStage.setScene(sScene);
        }
        
      });

      Button b2 = new Button("Button2");
      b2.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
         initializeB2Scene();
         primaryStage.setScene(tScene);
        }
        
      });

      Button b3=new Button("Button3");
      b3.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
          initializeB3Scene();
          primaryStage.setScene(hScene);
        }
        
      });

      Button b4=new Button("Button4");
      b4.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
          initializeB4Scene();
          primaryStage.setScene(fScene2);
        }
        
      });

      VBox vb=new VBox(40,b1,b2,b3,b4);
      vb.setPadding(new Insets(50,50,50,50));
      vb.setAlignment(Pos.CENTER);
      Scene sc=new Scene(vb,1000,800);
      arg0.setScene(sc);
      fScene=sc;
      primaryStage=arg0;
      arg0.show();
    }

    public void initializeB1Scene(){
      Button1Page button1Page=new Button1Page();
      button1Page.setbStage(primaryStage);
      sScene=new Scene(button1Page.createBox1(this::handleBack1),1000,800);
      button1Page.setbScene(sScene);
    }

    
    public void initializeB2Scene(){
      Button2Page button2Page=new Button2Page();
      button2Page.setMyStage1(primaryStage);
      tScene=new Scene(button2Page.createBox2(this::handleBack1),1000,800);
      button2Page.settScene(tScene);
    }

    public void initializeB3Scene(){
      Button3Page button3Page=new Button3Page();
      button3Page.setMyStage1(primaryStage);
      hScene=new Scene(button3Page.createBox3Box(this::handleBack1),1000,800);
      button3Page.setScene(hScene);
    }

    public void initializeB4Scene(){
      Button4Page button4Page=new Button4Page();
      button4Page.setMyStage4(primaryStage);
      fScene2=new Scene(button4Page.create4Box(this::handleBack1),1000,800);
      button4Page.sethScene(fScene2);
    }


    public void handleBack1(){
      primaryStage.setScene(fScene);
    }


}