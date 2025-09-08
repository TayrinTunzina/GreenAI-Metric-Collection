n, m = map(int, input().split())
MOD = 10**9 + 7

N = (1 << m) - 1

if n > N:
    print(0)
else:
    result = 1
    for i in range(n):
        result = (result * (N - i)) % MOD
    print(result)