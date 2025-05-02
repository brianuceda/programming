package sort;

import java.util.Arrays;

public class TimSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        timSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void shortTimSort(int[] array) {
        Arrays.sort(array);
    }

    public static void timSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        // Insertion sort para pequeñas porciones
        for (int i = 0; i < n; i += 32) {
            insertionSort(arr, i, Math.min(i + 32 - 1, n - 1));
        }
        
        // Combinar con merge
        for (int size = 32; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }
    
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = 0; i < k; i++) {
            arr[left + i] = temp[i];
        }
    }
}
