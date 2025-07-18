package com.pro8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyStorage extends Application{
    private static final String BUCKET = "firestoreproject-f2e22.firebasestorage.app";
    private static final String STORAGE_PATH = "img/sai.png";   //save by name sai in img folder
    private static final String LOCAL_TEMP = "C:/Users/saish/OneDrive/Desktop/assets/beverage5.png";

    private ImageView imageView = new ImageView();
    @Override
    public void start(Stage myStage) throws Exception {
        Button uploadBtn = new Button("Upload");
        Button getBtn = new Button("GET");
        Button deleteBtn = new Button("Delete");

        uploadBtn.setOnAction( e-> uploadImage(myStage));
        getBtn.setOnAction(e-> getImage());
        deleteBtn.setOnAction(e->deleteImage());

        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        HBox buttonBox = new HBox(10, uploadBtn, getBtn, deleteBtn);
        VBox root = new VBox(15, buttonBox, imageView);
        root.setPadding(new Insets(20));

        myStage.setScene(new Scene(root, 300, 300));
        myStage.setTitle("Firebase Storage Demo");
        myStage.show();
        
    }

    private void uploadImage(Stage mStage){
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select Image");
        chooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        File file = chooser.showOpenDialog(mStage);
        if (file == null) return;

        try {
            String urlStr = "https://firebasestorage.googleapis.com/v0/b/" + BUCKET +"/o?uploadType=media&name=" + URLEncoder.encode(STORAGE_PATH, "UTF-8");
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","image/png");

            try (OutputStream os = conn.getOutputStream(); FileInputStream fis  = new FileInputStream(file)){
                byte[] buffer = new byte[4096];
                int bytesRead;
                while((bytesRead = fis.read(buffer)) != -1) os.write(buffer, 0,bytesRead);
            }
            System.out.println("Upload response : "+ conn.getResponseCode());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getImage(){
        try {
            String encodedPath = STORAGE_PATH.replace("/", "%2F");
            String urlStr = "https://firebasestorage.googleapis.com/v0/b/" + BUCKET +"/o/"+ encodedPath + "?alt=media";
        
            try (InputStream in = new URL(urlStr).openStream(); 
                  FileOutputStream out  = new FileOutputStream(LOCAL_TEMP)){
                byte[] buffer = new byte[4096];
                int n;
                while((n = in.read(buffer)) != -1) out.write(buffer, 0, n);
            }
            imageView.setImage(new Image(new FileInputStream(LOCAL_TEMP)));
            System.out.println("Image downloaded and previewed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteImage(){
        try {
            String encodedPath = STORAGE_PATH.replace("/", "%2F");
            String urlStr = "https://firebasestorage.googleapis.com/v0/b/" + BUCKET +"/o/"+ encodedPath;
            HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
            conn.setRequestMethod("DELETE");
            System.out.println("Delete Response" + conn.getResponseCode());
            conn.disconnect();
            imageView.setImage(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
