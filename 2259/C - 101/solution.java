import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
 
        while (t-- > 0) {
            int n = nextInt(in);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);
 
            List<Integer> P = new ArrayList<>();
            int Lm = -1, Rm = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] == 1) P.add(i);
                else if (a[i] == -1) {
                    if (Lm == -1) Lm = i;
                    Rm = i;
                }
            }
 
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = (a[i] == 1) ? 1 : 0;
 
            if (P.isEmpty()) {
                if (Lm != -1) {
                    res[Lm] = 1;
                    res[Rm] = 1;
                }
            } else {
                int bestGap = 1;
                int bestL = P.get(0), bestR = P.get(0);
 
                for (int i = 0; i + 1 < P.size(); i++) {
                    int gap = P.get(i + 1) - P.get(i) + 1;
                    if (gap > bestGap) {
                        bestGap = gap;
                        bestL = P.get(i);
                        bestR = P.get(i + 1);
                    }
                }
 
                if (Lm != -1 && Lm < P.get(0)) {
                    int gap = P.get(0) - Lm + 1;
                    if (gap > bestGap) {
                        bestGap = gap;
                        bestL = Lm;
                        bestR = P.get(0);
                    }
                }
 
                int lastP = P.get(P.size() - 1);
                if (Rm != -1 && Rm > lastP) {
                    int gap = Rm - lastP + 1;
                    if (gap > bestGap) {
                        bestGap = gap;
                        bestL = lastP;
                        bestR = Rm;
                    }
                }
 
                res[bestL] = 1;
                res[bestR] = 1;
            }
 
            for (int i = 0; i < n; i++) {
                sb.append(res[i]);
                sb.append(i + 1 < n ? ' ' : '
');
            }
        }
 
        System.out.print(sb);
    }
 
    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == '-') break;
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') { neg = true; b = in.read(); }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }
}