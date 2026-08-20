import java.io.*;
import java.util.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
 
        while (t-- > 0) {
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
 
            String s = br.readLine().trim();
 
            int redScore = 0;
            int blueScore = 0;
 
            int len = 2 * n;
 
            for (int i = 0; i < len; i++) {
 
                if (s.charAt(i) == '0') {
                    continue;
                }
 
                // Next position in the circle
                int next = (i + 1) % len;
 
                int finalPosition;
 
                // If next person is empty, pass the potato
                if (s.charAt(next) == '0') {
                    finalPosition = next;
                } else {
                    // Otherwise, keep it
                    finalPosition = i;
                }
 
                // Convert 0-based index to person number:
                // i = 0 -> person 1 (Red)
                // i = 1 -> person 2 (Blue)
                if (finalPosition % 2 == 0) {
                    // Odd-numbered person -> Red Team
                    blueScore++;
                } else {
                    // Even-numbered person -> Blue Team
                    redScore++;
                }
            }
 
            System.out.println(redScore + " " + blueScore);
        }
    }
}