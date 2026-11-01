// Problem: LFU Cache
// Platform: leetcode
// Rating/Difficulty: Hard
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/lfu-cache/
// Solved on: 2026-11-01T07:21:09.028Z


import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // Insert at front: most recently used
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove a particular node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // Remove least recently used node
        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private int capacity;
    private int minFreq;

    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) return;

        // If key already exists
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;

            updateFrequency(node);
            return;
        }

        // If cache is full, remove LFU and LRU node
        if (keyToNode.size() == capacity) {

            DoublyLinkedList list = freqToList.get(minFreq);

            Node removed = list.removeLast();

            keyToNode.remove(removed.key);
        }

        // Insert new node with frequency 1
        Node newNode = new Node(key, value);

        keyToNode.put(key, newNode);

        freqToList
            .computeIfAbsent(1, k -> new DoublyLinkedList())
            .addFirst(newNode);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqToList.get(oldFreq);

        oldList.remove(node);

        // If this was the last node with minimum frequency
        if (oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        // Increase frequency
        node.freq++;

        // Add node to the new frequency list
        freqToList
            .computeIfAbsent(node.freq, k -> new DoublyLinkedList())
            .addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */