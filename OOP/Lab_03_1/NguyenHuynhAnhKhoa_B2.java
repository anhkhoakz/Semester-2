import java.util.Scanner;

public class NguyenHuynhAnhKhoa_B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //tao ma tran 3x4
        int[][] matrix1 = {{1, 3, 4, 4}, {5, 6, 8, 6}, {7, 6, 3, 4}};
        int[][] matrix2 = {{2, 6, 5, 8}, {5, 6, 7, 1}, {3, 7, 6, 5}};

        //in ra 2 ma tran dang ma tran 3x4
        printMatrix(matrix1, "Ma tran 1");
        printMatrix(matrix2, "Ma tran 2");

        //tong 2 ma tran:
        System.out.println("Tong 2 ma tran:");
        addTwoMatrices(matrix1, matrix2);

        //nhan ma tran voi 1 so
        System.out.println("- Nhan ma tran voi 1 so:");
        System.out.println("Chon 1 ma tran:");
        System.out.println("1. Ma tran 1");
        System.out.println("2. Ma tran 2");
        int chon = sc.nextInt();
        System.out.print("Nhap vao 1 so muon nhan:");
        int x = sc.nextInt();
        //ket qua da in
        multiplyMatrix((chon == 1) ? matrix1 : matrix2, x);
    }

    public static void printMatrix(int[][] matrix, String name) {
        //in ra ma tran
        System.out.println(name + ":");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void addTwoMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] kq = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                kq[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        printMatrix(kq, "Tong 2 ma tran");
    }

    public static void multiplyMatrix(int[][] matrix, int x) {
        int[][] kq = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                kq[i][j] = matrix[i][j] * x;
            }
        }

        printMatrix(kq, "Ket qua da nhan");
    }
}