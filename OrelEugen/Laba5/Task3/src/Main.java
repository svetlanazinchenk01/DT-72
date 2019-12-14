import java.io.*;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static abstract class AbstractEmployee implements Comparable<AbstractEmployee> {
        protected final int id;
        protected final String name;

        public AbstractEmployee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public final String getName() {
            return name;
        }

        abstract double getAverageMonthlySalary();

        abstract String toCSV();

        @Override
        public String toString() {
            return "AbstractEmployee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    "averageMonthlySalary=" + getAverageMonthlySalary() +
                    '}';
        }

        @Override
        public int compareTo(AbstractEmployee that) {
            if (this.getAverageMonthlySalary() > that.getAverageMonthlySalary()) {
                return -1;
            } else if (this.getAverageMonthlySalary() < that.getAverageMonthlySalary()) {
                return 1;
            } else {
                return this.name.compareTo(that.name);
            }
        }
    }

    private static final class HourlyRateEmployee extends AbstractEmployee {
        private final double hourlyRate;

        public HourlyRateEmployee(int id, String name, double hourlyRate) {
            super(id, name);
            this.hourlyRate = hourlyRate;
        }

        @Override
        double getAverageMonthlySalary() {
            return 20.8 * 8.0 * hourlyRate;
        }

        @Override
        String toCSV() {
            return String.format("%c,%d,%s,%f", 'h', id, name, hourlyRate);
        }
    }

    private static final class FixedSalaryEmployee extends AbstractEmployee {
        private final double fixedSalary;

        public FixedSalaryEmployee(int id, String name, double fixedSalary) {
            super(id, name);
            this.fixedSalary = fixedSalary;
        }

        @Override
        double getAverageMonthlySalary() {
            return this.fixedSalary;
        }

        @Override
        String toCSV() {
            return String.format("%c,%d,%s,%f", 'f', id, name, fixedSalary);
        }
    }

    private static AbstractEmployee parseEmployee(String str) {
        String[] args = str.split(",");
        if (args.length == 4) switch (args[0]) {
            case "h":
                return new HourlyRateEmployee(
                        Integer.parseInt(args[1]),
                        args[2],
                        Double.parseDouble(args[3])
                );
            case "f":
                return new FixedSalaryEmployee(
                        Integer.parseInt(args[1]),
                        args[2],
                        Double.parseDouble(args[3])
                );
        }
        throw new RuntimeException("invalid format");
    }

    private static Collection<AbstractEmployee> readFromFile(File file) {
        try {
            return new BufferedReader(new FileReader(file))
                    .lines()
                    .map(Main::parseEmployee)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("error: file not found");
        } catch (Throwable t) {
            System.out.println("error: " + t.getMessage());
        }

        return null;
    }

    private static void writeToFile(Collection<AbstractEmployee> employees, File file) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            employees.stream().map(AbstractEmployee::toCSV).forEach(printWriter::println);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: invalid file");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Collection<AbstractEmployee> employees = readFromFile(new File("Employees.txt"));
        if (employees == null) {
            return;
        }

        List<AbstractEmployee> sorted = employees.stream().sorted().collect(Collectors.toList());

        System.out.println("sorted:");
        sorted.forEach(System.out::println);

        System.out.println("\nfirst 5:");
        sorted.stream().limit(5).map(AbstractEmployee::getName).forEach(System.out::println);

        System.out.println("\nlast 3:");
        sorted.stream().skip(Math.max(0, employees.size() - 3))
                .map(AbstractEmployee::getId).forEach(System.out::println);

        writeToFile(sorted, new File("EmployeesSorted.txt"));
    }
}