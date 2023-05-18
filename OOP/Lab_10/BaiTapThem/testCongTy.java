import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testCongTy {
    public static void main(String[] args) {
        try {
            File file = new File ("data.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
    }
}
