abstract public class Employee implements Comparable<Employee>{
    String name;
    int id;
    double salary;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        if(this.salary==o.salary){
            return this.name.compareTo(o.name);
        }
        return (int) (o.salary-this.salary);
    }
}
