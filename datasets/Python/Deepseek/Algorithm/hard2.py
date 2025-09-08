def chiefHopper(arr):
    left = 0
    right = max(arr)
    answer = right
    
    while left <= right:
        mid = (left + right) // 2
        current_energy = mid
        possible = True
        for height in arr:
            if current_energy > height:
                current_energy += (current_energy - height)
            else:
                current_energy -= (height - current_energy)
            if current_energy < 0:
                possible = False
                break
        if possible:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1
    return answer

n = int(input())
arr = list(map(int, input().split()))
print(chiefHopper(arr))