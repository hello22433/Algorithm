n, k, t = input().split()
n, k = int(n), int(k)
str1 = [input() for _ in range(n)]

# Please write your code here.

def isFirstT(l) :
    return l[0] == T 

str1 = list(filter(isFirstT,str1))

str1.sort()

print(str1[k-1])