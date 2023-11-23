package Logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveLogic {
    public SaveLogic() {
    }

    public void createFile(String textAreaBuffer, String textFieldFileName) {
        System.out.println(textAreaBuffer);
        try {
            File myTextFile = new File(textFieldFileName + ".txt");
            if (myTextFile.createNewFile()) {
                System.out.println("File created: " + myTextFile.getName());
                try {
                    FileWriter myWriter = new FileWriter(textFieldFileName + ".txt");
                    myWriter.write(textAreaBuffer);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred when writting to file.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred when trying to create the text.");
            e.printStackTrace();
        }

    }

}
