/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('button[type="submit"]').click(function() {
      
      var inputs = document.getElementsByClassName("input-white");
      
      for (var i=0, item; i < inputs.length; i++) {
          
          item = inputs[i];
          
          if(item.getAttribute("name")==="sex" || item.getAttribute("name")==="dob"  )
             continue;
         
          var pattern = new RegExp(item.getAttribute("pattern"));
          
          var title = item.getAttribute("title");
          
          //alert(pattern+" "+title );
          //alert(item.value);
          //alert(item.value+" "+pattern.test(item.value));
          
          //alert(item.value+" "+item.parentElement.children.length);
          
          if (pattern.test(item.value)===false) {
              
              var ele = item.parentElement.children;
              
              ele[ele.length-1].innerHTML = title;
              
              //return false;
          } else {
              var ele = item.parentElement.children;
              
              ele[ele.length-1].innerHTML = "";
          }
                         
      }
      
      checked = $("input[type=checkbox]:checked").length;

      if(checked <= 0) {
          document.getElementById("checkboxtitle").innerHTML="You must choose at least 1";
        return false;
      } else if (checked > 3) {
          document.getElementById("checkboxtitle").innerHTML="You cant choose more than 3";
          return false;
      } else {
          
      };
      
 
    });
});
