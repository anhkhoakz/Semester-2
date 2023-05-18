public class JavaBasic {
    public static int sumNegativeElements(int a[]) {
        // sinh vien code tai day
        int sum = 0;
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                sum += a[i];
            }
        }
        return sum;
    }

    public static String uppercaseFirstVowels(String str) {
        // sinh vien code tai day
        String[] words = str.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            if ("aeiou".indexOf(firstChar) != -1) {
                char capitalizedChar = Character.toUpperCase(firstChar);
                word = capitalizedChar + word.substring(1);
                words[i] = word;
            }
        }
        String newString = String.join(" ", words);
        return newString;
    }

    public static int findMinNegativeElement(int a[]) {
        // sinh vien code tai day
        int minIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 && a[i] < minIndex) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static String getName(String str) {
        // sinh vien code tai day
        return str.substring(8);
    }

    public static int findFirstMod3Element(int[] a) {
        // sinh vien code tai day
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int countString(String str, String k) {
        // sinh vien code tai day
        String[] words = str.split(" ");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].toUpperCase().equals(k.toUpperCase())) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = { 1, -2, 3, 4, -2, 1, -9 };
        String s = "nguyen thi uyen an";
        String s1 = "Ho ten: Nguyen Thi Anh Dao";
        String s2 = "Nguyen Phuong Hoang Anh Phuong Oanh";
        // sinh vien code tai day
        System.out.println("Tổng các phần tử âm: " + sumNegativeElements(a));
        System.out.println("Chuỗi in hoa các ký tự đầu tiên của mỗi từ và là nguyên âm: " + uppercaseFirstVowels(s));
        System.out.println("Vị trí số âm nhỏ nhất trong mảng: " + findMinNegativeElement(a));
        System.out.println("Vị trí số đầu tiên trong mảng chia hết cho 3: " + findFirstMod3Element(a));
        System.out.println(getName(s1));
        System.out.println("số lượng từ k trong chuỗi str truyền vào: " + countString(s2, "phuong"));
    }

}