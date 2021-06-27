from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            if token is "*":
                a = int(stack.pop())
                b = int(stack.pop())
                stack.append(b * a)
            elif token is "/":
                a = int(stack.pop())
                b = int(stack.pop())
                stack.append(b / a)
            elif token is "+":
                a = int(stack.pop())
                b = int(stack.pop())
                stack.append(a + b)
            elif token is "-":
                a = int(stack.pop())
                b = int(stack.pop())
                stack.append(b - a)
            else:
                stack.append(token)
        return stack[0]

if __name__ == '__main__':
    s = Solution()
    ans = s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])
    print(ans)

