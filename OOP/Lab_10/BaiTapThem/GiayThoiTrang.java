public class GiayThoiTrang extends CongTy {
    private double chieuCaoDe;
    private String loaiMuiGiay;
    private double donGia;

    public GiayThoiTrang() {
        super();
        setChieuCaoDe(0);
        setLoaiMuiGiay("");
        setDonGia(0);
    }

    public GiayThoiTrang(String maSanPham, String tenSanPham, String chatLieu, double kichCo, String mauSac,
            int namSanXuat, double chieuCaoDe, String loaiMuiGiay, double donGia) {
        super(maSanPham, tenSanPham, chatLieu, kichCo, mauSac, namSanXuat);
        setChieuCaoDe(chieuCaoDe);
        setLoaiMuiGiay(loaiMuiGiay);
        setDonGia(donGia);
    }

    public void setChieuCaoDe(double chieuCaoDe) {
        this.chieuCaoDe = chieuCaoDe;
    }

    public void setLoaiMuiGiay(String loaiMuiGiay) {
        this.loaiMuiGiay = loaiMuiGiay;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getChieuCaoDe() {
        return this.chieuCaoDe;
    }

    public String getLoaiMuiGiay() {
        return this.loaiMuiGiay;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public double thanhTien() {
        double tongCong = getDonGia() * 50000 + getChieuCaoDe() * 2000;
        if (getLoaiMuiGiay().equalsIgnoreCase("mui nhon")) {
            return tongCong + 125000;
        } else {
            return tongCong + 10000;
        }
    }

    public String xuatThongTin() {
        return getMaSanPham() + ", " + getTenSanPham() + ", " + getChatLieu() + ", " + getKichCo() + ", " + getMauSac()
                + ", " + getNamSanXuat() + ", " + getChieuCaoDe() + ", " + getLoaiMuiGiay() + ", " + getDonGia() + ", " + thanhTien();
    }
}