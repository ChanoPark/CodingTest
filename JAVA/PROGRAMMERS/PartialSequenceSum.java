package Programmers;

public class PartialSequenceSum {
    public int[] solution(int[] sequence, int k) {
        int s = 0;
        int e = 10000000;
        int lt = 0;
        int rt = 0;
        int tmp = 0;

        while (lt < sequence.length) {
            if (tmp > k) {
                tmp -= sequence[lt++];
            } else if (tmp < k) {
                if (rt != sequence.length)
                    tmp += sequence[rt++];
                else {
                    tmp -= sequence[lt++];
                }
            } else {
                if (e - s > rt - 1 - lt) {
                    s = lt;
                    e = rt - 1;
                }
                tmp -= sequence[lt++];
            }
        }

        return new int[]{s, e};
    }
}
