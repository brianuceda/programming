package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int[] temp = new int[arr.length];
        applyMergeSort(arr, temp, 0, arr.length - 1);
    }
    
    private static void applyMergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            applyMergeSort(arr, temp, left, mid);
            applyMergeSort(arr, temp, mid + 1, right);
            
            merge(arr, temp, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copiar a array temporal
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        
        // Copiar elementos restantes si los hay
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }
}
