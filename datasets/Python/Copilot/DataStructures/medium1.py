def matchingStrings(stringList, queries):
    return [stringList.count(query) for query in queries]

# Manual input
n = int(input("Enter number of strings in stringList: "))
stringList = []
print("Enter the strings:")
for _ in range(n):
    stringList.append(input().strip())

q = int(input("Enter number of queries: "))
queries = []
print("Enter the queries:")
for _ in range(q):
    queries.append(input().strip())

# Results
results = matchingStrings(stringList, queries)
print("Query results:")
for res in results:
    print(res)
