import Foundation

func solution(_ num1:Int, _ num2:Int) -> Int {
    let Num1 = Double(num1)
    let Num2 = Double(num2)
    return Int(Double(Num1/Num2) * 1000)
}