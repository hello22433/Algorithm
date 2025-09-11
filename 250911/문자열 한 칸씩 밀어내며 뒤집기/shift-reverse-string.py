s, q = input().split()
q = int(q)
queries = [int(input()) for _ in range(q)]

# Please write your code here.

for query in queries :
    if query == 1 :
        s = s[1:] + s[0] 
    elif query == 2 :
        s = s[-1] + s[:-1]
    else :
        s = s[::-1]
    print(s)
