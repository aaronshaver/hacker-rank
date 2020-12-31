function updateResult(newText) {
    const currentResult = getDisplay()
    res.innerHTML = currentResult + newText
}

function getDisplay() {
    return res.innerHTML
}

function clearResult() {
    res.innerHTML = ""
}

function getStringAsArray(receivedInput) {
    output = []
    for (var i = 0; i < receivedInput.length; i++) {
        output.push(receivedInput[i])
    }
    return output
}

function evaluateEntries(inputEntries) {
    var cursor = 0
    var firstNum;
    var secondNum;
    var operator;
    
    // get first number
    var temp = []
    var lastCursor = 0;
    for (var i = cursor; i < inputEntries.length; i++) {
        lastCursor = i
        const currentChar = inputEntries[i]
        if (currentChar == 0 || currentChar == 1) {
            temp.push(currentChar)
        }
        else break;
    }
    firstNum = temp
   
    // get operator
    operator = inputEntries[lastCursor]
    
    // get second number
    var temp = []
    for (var i = lastCursor + 1; i < inputEntries.length; i++) {
        lastCursor = i
        const currentChar = inputEntries[i]
        if (currentChar == 0 || currentChar == 1) {
            temp.push(currentChar)
        }
        else break;
    }
    secondNum = temp
    
    return computeEquation(firstNum, operator, secondNum)
}

function computeEquation(firstNum, operator, secondNum) {
    firstNumString = ""
    for (var i = 0; i < firstNum.length; i++) {
        firstNumString += firstNum[i]
    }
    first = parseInt(firstNumString, 2)
    
    secondNumString = ""
    for (var i = 0; i < secondNum.length; i++) {
        secondNumString += secondNum[i]
    }
    second = parseInt(secondNumString, 2)
    
    var result
    switch (operator) {
        case "+":
            result = first + second
            break
        case "-":
            result = first - second
            break
        case "*":
            result = first * second
            break
        case "/":
            result = Math.floor(first / second)
            break
    }
        
    return result.toString(2)
}

function calculateResult() {
    const inputEntries = getStringAsArray(getDisplay())
    result = evaluateEntries(inputEntries)
    clearResult()
    res.innerHTML = result.toString()
}

btn0.addEventListener("click", function() { updateResult("0") })
btn1.addEventListener("click", function() { updateResult("1") })
btnSum.addEventListener("click", function() { updateResult("+") })
btnSub.addEventListener("click", function() { updateResult("-") })
btnMul.addEventListener("click", function() { updateResult("*") })
btnDiv.addEventListener("click", function() { updateResult("/") })
btnClr.addEventListener("click", function() { clearResult() })
btnEql.addEventListener("click", function() { calculateResult() })
