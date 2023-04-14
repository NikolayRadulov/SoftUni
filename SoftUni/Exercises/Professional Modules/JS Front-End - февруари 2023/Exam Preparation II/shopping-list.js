function solution(data) {

    let list = data[0].split("!");

    let commandIndex = 1;
    let command = data[commandIndex];

    while(command !== "Go Shopping!") {
        let tokens = command.split(" ");
        switch(tokens[0]) {
            case 'Urgent': {
                if(!isElementPresent(list, tokens[1]))list.unshift(tokens[1]);
            }
            break;
            case 'Unnecessary': {
                if(isElementPresent(list, tokens[1])){
                    for(let i = 0; i < list.length; i++) {
                        if(list[i] === tokens[1]) {
                            list.splice(i, 1);
                            break;
                        }
                    }
                }
            }
            break;
            case 'Correct': {
                for(let i = 0; i < list.length; i++) {
                    if(list[i] === tokens[1]) {
                        list[i] = tokens[2];
                    }
                }
            }
            break;
            case 'Rearrange': {
                for(let i = 0; i < list.length; i++) {
                    if(list[i] === tokens[1]) {
                        list.splice(i, 1);
                        list.push(tokens[1]);
                    }
                }
            }
            break;
        }
        command = data[++commandIndex];
    }
    console.log(list.join(", "));


    function isElementPresent(list, element) {
        for(let product of list) {
            if(product === element) return true;
        }

        return false;
    }
}
