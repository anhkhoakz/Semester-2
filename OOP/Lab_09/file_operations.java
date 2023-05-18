import java.io.*;

public class file_operations {
    public static void main(String[] args) throws IOException {

        // Get specific files by extensions from a given folder
        File directory = new File("path/to/directory");
        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // Change the extension as per requirement
            }
        });

        // Check if a file or directory specified by pathname exists or not
        File file = new File("path/to/file_or_directory");
        if (file.exists()) {
            System.out.println("File or directory exists.");
        } else {
            System.out.println("File or directory does not exist.");
        }

        // Check if the given pathname is a directory or a file
        if (file.isDirectory()) {
            System.out.println("Given pathname is a directory.");
        } else {
            System.out.println("Given pathname is a file.");
        }

        // Append text to an existing file
        FileWriter writer = new FileWriter("path/to/file", true); // Pass true to append instead of overwriting
        writer.write("This text will be appended to the file.");
        writer.close();

        // Find the longest word in a text file
        String longestWord = "";
        FileReader reader = new FileReader("path/to/file");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }
        bufferedReader.close();
        System.out.println("Longest word in the file: " + longestWord);

    }
}
