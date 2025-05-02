package sort;

import java.util.Arrays;

public class TimSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        
        // Implementacion automatica
        int[] sortedArray1 = shortTimSort(array.clone());
        System.out.println("Implementacion automatica: " + Arrays.toString(sortedArray1));
        
        // Implementacion manual
        int[] sortedArray2 = timSort(array.clone());
        System.out.println("Implementacion manual: " + Arrays.toString(sortedArray2));
    }
    
    public static int[] shortTimSort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public static int[] timSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        
        int n = arr.length;
        
        // Tamaño de ejecución mínimo
        int minRun = 32;

        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + minRun - 1, n - 1));
        }
        
        // Combinar con merge
        for (int size = minRun; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
        
        return arr;
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
