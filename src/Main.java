public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> table = new MyHashTable<>();

        table.put("Ramazan", 18);
        table.put("Alihan", 11);
        table.put("Anelya", 6);
        table.put("Arlan", 19);
        table.put("Anuar", 14);

        System.out.println(table.size());

        System.out.println(table.get("Ramazan"));
        System.out.println(table.get("Alihan"));

        System.out.println(table.remove("Arlan"));
        System.out.println(table.size());
    }
}