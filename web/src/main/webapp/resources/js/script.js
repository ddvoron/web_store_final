$(document).ready(function () {
    $('li.cl a').click(function (e) {
        var dropDown = $(this).parent().next();
        $('.dropdown').not(dropDown).slideUp(500);
        dropDown.slideToggle(500);
        e.preventDefault();
    })
});
