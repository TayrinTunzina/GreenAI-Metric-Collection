def extraLongFactorials(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    print(result)

# Taking input manually
n = int(input("Enter an integer: "))
extraLongFactorials(n)
