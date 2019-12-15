package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("text.txt");
        Scanner scan = new Scanner (read);
        String temp;
        String text=scan.nextLine();
        text=text.trim();
        while(scan.hasNextLine()){
            text+=" ";
            text+=scan.nextLine();

        }
        System.out.println(text);
        char [] words =text.toCharArray();
        for (int i=0;i<words.length;i++) {
            if (!Character.isLetter(words[i])) words[i]=' ';
        }
        String new_w=Character.toString(words[0]);
        for (int i = 1; i<words.length;i++)
            new_w+=words[i];
        new_w.trim();
        int am = 0;
        for (int i = 0; i<new_w.length()-1;i++)
            if(Character.isLetter(new_w.charAt(i)))
                if(Character.isWhitespace(new_w.charAt(i+1)))
                    am++;

         String [] words_n = new String[am+1];
         int j=0;
         int in1=0;
        int in2 = 0;
         while (j < am+1)
         {

             if(j==0){in1=0;in2=0;}

             in2 = new_w.indexOf(" ",in1);
          //   System.out.println(in1+" "+in2);
             if (in2 <0) in2 = new_w.length();
             if (in2-in1>0) {
                 words_n[j]=new_w.substring(in1,in2);
                    j++;}
             in1 = in2+1;
         }

        for(int i=0; i<words_n.length;i++){
            for(int k=words_n.length-1;k>i;k--){
                if(words_n[k-1].compareToIgnoreCase(words_n[k])>0){
                    String x=words_n[k-1];
                    words_n[k-1]=words_n[k];
                    words_n[k]=x;
                }
            }
        }
        for (String s : words_n) {
            System.out.print(s+" ");
        }

read.close();
    }

}
