import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

public Logs(){
        File file = new File("logs.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File is created!");
            } else {
                //the boolean at the end puts the file in append mode
                FileWriter fw = new FileWriter("logs.txt", true);
               // BufferedWriter bw = new BufferedWriter(fw);
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void logEntry(String entry){




    }
}
