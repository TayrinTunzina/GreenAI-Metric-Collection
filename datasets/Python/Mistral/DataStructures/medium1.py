def matching_strings(string_list, queries):
    result = []
    for query in queries:
        count = string_list.count(query)
        result.append(count)
    return result

# Reading input
n = int(input("Enter the size of stringList: "))
string_list = [input().strip() for _ in range(n)]
q = int(input("Enter the size of queries: "))
queries = [input().strip() for _ in range(q)]

# Getting the result
result = matching_strings(string_list, queries)
print(result)
