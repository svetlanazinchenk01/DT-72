public class Fix extends Worker{
    double fixedSalary;

    Fix(String name_, int id_, double fixedSalary_){
        super(name_,id_);
        fixedSalary = fixedSalary_;
        this.salary = getSalary();
    }
    double getSalary() {
        return fixedSalary;
    }
}
