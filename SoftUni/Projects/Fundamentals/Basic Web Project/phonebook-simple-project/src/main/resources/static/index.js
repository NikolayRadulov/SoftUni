let button = document.getElementsByTagName("button")[0];
button.style.position = "relative";
let table = document.getElementsByTagName("table")[0];
if(table.rows.length > 0)button.style.top = table.rows.length*1.4 + "px";
else button.style.top = 10 + "px";