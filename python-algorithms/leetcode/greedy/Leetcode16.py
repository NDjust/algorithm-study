import sys
from typing import List


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        if len(nums) == 3:
            return sum(nums)
        value = sys.maxsize * 2 + 1
        answer = sys.maxsize * 2 + 1

        for start in range(0, len(nums) - 2):
            mid = start + 1
            end = len(nums) - 1

            while mid < end:
                current_sum = nums[start] + nums[mid] + nums[end]

                if current_sum == target:
                    return target

                if value > abs(target - current_sum):
                    value = abs(target - current_sum)
                    answer = current_sum

                if current_sum > target:
                    end -= 1
                else:
                    mid += 1

        return answer


if __name__ == '__main__':
    s = Solution()
    result = s.threeSumClosest([-1, 2, 1, -4], 1)

    print(result)
