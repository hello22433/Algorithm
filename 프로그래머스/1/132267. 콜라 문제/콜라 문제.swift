import Foundation

func solution(_ a:Int, _ b:Int, _ n:Int) -> Int {
        var k = n/a * b + n%a
        var count = n/a * b;
        
    while true {
        var countSoo = k/a * b
        k = k/a * b + k%a
        count += countSoo
        
        if (k < a) {
            break;
        }
    }
    
    return count;
}

// 1. 빈병(n)을 가져다주고(a) 받는다(b) : k = n/a * b + n%a
// 2. 받은걸(b) 남은것(n-a)에 더한 다음 또 받는다.(b) : m = k/a * b + k%a
// 3. 반복하다가 m < a break;