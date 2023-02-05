import atomic.ListNode;

public class ReverseLinkedList {
    public static ListNode head;

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        head = new ListNode(85);
        head.next = new ListNode(15);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(20);

        System.out.println("Given linked list");
        ListNode.printList(head);
        head = reverseList(head);
        System.out.println();
        System.out.println("Reversed linked list ");
        ListNode.printList(head);
    }
}
