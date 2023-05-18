public class Khoa_Circle extends Khoa_Shape {
    private double radius;

    public Khoa_Circle() {
        super();
        this.radius = 0;
    }

    public Khoa_Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Khoa_Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    @Override
    public boolean equals(Khoa_Shape s) {
        if (s instanceof Khoa_Shape) {
            Khoa_Shape temp = (Khoa_Shape) s;
            if (this.getArea() == temp.getArea()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Circle{" + "Color = " + color + ", Filled = " + filled + '}' + ", Radius = " + radius + ", Perimeter = "
                + getPerimeter();
    }
}
