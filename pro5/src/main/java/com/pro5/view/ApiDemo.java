package com.pro5.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApiDemo extends Application{
    String imageUrl;

    public String getImageUrl(String category){
        String link = "https://api.unsplash.com/photos/random?client_id=HDa9BeTkUDLd8EKmizWLDQIyNS-ayRcAtPtJJpRFuGI&query=" + category;
        
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            JSONObject obj = new JSONObject(response.toString());
            imageUrl = obj.getJSONObject("urls").getString("small");
            System.out.println(imageUrl);
            
            return imageUrl;
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return null;
        
    }

    @Override
    public void start(Stage myStage) throws Exception {
        Text t1 = new Text("API Binding");
        t1.setStyle("-fx-font-size : 25px; -fx-fill: white; -fx-font-weight : bold;");

        TextField user = new TextField();
        user.setPromptText("Enter Image");
        user.setPrefHeight(25);
        user.setFocusTraversable(false);
        user.setMinWidth(100);
        user.setMaxWidth(400);
        user.setStyle(
            "-fx-background-color: lightblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);

        Button b1 = new Button("Get Image");
        b1.setFocusTraversable(false);
        b1.setMinWidth(60);
        b1.setMaxWidth(120);
        b1.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        b1.setOnAction(event -> {
            System.out.println(user.getText() + "Image Displayed");
            String imageURL = getImageUrl(user.getText());
            imageView.setImage(new Image(imageURL));
        });

        VBox vb = new VBox(20,t1,user,b1,imageView);
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(15));
        vb.setStyle("-fx-background-color: black");
        Scene myScene = new Scene(vb);
        myStage.setTitle("API Binding");
        myStage.setWidth(900);
        myStage.setHeight(800);
        myStage.setResizable(true);
        myStage.setScene(myScene);
        myStage.show();
        myStage.show();
    }
    
}
