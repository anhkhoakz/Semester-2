public class testStudent {

  public static void main(String[] args) {
    Student st1 = new Student(52200006, "Nguyen", "Khoa");
    Student st2 = new Student(52200090, "Manh", "Cuong");

    System.out.println("Fullname Sutdent1 = " + st1.getName());
    System.out.println("Fullname Student2 = " + st2.getName());
    System.out.println(st1);
    System.out.println(st2);

    st2.setFirstName("Nhat");
    st2.setLastName("Hao");

    System.out.println();
    System.out.println("After set: ");
    System.out.println();
    System.out.println(st2);
    System.out.println("Fullname Student2 = " + st2.getName());
  }
}
