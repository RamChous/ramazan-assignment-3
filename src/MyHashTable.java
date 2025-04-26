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
    private int size;

    public MyHashTable(){
        this(11);
        size = 0;
    }

    public MyHashTable(int M){
        chainArray = new HashNode[M];
        size = 0;
    }

    private int hash(K key){
        return 0;
    }

    public void put(K key, V value){

    }
}
