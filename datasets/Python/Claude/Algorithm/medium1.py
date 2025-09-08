def extraLongFactorials(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    print(result)

# Taking input from user
n = int(input("Enter a number to calculate its factorial: "))
extraLongFactorials(n)