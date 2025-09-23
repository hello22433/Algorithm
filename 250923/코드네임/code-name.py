MAX_N = 5

class M:
    def __init__(self,codename,score):
        self.codename=codename
        self.score=score

codenames = []
scores = []
mans = []
for i in range(MAX_N):
    codename, score = input().split()
    codenames.append(codename)
    scores.append(int(score))

    mans.append(M(codenames[i],scores[i]))

minScore = min(man.score for man in mans)
minScoreMan = [man.codename for man in mans if man.score == minScore]

print(minScoreMan[0],minScore)

# Please write your code here.


