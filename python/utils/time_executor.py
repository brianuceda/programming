import time
from typing import Callable, Any

def measure_time(func: Callable[[], Any]) -> int:
    start = time.time()
    func()
    end = time.time()
    return int((end - start) * 1000)

# TODO: Ejemplo de uso
def test_function(numbers: list[int]):
    sorted(numbers)

if __name__ == "__main__":
    # Lista de enteros desordenados
    import random
    numbers = [random.randint(0, 1000000) for _ in range(100000)]
    
    # Medir tiempo
    time_taken = measure_time(lambda: {
        test_function(numbers)
    })
    
    print(f"Tiempo de ordenacion: {time_taken} ms")
