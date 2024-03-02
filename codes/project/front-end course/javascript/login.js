let API_URL = "http://localhost:9999";
function onLogin(event){  
    event.preventDefault()

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    let xml = new XMLHttpRequest();

    xml.onload = function(){
        if (this.status==200) {
            localStorage.setItem('username',username)
            localStorage.setItem('password',password)
            window.location.href="students.html"
        }
        else{
            alert("yanlis")
        }
    }
    xml.open("GET",API_URL+"/users/login",true);
    xml.setRequestHeader("Authorization","Basic "+window.btoa(username+":"+password));
    xml.send();
}

function onSignUp(){
    window.location.href='signup.html'
}