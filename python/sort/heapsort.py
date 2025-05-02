def heap_sort(arr):
    n = len(arr)
    
    # Construir max heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    
    # Extraer elementos uno por uno
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0] # Intercambiar
        heapify(arr, i, 0)
    
    return arr

def heapify(arr, n, i):
    """Transforma un subárbol en un heap."""
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2
    
    # Verificar si el hijo izquierdo existe y es mayor que la raíz
    if left < n and arr[left] > arr[largest]:
        largest = left
    
    # Verificar si el hijo derecho existe y es mayor que el mayor actual
    if right < n and arr[right] > arr[largest]:
        largest = right
    
    # Cambiar la raíz si es necesario
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

if __name__ == "__main__":
    array = [5, 2, 9, 1, 5, 6]
    sorted_array = heap_sort(array.copy())
    print(sorted_array)
