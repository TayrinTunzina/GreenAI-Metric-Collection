# Manual Input
N = int(input("Enter number of elements: "))
A = list(map(int, input("Enter the elements: ").split()))

def max_si(arr):
    n = len(arr)
    max_si_val = 0
    for i in range(n - 1):
        m1, m2 = arr[i], arr[i+1]
        if m1 > m2:
            m1, m2 = m2, m1
        si = ((m1 & m2) ^ (m1 | m2)) & (m1 ^ m2)
        max_si_val = max(max_si_val, si)
    return max_si_val

print("Maximum Si:", max_si(A))