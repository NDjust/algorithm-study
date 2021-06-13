from typing import List


class Solution:
    move = [[0, 1], [1, 0], [-1, 0], [0, -1]]

    def exist(self, board: List[List[str]], word: str) -> bool:
        start = word[0]
        start_loc = []

        result = False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == start:
                    start_loc.append([i, j])

        for loc in start_loc:
            visited = [[False for _ in range(board[0])] for _ in range(len(board))]
            result = self.back_tracking(visited, loc, board, word)

            if result:
                return result

        return result

    def back_tracking(self, cnt: int, i: int, j: int, word: str, board: List[List[str]]) -> bool:
        if cnt == len(word):
            return True

        if i < 0 or j < 0 or i >= len(word) or j >= len(word) or word[cnt] != board[i][j]:
            return False

        temp = board[i][j]
        board[i][j] = ""

        for m in self.move:
            found = self.back_tracking(cnt + 1, i + m[0], j + m[1], word, board)

        board[i][j] = temp

        return found