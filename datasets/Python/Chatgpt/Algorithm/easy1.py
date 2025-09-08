def alternate(s):
    unique_chars = list(set(s))
    max_length = 0

    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            ch1 = unique_chars[i]
            ch2 = unique_chars[j]
            filtered = [c for c in s if c == ch1 or c == ch2]

            if all(filtered[k] != filtered[k+1] for k in range(len(filtered)-1)):
                max_length = max(max_length, len(filtered))
    return max_length

# Manual input
n = int(input("Enter string length: "))
s = input("Enter the string: ").strip()
print("Longest alternating string length:", alternate(s))