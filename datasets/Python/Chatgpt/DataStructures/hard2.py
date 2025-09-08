import sys

def find_starting_pump(n, pumps):
    total_surplus = 0
    current_surplus = 0
    start_index = 0

    for i in range(n):
        petrol, distance = pumps[i]
        surplus = petrol - distance
        total_surplus += surplus
        current_surplus += surplus

        if current_surplus < 0:
            start_index = i + 1
            current_surplus = 0

    return start_index if total_surplus >= 0 else -1

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())
    pumps = [tuple(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]
    print(find_starting_pump(n, pumps))
