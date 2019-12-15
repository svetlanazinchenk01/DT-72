package com.company;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Worker
{
    protected String name;
    protected int id;
    protected double salary;
    public Worker()
    {
        name = " ";
        id = 0;
        salary = 0;
    }
    public Worker (String name, int id, double salary)
    {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void Count() {}
    public void GetInfo() {System.out.println(" Name: "+name+  "  Id:  " +id+  "  Salary: "+salary);}
    public String GetName() {return name;}
    public int GetId() {return id;}
    public double GetSalary() {return salary;}

}

class Worker_Hour extends Worker
{

    public Worker_Hour()
    { super();}

    public Worker_Hour (String name, int id, double salary)
    {
        super(name,id,salary);
    }

    public void Count()
    {
        salary*=20.8*8;
    }
}

class Worker_Month extends Worker
{
    public Worker_Month()
    {super();}
    public Worker_Month(String name, int id, double salary)
    {
        super(name,id,salary);
    }
    public void Count()
    {
        salary = salary;
    }
}


public class Main {

    public static void bubbleSort(Worker[] array) {
        boolean sorted = false;
        double temp;
        int temp2;
        String temp1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i].salary < array[i + 1].salary) {
                    temp = array[i].salary;
                    array[i].salary = array[i + 1].salary;
                    array[i + 1].salary = temp;
                    temp1 = array[i].name;
                    array[i].name = array[i + 1].name;
                    array[i + 1].name = temp1;
                    temp2 = array[i].id;
                    array[i].id = array[i + 1].id;
                    array[i + 1].id = temp2;
                    sorted = false;
                }
            }

        }
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i].salary == array[i + 1].salary)
                    if (array[i].name.compareTo(array[i + 1].name) > 0) {
                        temp = array[i].salary;
                        array[i].salary = array[i + 1].salary;
                        array[i + 1].salary = temp;
                        temp1 = array[i].name;
                        array[i].name = array[i + 1].name;
                        array[i + 1].name = temp1;
                        temp2 = array[i].id;
                        array[i].id = array[i + 1].id;
                        array[i + 1].id = temp2;
                        sorted = false;
                    }
            }
        }
    }

        public static void main (String [] args) throws IOException {
            FileWriter writer = new FileWriter("notes.txt");
            FileReader writ = new FileReader("notes.txt");
            Scanner scan = new Scanner(writ);

            Worker[] array = new Worker[10];
            array[0] = new Worker_Hour("Kate", 46, 150);
            array[1] = new Worker_Hour("Tom", 47, 120);
            array[3] = new Worker_Hour("Alex", 48, 125);
            array[4] = new Worker_Hour("Derek", 49, 130);
            array[5] = new Worker_Hour("Vasya", 50, 145);
            array[6] = new Worker_Month("Lena", 11, 14500);
            array[7] = new Worker_Month("Olga", 12, 19400);
            array[8] = new Worker_Month("Anna", 13, 19400);
            array[9] = new Worker_Month("Petr", 14, 24500);
            array[2] = new Worker_Month("Jane", 15, 10500);
            for (int i = 0; i < 10; i++) {
                array[i].Count();
                array[i].GetInfo();
            }
            bubbleSort(array);
            for (int i = 0; i < 10; i++) {
                array[i].GetInfo();
            }
            for (int i = 0;i<5;i++)
            {System.out.println(array[i].name);}
            for (int i=9; i>6; i--)
            {System.out.println(array[i].id);}
            for (int i=0;i<10;i++)
            {
                 writer.write(array[i].GetName()+" " + array[i].GetId()+" " + array[i].GetSalary()+"\n");
            }
            writer.close();
            Worker[] input= new Worker[10];
            System.out.println("array read from file");
            for(int i=0; i<input.length;i++)
            {
                String test=scan.nextLine();
                String[] words =test.split(" ");
                String name = words[0];
                int id=Integer.parseInt(words[1]);
                double salary = Double.parseDouble(words[2]);
                input[i]=new Worker_Month(name,id,salary);
                input[i].GetInfo();
            }
            writ.close();
        }


    }
