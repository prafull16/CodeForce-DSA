import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine().trim();
            
            int count = 0;
            for (int start = 0; start < n; start += k) {
                boolean hasFree = false;
                for (int i = start; i < start + k; i++) {
                    if (s.charAt(i) == '0') {
                        hasFree = true;
                        break;
                    }
                }
                if (!hasFree) {
                    count++;
                }
            }
            
            sb.append(count).append('
');
        }
        
        System.out.print(sb);
    }
}