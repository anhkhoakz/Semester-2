public class GiayTheThao extends CongTy {
    private String loaiGiay;
    private double donGia;

    public GiayTheThao() {
        super();
        setLoaiGiay("");
        setDonGia(0);
    }

    public GiayTheThao(String maSanPham, String tenSanPham, String chatLieu, double kichCo, String mauSac,
            int namSanXuat, String loaiGiay, double donGia) {
        super(maSanPham, tenSanPham, chatLieu, kichCo, mauSac, namSanXuat);
        setLoaiGiay(loaiGiay);
        setDonGia(donGia);

    }

    public void setLoaiGiay(String loaiGiay) {
        this.loaiGiay = loaiGiay;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getLoaiDay() {
        return this.loaiGiay;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public double thanhTien() {
        double tongCong = getDonGia() * 65000 + 30000;
        if (getLoaiDay().equalsIgnoreCase("running")) {
            return tongCong + 30000;
        } else {
            return tongCong + 25000;
        }
    }

    public String xuatThongTin() {
        return getMaSanPham() + ", " + getTenSanPham() + ", " + getChatLieu() + ", " + getKichCo() + ", " + getMauSac()
                + ", " + getNamSanXuat() + ", " + getLoaiDay() + ", " + getDonGia() + ", "  + thanhTien();
    }
}
