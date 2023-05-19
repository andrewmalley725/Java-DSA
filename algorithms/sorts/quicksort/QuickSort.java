package algorithms.sorts.quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {4,6,1,7,3,2,5};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swap = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swap++;
                swap(array, swap, i);
            }
        }
        swap(array, pivotIndex, swap);

        return swap;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = pivot(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot+1, right);
        }
    }
}
