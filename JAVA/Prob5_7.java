import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Prob5_7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] order = br.readLine().toCharArray();
        char[] input = br.readLine().toCharArray();

        Queue<Character> queue = new LinkedList<>();
        for (char x : order) queue.add(x);

        for (char x : input) {
            if (queue.contains(x)) {
                if (x != queue.poll()) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if (queue.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
