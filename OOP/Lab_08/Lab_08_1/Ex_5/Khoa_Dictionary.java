import java.util.HashMap;
import java.util.Scanner;

public class Khoa_Dictionary {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("banana", "a long curved fruit with a yellow skin");
        dictionary.put("chocolate", "a sweet food made from cocoa beans");
        dictionary.put("elephant", "a large mammal with a long nose and ivory tusks");
        dictionary.put("guitar", "a musical instrument with six strings and a hollow body");
        dictionary.put("jazz", "a genre of music characterized by improvisation and swing rhythms");
        dictionary.put("kangaroo", "a marsupial with powerful hind legs and a long tail");
        dictionary.put("laptop", "a portable computer that can be used on your lap");
        dictionary.put("mountain", "a large natural elevation of the earth's surface");
        dictionary.put("ocean", "a large body of salt water that covers most of the earth's surface");
        dictionary.put("zebra", "an African mammal with black and white stripes");

        try (Scanner sc = new Scanner(System.in)) {
            String word;
            do {
                System.out.print("Enter a word to lookup or enter '0' to exit: ");
                word = sc.nextLine();

                switch (word) {
                    case "0":
                        break;
                    default:
                        String meaning = dictionary.get(word);
                        if (meaning != null) {
                            System.out.println("'" + word + "' is " + meaning);
                        } else {
                            System.out.println("'" + word + "' does not exist in the dictionary");
                        }
                        break;
                }
            } while (!word.equals("0"));
        }
    }
}
