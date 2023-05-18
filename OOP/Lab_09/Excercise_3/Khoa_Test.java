import java.util.ArrayList;

public class Khoa_Test {
    public ArrayList<Khoa_AbStudent> findStudent(ArrayList<Khoa_AbStudent> lstStu) {
        ArrayList<Khoa_AbStudent> result = new ArrayList<>();

        for (Khoa_AbStudent stu : lstStu) {
            String rank = stu.getRank();
            if (rank.equals("A") || rank.equals("Pass")) {
                result.add(stu);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Khoa_AbStudent> lstStu = new ArrayList<Khoa_AbStudent>();

        lstStu.add(new Khoa_ITStudent("Nguyen Huynh Anh Khoa", 8.4, 5220046));
        lstStu.add(new Khoa_ITStudent("Tran Gia Hao", 8.1, 5220080));
        lstStu.add(new Khoa_MathStudent("Pham Bao Long", 9.0, "522H0062"));
        lstStu.add(new Khoa_MathStudent("Lam Phu Cuong", 4.5, "21D"));

        for (Khoa_AbStudent stu : lstStu) {
            System.out.println(stu);
        }

        System.out.println();
        System.out.println("Students who has 'A' ranked or 'Pass': ");

        Khoa_Test find = new Khoa_Test();

        ArrayList<Khoa_AbStudent> result = find.findStudent(lstStu);

        for (Khoa_AbStudent stu : result) {
            System.out.println(stu);
        }
    }
}