import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int shifts = 0;
        for (int i = 1; i < array.length; i++) {
            int elem = array[i]; // take the next element
            int j = i - 1;

            if (j >= 0 && array[j] < elem) {
                shifts++;
            }
            /* find a suitable position to insert and shift elements to the right */
            while (j >= 0 && array[j] < elem) {
                array[j + 1] = array[j]; // shifting

                j--;
            }

            array[j + 1] = elem; // insert the element in the found position in the sorted part
        }
        System.out.println(shifts);
    }
}