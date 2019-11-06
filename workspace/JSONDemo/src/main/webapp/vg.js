function loadVG(vg){
    document.getElementById("vgID").innerHTML=vg.vgID;
    document.getElementById("vgName").innerHTML=vg.vgName;
    document.getElementById("vgMetaScore").innerHTML=vg.vgMetaScore;
}

function getVG(){
    console.log("inside getVg");
    let vgID =document.getElementById("vgIDInput").value;
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log("inside ORSC " + xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var vg=JSON.parse(xhr.responseText);
            loadVG(vg);
        }
    }
    xhr.open("GET","http://localhost:8080/JSONDemo/vg?vgid="+vgID, true);
    xhr.send();
}

function postVG(){
    console.log("in postVG");
    var xhr=new XMLHttpRequest();
    xhr.onreadystatechange= function(){
        console.log("inside ORSC " + xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);

    }
}
xhr.open("POST","http://localhost:8080/JSONDemo/vg", true);
var payload=jsonBuilder();
xhr.send(payload);
}
function jasonBuilder(){
    var elements=document.getElementById("vgForm").elements;
    var obj={};
    for(var i = 0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}
window.onload=function(){
    console.log("in onLoad");
    document.getElementById("vgSubmitGet").addEventListener("click", getVG , false);
    document.getElementById("vgFormSubmit").addEventListener("click", postVG ,false);
}