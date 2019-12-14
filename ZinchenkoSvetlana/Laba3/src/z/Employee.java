package z;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;



abstract class Employee implements Serializable {
    public Integer id;
    public String name;
    public String surname;
    public Double salary = 0.00;

    public Employee(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "ID : " + id +
                ", name : " + name  +
                ", surname :" + surname  +
                ", salary :" + salary ;
    }

    public abstract double getSalaryMonth();
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Our writeObject");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Our readObject");
    }

}



class SalaryAndNameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee a, Employee b) {
        int result = 0;

        if(a.salary < b.salary)
        {
            result = 1;
        }
        else if(a.salary > b.salary)
        {
            result = -1;
        }
        if (result == 0) {
            result = a.name.compareToIgnoreCase(b.name);
        }
        return result;
    }
}

