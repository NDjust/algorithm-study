from typing import Optional


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l2:
            return l1
        if not l1:
            return l2

        temp_l1 = l1
        temp_l2 = l2
        result = ListNode()
        round_up = 0
        while temp_l1 is not None and temp_l2 is not None:
            value = temp_l1.val + temp_l2.val + round_up
            round_up = value // 10
            temp_l1.val = value % 10
            result = temp_l1
            temp_l1 = temp_l1.next
            temp_l2 = temp_l2.next

        if temp_l2 is not None:
            temp_l1 = temp_l2

            if result is not None:
                result.next = temp_l2

        while temp_l1 is not None:
            value = temp_l1.val + round_up
            round_up = value // 10
            temp_l1.val = value % 10
            result = temp_l1
            temp_l1 = temp_l1.next
        if round_up:
            result.next = ListNode(round_up)
        return l1
