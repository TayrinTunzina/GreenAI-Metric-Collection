def calculate_similarity_sum(s):
    n = len(s)
    total_similarity = 0
    for i in range(n):
        suffix = s[i:]
        similarity = 0
        for j in range(len(suffix)):
            if s[j] == suffix[j]:
                similarity += 1
            else:
                break
        total_similarity += similarity
    return total_similarity

def main():
    t = int(input("Enter the number of test cases: "))
    results = []
    for _ in range(t):
        s = input("Enter the string: ")
        results.append(calculate_similarity_sum(s))
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
