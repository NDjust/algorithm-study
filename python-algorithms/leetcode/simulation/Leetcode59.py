from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        result = [[0 for _ in range(n)] for _ in range(n)]
        cnt = 1
        i, j = 0, 0
        LEFT, RIGHT = 'left', 'right'
        BOTTOM, TOP = 'bottom', 'top'
        direction = RIGHT
        result[i][j] = cnt
        while cnt < (n * n):
            if direction == LEFT:
                if j - 1 < 0 or result[i][j - 1] != 0:
                    direction = TOP
                else:
                    j -= 1
                    cnt += 1
                    result[i][j] = cnt
            elif direction == RIGHT:
                if j + 1 > n - 1 or result[i][j + 1] != 0:
                    direction = BOTTOM
                else:
                    j += 1
                    cnt += 1
                    result[i][j] = cnt
            elif direction == BOTTOM:
                if i + 1 > n - 1 or result[i + 1][j] != 0:
                    direction = LEFT
                else:
                    i += 1
                    cnt += 1
                    result[i][j] = cnt
            elif direction == TOP:
                if i - 1 < 0 or result[i - 1][j] != 0:
                    direction = RIGHT
                else:
                    i -= 1
                    cnt += 1
                    result[i][j] = cnt

        return result

if __name__ == '__main__':
    s = Solution()
    matrix = s.generateMatrix(4)
    print(matrix)
