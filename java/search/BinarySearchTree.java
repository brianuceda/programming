package search;

public class BinarySearchTree {
    public static void main(String[] args) {
        // Crear e insertar nodos en el árbol
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        
        // Existe
        int keyToFind = 40;
        boolean exists = tree.binarySearchTree(keyToFind);
        System.out.println("Existe el elemento " + keyToFind + "? " + exists);
        
        // No existe
        keyToFind = 90;
        exists = tree.binarySearchTree(keyToFind);
        System.out.println("Existe el elemento " + keyToFind + "? " + exists);
    }

    public BinarySearchTree() {
        root = null;
    }

    static class Node {
        int key;
        Node left, right;
        
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node root;
    
    public void insert(int key) {
        root = insertRec(root, key);
    }
    
    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }
    
    public boolean binarySearchTree(int key) {
        return searchRec(root, key);
    }
    
    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        
        if (root.key == key) {
            return true;
        }
        
        if (key < root.key) {
            return searchRec(root.left, key);
        }
        
        return searchRec(root.right, key);
    }
}
