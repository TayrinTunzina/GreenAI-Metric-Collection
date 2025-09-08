# Function to count occurrences of queries in stringList
def matchingStrings(stringList, queries):
    result = []
    # Create a dictionary to store the frequency of each string in stringList
    frequency = {}
    for string in stringList:
        if string in frequency:
            frequency[string] += 1
        else:
            frequency[string] = 1
    
    # For each query, check its frequency in the dictionary
    for query in queries:
        if query in frequency:
            result.append(frequency[query])
        else:
            result.append(0)
    
    return result

# Main function to take inputs manually
if __name__ == "__main__":
    # Input size of stringList
    n = int(input("Enter the size of stringList: "))
    stringList = []
    print("Enter the strings in stringList:")
    for _ in range(n):
        stringList.append(input())
    
    # Input size of queries
    q = int(input("Enter the size of queries: "))
    queries = []
    print("Enter the query strings:")
    for _ in range(q):
        queries.append(input())
    
    # Call the function and print the result
    result = matchingStrings(stringList, queries)
    print("Results:", result)
