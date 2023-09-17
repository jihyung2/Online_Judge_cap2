n = 5

star_pattern = ''

for i in range(n):
    star_pattern += (' ' * (n - i - 2) + '*' * (2 * i + 1)) + '\n'

print(star_pattern)
