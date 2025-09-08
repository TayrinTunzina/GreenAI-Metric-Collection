def max_si():
    N = int(input("Enter the number of elements in the array: "))
    A = list(map(int, input("Enter the elements of the array separated by space: ").split()))

    max_si_value = 0

    for L in range(N):
        for R in range(L + 1, N):
            subarray = A[L:R+1]
            subarray_sorted = sorted(subarray)
            M1 = subarray_sorted[0]
            M2 = subarray_sorted[1]
            Si = (((M1 & M2) ^ (M1 | M2)) & (M1 ^ M2))
            if Si > max_si_value:
                max_si_value = Si

    print("The maximum possible value of Si is:", max_si_value)

max_si()