package core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    BufferedWriter writer;

public Logs(){

    try {
        //deschid prin apend mode daca exista, daca nu exista il creaza
        this.writer = new BufferedWriter(new FileWriter("logs.txt", true));
        this.logEntry("Start of the program");
    //  writer.write("Start of the program\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    }

    public void logEntry(String entry){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date();

        try {
            this.writer.write(dateFormat.format(date) +" ");
            this.writer.write(entry+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void closeFile(){
        try {
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
