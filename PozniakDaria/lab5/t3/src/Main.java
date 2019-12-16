import java.util.*;
import java.io.*;

public class Main {
    abstract static class Employee implements Comparable<Employee>{
        String name;
        double salaryPerMonth;
        int id;

        Employee(String inputName, int inputId) {
            name = inputName;
            id = inputId;

        }

        Employee() {
            this.name = "Ivan";
            this.id = 1;
        }
     //get, set
        private String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name=name;
        }
        private double getMonthly(){
            return this.salaryPerMonth;
        }
        protected void setMonthly(double salaryInMonth) {
            this.salaryPerMonth = salaryInMonth;
        }
        private int getId() {
            return this.id;
        }
        public void setId(Integer id) {
            this.id=id;
        }
     //methods
        public String toString() {
            return (this.getId() + " " + this.getName() + " average: " + this.getMonthly());
        }

        public int compareTo(Employee w) {
            if(this.salaryPerMonth < w.salaryPerMonth) return -1;
            else if(this.salaryPerMonth > w.salaryPerMonth) return 1;
            else return this.getName().compareTo(w.getName())*(-1);
        }

    }

// descendant 1
    static class PartTime extends Employee {
        private double paidPerHour;

        PartTime(String inputName, int inputId,double inputPayPerHour) {
            super(inputName,inputId);
            paidPerHour = inputPayPerHour;
            monthSalary(inputPayPerHour);
        }
        PartTime( ) {
            paidPerHour = 1000;
            monthSalary(1000);
        }


        private double getPaidPerHour() {
            return this.paidPerHour;
        }

        public void setPaidPerHour(double paidPerHour) {
            this.paidPerHour = paidPerHour;
        }

        @Override
        public String toString() {
            String s = super.toString();
            return (s+ "     per hour: "+this.getPaidPerHour());
        }

        void monthSalary(double income) {
            setMonthly( 20.8 * 8 * income);
        }

    }

// descendant 2
    public static class FullTime extends Employee {
        private double payPerMonth;

        FullTime(String inputName, int inputId,double inputPayPerMonth) {
            super(inputName,inputId);
            payPerMonth = inputPayPerMonth;
            monthSalary(inputPayPerMonth);
        }

        FullTime() {
            payPerMonth = 1000;
            monthSalary(1000);
        }

        private double getPayPerMonth() { return this.payPerMonth; }
        public void setPayPerMonth(double payPerMonth) { this.payPerMonth=payPerMonth; }

        @Override
        public String toString() {
            String s = super.toString();
            return (s+ "     per month: "+this.getPayPerMonth());
        }

        void monthSalary(double income) {
            setMonthly(income);
        }
    }


    public static void main(String[] args) {
        try {
            File fromFile = new File("D:\\3 курс\\t3\\company.txt");
            List<Employee> myList = readFromFile(fromFile);
            if (myList.isEmpty()) System.out.println("EMPTY FILE");
            else {
                printDataBase(myList);
                File toFile = new File("my_company.txt");
                writeToFile(myList, toFile);
                System.out.println("\n\nSort");
                sortDataBase(myList);
                System.out.println("\n_______________________________________________");

                //output 5 first names of sorted myList
                System.out.println("Output 5 first names of sorted list");
                for (int i = 0; i < 5; i++) System.out.println(myList.get(i).getName());
                System.out.println("_______________________________________________");

                //output 3 last id of sorted myList
                System.out.println("Output 3 last id of sorted list");
                for (int i = myList.size() - 1; i > myList.size() - 4; i--) System.out.println(myList.get(i).getId());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("INCORRECT FILE");
        }
    }
    private static void sortDataBase(List<Employee> myList){
        Collections.sort(myList,Collections.reverseOrder());
        for (Employee aMyList : myList) {
            System.out.println(aMyList.getId() + " " + aMyList.getName() + " average: " + aMyList.getMonthly());
        }

    }

    private static void printDataBase(List<Employee> myList){
        for (Employee aMyList : myList) {
            System.out.println(aMyList.toString());
        }
    }

    private static void writeToFile(List<Employee> myList, File file){
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Employee aMyList : myList) {
                printWriter.print(aMyList.toString() + "\n");
            }
            printWriter.close();
        }
        catch (IOException i) {
            System.out.println("\nIOException occurred.");
        }
    }

    private static List<Employee>readFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file, "ISO-8859-1");
        List<Employee> myList = new ArrayList<Employee>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            if (correctRecord(words)) {
                if (words[3].equalsIgnoreCase("m")) {
                    FullTime f = new FullTime(words[1], Integer.parseInt(words[0]), Double.parseDouble(words[2]));
                    myList.add(f);
                }
                if (words[3].equalsIgnoreCase("h")) {
                    PartTime p = new PartTime(words[1], Integer.parseInt(words[0]), Double.parseDouble(words[2]));
                    myList.add(p);
                }
            }
        }
        scanner.close();
        return myList;
    }

    private static boolean correctRecord(String[] words){
        if (words.length == 4)
            if (words[0].matches("[0-9]+") && words[2].matches("[0-9]+(\\.[0-9]*)?"))
                if (words[1].matches("[a-zA-Z]+"))
                    if (words[3].equalsIgnoreCase("m") ||words[3].equalsIgnoreCase("h"))
                        return true;
        return false;
    }
}
