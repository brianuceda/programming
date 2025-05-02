package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Mover elementos mayores que key a una posición adelante
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
