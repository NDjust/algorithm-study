from typing import List


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = float('inf')
        left = 0
        _sum = 0
        for i in range(len(nums)):
            _sum += nums[i]

            while _sum >= target:
                ans = min(i + 1 - left, ans)
                _sum -= nums[left]
                left = left + 1

        return 0 if ans == float('inf') else ans
