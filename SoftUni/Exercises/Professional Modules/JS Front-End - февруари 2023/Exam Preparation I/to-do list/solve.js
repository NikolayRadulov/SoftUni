// TODO
function attachEvents() {
  const baseUrl = 'http://localhost:3030/jsonstore/tasks/';
  const loadAllButton = document.getElementById('load-button');
  const addItemButton = document.getElementById('add-button');
  const toDoList = document.getElementById('todo-list');
  const titleField = document.getElementById('title');

  loadAllButton.addEventListener('click', loadItems);
  addItemButton.addEventListener('click', addItem);

  function addItem(e) {
    e.preventDefault();

    let name = titleField.value;
    let header = {
        method: "POST",
        body: JSON.stringify({name})
    };

    fetch(baseUrl, header).then(() => loadItems())
  }

  function loadItems(event) {
    event?.preventDefault();

    toDoList.innerHTML = '';
    let header = {
        method: 'GET'

    };
    fetch(baseUrl, header)
    .then(object => object.json())
    .then(task => {
        const tasks = Object.values(task);

        for(const {name, _id} of tasks) {
            let li = document.createElement('li');
            li._id = _id;
            let span = document.createElement('span');
            span.textContent = name;
            let editButton = document.createElement('button');
            editButton.textContent = "Edit";
            editButton.addEventListener('click', editItems);
            let deleteButton = document.createElement('button');
            deleteButton.textContent = "Remove";
            deleteButton.addEventListener('click', removeItems);

            li.appendChild(span);
            li.appendChild(deleteButton);
            li.appendChild(editButton);
            
            toDoList.appendChild(li);
        }
    })
    .catch(e => console.log(e));
  }

  function removeItems(event) {
    event?.preventDefault();

    let id = event.currentTarget.parentNode._id;
    let headers = {
        method: "DELETE"
    }
    fetch(`${baseUrl}${id}`, headers).then(() => loadItems())
  }

  function editItems(e) {
    e?.preventDefault();
    let li = e.currentTarget.parentNode;

    const [span, edit_button1, remove_button] = li.children;

    span.remove();
    remove_button.remove();

    const input = document.createElement('input');
    const submitButton = document.createElement('button'); 
    submitButton.textContent = "Submit";
    submitButton.addEventListener('click', (e) => {
        e?.preventDefault();
        let name = input.value;
        let id = e.currentTarget.parentNode._id;
        let header = {
            method: "PATCH",
            body: JSON.stringify({ name })
        };
        fetch(`${baseUrl}${id}`, header).then(() => loadItems());
    });

    li.prepend(input); //could have problem
    li.appendChild(submitButton);
  }
}

attachEvents();
