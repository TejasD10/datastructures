package com.zzz.tutorial.sorting;

public class MergeSort<Key extends Comparable<Key>> {

    Key[] input;

    public MergeSort(Comparable[] input) {
        if (input == null) {
            this.input = (Key[]) new Comparable[0];
            return;
        }
        this.input = (Key[]) input;
    }

    public Key[] sort() {
        Key[] aux = (Key[]) new Comparable[input.length];
        sort(input, aux, 0, input.length - 1);
        return (Key[]) input;
    }

    @SuppressWarnings("rawtypes")
    private void sort(Comparable[] input, Comparable aux[], int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = (hi + lo) / 2;
        sort(input, aux, lo, mid);
        sort(input, aux, mid + 1, hi);
        merge(input, aux, lo, mid, hi);
    }

    private void merge(Comparable input[], Comparable aux[], int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = input[k];
        }
        int j = mid + 1;
        int i = lo;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                input[k] = aux[j++];
            else if (j > hi)
                input[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0)
                input[k] = aux[i++];
            else
                input[k] = aux[j++];
        }
    }

}
