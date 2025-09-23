unlock_code, wire_color, seconds = input().split()
seconds = int(seconds)

# Please write your code here.

class S:
    def __init__(self,unlock_code,wire_color,seconds) :
        self.unlock_code = unlock_code
        self.wire_color=wire_color
        self.seconds = seconds

s1 = S(unlock_code,wire_color,seconds)

print(f"code : {s1.unlock_code}\ncolor : {s1.wire_color}\nsecond : {s1.seconds}")