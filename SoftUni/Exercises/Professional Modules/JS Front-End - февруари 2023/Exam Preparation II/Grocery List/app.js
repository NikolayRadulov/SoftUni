const loadButton = document.getElementById('load-product');
loadButton.addEventListener('click', loadAllProducts);
const addButton = document.getElementById('add-product');
addButton.addEventListener('click', addNewProduct);
const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';
const updButton = document.getElementById('update-product');
updButton.addEventListener('click', submitChanges);

const productField = document.getElementById('product');
const countField = document.getElementById('count');
const priceField = document.getElementById('price');

function loadAllProducts(e) {
    e?.preventDefault();
    document.getElementsByTagName('table')[0].innerHTML = '';
    fetch(BASE_URL).then(data=>data.json())
                   .then(fullProduct => {
                        let tasks = Object.values(fullProduct);
                        for(const {_id, product, count, price} of tasks) {
                            let tr = document.createElement('tr');
                            tr._id = _id;
                            let tdProduct = document.createElement('td');
                            tdProduct.className = 'name';
                            tdProduct.textContent = product;
                            let tdCount = document.createElement('td');
                            tdCount.textContent = count;
                            tdCount.className = 'count-product';
                            let tdPrice = document.createElement('td');
                            tdPrice.textContent = price;
                            tdPrice.className = 'product-price';
                            let tdAction = document.createElement('td');
                            tdAction.className = 'btn';
                            let updateBtn = document.createElement('button');
                            updateBtn.textContent = 'Update';
                            updateBtn.addEventListener('click', updateProduct);
                            let deleteBtn = document.createElement('button');
                            deleteBtn.textContent = 'Delete';
                            deleteBtn.addEventListener('click', deleteProduct);
                            tdAction.appendChild(updateBtn);
                            tdAction.appendChild(deleteBtn);
                            tr.appendChild(tdProduct);
                            tr.appendChild(tdCount);
                            tr.appendChild(tdPrice);
                            tr.appendChild(tdAction);
                            document.getElementById('tbody').appendChild(tr);
                        }
                   })
}

function addNewProduct(e) {
    e?.preventDefault();
    const product = document.getElementById('product').value;
    const count = document.getElementById('count').value;
    const price = document.getElementById('price').value;

    let header = {
        method: 'POST',
        body: JSON.stringify({ product, count, price})
    }

    fetch(BASE_URL, header).then(()=>loadAllProducts());
} 

function deleteProduct(e) {

    e?.preventDefault();
    let tr = e.currentTarget.parentNode.parentNode;

    let header = {
        method: 'DELETE'
    }

    fetch(`${BASE_URL}${tr._id}`, header).then(()=>loadAllProducts());
}

function updateProduct(e) {
    e?.preventDefault();
    
    let tr = e.currentTarget.parentNode.parentNode;
    updButton._id = tr._id;
    console.log(tr.children);
    let [tdProduct, tdCount, tdPrice, tdAction] = tr.children;

    productField.value = tdProduct.textContent;
    countField.value = tdCount.textContent;
    priceField.value = tdPrice.textContent;

    addButton.setAttribute('disabled', true);
    updButton.removeAttribute('disabled');
}

function submitChanges(e) {
    e?.preventDefault();

    const product = productField.value;
    const count = countField.value;
    const price = priceField.value;
    let header = {
        method: 'PATCH',
        body: JSON.stringify({ product, count, price})
    }
    fetch(`${BASE_URL}${updButton._id}`, header).then(()=>loadAllProducts()).catch(e => console.log(e));

    productField.value = '';
    countField.value = '';
    priceField.value = '';

    updButton.disabled = true;
    addButton.disabled = false;
}