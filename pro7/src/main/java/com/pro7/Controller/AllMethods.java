package com.pro7.Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AllMethods {
    static final String PROJECT_ID = "javafx-pro2";
    static final String API_KEY = "AIzaSyAP00v6sNiZAjEYBTCWVYfZj0UzVPBOOog";

    public static String addUserToFirestore(String name, String age){
        if(name.isEmpty() || age.isEmpty()){
            return "Please Enter Both Name And Age";
        }
        String endpoint = String.format(
            "https://firestore.googleapis.com/v1/projects/%s/databases/(default)/documents/users?key=%s", PROJECT_ID, API_KEY);
            String payload = String.format("{ \"fields\" : { \"name\" : {\"stringValue\" : \"%s\"}, \"age\" : {\"integerValue\" : \"%s\"} } }", name, age);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()){
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }
            InputStream is = conn.getInputStream();
            byte[] responseBytes = is.readAllBytes();
            String response = new String(responseBytes, StandardCharsets.UTF_8);
            is.close();
            conn.disconnect();
            return "Added ! FireStore says : \n"+ response;
        } catch (Exception e) {
           return "Error: "+ e.getMessage();
        }
    }
    

public static String readUserToFirestore(){
        String endpoint = String.format(
            "https://firestore.googleapis.com/v1/projects/%s/databases/(default)/documents/users?key=%s", PROJECT_ID, API_KEY);
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type","application/json");
            InputStream is = conn.getInputStream();
            byte[] responseBytes = is.readAllBytes();
            String response = new String(responseBytes, StandardCharsets.UTF_8);
            is.close();
            conn.disconnect();
            return "Users in FireStore : \n"+ response;
        } catch (Exception e) {
           return "Error: "+ e.getMessage();
        }
    }

    public static String updateUserToFirestore(String docId, String name, String age){
        if(docId.isEmpty() || name.isEmpty() || age.isEmpty()){
            return "Enter doc ID, Name And Age to upload";
        }
        String endpoint = String.format(
            "https://firestore.googleapis.com/v1/projects/%s/databases/(default)/documents/users/%s?key=%s", PROJECT_ID, docId, API_KEY);

            String payload = String.format("{ \"fields\" : { \"name\" : {\"stringValue\" : \"%s\"}, \"age\" : {\"integerValue\" : \"%s\"} } }", name, age);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()){
                os.write(payload.getBytes(StandardCharsets.UTF_8));
            }
            InputStream is = conn.getInputStream();
            byte[] responseBytes = is.readAllBytes();
            String response = new String(responseBytes, StandardCharsets.UTF_8);
            is.close();
            conn.disconnect();
            return "Updated! FireStore says : \n"+ response;
        } catch (Exception e) {
            return "Error: "+ e.getMessage();
        }
    }

    public static String deleteUserToFirestore(String docId){
        if(docId.isEmpty()){
            return "Please Enter Doc ID";
        }
        String endpoint = String.format(
            "https://firestore.googleapis.com/v1/projects/%s/databases/(default)/documents/users/%s?key=%s", PROJECT_ID, docId, API_KEY);
            
        try {
            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type","application/json");
            int responseCode = conn.getResponseCode();
            conn.disconnect();
            if(responseCode == 200){
                return "Deleted Successfully";
            }else{
                return "Delete Failed. HTTP code: "+ responseCode;
            }
        } catch (Exception e) {
            return "Error: "+ e.getMessage();
        }
    }
}
    



