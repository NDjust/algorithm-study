package graph;

public class Leetcode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                addNode(result, new ListNode(l1.val));
                l1 = l1.next;
            } else {
                addNode(result, new ListNode(l2.val));
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            while (l2 != null) {
                addNode(result, new ListNode(l2.val));
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                addNode(result, new ListNode(l1.val));
                l1 = l1.next;
            }
        }
        result = result.next;
        return result;
    }

    private void addNode(ListNode result, final ListNode node) {
        if (result.next == null) {
            result.next = node;
            return;
        }
        addNode(result.next, node);
    }

    public static void main(String[] args) {
        Leetcode21 leetcode21 = new Leetcode21();
        ListNode l1One = new ListNode(1);
        ListNode l1Two = new ListNode(2);
        ListNode l1Four = new ListNode(4);

        l1One.next = l1Two;
        l1Two.next = l1Four;

        ListNode l2One = new ListNode(1);
        ListNode l2Three = new ListNode(3);
        ListNode l2Four = new ListNode(4);
        l2One.next = l2Three;
        l2Three.next = l2Four;

        ListNode listNode = leetcode21.mergeTwoLists(l1One, l2One);

        while (listNode.next != null) {
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}