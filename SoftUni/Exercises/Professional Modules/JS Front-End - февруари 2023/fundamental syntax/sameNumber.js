function solution(num) {
    let lastDigit = -1;
    let isDifferentDigitFound = false;
    let sum = 0;
    while(num > 0) {
        let digit = num%10;
        if(lastDigit === -1) lastDigit = digit;
        else if(lastDigit !== digit) isDifferentDigitFound = true;
        sum += digit;
        num = Math.floor(num/10);
    }
    
    if(!isDifferentDigitFound) console.log('true');
    else console.log('false');
    console.log(sum);
}
