#!/bin/python3
import sys

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
