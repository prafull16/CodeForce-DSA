import java.util.*;
 
public class Main {
 
    static final long MOD = 998244353L;
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            int n = sc.nextInt();
            String s = sc.next();
 
            // dp[a][b] = number of ways where
            // previous two characters are a and b
            long[][] dp = new long[2][2];
 
            // Initialize first two characters
            for (int a = 0; a <= 1; a++) {
                if (s.charAt(0) != '?' &&
                    s.charAt(0) - '0' != a) {
                    continue;
                }
 
                for (int b = 0; b <= 1; b++) {
                    if (s.charAt(1) != '?' &&
                        s.charAt(1) - '0' != b) {
                        continue;
                    }
 
                    dp[a][b] = 1;
                }
            }
 
            // Process remaining characters
            for (int i = 2; i < n; i++) {
 
                long[][] next = new long[2][2];
 
                for (int a = 0; a <= 1; a++) {
                    for (int b = 0; b <= 1; b++) {
 
                        if (dp[a][b] == 0) {
                            continue;
                        }
 
                        for (int c = 0; c <= 1; c++) {
 
                            // Current character must match '?'
                            // or be equal to c
                            if (s.charAt(i) != '?' &&
                                s.charAt(i) - '0' != c) {
                                continue;
                            }
 
                            // Need s[i-2] != s[i]
                            if (a == c) {
                                continue;
                            }
 
                            next[b][c] =
                                (next[b][c] + dp[a][b]) % MOD;
                        }
                    }
                }
 
                dp = next;
            }
 
            long ans = 0;
 
            for (int a = 0; a <= 1; a++) {
                for (int b = 0; b <= 1; b++) {
                    ans = (ans + dp[a][b]) % MOD;
                }
            }
 
            System.out.println(ans);
        }
    }
}