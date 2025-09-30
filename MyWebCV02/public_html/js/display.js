//$(function(){
//    alert("ready");
//});
function view(viewName){
    $('main>section').hide();
    $('#'+viewName).show();
}
function showInfo(){
    view('info-box');
}
function showLoginForm(){
    view('login-box');
    $('#loginForm').trigger('reset');
}