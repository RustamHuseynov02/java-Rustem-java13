function onSaveTeacher(event){
 event.preventDefault()

 // inputdan melumatlari goturur
 let teacherName = document.getElementById('teacher-name').value;
 let teacherSurname = document.getElementById('teacher-surname').value;
 let teacherUsername = document.getElementById('teacher-username').value;
 let teacherPassword = document.getElementById('teacher-password').value;
 let teacherEmail = document.getElementById('teacher-email').value;

 let teacherObject = {}
// goturulen melumatlari objecte kocurur
 teacherObject.name = teacherName;
 teacherObject.surname = teacherSurname;
 teacherObject.username = teacherUsername;
 teacherObject.password = teacherPassword;
 teacherObject.email = teacherEmail;

 //obyekti json halina salir
 let request = JSON.stringify(teacherObject)


 //jsonu apiye gonderir javadiki postApiye

 let xml=new XMLHttpRequest();
 xml.open('POST','http://localhost:9056/users/teacher',true);
 xml.setRequestHeader('Content-type','application/json');
 xml.send(request);

}