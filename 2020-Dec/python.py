

# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/halloween-sale/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the howManyGames function below.
def howManyGames(price, discount, minimum, wallet):
    if wallet < price:
        return 0  # edge case of initial price being too high
    
    games_purchased = 0
    
    while wallet >= price:
        wallet -= price
        games_purchased += 1
        
        price -= discount
        if price < minimum:
            price = minimum
    
    return games_purchased

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    pdms = input().split()

    p = int(pdms[0])

    d = int(pdms[1])

    m = int(pdms[2])

    s = int(pdms[3])

    answer = howManyGames(p, d, m, s)

    fptr.write(str(answer) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/camelcase/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the camelcase function below.
def camelcase(s):
    count = 0
    for c in s:
        if c.isupper():
            count += 1
    return count + 1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = camelcase(s)

    fptr.write(str(result) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/fair-rations/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the fairRations function below.
def fairRations(subjects):
    # odd number of odds leads to infinite loop of incrementing
    odds_count = 0
    for subject in subjects:
        if subject % 2 != 0:
            odds_count += 1
    if odds_count % 2 != 0:
        return 'NO'
    
    increments = 0
    for i in range(len(subjects)):
        if subjects[i] % 2 != 0:
            increments += 1
            
            if i + 1 < len(subjects):
                increments += 1
                subjects[i + 1] += 1
            elif i - 1 > -1:
                increments += 1
                subjects[i - 1] += 1
    
    return increments


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    N = int(input())

    B = list(map(int, input().rstrip().split()))

    result = fairRations(B)

    fptr.write(str(result) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/minimum-distances/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumDistances function below.
def minimumDistances(a):
    min_distance = -1 
    distances = {}
    for i, val in enumerate(a):
        if val not in distances:
            distances[val] = [i]
        else:
            distances[val] = distances[val] + [i]
    
    for key in distances.keys():
        if len(distances[key]) >= 2:
            for i in range(len(distances[key]) - 1):
                distance = abs(distances[key][i] - distances[key][i + 1])
                if distance < min_distance or min_distance == -1:
                    min_distance = distance
    
    return min_distance

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    a = list(map(int, input().rstrip().split()))

    result = minimumDistances(a)

    fptr.write(str(result) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/beautiful-triplets/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the beautifulTriplets function below.
def beautifulTriplets(d, arr):
    
    # note: HackerRank didn't want me to optimize any further;
    # however, I had at least one idea of keeping track of i numbers
    # that weren't part of a successful triplet, and thus if you encounter
    # that number again as i, you could just skip it
    
    triplets = []
    for i in range(len(arr)):
        starting_num = arr[i]
        second_num_target = starting_num + d
        for j in range(i + 1, len(arr)):
            if arr[j] - arr[i] == d:
                for k in range(j + 1, len(arr)):
                    if arr[k] - arr[j] == d:
                        triplets.append([i,j,k])
                        break
                        
    return len(triplets)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nd = input().split()

    n = int(nd[0])

    d = int(nd[1])

    arr = list(map(int, input().rstrip().split()))

    result = beautifulTriplets(d, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/missing-numbers/problem 

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the missingNumbers function below.
def missingNumbers(arr, brr):
    missing_nums = {}
    
    # construct counts of all the numbers we have to account for
    for num in brr:
        if num not in missing_nums:
            missing_nums[num] = 1
        else:
            missing_nums[num] = missing_nums[num] + 1
    
    for num in arr:
        if missing_nums[num] == 1:
            missing_nums.pop(num, None)  # remove from dict
        else:
            missing_nums[num] = missing_nums[num] - 1  # decrement count
            
    return sorted(missing_nums.keys())
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    m = int(input())

    brr = list(map(int, input().rstrip().split()))

    result = missingNumbers(arr, brr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/kaprekar-numbers/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the kaprekarNumbers function below.
def kaprekarNumbers(p, q):
    output = ""
    for i in range(p, q + 1):
        digits_length = len(str(i))
        if digits_length == 1:
            if i == 1 or i == 9:
                output += str(i) + ' '
                continue
        else:
            square = i ** 2
            stringified_square = str(square)
            right = stringified_square[-digits_length:]
            left = stringified_square[:-digits_length]
            if int(left) + int(right) == i:
                output += str(i) + ' '
    if output:
        print(output)
    else:
        print("INVALID RANGE")

if __name__ == '__main__':
    p = int(input())

    q = int(input())

    kaprekarNumbers(p, q)
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/acm-icpc-team/problem

# note: obviously this is O(n^2) so it's not going to do well for large
# input arrays. Thninking about a more performant solution, the tricky
# bit is retaining the original indices of the unsorted list
# I was thinking a data structure like:
# {
#   2: [1,2],
#   3: [4],
#   4: [3]
# }
# where the key is the cost and the value is a list of original array positions
# Then you could iterate through the keys, get the reciprocal number
# (2 for 2 when total is 4), (maybe 1 for 3 when total is 4 and diff nums)
# So our key is 2, reciprocal is 2, we look to see if count of indices for key 2
# is > 1, bam done
# For the 1 and 3 example, if our first key is 1, reciprocal is 3, so simply get
# the value stored for key 3 (or if there is no such key, continue the for loop)
# I think this would be O(2n) -> O(n)

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the icecreamParlor function below.
def icecreamParlor(m, arr):
    indexes = []
    for i in range(len(arr)):
        reciprocal_num = m - arr[i] 
        for j in range(i + 1, len(arr)):
            if arr[i] + arr[j] == m:
                return [i+1, j+1]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input())

    for t_itr in range(t):
        m = int(input())

        n = int(input())

        arr = list(map(int, input().rstrip().split()))

        result = icecreamParlor(m, arr)

        fptr.write(' '.join(map(str, result)))
        fptr.write('\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/acm-icpc-team/problem

# GG EZ

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'taumBday' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER b
#  2. INTEGER w
#  3. INTEGER bc
#  4. INTEGER wc
#  5. INTEGER z
#

def taumBday(b, w, bc, wc, z):
    # base case; no conversion
    minimum_cost = (b * bc) + (w * wc)
    
    convert_b_to_w = ((bc + z) * w) + (bc * b)
    minimum_cost = convert_b_to_w if convert_b_to_w < minimum_cost  else minimum_cost
    
    convert_w_to_b = ((wc + z) * b) + (wc * w)
    minimum_cost = convert_w_to_b if convert_w_to_b < minimum_cost  else minimum_cost
    
    return minimum_cost

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        b = int(first_multiple_input[0])

        w = int(first_multiple_input[1])

        second_multiple_input = input().rstrip().split()

        bc = int(second_multiple_input[0])

        wc = int(second_multiple_input[1])

        z = int(second_multiple_input[2])

        result = taumBday(b, w, bc, wc, z)

        fptr.write(str(result) + '\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/acm-icpc-team/problem

# I had to look up some of this. It was a very fiddly problem that, unless solved
# in just such a certain way, would fail to perform well with large inputs
#
# I successfully created an algorithm that would solve smaller inputs, but had 
# to look up these combinations() and .count('1') tricks

#!/bin/python3

#!/bin/python3

import math
import os
import random
import re
import sys
from itertools import combinations

def acmTeam(topic):
    max_binary_dec = 0 
    total_teams = 0
    people_count = len(topic)
    
    pairs = combinations(topic, 2)
    for pair in pairs:
        current_bin_dec = bin(int(pair[0], 2) | int(pair[1], 2)).count('1')
        if max_binary_dec < current_bin_dec:
            max_binary_dec = current_bin_dec
            total_teams = 0
        if current_bin_dec == max_binary_dec:
            total_teams += 1
    
    return [max_binary_dec, total_teams]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nm = input().split()

    n = int(nm[0])

    m = int(nm[1])

    topic = []

    for _ in range(n):
        topic_item = input()
        topic.append(topic_item)

    result = acmTeam(topic)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
# ---------------------------------------------------------------------------


# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    jumps = 0
    i = 0
     
    while i < len(c) - 1:  # don't need to do anything if on last cloud
        if (i + 2) < len(c):
            if c[i + 2] == 0:
                i += 2  # do 2-space-jump
                jumps += 1
                continue
        jumps += 1
        i += 1
        
    return jumps

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    fptr.write(str(result) + '\n')

    fptr.close()
## ---------------------------------------------------------------------------


## ---------------------------------------------------------------------------
## puzzle link: https://www.hackerrank.com/challenges/repeated-string/problem

#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    total = 0
    num_a = len([x for x in s if x == 'a'])
    main_a = num_a * (n // len(s))

    remainder_num = n % len(s) 
    additional_a = 0
    if remainder_num > 0: 
        remainder_str = s[0:remainder_num]
        additional_a = len([x for x in remainder_str if x == 'a'])
        
    return main_a + additional_a

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    n = int(input())

    result = repeatedString(s, n)

    fptr.write(str(result) + '\n')

    fptr.close()
## ---------------------------------------------------------------------------


## ---------------------------------------------------------------------------
## 2
## puzzle link: https://www.hackerrank.com/challenges/counting-valleys/problem

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'pickingNumbers' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY a as parameter.
#

def picking_numbers(a):
    a.sort()
    sub_array = []
    array_lengths = []
   
    for i, value in enumerate(a):
        sub_array.append(a[i])
        if len(sub_array) > 1 and sub_array[-1] - sub_array[0] > 1:
            array_lengths.append(len(sub_array) - 1)
            # remove chain of nums with lowest value so we can keep walking forward,
            # in case there's an even longer chain later on in the middle
            # for example, take the series [2,2,2,3,3,3,4,4,4,4]
            # if we didn't drop the 2s and continue, then we'd output an incorrect
            # max length of 6 instead of 7
            to_remove = sub_array[0]
            sub_array = [x for x in sub_array if x != to_remove]
    
    if not array_lengths:
        array_lengths.append(len(sub_array))

    return max(array_lengths)
            
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    result = picking_numbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()
## ---------------------------------------------------------------------------


## ---------------------------------------------------------------------------
## 1
## puzzle link: https://www.hackerrank.com/challenges/counting-valleys/problem

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countingValleys' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def counting_valleys(steps, path):
    valleys = 0
    altitude = 0
    
    for move in path:
        if altitude == -1 and move == 'U':
            valleys += 1
            
        if move == 'U':
            altitude += 1
        else:
            altitude -= 1
    
    return valleys


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    steps = int(input().strip())

    path = input()

    result = counting_valleys(steps, path)

    fptr.write(str(result) + '\n')

    fptr.close()
## ---------------------------------------------------------------------------

