package search;

public class BinarySearch {
    public static void main(String[] args) {
        // Array ordenado
        int[] array = {1, 2, 5, 6, 9, 12, 15, 21, 28};
        
        // Existe
        int target = 15;
        boolean exists = binarySearch(array, target);
        System.out.println("Existe el elemento " + target + "? " + exists);
        
        // No existe
        target = 10;
        exists = binarySearch(array, target);
        System.out.println("Existe el elemento " + target + "? " + exists);
    }
    
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return true;
            }
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}
