package SumaOdApsolutniRazliki;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int[] numbers, int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni

        int[][] matrica = new int[101][101];
        int z;
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j < N; j++) {
                if (j < i - 1)
                    continue;

                for (int k = 0; k < j; k++) {
                    z = Math.abs(numbers[j] - numbers[k]);
                    matrica[i][j] = Math.max(z + matrica[i - 1][k], matrica[i][j]);
                }
                matrica[i][j] = Math.max(matrica[i][j], matrica[i][j - 1]);
                matrica[i][j] = Math.max(matrica[i][j], matrica[i - 1][j - 1]);
                matrica[i][j] = Math.max(matrica[i][j], matrica[i - 1][j]);
            }
        }
        return matrica[K][N - 1];
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}