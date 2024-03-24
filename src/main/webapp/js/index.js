async function startUp() {
    var url = "http://localhost:8989/anon-book/post";
    var response = await fetch(url, { method: "GET" });
    const posts = await response.json();
    console.log(posts);
    for (var i = 0; i < posts.length; i++) {
        addPost(posts[i]);
    }
}
function addPost(post) {
    console.log(post)
    var div = document.createElement("div");
    div.className = "posts";

    var idEl = document.createElement("p");
    idEl.className = "bio";
    idEl.textContent = "N" + post.id;

    var date = new Date(post.date);
    var dateEl = document.createElement("p");
    dateEl.className = "bio";
    dateEl.textContent = " || " + date;

    var textEl = document.createElement("p");
    textEl.textContent = post.text;

    div.appendChild(idEl);
    div.appendChild(dateEl);
    div.appendChild(textEl);
    div.onclick=function(){
        seePost(post)
    }
    if (post.image != null) {
        var image = document.createElement("img");
        image.src = post.image;
        div.appendChild(image);
    }

    document.body.appendChild(div);
}

async function seePost(post){
    var newWindow=window.open("http://localhost:8989/anon-book/post.html", windowname="N"+post.id);
    newWindow.onload = function(){
        newWindow.postMessage(post,"*");
    }
}

function addPostWindow() {
    var newWindow = window.open(href = "http://localhost:8989/anon-book/addPost.html", windowname = "asdfsd");
}