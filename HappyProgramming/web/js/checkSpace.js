/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function checkSpace() {
    var string = document.getElementById("content").value;
    var text = document.getElementById("text-space");
    var text1 = document.getElementById("text-space-1");
    if (!string.trim()) {
        text.style.display = "block";
        text1.style.display = "none";
        document.getElementById("button").disabled = true;
    } else {
        text.style.display = "none";
        text1.style.display = "block";
        document.getElementById("button").disabled = false;
    }
}
