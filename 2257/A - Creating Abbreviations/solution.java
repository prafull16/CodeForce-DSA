import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int t = sc.nextInt();
 
        while (t-- > 0) {
 
            int n = sc.nextInt();
            int m = sc.nextInt();
 
            // original[i] = true if there is an ordinary word
            // starting with character ('a' + i)
            boolean[] original = new boolean[26];
 
            for (int i = 0; i < n; i++) {
                String word = sc.next();
                original[word.charAt(0) - 'a'] = true;
            }
 
            String[] abbr = new String[m];
 
            for (int i = 0; i < m; i++) {
                abbr[i] = sc.next();
            }
 
            boolean[] created = new boolean[m];
 
            // available[c] means an abbreviation can currently
            // be used as a word whose first letter is c.
            boolean[] available = original.clone();
 
            int count = 0;
 
            // Keep trying to create abbreviations.
            // If in one complete pass nothing is created,
            // then the remaining abbreviations are impossible.
            while (count < m) {
 
                boolean progress = false;
 
                for (int i = 0; i < m; i++) {
 
                    if (created[i]) {
                        continue;
                    }
 
                    boolean possible = true;
 
                    for (char c : abbr[i].toCharArray()) {
 
                        int idx = c - 'A';
 
                        if (!available[idx]) {
                            possible = false;
                            break;
                        }
                    }
 
                    if (possible) {
                        created[i] = true;
                        count++;
 
                        // This abbreviation can now be used as
                        // an ordinary word.
                        int firstLetter = abbr[i].charAt(0) - 'A';
                        available[firstLetter] = true;
 
                        progress = true;
                    }
                }
 
                if (!progress) {
                    break;
                }
            }
 
            System.out.println(count == m ? "YES" : "NO");
        }
 
        sc.close();
    }
}