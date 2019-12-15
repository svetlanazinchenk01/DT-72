package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws IOException {
        FileWriter bl = new FileWriter("text.txt");
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 150; i++)
            list.add(i, (int) (Math.random() * 200));
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i=0;i<150;i++)
            list1.add(i, list.get(i));
        for (int i = 0; i < list1.size(); i++)
            System.out.println(list1.get(i));
        Collections.sort(list1);
        for (int i = 0; i<135; i++)
            list1.remove(0);
        for(int i=14;i>=0;i--)
            System.out.println("   sort   " +list1.get(i));
            for(int i=14;i>=0;i--)
            bl.write(list1.get(i)+"\n");

        bl.close();
}}

