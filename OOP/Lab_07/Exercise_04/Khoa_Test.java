public class Khoa_Test {
    public static void main(String[] args) {
        Khoa_GeometricObject g = new Khoa_Circle(2.0);
        System.out.println(g.getArea() + ", " + g.getPerimeter());

        Khoa_Resizeable r = new Khoa_ResizeableCirlce(10.0);
        r.resize(50);
    }
}