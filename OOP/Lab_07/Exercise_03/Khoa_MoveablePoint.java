public class Khoa_MoveablePoint implements Khoa_Moveable {
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public Khoa_MoveablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return "MoveablPoint[x = " + this.x + ", y = " + this.y + ", x speed = " + this.xSpeed + ", y speed = "
                + this.ySpeed + "]";
    }

    public void moveUp() {
        this.y = this.y - this.xSpeed;
    }

    public void moveDown() {
        this.y = this.y + this.xSpeed;
    }

    public void moveLeft() {
        this.x = this.x - this.ySpeed;
    }

    public void moveRight() {
        this.x = this.x + this.ySpeed;
    }
}