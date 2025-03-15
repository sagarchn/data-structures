import java.util.HashMap;

public class LRUCache {

    private final int size;
    private Node first;
    private Node last;

    private HashMap<Integer, Node> map;

    public void print() {
        if (map.isEmpty())
            System.out.println("[EMPTY]");
        StringBuilder sb = new StringBuilder();

        Node curr = first;
        while (curr != null) {
            sb.append("[" + curr.key + " : " + curr.val + "]");
            sb.append(" ");
            curr = curr.next;
        }

        System.out.println(sb.toString());

    }

    static class Node {
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        System.out.println("Retrieving key : " + key);
        Node rVal = map.get(key);
        if (null == rVal) {
            return -1;
        }
        moveToTop(rVal);
        return rVal.val;
    }

    private void moveToTop(Node node) {
        removeNode(node);
        addNode(node);
    }


    public void put(int key, int value) {
        System.out.println("Adding key : " + key + " value : " + value);
        if (map.containsKey(key)) { // if already present remove and insert again
            removeNode(map.get(key));
            map.remove(key);
        }
        if(map.size() == size) {
            map.remove(last.key);
            removeNode(last);
        }
        // add new node
        Node node = new Node(key, value);
        map.put(key, node);

        addNode(node);
    }

    private void addNode(Node node) {
        node.next = first;
        node.prev = null;
        if(first != null) {
            first.prev = node;
        }
        first = node;
        if (last == null) {
            last = first;
        }
    }

    // [1] [2]
    // p = null, n = null
    private void removeNode(Node node) {
        if (first == null)
            return;
        Node p = node.prev;
        Node n = node.next;

        if (p == null && n == null) {
            first = last = null;
        }

        if (null != p) {
            p.next = n;
        } else {
            first = n;
        }
        if (null != n) {
            n.prev = p;
        } else {
            last = p;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */