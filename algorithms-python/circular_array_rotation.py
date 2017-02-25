num_integers, rotations, num_queries = input().strip().split(' ')
num_integers, rotations, num_queries = [int(num_integers), int(rotations), int(num_queries)]
a = [int(a_temp) for a_temp in input().strip().split(' ')]

rotations = rotations % num_integers  # if rotations == num_integers, there's no rotations, thus we ignore those
if num_integers != rotations:
    prepend = a[num_integers-rotations:]
    a = prepend + a
    a = a[0:num_integers]

for i in range(num_queries):
    query_position = int(input().strip())
    print(a[query_position])
