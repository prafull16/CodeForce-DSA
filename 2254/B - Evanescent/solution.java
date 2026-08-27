import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
 
            // Build blocks
            char[] blockChar = new char[n];
            int[] blockCount = new int[n];
            int k = 0;
 
            int i = 0;
            while (i < n) {
                char c = s.charAt(i);
                int cnt = 0;
                while (i < n && s.charAt(i) == c) {
                    cnt++;
                    i++;
                }
                blockChar[k] = c;
                blockCount[k] = cnt;
                k++;
            }
 
            int best = k;
 
            if (k >= 3) {
                for (int j = 1; j <= k - 2; j++) {
                    if (blockCount[j] == 1) {
                        int candidate;
                        if (blockChar[j - 1] == blockChar[j + 1]) {
                            candidate = k - 2;
                        } else {
                            candidate = k - 1;
                        }
                        if (candidate < best) best = candidate;
                    }
                }
            }
 
            sb.append(best).append('
');
        }
 
        System.out.print(sb);
    }
}