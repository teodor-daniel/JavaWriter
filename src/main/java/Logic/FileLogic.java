package Logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileLogic {
    private String fileName;
    private  String sortedFile;
    public FileLogic(String fileName){
        this.fileName = fileName;
    }

    public void sortWordsInFile() {
        try {
            // set the words in the file in a certain order (lexicographically)
            String pathWithoutExtension = this.fileName.substring(0, this.fileName.length() - 4);
            this.sortedFile = "src/main/resources/Text/" + pathWithoutExtension + "Sorted.txt";

            List<String> words = Files.lines(Paths.get("src/main/resources/Text/" + this.fileName))
                    .flatMap(line -> List.of(line.split("\\s+")).stream())
                    .collect(Collectors.toList());

            // Sort the words lexicographically and by size
            words.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));


            // Write the sorted words to the output file
            Files.write(Paths.get(this.sortedFile), words);

            System.out.println("Words sorted and saved to: " + this.sortedFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Here it broke");
        }
    }


    public List<String> loadWordsFromFile() { //here I get all the words from a file that is sorted and put them in an arrayList
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get( "src/main/resources/Text/" + this.fileName))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                words.add(word);
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
        return words;
    }

}
