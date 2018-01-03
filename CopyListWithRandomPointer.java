/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
    private void copyNext(RandomListNode head) {
        while(head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = head.next;
            node.random = head.random;
            head.next = node;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        while(head != null) {
            if(head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        while(head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            if(temp.next != null) {
                temp.next = temp.next.next;
            }
            head = head.next;
        }
        return newHead;
    }
}
