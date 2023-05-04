package CikCakSekvenca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int[] a) {
        // Vasiot kod tuka

        int dolzina = 0;
        int najgolema = 0;

        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                if (a[i] < 0 && a[i + 1] > 0 || a[i] > 0 && a[i + 1] < 0) {
                    dolzina++;
                    if (najgolema < dolzina)
                        najgolema = dolzina;
                } else dolzina = 0;
            }
        }
        return najgolema + 1;
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        for (i = 0; i < N; i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
