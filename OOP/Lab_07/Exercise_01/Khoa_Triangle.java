public class Khoa_Triangle extends Khoa_Shape {
    private double base;
    private double height;

    public Khoa_Triangle() {
        super();
        this.base = 0;
        this.height = 0;
    }

    public Khoa_Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public double getArea() {
        return (this.base * this.height) / 2;
    }

    public String toString() {
        return "Triangle{" + "Base = " + base + ", Height = " + height + ", color = " + color + '}';
    }
}
