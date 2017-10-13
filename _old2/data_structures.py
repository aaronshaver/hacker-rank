#!/bin/python3
import sys


# https://www.hackerrank.com/challenges/arrays-ds
# ------------------------------------------------------------
n = int(input().strip())
arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]

output = ''
for item in list(reversed(arr)):
    output += str(item) + ' '

print(output)


# https://www.hackerrank.com/challenges/2d-array
# ------------------------------------------------------------
arr = []
for arr_i in range(6):
   arr_t = [int(arr_temp) for arr_temp in input().strip().split(' ')]
   arr.append(arr_t)

max_sum = -sys.maxsize - 1

for i in range(4):
    for j in range(4):
        top = arr[i][0 + j] + arr[i][1 + j] + arr[i][2 + j]
        middle = arr[i + 1][1 + j]
        bottom = arr[i + 2][0 + j] + arr[i + 2][1 + j] + arr[i + 2][2 + j]
        hour_glass = top + middle + bottom
        if hour_glass > max_sum:
            max_sum = hour_glass

print(max_sum)
