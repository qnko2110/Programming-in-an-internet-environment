/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    showLoginForm();
});

function login() {
    var username = $('input[name=username]').val();
    var password = $('input[name=password]').val();
    alert(username + ": " + password);
    
    showInfo();
    return false; 
}

