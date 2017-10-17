#!/bin/python3
import sys

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/handshake/problem
import math

num_cases = int(input().strip())
for _ in range(num_cases):
    num_people = int(input().strip())
    if num_people in [0, 1]:
        print(0)
    else:
        # n choose r formula is:
        # n! / r! * (n-r)!
        output = int(math.factorial(num_people) /
            (2 * math.factorial(num_people - 2)))
        print(output)
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/lowest-triangle/problem
import math

def lowestTriangle(base, area):
    # area = (base * height) / 2
    # we know area, base, so just solve for height
    height = (2 * area) / base
    return math.ceil(height)

base, area = input().strip().split(' ')
base, area = [int(base), int(area)]
height = lowestTriangle(base, area)
print(height)
# ------------------------------------------------------------------------------