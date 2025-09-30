$(function () {
    $('.DataTime').click(function () {
        var dateTime = getDateTime();
        //alert(dateTime);
        $('.DataTime').text(dateTime);
    }).click();
});
function getDateTime() {
    var result = '';
    $.ajax({
        type: 'GET',
        url: 'http://kst.tugab.bg/pis/gettimejson.php',
        async: false,
        cache: false,
        contentType: 'application/json',
        success: function (data) {
            result = data.value;
        },
        error: function (data) {
            result = "Комуникационна грешка";
        }
    });
    return result;
}
