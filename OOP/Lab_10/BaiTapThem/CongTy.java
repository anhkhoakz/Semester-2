public abstract class CongTy {
    protected String maSanPham;
    protected String tenSanPham;
    protected String chatLieu;
    protected double kichCo;
    protected String mauSac;
    protected int namSanXuat;

    public CongTy() {
        this("", "", "", -1, "", -1);
    }

    public CongTy(String maSanPham, String tenSanPham, String chatLieu, double kichCo, String mauSac, int namSanXuat) {
        setMaSanPham(maSanPham);
        setTenSanPham(tenSanPham);
        setChatLieu(chatLieu);
        setKichCo(kichCo);
        setMauSac(mauSac);
        setNamSanXuat(namSanXuat);
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public void setKichCo(double kichCo) {
        this.kichCo = kichCo;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getMaSanPham() {
        return this.maSanPham;
    }

    public String getTenSanPham() {
        return this.tenSanPham;
    }

    public String getChatLieu() {
        return this.chatLieu;
    }

    public double getKichCo() {
        return this.kichCo;
    }

    public String getMauSac() {
        return this.mauSac;
    }

    public int getNamSanXuat() {
        return this.namSanXuat;
    }
}