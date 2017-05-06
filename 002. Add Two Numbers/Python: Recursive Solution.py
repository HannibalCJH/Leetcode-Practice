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
        def addNumbers(list1, list2, carry):
            if not list1 and not list2:
                # Python的三元运算符，"True result" if True else "False result"
                return ListNode(1) if carry else None
                
            if not list1:
                list1 = ListNode(0)
            if not list2:
                list2 = ListNode(0)
                
            sum = list1.val + list2.val + carry
            node = ListNode(sum % 10)
            node.next = addNumbers(list1.next, list2.next, sum // 10)
            return node
            
        return addNumbers(l1, l2, 0)
