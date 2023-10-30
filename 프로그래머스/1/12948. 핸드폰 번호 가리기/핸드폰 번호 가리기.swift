func solution(_ phone_number:String) -> String {
    var reversedPhone_number = String(phone_number.reversed())
    var count = 0
    var returnPhone_number : [String] = []
    
    for i in reversedPhone_number {
        let i = String(i)
        count += 1
        if (count > 4) {
            returnPhone_number.insert("*", at:0)
        } else {
            returnPhone_number.insert(i, at:0)
        }
    }
    return returnPhone_number.joined(separator:"")
}