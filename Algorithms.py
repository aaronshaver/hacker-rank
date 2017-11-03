#!/bin/python3
import sys

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/the-birthday-bar/problem
def solve(num_squares, squares, day, month):
    if len(squares) < month:  # can't possibly have ways/solutions
        return 0

    window_lower = 0
    window_upper = month

    counter = 0
    for i in range(1, num_squares + 1):
        if sum(squares[window_lower:window_upper]) == day:
            counter += 1

        window_lower += 1
        window_upper += 1
    return counter

n = int(input().strip())
s = list(map(int, input().strip().split(' ')))
d, m = input().strip().split(' ')
d, m = [int(d), int(m)]
result = solve(n, s, d, m)
print(result)
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/between-two-sets/problem
def getTotalX(a, b):
    total = 0
    smallest = min(a + b)
    largest = max(a + b)
    candidates = [x for x in range(smallest, largest + 1)]

    debug_candidates = []
    for candidate in candidates:
        a_flag = True
        b_flag = True

        for a_val in a:
            if not (candidate % a_val == 0):
                a_flag = False
                break
        if not a_flag:
            continue

        for b_val in b:
            if not (b_val % candidate == 0):
                b_flag = False
                break
        if not b_flag:
            continue

        if a_flag and b_flag:
            total += 1

    return total

if __name__ == "__main__":
    n, m = input().strip().split(' ')
    n, m = [int(n), int(m)]
    a = list(map(int, input().strip().split(' ')))
    b = list(map(int, input().strip().split(' ')))
    total = getTotalX(a, b)
    print(total)
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
def getRecord(games):
    high_exceeded = 0
    low_exceeded = 0
    highest = games[0]  # first game
    lowest = games[0]

    for game in games[1:]:  # skip first as it's used for initial high, low
        if game < lowest:
            low_exceeded += 1
            lowest = game
        elif game > highest:
            high_exceeded += 1
            highest = game
    return [high_exceeded, low_exceeded]

n = int(input().strip())
s = list(map(int, input().strip().split(' ')))
result = getRecord(s)
print (" ".join(map(str, result)))
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/kangaroo/problem
def kangaroo(x1, v1, x2, v2):
    # if position different, velocities are the same, then will never meet
    if (x1 != x2) and (v1 == v2):
        return 'NO'

    # if kanga1 is same or left of kanga2 and slower, will never meet
    if (x1 <= x2) and (v1 < v2):
        return 'NO'

    # if difference between velocities evenly divides into difference in initial
    # position, kangas will meet
    #
    # This is explained well in the discussion on HackerRank by nasimoyz:
    # 'If the rate at which the distance is closing can add up to the original
    # distance between them (is a factor of the original distance), you know
    # they'll eventually meet.'
    if (x1 - x2) % (v2 - v1) == 0:
        return 'YES'

    # all other cases where they won't meet
    return 'NO'

x1, v1, x2, v2 = input().strip().split(' ')
x1, v1, x2, v2 = [int(x1), int(v1), int(x2), int(v2)]
result = kangaroo(x1, v1, x2, v2)
print(result)
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/apple-and-orange/problem
s, t = input().strip().split(' ')
house_left, house_right = [int(s), int(t)]

a, b = input().strip().split(' ')
apple_tree_loc, orange_tree_loc = [int(a), int(b)]

m, n = input().strip().split(' ')
fruit_counts = [int(m), int(n)]

apple_locations = [int(apple_temp) for apple_temp in
                   input().strip().split(' ')]
orange_locations = [int(orange_temp) for orange_temp in
                    input().strip().split(' ')]

def is_on_house(tree_location, fruit_distance, house_left, house_right):
    return ((tree_location + fruit_distance) >= house_left) and \
        ((tree_location + fruit_distance) <= house_right)

apple_count, orange_count = 0, 0

for fruit_distance in apple_locations:
    if is_on_house(apple_tree_loc, fruit_distance, house_left, house_right):
        apple_count += 1

for fruit_distance in orange_locations:
    if is_on_house(orange_tree_loc, fruit_distance, house_left, house_right):
        orange_count += 1

print(apple_count)
print(orange_count)
# ------------------------------------------------------------------------------
