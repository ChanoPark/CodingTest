import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Prob4_2 {
    /**
     * 문자열 정렬 후 비교 O(NlogN)
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] wordArr1 = br.readLine().toCharArray();
        char[] wordArr2 = br.readLine().toCharArray();

        Arrays.sort(wordArr1);
        Arrays.sort(wordArr2);
        if (Arrays.equals(wordArr1, wordArr2)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word1 = br.readLine().toCharArray();
        char[] word2 = br.readLine().toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char w1 : word1) {
            map.put(w1, map.getOrDefault(w1, 0) + 1);
        }

        for (char w2 : word2) {
            if (!map.containsKey(w2) || map.get(w2) == 0) { //여기서 0인경우도 아나그램이 아님.
                System.out.println("NO");
                return;
            } else {
                map.put(w2, map.get(w2) - 1);
            }
        }

        System.out.println("YES");
    }
}
