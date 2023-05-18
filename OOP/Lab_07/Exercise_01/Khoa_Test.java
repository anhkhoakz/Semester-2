public class Khoa_Test {
    public static void main(String[] args) {
        Khoa_Shape s = new Khoa_Rectangle(3, 4, "White");
        System.out.println(s.toString());
        System.out.println("Area = " + s.getArea());

        s = new Khoa_Triangle(4, 5, "Black");
        System.out.println(s.toString());
        System.out.println("Area = " + s.getArea());
    }
}
