class Student {
    String name;
    String address;
    String sex;
    double score;

    public Student(String name, String address, String sex, double score) {
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.score = score;
    }

    class StudentOperator {
        void print() {
            System.out.println("Student [" + name + ", " + address + ", " + sex + ", " + score + "]");
        }

        String type() {
            if (score > 8) {
                return "A";
            } else if (score >= 5 && score <= 8) {
                return "B";
            } else {
                return "C";
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Test case 1: A student with score 9.
        Student student1 = new Student("John Smith", "123 Main St", "Male", 9);
        Student.StudentOperator operator1 = student1.new StudentOperator();
        operator1.print();
        System.out.println("Student rank: " + operator1.type());

        // Test case 2: A student with score 4.
        Student student2 = new Student("Tom Brown", "789 Oak St", "Male", 4);
        Student.StudentOperator operator2 = student2.new StudentOperator();
        operator2.print();
        System.out.println("Student rank: " + operator2.type());

        // Test case 3: A female student with score 6.
        Student student3 = new Student("Jessica Lee", "101 Maple Ave", "Female", 6);
        Student.StudentOperator operator3 = student3.new StudentOperator();
        operator3.print();
        System.out.println("Student rank: " + operator3.type());

        // Test case 4: A male student with score 11.
        Student student4 = new Student("Jack Johnson", "456 Elm St", "Male", 11);
        Student.StudentOperator operator4 = student4.new StudentOperator();
        operator4.print();
        System.out.println("Student rank: " + operator4.type());
    }
}
