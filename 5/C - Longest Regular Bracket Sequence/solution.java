import java.util.*;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String s = sc.nextLine();
        int n = s.length();
 
        Stack<Integer> stack = new Stack<>();
 
        int base = -1;
        int maxLength = 0;
        int count = 0;
 
        for (int i = 0; i < n; i++) {
 
            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
 
                if (!stack.isEmpty()) {
                    stack.pop();
 
                    int length;
 
                    if (!stack.isEmpty()) {
                        length = i - stack.peek();
                    } else {
                        length = i - base;
                    }
 
                    if (length > maxLength) {
                        maxLength = length;
                        count = 1;
                    } 
                    else if (length == maxLength) {
                        count++;
                    }
 
                } 
                else {
                    // This ')' cannot belong to any valid sequence
                    base = i;
                }
            }
        }
 
        if (maxLength == 0) {
            System.out.println("0 1");
        } else {
            System.out.println(maxLength + " " + count);
        }
    }
}