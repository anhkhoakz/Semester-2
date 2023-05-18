public abstract class Khoa_Shape {
    protected String color;

    public Khoa_Shape() {
        this.color = "";
    }

    public Khoa_Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}