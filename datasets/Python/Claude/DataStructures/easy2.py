def hourglassSum(arr):
    max_sum = -63  # minimum possible sum (-9 * 7)
    
    # iterate through the 2D array
    for i in range(4):
        for j in range(4):
            # sum of top 3 elements
            top = sum(arr[i][j:j+3])
            
            # middle element
            middle = arr[i+1][j+1]
            
            # sum of bottom 3 elements
            bottom = sum(arr[i+2][j:j+3])
            
            # total sum of hourglass
            hourglass = top + middle + bottom
            
            # update maximum sum
            max_sum = max(max_sum, hourglass)
            
    return max_sum

# Input function
def get_input():
    arr = []
    print("Enter 6 rows of 6 space-separated numbers:")
    for _ in range(6):
        row = list(map(int, input().split()))
        arr.append(row)
    return arr

# Main program
if __name__ == "__main__":
    arr = get_input()
    result = hourglassSum(arr)
    print(f"Maximum hourglass sum is: {result}")