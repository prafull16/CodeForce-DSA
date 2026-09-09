import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            String s = br.readLine().trim();
            String afterAlice = aliceDelete(s);
            String afterBob = bobDelete(afterAlice);
            sb.append(afterBob).append('
');
        }
        
        System.out.print(sb);
    }
    
    // Alice deletes a '0' to maximize the resulting string
    static String aliceDelete(String s) {
        int n = s.length();
        int idxToDelete = -1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                idxToDelete = i;
                break;
            }
        }
        if (idxToDelete == -1) {
            // no "01" pattern found, delete last '0'
            idxToDelete = s.lastIndexOf('0');
        }
        return s.substring(0, idxToDelete) + s.substring(idxToDelete + 1);
    }
    
    // Bob deletes a '1' to minimize the resulting string
    static String bobDelete(String s) {
        int n = s.length();
        int idxToDelete = -1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                idxToDelete = i;
                break;
            }
        }
        if (idxToDelete == -1) {
            // no "10" pattern found, delete last '1'
            idxToDelete = s.lastIndexOf('1');
        }
        return s.substring(0, idxToDelete) + s.substring(idxToDelete + 1);
    }
}