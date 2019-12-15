public class Hour extends Worker{
    double hourSalary;

    Hour(String name_, int id_, double hourlyRate_){
        super(name_,id_);
        hourSalary = hourlyRate_;
        salary = getSalary();
    }
    double getSalary(){
        return 20.8*8*hourSalary;
    }
}
