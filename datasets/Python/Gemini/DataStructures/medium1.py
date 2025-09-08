def matchingStrings(stringList, queries):
    """
    Counts occurrences of each query string in a list of input strings.

    Args:
        stringList: A list of strings to search within.
        queries: A list of query strings to count.

    Returns:
        A list of integers, where each element is the count of the
        corresponding query string in stringList.
    """
    results = []
    for query in queries:
        count = 0
        for s in stringList:
            if s == query:
                count += 1
        results.append(count)
    return results

if __name__ == "__main__":
    # --- Input section ---
    print("Enter the number of strings in stringList (n):")
    n = int(input())

    print(f"Enter {n} strings for stringList, one per line:")
    stringList = []
    for _ in range(n):
        stringList.append(input())

    print("\nEnter the number of query strings (q):")
    q = int(input())

    print(f"Enter {q} query strings, one per line:")
    queries = []
    for _ in range(q):
        queries.append(input())

    # --- Processing and Output section ---
    print("\n--- Results ---")
    results = matchingStrings(stringList, queries)
    for res in results:
        print(res)
