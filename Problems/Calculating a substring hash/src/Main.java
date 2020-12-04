import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] s = scanner.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        for (int i = 1; i <= text.length(); i++) {
            if (i != text.length()) {
                System.out.print(hashCod(text.substring(0, i)) + " ");
            } else {
                System.out.print(hashCod(text.substring(0, i)));
            }
        }
        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.print(hashIJ(text, arr[i][0], arr[i][1]) + " ");
        }
    }

    public static long charToLong(char ch) {
        return (long)(ch - 'A' + 1);
    }

    public static long hashCod(String text) {
        /* 2 */
        int a = 53;
        long m = 1_000_000_000 + 9;

        /* 3 */
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < text.length(); i++) {
            currSubstrHash += charToLong(text.charAt(text.length() - text.length() + i)) * pow;
            currSubstrHash %= m;

            if (i != text.length() - 1) {
                pow = pow * a % m;
            }
        }
        return currSubstrHash;
    }

    public static long hashIJ(String text, int i, int j) {
        long firstHash = hashCod(text.substring(0, j));
        long secondHash = hashCod(text.substring(0, i));
        long m = 1_000_000_000 + 9;
        long answer = (firstHash - secondHash) % m;
        if (answer < 0) {
            return m + answer;
        }
        return (firstHash - secondHash) % m;
    }
}