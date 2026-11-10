import java.util.LinkedList;

class MyHashSet {
    private static final int BASE = 769;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BASE;
    }
    
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        bucket.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> bucket = buckets[index];
        return bucket.contains(key);
    }
}