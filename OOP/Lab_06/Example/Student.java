public class Student extends Person {

  private float scoreMath;
  private float scorePhysical;
  private float scoreChemistry;

  public Student(
      String name,
      String address,
      float scoreMath,
      float scorePhysical,
      float scoreChemistry) {
    this.name = name;
    this.address = address;
    this.scoreMath = scoreMath;
    this.scorePhysical = scorePhysical;
    this.scoreChemistry = scoreChemistry;
  }

  public float getScoreMath() {
    return this.scoreMath;
  }

  public void setScoreMath(float score) {
    this.scoreMath = score;
  }

  public float getScorePhysical() {
    return this.scorePhysical;
  }

  public void setScorePhysical(float score) {
    this.scorePhysical = score;
  }

  public float getScoreChemistry() {
    return this.scoreChemistry;
  }

  public void setScoreChemistry(float score) {
    this.scoreChemistry = score;
  }
}
