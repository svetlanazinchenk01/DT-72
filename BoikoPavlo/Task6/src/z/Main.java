package z;
import java.io.*;

import static z.Keyin.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int tmp = 1;
        while (tmp == 1) {
        System.out.println("|                  Reverse                  |");
        System.out.println("|                                           |");
        System.out.println("Input word:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out,"utf-8"),true);
        String k= br.readLine();
        Reversed reversed =new Reversed();
        String word = reversed.reverseString(k);
        System.out.println("|                                           |");
        System.out.println("|                  Reverse:                 |");
        pw.println(word);
        System.out.println("|                                           |");
        System.out.println("|           1. Input new word               |");
        System.out.println("|           2.      Exit                    |");
        tmp = inInt("Input your answer");
        while(tmp<1||tmp>2){
            System.out.println("You must write 1 or 2");
            tmp = inInt("Input your answer");
            }
        }

    }



}
