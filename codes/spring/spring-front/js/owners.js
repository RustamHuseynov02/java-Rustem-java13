function loadOwners(){

    let xml = new XMLHttpRequest();

    xml.onload=function(){
        let m = JSON.parse(this.responseText)
        m.list.forEach(e => {
            document.getElementById("owners").innerHTML+="<tr><td>"+e.id+"</td><td>"+e.name+"</td></tr>";
        });
    }

    xml.open('GET','http://localhost:9056/owners',true)

    xml.send();
}
loadOwners();