#!/bin/python3

import sys

a0, a1, a2 = input().strip().split(' ')
a0, a1, a2 = [int(a0), int(a1), int(a2)]
b0, b1, b2 = input().strip().split(' ')
b0, b1, b2 = [int(b0), int(b1), int(b2)]

allison_score = 0
bob_score = 0


def calculate_comparison(score1, score2):
    if score1 > score2:
        return 1
    elif score2 > score1:
        return -1
    else:
        return 0


result = calculate_comparison(a0, b0)
if result == 1:
    allison_score += 1
elif result == -1:
    bob_score += 1

result = calculate_comparison(a1, b1)
if result == 1:
    allison_score += 1
elif result == -1:
    bob_score += 1

result = calculate_comparison(a2, b2)
if result == 1:
    allison_score += 1
elif result == -1:
    bob_score += 1

print(allison_score, bob_score)