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
        selectedStudentId = 0;
        loadAddStudents();
    }


    xml.open("POST", "http://localhost:9999/students", true);
    xml.setRequestHeader('Content-type', 'application/json');
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


    xml.open("GET", "http://localhost:9999/students", true);
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

        studentsTbodyHtml += "<td><button class='btn btn-danger' onClick='onStudentsDelete(" + student.id + ")'>Sil</button> ";
        studentsTbodyHtml += "<button class='btn btn-primary' onClick='onStudentsUpdate(" + student.id + ")'>Redakte</button></td></tr>";

    }

    studentsTbody.innerHTML = studentsTbodyHtml;
}


function onStudentsDelete(studentId) {
    if (confirm("silməyə əminsiz?")) {
        let xml = new XMLHttpRequest();


        xml.onload = function () {
            loadAddStudents();
        }


        xml.open("DELETE", "http://localhost:9999/students/" + studentId, true);
        xml.send();
    }

}

function onStudentsUpdate(studentId){
    selectedStudentId=studentId;
    let xml = new XMLHttpRequest();


        xml.onload = function () {
            let response = this.responseText;
            let students = JSON.parse(response);
            document.getElementById('student-name').value=students.name;
            document.getElementById('student-surname').value=students.surname;
        }


        xml.open("GET", "http://localhost:9999/students/" + studentId, true);
        xml.send();
}

