$(function () {
    var n = 4;
    for (var i = 1; i <= n; i++) {
        var image = getImage(i);
        $('#picture').append(image);
    }
});
function getImage(id) {
    var url = `images/picture-${id}.jpg`;
    var image = $('<img/>');
    image.attr('src', url);
    return image;
}









