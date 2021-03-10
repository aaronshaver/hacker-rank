data = ["cal", "lac", "abc", "ba", "totally", "ylla", "rum", "mur", "listen", "netsil"]

def get_palindrome_pairs(words):
    palindromes = []
    for i in range(len(words)):
        for j in range(i+1, len(words)):
            combined = words[i] + words[j]
            combined_swapped = words[j] + words[i]
            if combined == combined[::-1]:
                palindromes.append(combined)
            if combined_swapped == combined_swapped[::-1]:
                palindromes.append(combined_swapped)

    return palindromes

print(get_palindrome_pairs(data))