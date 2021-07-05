from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()

        for i in range(len(nums) - 2):
            a = nums[i]
            start, end = i + 1, len(nums) - 1
            while start < end:
                b, c = nums[start], nums[end]
                triple = a + b + c
                if triple == 0:
                    if [a, b, c] not in ans:
                        ans.append([a, b, c])
                    start += 1
                    end -= 1
                elif triple > 0:
                    end -= 1
                else:
                    start += 1
        return ans



if __name__ == '__main__':
    s = Solution()
    three_sum = s.threeSum([-1, 0, 1, 2, -1, -4])
    print(three_sum)
