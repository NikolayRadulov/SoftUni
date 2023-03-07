function printAndSum(start, end) {
    let sum = 0;
    let nums = [];
    for(let i = start; i <= end; i++ ) {
        sum+=i;
        nums.push(i);
    }
    console.log(nums.join(" "));
    console.log('Sum: ' + sum);
}