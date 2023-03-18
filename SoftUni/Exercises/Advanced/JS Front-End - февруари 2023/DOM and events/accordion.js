function toggle() {
    const button = document.getElementsByClassName('button')[0];
    const text = document.getElementById('extra'); 
    if(button.innerText === 'More') {
        button.innerText = 'Less';
        text.style.display = 'block';
    }
    else {
        button.innerText = 'More';
        text.style.display = 'none';
    }

}