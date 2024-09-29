package com.acb.map;

public class CustomMap<K, V> {

    private Node<K, V>[] buckets;
    private int capacity; // 16

    private int size = 0;

    private double lf = 0.75;

    public CustomMap() {
        this(16);
    }

    public CustomMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[this.capacity];
    }

    public void put(K key, V value) {
        if (size == lf * capacity) {
            // rehash
            Node<K, V>[] old = buckets;

            capacity *= 2;
            size = 0;
            buckets = new Node[capacity];

            for (Node<K,V> e: old) {
                while (e != null) {
                    put(e.key, e.value);
                    e = e.next;
                }
            }
        }
        Node<K, V> node = new Node<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Node<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = node;
            size++;
        } else {
            // compare the keys to see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = node;
                size++;
            }
        }
    }

    public V get(K key) {
        Node<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (key.equals(bucket.key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private int getBucketSize() {
        return buckets.length;
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : buckets) {
            sb.append("[");
            while (node != null) {
                sb.append(node);
                if (node.next != null) {
                    sb.append(", ");
                }
                node = node.next;
            }
            sb.append("]");
        }
        return "{" + sb.toString() + "}";
    }
}
