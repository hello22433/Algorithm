import Foundation

func solution(_ nums:[Int]) -> Int {
    var result = 0
    
outer:for i in 0..<nums.count {
        for j in i+1..<nums.count {
            for k in j+1..<nums.count {
                
                if (isSosoo(nums[i], nums[j], nums[k])) {
                    result += 1
                }
                
                // 배열 넘기기 방지.
                if (i == nums.count - 3 && j == nums.count - 2 && k == nums.count - 1) {
                    break outer;
                }
            }
        }
    }
    
    return result
}

func isSosoo(_ i: Int, _ j: Int, _ k: Int) -> Bool {
    let nums = i + j + k
    for q in 2..<nums {
        if (nums % q == 0) {
            return false
        }
    }
    return true
}



// 1. 삼중 반복문으로 서로다른 세 개를 더한다.
// 2. 제일 하위 반복문에서 더할 때마다 소수 검사한다. 검사에서 양성 반응오면 count += 1