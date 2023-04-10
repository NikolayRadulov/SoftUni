function getStoreProvision(arr1, arr2) {
    let map = {};

    for(let i = 0; i < arr1.length-1; i+=2) {
        if(map[arr1[i]] === undefined) map[arr1[i]] = parseInt(arr1[i+1]);
        else map[arr1[i]] += parseInt(arr1[i+1])
    }
    for(let i = 0; i < arr2.length-1; i+=2) {
        if(map[arr2[i]] === undefined) map[arr2[i]] = parseInt(arr2[i+1]);
        else map[arr2[i]] += parseInt(arr2[i+1])
    }

    for (const key in map) {
        console.log(`${key} -> ${map[key]}`);
    }
}
