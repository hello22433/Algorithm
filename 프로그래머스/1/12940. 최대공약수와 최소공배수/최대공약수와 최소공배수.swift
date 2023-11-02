func solution(_ n:Int, _ m:Int) -> [Int] {
    var nAk : [Int] = []
    
    var GongAk : [Int] = []
    
    // n의 약수 구하기
    for i in 1...n {
        if (n % i == 0) {
            nAk.append(i)
        }
    }
    
    // n과 m의 공약수 구하기
    for i in 1...m {
        if (m % i == 0) {
            if (nAk.contains(i)) {
                GongAk.append(i)
            }
        }
    }
    
    let MaximumGongAk = GongAk.last!
    // 왜 optional로 값이 나오는 걸까? -> 배열 메서드로 정수를 추출하면 그런 듯 하다.
    
    // 최소공배수 구하기
    let MinimumGongBae = MaximumGongAk * (n / MaximumGongAk) * (m / MaximumGongAk)
    
    return [MaximumGongAk, MinimumGongBae]
}