import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob9_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            persons[i] = new Person(height, weight);
        }
        Arrays.sort(persons);

        int result = 1;
        int maxWeight = persons[0].getWeight();

        for (int i = 1; i < n; i++) {
            if (persons[i].getWeight() > maxWeight) {
                result++;
                maxWeight = persons[i].getWeight();
            }
        }
        System.out.println(result);
    }

    public static class Person implements Comparable<Person> {
        private int height;
        private int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public int getHeight() {
            return height;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Person o) {
            return o.height - this.height;
        }
    }
}
