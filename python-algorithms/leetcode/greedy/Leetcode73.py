from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        visited = [[False for _ in range(len(matrix[0]))] for _ in range(len(matrix))]

        def replace(i, j, matrix):
            visited[i][j] = True

            for x in range(len(matrix)):
                if visited[x][j]:
                    continue
                matrix[x][j] = 0
                visited[x][j] = True
            for y in range(len(matrix[0])):
                if visited[i][y]:
                    continue
                matrix[i][y] = 0
                visited[i][y] = True

        zero_loc = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    zero_loc.append([i, j])

        for z in zero_loc:
            replace(z[0], z[1], matrix)

        return matrix


if __name__ == '__main__':
    s = Solution()
    result = s.setZeroes([[0,1,2,0],[3,4,5,2],[1,3,1,5]]
)
    for r in result:
        print(r)
