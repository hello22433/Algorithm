import Foundation

func solution(_ answers:[Int]) -> [Int] {
    
    let sooPho1 = [1,2,3,4,5]
    var sooPho1score = 0
    let sooPho2 = [2,1,2,3,2,4,2,5]
    var sooPho2score = 0
    let sooPho3 = [3,3,1,1,2,2,4,4,5,5]
    var sooPho3score = 0
    
    var sooPhoIndexCount = 0
    
    // 1
    for i in answers {
        if (i == sooPho1[sooPhoIndexCount]) {
            sooPho1score += 1
        }
        sooPhoIndexCount += 1
        if (sooPhoIndexCount > sooPho1.count - 1) {
            sooPhoIndexCount = 0
        }
    }
    sooPhoIndexCount = 0
    
    // 2
    for i in answers {
        if (i == sooPho2[sooPhoIndexCount]) {
            sooPho2score += 1
        }
        sooPhoIndexCount += 1
        if (sooPhoIndexCount > sooPho2.count - 1) {
            sooPhoIndexCount = 0
        }
    }
    sooPhoIndexCount = 0
    
    // 3
    for i in answers {
        if (i == sooPho3[sooPhoIndexCount]) {
            sooPho3score += 1
        }
        sooPhoIndexCount += 1
        if (sooPhoIndexCount > sooPho3.count - 1) {
            sooPhoIndexCount = 0
        }
    }
    
    var bucket : [Int : Int] = [1 : sooPho1score, 2 : sooPho2score, 3 : sooPho3score]
    var bucketSorted = bucket.sorted{(first, second) in
               if (first.value == second.value) {
                   return first.key < second.key
               } 
               return first.value > second.value
               }
    
    var bucketSortedValue : [Int] = []
    for i in bucketSorted {
        bucketSortedValue.append(i.value)
    }
    
    var result : [Int] = []
    var bucketSortedIndexCount = 0
    for i in bucketSorted {
        result.append(i.key)
        if (bucketSortedIndexCount < bucketSortedValue.count - 1) {
            bucketSortedIndexCount += 1 
            if (i.value != bucketSortedValue[bucketSortedIndexCount]) {
                break;
            }
        }
    }
    
    return result
}


// 1. answers와 sooPho를 같이 돌려야 하는데 sooPho의 길이가 부족하면 다시 돌아가야 한다. -> 각각의 반복문을 만들어준다
// 2. 점수를 구하고, 각각의 정수를 키값으로 해서 value를 저장한다.
// 3. value를 기준으로 내림차순 정렬하되, 같을 때는 key를 기준으로 오름차순 정렬
// 4. 키 값을 result배열에 넣는다.