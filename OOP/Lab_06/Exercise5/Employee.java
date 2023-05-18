public class Employee {
    protected String ID;
    protected String fullName;
    protected int yearJoined;
    protected double coefficientsSalary;
    protected int numDaysOff;

    public Employee() {
        this.ID = "0";
        this.fullName = "";
        this.yearJoined = 2020;
        this.coefficientsSalary = 1.0;
        this.numDaysOff = 0;
    }

    public Employee(String ID, String fullName, double coefficientsSalary) {
        this.ID = ID;
        this.fullName = fullName;
        this.coefficientsSalary = coefficientsSalary;
        this.yearJoined = 2020;
        this.numDaysOff = 0;
    }

    public Employee(String ID, String fullName, int yearJoined, double coefficientsSalary, int numDaysOff) {
        this.ID = ID;
        this.fullName = fullName;
        this.yearJoined = yearJoined;
        this.coefficientsSalary = coefficientsSalary;
        this.numDaysOff = numDaysOff;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearJoined() {
        return this.yearJoined;
    }

    public void setYearJoined(int yearJoined) {
        this.yearJoined = yearJoined;
    }

    public double getCoefficientsSalary() {
        return this.coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public int getNumDaysOff() {
        return this.numDaysOff;
    }

    public void setNumDaysOff(int numDaysOff) {
        this.numDaysOff = numDaysOff;
    }

    public double getSenioritySalary() {
        int yearOfWork = 2023 - this.yearJoined;
        if (yearOfWork >= 5)
            return (yearOfWork * 1150) / 100;
        return 0;
    }

    public String considerEmulation() {
        if (this.numDaysOff <= 1)
            return "A";
        else if (this.numDaysOff <= 3)
            return "B";
        return "C";
    }

    public double getSalary() {
        double basicSalary = 1150;
        double emulationCoefficient;
        String rating = considerEmulation();

        if (rating.equals("A"))
            emulationCoefficient = 1.0;
        else if (rating.equals("B"))
            emulationCoefficient = 0.75;
        else
            emulationCoefficient = 0.5;
        return basicSalary + basicSalary * (this.coefficientsSalary + emulationCoefficient) + getSenioritySalary();
    }

    @Override
    public String toString() {
        return "Employee[ID = " + this.ID + ", fullname = " + this.fullName + ", year joined = " + this.yearJoined
                + ", coefficient salary = " + this.coefficientsSalary + ", num days off = " + this.numDaysOff + "]";
    }
}