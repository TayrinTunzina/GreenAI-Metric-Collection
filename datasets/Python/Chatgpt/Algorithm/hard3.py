def z_function(s):
    """
    Computes the Z-array for string s.
    Z[i] is the length of the longest substring starting from i that matches the prefix of s.
    """
    n = len(s)
    Z = [0] * n
    Z[0] = n  # The whole string is the longest prefix of itself
    l, r, K = 0, 0, 0
    for i in range(1, n):
        if i > r:
            l, r = i, i
            while r < n and s[r] == s[r - l]:
                r += 1
            Z[i] = r - l
            r -= 1
        else:
            K = i - l
            if Z[K] < r - i + 1:
                Z[i] = Z[K]
            else:
                l = i
                while r < n and s[r] == s[r - l]:
                    r += 1
                Z[i] = r - l
                r -= 1
    return Z

def sum_of_similarities(s):
    Z = z_function(s)
    return sum(Z)

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        s = input().strip()
        print(sum_of_similarities(s))
