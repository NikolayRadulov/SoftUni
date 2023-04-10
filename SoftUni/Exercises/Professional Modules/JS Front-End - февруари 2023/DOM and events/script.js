function create(words) {
   let sections = [];

   words.forEach(element => {
      let elementDiv = document.createElement('div');
      let elementP = document.createElement('p');
      elementP.style.display = 'none';
      elementP.innerText = element;
      elementDiv.addEventListener('click', () => {
         elementP.style.display = 'inline';
      });
      elementDiv.appendChild(elementP);
      let container = document.getElementById('content');
      container.appendChild(elementDiv);
   });
}