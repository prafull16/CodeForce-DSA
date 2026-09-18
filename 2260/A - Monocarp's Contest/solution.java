import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == 0) zeroCount++;
            }
 
            if (a[0] == 0 && a[n - 1] == 0) {
                sb.append(0).append('
');
            } else if (zeroCount < 2) {
                sb.append(-1).append('
');
            } else {
                int ops = 0;
                if (a[0] == 1) ops++;
                if (a[n - 1] == 1) ops++;
                sb.append(ops).append('
');
            }
        }
 
        System.out.print(sb);
    }
}