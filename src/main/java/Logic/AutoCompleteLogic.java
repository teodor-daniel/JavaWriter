package Logic;

import java.util.List;

public class AutoCompleteLogic {

    public String autocomplete(List<String> words, String prefix) {
        for(String word : words){
            if(word.startsWith(prefix)){
                return  word;
            }
        }
        return null; // handle exception
    }

}
