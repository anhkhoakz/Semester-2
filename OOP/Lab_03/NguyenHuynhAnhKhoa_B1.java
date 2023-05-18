import java.util.Scanner;
import java.util.Arrays;

public class NguyenHuynhAnhKhoa_B1 {
    public static boolean removeElement(int[] arr, int n) {
        int arr_length = arr.length;
        int i, j;
        for (i = 0; i < arr_length; i++) {
            if (arr[i] == n) {
                for (j = i; j < arr_length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr_length - 1] = 0;
                return true;
            }
        }
        return false;
    }

    public static void insertElement(int[] arr, int element, int index) {
        int temp = arr[index];
        arr[index] = element;
        for (int i = index + 1; i < arr.length; i++) {
            int temp2 = arr[i];
            arr[i] = temp;
            temp = temp2;
        }
    }

    public static String findDuplicates(int[] arr) {
        int[] duplicates = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    int temp = 0;
                    for (int k = 0; k < count; k++) {
                        if (duplicates[k] == arr[i]) {
                            temp = 1;
                            break;
                        }
                    }
                    if (temp == 0) {
                        duplicates[count] = arr[i];
                        count++;
                    }
                    break;
                }
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = duplicates[i];
        }
        String result_str = Arrays.toString(result);
        return result_str;
    }

    public static String removeDuplicates(int[] arr) {
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < count; j++) {
                if (result[j] == arr[i]) {
                    temp = 1;
                    break;
                }
            }
            if (temp == 0) {
                result[count] = arr[i];
                count++;
            }
        }
        int[] finalResult = new int[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }
        String finalResult_str = Arrays.toString(finalResult);
        return finalResult_str;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.println("Nhap vao so phan tu cua mang: ");
            n = sc.nextInt();
        } while (n < 0);

        int arr[] = new int[n];

        System.out.println("Nhap vao cac phan tu cua mang: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap vao phan tu thu " + i + ": ");
            arr[i] = sc.nextInt();
        }


        String arr_str = Arrays.toString(arr);
        System.out.println(arr_str);

        System.out.println("Nhap vao mot so muon xoa: ");
        int x = sc.nextInt();

        System.out.println(removeElement(arr, x));

        System.out.println("Nhap vao mot so muon them vao: ");
        x = sc.nextInt();

        System.out.println("Nhap vao vi tri them so: ");
        int index = sc.nextInt();

        insertElement(arr, x, index);

        arr_str = Arrays.toString(arr);
        System.out.println(arr_str);

        System.out.println(findDuplicates(arr));

        System.out.println(removeDuplicates(arr));
    }
}