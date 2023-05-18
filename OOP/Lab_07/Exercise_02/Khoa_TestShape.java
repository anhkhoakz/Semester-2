public class Khoa_TestShape {
    public static void main(String[] args) {
        Khoa_Shape s = new Khoa_Circle(5.0, "blue", true);
        System.out.println(s);

        s = new Khoa_Rectangle(5.0, 2.0, s.getColor(), s.isFilled());
        System.out.println(s);

        s = new Khoa_Square(3.0, "white", true);
        System.out.println(s);
        System.out.println();

        Khoa_Shape s1 = new Khoa_Circle(1.0, "red", false);
        System.out.println("cirlce s = Khoa_circle s1 ? = " + s.equals(s1));

        Khoa_Shape s2 = new Khoa_Square(3.0, "white", true);
        System.out.println("square s = square s2 ? = " + s.equals(s2));
        System.out.println();

        Khoa_Shape[] shapes = new Khoa_Shape[5];
        shapes[0] = new Khoa_Circle(4, "Red", true);
        shapes[1] = new Khoa_Rectangle(8, 4, "Blue", true);
        shapes[2] = new Khoa_Square(10, "Black", true);
        shapes[3] = new Khoa_Circle(9);
        shapes[4] = new Khoa_Rectangle(12, 8, "Blue", true);

        // in ra cac dien tich cua array shapes trong class Khoa_Shape
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Area " + i + " = " + shapes[i].getArea());
        }

        // tim dien tich lon nhat trong array shapes cua class Khoa_Shape
        double maxArea = 0;
        for (int i = 0; i < shapes.length; i++) {
            double area = shapes[i].getArea();
            if (area > maxArea) {
                maxArea = area;
            }
        }

        System.out.println();
        System.out.println("The largest area in a array is = " + maxArea);
    }
}