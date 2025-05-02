def hash_table_search(hash_table, key):
    return key in hash_table

if __name__ == "__main__":
    # Diccionario con datos de prueba
    hash_table = {
        5: "cinco",
        2: "dos",
        9: "nueve",
        1: "uno",
        6: "seis"
    }
    
    # Existe
    key_to_find = 9
    exists = hash_table_search(hash_table, key_to_find)
    print(f"¿Existe la clave {key_to_find}? {exists}")
    
    # No existe
    key_to_find = 7
    exists = hash_table_search(hash_table, key_to_find)
    print(f"¿Existe la clave {key_to_find}? {exists}")
