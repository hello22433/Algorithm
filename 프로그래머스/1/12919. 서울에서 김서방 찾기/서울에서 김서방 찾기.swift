func solution(_ seoul:[String]) -> String {
    var count = -1
    for i in seoul {
        count += 1
        if (i == "Kim") {
            return "김서방은 \(count)에 있다"
        }
    }
    return ""
}