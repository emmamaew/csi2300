import java.util.Scanner;

public class Fibonacci {
    
    public static int FibNum(int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
    
        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a number position to get corresponding Fibonacci number, or 'q' to quit: ");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            int n = Integer.parseInt(input);
            int result = FibNum(n);

            System.out.println("The Fibonacci number at postion " + n + " is " + result);
        } 
        scanner.close();
    }
}