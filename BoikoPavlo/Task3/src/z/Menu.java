package z;


import java.io.*;
import java.util.*;


public class Menu {

    List<Employee> list;
    boolean sorted = false;

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public void printMenuStart() {
        System.out.println("|                  MENU                     |");
        System.out.println("| Options:                                  |");
        System.out.println("|        1. Input new people                |");
        System.out.println("|        2. Open file with data             |");
        System.out.println("|        3. Exit                            |");
        inputMenuSelection();

    }

    public void inputMenuSelection() {
        int swValue;
        swValue = Keyin.inInt(" Select option: ");

        switch (swValue) {
            case 1:
                System.out.println("//////////////////////////////////////");
                System.out.println("Input new people");
                inputData();
                break;
            case 2:
                System.out.println("//////////////////////////////////////");
                System.out.println("Open file with data");
                openFile();
                break;
            case 3:
                System.out.println("//////////////////////////////////////");
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid selection (Must be 1-3 your options");
                inputMenuSelection();
                break;
        }
    }

    public void openFile() {
        List<File> lst = new ArrayList<>();

        try {
            java.lang.String EXTENSION = ".out";
            File[] files = new File(".").listFiles(new ExtensionFilter(EXTENSION));
            lst = Arrays.asList(files);
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }

        System.out.println("You can open " + lst.size() + " file(s)");

        for (int i = 1; i <= lst.size(); i++)
            System.out.println(String.valueOf(i) + ". " + lst.get(i - 1));

        int swValue;
        swValue = Keyin.inInt(" Select file ( 0 - go to menu)  ");

        int boolen = 2;
        if ((swValue <= lst.size()) && (swValue > 0))
            boolen = 1;
        else if (swValue == 0)
            boolen = 0;

        switch (boolen) {
            case 1:
                System.out.println("//////////////////////////////////////");
                System.out.println("Your choice - " + lst.get(swValue - 1));
                openFileChoice(lst.get(swValue - 1));
                printChoiseWithList();
          
                break;
            case 0:
                System.out.println("//////////////////////////////////////");
                System.out.println("Exit to menu");
                printMenuStart();
                break;
            default:
                System.out.println("//////////////////////////////////////");
                System.out.println("Invalid selection (Must be 1-3 your options");
                openFile();
                break;
        }

    }


    public void openFileChoice(File file) {
        try {
            String h = file.getName();
            list = new ArrayList<>();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(h));
            list = (List<Employee>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            printMenuStart();

        }
    }


    public void printChoiseWithList() {
        if(list.isEmpty()){
            System.out.println("Data is empty");
            printMenuStart();
        }
        else {
            System.out.println("| Options with list:                               |");
            System.out.println("|        1.              Sort                      |");
            System.out.println("|        2.            Print Data                  |");
            System.out.println("|     3.Sort and show first 5 names of workers     |");
            System.out.println("|     4.Sort and show last 3 id`s of workers       |");
            System.out.println("|        5.         Save in new file               |");
            System.out.println("|        6.        Exit to main menu               |");
            ChoiseWithList();
        }
    }


    public void ChoiseWithList() {
        int swValue;
        swValue = Keyin.inInt(" Select option: ");

        switch (swValue) {
            case 1:
                System.out.println("//////////////////////////////////////");
                System.out.println("  Sort  ");
                System.out.println("//////////////////////////////////////");
                sortList();
                printChoiseWithList();
                break;

            case 2:
                System.out.println("//////////////////////////////////////");
                System.out.println("      Print Data  ");
                System.out.println("//////////////////////////////////////");
                for (int i = 0; i < list.size(); i++)
                      System.out.println(list.get(i));
                printChoiseWithList();
                break;

            case 3:
                    System.out.println("//////////////////////////////////////");
                    System.out.println("Sort and show first 5 names of workers");
                    System.out.println("//////////////////////////////////////");
                    printFirstName(5);
                    printChoiseWithList() ;
                    break;

            case 4:
                   System.out.println("//////////////////////////////////////");
                   System.out.println("Sort and show last 3 id`s of workers");
                   System.out.println("//////////////////////////////////////");
                   printLastId(3);
                   printChoiseWithList();
                   break;

            case 5:
                System.out.println("//////////////////////////////////////");
                System.out.println("Save in file");
                System.out.println("//////////////////////////////////////");
                saveInFile();
                printChoiseWithList();
                break;

            case 6:
                 System.out.println("//////////////////////////////////////");
                 System.out.println(" Exit to main menu ");
                 System.out.println("//////////////////////////////////////");
                 sorted=false;
                 printMenuStart();
                 break;

            default:
                System.out.println("Invalid selection (Must be 1-3 your options");
                ChoiseWithList();
                break;
        }

    }

    public void printFirstName(int count){
        sortList();

        int c = count;
        if (list.size()<count) {
            c=list.size();
        }

        for (int i = 0; i < c; i++)
               System.out.println((i+1) + ".  Name :  " + list.get(i).getName());
    }


    public void printLastId(int count){
        sortList();

        int c = count;
        if (list.size()<count) {
            c=list.size();
        }

        for (int i = list.size(); i > list.size()-c; i--)
               System.out.println((list.size()-i+1) + ". ID =" + list.get(i-1).getId());
    }



    public void inputData(){
          int countHourlySalary;
          do {
              countHourlySalary = Keyin.inInt(" Please write How many people with hourly salary (not more 100 (100 not inclusive))");
          }  while (countHourlySalary<0 || countHourlySalary>100);

          int countFixedSalary;
          do {
              countFixedSalary = Keyin.inInt(" Please write How many people with fixed salary (not more 100 (100 not inclusive))");
          }  while (countFixedSalary<0||countFixedSalary>100);

          list = new ArrayList<>();
          int id=1;

          for (int i=0; i<countHourlySalary; i++) {
              if (i == 0)
                  System.out.println("Please write data about people with hourly salary:  ");
              System.out.println(i + 1 + ". ");
              String name;
              String surname;
              Double salary;
              System.out.println("Name : ");
              name = Keyin.inString();
              name = name.substring(0, 1).toUpperCase() + name.substring(1);
              System.out.println("Surname : ");
              surname = Keyin.inString();
              do {
                  salary = Keyin.inDouble("Hourly Salary: ");
              } while (salary<0);

              surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
              EmployeeHourlySalary one = new EmployeeHourlySalary(id, name, surname, salary);
              list.add(one);
              id++;
          }

          System.out.println("Please write data about people with fixed salary:  ");
          for (int i=0; i<countFixedSalary; i++){
              System.out.println(i+1 + ". ");

              String name;
              String surname;
              Double salary;

              System.out.println("Name : ");
              name = Keyin.inString() ;
              name=name.substring(0,1).toUpperCase()+name.substring(1)  ;

              System.out.println("Surname : ");
              surname =  Keyin.inString() ;
              surname=surname.substring(0,1).toUpperCase()+surname.substring(1)  ;

              salary =  Keyin.inDouble("Fixed Salary: ") ;
              EmployeeFixedSalary one = new EmployeeFixedSalary(id,name,surname,salary);

              list.add(one);
              id++;
          }

          printChoiseWithList();
    }


    public void saveInFile(){
        int numberFile;
        numberFile = Keyin.inInt(" Please write number new file ");

        try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("List" + Integer.toString(numberFile) + ".out"));
                out.writeObject(list);
                out.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
    }



    public void sortList() {
        if(sorted){
           System.out.println("List was sorted ");
        }
        else{
        Collections.sort(list, new SalaryAndNameComparator()) ;
        System.out.println("List are sort now");
        sorted=true;
        }

    }

}





