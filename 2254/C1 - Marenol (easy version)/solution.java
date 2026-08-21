import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
 
            int evenA = 0;
            int oddA = 0;
            int evenB = 0;
            int oddB = 0;
 
            for (int i = 0; i < n; i++) {
 
                if (a.charAt(i) == '1') {
                    if (i % 2 == 0)
                        evenA++;
                    else
                        oddA++;
                }
 
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0)
                        evenB++;
                    else
                        oddB++;
                }
            }
 
            if (evenA == evenB && oddA == oddB)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}