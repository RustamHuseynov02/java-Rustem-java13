function onSaveAdmin(event){
   event.preventDefault();

       let adminName = document.getElementById('admin-name').value;
       let adminSurname = document.getElementById('admin-surname').value;
       let adminUsername = document.getElementById('admin-username').value;
       let adminPassword = document.getElementById('admin-password').value;
       let adminEmail = document.getElementById('admin-email').value;

       let adminObject = {};

       adminObject.name = adminName;
       adminObject.surname = adminSurname;
       adminObject.username = adminUsername;
       adminObject.password = adminPassword;
       adminObject.email = adminEmail;

       let request = JSON.stringify(adminObject);

       let xml = new XMLHttpRequest();

       xml.open('POST','http://localhost:9056/users/admin',true);
       xml.setRequestHeader('Content-type','application/json');
       xml.send(request)
}