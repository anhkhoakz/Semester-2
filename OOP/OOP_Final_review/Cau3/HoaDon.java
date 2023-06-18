public class HoaDon {
    protected String maHoaDon;
    protected String ngayLapHoaDon;
    protected String nguoiBan;
    protected String nguoiMua;
    protected String tenSanPham;
    protected int soLuong;
    protected double donGia;

    public HoaDon() {
        this.maHoaDon = "HD001";
        this.nguoiBan = "Nguyen Hoang";
        this.tenSanPham = "But bi Thien Long";
        this.soLuong = 20;
        this.donGia = 2500;
    }

    public double tinhThanhTien() {
        double giamGia = 0;
        if (this.soLuong > 1000) {
            giamGia = 0.04;
        }
        return soLuong * donGia * (1 - giamGia);
    }

    public double tinhThue() {
        return tinhThanhTien() * 0.1;
    }

    public double tinhTongTien() {
        return tinhThue() + tinhThanhTien();
    }

    public String xuatThongTin() {
        return maHoaDon + ", " + tenSanPham + ", " + nguoiMua + ", " + soLuong + ", " + donGia + ", " + tinhThanhTien()
                + ", " + tinhThue() + ", " + tinhTongTien();
    }
}