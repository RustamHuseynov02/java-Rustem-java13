let API_URL = "http://localhost:9999";

let username = localStorage.getItem('username');
let password = localStorage.getItem('password');
let token = "Basic " + window.btoa(username+":"+password);

let selectedStudentId = 0;

function onSaveStudent(event) {
    event.preventDefault();

    let studentName = document.getElementById('student-name').value;
    let studentSurname = document.getElementById('student-surname').value;

    let studentObject = {};
    studentObject.id = selectedStudentId;
    studentObject.name = studentName;
    studentObject.surname = studentSurname;

    let requset = JSON.stringify(studentObject);




    let xml = new XMLHttpRequest();


    xml.onload = function () {
        if (this.status == 400) {
            let nameError = "";
            let surnameError = "";
            let errorObject = JSON.parse(this.responseText);
            errorObject.validations.forEach(error => {
                if (error.field == 'name') {
                    nameError += error.message + "<br>"
                }
                if (error.field == 'surname') {
                    surnameError += error.message + "<br>"
                }
            });
            document.getElementById('name-error').innerHTML = nameError;
            document.getElementById('surname-error').innerHTML = surnameError;
        } else {
            clearErrorMessage();
            selectedStudentId = 0;
            loadAddStudents();
        }

    }


    xml.open("POST", API_URL + "/students", true);
    xml.setRequestHeader('Content-type', 'application/json');
    xml.setRequestHeader("Authorization",token)
    xml.send(requset);
}

loadAddStudents();


function loadAddStudents() {
    let xml = new XMLHttpRequest();


    xml.onload = function () {
        let response = this.responseText;
        let students = JSON.parse(response);
        fillStudentsTable(students);
    }


    xml.open("GET", API_URL + "/students", true);
    xml.setRequestHeader("Authorization",token)
    xml.send();
}

function fillStudentsTable(students) {

    let studentsTbody = document.getElementById('students-tbody');

    let studentsTbodyHtml = ""

    for (let i = 0; i < students.length; i++) {
        let student = students[i];
        studentsTbodyHtml += "<tr><td>" + student.id + "</td>";
        studentsTbodyHtml += "<td>" + student.name + "</td>";
        studentsTbodyHtml += "<td>" + student.surname + "</td>";

        studentsTbodyHtml += "<td><button class='btn btn-danger' onClick='onStudentsDelete(" +
            student.id + ")'>Sil</button> ";
        studentsTbodyHtml += "<button class='btn btn-primary' onClick='onStudentsUpdate(" +
            student.id + ")'>Redakte</button> ";

            studentsTbodyHtml += "<button class='btn btn-warning' onClick='onShowStudentNotes(" +
            student.id + ")' type='button' data-toggle='modal' data-target='#noteListModal'>Qeydlər</button> ";

        studentsTbodyHtml += "<button class='btn btn-secondary' onClick='onStudentsNote ("
            + student.id + ")' type='button' data-toggle='modal' data-target='#noteModal'"
            +">Qeyd Yaz</button></td></tr>";

    }

    studentsTbody.innerHTML = studentsTbodyHtml;
    let table = new DataTable('#students-table');
}


function onStudentsDelete(studentId) {
    if (confirm("silməyə əminsiz?")) {
        let xml = new XMLHttpRequest();


        xml.onload = function () {
            loadAddStudents();
        }


        xml.open("DELETE", API_URL + "/students/" + studentId, true);
        xml.setRequestHeader("Authorization",token)
        xml.send();
    }

}

function onStudentsUpdate(studentId) {
    selectedStudentId = studentId;
    let xml = new XMLHttpRequest();


    xml.onload = function () {
        let response = this.responseText;
        let students = JSON.parse(response);
        document.getElementById('student-name').value = students.name;
        document.getElementById('student-surname').value = students.surname;
    }


    xml.open("GET", API_URL + "/students/" + studentId, true);
    xml.setRequestHeader("Authorization",token)
    xml.send();
}

function clearErrorMessage() {
    document.getElementById('name-error').innerHTML = "";
    document.getElementById('surname-error').innerHTML = "";
}


function onStudentsNote(studentId) {
    selectedStudentId = studentId;
    let xml = new XMLHttpRequest();


    xml.onload = function () {
        let response = this.responseText;
        let students = JSON.parse(response);
        document.getElementById('student-name').value = students.name;
        document.getElementById('student-surname').value = students.surname;
    }


    xml.open("GET", API_URL + "/students/" + studentId, true);
    xml.setRequestHeader("Authorization",token)
    xml.send();
}


function onSaveStudentNote(event) {
    event.preventDefault();

    let studentNote = document.getElementById('student-note').value;

    let studentNoteObject = {};
    studentNoteObject.note = studentNote;
    studentNoteObject.studentId = selectedStudentId;
    
    let requset = JSON.stringify(studentNoteObject)
    let xml = new XMLHttpRequest();
    xml.onload = function () {
        if (this.status == 400) {
            alert("not qeyd edilmədi")
        } else {
            alert("not qeyd edildi")
        }
    }
    xml.open("POST", API_URL + "/student-note", true);
    xml.setRequestHeader('Content-type', 'application/json');
    xml.setRequestHeader("Authorization",token)
    xml.send(requset);
}

function onShowStudentNotes(studentId){
loadAddStudentNotes(studentId)
}

function fillStudentNotesTable(notes) {

    let notesTbody = document.getElementById('notes-tbody');

    let notesTbodyHtml = ""

    for (let i = 0; i < notes.length; i++) {
        let note = notes[i];
        notesTbodyHtml += "<tr><td>" + note.id + "</td>";
        notesTbodyHtml += "<td>" + note.note + "</td></tr>";


        

    }

    notesTbody.innerHTML = notesTbodyHtml;
}

function loadAddStudentNotes(studentId) {
    let xml = new XMLHttpRequest();


    xml.onload = function () {
        let response = this.responseText;
        let notes = JSON.parse(response);
        fillStudentNotesTable(notes);
    }


    xml.open("GET", API_URL + "/student-note/"+studentId, true);
    xml.setRequestHeader("Authorization",token)
    xml.send();
}