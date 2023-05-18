public class Khoa_Employee {
    protected String ID;
    protected int salary;

    public Khoa_Employee() {
        this.ID = "";
        this.salary = -1;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Khoa_Employee(String ID, int Salary) {
        setID(ID);
        setSalary(Salary);
    }

    public String getID() {
        return this.ID;
    }

    public int getSalary() {
        return this.salary;
    }

    public String toString() {
        return "ID: " + getID() + ", Salary: " + getSalary();
    }
}
