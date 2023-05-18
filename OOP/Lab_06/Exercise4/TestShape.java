public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        Circle c1 = new Circle();
        Rectangle r1 = new Rectangle();
        Square sq1 = new Square();

        Shape s2 = new Shape("blue", false);
        Circle c2 = new Circle(6.0, s2.getColor(), s2.isFilled());
        Rectangle r2 = new Rectangle(5.0, 3.0, s2.getColor(), s2.isFilled());
        Square sq2 = new Square(5.0, s2.getColor(), s2.isFilled());

        System.out.println(s1);
        System.out.println(c1);
        System.out.println(r1);
        System.out.println(sq1);
        System.out.println();
        System.out.println(s2);
        System.out.println(c2);
        System.out.println(r2);
        System.out.println(sq2);
    }
}