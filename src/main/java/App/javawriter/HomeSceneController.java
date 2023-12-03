package App.javawriter;
import Logic.ColorPickerLogic;
import Logic.TextAreaLogic;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeSceneController {
    public CheckBox autoCompleteSate;
    private ColorPickerLogic colorPickerLogic = new ColorPickerLogic();
    private TextAreaLogic textAreaLogic = new TextAreaLogic();
    @FXML
    private TextArea textArea;
    @FXML
    private Label charactersCounter;
    @FXML
    private Label stringCounter;
    @FXML
    private Button changeToUppercase;
    @FXML
    private Button changeToLowercase;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Button changeToSaveScene;
    @FXML
    private Button changeToLoadScene;


    public void setTextAreaContent(String text) {
        textArea.setText(text);
    }

    public void updateText() {
        textArea.textProperty().addListener((event) -> {
            textArea.setWrapText(true);
            charactersCounter.setText("Characters: " + textAreaLogic.returnCharactersCount(textArea.getText()));
            stringCounter.setText("Words: " + textAreaLogic.returnWordsCount(textArea.getText()));
            textAreaLogic.setDefaultLabelText(textArea, stringCounter, charactersCounter);
        });
        textArea.setOnKeyPressed(event -> {
            if (autoCompleteSate.isSelected() && event.getCode() == KeyCode.CONTROL) {
                int caretPosition = textArea.getCaretPosition();
                //right now it just sets it to upper case I did this to test if I can select the
                //word that O am currently on using the caret, and it works
                int wordStart = findWordStart(caretPosition);
                int wordEnd = findWordEnd(caretPosition);

                String currentWord = textArea.getText(wordStart, wordEnd);

                String upperCaseWord = currentWord.toUpperCase();

                textArea.replaceText(wordStart, wordEnd, upperCaseWord);

                textArea.positionCaret(wordStart + upperCaseWord.length());
            }
        });
    }
     private int findWordStart(int position) {
            String text = textArea.getText();
            int start = position;

            while (start > 0 && !Character.isWhitespace(text.charAt(start - 1))) {
                start--;
            }

            return start;
        }
        private int findWordEnd(int position) {
            String text = textArea.getText();
            int end = position;

            while (end < text.length() && !Character.isWhitespace(text.charAt(end))) {
                end++;
            }

            return end;
        }

    public void handleUpperCase() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            textAreaLogic.setToUpperCaseSelectedText(selectedText, textArea);
        }
    }

    public void handleToLowerCase() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            textAreaLogic.setToLowerCaseSelectedText(selectedText, textArea);
        }

    }

    @FXML
    private void handleColorPicker(ActionEvent actionEvent) {
        textArea.setStyle("-fx-text-fill: #" + colorPickerLogic.colorToHex(colorPicker.getValue()) + ";");
    }


    public void handleToSaveScene() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("save-scene-view.fxml"));
            Parent root = fxmlLoader.load();
            SaveSceneController saveSceneController = fxmlLoader.getController();
            Stage newStage = new Stage();
            saveSceneController.setTextAreaBuffer(textArea.getText());
            newStage.getIcons().add(new Image("file:src/main/resources/Images/save.png"));

            newStage.setTitle("Save");
            newStage.setScene(new Scene(root, 350, 50));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleToLoadScene() {
        try {
            String loadSceneViewName = "load-scene-view.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(loadSceneViewName));
            Parent root = fxmlLoader.load();
            LoadSceneController loadSceneController = fxmlLoader.getController();

            Stage newStage = new Stage();
            newStage.getIcons().add(new Image("file:src/main/resources/Images//load.png"));

            newStage.setTitle("Load");
            newStage.setScene(new Scene(root, 350, 50));
            newStage.show();

            newStage.setOnHidden(event -> {
                System.out.println("LoadScene is closed");

                if (loadSceneController != null) {
                    String buffer = loadSceneController.getWords();
                    textArea.setText(buffer);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enableAutoComplete() {
        if(autoCompleteSate.isSelected()){
            System.out.println("You checked me");
        }
    }
}


