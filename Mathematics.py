#!/bin/python3
import sys

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/game-with-cells/problem
n,m = input().strip().split(' ')
n,m = [int(n),int(m)]

# set the "new grid" dimensions initially to the original grid dimensions
imaginary_n = n
imaginary_m = m

# EXPLANATION:
#
# if we have 2x2 grid, we have one 2x2 supply area
# if we have 2x3 grid, we have one 2x2 area, with a 1x2 LEFTOVER
# we have to act like we need two complete 2x2 coverage zones
#
# similarly if we have 4x4, we have four perfect 2x2 coverage zones
# BUT if we have 3x3, we have one perfect 2x2 zone, with overlapping edges on
# the right and bottom (if we start from the upper left)
# we have to act like we need enough drops for a 4x4 grid!
#
# SO if the dimensions are even, we can just count how many sets of four cells
# we need
# BUT if either the X or Y axis on our grid is odd, creating the overlapping
# "leaf" of a strip of one-wide cells, we need to imagine an "IMAGINARY grid" of
# cells that allow us to do perfect 2x2 zones throughout the grid

# if X axis is odd, extend the imaginary grid to make the shape even on X axis
if n % 2 != 0:
    imaginary_n = n + 1

# if Y axis is odd, extend the imaginary grid to make the shape even on Y axis
if m % 2 != 0:
    imaginary_m = m + 1

# output the total number of cells on the IMAGINARY grid divided by four cells
# at a time
print(int((imaginary_n * imaginary_m) / 4))
# ------------------------------------------------------------------------------

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