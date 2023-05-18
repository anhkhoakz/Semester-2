public class Teacher extends Person {

  private String subject;

  public Teacher() {
    super();
    this.subject = "";
  }

  public Teacher(String name, String address, String subject) {
    super(name, address);
    this.subject = subject;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
