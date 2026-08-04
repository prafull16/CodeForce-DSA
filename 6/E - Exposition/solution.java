import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;
 
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
 
        int n = fs.nextInt();
        long k = fs.nextLong();
 
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = fs.nextInt();
        }
 
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
 
        ArrayList<int[]> ans = new ArrayList<>();
 
        int left = 0;
        int best = 0;
 
        for (int right = 0; right < n; right++) {
 
            while (!minDeque.isEmpty() && h[minDeque.peekLast()] >= h[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
 
            while (!maxDeque.isEmpty() && h[maxDeque.peekLast()] <= h[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
 
            while (h[maxDeque.peekFirst()] - h[minDeque.peekFirst()] > k) {
                if (minDeque.peekFirst() == left)
                    minDeque.pollFirst();
 
                if (maxDeque.peekFirst() == left)
                    maxDeque.pollFirst();
 
                left++;
            }
 
            int len = right - left + 1;
 
            if (len > best) {
                best = len;
                ans.clear();
                ans.add(new int[]{left + 1, right + 1});
            } else if (len == best) {
                ans.add(new int[]{left + 1, right + 1});
            }
        }
 
        StringBuilder out = new StringBuilder();
        out.append(best).append(" ").append(ans.size()).append('
');
 
        for (int[] p : ans) {
            out.append(p[0]).append(" ").append(p[1]).append('
');
        }
 
        System.out.print(out);
    }
}