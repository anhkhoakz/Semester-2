public class MathStudent extends Student
{
    private String sID;

    public MathStudent()
    {
        super();
        this.sID = "522H0000";
    }

    public MathStudent(String sName, double gpa, String sID)
    {
        super(sName, gpa);
        this.sID = sID;
    }

    public String getRank()
    {
        if(this.gpa >= 5.0)
            return "Pass";
        return "Fail";
    }

    public String toString()
    {
        return this.sName + " - " + this.sID + " - " + this.gpa;
    }
}