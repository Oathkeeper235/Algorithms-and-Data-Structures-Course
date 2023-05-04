package BlackFriday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;
import java.util.Comparator;

class Heap<E extends Comparable<E>> {

    private E elements[];

    private Comparator<? super E> comparator;

    private int compare(E k1, E k2) {
        return (comparator == null ? k1.compareTo(k2) : comparator.compare(k1, k2));
    }

    int getParent(int i) {
        return (i + 1) / 2 - 1;
    }

    public E getAt(int i) {
        return elements[i];
    }

    int getLeft(int i) {
        return (i + 1) * 2 - 1;
    }

    int getRight(int i) {
        return (i + 1) * 2;
    }

    void setElement(int index, E elem) {
        elements[index] = elem;
    }

    void swap(int i, int j) {
        E tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    void adjust(int i, int n) {

        while (i < n) {

            int left = getLeft(i);
            int right = getRight(i);
            int largest = i;

            if ((left < n) && (elements[left].compareTo(elements[largest]) > 0))
                largest = left;
            if ((right < n) && (elements[right].compareTo(elements[largest]) > 0))
                largest = right;

            if (largest == i)
                break;

            swap(i, largest);
            i = largest;

        }

    }

    void buildHeap() {
        int i;
        for (i = elements.length / 2 - 1; i >= 0; i--)
            adjust(i, elements.length);
    }

    public void heapSort() {
        int i;
        buildHeap();
        for (i = elements.length; i > 1; i--) {
            swap(0, i - 1);
            adjust(0, i - 1);
        }
    }

    @SuppressWarnings("unchecked")
    public Heap(int size) {
        elements = (E[]) new Comparable[size];
    }

}

public class BlackFriday {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line;

        Heap<Integer> vlez = new Heap<Integer>(N);
        Heap<Integer> izlez = new Heap<Integer>(N);

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String[] splits = line.split("(:|\\s+)");

            int start = (Integer.parseInt(splits[0]) * 60) + Integer.parseInt(splits[1]);
            int end = Math.min(start + Integer.parseInt(splits[2]), 23 * 60 + 59);

            vlez.setElement(i, start);
            izlez.setElement(i, end);
        }

        vlez.heapSort();
        izlez.heapSort();

        maxCustomers(vlez, izlez, N);
    }

    public static void maxCustomers(Heap<Integer> vlez, Heap<Integer> izlez, int n) {
        int prisutni = 0;
        int max = 0;
        int v = 0;

        for (int i = 0; i < n; i++) {
            int start = vlez.getAt(i);
            prisutni++;
            int end = izlez.getAt(v);

            if (end <= start) {
                prisutni--;
                v++;
            }

            max = Math.max(prisutni, max);
        }

        System.out.println(max);
    }
}
