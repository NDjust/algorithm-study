import random


class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.items = set()
        self.val_list = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.items:
            return False

        self.items.add(val)
        self.val_list.append(val)
        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.items:
            return False
        self.items.remove(val)
        self.val_list.remove(val)

        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """

        return self.val_list[random.randrange(0, len(self.val_list))]