user2_id, user2_level = input().split()
user2_level = int(user2_level)

# Please write your code here.

class S:
    def __init__(self, idd, level):
        self.idd = idd
        self.level = level

s1 = S("codetree",10)
s2 = S(user2_id,user2_level)

print(f"user {s1.idd} lv {s1.level}")
print(f"user {s2.idd} lv {s2.level}")