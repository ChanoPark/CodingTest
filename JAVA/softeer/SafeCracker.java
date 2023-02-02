package softeer;

import java.util.*;
import java.io.*;

public class SafeCracker {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        List<Jewel> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int price = Integer.parseInt(input[1]);
            list.add(new Jewel(weight, price));
        }

        Collections.sort(list, (a, b) -> b.getPrice() - a.getPrice());

        int bag = 0;
        int answer = 0;

        for (Jewel j : list) {
            if (j.getWeight() + bag > w) {
                answer += j.getPrice() * (w - bag);
                bag += w - bag;
            } else {
                bag += j.getWeight();
                answer += j.getPrice() * j.getWeight();
            }

            if (bag >= w) break;
        }

        System.out.println(answer);
    }

    public static class Jewel {
        private int weight;
        private int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getPrice() {
            return this.price;
        }
    }
}
