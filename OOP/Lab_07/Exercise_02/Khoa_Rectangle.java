public class Khoa_Rectangle extends Khoa_Shape {
    protected double width;
    protected double length;

    public Khoa_Rectangle() {
        super();
        this.width = 0;
        this.length = 0;
    }

    public Khoa_Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public boolean equals(Khoa_Shape s) {
        if (s instanceof Khoa_Rectangle) {
            Khoa_Rectangle r = (Khoa_Rectangle) s;
            if (this.getArea() == r.getArea()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Rectangle[width = " + this.width + ", length = " + this.length + ", area = " + getArea()
                + ", perimeter = " + getPerimeter() + ", color = " + getColor() + ", filled = " + isFilled() + "]";
    }
}