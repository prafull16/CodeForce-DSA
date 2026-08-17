import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int[] t = new int[n];
 
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
 
        int left = 0;
        int right = n - 1;
 
        int aliceTime = 0;
        int bobTime = 0;
 
        int alice = 0;
        int bob = 0;
 
        while (left <= right) {
 
            // Alice gets the next chocolate if her time
            // is less than or equal to Bob's time.
            if (aliceTime <= bobTime) {
                aliceTime += t[left];
                alice++;
                left++;
            } else {
                bobTime += t[right];
                bob++;
                right--;
            }
        }
 
        System.out.println(alice + " " + bob);
    }
}