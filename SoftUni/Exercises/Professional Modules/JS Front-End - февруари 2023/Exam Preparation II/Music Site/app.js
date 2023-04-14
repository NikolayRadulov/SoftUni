//window.addEventListener('load', solve);

function solve() {
    const genreField = document.getElementById('genre');
    const nameField = document.getElementById('name');
    const authorField = document.getElementById('author');
    const dateField = document.getElementById('date');

    const addButton = document.getElementById('add-btn');

    addButton.addEventListener('click', addSong);


    function addSong(e) {
        e.preventDefault();
        let data = [genreField.value, nameField.value, authorField.value, dateField.value];

        for(let field of data) {
            if(field.trim().length === 0) return;
        }

        genreField.value = '';
        nameField.value = '';
        authorField.value = '';
        dateField.value = '';

        let div = document.createElement('div');
        div.className = 'hits-info';
        let h2Genre =  document.createElement('h2');
        let h2Name =  document.createElement('h2');
        let h2Author =  document.createElement('h2');
        let h3Date =  document.createElement('h3');
        let img = document.createElement('img');
        img.src = './static/img/img.png';
        let saveButton = document.createElement('button');
        saveButton.className = "save-btn";
        saveButton.textContent = "Save song";
        saveButton.addEventListener('click', (e) => {
            let div = e.currentTarget.parentNode;
            saveButton.remove();
            likeButton.remove();
            div.remove();
            document.getElementsByClassName('saved-container')[0].appendChild(div);
        });
        let likeButton = document.createElement('button');
        likeButton.className = "like-btn";
        likeButton.textContent = 'Like song';
        likeButton.addEventListener('click', (e) => {
            e.preventDefault();
            let [p, img] = document.getElementsByClassName('likes')[0].children;
            let likes = parseInt(p.textContent.split(': ')[1])+1;
            p.innerText = "Total Likes: "+likes;
            likeButton.disabled = true;
        });
        let deleteButton = document.createElement('button');
        deleteButton.className = "delete-btn";
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', (e) => {
            let div = e.currentTarget.parentNode;
            div.remove();
        });

        h2Genre.innerText = 'Genre: ' + data[0];
        h2Name.innerText = 'Name: ' + data[1];
        h2Author.innerText = 'Author: ' + data[2];
        h3Date.innerText = 'Date: ' + data[3];

        div.appendChild(img);
        div.appendChild(h2Genre);
        div.appendChild(h2Name);
        div.appendChild(h2Author);
        div.appendChild(h3Date);   
        div.appendChild(saveButton);
        div.appendChild(likeButton);
        div.appendChild(deleteButton);

        document.getElementsByClassName('all-hits-container')[0].appendChild(div);
    }

}