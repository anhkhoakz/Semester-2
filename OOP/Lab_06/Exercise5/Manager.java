public class Manager extends Employee {
    private String position;
    private double coefficientSalaryByPosition;

    public Manager() {
        super();
        this.position = "Head of the administrative office";
        this.coefficientSalaryByPosition = 5.0;
    }

    public Manager(String ID, String fullName, double coefficientsSalary, String position,
            double coefficientSalaryByPosition) {
        super(ID, fullName, coefficientsSalary);
        this.position = position;
        this.coefficientSalaryByPosition = coefficientSalaryByPosition;
    }

    public Manager(String ID, String fullName, int yearJoined, double coefficientsSalary, int numDaysOff,
            String position, double coefficientSalaryByPosition) {
        super(ID, fullName, yearJoined, coefficientsSalary, numDaysOff);
        this.position = position;
        this.coefficientSalaryByPosition = coefficientSalaryByPosition;
    }

    @Override
    public String considerEmulation() {
        return "A";
    }

    public double bonusByPosition() {
        double basicSalary = 1150;
        return basicSalary * this.coefficientSalaryByPosition;
    }

    @Override
    public double getSalary() {
        double basicSalary = 1150;
        double emulationCoefficient = 1.0;
        return basicSalary + basicSalary * (getCoefficientsSalary() + emulationCoefficient) + getSenioritySalary()
                + bonusByPosition();
    }

    @Override
    public String toString() {
        return "Manager[ID = " + getID() + ", fullname = " + getFullName() + ", year joined = " + getYearJoined()
                + ", coefficient salary = " + getCoefficientsSalary() + ", num days off = " + getNumDaysOff()
                + ", position = " + this.position + ", coefficient salary by position = "
                + this.coefficientSalaryByPosition + "]";
    }
}