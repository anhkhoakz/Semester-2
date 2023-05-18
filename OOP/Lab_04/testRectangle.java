public class testRectangle {

  public static void main(String[] args) {
    Rectangle r1 = new Rectangle();
    Rectangle r2 = new Rectangle(2f, 4f);
    System.out.println(r1);
    System.out.println(r2);

    System.out.println("Area: " + r1.getArea());
    System.out.println("Perimeter: " + r1.getPerimeter());

    System.out.println("Area: " + r2.getArea());
    System.out.println("Perimeter: " + r2.getPerimeter());
  }
}
