import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        List<Integer> list = KMPSearch(text, pattern);
        List<Integer> answer = new ArrayList<>();
        if (list.isEmpty()) {
            System.out.println(0);
        } else if (list.size() == 1) {
            System.out.println(1);
            System.out.println(0);
        } else {
            answer.add(list.get(0));
            int j = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) >= answer.get(j) + pattern.length()) {
                    //System.out.println(list.get(i));
                    //System.out.println(answer.get(j));
                    answer.add(list.get(i));
                    j++;
                }
            }
            System.out.println(answer.size());
            for (int i : answer) {
                System.out.print(i + " ");
            }
        }

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
