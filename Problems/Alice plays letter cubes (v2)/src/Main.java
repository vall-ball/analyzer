import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() == 0) {
            System.out.println(1);
        } else if (s.length() == 1) {
            System.out.println(2);
        } else {
            /*int[] prefix = prefixFunction(s);
            for (int j : prefix) {
                System.out.print(j + " ");
            }*/
            int i = 2;
            int answer = 2;
            while (i <= s.length()) {
                String s1 = s.substring(0, i);
                answer += s1.length() - max(prefixFunction(new StringBuilder(s1).reverse().toString()));
                i++;
            }
            System.out.println(answer);
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

    public static int max(int[] prefix) {
     /*  if (prefix.length <= 1) {
            return 0;
       }*/
        int answer = prefix[0];

        for (int i = 1; i < prefix.length; i++) {
            if (answer < prefix[i]) {
                answer = prefix[i];
            }
        }
        return answer;
    }
}
