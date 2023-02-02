package softeer;

import java.io.*;


public class Gearbox8Level {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length+1];
        for (int i=1; i<input.length+1 ; i++) arr[i] = Integer.parseInt(input[i-1]);

        if (arr[1] == 1) {
            for (int i=1; i<9; i++) {
                if (i != arr[i]) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        } else {
            for (int i=8; i>0; i--) {
                if (i != arr[8-i+1]) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        }
    }
}
