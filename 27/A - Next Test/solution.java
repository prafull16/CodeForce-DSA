import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        boolean[] used = new boolean[3002];
 
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            used[x] = true;
        }
 
        for (int i = 1; i <= 3001; i++) {
            if (!used[i]) {
                System.out.println(i);
                break;
            }
        }
 
        sc.close();
    }
}