secret_code, meeting_point, time = input().split()
time = int(time)

# Please write your code here.

class S:
    def __init__(self,secret_code,meeting_point,time) :
        self.secret_code = secret_code
        self.meeting_point = meeting_point
        self.time = time

s1 = S(secret_code,meeting_point,time)

print(f"secret code : {s1.secret_code}")
print(f"meeting point : {s1.meeting_point}")
print(f"time : {s1.time}")
        