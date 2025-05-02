package search;

import java.util.HashMap;

public class HashTableSearch {
    public static void main(String[] args) {
        // Set con datos de prueba
        HashMap<Integer, String> hashTable = new HashMap<>();
        hashTable.put(5, "cinco");
        hashTable.put(2, "dos");
        hashTable.put(9, "nueve");
        hashTable.put(1, "uno");
        hashTable.put(6, "seis");
        
        // Existe
        int keyToFind = 9;
        boolean exists = hashTableSearch(hashTable, keyToFind);
        System.out.println("Existe la clave " + keyToFind + "? " + exists);
        
        // No existe
        keyToFind = 7;
        exists = hashTableSearch(hashTable, keyToFind);
        System.out.println("Existe la clave " + keyToFind + "? " + exists);
    }
    
    public static boolean hashTableSearch(HashMap<Integer, String> hashTable, int key) {
        return hashTable.containsKey(key);
    }
}
