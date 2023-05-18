public class Khoa_ResizeableCirlce extends Khoa_Circle implements Khoa_Resizeable {
    public Khoa_ResizeableCirlce() {
        super();
    }

    public Khoa_ResizeableCirlce(double radius) {
        super(radius);
    }

    public void resize(int percent) {
        this.radius = this.radius * (percent / 100.0);
    }
}