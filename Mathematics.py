#!/bin/python3

# https://www.hackerrank.com/challenges/handshake/problem
import math
import sys

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
