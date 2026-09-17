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
            int ones = 0;
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) ones++;
            }
            
            if (2 * ones >= n) {
                sb.append("Bessie").append("
");
            } else {
                sb.append("Elsie").append("
");
            }
        }
        
        System.out.print(sb);
    }
}