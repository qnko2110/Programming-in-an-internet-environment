/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $(document).on({
        ajaxStart: function () {
            $("#loading-box").show();
        },
        ajaxStop: function () {
            $("#loading-box").hide();
        }
    });
    showLoginForm();
});

function login() {
    sendRequest();
    return false; 
}

