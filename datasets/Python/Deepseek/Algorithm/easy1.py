def alternate(s):
    unique_chars = set(s)
    max_len = 0
    
    for first in unique_chars:
        for second in unique_chars:
            if first == second:
                continue
            filtered = [c for c in s if c == first or c == second]
            valid = True
            for i in range(len(filtered) - 1):
                if filtered[i] == filtered[i + 1]:
                    valid = False
                    break
            if valid and len(filtered) > max_len:
                max_len = len(filtered)
    
    return max_len if max_len >= 2 else 0

# Read input
n = int(input().strip())
s = input().strip()

# Compute and print result
print(alternate(s))