import java.util.*;
 
public class Main {
 
    static boolean isRC(String s) {
        if (s.charAt(0) != 'R')
            return false;
 
        int i = 1;
 
        while (i < s.length() && Character.isDigit(s.charAt(i)))
            i++;
 
        if (i == 1 || i == s.length())
            return false;
 
        if (s.charAt(i) != 'C')
            return false;
 
        i++;
 
        if (i == s.length())
            return false;
 
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
            i++;
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        while (n-- > 0) {
            String s = sc.next();
 
            if (isRC(s)) {
                int cPos = s.indexOf('C');
 
                int row = Integer.parseInt(s.substring(1, cPos));
                int col = Integer.parseInt(s.substring(cPos + 1));
 
                StringBuilder letters = new StringBuilder();
 
                while (col > 0) {
                    col--;
                    letters.append((char) ('A' + col % 26));
                    col /= 26;
                }
 
                System.out.println(letters.reverse().toString() + row);
 
            } else {
                int i = 0;
 
                while (Character.isLetter(s.charAt(i)))
                    i++;
 
                String letters = s.substring(0, i);
                String row = s.substring(i);
 
                int col = 0;
 
                for (char ch : letters.toCharArray()) {
                    col = col * 26 + (ch - 'A' + 1);
                }
 
                System.out.println("R" + row + "C" + col);
            }
        }
    }
}