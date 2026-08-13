import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int m = sc.nextInt();
        char c = sc.next().charAt(0);
 
        char[][] grid = new char[n][m];
 
        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
 
        boolean[] counted = new boolean[26];
        int ans = 0;
 
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
 
                // Only check cells belonging to President's desk
                if (grid[i][j] != c) {
                    continue;
                }
 
                // Check 4 neighboring cells
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
 
                    // Check if neighbor is inside grid
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
 
                        char neighbor = grid[nr][nc];
 
                        // It is another desk
                        if (neighbor != '.' && neighbor != c) {
 
                            int index = neighbor - 'A';
 
                            // Count this desk only once
                            if (!counted[index]) {
                                counted[index] = true;
                                ans++;
                            }
                        }
                    }
                }
            }
        }
 
        System.out.println(ans);
    }
}