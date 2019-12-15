abstract public class Worker implements Comparable<Worker>{
    String name;
    int id;
    double salary;

    Worker(String name_, int id_){
        name = name_;
        id = id_;
    }

    abstract double getSalary();

    @Override
    public int compareTo(Worker o) {
        if(this.salary==o.salary){
            return this.name.compareTo(o.name);
        }
        return (int) (o.salary-this.salary);
    }
}
