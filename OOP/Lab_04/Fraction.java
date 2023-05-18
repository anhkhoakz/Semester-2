public class Fraction {

  private int numerator;
  private int denominator;

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    reduce();
  }

  public Fraction(Fraction f) {
    this.numerator = f.numerator;
    this.denominator = f.denominator;
  }

  public void add(Fraction f) {
    int lcm = getLCM(denominator, f.denominator);
    numerator =
      numerator * (lcm / denominator) + f.numerator * (lcm / f.denominator);
    denominator = lcm;
    reduce();
  }

  public void sub(Fraction f) {
    int lcm = getLCM(denominator, f.denominator);
    numerator =
      numerator * (lcm / denominator) - f.numerator * (lcm / f.denominator);
    denominator = lcm;
    reduce();
  }

  public void mul(Fraction f) {
    numerator *= f.numerator;
    denominator *= f.denominator;
    reduce();
  }

  public void div(Fraction f) {
    if (f.numerator == 0) {
      throw new IllegalArgumentException("Cannot divide by zero");
    }
    numerator *= f.denominator;
    denominator *= f.numerator;
    reduce();
  }

  public void reduce() {
    int gcd = getGCD(numerator, denominator);
    numerator /= gcd;
    denominator /= gcd;
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
  }

  public String toString() {
    if (denominator == 1) {
      return Integer.toString(numerator);
    } else {
      return numerator + "/" + denominator;
    }
  }

  private int getGCD(int a, int b) {
    return b == 0 ? a : getGCD(b, a % b);
  }

  private int getLCM(int a, int b) {
    return a * b / getGCD(a, b);
  }
}
