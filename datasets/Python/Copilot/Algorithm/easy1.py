def alternate(s):
    unique_chars = list(set(s))
    max_length = 0

    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            filtered = [c for c in s if c == unique_chars[i] or c == unique_chars[j]]
            if all(filtered[k] != filtered[k + 1] for k in range(len(filtered) - 1)):
                max_length = max(max_length, len(filtered))
    return max_length

# Manual input
n = int(input("Enter length of string: "))
s = input("Enter the string: ")
print("Longest length:", alternate(s))