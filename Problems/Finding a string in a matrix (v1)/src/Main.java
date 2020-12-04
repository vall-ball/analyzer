import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String size = scanner.nextLine();
        int rows = Integer.parseInt(size.split(" ")[0]);
        int columns = Integer.parseInt(size.split(" ")[1]);
        String[] arr = new String[rows];
        for (int i = 0; i < rows; i++) {
            arr[i] = scanner.nextLine();
        }
        List<Integer> kmp = KMPSearch(toOneString(arr), pattern);
        System.out.println(kmp.size());
        for (int i : kmp) {
            System.out.println(coor(i, rows, columns));
        }

    }

    public static String toOneString(String[] arr) {
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static String coor(int i, int rows, int columns) {
        //System.out.println("i " + i );
        int a = i / columns;
        int b = i % columns;
        return a + " " + b;
    }

    public static int[] prefixFunction(String str) {
        /* 1 */
        int[] prefixFunc = new int[str.length()];

        /* 2 */
        for (int i = 1; i < str.length(); i++) {
            /* 3 */
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            /* 4 */
            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            /* 5 */
            prefixFunc[i] = j;
        }

        /* 6 */
        return prefixFunc;
    }

    public static List<Integer> KMPSearch(String text, String pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        int j = 0;
        /* 2 */
        for (int i = 0; i < text.length(); i++) {
            /* 3 */
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            /* 4 */
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            /* 5 */
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }
        /* 6 */
        return occurrences;
    }
}