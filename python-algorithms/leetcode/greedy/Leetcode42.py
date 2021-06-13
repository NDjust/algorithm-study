from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        ans = 0
        left, right = 0, n - 1
        l_max, r_max = 0, 0

        while left < right:
            if height[left] < height[right]:
                l_max = max(l_max, height[left])
                ans = ans + l_max - height[left]
                left = left + 1
            else:
                r_max = max(r_max, height[right])
                ans = ans + r_max - height[right]
                right = right - 1
        return ans


if __name__ == '__main__':
    s = Solution()
    trap = s.trap([5, 4, 1, 2])
    print(trap)
