public class newCustomer extends CongTy {
    public newCustomer(String id, String name, String gender, String address, int amount, int price) {
        this.ID = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.amount = amount;
        this.price = price;
    }

    public double thanhTien() {
        return amount * price;
    }

    public String toString() {
        return "Khach Hang Moi: " + ID + ", " + name + ", " + gender + ", " + address + ", " + amount
                + ", " + thanhTien();
    }

}
