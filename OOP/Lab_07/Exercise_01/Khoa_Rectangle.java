public class Khoa_Rectangle extends Khoa_Shape {
    private double length;
    private double width;

    public Khoa_Rectangle() {
        super();
        this.length = 0;
        this.width = 0;
    }

    public Khoa_Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return this.length * this.width;
    }

    public double getPerimeter() {
        return (this.length + this.width) * 2.0;
    }

    public String toString() {
        return "Rectangle{" + "length = " + length + ", width = " + width + ", color = " + color + '}';
    }
}
