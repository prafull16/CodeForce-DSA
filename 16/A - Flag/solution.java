import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        String[] flag = new String[n];
 
        for (int i = 0; i < n; i++) {
            flag[i] = sc.next();
        }
 
        for (int i = 0; i < n; i++) {
 
            // Check whether all characters in the row are same
            for (int j = 1; j < m; j++) {
                if (flag[i].charAt(j) != flag[i].charAt(0)) {
                    System.out.println("NO");
                    return;
                }
            }
 
            // Check whether adjacent rows have different colours
            if (i > 0 && flag[i].charAt(0) == flag[i - 1].charAt(0)) {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println("YES");
    }
}