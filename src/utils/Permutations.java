package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static <T> ArrayList<ArrayList<T>> getPermutations(T[] inElements) {

        T[] elements = Arrays.copyOf(inElements, inElements.length);
        ArrayList<ArrayList<T>> permutations = new ArrayList<>();

        int n = elements.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }
        permutations.add(new ArrayList(Arrays.asList(elements)));
        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                permutations.add(new ArrayList(Arrays.asList(elements)));
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }
        return permutations;
    }

    private static <T> void swap(T[] elements, int a, int b) {
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

}
