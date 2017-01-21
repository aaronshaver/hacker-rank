#!/bin/python3

import sys

n = int(input().strip())
a = []
for a_i in range(n):
    a_t = [int(a_temp) for a_temp in input().strip().split(' ')]
    a.append(a_t)

sum_left = sum_right = 0

for column, line in enumerate(a):
    sum_left += line[column]
    sum_right += line[(n - 1) - column]

print(abs(sum_left - sum_right))
