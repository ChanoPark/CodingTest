import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_6 {
    /**
     * 정수를 뒤집기 위해서 reverse = reverse * 10 + t 라는 식을 적용할 수도 있음.
     * 여기서 t는 1의 자리 숫자.
     * <p>
     * 가능한 자연수의 소수를 모두 정리하지 않고, 2부터 직접 검사하기
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        for (int number : numbers) {
            int reverse = 0;

            while (number != 0) {
                int t = number % 10;
                reverse = reverse * 10 + t;
                number /= 10;
            }

            if (isPrime(reverse)) System.out.print(reverse + " ");
        }
    }

    public boolean isPrime(int number) {
        if (number == 1) return false;
        else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];

        for (int i = 2; i < 100001; i++) {
            if (arr[i] == 0) {
                int j = 2;
                while (i * j < 100001) {
                    arr[i * j] = -1;
                    j++;
                }
            }
        }
        arr[1] = -1;

        for (int number : numbers) {
            StringBuilder temp = new StringBuilder();
            while (number != 0) {
                temp.append(number % 10);
                number /= 10;
            }
            int reverse = Integer.parseInt(temp.toString());

            if (arr[reverse] == 0) System.out.print(reverse + " ");
        }
    }
}
