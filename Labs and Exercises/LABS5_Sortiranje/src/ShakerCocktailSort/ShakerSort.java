package ShakerCocktailSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    static void shakerSort(int a[], int n) {
        // Vasiot kod tuka
        boolean swapped = true;
        int start = 0;

        while (swapped == true) {
            swapped = false;

            for (int i = n - 2 - start; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    swapped = true;
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            print(a);

            for (int i = start; i < n - 1 - start; i++) {
                if (a[i] > a[i + 1]) {
                    swapped = true;
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            print(a);

            start++;
        }
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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
        shakerSort(a, n);
    }
}