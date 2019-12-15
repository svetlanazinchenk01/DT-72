import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Worker> readFromFile(String filename){
        ArrayList<Worker> arrayList = new ArrayList();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String[] s = input.nextLine().split(" ");
                if (s[3].equals("Fix"))
                    arrayList.add(new Fix(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2])));
                else
                    arrayList.add(new Hour(s[0], Integer.parseInt(s[1]), Double.parseDouble(s[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return arrayList;
    }

    static void writeToFile(ArrayList<Worker> arrayList, String filename){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Worker a : arrayList) {
                String employeeType = a.getClass().getSimpleName();
                if(employeeType.equals("Hour"))
                {
                    double salary = a.salary/(20.8*8);
                    writer.write(a.name + " " + a.id + " " + salary + " " + employeeType);
                }
                else
                    writer.write(a.name + " " + a.id + " " + a.salary + " " + employeeType);
                writer.newLine();
            }
            writer.close();
        } catch(IOException e){
            System.out.println("IOException");
        }
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose your option: \n\t1) Build a random sequence of workers;\n\t2) Load from file.");
        int k = input.nextInt();
        if(k==1) {
            ArrayList<Worker> arrayList = new ArrayList();
            System.out.println("Number of workers to generate:");
            int N = input.nextInt();
            for (int i = 0; i < N; i++) {
                String name = "Worker_" + i;
                if (i % 2 == 0) {
                    double hourSalary = (Math.random() * 7) + 5;
                    arrayList.add(new Hour(name, i, hourSalary));
                } else {
                    double fixedPrice = (Math.random() * 900) + 900;
                    arrayList.add(new Fix(name, i, fixedPrice));
                }
            }
            System.out.println("Random sequence of workers:");
            for (Worker a : arrayList)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Sorted workers sequence:");
            Collections.sort(arrayList);
            for (Worker a : arrayList)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Names of the first 5 workers");
            for (int i = 0; i < 5; i++)
                System.out.println(arrayList.get(i).name);
            System.out.println();

            System.out.println("IDs of the last 3 workers");
            for (int i = arrayList.size() - 3; i < arrayList.size(); i++)
                System.out.println(arrayList.get(i).id);
            System.out.println();

            System.out.println("Save to file? [y]");
            Scanner input1 = new Scanner(System.in);
            String y = input1.nextLine();
            if(y.equals("y")){
                System.out.println("Type filename:");
                String s = input1.nextLine();
                writeToFile(arrayList,s+".txt");
            }
            return;
        }
        if(k==2) {
            System.out.println("Type filename to open ('in' for test):");
            Scanner input1 = new Scanner(System.in);
            //input1.nextLine();
            String s = input1.nextLine();
            ArrayList<Worker> arrayList = readFromFile(s + ".txt");

            System.out.println("Sequence of workers:");
            for (Worker a : arrayList)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Sorted workers sequence:");
            Collections.sort(arrayList);
            for (Worker a : arrayList)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Names of the first 5 workers");
            for (int i = 0; i < 5; i++)
                System.out.println(arrayList.get(i).name);
            System.out.println();

            System.out.println("IDs of the last 3 workers");
            for (int i = arrayList.size() - 3; i < arrayList.size(); i++)
                System.out.println(arrayList.get(i).id);
            System.out.println();

            System.out.println("Save to file? [y]");
            Scanner input2 = new Scanner(System.in);
            String y = input2.nextLine();
            if(y.equals("y")){
                System.out.println("Type filename:");
                String z = input2.nextLine();
                writeToFile(arrayList,z+".txt");
            }
            return;
        }
        else
            System.out.println("Wrong variant");
    }
}
