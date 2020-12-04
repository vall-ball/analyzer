package analyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileHandler {

    public String load(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine() + "\n");
        }
        scanner.close();
        return builder.toString();
    }

    public Map<String, String> getMapOfPatterns(String str) {
        Map<String, String> answer = new LinkedHashMap<>();
        String[] arr = str.split("\n");
        for (int i = arr.length - 1; i >= 0; i--) {
            String[] s = arr[i].split(";");
            answer.put(s[1].replaceAll("\"", ""), s[2].replaceAll("\"", ""));
        }
        return answer;
    }
}
