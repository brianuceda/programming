package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        // Construir heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extraer elementos del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover raíz al final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Llamar heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Si hijo izquierdo es mayor que raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // Si hijo derecho es mayor que el mayor hasta ahora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // Si el mayor no es la raíz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Heapify el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}
