def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        if arr[mid] == target:
            return True
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    
    return False

if __name__ == "__main__":
    # Array ordenado
    array = [1, 2, 5, 6, 9, 12, 15, 21, 28]
    
    # Existe
    target = 15
    exists = binary_search(array, target)
    print(f"¿Existe el elemento {target}? {exists}")
    
    # No existe
    target = 10
    exists = binary_search(array, target)
    print(f"¿Existe el elemento {target}? {exists}")
