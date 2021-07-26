from typing import List


class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        answer = 1
        points.sort(key=lambda a: a[1])
        curr = points[0]

        for point in points:
            if curr[1] < point[0]:
                curr = point
                answer += 1

        return answer


if __name__ == '__main__':
    s = Solution()
    result = s.findMinArrowShots([[10, 16], [2, 8], [1, 6], [7, 12]])
    print(result)
