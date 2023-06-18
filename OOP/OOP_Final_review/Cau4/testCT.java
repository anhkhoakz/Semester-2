import java.util.ArrayList;

public class testCT {
    public static void main(String[] args) {
        ArrayList<CongTy> khachHangLst = new ArrayList<>();

        khachHangLst.add(new newCustomer("CD01", "Dao Cu Dat", "Nam", "TPHCM", 10, 30000));
        khachHangLst.add(new loyalCustomer("CL01", "Quach Chan Long", "Nam", "TPHCM", 30, 25000));
        khachHangLst.add(new vipCustomer("GH01", "Tran Gia Hao", "Nam", "TPHCM", 1, 2500));

        for (CongTy kh : khachHangLst) {
            System.out.println(kh);
        }
    }
}
