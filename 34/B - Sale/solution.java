import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        Arrays.sort(a);
 
        int ans = 0;
 
        // Take the most negative prices
        for (int i = 0; i < n && i < m; i++) {
            if (a[i] < 0) {
                ans += -a[i]; // Convert negative price into money earned
            } else {
                break;
            }
        }
 
        System.out.println(ans);
    }
}