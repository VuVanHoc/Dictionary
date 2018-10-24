
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
}
