print("Enter the size of string list:")
n = int(input())

print(f"Enter {n} strings (one per line):")
stringList = []
for i in range(n):
    stringList.append(input().strip())

print("Enter the number of queries:")
q = int(input())

print(f"Enter {q} query strings (one per line):")
queries = []
for i in range(q):
    queries.append(input().strip())

print("\nResults:")
# Process and output results
for i, query in enumerate(queries):
    count = stringList.count(query)
    print(f"Query '{query}': {count}")

print("\nAnswer array:")
results = []
for query in queries:
    count = stringList.count(query)
    results.append(count)
print(results)
