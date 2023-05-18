import java.util.ArrayList;
import java.util.Scanner;

public class Khoa_Vector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a length for vector X: ");
        int n = sc.nextInt();

        ArrayList<Integer> X = new ArrayList<>();

        enterVector(X, n, sc);

        System.out.println("Vector X: ");

        printVector(X);

        ArrayList<Integer> Y = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int element = 2 * X.get(i) * X.get(i) + 1;
            Y.add(element);
        }

        System.out.println();
        System.out.println("Vector Y: ");

        printVector(Y);

    }

    public static void enterVector(ArrayList<Integer> X, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int element = sc.nextInt();
            X.add(element);
        }
    }

    public static void printVector(ArrayList<Integer> X) {
        for (int element : X) {
            System.out.print(element + "  ");
        }
    }
}
