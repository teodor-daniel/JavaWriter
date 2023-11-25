package App.javawriter;

import Interfaces.Closable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoadSceneController implements Closable {

    @FXML
    public Button closeScene;
    @FXML
    public TextField loadPathFile;
    @FXML
    public Button confirmFile;

    public void handleCloseWindow(MouseEvent mouseEvent) {
        final Node source = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void handleConfirmedPath(ActionEvent actionEvent) {

    }
}
