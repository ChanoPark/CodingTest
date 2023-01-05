import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Prob4_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] vote = br.readLine().toCharArray();

        HashMap<Character, Integer> resultMap = new HashMap<>();
        resultMap.put('A', 0);
        resultMap.put('B', 0);
        resultMap.put('C', 0);
        resultMap.put('D', 0);
        resultMap.put('E', 0);

        for (char target : vote) {
            resultMap.put(target, resultMap.getOrDefault(target, 0)+1);
        }

        int max = 0;
        Character result = null;
        for (Map.Entry<Character, Integer> entry : resultMap.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        System.out.println(result);
    }
}
