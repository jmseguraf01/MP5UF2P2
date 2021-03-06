package ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class HashTableTest {

    @ParameterizedTest
    @CsvSource({"10","15","20","25"})
    void count(int inserts) {
        // Inserto datos y compruebo el total de items insertados
        HashTable hashTable = new HashTable();
        for (int i = 0; i < inserts; i++) {
            hashTable.put(String.valueOf(inserts), String.valueOf(inserts));
        }
        Assertions.assertEquals(inserts, hashTable.count());
    }

    @org.junit.jupiter.api.Test
    void size() {
        ex1.HashTable hashTable = new ex1.HashTable();
        Assertions.assertEquals(hashTable.size(), hashTable.size());
    }

    @ParameterizedTest
    @CsvSource({"a,1", "b,2", "c,2"})
    void put(String value, String key) {
        HashTable hashTable = new HashTable();
        // Compruebo la inserccion en las colisiones
        for (String key2 : hashTable.getCollisionsForKey(key, 5)) {
            hashTable.put(key2, value);
            Assertions.assertEquals(value, hashTable.get(key2));
        }
        // Compruebo que se sustituyen los datos cuando la key es la misma
        String nuevoValor = "nuevo valor";
        hashTable.put("20", value);
        hashTable.put("20", nuevoValor);
        hashTable.put("31", value);
        hashTable.put("31", nuevoValor);
        Assertions.assertEquals(nuevoValor, hashTable.get("20"));
        Assertions.assertEquals(nuevoValor, hashTable.get("31"));
    }

    @org.junit.jupiter.api.Test
    void get() {
        String value = "a";
        String key = "1";
        HashTable hashTable = new HashTable();
        hashTable.put(key, value);
        // Valor existente
        Assertions.assertEquals(value, hashTable.get(key));
        // Un valor que no existe
        Assertions.assertEquals(null, hashTable.get("5"));
    }

    @ParameterizedTest
    @CsvSource({"a,3", "b,2", "c,39000"})
    void drop(String value, String key) {
        HashTable hashTable = new HashTable();
        // Elimino los datos que inserto
        for (String key2 : hashTable.getCollisionsForKey(key, 5)) {
            hashTable.put(key2, value);
            hashTable.drop(key2);
            Assertions.assertEquals(null, hashTable.get(key2));
        }
    }
}