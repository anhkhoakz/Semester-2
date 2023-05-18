import java.util.ArrayList;

public class Khoa_Test<T> {
    private ArrayList<T> point = new ArrayList<T>();

    public void add(T obj) {
        point.add(obj);
    }

    public void display() {
        for (T obj : point) {
            System.out.println(obj);
        }
    }

    public void isInside() {
        for (T obj : point) {
            if ((((Khoa_Point) obj).getDistance()) <= 1.0) {
                System.out.println(obj + "is inside");
            } else {
                System.out.println(obj + "is not inside");
            }
        }
    }

    public static void main(String[] args) {
        Khoa_Test<Khoa_Point> pt = new Khoa_Test<Khoa_Point>();

        pt.add(new Khoa_Point(1.0, 2.0));
        pt.add(new Khoa_Point(0.5, 5.0));
        pt.add(new Khoa_Point(8.1, 3.3));
        pt.display();

        System.out.println("Check if points id inside circle(0,0), radius = 1");
        pt.isInside();
    }
}