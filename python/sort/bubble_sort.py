def bubble_sort(arr):
    n = len(arr)
    
    for i in range(n):
        # Bandera para optimizar si el array ya está ordenado
        swapped = False
        
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        
        # Si no hubo intercambios en esta pasada, el array está ordenado
        if not swapped:
            break
    
    return arr

if __name__ == "__main__":
    array = [5, 2, 9, 1, 5, 6]
    sorted_array = bubble_sort(array.copy())
    print(sorted_array)
