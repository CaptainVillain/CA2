const buttons = document.querySelectorAll("#users button");
for(let i = 0; i < buttons.length; i++){
buttons[i].addEventListener("click", getPath);
    
}

function getPath(event) {
    var path = event.target.id;
        fetch("http://localhost:8084/api/" + path)
            .then(res => res.json())
            .then(data => tohtml(data));
    console.log(path);
}


function tohtml(data) {
         
    var myJSON = JSON.stringify(data);
    console.log(myJSON.split(',').join("\r\n"));
    document.getElementById("data").innerHTML = myJSON;
        
 
}


