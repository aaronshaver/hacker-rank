# https://www.hackerrank.com/challenges/arrays-ds

n = int(input().strip())
arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]

output = ''
for item in list(reversed(arr)):
    output += str(item) + ' '

print(output)
