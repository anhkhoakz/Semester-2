public class HoaDonGiaoHang extends HoaDon {
    private String diaChi;
    private double khoangCach;
    private double thoiGianGiao;

    public HoaDonGiaoHang() {
        super();
        diaChi = "Q. Tan Phu";
        khoangCach = 20;
        thoiGianGiao = 24;
    }

    public double tinhThanhTien() {
        double phiGiao;
        if (thoiGianGiao < 24) {
            if (khoangCach < 10) {
                phiGiao = 20 * khoangCach * soLuong;
            } else {
                phiGiao = 18 * khoangCach * soLuong;
            }
        } else {
            phiGiao = 150000;
        }
        return super.tinhThanhTien() + phiGiao;
    }

    public String xuatThongTin() {
        return super.xuatThongTin() + ", " + (tinhThanhTien() - super.tinhThanhTien());
    }
}
