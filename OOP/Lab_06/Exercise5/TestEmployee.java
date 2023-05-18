public class TestEmployee {
    public static void main(String[] args) {
        Employee em1 = new Employee();
        Manager ma1 = new Manager();
        Employee em2 = new Employee("522H0080", "Tran Gia Hao", 2018, 1.5, 0);
        Manager ma2 = new Manager(em2.getID(), em2.getFullName(), em2.getCoefficientsSalary(),
                "Head of the administrator office", 6.0);

        System.out.println(em1);
        System.out.println(ma1);
        System.out.println();
        System.out.println(em2);
        System.out.println(ma2);
        System.out.println();
        System.out.println("Employee seniority salary = " + em1.getSenioritySalary());
        System.out.println("Employee salary = " + em1.getSalary());
        System.out.println("Manager seniority salary = " + ma1.getSenioritySalary());
        System.out.println("Manager salary = " + ma1.getSalary());
        System.out.println();
        System.out.println("Manger year joined = " + ma2.getYearJoined() + ", days off = " + ma2.getNumDaysOff());
        System.out.println("Employee seniority salary = " + em2.getSenioritySalary());
        System.out.println("Employee salary = " + em2.getSalary());
        System.out.println("Manager seniority salary = " + ma2.getSenioritySalary());
        System.out.println("Manager salary = " + ma2.getSalary());
    }
}