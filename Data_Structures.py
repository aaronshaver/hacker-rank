#!/bin/python3
import sys

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/sparse-arrays/problem
num_strings = int(input())

string_counts = {}
for _ in range(num_strings):
    key = input()
    if key in string_counts:
        string_counts[key] += 1
    else:
        string_counts[key] = 1

queries = []
num_queries = int(input())
for _ in range(num_queries):
    queries.append(input())

for query_string in queries:
    if query_string in string_counts:
        print(string_counts[query_string])
    else:
        print('0')
# ------------------------------------------------------------------------------

# ------------------------------------------------------------------------------
# https://www.hackerrank.com/challenges/array-left-rotation/problem

def leftRotation(a, d):
    if len(a) == d:
        return a
    else:
        return a[d:] + a[:d]

if __name__ == "__main__":
    n, d = input().strip().split(' ')
    n, d = [int(n), int(d)]
    a = list(map(int, input().strip().split(' ')))
    result = leftRotation(a, d)
    print (" ".join(map(str, result)))
# ------------------------------------------------------------------------------