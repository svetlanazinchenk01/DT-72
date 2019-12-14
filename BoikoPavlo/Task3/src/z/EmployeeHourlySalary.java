package z;

import java.io.Serializable;
import java.util.Comparator;

public  class EmployeeHourlySalary extends Employee implements Serializable{
    public double hourlySalary;

    public EmployeeHourlySalary(Integer ID, String name, String surname, double hourlySalary) {
        super(ID, name, surname);
        this.hourlySalary = hourlySalary;
        salary=hourlySalary*20.8*8;
    }

    public EmployeeHourlySalary() {
        super();
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getSalaryMonth(){
        return hourlySalary*20.8*8;
    }



}



