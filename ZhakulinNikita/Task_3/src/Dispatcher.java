import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dispatcher {
    static List<Employee> readFile(String filename){
        List<Employee> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String[] columns = input.nextLine().split(" ");
                if (columns[3].equals("Fixedly"))
                    list.add(new Fixedly(columns[0], Integer.parseInt(columns[1]), Double.parseDouble(columns[2])));
                else
                    list.add(new Hourly(columns[0], Integer.parseInt(columns[1]), Double.parseDouble(columns[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }
        return list;
    }

    static void writeFile(List<Employee> list, String filename){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Employee a : list) {
                String employeeType = a.getClass().getSimpleName();
                if(employeeType.equals("Hourly"))
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
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите один из представленных вариантов (1,2): \n\t1) Построить случайную последовательность работников;\n\t2) Загрузить последовательность из файла.");
        int k = in.nextInt();
        if(k==1) {
            List<Employee> list = new ArrayList<>();
            System.out.println("Введите желаемое количество работников:");
            int N = in.nextInt();
            for (int i = 0; i < N; i++) {
                String name = "Employee" + i;
                if (i % 2 == 0) {
                    double hourlyRate = (Math.random() * (10 - 6)) + 6;
                    list.add(new Hourly(name, i, hourlyRate));
                } else {
                    double fixedPrice = (Math.random() * (1700 - 1000)) + 1000;
                    list.add(new Fixedly(name, i, fixedPrice));
                }
            }
            System.out.println("Построенная последовательность работников (Имя, ИД, зарплата)");
            for (Employee a : list)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Отсортированная последовательность работников (Имя, ИД, зарплата)");
            Collections.sort(list);
            for (Employee a : list)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Топ 5 работников по зарплате (Имя)");
            for (int i = 0; i < 5; i++)
                System.out.println(list.get(i).name);
            System.out.println();

            System.out.println("Последние 3 работника по зарплате (ИД)");
            for (int i = list.size() - 3; i < list.size(); i++)
                System.out.println(list.get(i).id);
            System.out.println();

            System.out.println("Сохранить отсортированный список работников? (y)");
            Scanner in1 = new Scanner(System.in);
            String y = in1.nextLine();
            if(y.equals("y")){
                System.out.println("Введите имя файла:");
                String s = in1.nextLine();
                writeFile(list,s+".txt");
            }
            return;
        }
        if(k==2) {
            System.out.println("Введите имя файла для открытия ('in' для теста):");
            Scanner in1 = new Scanner(System.in);
            in.nextLine();
            String s = in.nextLine();
            List<Employee> list1 = readFile(s + ".txt");

            System.out.println("Построенная последовательность работников (Имя, ИД, зарплата)");
            for (Employee a : list1)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Отсортированная последовательность работников (Имя, ИД, зарплата)");
            Collections.sort(list1);
            for (Employee a : list1)
                System.out.println(a.name + ", " + a.id + ", " + a.salary);
            System.out.println();

            System.out.println("Топ 5 работников по зарплате (Имя)");
            for (int i = 0; i < 5; i++)
                System.out.println(list1.get(i).name);
            System.out.println();

            System.out.println("Последние 3 работника по зарплате (ИД)");
            for (int i = list1.size() - 3; i < list1.size(); i++)
                System.out.println(list1.get(i).id);
            System.out.println();

            System.out.println("Сохранить отсортированный список работников? (y)");
            Scanner in2 = new Scanner(System.in);
            String y = in1.nextLine();
            if(y.equals("y")){
                System.out.println("Введите имя файла:");
                String sh = in1.nextLine();
                writeFile(list1,sh+".txt");
            }
            return;
        }
        else
            System.out.println("Неправильный код");
    }
}
