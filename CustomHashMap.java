class CustomHashMap {
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private Entry[] buckets;

    public CustomHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int getBucketIndex(int key) {
        return key % INITIAL_CAPACITY;
    }

    public void put(int key, int value) {
        int index = getBucketIndex(key);
        Entry newNode = new Entry(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Entry current = buckets[index];
            Entry prev = null;
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
        }
    }

    public Integer get(int key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        System.out.println("Value for key 2: " + map.get(2));
        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2));
    }
}