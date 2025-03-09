package collections_framework.map_interface;

class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next; // Linked list chaining for collision handling

    Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;  // Default capacity
    private static final float LOAD_FACTOR = 0.75f;
    private Node<K, V>[] buckets; // Array of linked lists (buckets)
    private int size = 0;

    public CustomHashMap() {
        buckets = new Node[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];

        if (buckets[index] == null) {
            buckets[index] = new Node<>(key, value);
        } else {
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing key
                    return;
                }
                if (current.next == null) break; // Reach last node
                current = current.next;
            }
            current.next = new Node<>(key, value); // Add new node at end
        }
        size++;
        if ((float) size > LOAD_FACTOR * buckets.length) {
            resize();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove first node
                } else {
                    prev.next = current.next; // Remove middle or last node
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        buckets = new Node[buckets.length * 2]; // Double capacity
        size = 0; // Reset size and reinsert elements

        for (Node<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    // Display method (for debugging)
    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Node<K, V> current = buckets[i];
            while (current != null) {
                System.out.print("[" + current.key + "=" + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

        customHashMap.put("Java", 10);
        customHashMap.put("Python", 20);
        customHashMap.put("C++", 30);
        customHashMap.put("Java", 100);

        System.out.println("Java: " + customHashMap.get("Java"));
        System.out.println("Python: " + customHashMap.get("Python"));

        customHashMap.remove("Python");
        System.out.println("Python exists? " + customHashMap.containsKey("Python"));

        System.out.println("Size of map: " + customHashMap.size());

        customHashMap.put("Aa", 1);
        customHashMap.put("Bb", 2);

        customHashMap.printMap();
    }
}
