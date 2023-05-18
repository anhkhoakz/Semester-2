public abstract class Khoa_Shape {
    protected String color;
    protected boolean filled;

    public Khoa_Shape() {
        this.color = "";
        this.filled = false;
    }

    public Khoa_Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public boolean equals(Khoa_Shape s) {
        if (s instanceof Khoa_Shape) {
            Khoa_Shape temp = (Khoa_Shape) s;
            if (this.getArea() == temp.getArea()) {
                return true;
            }
        }
        return false;
    }

    public abstract double getPerimeter();

    public String toString() {
        return "Shape{" + "Color = " + color + ", Filled = " + filled + '}';
    }
}