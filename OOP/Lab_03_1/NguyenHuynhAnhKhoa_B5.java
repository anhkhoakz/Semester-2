import java.util.*;

public class NguyenHuynhAnhKhoa_B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao 1 chuoi:");
        String paragraph = sc.nextLine();

        System.out.println("Dem so tu xuat hien trong chuoi:");
        countWordsAppear(paragraph);
    }

    public static void countWordsAppear(String paragraph) {
        String[] words = paragraph.toLowerCase().replaceAll("[,.!?;:()+-_*/<>=]", "").split(" ");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}