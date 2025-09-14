n = int(input())

# Please write your code here.



def print_nums(n) :
    num = 1

    for _ in range(n) :
        for _ in range(n) :
            print(num,end=" ")
            num += 1
            num = num % 10
        print()


print_nums(n)
