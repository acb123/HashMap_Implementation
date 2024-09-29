package com.acb.map;

class Node<K, V> {
    final K key;
    V value;
    Node<K, V> next;

    public Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (obj instanceof Node) {
            Node Node = (Node) obj;

            return key.equals(Node.getKey()) &&
                    value.equals(Node.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
        hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }
}
