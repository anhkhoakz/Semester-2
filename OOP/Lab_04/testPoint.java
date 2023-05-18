public class testPoint {

  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point(5.0f, 10.5f);
    System.out.println("x1 =" + p1.getX());
    System.out.println("y1 =" + p1.getY());
    System.out.println("x2 =" + p2.getX());
    System.out.println("y2 =" + p2.getY());
  }
}
