import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob5_8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        Queue<Person> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) queue.add(new Person(i, Integer.parseInt(st.nextToken())));

        int answer = 0;

        while (!queue.isEmpty()) {
            Person person = queue.poll();

            for (Person p : queue) {
                if (person.priority < p.priority) {
                    queue.add(person);
                    person = null;
                    break;
                }
            }

            if (person != null) {
                answer++;
                if (person.id == M) break;
            }
        }

        System.out.println(answer);
    }

    public static class Person {
        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        private final int id;
        private final int priority;
    }
}