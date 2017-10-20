#!/bin/python3
import sys

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/kangaroo/problem
def jump(kanga1, v1, kanga2, v2):
    """ if kangaroo1 jumps past kangaroo2, kanga 2 will never catch up
        there's probably a better way to do this :-(
    """
    for _ in range(20):
        kanga1 += v1
        kanga2 += v2
        difference = kanga2 - kanga1
        if difference == 0:
            return True
        if difference < 0:
            return False
    return True

def kangaroo(x1, v1, x2, v2):
    if (x1 <= x2) and (v1 < v2):
        return 'NO'
    if (x1 == x2) and (v1 == v2):
        return 'YES'
    if (x1 != x2) and (v1 == v2):
        return 'NO'
    if not jump(x1, v1, x2, v2):
        return 'NO'
    else:
        return 'YES'

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
