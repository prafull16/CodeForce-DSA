import java.util.Scanner;
 
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
 
        int y = sc.nextInt();
        int w = sc.nextInt();
 
        int mx = Math.max(y, w);
        int numerator = 7 - mx;
        int denominator = 6;
 
        int g = gcd(numerator, denominator);
 
        System.out.println((numerator / g) + "/" + (denominator / g));
    }
}