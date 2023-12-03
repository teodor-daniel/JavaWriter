package App.javawriter;

import Logic.AutoCompleteLogic;
import Logic.FileLogic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;


public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-scene-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 425, 600);
        stage.setTitle("JavaWriter");
        stage.getIcons().add(new Image("file:src/main/resources/Images/icon.png"));

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        FileLogic myFile = new FileLogic("pisi.txt");
        AutoCompleteLogic autoCompleteLogic = new AutoCompleteLogic();
        myFile.sortWordsInFile();
        List<String> words = myFile.loadWordsFromFile();
        String inputWord = "do"; // autocomplete the word do -> doom -> door.
        inputWord = autoCompleteLogic.autocomplete(words, inputWord);
        System.out.println(inputWord);
        launch();
    }



}