package analyzer;

public class Searcher {

    public boolean searchNaive(byte[] file, byte[] pattern) {
        for (int i = 0; i < file.length - pattern.length + 1; i++) {
            byte[] temp = new byte[pattern.length];
            System.arraycopy(file, i, temp, 0, temp.length);
            if (searchInPortion(temp, pattern)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchInPortion(byte[] portionOfFile, byte[] pattern) {
        for (int i = 0; i < portionOfFile.length; i++) {
            if (portionOfFile[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] prefixFunction(byte[] str) {
        /* 1 */
        int[] prefixFunc = new int[str.length];

        /* 2 */
        for (int i = 1; i < str.length; i++) {
            /* 3 */
            int j = prefixFunc[i - 1];

            while (j > 0 && str[i] != str[j]) {
                j = prefixFunc[j - 1];
            }

            /* 4 */
            if (str[i] == str[j]) {
                j += 1;
            }

            /* 5 */
            prefixFunc[i] = j;
        }

        /* 6 */
        return prefixFunc;
    }

    public boolean kmpSearch(byte[] text, byte[] pattern) {
        /* 1 */
        int[] prefixFunc = prefixFunction(pattern);
        int j = 0;
        /* 2 */
        for (int i = 0; i < text.length; i++) {
            /* 3 */
            while (j > 0 && text[i] != pattern[j]) {
                j = prefixFunc[j - 1];
            }
            /* 4 */
            if (text[i] == pattern[j]) {
                j += 1;
            }
            /* 5 */
            if (j == pattern.length) {
                return true;
            }
        }
        /* 6 */
        return false;
    }

    public boolean rabinKarp(byte[] text, byte[] pattern) {
        if (text.length < pattern.length) {
            return false;
        }
        /* 2 */
        int a = 53;
        long m = 1_000_000_000 + 9;

        /* 3 */
        long patternHash = 0;
        long currSubstrHash = 0;
        long pow = 1;

        for (int i = 0; i < pattern.length; i++) {
            patternHash += pattern[i] * pow;
            patternHash %= m;

            currSubstrHash += text[text.length - pattern.length + i] * pow;
            currSubstrHash %= m;

            if (i != pattern.length - 1) {
                pow = pow * a % m;
            }
        }
        boolean patternIsFound = false;
        for (int i = text.length; i >= pattern.length; i--) {
            if (patternHash == currSubstrHash) {
                patternIsFound = true;

                for (int j = 0; j < pattern.length; j++) {
                    if (text[i - pattern.length + j] != pattern[j]) {
                        patternIsFound = false;
                        break;
                    }
                }

            }
            if (i > pattern.length) {
                /* 5 */
                currSubstrHash = (currSubstrHash - text[i - 1] * pow % m + m) * a % m;
                currSubstrHash = (currSubstrHash + text[i - pattern.length - 1]) % m;
            }

        }
        return patternIsFound;
    }

}
