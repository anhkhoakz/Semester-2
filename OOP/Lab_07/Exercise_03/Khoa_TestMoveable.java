public class Khoa_TestMoveable {
    public static void main(String[] args) {
        Khoa_Moveable m = new Khoa_MoveablePoint(1, 3, 5, 3);
        System.out.println(m);

        m = new Khoa_MoveableCircle(1, 3, 5, 3, 5);
        System.out.println(m);
    }
}