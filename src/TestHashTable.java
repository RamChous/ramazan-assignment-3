import java.util.Random;

public class TestHashTable {
    private static class MyTestingClass {
        private int id;
        private String name;

        public MyTestingClass(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object)
                return true;
            if (object == null || getClass() != object.getClass())
                return false;
            MyTestingClass other = (MyTestingClass) object;
            return id == other.id && (name != null ? name.equals(other.name) : other.name == null);
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = 31 * hash + id;
            for (int i = 0; i < name.length(); i++)
                hash = 31 * hash + name.charAt(i);
            return hash;
        }
    }

    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args){
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++){
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(1000);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student" + i, random.nextInt(30));

            table.put(key, value);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        int bucket = table.bucketCount();

        for (int i = 0; i < table.bucketCount(); i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, Student> node = table.getBucket(i);
            while (node != null) {
                count++;
                node = node.next;
            }
            System.out.println("Bucket " + i + ":" + count + " elements");
            if (count < min)
                min = count;
            if (count > max)
                max = count;
            total += count;
        }
        System.out.println("Minimum number of elements in a bucket: " + min);
        System.out.println("Maximum number of elements in a bucket: " + max);
        System.out.println("Average number of elements in a bucket: " + (double) total / bucket);
    }
}
