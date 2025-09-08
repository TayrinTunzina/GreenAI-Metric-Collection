def calculate_z(s):
    n = len(s)
    z = [0] * n
    l, r, k = 0, 0, 0
    for i in range(1, n):
        if i > r:
            l, r = i, i
            while r < n and s[r] == s[r - l]:
                r += 1
            z[i] = r - l
            r -= 1
        else:
            k = i - l
            if z[k] < r - i + 1:
                z[i] = z[k]
            else:
                l = i
                while r < n and s[r] == s[r - l]:
                    r += 1
                z[i] = r - l
                r -= 1
    z[0] = n
    return z

def similarity_sum(s):
    z = calculate_z(s)
    return sum(z)

if __name__ == "__main__":
    t = int(input("Enter the number of test cases: "))
    for _ in range(t):
        s = input()
        print(similarity_sum(s))
