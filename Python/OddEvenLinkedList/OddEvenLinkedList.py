# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    # (75ms)
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head:
            odd, even_head, even_now = head, head.next, head.next
            while even_now and even_now.next:
                odd.next = even_now.next
                odd = odd.next
                even_now.next = odd.next
                even_now = even_now.next
            odd.next = even_head
        return head
