package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray = quickSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        applyQuickSort(arrCopy, 0, arrCopy.length - 1);
        return arrCopy;
    }
    
    private static void applyQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            applyQuickSort(arr, low, pi - 1);
            applyQuickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        // Tomar el último elemento como pivote
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
