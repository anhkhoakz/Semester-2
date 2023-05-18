public class Khoa_MoveableCircle implements Khoa_Moveable {
    int radius;
    Khoa_MoveablePoint center;

    public Khoa_MoveableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new Khoa_MoveablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public String toString() {
        return "MoveableCircle[radius = " + this.radius + ", center = " + this.center + "]";
    }

    public void moveUp() {
        center.moveUp();
    }

    public void moveDown() {
        center.moveDown();
    }

    public void moveLeft() {
        center.moveLeft();
    }

    public void moveRight() {
        center.moveRight();
    }
}