public class TestPoint {
    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point3D p11 = new Point3D();
        Point2D p2 = new Point2D(3.3f, 1.2f);
        Point3D p22 = new Point3D(p2.getX(), p2.getY(), 9.4f);

        System.out.println(p1);
        System.out.println(p11);
        System.out.println(p2);
        System.out.println(p22);
    }
}