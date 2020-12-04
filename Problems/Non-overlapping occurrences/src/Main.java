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
                int begin = text.substring(i).indexOf(pattern);
                if (list.size() == 0 && begin != -1) {
                    list.add(begin);
                } else if (begin != -1 && begin + i >= list.get(list.size() - 1) + pattern.length()) {
                    list.add(begin + i);
                    i += begin;
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