import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        HashMap<String, Integer> map = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            String name = sc.next();
 
            if (!map.containsKey(name)) {
                map.put(name, 1);
                System.out.println("OK");
            } else {
                int count = map.get(name);
 
                String newName = name + count;
 
                while (map.containsKey(newName)) {
                    count++;
                    newName = name + count;
                }
 
                map.put(name, count + 1);
                map.put(newName, 1);
 
                System.out.println(newName);
            }
        }
 
        sc.close();
    }
}