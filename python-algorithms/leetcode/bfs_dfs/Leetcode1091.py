from typing import List


class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1

        direction = [[0, 1], [0, -1],  # 오, 왼
                     [1, 0], [-1, 0],  # 아래, 위
                     [1, 1], [-1, -1],  # 오른쪽 아래, 왼쪽 위
                     [1, -1], [-1, 1]  # 아래 왼쪽, 오른쪽 위
                     ]

        # init
        path = [[0, 0, 1]]
        visited = [[False for _ in range(len(grid))] for _ in range(len(grid))]
        visited[0][0] = True
        is_clear = False
        result = len(grid) * len(grid)

        while len(path) != 0:
            curr_loc = path.pop(0)

            if curr_loc[0] == len(grid) - 1 and curr_loc[1] == len(grid) - 1:
                result = curr_loc[2] if curr_loc[2] < result else result
                is_clear = True
            for d in direction:
                dx = curr_loc[0] + d[0]
                dy = curr_loc[1] + d[1]

                if dx < 0 or dy < 0 or dx >= len(grid) or dy >= len(grid) or visited[dx][dy]:
                    continue

                if grid[dx][dy] == 0:
                    visited[dx][dy] = True
                    path.append([dx, dy, curr_loc[2] + 1])

        return result if is_clear else -1


if __name__ == '__main__':
    s = Solution()
    answer = s.shortestPathBinaryMatrix([[0, 0, 0], [1, 1, 0], [1, 1, 0]])
    print(answer)
