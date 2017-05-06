# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = pre = ListNode(-1)
        carry = 0
        
        while l1 or l2 or carry:
            if not l1:
                l1 = ListNode(0)
            if not l2:
                l2 = ListNode(0)
            
            sum = l1.val + l2.val + carry
            cur = ListNode(sum % 10)
            carry = sum // 10
            pre.next = cur
            pre = cur
            l1 = l1.next
            l2 = l2.next
            
        return dummy.next
