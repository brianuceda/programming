class Node:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None
    
    def insert(self, key):
        """Insertar un nodo en el árbol."""
        if self.root is None:
            self.root = Node(key)
            return
        
        self._insert_recursive(self.root, key)
    
    def _insert_recursive(self, node, key):
        """Inserción recursiva de un nodo."""
        if key < node.key:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        elif key > node.key:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)
    
    def search(self, key):
        """Buscar un valor en el árbol."""
        return self._search_recursive(self.root, key)
    
    def _search_recursive(self, node, key):
        """Búsqueda recursiva de un valor."""
        if node is None or node.key == key:
            return node is not None
        
        if key < node.key:
            return self._search_recursive(node.left, key)
        return self._search_recursive(node.right, key)

if __name__ == "__main__":
    # Crear e insertar nodos en el árbol
    tree = BinarySearchTree()
    tree.insert(50)
    tree.insert(30)
    tree.insert(70)
    tree.insert(20)
    tree.insert(40)
    tree.insert(60)
    tree.insert(80)
    
    # Existe
    key_to_find = 40
    exists = tree.search(key_to_find)
    print(f"¿Existe el elemento {key_to_find}? {exists}")
    
    # No existe
    key_to_find = 90
    exists = tree.search(key_to_find)
    print(f"¿Existe el elemento {key_to_find}? {exists}")
