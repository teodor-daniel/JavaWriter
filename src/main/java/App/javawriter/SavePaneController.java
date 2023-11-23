package App.javawriter;

import Interfaces.Closable;
import Logic.SaveLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SavePaneController implements Closable {

    @FXML
    public Button closeScene;
    @FXML
    public Button saveFile;
    @FXML
    public TextField textFieldFileName;
    private String textAreaBuffer;

    private  SaveLogic saveLogic = new SaveLogic();
    public String getTextAreaBuffer() {
        return textAreaBuffer;
    }

    public void setTextAreaBuffer(String textAreaBuffer) {
        this.textAreaBuffer = textAreaBuffer;
    }

    @FXML
    public void handleCloseWindow(MouseEvent actionEvent) {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    public void handleSaveText(ActionEvent actionEvent)  {
       this.saveLogic.createFile(this.textAreaBuffer,this.textFieldFileName.getText());
    }
}
