function printCharacters(ch1, ch2) {
    let chars = [];
    for(let i = Math.min(ch1.charCodeAt(0), ch2.charCodeAt(0))+1; i < Math.max(ch1.charCodeAt(0), ch2.charCodeAt(0)); i++) {
        chars.push(String.fromCharCode(i));
    }

    return chars.join(' ');
}