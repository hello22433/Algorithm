import Foundation

func solution(_ food:[Int]) -> String {
    var count = 0;
    var newArr : [Int] = []

    for i in food {
        if (count == 0) {
            count += 1;
            continue;
        }
        // swift는 자동으로 내림처리한다
        newArr.append(i / 2)
    }
    
    var resultArr : [String] = []
    var resultArrReverse : [String] = []
    var numberCount = 0;
        for j in newArr {
            numberCount += 1
            resultArrReverse.insert(String(repeating:String(numberCount), count:j), at:0)
            resultArr.append(String(repeating:String(numberCount), count:j))
        }
    resultArrReverse.insert("0",at:0)
    resultArrReverse.insert(contentsOf:resultArr, at:0)
    
    return resultArrReverse.joined(separator:"")
}

// 1. 나누기 2를 한다. 자동내림처리되니까 그걸로 반복처리한다. how?
// 2. result 배열에 새로운 배열을 넣고 0을 넣음으로써 마무리한다.
// 3. 새로운 배열을 result배열에 다시 넣는다.