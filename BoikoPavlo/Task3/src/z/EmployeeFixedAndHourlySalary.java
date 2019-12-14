package z;

class EmployeeFixedAndHourlySalary extends Employee{
    public double hourlySalary;
    public double fixefSalary;

    public EmployeeFixedAndHourlySalary(Integer id, String name, String surname, double hoursalar , double fixefSalary) {
        super(id, name, surname);
        this.hourlySalary = hoursalar;
        this.fixefSalary = fixefSalary;
        salary= hourlySalary*20.8*8 + this.fixefSalary ;
    }

    public EmployeeFixedAndHourlySalary(EmployeeFixedSalary employeeFixedSalary , double hoursalary){
        super(employeeFixedSalary.id, employeeFixedSalary.name,employeeFixedSalary.surname);
        this.hourlySalary = hoursalary;
        this.fixefSalary = employeeFixedSalary.getFixedSalary();
        salary= hourlySalary*20.8*8 + this.fixefSalary ;
    }

    public EmployeeFixedAndHourlySalary(EmployeeHourlySalary employeeHourlySalary , double hoursalary){
        super(employeeHourlySalary.id, employeeHourlySalary.name,employeeHourlySalary.surname);
        this.hourlySalary = hoursalary;
        this.fixefSalary = employeeHourlySalary.getHourlySalary();
        salary= hourlySalary*20.8*8 + this.fixefSalary ;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public double getFixefSalary() {
        return fixefSalary;
    }

    public void setFixefSalary(double fixefSalary) {
        this.fixefSalary = fixefSalary;
    }



    @Override
    public double getSalaryMonth() {
        return super.salary;
    }
}

