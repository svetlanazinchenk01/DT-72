package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int value = (int)(Math.random()*100);
        Scanner in = new Scanner (System.in);
        System.out.println("Enter number from 0 to 100");

        int a=0, b=100;
        int number=0;
        do
        {
           number=in.nextInt();
            while (number >b || number < a)
            {
                System.out.println("ENTER NUMBER FROM" +a+ "to" +b);
                number = in.nextInt();
            }
            if (number < value)
            {
                System.out.println("Almost!:) Try something bigger");
                a = number;
                System.out.println("Would better between ["+a+";"+b+"]");
            }
            else if (number > value)
            {
                System.out.println("Almost!:) Try something less");
                b = number;
                System.out.println("Would better between [ " +a+ ";"+b+"]");
            }
            else
            { System.out.println("My congratulations. You won!"); }

        } while (number != value);

    }
}
