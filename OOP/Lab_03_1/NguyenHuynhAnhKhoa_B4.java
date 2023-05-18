import java.util.Scanner;

public class NguyenHuynhAnhKhoa_B4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap vao 1 chuoi: ");
        String str = sc.nextLine();

        System.out.println("- Do dai cua chuoi da nhap la: " + str.length());
        System.out.println("- So tu trong chuoi da nhap la: " + str.split(" ").length);

        System.out.print("- Nhap vao 1 chuoi muon ghep: ");
        String content = sc.nextLine();

        System.out.println("Chuoi da ghep la: " + str.concat(content));

        if (isPalindrome(str)) {
            System.out.print("- Chuoi vua nhap la chuoi palindrome");
        } else {
            System.out.print("- Chuoi vua nhap khong phai la chuoi palindrome");
        }
    }

    public static boolean isPalindrome(String str) {
        String strCheck = str.toLowerCase().replaceAll(" ", "");
        StringBuilder reverse = new StringBuilder(strCheck).reverse();

        return strCheck.equals(reverse.toString());
    }
}