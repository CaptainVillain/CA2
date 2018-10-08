const buttons = document.querySelectorAll("#users button");
for(let i = 0; i < buttons.length; i++){
buttons[i].addEventListener("click", getPath);
    
}

function getPath(event) {
    var path = event.target.id;
        fetch("https://www.cph-nr80.dk/Ca2/api/" + path)
            .then(res => res.json())
            .then(data => tohtml(data));
    console.log(path);
}


function tohtml(data) {
    console.log(data)
    var myJSON = JSON.stringify(data);
    console.log(myJSON)
    document.getElementById("data").innerHTML = myJSON;
        
 
}


