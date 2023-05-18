import java.util.*;

public class ArrayProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        System.out.println();

        menu();

        System.out.print("Enter your choice: ");
        int userChoice = sc.nextInt();
        System.out.println();

        sc.close();
        
        switch (userChoice) {
            case 0:
                return;
            case 1:
                System.out.println("Greatest even number in an array: " + maxEven(arr));
                break;
            case 2:
                System.out.println("Smallest odd number in an array: " + minOdd(arr));
                break;
            case 3:
                System.out.println("Sum of greatest even number and smallest odd number in an array: " + sumMEMO(arr));
                break;
            case 4:
                System.out.println("Sum of even number in an array: " + sumEven(arr));
                break;
            case 5:
                System.out.println("Product of odd number in an array: " + prodOdd(arr));
                break;
            case 6:
                System.out.println("Position of first even number in an array: " + idxFirstEven(arr));
                break;
            case 7:
                System.out.println("Position of last odd number in an array: " + idxLastOdd(arr));
                break;
            case 8:
                System.out.println("Array: " + Arrays.toString(input(n)));
                break;
            default:
                return;
        }
    }

    public static void menu() {
        System.out.println("\tMenu");
        System.out.println("0. Exit");
        System.out.println("1. Find the greatest even number in an array");
        System.out.println("2. Find the smallest odd number in an array");
        System.out.println("3. Calculate the sum of greatest even number and the smallest odd number in an array");
        System.out.println("4. Calculate the sum of even number in an array");
        System.out.println("5. Calculate the product of odd number in an array");
        System.out.println("6. Return the position of the first even number in an array");
        System.out.println("7. Return the position of the last odd number in an array");
        System.out.println("8. Return an array with 'n' elements which input from keybroad");
        System.out.println();
    }

    public static int maxEven(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max && a[i] % 2 == 0) {
                max = a[i];
            }
        }
        return max;
    }

    public static int minOdd(int[] a) {
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min && a[i] % 2 != 0) {
                min = a[i];
            }
        }
        return min;
    }

    public static int sumMEMO(int[] a) {
        return maxEven(a) + minOdd(a);
    }

    public static int sumEven(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sum += a[i];
            }
        }
        return sum;
    }

    public static int prodOdd(int[] a) {
        int product = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                product *= a[i];
            }
        }
        return product;
    }

    public static int idxFirstEven(int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int idxLastOdd(int[] arr) {
        int index = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int[] input(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arrNew = new int[n];
        for (int i = 0; i < arrNew.length; i++) {
            System.out.print("Enter arrNew[" + i + "]: ");
            arrNew[i] = sc.nextInt();
        }
        sc.close();
        return arrNew;
    }
}