def similarity(s):
    n = len(s)
    total = n  # Similarity with itself is length of string
    
    # Compare with each suffix
    for i in range(1, n):
        # Count matching prefix characters
        j = 0
        while j + i < n and s[j] == s[j + i]:
            j += 1
        total += j
        
    return total

def main():
    t = int(input())
    for _ in range(t):
        s = input().strip()
        print(similarity(s))

if __name__ == "__main__":
    main()