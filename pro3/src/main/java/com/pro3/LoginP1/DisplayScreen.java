package com.pro3.LoginP1;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayScreen {
    Scene scene2;
    Stage stage2;
    String username;

    public void setUser(String username) {
        this.username = username;
    }

    public void setScene2(Scene scene2) {
        this.scene2 = scene2;
    }
    public void setStage2(Stage stage2) {
        this.stage2 = stage2;
    }
    
    public VBox createScene( ){
         Text t1 = new Text("Welceom "+ username);
        VBox vb = new VBox(t1);
        return vb;
            
    }

}


