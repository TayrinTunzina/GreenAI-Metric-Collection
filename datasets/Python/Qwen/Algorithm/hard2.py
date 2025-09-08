import math

def chiefHopper(arr):
    required = 0
    for height in reversed(arr):
        required = math.ceil((required + height) / 2)
    return required

# Manual Input
n = int(input())
arr = list(map(int, input().split()))

print(chiefHopper(arr))