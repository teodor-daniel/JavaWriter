package App.javawriter;

import Logic.ColorPickerLogic;
import Logic.TextAreaLogic;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class HomePaneController {
    private ColorPickerLogic colorPickerLogic = new ColorPickerLogic();
    private TextAreaLogic textAreaLogic = new TextAreaLogic();
    @FXML
    public TextArea textArea;
    @FXML
    public Label charactersCounter;
    @FXML
    public Label stringCounter;
    @FXML
    public Button changeToUppercase;
    @FXML
    public Button changeToLowercase;
    @FXML
    public ColorPicker colorPicker;
    @FXML
    public Button save;

    public void updateCounters() {
        textArea.textProperty().addListener((event) -> {
            charactersCounter.setText("Characters: " + textAreaLogic.returnCharactersCount(textArea.getText()));
            stringCounter.setText("Words: " + textAreaLogic.returnWordsCount(textArea.getText()));
            textAreaLogic.setDefaultLabelText(textArea, stringCounter, charactersCounter);
        });

    }

    public void handletoUpperCase(ActionEvent actionEvent) {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            textAreaLogic.setToUpperCaseSelectedText(selectedText, textArea);
        }
    }

    public void handleToLowerCase(ActionEvent actionEvent) {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            textAreaLogic.setToLowerCaseSelectedText(selectedText, textArea);
        }

    }

    @FXML
    private void handleColorPicker(ActionEvent actionEvent) {
        textArea.setStyle("-fx-text-fill: #" + colorPickerLogic.colorToHex(colorPicker.getValue()) + ";");
    }


    public void handleSave(ActionEvent actionEvent) {
     //to do pop new scene input the name, save the file in a directory called saves,
    }
}


