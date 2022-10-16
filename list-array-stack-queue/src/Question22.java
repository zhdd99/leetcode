/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-10-16
 */

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Question22 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }
        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        return head.next;
    }
}
