import java.io.*;
import java.util.*;
 
public class Main {
 
    static class EGCD {
        long x, y, g;
 
        EGCD(long x, long y, long g) {
            this.x = x;
            this.y = y;
            this.g = g;
        }
    }
 
    static EGCD exgcd(long a, long b) {
        if (b == 0) {
            if (a >= 0)
                return new EGCD(1, 0, a);
            else
                return new EGCD(-1, 0, -a);
        }
 
        EGCD t = exgcd(b, a % b);
 
        long x = t.y;
        long y = t.x - (a / b) * t.y;
 
        return new EGCD(x, y, t.g);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
 
        EGCD res = exgcd(A, B);
 
        if ((-C) % res.g != 0) {
            System.out.println(-1);
            return;
        }
 
        long mult = (-C) / res.g;
 
        long x = res.x * mult;
        long y = res.y * mult;
 
        System.out.println(x + " " + y);
    }
}