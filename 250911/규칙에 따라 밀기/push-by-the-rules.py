s = input()

queries = input()

for q in queries :
    if q == 'L' :
        s = s[1:] + s[0]
    else :
        s = s[-1] + s[:-1]

print(s)