import java.io.*;
import java.util.Scanner;

public class SumFile {
    public static void main(String[] args) {
        try {
            int sum = 0;

            File inputFile = new File("input.txt");
            Scanner inputReader = new Scanner(inputFile);

            while (inputReader.hasNextInt()) {
                int n = inputReader.nextInt();
                sum += n;
            }

            inputReader.close();

            FileWriter outputFile = new FileWriter("output.txt");
            outputFile.write(String.valueOf(sum));
            System.out.println("Successfully wrote to the output.txt");
            outputFile.close();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
