import java.util.Scanner;

public class NguyenHuynhAnhKhoa_B3 {

    public static String getFirstNameLastName(String fullName) {
        String[] parts = fullName.split(" ");
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        return firstName + " " + lastName;
    }

    public static String getMiddleName(String fullName) {
        String[] names = fullName.split(" ");

        if (names.length == 2) {
            return null;
        } else if (names.length % 2 == 0) {
            int middleIndex = names.length / 2;
            return names[middleIndex - 1] + " " + names[middleIndex];
        } else {
            int middleIndex = names.length / 2;
            return names[middleIndex];
        }
    }

    public static String capitalizeFullName(String fullName) {
        String[] parts = fullName.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                sb.append(Character.toUpperCase(part.charAt(0)));
                sb.append(part.substring(1).toLowerCase());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static String convertName(String name) {
        StringBuilder convertedName = new StringBuilder();
        for (char c : name.toCharArray()) {
            if (isVowel(c)) {
                convertedName.append(Character.toUpperCase(c));
            } else {
                convertedName.append(Character.toLowerCase(c));
            }
        }
        return convertedName.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao ho va ten: ");
        String name = sc.nextLine();

        System.out.println(getFirstNameLastName(name));
        System.out.println(getMiddleName(name));
        System.out.println(capitalizeFullName(name));
        System.out.println(convertName(name));

    }
}