import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String[] letters = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int answer = 0;
            String s = letters[i] + text;
            for (int j = 0; j <= text.length(); j++) {
                if (!text.contains(s.substring(0, s.length() - j))) {
                    answer++;
                }
            }
            System.out.print(answer + " ");
        }
    }


}