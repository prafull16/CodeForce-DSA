import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            int[] freq = new int[m + 1];
 
            st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                freq[x]++;
            }
 
            // suffix[x] = number of carrots having length >= x
            int[] suffix = new int[m + 2];
 
            for (int x = m; x >= 1; x--) {
                suffix[x] = suffix[x + 1] + freq[x];
            }
 
            int answer = 0;
 
            for (int x = 1; x <= m; x++) {
 
                // All carrots with length >= x can give one x.
                int current = suffix[x];
 
                // Carrots of length 2*x give an additional x.
                if (2 * x <= m) {
                    current += freq[2 * x];
                }
 
                answer = Math.max(answer, current);
            }
 
            out.append(answer).append('
');
        }
 
        System.out.print(out);
    }
}