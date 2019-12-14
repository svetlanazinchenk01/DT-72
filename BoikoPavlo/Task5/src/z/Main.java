package z;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setProperty("console.encoding","Cp866");

        int k = 1;
        while (k == 1) {

            System.out.println("|                    Hello                  |");
            System.out.println("|             Sort text by alphabet         |");
            System.out.println("|                                           |");
            System.out.println("|                                           |");

            String pachs;
            do{
                System.out.println("|       Please put patch where file         |");
                pachs = Keyin.inString();
            }
            while (pachs.isEmpty());

            FilewithText file = new FilewithText();
            file.openFile(pachs);

            if(file.isBool()) {

                Listword listword = new Listword(file.getPath(), file.getName());
                listword.printList("List of words before sort");

                listword.sortList();
                listword.printList("List of words after sort");

                int answer=0;
                do {
                    System.out.println("|                   Delete repetition of words?                   |");
                    System.out.println("|                             1.Yes                               |");
                    System.out.println("|                             2.No                                |");
                    answer = Keyin.inInt("Input your answer");
                }
                while (answer<1 || answer >2);

                if(answer==1) {
                    listword.deleteRepetition();
                    listword.printList("List without repetition of words: ");
                }

                k=0;
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
    }
}
