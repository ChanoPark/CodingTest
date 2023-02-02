package softeer;

import java.io.*;

public class DriveDistance {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int A = Integer.parseInt(input.split(" ")[0]);
        int B = Integer.parseInt(input.split(" ")[1]);
        if (A > B) System.out.println("A");
        else if (A == B) System.out.println("same");
        else System.out.println("B");
    }
}
