package com.pro7.View;

import com.pro7.Controller.AllMethods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Firestore extends Application{
    
    AllMethods controller = new AllMethods();

    @Override
    public void start(Stage myStage) throws Exception {
        Text t1 = new Text("Name");
        t1.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");
        nameField.setPrefHeight(25);
        nameField.setFocusTraversable(false);
        nameField.setMinWidth(100);
        nameField.setMaxWidth(400);
        nameField.setStyle(
            "-fx-background-color: lightblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;" 
        );
        
        Text t2 = new Text("Age");
        t2.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        TextField ageField = new TextField();
        ageField.setPromptText("Enter Age");
        ageField.setPrefHeight(25);
        ageField.setFocusTraversable(false);
        ageField.setMinWidth(100);
        ageField.setMaxWidth(400);
        ageField.setStyle(
            "-fx-background-color: lightblue;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;"
        );

        Text t3 = new Text("Document ID");
        t3.setStyle("-fx-font-size : 15px; -fx-fill: white; -fx-font-weight : bold;");
        TextField docIdField = new TextField();
        docIdField.setPromptText("Enter Age");
        docIdField.setPrefHeight(25);
        docIdField.setFocusTraversable(false);
        docIdField.setMinWidth(100);
        docIdField.setMaxWidth(400);
        docIdField.setStyle(
            "-fx-background-color: lightblue;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" + "-fx-prompt-text-fill : black;"
        );

        Label resultLabel = new Label();

        Button addButton = new Button("Add to Firestore");
        addButton.setFocusTraversable(false);
        addButton.setMinWidth(100);
        addButton.setMaxWidth(160);
        addButton.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );

        addButton.setOnAction( e -> {
            String name = nameField.getText();
            String age = ageField.getText();
            String result = AllMethods.addUserToFirestore(name,age);
            resultLabel.setText(result);
        });

        Button readButton = new Button("Read All Users");
        readButton.setFocusTraversable(false);
        readButton.setMinWidth(100);
        readButton.setMaxWidth(160);
        readButton.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        readButton.setOnAction( e -> {
            String result = AllMethods.readUserToFirestore();
            resultLabel.setText(result);
        });
        

        Button updateButton = new Button("Update Users");
        updateButton.setFocusTraversable(false);
        updateButton.setMinWidth(100);
        updateButton.setMaxWidth(160);
        updateButton.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        updateButton.setOnAction( e -> {
            String docId = docIdField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            String result = AllMethods.updateUserToFirestore(docId, name, age);
            resultLabel.setText(result);
        });

        Button deleteButton = new Button("Delete Users");
        deleteButton.setFocusTraversable(false);
        deleteButton.setMinWidth(100);
        deleteButton.setMaxWidth(160);
        deleteButton.setStyle(
            "-fx-background-color: skyblue;" + "-fx-text-fill: black;" + "-fx-font-size: 14px;" +
            "-fx-border-color: darkblue;" + "-fx-border-radius: 5;" 
        );
        deleteButton.setOnAction( e -> {
            String docId = docIdField.getText();
            String result = AllMethods.deleteUserToFirestore(docId);
            resultLabel.setText(result);
        });

        VBox vb = new VBox(20,t1,nameField,t2,ageField,t3,docIdField,addButton,readButton,updateButton,deleteButton,resultLabel);
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
    }
    
}
