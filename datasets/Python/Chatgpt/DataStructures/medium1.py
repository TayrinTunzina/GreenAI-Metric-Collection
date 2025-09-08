def matchingStrings(stringList, queries):
    result = []
    for query in queries:
        count = 0
        for string in stringList:
            if string == query:
                count += 1
        result.append(count)
    return result

# Take all inputs manually
n = int(input("Enter number of input strings:\n"))
stringList = []
print("Enter the input strings one by one:")
for _ in range(n):
    stringList.append(input().strip())

q = int(input("Enter number of queries:\n"))
queries = []
print("Enter the queries one by one:")
for _ in range(q):
    queries.append(input().strip())

# Call function and print results
results = matchingStrings(stringList, queries)
print("Query Results:")
for res in results:
    print(res)
