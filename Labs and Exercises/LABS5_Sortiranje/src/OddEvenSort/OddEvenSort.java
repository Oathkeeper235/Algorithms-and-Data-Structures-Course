package OddEvenSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class OddEvenSort {

    static void oddEvenSort(int[] a, int n) {
        // Vasiot kod tuka
        int neparni = 0;
        int parni = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0)
                parni++;
            else
                neparni++;
        }

        int[] neparniNiza = new int[neparni];
        int[] parniNiza = new int[parni];

        int temp;

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0)
                neparniNiza[k++] = a[i];
        }

        k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0)
                parniNiza[k++] = a[i];
        }

        for (int i = 0; i < neparni - 1; i++) {
            for (int j = 0; j < neparni - i - 1; j++) {
                if (neparniNiza[j] > neparniNiza[j + 1]) {
                    temp = neparniNiza[j];
                    neparniNiza[j] = neparniNiza[j + 1];
                    neparniNiza[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < parni - 1; i++) {
            for (int j = 0; j < parni - i - 1; j++) {
                if (parniNiza[j] < parniNiza[j + 1]) {
                    temp = parniNiza[j];
                    parniNiza[j] = parniNiza[j + 1];
                    parniNiza[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < neparni; i++)
            a[i] = neparniNiza[i];

        for (int i = 0; i < parni; i++)
            a[i + neparni] = parniNiza[i];

    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}