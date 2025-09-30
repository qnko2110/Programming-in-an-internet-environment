/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// USERNAME: ofterkadeamerephiperelyb
// PASSWORD: 9325a8e2de53036a717620951b51a0569232401c 

var PORT = 443;
var TIMEOUT = 5000;
var PROTOCOL = 'https://';
var SERVER_NAME =
'024b178f-c9b8-4bc0-ae0e-67b8cbc7d5ec-bluemix.cloudantnosqldb.appdomain.cloud';
var DATABASE = 'webservice';
var DOCUMENT = '123456';
var newline = '<br/>';

       
// -----------------------------------------------------------------------------
function sendRequest() {

    var username = $('input[name=username]').val();
    var password = $('input[name=password]').val();
    var hash = btoa(username + ':' + password);

    getInfo(hash)
        .then(
             
            function (result) {
                //alert(JSON.stringify(result));
                var name=result.name;
                var specialty=result.specialty;
                var specialtyfullname=result.specialtyfullname;
                var course=result.course;
                var about=result.aboutme;
                var imageObject=result._attachments['picture.png'];
                var image = imageObject.data;
                var picture = 'data:image/png;base64,' + image;
                var info=`${name.firstname} ${name.lastname}<br/>Специалност "${specialtyfullname}"`;
                showInfo(picture,info);
        }).catch(                
            function (error) {
                //alert(JSON.stringify(error));
               var status=error.status;
               if(status===0){
                   showError('Няма връзка с базата данни',3);
               }
               else if (status===401){
                   $('input[name=username]').val('');
                   $('input[name=password]').val('');
                   showError('Грешно име на потребител или парола',3);
               }
            }
        );
    return false;
}
// -----------------------------------------------------------------------------
function getInfo(hash) {
    var url = PROTOCOL + SERVER_NAME + ':' + PORT + '/' + DATABASE + '/' +
            DOCUMENT + '?attachments=true';
    var promise = new Promise(function (resolve, reject) {
        $.ajax({
            type: 'GET',
            url: url,
            async: true,
            cache: false,
            contentType: 'application/json',
            timeout: TIMEOUT,
            beforeSend: function (req) {
                req.setRequestHeader('Accept', 'application/json');
                req.setRequestHeader('Authorization', 'Basic ' + hash);
            },
            success: function (data) {
                resolve(data);
            },
            error: function (data) {
                reject(data);
            }
        });
    });
    return promise;
}
// -----------------------------------------------------------------------------