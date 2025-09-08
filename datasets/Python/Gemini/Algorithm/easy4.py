import sys

def bigSorting(unsorted):
    # Custom comparison function based on length then lexicographical order
    # Python's sorted() with a key that returns a tuple (length, string)
    # will first sort by length, then by the string value itself.
    return sorted(unsorted, key=lambda s: (len(s), s))

if __name__ == '__main__':
    # For faster input in competitive programming
    n = int(sys.stdin.readline().strip())

    unsorted = []
    for _ in range(n):
        unsorted_item = sys.stdin.readline().strip()
        unsorted.append(unsorted_item)

    # Manual Input (for interactive testing):
    # print("Enter the number of strings (n):")
    # n = int(input().strip())
    # unsorted = []
    # for i in range(n):
    #     print(f"Enter string {i+1}:")
    #     unsorted_item = input().strip()
    #     unsorted.append(unsorted_item)


    result = bigSorting(unsorted)

    for item in result:
        print(item)