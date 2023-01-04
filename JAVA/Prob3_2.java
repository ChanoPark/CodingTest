import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob3_2 {
    /**
     * 먼저 정렬을 시키고 계산하는 방법 -> O(n^2) 제거
     */
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n1 ; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n2 ; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        ArrayList<Integer> answer = new ArrayList<>();
        int idx1=0;
        int idx2=0;

        while (idx1 < n1 && idx2 <n2) {
            if (arr1[idx1] == arr2[idx2]) {
                answer.add(arr1[idx1++]);
                idx2++;
            } else if (arr1[idx1] < arr2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }
    public static void main(String[] args) throws Exception {
        Main t = new Main();
        t.solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n1 = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n1 ; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int n2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[n2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n2 ; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answer = new ArrayList<>();

        boolean flag;
        int idx=0;
        for (int i=0; i < n1 ;i++) {
            flag = false;
            for (int j=0; j <n2; j++) {
                if (arr2[j] == arr1[i]) {
                    flag = true;
                    arr2[j] = -1; //원소가 중복되지 않으므로.
                    break;
                }
            }
            if (flag) answer.add(arr1[i]);
        }

        answer.sort(Comparator.naturalOrder());
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
