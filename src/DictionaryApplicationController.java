
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class DictionaryApplicationController {

    
    public void handleAddWordItem() throws IOException {
        try {
            FXMLLoader fxmll = new FXMLLoader(getClass().getResource("UserInterface/AddNewWord.fxml"));
            Parent parent = fxmll.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Add New Word");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void handleDeleteWord() throws  IOException{
        try {
            FXMLLoader fxmll = new FXMLLoader(getClass().getResource("UserInterface/DeleteWord.fxml"));
            Parent parent = fxmll.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Delete Word");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleChangeWord() throws  IOException{
        try {
            FXMLLoader fxmll = new FXMLLoader(getClass().getResource("UserInterface/ChangeWord.fxml"));
            Parent parent = fxmll.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Change Word Meaning");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML private Label searchLabel = new Label();
    @FXML private Label resultFinding = new Label();
    @FXML private TextField searchField = new TextField();
    public void handleSearchButton() {
        
        try {
           searchLabel.setText(searchField.getText().trim().toLowerCase());
           searchLabel.setVisible(true);
           resultFinding.setText(DictionaryManagement.dictionaryLookup(searchField.getText().trim().toLowerCase()));
           resultFinding.setVisible(true);
        } catch (Exception e) {
        }
    }
    
   
    
    
    
}
