public class vipCustomer extends CongTy {
    public vipCustomer(String id, String name, String gender, String address, int amount, int price) {
        this.ID = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.amount = amount;
        this.price = price;
    }

    public double thanhTien() {
        return amount * (price - 10) * 0.93;
    }

    public String toString() {
        return "Khach Hang VIP: " + ID + ", " + name + ", " + gender + ", " + address + ", " + amount
                + ", " + thanhTien();
    }
}