package in.samratc.main.amazonOp;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyRandomLinkedList {
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class DeepCopyRandomLinkedListSol {
    /**
     * T: O(n) S:O(n)
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr = head, newHead = null, newCurr = null;
        while (curr != null) {
            if (!nodeMap.containsKey(curr))
                nodeMap.put(curr, new Node(curr.val));
            Node newNode = nodeMap.get(curr);
            if (curr.random != null) {
                if (!nodeMap.containsKey(curr.random))
                    nodeMap.put(curr.random, new Node(curr.random.val));
                newNode.random = nodeMap.get(curr.random);
            }
            if (newHead == null) {
                newHead = newNode;
                newCurr = newNode;
            } else {
                newCurr.next = newNode;
                newCurr = newCurr.next;
            }

            curr = curr.next;
        }
        return newHead;
    }

    /**
     * T: O(n) S:O(1)
     */
    public Node copyRandomList2(Node head) {
        if (head == null)
            return head;
        Node curr = head, copy = null;
        while (curr != null) {
            Node next = curr.next;
            copy = new Node(curr.val);
            copy.next = next;
            curr.next = copy;
            curr = next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = curr.random.next;
            curr = curr.next;
        }

        curr = head;
        Node copyHead = null, copyCurr = null;
        while (curr != null) {
            copy = curr.next;
            Node next = curr.next.next;
            if (copyHead == null) {
                copyCurr = copy;
                copyHead = copy;
            } else {
                copyCurr.next = copy;
                copyCurr = copyCurr.next;
            }

            curr.next = next;
            curr = next;
        }
        return copyHead;
    }
}
