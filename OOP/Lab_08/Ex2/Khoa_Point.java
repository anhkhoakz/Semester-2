public class Khoa_Point {
    double x;
    double y;

    public Khoa_Point() {
        this(0.0, 0.0);
    }

    public Khoa_Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance() {
        return Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public String toString() {
        return "Point(" + this.x + ", " + this.y + "), distance = " + getDistance();
    }
}