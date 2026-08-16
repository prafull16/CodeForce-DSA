import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
 
            // Sort the three numbers
            long[] arr = {a, b, c};
            Arrays.sort(arr);
 
            long min = arr[0];
            long mid = arr[1];
            long max = arr[2];
 
            // Either:
            // 1. Do nothing -> range = max - min
            // 2. Replace max with min + mid -> range = mid
            long answer = Math.min(max - min, mid);
 
            System.out.println(answer);
        }
 
        sc.close();
    }
}