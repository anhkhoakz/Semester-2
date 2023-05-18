public class Khoa_Square extends Khoa_Rectangle {
    public Khoa_Square() {
        super();
    }

    public Khoa_Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public void setWidth(double side) {
        setSide(side);
    }

    public void setLength(double side) {
        setSide(side);
    }

    public boolean equals(Khoa_Shape s) {
        if (s instanceof Khoa_Square) {
            Khoa_Square sq = (Khoa_Square) s;
            if (this.getArea() == sq.getArea()) {
                return true;
            }
        }
        return false;
    }
}