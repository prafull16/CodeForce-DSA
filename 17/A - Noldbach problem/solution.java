import java.util.*;
 
public class Main {
 
    static boolean isPrime(int x) {
        if (x < 2) return false;
 
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
        int k = sc.nextInt();
 
        // Store all primes from 2 to n
        ArrayList<Integer> primes = new ArrayList<>();
 
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
 
        int count = 0;
 
        // Check consecutive (neighboring) primes
        for (int i = 0; i < primes.size() - 1; i++) {
            int value = primes.get(i) + primes.get(i + 1) + 1;
 
            // value must be a prime and <= n
            if (value <= n && isPrime(value)) {
                count++;
            }
        }
 
        if (count >= k) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}