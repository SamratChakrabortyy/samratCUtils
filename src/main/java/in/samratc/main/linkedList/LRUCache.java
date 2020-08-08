package in.samratc.main.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private static class DLinkNode {
        int key, value;
        DLinkNode pre, post;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {

        }
    }

    private final int capacity;
    private int count;
    private final Map<Integer, DLinkNode> cache = new HashMap<>();
    private final DLinkNode head;
    private final DLinkNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.head = new DLinkNode();
        this.tail = new DLinkNode();
        this.head.pre = this.tail.post = null;
        this.head.post = this.tail;
        this.tail.pre = this.head;
    }

    /**
     * Add Node to the next of Head
     */
    private void addToHead(DLinkNode node) {
        node.pre = this.head;
        node.post = this.head.post;
        node.pre.post = node;
        node.post.pre = node;
    }

    /**
     * remove an existing Node from List
     */
    private void removeNode(DLinkNode node) {
        DLinkNode pre = node.pre;
        DLinkNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Remove node prom tail and return the same;
     */
    private DLinkNode popFromTail() {
        DLinkNode node = this.tail.pre;

        node.pre.post = this.tail;
        node.post.pre = node.pre;

        return node;
    }

    /**
     * move a certain node to head
     */
    private void moveToHead(DLinkNode node) {
        this.removeNode(node);
        this.addToHead(node);
    }

    public int get(int key) {
        if (!this.cache.containsKey(key))
            return -1; // should raise an Exception
        DLinkNode node = this.cache.get(key);
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node;
        if (this.cache.containsKey(key)) {
            node = this.cache.get(key);
            node.value = value;
            this.removeNode(node);
        } else {
            node = new DLinkNode(key, value);
            this.cache.put(key, node);
            this.count++;
        }
        this.addToHead(node);
        if (this.count > this.capacity) {
            DLinkNode last = this.popFromTail();
            this.cache.remove(last.key);
            this.count--;
        }
    }
}
