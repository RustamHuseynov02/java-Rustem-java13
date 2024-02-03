function onSaveSeller(event){
    event.preventDefault()

    let sellerName = document.getElementById("seller-name").value;
    let sellerSurname = document.getElementById("seller-surname").value;
    let sellerUsername = document.getElementById("seller-username").value;
    let sellerPassword = document.getElementById("seller-password").value;
    let sellerEmail = document.getElementById("seller-email").value;

    let sellerObject = {};
    sellerObject.name = sellerName;
    sellerObject.surname = sellerSurname;
    sellerObject.username = sellerUsername;
    sellerObject.password = sellerPassword;
    sellerObject.email = sellerEmail;

    let request = JSON.stringify(sellerObject)


    let xml = new XMLHttpRequest();
    xml.open('POST','http://localhost:9056/users/seller',true)
    xml.setRequestHeader('Content-type','application/json')
    xml.send(request)
}