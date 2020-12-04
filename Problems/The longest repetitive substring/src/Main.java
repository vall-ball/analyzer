import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        boolean answer = false;
        Map<Long, List<String>> map = new TreeMap<>();
        Set<Long> set = new HashSet<>();
        for (int i = text.length() - 1; i >= 1; i--) {
            for (int j = 0; j < text.length() - i + 1; j++) {
                String pattern = text.substring(j, j + i);
                long hash = hash(pattern);
                //System.out.println(pattern);
                //System.out.println(hash);
                // if (set.contains(hash)) {
                if (map.containsKey(hash) && map.get(hash).contains(pattern)) {
                    System.out.println(pattern.length());
                    return;
                } else if (map.containsKey(hash)) {
                    List<String> list = map.get(hash);
                    list.add(pattern);
                } else {
                    List<String> list = new ArrayList<>();
                    map.put(hash, list);
                }


            }
            map.clear();
        }
        System.out.println(0);
    }

    /* 1 */
    public static long charToLong(char ch) {
        return (long)(ch - 'A' + 1);
    }

    public static long hash(String pattern) {
        /* 2 */
        int a = 53; //53
        long m = 1_000_000_000 + 9; //1_000_000_000 + 9

        /* 3 */
        long patternHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;
         //   if (i != pattern.length() - 1) {
                pow = pow * a % m;
         //   }
        }
        return patternHash;
    }

    public static List<Integer> RabinKarp(String text, String pattern) {
        /* 2 */
        int a = 53; //53
        long m = 1000000000009L; //1_000_000_000 + 9

        /* 3 */
        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length(); i++) {
            patternHash += charToLong(pattern.charAt(i)) * pow;
            patternHash %= m;

            currSubstrHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
            currSubstrHash %= m;

            if (i != pattern.length() - 1) {
                pow = pow * a % m;
            }
        }

        /* 4 */
        ArrayList<Integer> occurrences = new ArrayList<>();

        for (int i = text.length(); i >= pattern.length(); i--) {
            if (patternHash == currSubstrHash) {
                boolean patternIsFound = true;

                for (int j = 0; j < pattern.length(); j++) {
                    if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
                        patternIsFound = false;
                        break;
                    }
                }

                if (patternIsFound) {
                    occurrences.add(i - pattern.length());
                }
            }

            if (i > pattern.length()) {
                /* 5 */
                currSubstrHash = (currSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
            }
        }

        Collections.reverse(occurrences);
        return occurrences;
    }

}