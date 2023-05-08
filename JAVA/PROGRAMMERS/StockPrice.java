package Programmers;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Loop1:
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    continue Loop1;
                }
            }
            answer[i] = prices.length - i - 1;
        }

        return answer;
    }

    //더 깔끔한 답
    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
