/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
// (196ms)
var oddEvenList = function(head) {
    if(head !== null) {
        var odd = head, evenHead = head.next, evenNow = evenHead;
        while(evenNow !== null && evenNow.next !== null) {
            odd.next = evenNow.next;
            odd = odd.next;
            evenNow.next = odd.next;
            evenNow = evenNow.next;
        }
        odd.next = evenHead;
    }
    return head;
};