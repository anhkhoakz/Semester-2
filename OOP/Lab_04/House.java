public class House {

  private String houseCode;
  private int numOfBedRooms;
  private boolean hasSwimmingPool;
  private double area;
  private double costPerSquareMeter;

  public House() {
    this.houseCode = "A01";
    this.numOfBedRooms = 2;
    this.hasSwimmingPool = false;
    this.area = 0;
    this.costPerSquareMeter = 0;
  }

  public House(
    String houseCode,
    int numOfBedRooms,
    boolean hasSwimmingPool,
    double area,
    double costPerSquareMeter
  ) {
    this.houseCode = houseCode;
    this.numOfBedRooms = numOfBedRooms;
    this.hasSwimmingPool = hasSwimmingPool;
    this.area = area;
    this.costPerSquareMeter = costPerSquareMeter;
  }

  public String getHouseCode() {
    return houseCode;
  }

  public void setHouseCode(String houseCode) {
    this.houseCode = houseCode;
  }

  public int getNumOfBedRooms() {
    return numOfBedRooms;
  }

  public void setNumOfBedRooms(int numOfBedRooms) {
    this.numOfBedRooms = numOfBedRooms;
  }

  public boolean isHasSwimmingPool() {
    return hasSwimmingPool;
  }

  public void setHasSwimmingPool(boolean hasSwimmingPool) {
    this.hasSwimmingPool = hasSwimmingPool;
  }

  public double getArea() {
    return area;
  }

  public void setArea(double area) {
    this.area = area;
  }

  public double getCostPerSquareMeter() {
    return costPerSquareMeter;
  }

  public void setCostPerSquareMeter(double costPerSquareMeter) {
    this.costPerSquareMeter = costPerSquareMeter;
  }

  public double calculateSellingPrice() {
    double subTotal = area * costPerSquareMeter;

    if (hasSwimmingPool) {
      subTotal *= 1.1;
    }

    return subTotal * 1.15;
  }

  public String toString() {
    return (
      "House[" +
      "houseCode='" +
      houseCode +
      '\'' +
      ", numOfBedRooms=" +
      numOfBedRooms +
      ", hasSwimmingPool=" +
      hasSwimmingPool +
      ", sellingPrice=" +
      calculateSellingPrice() +
      "]"
    );
  }
}
