public class Khoa_MathStudent extends Khoa_AbStudent {
    private String id;

    public Khoa_MathStudent() {
        super();
        this.id = "";
    }

    public Khoa_MathStudent(String sName, double gpa, String id) {
        super(sName, gpa);
        this.id = id;
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getRank() {
        if (this.gpa >= 5.0) {
            return "Pass";
        }
        return "Fail";
    }

    public String toString() {
        return "MathStudent[name = " + getName() + ", id = " + this.id + ", gpa = " + getGPA() + "]";
    }
}