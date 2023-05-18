public class Khoa_Student {
    protected int ID;
    protected double score;

    public Khoa_Student() {
        this.ID = -1;
        this.score = -1;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Khoa_Student(int ID, double score) {
        setID(ID);
        setScore(score);
    }

    public int getID() {
        return this.ID;
    }

    public double getScore() {
        return this.score;
    }

    public String toString() {
        return "ID: " + getID() + ", Score: " + getScore();
    }
}
