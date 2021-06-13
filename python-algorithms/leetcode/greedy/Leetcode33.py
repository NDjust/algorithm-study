from math import floor
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = floor(left + (right - left) / 2)
            if nums[mid] == target:
                return mid
            if target < nums[mid] and nums[left] <= nums[mid]:
                if target < nums[left]:
                    left = mid + 1
                else:
                    right = mid - 1
            elif target < nums[mid] < nums[left]:
                right = mid - 1
            elif target > nums[mid] and nums[right] >= nums[mid]:
                if target > nums[right]:
                    right = mid - 1
                else:
                    left = mid + 1
            elif target > nums[mid] > nums[right]:
                left = mid + 1
            else:
                break
        return -1
