public class DepSandal extends CongTy {
    private double soQuai;
    private String loaiDe;
    private double donGia;

    public DepSandal() {
        super();
        setSoQuai(0);
        setLoaiDe("");
        setDonGia(0);
    }

    public DepSandal(String maSanPham, String tenSanPham, String chatLieu, double kichCo, String mauSac,
            int namSanXuat, double soQuai, String loaiDe, double donGia) {
        super(maSanPham, tenSanPham, chatLieu, kichCo, mauSac, namSanXuat);
        setSoQuai(soQuai);
        setLoaiDe(loaiDe);
        setDonGia(donGia);
    }

    public void setSoQuai(double soQuai) {
        this.soQuai = soQuai;
    }

    public void setLoaiDe(String loaiDe) {
        this.loaiDe = loaiDe;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getSoQuai() {
        return this.soQuai;
    }

    public String getLoaiDe() {
        return this.loaiDe;
    }

    public double getDonGia() {
        return this.donGia;
    }

    public double thanhTien() {
        return getDonGia() * 35000 + getSoQuai() * 5000;
    }

    public String xuatThongTin() {
        return getMaSanPham() + ", " + getTenSanPham() + ", " + getChatLieu() + ", " + getKichCo() + ", " + getMauSac()
                + ", " + getNamSanXuat() + ", " + getSoQuai() + ", " + getLoaiDe() + ", " + getDonGia() + ", "
                + thanhTien();
    }
}