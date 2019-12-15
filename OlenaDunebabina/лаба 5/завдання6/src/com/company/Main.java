package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a word: ");
        String word = in.nextLine();
        System.out.println(word);
        char[] result = word.toCharArray();
        int n=1;
        for(int i=0;i<result.length-1;i++)
        { n++;}
        String [] words =new String[n];
        for (int i=0;i<n;i++)
        {
            words[i]=word.substring(i,i+1);
        }
        for (int i=n-2;i>=0;i--) {
            words[n - 1] += words[i];
        }
        System.out.println(words[n-1]);
}}
