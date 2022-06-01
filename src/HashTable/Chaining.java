package HashTable;

public class Chaining<K, V> {
    private int M = 13;
    private Node[] a = new Node[M];

    public static class Node {
        private Object key;
        private Object data;
        private Node next;

        public Node(Object newKey, Object newData, Node ref) {
            key = newKey;
            data = newData;
            next = ref;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getData() {
            return this.data;
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7ffffff) % M;
    }

    public V get(K key) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (V) x.data;
        }
        return null;
    }

    private void put(K key, V data) {
        int i = hash(key);
        for (Node x = a[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.data = data;
                return;
            }
        }
        a[i] = new Node(key, data, a[i]);
    }
}
