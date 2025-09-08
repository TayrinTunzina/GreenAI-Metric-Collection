def matchingStrings(stringList, queries):
    result = []
    count_dict = {}
    for s in stringList:
        if s in count_dict:
            count_dict[s] += 1
        else:
            count_dict[s] = 1
    for q in queries:
        result.append(count_dict.get(q, 0))
    return result

if __name__ == '__main__':
    # Taking input manually from the user
    n = int(input("Enter the number of strings in the list: "))
    stringList = []
    for i in range(n):
        s = input(f"Enter string {i+1}: ")
        stringList.append(s)
    q = int(input("Enter the number of queries: "))
    queries = []
    for i in range(q):
        query = input(f"Enter query {i+1}: ")
        queries.append(query)
    results = matchingStrings(stringList, queries)
    print("Results:", results)
