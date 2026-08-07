import java.io.*;
import java.util.*;
 
public class Main {
 
    static class Round {
        String name;
        int score;
 
        Round(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int n = Integer.parseInt(br.readLine());
 
        ArrayList<Round> rounds = new ArrayList<>();
        HashMap<String, Integer> finalScore = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
 
            rounds.add(new Round(name, score));
            finalScore.put(name, finalScore.getOrDefault(name, 0) + score);
        }
 
        int maxScore = Integer.MIN_VALUE;
 
        for (int score : finalScore.values()) {
            maxScore = Math.max(maxScore, score);
        }
 
        HashMap<String, Integer> currentScore = new HashMap<>();
 
        for (Round r : rounds) {
            currentScore.put(r.name, currentScore.getOrDefault(r.name, 0) + r.score);
 
            if (currentScore.get(r.name) >= maxScore &&
                finalScore.get(r.name) == maxScore) {
                System.out.println(r.name);
                return;
            }
        }
    }
}