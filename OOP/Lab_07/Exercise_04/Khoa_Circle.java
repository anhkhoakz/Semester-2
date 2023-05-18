public class Khoa_Circle implements Khoa_GeometricObject {
    protected double radius;

    public Khoa_Circle() {
        this.radius = 1.0;
    }

    public Khoa_Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }
}