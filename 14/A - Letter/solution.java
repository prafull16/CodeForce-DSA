import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
 
        char[][] grid = new char[n][m];
 
        int minRow = n;
        int maxRow = -1;
        int minCol = m;
        int maxCol = -1;
 
        // Read the grid and find the bounding rectangle
        for (int i = 0; i < n; i++) {
 
            String s = sc.next();
 
            for (int j = 0; j < m; j++) {
 
                grid[i][j] = s.charAt(j);
 
                if (grid[i][j] == '*') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
 
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
 
        // Print the minimum rectangle
        for (int i = minRow; i <= maxRow; i++) {
 
            for (int j = minCol; j <= maxCol; j++) {
                System.out.print(grid[i][j]);
            }
 
            System.out.println();
        }
    }
}