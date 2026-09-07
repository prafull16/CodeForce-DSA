import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        long n = sc.nextLong();
        int m = sc.nextInt();
 
        long[][] boxes = new long[m][2];
 
        for (int i = 0; i < m; i++) {
            boxes[i][0] = sc.nextLong(); // number of matchboxes
            boxes[i][1] = sc.nextLong(); // matches per box
        }
 
        // Sort by matches per box in descending order
        Arrays.sort(boxes, (a, b) -> Long.compare(b[1], a[1]));
 
        long answer = 0;
 
        for (int i = 0; i < m && n > 0; i++) {
            long take = Math.min(n, boxes[i][0]);
 
            answer += take * boxes[i][1];
            n -= take;
        }
 
        System.out.println(answer);
    }
}