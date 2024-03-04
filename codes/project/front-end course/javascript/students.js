let API_URL = "http://localhost:9999";

let username = localStorage.getItem('username');
let password = localStorage.getItem('password');
let token = "Basic " + window.btoa(username + ":" + password);
let gridOptionsGlobal;

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
    xml.setRequestHeader("Authorization", token)
    xml.send(requset);
}




function loadAddStudents() {
    let xml = new XMLHttpRequest();


    xml.onload = function () {
        let response = this.responseText;
        let students = JSON.parse(response);
        fillStudentsTable(students);
    }


    xml.open("GET", API_URL + "/students", true);
    xml.setRequestHeader("Authorization", token)
    xml.send();
}

function fillStudentsTable(students) {
    gridOptionsGlobal.api.setRowData(students);
}


function onStudentsDelete(studentId) {
    if (confirm("silməyə əminsiz?")) {
        let xml = new XMLHttpRequest();


        xml.onload = function () {
            loadAddStudents();
        }


        xml.open("DELETE", API_URL + "/students/" + studentId, true);
        xml.setRequestHeader("Authorization", token)
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
    xml.setRequestHeader("Authorization", token)
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
    xml.setRequestHeader("Authorization", token)
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
    xml.setRequestHeader("Authorization", token)
    xml.send(requset);
}

function onShowStudentNotes(studentId) {
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


    xml.open("GET", API_URL + "/student-note/" + studentId, true);
    xml.setRequestHeader("Authorization", token)
    xml.send();
}

function prepareAgGridTable() {
    // Column Definitions: Defines the columns to be displayed.
    const columnDefs = [
        { field: "id" ,headerName:"Kod"},
        { field: "name",headerName:"Ad"},
        { field: "surname",headerName:"Soyad"}
    ];
    // Grid Options: Contains all of the grid configurations
    const gridOptions = {
        columnDefs: columnDefs,
        rowData: [],
        defaultColDef:{sortable:true,filter:true},
        animateRows:true,
        floatingFilter:true,
        pagination:true,
        powSelection:'multiple'
    };
    gridOptionsGlobal=gridOptions;
    // Your Javascript code to create the grid
    document.addEventListener('DOMContentLoaded', () => {
        const myGridElement = document.querySelector('#myStudents');
        new agGrid.Grid(myGridElement, gridOptions);
    })
}

prepareAgGridTable()
loadAddStudents();