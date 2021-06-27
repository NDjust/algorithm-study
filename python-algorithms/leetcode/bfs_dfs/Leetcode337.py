# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rob(self, root):
        def dfs(node):
            if not node:
                return 0, 0

            taking_left, leaving_left = dfs(node.left)
            taking_right, leaving_right = dfs(node.right)
            #  take
            taking = node.val + leaving_left + leaving_right
            # leave
            leaving = max(taking_left, leaving_left) + max(taking_right, leaving_right)
            return taking, leaving

        return max(dfs(root))