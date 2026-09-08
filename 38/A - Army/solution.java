import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] d = new int[n]; // 1-indexed, d[i] = years from rank i to i+1
        for (int i = 1; i <= n - 1; i++) {
            d[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int total = 0;
        for (int i = a; i < b; i++) {
            total += d[i];
        }
        
        System.out.println(total);
    }
}