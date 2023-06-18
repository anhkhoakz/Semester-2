public class loyalCustomer extends CongTy {
    public loyalCustomer(String id, String name, String gender, String address, int amount, int price) {
        this.ID = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.amount = amount;
        this.price = price;
    }

    public double thanhTien() {
        int giamGia = amount / 30;
        return (amount - giamGia) * price * 0.95;
    }

    public String toString() {
        return "Khach Hang Loyal: " + ID + ", " + name + ", " + gender + ", " + address + ", " + amount
                + ", " + thanhTien();
    }
}