public class Hourly extends Employee{
    double hourlyRate;

    Hourly(String name, int id, double hourlyRate){
        super(name,id);
        this.hourlyRate = hourlyRate;
        this.salary = calculateSalary();
    }
    double calculateSalary(){
        return 20.8*8*hourlyRate;
    }
}
