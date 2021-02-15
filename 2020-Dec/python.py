

# ---------------------------------------------------------------------------
# puzzle link: https://www.hackerrank.com/challenges/acm-icpc-team/problem

#!/bin/python3

import math
import os
import random
import re
import sys

def acmTeam(topic):
    max_binary_dec = 0 
    total_teams = 0
    people_count = len(topic)
    
    for i in range(people_count):
        for j in range(i + 1, people_count):
            current_bin_dec = int(topic[i], 2) | int(topic[j], 2)
            if current_bin_dec < max_binary_dec:
                continue
            elif current_bin_dec == max_binary_dec:
                total_teams += 1
            elif current_bin_dec > max_binary_dec:
                max_binary_dec = current_bin_dec
                total_teams = 1
    
    max_topics = bin(max_binary_dec).count("1")
    return [max_topics, total_teams]

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

