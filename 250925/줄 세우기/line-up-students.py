n = int(input())
students = [tuple(map(int, input().split())) + (i + 1,) for i in range(n)]

# Please write your code here.

students.sort(key=lambda x:(-x[0],-x[1],x[2]))

for s in students:
    print(s[0],s[1],s[2])