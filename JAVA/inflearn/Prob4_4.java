import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Prob4_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : target) map.put(x, map.getOrDefault(x, 0)+1);

        int lt = 0;
        int rt = target.length-1;
        int answer = 0;

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = lt; i < rt; i++) targetMap.put(word[i], targetMap.getOrDefault(word[i], 0)+1);

        for ( ; rt < word.length; rt++) {
            targetMap.put(word[rt], targetMap.getOrDefault(word[rt], 0)+1);
            if (map.equals(targetMap)) answer++;
            targetMap.put(word[lt], targetMap.get(word[lt])-1);
            if (targetMap.get(word[lt]) == 0) targetMap.remove(word[lt]);
            lt++;
        }
        System.out.println(answer);
    }
}
