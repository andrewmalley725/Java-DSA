package algorithms.sorts.mergesort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array1 = {1,3,7,8};
        int[] array2 = {2,4,5,6};

        System.out.println( Arrays.toString( merge(array1, array2) ) );
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];
        int mainIndex = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                newArray[mainIndex] = array1[i];
                mainIndex++;
                i++;
            } else {
                newArray[mainIndex] = array2[j];
                mainIndex++;
                j++;
            }
        }
        while (i < array1.length) {
            newArray[mainIndex] = array1[i];
            mainIndex++;
            i++;
        }
        while (j < array2.length) {
            newArray[mainIndex] = array2[j];
            mainIndex++;
            j++;
        }
        return newArray;
    }
}
