package HashMap;
import java.util.*;
class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
    }

    HashMap<Integer, Node> cache;
    int cap;
    Node head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        // add at first
        Node nbr = head.next;

        node.next = nbr;
        node.prev = head;

        nbr.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        // remove from the list
        // first we find prev node and next node of the curr node
        Node prevNbr = node.prev;
        Node nextNbr = node.next;

        // second we point the prevNbr next to nextnbr and the prev of Nextnbr to prev
        prevNbr.next = nextNbr;
        nextNbr.prev = prevNbr;

        // make the next and prev of curr node and null
        node.next = node.prev = null;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            int val = node.value;
            moveToFront(node);
            return val;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            // pair doesn't exists
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if (cache.size() == cap) {
                Node LRU_node = tail.prev;
                cache.remove(LRU_node.key);
                removeNode(LRU_node);
            }
            cache.put(key, newNode);
            addNode(newNode);
        } else {
            node.value = value;
            moveToFront(node);
        }
    }
}
