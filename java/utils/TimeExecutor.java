package utils;

public class TimeExecutor {
    public static int measureTime(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }
    
    public static <T> int measureTime(java.util.function.Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        supplier.get();
        long end = System.currentTimeMillis();
        return (int)(end - start);
    }
    
    // TODO: Ejemplo de uso
    public static void test_function(int[] numbers) {
        java.util.Arrays.sort(numbers);
    }

    public static void main(String[] args) {
        // Array de enteros desordenados
        int[] numbers = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 1000000);
        }
        
        // Medir tiempo
        int time = measureTime(() -> {
            test_function(numbers);
        });
        
        System.out.println("Tiempo de ordenacion: " + time + " ms");
    }
}
