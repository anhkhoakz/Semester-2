public abstract class Khoa_AbStudent {
    protected String sName;
    protected double gpa;

    public Khoa_AbStudent() {
        this("", 0.0);
    }

    public Khoa_AbStudent(String sName, double gpa) {
        this.sName = sName;
        this.gpa = gpa;
    }

    public String getName() {
        return this.sName;
    }

    public void setName(String sName) {
        this.sName = sName;
    }

    public double getGPA() {
        return this.gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public abstract String getRank();

    public String toString() {
        return "Student[name = " + this.sName + ", gpa = " + this.gpa + "]";
    }
}