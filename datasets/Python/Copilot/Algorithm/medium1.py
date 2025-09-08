def extraLongFactorials(n):
    factorial = 1
    for i in range(1, n + 1):
        factorial *= i
    print(factorial)

# Taking input from the user
n = int(input("Enter an integer n: "))
extraLongFactorials(n)
