package App.javawriter;

import Interfaces.Closable;
import Logic.LoadLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoadSceneController implements Closable {

    @FXML
    public Button closeScene;
    @FXML
    public TextField loadPathFile;
    @FXML
    public Button confirmFile;

    // Use the same instance of LoadLogic throughout the controller's lifecycle
    private LoadLogic loadLogic = new LoadLogic();

    public String getWords() {
        return this.loadLogic.getWords();
    }

    public void handleCloseWindow(MouseEvent mouseEvent) {
        final Node source = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void handleConfirmedPath(ActionEvent actionEvent) {
        if (!this.loadPathFile.getText().isEmpty()) {
            System.out.println("It worked");
            String textLoadPathFile = this.loadPathFile.getText();
            try (FileReader loadedFile = new FileReader(textLoadPathFile)) {

                BufferedReader bufferedReader = new BufferedReader(loadedFile);
                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    loadLogic.addWord(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Must input a path");
        }
    }
}