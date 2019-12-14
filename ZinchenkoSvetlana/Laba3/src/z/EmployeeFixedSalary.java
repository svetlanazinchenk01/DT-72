package z;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EmployeeFixedSalary  extends Employee implements Serializable {
    public double fixedSalary;

    public EmployeeFixedSalary(Integer ID, String name, String surname, double fixedSalary) {
        super(ID, name, surname);
        this.fixedSalary = fixedSalary;
        salary=fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getSalaryMonth(){
        return fixedSalary;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        System.out.println("Our writeObject");
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        System.out.println("Our readObject");
    }

}

