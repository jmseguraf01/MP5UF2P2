package ex3;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        // Put some key values.
        for (int i = 0; i < 30; i++) {
            final String key = String.valueOf(i);
            hashTable.put(key, new Persona("juanmi", key));
        }
        hashTable.put("10", new Persona("nuev o valor", "10"));

        // Print the HashTable structure
        HashTable.log("****   HashTable  ***");
        HashTable.log(hashTable.toString());
        HashTable.log("\nValue for key(20) : " + hashTable.get("20"));
    }

    private static class Persona {
        String name;
        String edad;

        public Persona(String name, String edad) {
            this.name = name;
            this.edad = edad;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "name='" + name + '\'' +
                    ", edad='" + edad + '\'' +
                    '}';
        }
    }
}


// [1 -> [2 -> [3 -> [4]]],0,0,0]