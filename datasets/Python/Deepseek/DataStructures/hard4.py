def max_xor_two_numbers(arr):
    max_xor = 0
    root = {}
    
    for num in arr:
        node = root
        xor_node = root
        current_xor = 0
        
        for i in range(31, -1, -1):
            bit = (num >> i) & 1
            # Insert the number into the trie
            if bit not in node:
                node[bit] = {}
            node = node[bit]
            
            # Compute current_xor by choosing the opposite bit if available
            toggled_bit = 1 - bit
            if toggled_bit in xor_node:
                current_xor += (1 << i)
                xor_node = xor_node[toggled_bit]
            else:
                xor_node = xor_node[bit]
        
        if current_xor > max_xor:
            max_xor = current_xor
    
    return max_xor

def main():
    n = int(input("Enter the number of elements: "))
    arr = list(map(int, input("Enter the elements separated by space: ").split()))
    print("Maximum XOR:", max_xor_two_numbers(arr))

if __name__ == "__main__":
    main()