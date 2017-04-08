# https://www.hackerrank.com/challenges/find-point

num_pairs = int(input())
pairs = []

for _ in range(num_pairs):
    vals = list(map(lambda x: int(x), input().split()))  # make each str an int
    pairs.append(((vals[0], vals[1]), (vals[2], vals[3])))

for pair in pairs:
    # add the difference (distance) between the two pairs to the second pair
    print(str((pair[1][0] - pair[0][0]) + pair[1][0]) + ' ' +
          str((pair[1][1] - pair[0][1]) + pair[1][1]))
