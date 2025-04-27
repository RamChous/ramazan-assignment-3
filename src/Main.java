public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>();

        table.put("Ramazan", 18);
        table.put("Alihan", 11);
        table.put("Anelya", 6);
        table.put("Arlan", 19);
        table.put("Anuar", 14);

        System.out.println("Size: " + table.size());
        System.out.println("Age of Ramazan: " + table.get("Ramazan"));
        System.out.println("Age of Alihan: " + table.get("Alihan"));
        System.out.println("Remove: " + table.remove("Arlan"));
        System.out.println("Size after removing: " + table.size());
        System.out.println("Table contains 6: " + table.contains(6));
        System.out.println("Table contains 100" + table.contains(100));
        System.out.println("Key of value 14 " + table.getKey(14));
        System.out.println("Key of value 52 " + table.getKey(52));

        System.out.println("---------------------------");

        BST<Integer, String> bst = new BST<>();

        bst.put(23, "Root");
        bst.put(11, "Left child");
        bst.put(52, "Right child");
        bst.put(7, "Left-Left child");
        bst.put(22, "Left-Right child");
        bst.put(99, "Right-Right child");

        System.out.println("Size: " + bst.size());

        System.out.println("Get 23 (Root): " + bst.get(23));
        System.out.println("Get 11 (Left child): " + bst.get(11));
        System.out.println("Get 52 (Right child): " + bst.get(52));
        System.out.println("Get 7 (Left-Left child): " + bst.get(7));
        System.out.println("Get 22 (Left-Right child): " + bst.get(22));
        System.out.println("Get 99 (Right-Right child): " + bst.get(99));

        System.out.println("Get 100 (Should be null): " + bst.get(100));

        bst.delete(23);
        System.out.println("Get 23 (root): " + bst.get(23));
        System.out.println("Size after removing: " + bst.size());

        for (BST.Entry<Integer, String> e : bst.iterator()) {
            System.out.println("Key: " + e.getKey() + " and value: " +  e.getValue());
        }
    }
}