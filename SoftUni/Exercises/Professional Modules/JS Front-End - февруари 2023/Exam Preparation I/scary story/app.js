//window.addEventListener("load", solve);

function solve() {
  const button = document.getElementById('form-btn');
  button.addEventListener('click', () => {

    let fields = [document.getElementById('first-name'), document.getElementById('last-name'), document.getElementById('age'), document.getElementById('story-title'), document.getElementById('story')];
    let inputName = document.getElementById('first-name').value + " " + document.getElementById('last-name').value;
    let inputAge = document.getElementById('age').value;
    let inputTitle = document.getElementById('story-title').value;
    let inputGenre = document.getElementById('genre').value;
    let inputStory = document.getElementById('story').value;
    let datas = [inputName.split(" ")[0], inputName.split(" ")[1], inputAge, inputTitle, inputStory];
    if(inputName.split(" ")[0].trim().length == 0 || inputName.split(" ")[1].trim().length == 0 || inputAge.trim().length == 0 || inputTitle.trim().length == 0 || inputStory.trim().length == 0) return;
    let li = document.createElement('li');
    li.className = 'story-info';
    let article = document.createElement('article');
    let name = document.createElement('h4');
    name.innerText = "Name: " + inputName;
    let age = document.createElement('p');
    age.innerText = "Age: " + inputAge; //parse to int
    let title = document.createElement('p');
    title.innerText = "Title: " + inputTitle;
    let genre = document.createElement('p');
    genre.innerText = "Genre: " + inputGenre;
    let story = document.createElement('p');
    story.innerText = inputStory;

    for(let field of fields) {
        field.value = "";
    }
    document.getElementById("preview-list").appendChild(li);
    li.appendChild(article);
    article.appendChild(name);
    article.appendChild(age);
    article.appendChild(title);
    article.appendChild(genre);
    article.appendChild(story);
    
    const saveButton = document.createElement('button');
    saveButton.className = 'save-btn';
    saveButton.innerText = "Save story";
    saveButton.addEventListener('click', () => {
      document.getElementsByClassName('form-wrapper')[0].remove();
      document.getElementById("side-wrapper").remove();
      let h1 = document.createElement('h1');
      h1.innerText = 'Your scary story is saved!';
      document.getElementById('main').appendChild(h1);
    });
    const editButton = document.createElement('button');
    editButton.className = 'edit-btn';
    editButton.innerText = 'Edit story';
    editButton.addEventListener('click', () => {
      document.getElementsByClassName('story-info')[0].remove();
      for(let i = 0; i < fields.length; i++) {
        fields[i].value = datas[i];
      }
      button.disabled = false;
    });

    const deleteButton = document.createElement('button');
    deleteButton.className = 'delete-btn';
    deleteButton.innerText = 'Delete story';
    deleteButton.addEventListener('click', () => {
      document.getElementsByClassName('story-info')[0].remove();
      button.disabled = false;
    })

    li.appendChild(saveButton);
    li.appendChild(editButton);
    li.appendChild(deleteButton);

    button.disabled = true;
  });
}
