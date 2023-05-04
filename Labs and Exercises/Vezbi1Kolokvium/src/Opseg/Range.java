package Opseg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Range {

    static int zbirNaCifri(long pamtac) {
        int zbirNaCifriNaX = 0;

        while (pamtac > 0) {
            zbirNaCifriNaX += (pamtac % 10);
            pamtac /= 10;
        }

        return zbirNaCifriNaX;
    }

    static long proveri(long N, long A, long B) {
        // Vasiot kod tuka
        long brojac = -1;

        if (N == (B * B + zbirNaCifri(B) + 200 * B))
            return B;

        for (long x = A; x <= B; x++) {
            int zbirNaCifriNaX = zbirNaCifri(x);

            if (zbirNaCifri(A) == 1 && zbirNaCifri(B) == 1)
                return brojac;

            long rezultat = x * x + zbirNaCifriNaX + 200 * x;

            if (rezultat == N) {
                brojac = x;
                break;
            }
        }

        return brojac;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long res = proveri(N, A, B);
        System.out.println(res);

        br.close();

    }

}
