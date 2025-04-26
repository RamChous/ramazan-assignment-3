public class MyHashTable<K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private double loadFactor = 0.9;
    private int size;

    public MyHashTable(){
        this(11);
        size = 0;
    }

    public MyHashTable(int M){
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % chainArray.length;
    }

    public void ensureLoadFactor() {
        if ((double) size / chainArray.length > loadFactor) {
            HashNode<K, V>[] oldChainArray = chainArray;
            chainArray = new HashNode[chainArray.length * 2];

            for (HashNode<K, V> current : chainArray){
                while (current != null) {
                    HashNode<K, V> next = current.next;
                    int index = hash(current.key);
                    current.next = chainArray[index];
                    chainArray[index] = current;
                    current = next;
                }
            }
        }
    }

    public void put(K key, V value) {
        ensureLoadFactor();
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }

    public int size(){
        return size;
    }
}
