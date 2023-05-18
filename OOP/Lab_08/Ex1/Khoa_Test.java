public class Khoa_Test {
    public static void main(String[] args) {
        Khoa_Model<Khoa_Person> person = new Khoa_Model<Khoa_Person>();
        person.add(new Khoa_Person("Nguyen Huynh Anh Khoa", 2004));
        person.add(new Khoa_Person("Tran Gia Hao", 2003));
        person.display();

        System.out.println();

        Khoa_Model<Khoa_Student> student = new Khoa_Model<Khoa_Student>();
        student.add(new Khoa_Student(52200046, 8.6));
        student.add(new Khoa_Student(52200073, 9));
        student.display();

        System.out.println();

        Khoa_Model<Khoa_Employee> employee = new Khoa_Model<Khoa_Employee>();
        employee.add(new Khoa_Employee("KT2246", 17000000));
        employee.add(new Khoa_Employee("NS522H", 20000000));
        employee.display();
    }
}
