from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        """
        [1, 2, 3, 4]
        product except self
        - (왼쪽의 모든 숫자 곱) * (오른쪽의 모든 숫자 곱)
        - nums[:i - 1] * nums[i + 1 :]

        self 제외 왼쪽  = nums[i - 1] * (0 ~ i - 1까지의 곱)
        self 제외 오른쪽  = nums[len(nums)- i - 1] * (len(nums) - 1 ~ i + 1 까지의 곱)
        """
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