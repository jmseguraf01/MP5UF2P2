package ex4;

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
<<<<<<< HEAD:src/main/java/ex4/HashTableTest.java
        HashTable hashTable = new HashTable();
=======
        ex1.HashTable hashTable = new ex1.HashTable();
>>>>>>> bcc46816bf06f94330bd25a86361a31a97b2bbdd:MP05UF2P2/src/main/java/ex4/HashTableTest.java
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