import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob10_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        Block[] blocks = new Block[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            blocks[i] = new Block(area, height, weight);
        }

        Arrays.sort(blocks);
        dp[0] = blocks[0].getHeight();

        for (int i = 1; i < n; i++) {
            Block block = blocks[i];
            int max = dp[i];
            for (int j = i - 1; j >= 0; j--) {

                if (max <= dp[j] && blocks[i].getWeight() > blocks[j].getWeight()) {
                    max = dp[j];
                }

                dp[i] = max + block.getHeight();
                answer = Math.max(answer, dp[i]);
            }
        }
        System.out.println(answer);
    }

    public static class Block implements Comparable<Block> {
        private int area;
        private int height;
        private int weight;

        public Block(int area, int height, int weight) {
            this.area = area;
            this.weight = weight;
            this.height = height;
        }

        public int getArea() {
            return area;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int compareTo(Block o) {
            return this.area - o.getArea();
        }
    }
}
