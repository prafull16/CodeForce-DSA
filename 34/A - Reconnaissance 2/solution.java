import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int[] a = new int[n];
 
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
 
        int minDiff = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
 
        for (int i = 0; i < n; i++) {
 
            // Next soldier, with circular connection
            int j = (i + 1) % n;
 
            int diff = Math.abs(a[i] - a[j]);
 
            if (diff < minDiff) {
                minDiff = diff;
 
                ans1 = i + 1; // Convert to 1-based index
                ans2 = j + 1;
            }
        }
 
        System.out.println(ans1 + " " + ans2);
    }
}