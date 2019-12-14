public class Fixedly extends Employee{
    double fixedPrice;

    Fixedly(String name, int id, double fixedPrice){
        super(name,id);
        this.fixedPrice = fixedPrice;
        this.salary = calculateSalary();
    }
    double calculateSalary() {
        return fixedPrice;
    }
}
