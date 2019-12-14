package z;

import java.io.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class Main {

    public static void main(String[] args) throws IOException {
        System.setProperty("console.encoding","Cp866");
        int k = 1;
        while (k == 1) {
            System.out.println("|                                           |");
            System.out.println("|             Sort text by alphabet         |");
            System.out.println("|                                           |");
            System.out.println("|                                           |");
            System.out.println("|       Please put the path to the file     |");
            String pachs = Keyin.inString();
            FilewithText file = new FilewithText();
            file.openFile(pachs);
            if(file.isBool()) {
                Listword listword = new Listword(file.getPath(), file.getName());
                System.out.println("List of words before sort");
                for (int i = 0; i < listword.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + listword.getList().get(i));
                }
                listword.sortList();
                System.out.println("List of words after sort");
                for (int i = 0; i < listword.getList().size(); i++) {
                    System.out.println((i + 1) + ". " + listword.getList().get(i));
                }
                System.out.println("|                        Restart program?                         |");
                System.out.println("|                        1.Select new file                        |");
                System.out.println("|                             2.Exit                              |");
                k = Keyin.inInt("Input your answer");
            }
            while(k<1||k>2){
                System.out.println("You must write 1 or 2");
                k = Keyin.inInt("Input your answer");
            }
        }




/*
        File file = new File("text.txt");
        try {
            String h = file.getName();
            List<String> list = new ArrayList<>();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(h));
            list = (List<String>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Path file = Paths.get("text.txt");
        //List<String> lines = Files.readAllLines(file);

        List<String> lines = Files.readAllLines(Paths.get("text.txt"), StandardCharsets.UTF_8);
        System.out.println(lines);
       // File file = new File("abc.txt");
        System.out.println(Files.lines(Paths.get("text.txt")));

	// write your code here*/
    }
}
