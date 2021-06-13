class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}

    def get(self, key: int) -> int:
        if key in self.cache:
            self.put(key, self.cache[key])
        return self.cache.get(key, -1)

    def put(self, key: int, value: int) -> None:
        self.cache.pop(key, None)
        self.cache[key] = value
        if len(self.cache) > self.capacity:
            del self.cache[next(iter(self.cache))]



if __name__ == '__main__':
    cache = LRUCache(1)
    cache.put(2, 1)
    print(cache.cache)
    print(cache.get(2))
    cache.put(3, 2)
    print(cache.cache)
    print(cache.get(2))
    print(cache.get(3))
    a = dict()
    a[1] = 2
    a[2] = 3
    a[3] = 4

