public class Khoa_ITStudent extends Khoa_AbStudent {
    private int id;

    public Khoa_ITStudent() {
        super();
        this.id = 0;
    }

    public Khoa_ITStudent(String sName, double gpa, int id) {
        super(sName, gpa);
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getRank() {
        if (this.gpa > 8.0 && this.gpa <= 10.0) {
            return "A";
        } else if (this.gpa > 5.0 && this.gpa <= 8.0) {
            return "B";
        }
        return "C";
    }

    public String toString() {
        return "ITStudent[name = " + getName() + ", id = " + this.id + " , gpa = " + getGPA() + "]";
    }
}