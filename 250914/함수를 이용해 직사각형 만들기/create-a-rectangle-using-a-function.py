n, m = map(int, input().split())

# Please write your code here.
print_stars(n,m)

def print_stars(n,m) :
    for _ in range(n) :
        print("*" * m)