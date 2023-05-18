public class testFraction {

  public static void main(String[] args) {
    Fraction f1 = new Fraction(2, 3);
    Fraction f2 = new Fraction(3, 4);
    f1.add(f2);
    System.out.println(f1);

    f1.sub(f2);
    System.out.println(f1);

    f1.mul(f2);
    System.out.println(f1);

    f1.div(f2);
    System.out.println(f1);
  }
}
