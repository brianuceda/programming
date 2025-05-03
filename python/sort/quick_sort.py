def quick_sort(array):
    def _quick_sort_helper(arr, low, high):
        if low < high:
            pi = partition(arr, low, high)
            _quick_sort_helper(arr, low, pi - 1)
            _quick_sort_helper(arr, pi + 1, high)
    
    def partition(arr, low, high):
        # Pivote el de la derecha
        pivot = arr[high]
        
        # Apuntador del último elemento más pequeño
        i = low - 1
        
        for j in range(low, high):
            if arr[j] <= pivot:
                # Avanzar apuntador
                i = i + 1
                # Intercambiar elementos
                (arr[i], arr[j]) = (arr[j], arr[i])
        
        # Al final intercambiar el pivote
        (arr[i + 1], arr[high]) = (arr[high], arr[i + 1])
        
        # Regresa la posición final del pivote
        return i + 1
    
    # Llamamos a la función auxiliar directamente sobre el array
    if len(array) > 1:
        _quick_sort_helper(array, 0, len(array) - 1)
    
    return array

if __name__ == "__main__":
    array = [5, 2, 9, 1, 5, 6]
    quick_sort(array)
    print(array)
