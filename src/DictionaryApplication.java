/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class DictionaryApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("UserInterface/DictionaryApplication.fxml"));
            Parent parent = (Parent) fXMLLoader.load();
            Scene scene = new Scene(parent);
            
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dictionary English - Vietnamese");
//            primaryStage.setMaxHeight(510);
//            primaryStage.setMaxWidth(700);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
