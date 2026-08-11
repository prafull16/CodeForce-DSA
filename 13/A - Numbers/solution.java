import java.util.*;
 
public class Main {
 
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int A = sc.nextInt();
        int sum = 0;
 
        // Check every base from 2 to A-1
        for (int b = 2; b < A; b++) {
 
            int n = A;
 
            // Find sum of digits of A in base b
            while (n > 0) {
                sum += n % b;
                n /= b;
            }
        }
 
        int denominator = A - 2;
 
        // Reduce fraction
        int g = gcd(sum, denominator);
 
        System.out.println((sum / g) + "/" + (denominator / g));
    }
}