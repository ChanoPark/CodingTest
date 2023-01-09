import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob3_5 {

    /**
     * 수학적 풀이
     * 연속된 자연수이므로 자리수마다 가능한 경우의 수가 1개임.
     * 그래서 자리수마다 가능한 숫자가 있는지 판별하는 것.
     * 자리수만큼 숫자를 빼고, 똑같이 숫자를 분배할 수 있으면 가능한 자리수로 판단.
     */
    public void solution2() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int answer = 0;

        int cnt = 1; //자리수
        number--; //1 빼고

        while (number > 0) {
            number -= ++cnt; //자리수를 늘려가면서 숫자에서 빼기
            if (number % cnt == 0) answer++;
        }
        System.out.println(answer);
    }

    /**
     * 연속된 자연수 -> 숫자를 2로 나눈 값 + 1까지만 가능함.
     * 결국 rt도 2로 나눈 값+1이 넘어가면 sum이 number를 넘어갈 수 밖에 없음.
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int answer = 0;
        int lt = 1;
        int rt = 1;
        int sum = 0;

        while (lt < number / 2 + 1) {
            sum += rt++;
            if (sum == number) answer++;
            else if (sum >= number) {
                while (sum >= number) {
                    sum -= lt++;
                    if (sum == number) answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        Prob3_5 t = new Prob3_5();
        t.solution2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int answer = 0;
        int lt = 1;
        int rt = 1;
        int sum = 0;

        while (lt < number) {
            if (sum > number) {
                sum -= lt++;
            } else if (sum == number && lt != rt) {
                answer++;
                sum -= lt++;
            } else {
                sum += rt++;
            }

            if (rt == number) {
                while (lt < number && sum >= number) {
                    sum -= lt++;
                    if (sum == number && lt != rt) answer++;
                }
                break;
            }
        }
        System.out.println(answer);
    }
}
