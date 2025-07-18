package com.pro2.Home;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage myStage) throws Exception {
        VBox vb1 = new VBox(100);
        Image img = new Image("Assets\\Images\\Photo1.jpg");
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);
        vb1.getChildren().addAll(imageView);

    
        Text t1 = new Text("Name : Sai Bhagawan Shinde");
        t1.setFont(new Font(20));
        //t1.setStyle("-fx-stroke:black");
        Text t2 = new Text("Mobile No : 9284004476");
        t2.setFont(new Font(20));
        //t2.setStyle("-fx-stroke:black");
        Text t3 = new Text("Email : saishinde278@gmail.com");
        t3.setFont(new Font(20));
        //t3.setStyle("-fx-stroke:black");
        VBox vb2 = new VBox(10,t1,t2,t3);
        HBox hb1 = new HBox(50,vb1,vb2);
 
        Text t4 = new Text("SKILLS : ");
        t4.setFont(new Font(18));
        t4.setStyle("-fx-stroke:black");
        VBox v1 = new VBox(20,t4);
        Text t5 = new Text(" -> C ");
        t5.setFont(new Font(18));
        Text t6 = new Text(" -> C++ ");
        t6.setFont(new Font(18));
        Text t7 = new Text(" -> Java");
        t7.setFont(new Font(18));
        Text t8 = new Text(" -> Flutter");
        t8.setFont(new Font(18));
        VBox v2 = new VBox(5,t5,t6,t7,t8);
        
        VBox vb3 = new VBox(10,v1,v2);
        HBox hb2 = new HBox(50,vb3);

        Text t9 = new Text("EDUCATION : ");
        t9.setFont(new Font(18));
        t9.setStyle("-fx-stroke:black");
        VBox v3 = new VBox(20,t9);
        Text t10 = new Text(" * SSC - 95%");
        t10.setFont(new Font(18));
        Text t11 = new Text(" * HSC - 73% ");
        t11.setFont(new Font(18));
        Text t12 = new Text(" * T.E - 9.5 CGPA");
        t12.setFont(new Font(18));
    
        VBox v4 = new VBox(5,t10,t11,t12);

        VBox vb4 = new VBox(10,v3,v4);
        HBox hb3 = new HBox(50,vb4);

        Text t13 = new Text("PROJECT : ");
        t13.setFont(new Font(18));
        t13.setStyle("-fx-stroke:black");
        VBox v5 = new VBox(20,t13);

        Text t14 = new Text(" 1) UtsavHub - Event Management App (Flutter)");
        t14.setFont(new Font(18));
        Text t15 = new Text(" 2) FabricFix - (JavaFx)");
        t15.setFont(new Font(18));
    
        VBox v6 = new VBox(5,t14,t15);
        VBox vb5 = new VBox(12,v5,v6);
        HBox hb4 = new HBox(50,vb5);

        VBox mainVBox = new VBox(40,hb1,hb2,hb3,hb4);
        mainVBox.setPadding(new Insets(20));
        mainVBox.alignmentProperty();
        Scene myScene = new Scene(mainVBox);
        myScene.setFill(Color.SKYBLUE);
        myStage.setTitle("Resume");
        myStage.setWidth(700);
        myStage.setHeight(700);
        myStage.setScene(myScene); 
        myStage.show();
        
    }
    
}
