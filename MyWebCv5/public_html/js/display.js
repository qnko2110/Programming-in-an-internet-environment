//"images/DefaultImage.jpg" alt="DefaultImage"
function view(viewName) {
    $('main > section').hide();
    $('#' + viewName).show();
}

function showLoginForm() {
    view('login-box');
    $('#loginForm').trigger('reset');
}
function showInfo(picture, info) {
    
    $('#picture').attr('src', picture);
    var infoBox = $('#info-text');
    infoBox.html(info);
    view('info-box');
}


function showError(errorMsg, time) {
    var errorBox = $('#error-box');
    errorBox.text(errorMsg);
    view('error-box');
    setTimeout(function () {
        $('#error-box').fadeOut();
        showLoginForm();
    }, time * 1000);
}


