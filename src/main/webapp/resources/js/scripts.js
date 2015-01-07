/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var handleEvent;

$(document).ready(function () {
    
    
  //$('')

  handleEvent =  function (event) {
        console.log(event)
        if (event.status === 'begin') {
            //$(event.source).after("updating...")
        }
        
        if (event.status === 'success'){
           $('#persistform:title').focus();
           console.log('success');
           $('#list table tr:first').hide();
           $('#list table tr:first').fadeIn(1000);
        }
        
        if(event.status === 'complete'){
            console.log('complete');
        }
        
     
       
    }
    
    addTodo = function (event){
         if (event.status === 'success'){
          var todo = $('#list table tr:first');
          todo.hide();
          todo.fadeIn(1000);
        }
    }
});