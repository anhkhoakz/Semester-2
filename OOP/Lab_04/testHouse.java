public class testHouse {

  public static void main(String[] args) {
    House house1 = new House();
    System.out.println(house1.toString());

    House house2 = new House("A02", 3, true, 120, 3000000);
    System.out.println(house2.toString());

    house1.setArea(80);
    System.out.println(house1.toString());
  }
}
