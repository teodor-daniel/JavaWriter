package Logic;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class TextAreaLogic {

    public TextAreaLogic() {
    }

    public void setToUpperCaseSelectedText(String selectedText, TextArea textArea) {
        String upperCaseText = selectedText.toUpperCase();

        int start = textArea.getSelection().getStart();
        int end = textArea.getSelection().getEnd();
        textArea.replaceText(start, end, upperCaseText);
    }

    public void setToLowerCaseSelectedText(String selectedText, TextArea textArea) {
        String upperCaseText = selectedText.toLowerCase();

        int start = textArea.getSelection().getStart();
        int end = textArea.getSelection().getEnd();
        textArea.replaceText(start, end, upperCaseText);
    }

    public void setDefaultLabelText(TextArea textArea, Label stringCounter, Label charactersCounter) {
        if (textArea.getText().isEmpty()) {
            stringCounter.setText("Words: 0");
            charactersCounter.setText("Characters: 0");
        }
    }

    public String returnWordsCount(String text) {
        String[] wordSplit = text.split("\\s+");
        int counter = wordSplit.length;
        return Integer.toString(counter);
    }

    public String returnCharactersCount(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c != ' ') {
                count++;
            }
        }
        return Integer.toString(count);
    }
}
