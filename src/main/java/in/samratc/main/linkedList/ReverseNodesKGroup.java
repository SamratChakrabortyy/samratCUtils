package in.samratc.main.linkedList;

public class ReverseNodesKGroup {
    public static void main(String... args){
        ListNode head = null;
        /*head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        new ReverseNodesKGroupSol().reverseKGroup(head, 2);*/
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        new ReverseNodesKGroupSol().reverseKGroup(head, 3);
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        new ReverseNodesKGroupSol().reverseKGroup(head, 4);
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReverseNodesKGroupSol {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, prev = null, next = null, start = null, end = null;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == 1) {
                start = curr;
                curr = curr.next;
            } else if (count == k) {
                next = curr.next;
                curr.next = null;
                ListNode revHead = revList(start);
                if(prev == null)
                    head = revHead;
                else
                    prev.next = revHead;
                start.next = next;
                prev = start;
                count = 0;
                curr = next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    private ListNode revList(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
