import Foundation

func solution(_ a:Int, _ b:Int) -> String {
    let formatter = DateFormatter()
    
    
    formatter.dateFormat = "yyyy-MM-dd"
    let abDate = formatter.date(from:"2016-\(a)-\(b)")
    
    formatter.dateFormat = "E"
    let result = formatter.string(from:abDate!)
    
    return result.uppercased()
}