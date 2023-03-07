function oddAndEvenSum(num) {
    let sumEven = 0, sumOdd = 0;
    let str = num+"";
    for(let i = 0; i < str.length; i++) {
        let checkNum = parseInt(str.charAt(i));
        if(checkNum % 2 === 0) sumEven+=checkNum;
        else sumOdd += checkNum;
    }

    console.log(`Odd sum = ${sumOdd}, Even sum = ${sumEven}`);
}