import atomic.ListNode;

public class MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 == null) ? list2 : list1;
        return res.next;
    }

    public static ListNode head1, head2;

    public static void main(String[] args) {

        head1 = new ListNode(4);
        head1.next = new ListNode(20);
        head1.next.next = new ListNode(35);
        head1.next.next.next = new ListNode(89);

        head2 = new ListNode(15);
        head2.next = new ListNode(25);
        head2.next.next = new ListNode(40);

        ListNode newHead = mergeTwoLists(head1, head2);
        ListNode.printList(newHead);
    }
}
