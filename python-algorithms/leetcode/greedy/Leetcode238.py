from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        ans = []
        left_product = [1] * len(nums)
        right_product = [1] * len(nums)

        for i in range(1, len(nums)):
            left_product[i] = nums[i - 1] * left_product[i - 1]
            right_product[len(nums) - i - 1] = right_product[len(nums) - i] * nums[len(nums) - i]

        for i in range(len(nums)):
            ans.append(left_product[i] * right_product[i])
        return ans

if __name__ == '__main__':
    s = Solution()
    print(s.productExceptSelf([1, 2, 3, 4]))