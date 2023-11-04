import Foundation

func solution(_ sizes:[[Int]]) -> Int {
    var LargeInt : [Int] = []
    var MiniInt : [Int] = []
    
    for i in sizes {
        // if (i[0][0] > i[0][1]) {
        //     LargeInt.append(i[0][0])
        //     MiniInt.append(i[0][1])
        // } else {
        //     LargeInt.append(i[0][1])
        //     MiniInt.append(i[0][0])
        // }
                if (i[0] > i[1]) {
            LargeInt.append(i[0])
            MiniInt.append(i[1])
        } else {
            LargeInt.append(i[1])
            MiniInt.append(i[0])
        }
    }
    
    let result = LargeInt.max()! * MiniInt.max()!
    
    return result
}