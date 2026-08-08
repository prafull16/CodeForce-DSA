import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int d = sc.nextInt();
        int sumTime = sc.nextInt();
 
        int[] min = new int[d];
        int[] max = new int[d];
        int[] schedule = new int[d];
 
        int minSum = 0;
        int maxSum = 0;
 
        for (int i = 0; i < d; i++) {
            min[i] = sc.nextInt();
            max[i] = sc.nextInt();
 
            minSum += min[i];
            maxSum += max[i];
 
            schedule[i] = min[i];
        }
 
        // Impossible to make the required total
        if (sumTime < minSum || sumTime > maxSum) {
            System.out.println("NO");
            return;
        }
 
        int remaining = sumTime - minSum;
 
        // Distribute remaining hours
        for (int i = 0; i < d; i++) {
            int extra = Math.min(remaining, max[i] - min[i]);
 
            schedule[i] += extra;
            remaining -= extra;
        }
 
        System.out.println("YES");
 
        for (int i = 0; i < d; i++) {
            System.out.print(schedule[i] + " ");
        }
 
        System.out.println();
    }
}