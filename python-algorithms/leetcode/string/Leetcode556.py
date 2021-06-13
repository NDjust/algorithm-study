from itertools import permutations


class Solution:
    def nextGreaterElement(self, n: int) -> int:
        # 32-bit integer limit : 2,147,483,647
        value = [digit for digit in str(n)]
        result = 2_147_483_647
        per = list(permutations(value, len(str(n))))
        for p in per:
            next_value = int("".join(p))
            if next_value > n:
                result = min(next_value, result)
        return -1 if result is 2_147_483_647 else result

    def betterSolution(self, n: int) -> int:

        # Step - 1
        nums = list(map(int, str(n)))

        # Step - 2
        idx = len(nums) - 2
        while idx >= 0 and nums[idx] >= nums[idx + 1]:
            idx -= 1
        if idx == -1:
            return -1

        # Step - 3
        idx2 = len(nums) - 1
        while nums[idx2] <= nums[idx]:
            idx2 -= 1

        # Step - 4
        nums[idx], nums[idx2] = nums[idx2], nums[idx]

        # Step - 5
        nums[idx + 1:] = reversed(nums[idx + 1:])

        # Step - 6
        res = ''
        for n in nums:
            res += str(n)
        res = int(res)

        # Step - 7
        return res if res <= 2 ** 31 - 1 else -1
if __name__ == '__main__':
    s = Solution()
    result = s.nextGreaterElement(21)
    print(result)
