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
 
            ArrayList<Integer> oddA = new ArrayList<>();
            ArrayList<Integer> evenA = new ArrayList<>();
 
            ArrayList<Integer> oddB = new ArrayList<>();
            ArrayList<Integer> evenB = new ArrayList<>();
 
            // Store positions of 1s in a
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    // Using 0-based indexing
                    if (i % 2 == 0)
                        evenA.add(i);
                    else
                        oddA.add(i);
                }
            }
 
            // Store positions of 1s in b
            for (int i = 0; i < n; i++) {
                if (b.charAt(i) == '1') {
                    if (i % 2 == 0)
                        evenB.add(i);
                    else
                        oddB.add(i);
                }
            }
 
            // Parity counts must be equal
            if (evenA.size() != evenB.size() ||
                oddA.size() != oddB.size()) {
 
                System.out.println(-1);
                continue;
            }
 
            long ans = 0;
 
            // Match 1s at even positions
            for (int i = 0; i < evenA.size(); i++) {
                ans += Math.abs(evenA.get(i) - evenB.get(i)) / 2;
            }
 
            // Match 1s at odd positions
            for (int i = 0; i < oddA.size(); i++) {
                ans += Math.abs(oddA.get(i) - oddB.get(i)) / 2;
            }
 
            System.out.println(ans);
        }
    }
}