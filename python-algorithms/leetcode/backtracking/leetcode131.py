from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def dfs(rest: str):
            if not rest:
                ans.append(current[:])

            for end in range(1, len(rest) + 1):

                if rest[:end] == rest[end - 1::-1]:
                    current.append(rest[:end])
                    dfs(rest[end:])
                    current.pop()

        ans = []
        current = []
        dfs(s)
        return ans


if __name__ == '__main__':
    print(int(5 % 2))
    s = Solution()
    partition = s.partition("aab")

    print(partition)
