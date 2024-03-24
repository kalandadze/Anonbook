window.addEventListener('message', function (post) {
    setup(post.data);
})

async function setup(post) {
    var div = document.getElementById("post");

    var idEl = document.getElementById("post_id");
    idEl.textContent = "N" + post.id;

    var date = new Date(post.date);
    var dateEl = document.getElementById("date");
    dateEl.textContent = " || " + date;

    var textEl = document.getElementById("text");
    textEl.textContent = post.text;

    if (post.image != null) {
        var image = document.createElement("img");
        image.src = post.image;
        div.appendChild(image);
    }
    addComments(post.id)
}
async function addComments(postId) {
    var url = "http://localhost:8989/anon-book/comment?post_id="+postId;
    console.log(url);
    var response = await fetch(url, { method: "GET" });
    const comments=await response.json();
    console.log(comments);
    for (var i = 0; i < comments.length; i++) {
        addComment(comments[i].comment);
    }
}
function addComment(comment){
    var ul=document.getElementById("comments");
    var li=document.createElement("li");
    li.textContent=comment;
    ul.appendChild(li);
}

async function add() {
    var id = document.getElementById("post_id").textContent;
    var comment = document.getElementById("prod_text").value;
    var url = "http://localhost:8989/anon-book/comment?text=" + comment + "&post_id=" + id;
    var response = await fetch(url, { method: "POST" })
    addComment(comment);
}