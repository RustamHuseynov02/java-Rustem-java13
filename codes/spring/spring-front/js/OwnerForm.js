function onSaveOwner(event){
    event.preventDefault()

    let ownerName = document.getElementById("owner-name").value;
    let ownerSurname = document.getElementById("owner-surname").value;
    let ownerUsername = document.getElementById("owner-username").value;
    let ownerPassword = document.getElementById("owner-password").value;
    let ownerEmail = document.getElementById("owner-email").value;

    let ownerObject = {};
    ownerObject.name = ownerName;
    ownerObject.surname = ownerSurname;
    ownerObject.username = ownerUsername;
    ownerObject.password = ownerPassword;
    ownerObject.email = ownerEmail;

    let request = JSON.stringify(ownerObject)


    let xml = new XMLHttpRequest();
    xml.open('POST','http://localhost:9056/users/owner',true)
    xml.setRequestHeader('Content-type','application/json')
    xml.send(request)
}