
def print_permutations(values, length, accum):
    """ Prints all permutations of the value set up to a given length recursively """
    if length == 0:
        print(accum)
    else:
        for value in values:
            temp_accum = []
            temp_accum = temp_accum + accum
            temp_accum.append(value)
            print_permutations(values, length - 1, temp_accum)

print_permutations([0, 1], 2, [])  # 00 01 10 11
print()
print_permutations([0, 1, 2], 2, [])  # 00 01 10 11 02 20 12 21