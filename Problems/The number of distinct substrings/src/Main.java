import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Set<Long> set = new HashSet<>();

        int a = 53;
        long m = 1_000_000_000 + 9;

        for (int i = 0; i < str.length(); i++) {
            long currSubstrHash = 0;
            long pow = 1;
            String text = str.substring(i);
            for (int j = 0; j < text.length(); j++) {
                currSubstrHash += charToLong(text.charAt(j)) * pow;
                currSubstrHash %= m;
                if (j != text.length() - 1) {
                    pow = pow * a % m;
                }
                set.add(currSubstrHash);
                //System.out.println("i =" + i + " j=" + j);
                //System.out.println(text);


            }
        }
       // System.out.println(str.length());
        System.out.println(set.size() + 1);

    }

    public static long charToLong(char ch) {
        return (long)(ch - 'A' + 1);
    }



    public static long rabinKarpHash(String text) {
        /* 2 */
        int a = 53;
        long m = 1_000_000_000 + 9;

        /* 3 */
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < text.length(); i++) {
            currSubstrHash += charToLong(text.charAt(i)) * pow;
            currSubstrHash %= m;

            if (i != text.length() - 1) {
                pow = pow * a % m;
            }
        }
        return currSubstrHash;
    }
}

/*
       for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < str.length() - i + 1; j++) {
                //System.out.println(str.substring(j, j + i));
                set.add(rabinKarpHash(str.substring(j, j + i)));
            }
        }
 */