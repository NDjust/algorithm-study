class Solution:

    def __init__(self):
        self.first, self.second, self.prev_node = None, None, None

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead
        """

        def changeTree(root):
            if root is None:
                return
            changeTree(root.left)

            if self.prev_node:
                if self.prev_node.val > root.val:
                    if not self.first:
                        self.first = self.prev_node
                    self.second = root
            self.prev_node = root
            changeTree(root.right)

        changeTree(root)
        self.first.val, self.second.val = self.second.val, self.first.val


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
