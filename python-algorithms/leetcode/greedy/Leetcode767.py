import heapq


class Solution:
    def reorganizeString(self, s: str) -> str:
        pair = dict()
        heap = []
        result = ""
        for i in range(len(s)):
            if s[i] in pair.keys():
                pair[s[i]] += 1
            else:
                pair[s[i]] = 1

        for key in pair.keys():
            heapq.heappush(heap, (-pair[key], key))

        while len(heap) != 0:
            if len(heap) > 1:
                first = heapq.heappop(heap)
                second = heapq.heappop(heap)
                result += first[1] + second[1]

                if first[0] < -1:
                    heapq.heappush(heap, (first[0] + 1, first[1]))
                if second[0] < -1:
                    heapq.heappush(heap, (second[0] + 1, second[1]))
            else:
                heappop = heapq.heappop(heap)
                if heappop[0] < -1:
                    return ""

                if len(result) > 0 and result[len(result) - 1] == heappop[1]:
                    return ""
                result += heappop[1]

        return result


if __name__ == '__main__':
    s = Solution()
    value = s.reorganizeString("aab")
    print(value)
