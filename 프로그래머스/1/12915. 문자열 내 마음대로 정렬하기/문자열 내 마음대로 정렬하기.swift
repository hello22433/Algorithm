func solution(_ strings:[String], _ n:Int) -> [String] {
    var strings = strings
    
    var newArr : [String] = []
    var result : [String] = []
    
    for i in strings {
        newArr.append(String(i[i.index(i.startIndex, offsetBy: n)]))
    }
    
    newArr.sort(by: < )
    strings.sort(by: < )
    
    for i in newArr {
        for j in strings {
            
            if (String(i) == String(j[j.index(j.startIndex, offsetBy: n)])) {
                result.append(String(j))
                strings.remove(at: strings.firstIndex(of:j)!)
                break;
            }
        }
    }
    
    return result
}


// 1. strings에서 n번째 글자 빼온다.
// 2. new배열에 넣어서 오름차순 정렬한다.
// 3. strings를 오름차순으로 정렬한다.
// 4. strings를 다시 순회탐색하면서 n번째 문자열이 new배열과 일치하면 result배열에 넣는다.
