function addAndSubrtact(a, b, c) {

    function sum() {
        return a+b;
    }

    function subtract() {
        return sum()-c;
    }

    return subtract();
}