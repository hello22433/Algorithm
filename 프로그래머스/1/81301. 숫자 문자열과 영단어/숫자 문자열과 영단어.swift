import Foundation



func solution(_ s:String) -> Int {
    var newArr : [String] = []
    var bucket : [String] = []
    
    for i in s {
        let i = String(i)
        
        if (Int(i) != nil) {
            newArr.append(i)
            continue;
        } else {
            bucket.append(i)
        }
        
        if (bucket.count != 0) {
            switch bucket.joined(separator:"") 
            {
                case "zero" :
                    newArr.append("0")
                    bucket = []
                case "one" :
                    newArr.append("1")
                    bucket = []
                case "two" :
                    newArr.append("2")
                    bucket = []
                case "three" :
                    newArr.append("3")
                    bucket = []
                case "four" :
                    newArr.append("4")
                    bucket = []
                case "five" :
                    newArr.append("5")
                    bucket = []
                case "six" :
                    newArr.append("6")
                    bucket = []
                case "seven" :
                    newArr.append("7")
                    bucket = []
                case "eight" :
                    newArr.append("8")
                    bucket = []
                case "nine" :
                    newArr.append("9")
                    bucket = []
                default :
                    continue;
            }
        }  
    }
    
    return Int(newArr.joined(separator:""))!
}

// 1. 탐색돌려서 숫자나오면 그대로 새로운 배열에 넣는다. 
// 2. 영어가 나오면 돌릴때마다 bucket에 넣으면서 joined해보고 스위치로 영단어 체크해본다.
// 3. 체크해서 맞을때 숫자로 바꿔서 새로운 배열에 넣고, bucket초기화.