import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable() {
        this.buckets = new Entry[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    // Función hash
    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Obtener índice
    private int indexFor(K key) {
        return hash(key);
    }

    // PUT - Insertar o actualizar
    public V put(K key, V value) {
        int idx = indexFor(key);
        Entry<K, V> head = buckets[idx];

        // Buscar si la clave ya existe
        for (Entry<K, V> cur = head; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                V old = cur.value;
                cur.value = value;
                return old;
            }
        }

        // Insertar al inicio de la lista
        buckets[idx] = new Entry<>(key, value, head);
        size++;

        // Verificar factor de carga
        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

        return null;
    }

    // GET - Obtener valor
    public V get(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    // REMOVE - Eliminar
    public V remove(K key) {
        int idx = indexFor(key);
        Entry<K, V> cur = buckets[idx];
        Entry<K, V> prev = null;

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) {
                    buckets[idx] = cur.next;
                } else {
                    prev.next = cur.next;
                }
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    // CONTAINS_KEY - Verificar existencia
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // SIZE
    public int size() {
        return size;
    }

    // IS_EMPTY
    public boolean isEmpty() {
        return size == 0;
    }

    // Redimensionar tabla
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        buckets = new Entry[oldBuckets.length * 2];
        size = 0;

        for (Entry<K, V> head : oldBuckets) {
            Entry<K, V> cur = head;
            while (cur != null) {
                put(cur.key, cur.value);
                cur = cur.next;
            }
        }
    }

    // Método para mostrar la tabla (para debugging)
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> cur = buckets[i];
            while (cur != null) {
                System.out.print(cur + " -> ");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    // Obtener todas las claves
    public List<K> keys() {
        List<K> keyList = new ArrayList<>();
        for (Entry<K, V> head : buckets) {
            Entry<K, V> cur = head;
            while (cur != null) {
                keyList.add(cur.key);
                cur = cur.next;
            }
        }
        return keyList;
    }
}