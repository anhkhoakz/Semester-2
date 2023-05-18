import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpperCase {
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner inputContent = new Scanner(input);

            FileWriter output = new FileWriter("output.txt");

            while (inputContent.hasNextLine()) {
                String data = inputContent.nextLine();
                output.write(data.toUpperCase());
                if (inputContent.hasNextLine()) {
                    output.write("\n");
                }
            }

            System.out.println("Successfully uppercase to output.txt");

            inputContent.close();
            output.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
