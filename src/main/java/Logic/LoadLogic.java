package Logic;

import java.util.ArrayList;

public class LoadLogic {
    private ArrayList<String> wordList;

    public LoadLogic() {
        this.wordList = new ArrayList<>();
    }

    public void addWord(String text) {
        this.wordList.add(text);
    }

    public String getWords() {
        String buffer = "";
        for (String word : wordList) {
            buffer += word;
        }
        return buffer;
    }
}
