package com.sai.Home;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home extends Application{

    @Override
    public void start(Stage myStage) throws Exception {
        DropShadow ds = new DropShadow();
        ds.setColor(Color.SALMON);
        Text t1 = new Text(700,20,"Good Morning");
        t1.setFont(new Font(25));
        t1.setStyle("-fx-stroke:black");
        t1.setEffect(ds);
        Text t2 = new Text(100,30,"Have a nice day");
        t2.setFont(new Font(25));
        t2.setStyle("-fx-stroke:black");
        t1.maxWidth(35);
        t1.setFill(Color.RED);
        VBox vb1 = new VBox(10);
        Image img = new Image("Assets\\\\Images\\\\logo.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);
        vb1.getChildren().addAll(imgView);
        vb1.setVisible(true);
        VBox vb2 = new VBox(15,t1,t2);
        HBox hb = new HBox(50, vb1, vb2);
        Scene myScene = new Scene(hb,100,800);
        myScene.setFill(Color.LAVENDER);
        myStage.setTitle("New Project 1");
        myStage.setWidth(1000);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.getIcons().add(new Image("Assets\\Images\\logo.jpg"));
        myStage.setScene(myScene);
        myStage.show();
        
    }
    
}
