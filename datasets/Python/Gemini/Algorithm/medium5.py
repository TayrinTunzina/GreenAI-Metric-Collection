def solve():
    n = int(input())
    xor_sum = 0
    for _ in range(n):
        m, k = map(int, input().split())
        
        # Calculate Grundy number for the tree
        grundy_num = 0
        if m % 2 == 1: # m is odd
            grundy_num = 1
        else: # m is even
            grundy_num = 2
            
        xor_sum ^= grundy_num
        
    if xor_sum != 0:
        print("BOB")
    else:
        print("BEN")

g = int(input())
for _ in range(g):
    solve()