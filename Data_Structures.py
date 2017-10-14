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
