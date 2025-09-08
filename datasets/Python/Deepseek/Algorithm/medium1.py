def extraLongFactorials(n):
    factorial = 1
    for i in range(1, n + 1):
        factorial *= i
    print(factorial)

# Input
n = int(input("Enter an integer (1 <= n <= 100): "))
extraLongFactorials(n)