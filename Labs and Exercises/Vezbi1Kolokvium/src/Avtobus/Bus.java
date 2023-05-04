package Avtobus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka

        int minimum = M * 100;
        int maximum = (M - 1) * 100 + N * 100;

        if (M == 0) {
            minimum = N * 100;
            maximum = N * 100;
        }
        if (N > M) {
            minimum = N * 100;
        }

        System.out.println(minimum + "\n" + maximum);

    }

}
