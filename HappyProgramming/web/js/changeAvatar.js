/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function changeImage() {
    var path = document.getElementById("avatarURL").value;
    document.getElementById("image").src = "images//" + path.replace(/^.*\\/, "");
}
