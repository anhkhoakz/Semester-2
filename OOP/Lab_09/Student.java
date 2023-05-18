public abstract class Student
{
    protected String sName;
    protected double gpa;

    public Student()
    {
        this("", 0.0);
    }

    public Student(String sName, double gpa)
    {
        this.sName = sName;
        this.gpa = gpa;
    }

    public abstract String getRank();

    public String toString()
    {
        return this.sName + " - " + this.gpa;
    }
}