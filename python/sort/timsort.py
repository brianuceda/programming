def short_tim_sort(arr):
    return sorted(arr)

def tim_sort(arr):
    if not arr or len(arr) <= 1:
        return arr
    
    n = len(arr)
    
    # Tamaño de ejecución mínimo
    min_run = 32
    
    # Paso 1: Ordenar subarrays pequeños con insertion sort
    for start in range(0, n, min_run):
        end = min(start + min_run - 1, n - 1)
        insertion_sort(arr, start, end)
    
    # Paso 2: Combinar los subarrays ordenados
    size = min_run
    while size < n:
        for left in range(0, n, 2 * size):
            mid = min(n - 1, left + size - 1)
            right = min(n - 1, left + 2 * size - 1)
            
            if mid < right:
                merge(arr, left, mid, right)
        
        size *= 2
    
    return arr

def insertion_sort(arr, left, right):
    """Ordenamiento por inserción para un rango específico."""
    for i in range(left + 1, right + 1):
        key = arr[i]
        j = i - 1
        while j >= left and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def merge(arr, left, mid, right):
    """Combina dos subarrays ordenados."""
    len1, len2 = mid - left + 1, right - mid
    left_arr = arr[left:mid + 1]
    right_arr = arr[mid + 1:right + 1]
    
    i = j = 0
    k = left
    
    while i < len1 and j < len2:
        if left_arr[i] <= right_arr[j]:
            arr[k] = left_arr[i]
            i += 1
        else:
            arr[k] = right_arr[j]
            j += 1
        k += 1
    
    while i < len1:
        arr[k] = left_arr[i]
        i += 1
        k += 1
    
    while j < len2:
        arr[k] = right_arr[j]
        j += 1
        k += 1

if __name__ == "__main__":
    array = [5, 2, 9, 1, 5, 6]
    
    # Implementacion automatica
    sorted_array1 = short_tim_sort(array.copy())
    print("Implementacion automatica:", sorted_array1)
    
    # Implementacion manual
    sorted_array2 = tim_sort(array.copy())
    print("Implementacion manual:", sorted_array2)
