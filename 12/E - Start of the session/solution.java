import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = n - 1;
 
        int[][] a = new int[n][n];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
 
                // Main diagonal
                if (i == j) {
                    a[i][j] = 0;
                }
 
                // Last row/column
                else if (i == n - 1) {
                    a[i][j] = (2 * j) % m + 1;
                }
                else if (j == n - 1) {
                    a[i][j] = (2 * i) % m + 1;
                }
 
                // Remaining part
                else {
                    a[i][j] = (i + j) % m + 1;
                }
            }
        }
 
        // Print matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}