/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function myFunction() {
    var inputElems = document.getElementsByTagName("input");
    var count = 0;
    var text = document.getElementById("text");
    for (var i=0; i<inputElems.length; i++) {
    if (inputElems[i].type === "checkbox" && inputElems[i].checked === true){
        count++;
    }}
    if (count===0 || count>3) {
        text.style.display = "block";
        document.getElementById("button").disabled = true;
    } else {
        text.style.display = "none";
        document.getElementById("button").disabled = false;
    }
}
