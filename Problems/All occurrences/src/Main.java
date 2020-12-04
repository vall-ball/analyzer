import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();
        String text = scanner.nextLine();
        if (pattern.equals("")) {
            System.out.println(1);
            System.out.println(0);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
                int answer = text.substring(i).indexOf(pattern);
                if (answer != -1) {
                    list.add(answer + i);
                    i += answer;
                }

            }
            System.out.println(list.size());
            if (list.size() > 0) {
                for (int i : list) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}